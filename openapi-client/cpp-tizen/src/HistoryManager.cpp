#include <glib-object.h>
#include <json-glib/json-glib.h>

#include "HistoryManager.h"
#include "NetClient.h"
#include "Helpers.h"
#include "Error.h"
#include "RequestInfo.h"

using namespace std;
using namespace Tizen::ArtikCloud;


HistoryManager::HistoryManager()
{

}

HistoryManager::~HistoryManager()
{

}

static gboolean __HistoryManagerresponseHandler(gpointer data)
{
	RequestInfo *request = static_cast<RequestInfo*>(data);
	g_thread_join(request->thread);

	// invoke the callback function
	bool retval = request->processor(*(request->p_chunk), *(request->code), request->errormsg, request->userData, request->handler);

	delete request;
	return FALSE;
}

static gpointer __HistoryManagerthreadFunc(gpointer data)
{
	RequestInfo *request = static_cast<RequestInfo*>(data);

	// handle the request
	NetClient::easycurl(request->host, request->path, request->method, request->queryParams,
	request->mBody, request->headerList, request->p_chunk, request->code, request->errormsg);

	request->thread = g_thread_self();
	g_idle_add(__HistoryManagerresponseHandler, static_cast<gpointer>(request));

	return NULL;
}


static bool getStatsProcessor(MemoryStruct_s p_chunk, long code, char* errormsg, void* userData,
	void(* voidHandler)())
{
	void(* handler)(std::list<GetStats_200_response_inner>, Error, void* )
	= reinterpret_cast<void(*)(std::list<GetStats_200_response_inner>, Error, void* )> (voidHandler);
	
	JsonNode* pJson;
	char * data = p_chunk.memory;

	std::list<GetStats_200_response_inner> out;
	

	if (code >= 200 && code < 300) {
		Error error(code, string("No Error"));



		pJson = json_from_string(data, NULL);
		JsonArray * jsonarray = json_node_get_array (pJson);
		guint length = json_array_get_length (jsonarray);
		for(guint i = 0; i < length; i++){
			JsonNode* myJson = json_array_get_element (jsonarray, i);
			char * singlenodestr = json_to_string(myJson, false);
			GetStats_200_response_inner singlemodel;
			singlemodel.fromJson(singlenodestr);
			out.push_front(singlemodel);
			g_free(static_cast<gpointer>(singlenodestr));
			json_node_free(myJson);
		}
		json_array_unref (jsonarray);
		json_node_free(pJson);


	} else {
		Error error;
		if (errormsg != NULL) {
			error = Error(code, string(errormsg));
		} else if (p_chunk.memory != NULL) {
			error = Error(code, string(p_chunk.memory));
		} else {
			error = Error(code, string("Unknown Error"));
		}
		 handler(out, error, userData);
		return false;
			}
}

static bool getStatsHelper(char * accessToken,
	
	void(* handler)(std::list<GetStats_200_response_inner>, Error, void* )
	, void* userData, bool isAsync)
{

	//TODO: maybe delete headerList after its used to free up space?
	struct curl_slist *headerList = NULL;

	
	string accessHeader = "Authorization: Bearer ";
	accessHeader.append(accessToken);
	headerList = curl_slist_append(headerList, accessHeader.c_str());
	headerList = curl_slist_append(headerList, "Content-Type: application/json");

	map <string, string> queryParams;
	string itemAtq;
	
	string mBody = "";
	JsonNode* node;
	JsonArray* json_array;

	string url("/mail/stats");
	int pos;


	//TODO: free memory of errormsg, memorystruct
	MemoryStruct_s* p_chunk = new MemoryStruct_s();
	long code;
	char* errormsg = NULL;
	string myhttpmethod("GET");

	if(strcmp("PUT", "GET") == 0){
		if(strcmp("", mBody.c_str()) == 0){
			mBody.append("{}");
		}
	}

	if(!isAsync){
		NetClient::easycurl(HistoryManager::getBasePath(), url, myhttpmethod, queryParams,
			mBody, headerList, p_chunk, &code, errormsg);
		bool retval = getStatsProcessor(*p_chunk, code, errormsg, userData,reinterpret_cast<void(*)()>(handler));

		curl_slist_free_all(headerList);
		if (p_chunk) {
			if(p_chunk->memory) {
				free(p_chunk->memory);
			}
			delete (p_chunk);
		}
		if (errormsg) {
			free(errormsg);
		}
		return retval;
	} else{
		GThread *thread = NULL;
		RequestInfo *requestInfo = NULL;

		requestInfo = new(nothrow) RequestInfo (HistoryManager::getBasePath(), url, myhttpmethod, queryParams,
			mBody, headerList, p_chunk, &code, errormsg, userData, reinterpret_cast<void(*)()>(handler), getStatsProcessor);;
		if(requestInfo == NULL)
			return false;

		thread = g_thread_new(NULL, __HistoryManagerthreadFunc, static_cast<gpointer>(requestInfo));
		return true;
	}
}




bool HistoryManager::getStatsAsync(char * accessToken,
	
	void(* handler)(std::list<GetStats_200_response_inner>, Error, void* )
	, void* userData)
{
	return getStatsHelper(accessToken,
	
	handler, userData, true);
}

bool HistoryManager::getStatsSync(char * accessToken,
	
	void(* handler)(std::list<GetStats_200_response_inner>, Error, void* )
	, void* userData)
{
	return getStatsHelper(accessToken,
	
	handler, userData, false);
}

static bool viewMailLogProcessor(MemoryStruct_s p_chunk, long code, char* errormsg, void* userData,
	void(* voidHandler)())
{
	void(* handler)(MailLog, Error, void* )
	= reinterpret_cast<void(*)(MailLog, Error, void* )> (voidHandler);
	
	JsonNode* pJson;
	char * data = p_chunk.memory;

	
	MailLog out;

	if (code >= 200 && code < 300) {
		Error error(code, string("No Error"));




		if (isprimitive("MailLog")) {
			pJson = json_from_string(data, NULL);
			jsonToValue(&out, pJson, "MailLog", "MailLog");
			json_node_free(pJson);

			if ("MailLog" == "std::string") {
				string* val = (std::string*)(&out);
				if (val->empty() && p_chunk.size>4) {
					*val = string(p_chunk.memory, p_chunk.size);
				}
			}
		} else {
			
			out.fromJson(data);
			char *jsonStr =  out.toJson();
			printf("\n%s\n", jsonStr);
			g_free(static_cast<gpointer>(jsonStr));
			
		}
		handler(out, error, userData);
		return true;
		//TODO: handle case where json parsing has an error

	} else {
		Error error;
		if (errormsg != NULL) {
			error = Error(code, string(errormsg));
		} else if (p_chunk.memory != NULL) {
			error = Error(code, string(p_chunk.memory));
		} else {
			error = Error(code, string("Unknown Error"));
		}
		 handler(out, error, userData);
		return false;
			}
}

static bool viewMailLogHelper(char * accessToken,
	long long id, std::string origin, std::string mx, std::string from, std::string to, std::string subject, std::string mailid, int skip, int limit, long long startDate, long long endDate, std::string replyto, std::string headerfrom, 
	void(* handler)(MailLog, Error, void* )
	, void* userData, bool isAsync)
{

	//TODO: maybe delete headerList after its used to free up space?
	struct curl_slist *headerList = NULL;

	
	string accessHeader = "Authorization: Bearer ";
	accessHeader.append(accessToken);
	headerList = curl_slist_append(headerList, accessHeader.c_str());
	headerList = curl_slist_append(headerList, "Content-Type: application/json");

	map <string, string> queryParams;
	string itemAtq;
	

	itemAtq = stringify(&id, "long long");
	queryParams.insert(pair<string, string>("id", itemAtq));
	if( itemAtq.empty()==true){
		queryParams.erase("id");
	}


	itemAtq = stringify(&origin, "std::string");
	queryParams.insert(pair<string, string>("origin", itemAtq));
	if( itemAtq.empty()==true){
		queryParams.erase("origin");
	}


	itemAtq = stringify(&mx, "std::string");
	queryParams.insert(pair<string, string>("mx", itemAtq));
	if( itemAtq.empty()==true){
		queryParams.erase("mx");
	}


	itemAtq = stringify(&from, "std::string");
	queryParams.insert(pair<string, string>("from", itemAtq));
	if( itemAtq.empty()==true){
		queryParams.erase("from");
	}


	itemAtq = stringify(&to, "std::string");
	queryParams.insert(pair<string, string>("to", itemAtq));
	if( itemAtq.empty()==true){
		queryParams.erase("to");
	}


	itemAtq = stringify(&subject, "std::string");
	queryParams.insert(pair<string, string>("subject", itemAtq));
	if( itemAtq.empty()==true){
		queryParams.erase("subject");
	}


	itemAtq = stringify(&mailid, "std::string");
	queryParams.insert(pair<string, string>("mailid", itemAtq));
	if( itemAtq.empty()==true){
		queryParams.erase("mailid");
	}


	itemAtq = stringify(&skip, "int");
	queryParams.insert(pair<string, string>("skip", itemAtq));
	if( itemAtq.empty()==true){
		queryParams.erase("skip");
	}


	itemAtq = stringify(&limit, "int");
	queryParams.insert(pair<string, string>("limit", itemAtq));
	if( itemAtq.empty()==true){
		queryParams.erase("limit");
	}


	itemAtq = stringify(&startDate, "long long");
	queryParams.insert(pair<string, string>("startDate", itemAtq));
	if( itemAtq.empty()==true){
		queryParams.erase("startDate");
	}


	itemAtq = stringify(&endDate, "long long");
	queryParams.insert(pair<string, string>("endDate", itemAtq));
	if( itemAtq.empty()==true){
		queryParams.erase("endDate");
	}


	itemAtq = stringify(&replyto, "std::string");
	queryParams.insert(pair<string, string>("replyto", itemAtq));
	if( itemAtq.empty()==true){
		queryParams.erase("replyto");
	}


	itemAtq = stringify(&headerfrom, "std::string");
	queryParams.insert(pair<string, string>("headerfrom", itemAtq));
	if( itemAtq.empty()==true){
		queryParams.erase("headerfrom");
	}

	string mBody = "";
	JsonNode* node;
	JsonArray* json_array;

	string url("/mail/log");
	int pos;


	//TODO: free memory of errormsg, memorystruct
	MemoryStruct_s* p_chunk = new MemoryStruct_s();
	long code;
	char* errormsg = NULL;
	string myhttpmethod("GET");

	if(strcmp("PUT", "GET") == 0){
		if(strcmp("", mBody.c_str()) == 0){
			mBody.append("{}");
		}
	}

	if(!isAsync){
		NetClient::easycurl(HistoryManager::getBasePath(), url, myhttpmethod, queryParams,
			mBody, headerList, p_chunk, &code, errormsg);
		bool retval = viewMailLogProcessor(*p_chunk, code, errormsg, userData,reinterpret_cast<void(*)()>(handler));

		curl_slist_free_all(headerList);
		if (p_chunk) {
			if(p_chunk->memory) {
				free(p_chunk->memory);
			}
			delete (p_chunk);
		}
		if (errormsg) {
			free(errormsg);
		}
		return retval;
	} else{
		GThread *thread = NULL;
		RequestInfo *requestInfo = NULL;

		requestInfo = new(nothrow) RequestInfo (HistoryManager::getBasePath(), url, myhttpmethod, queryParams,
			mBody, headerList, p_chunk, &code, errormsg, userData, reinterpret_cast<void(*)()>(handler), viewMailLogProcessor);;
		if(requestInfo == NULL)
			return false;

		thread = g_thread_new(NULL, __HistoryManagerthreadFunc, static_cast<gpointer>(requestInfo));
		return true;
	}
}




bool HistoryManager::viewMailLogAsync(char * accessToken,
	long long id, std::string origin, std::string mx, std::string from, std::string to, std::string subject, std::string mailid, int skip, int limit, long long startDate, long long endDate, std::string replyto, std::string headerfrom, 
	void(* handler)(MailLog, Error, void* )
	, void* userData)
{
	return viewMailLogHelper(accessToken,
	id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate, replyto, headerfrom, 
	handler, userData, true);
}

bool HistoryManager::viewMailLogSync(char * accessToken,
	long long id, std::string origin, std::string mx, std::string from, std::string to, std::string subject, std::string mailid, int skip, int limit, long long startDate, long long endDate, std::string replyto, std::string headerfrom, 
	void(* handler)(MailLog, Error, void* )
	, void* userData)
{
	return viewMailLogHelper(accessToken,
	id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate, replyto, headerfrom, 
	handler, userData, false);
}

