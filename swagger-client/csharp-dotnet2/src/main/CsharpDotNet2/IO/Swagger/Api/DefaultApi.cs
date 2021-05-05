using System;
using System.Collections.Generic;
using RestSharp;
using IO.Swagger.Client;
using IO.Swagger.Model;

namespace IO.Swagger.Api
{
    /// <summary>
    /// Represents a collection of functions to interact with the API endpoints
    /// </summary>
    public interface IDefaultApi
    {
        /// <summary>
        /// displays a list of mail service orders 
        /// </summary>
        /// <param name="id">The ID of your mail order this will be sent through.</param>
        /// <returns>MailOrders</returns>
        MailOrders GetMailOrders (long? id);
        /// <summary>
        /// Checks if the server is running 
        /// </summary>
        /// <returns></returns>
        void PingServer ();
        /// <summary>
        /// places a mail order Adds an item to the system
        /// </summary>
        /// <param name="body">Inventory item to add</param>
        /// <returns></returns>
        void PlaceMailOrder (MailOrder body);
        /// <summary>
        /// Sends an Email with Advanced Options Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
        /// </summary>
        /// <param name="body"></param>
        /// <returns>GenericResponse</returns>
        GenericResponse SendAdvMailById (SendMail body);
        /// <summary>
        /// Sends an Email Sends An email through one of your mail orders.
        /// </summary>
        /// <param name="body"></param>
        /// <returns>GenericResponse</returns>
        GenericResponse SendMailById (SendMail body);
        /// <summary>
        /// Sends an Email Sends An email through one of your mail orders.
        /// </summary>
        /// <param name="subject"></param>
        /// <param name="body"></param>
        /// <param name="from"></param>
        /// <param name="to"></param>
        /// <param name="id"></param>
        /// <param name="replyto"></param>
        /// <param name="cc"></param>
        /// <param name="bcc"></param>
        /// <param name="attachments"></param>
        /// <returns>GenericResponse</returns>
        GenericResponse SendMailById (string subject, string body, List<SendMailFrom> from, List<MailContact> to, long? id, List<MailContact> replyto, List<MailContact> cc, List<MailContact> bcc, List<MailAttachment> attachments);
        /// <summary>
        /// validatess order details before placing an order 
        /// </summary>
        /// <returns></returns>
        void ValidateMailOrder ();
        /// <summary>
        /// displays the mail log By passing in the appropriate options, you can search for available inventory in the system 
        /// </summary>
        /// <param name="id">The ID of your mail order this will be sent through.</param>
        /// <param name="searchString">pass an optional search string for looking up inventory</param>
        /// <param name="skip">number of records to skip for pagination</param>
        /// <param name="limit">maximum number of records to return</param>
        /// <returns>List&lt;MailLog&gt;</returns>
        List<MailLog> ViewMailLogById (long? id, string searchString, int? skip, int? limit);
    }
  
    /// <summary>
    /// Represents a collection of functions to interact with the API endpoints
    /// </summary>
    public class DefaultApi : IDefaultApi
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="DefaultApi"/> class.
        /// </summary>
        /// <param name="apiClient"> an instance of ApiClient (optional)</param>
        /// <returns></returns>
        public DefaultApi(ApiClient apiClient = null)
        {
            if (apiClient == null) // use the default one in Configuration
                this.ApiClient = Configuration.DefaultApiClient; 
            else
                this.ApiClient = apiClient;
        }
    
        /// <summary>
        /// Initializes a new instance of the <see cref="DefaultApi"/> class.
        /// </summary>
        /// <returns></returns>
        public DefaultApi(String basePath)
        {
            this.ApiClient = new ApiClient(basePath);
        }
    
        /// <summary>
        /// Sets the base path of the API client.
        /// </summary>
        /// <param name="basePath">The base path</param>
        /// <value>The base path</value>
        public void SetBasePath(String basePath)
        {
            this.ApiClient.BasePath = basePath;
        }
    
        /// <summary>
        /// Gets the base path of the API client.
        /// </summary>
        /// <param name="basePath">The base path</param>
        /// <value>The base path</value>
        public String GetBasePath(String basePath)
        {
            return this.ApiClient.BasePath;
        }
    
        /// <summary>
        /// Gets or sets the API client.
        /// </summary>
        /// <value>An instance of the ApiClient</value>
        public ApiClient ApiClient {get; set;}
    
        /// <summary>
        /// displays a list of mail service orders 
        /// </summary>
        /// <param name="id">The ID of your mail order this will be sent through.</param>
        /// <returns>MailOrders</returns>
        public MailOrders GetMailOrders (long? id)
        {
    
            var path = "/mail";
            path = path.Replace("{format}", "json");
                
            var queryParams = new Dictionary<String, String>();
            var headerParams = new Dictionary<String, String>();
            var formParams = new Dictionary<String, String>();
            var fileParams = new Dictionary<String, FileParameter>();
            String postBody = null;
    
             if (id != null) queryParams.Add("id", ApiClient.ParameterToString(id)); // query parameter
                        
            // authentication setting, if any
            String[] authSettings = new String[] { "apiKeyAuth" };
    
            // make the HTTP request
            IRestResponse response = (IRestResponse) ApiClient.CallApi(path, Method.GET, queryParams, postBody, headerParams, formParams, fileParams, authSettings);
    
            if (((int)response.StatusCode) >= 400)
                throw new ApiException ((int)response.StatusCode, "Error calling GetMailOrders: " + response.Content, response.Content);
            else if (((int)response.StatusCode) == 0)
                throw new ApiException ((int)response.StatusCode, "Error calling GetMailOrders: " + response.ErrorMessage, response.ErrorMessage);
    
            return (MailOrders) ApiClient.Deserialize(response.Content, typeof(MailOrders), response.Headers);
        }
    
        /// <summary>
        /// Checks if the server is running 
        /// </summary>
        /// <returns></returns>
        public void PingServer ()
        {
    
            var path = "/ping";
            path = path.Replace("{format}", "json");
                
            var queryParams = new Dictionary<String, String>();
            var headerParams = new Dictionary<String, String>();
            var formParams = new Dictionary<String, String>();
            var fileParams = new Dictionary<String, FileParameter>();
            String postBody = null;
    
                                    
            // authentication setting, if any
            String[] authSettings = new String[] {  };
    
            // make the HTTP request
            IRestResponse response = (IRestResponse) ApiClient.CallApi(path, Method.GET, queryParams, postBody, headerParams, formParams, fileParams, authSettings);
    
            if (((int)response.StatusCode) >= 400)
                throw new ApiException ((int)response.StatusCode, "Error calling PingServer: " + response.Content, response.Content);
            else if (((int)response.StatusCode) == 0)
                throw new ApiException ((int)response.StatusCode, "Error calling PingServer: " + response.ErrorMessage, response.ErrorMessage);
    
            return;
        }
    
        /// <summary>
        /// places a mail order Adds an item to the system
        /// </summary>
        /// <param name="body">Inventory item to add</param>
        /// <returns></returns>
        public void PlaceMailOrder (MailOrder body)
        {
    
            var path = "/mail/order";
            path = path.Replace("{format}", "json");
                
            var queryParams = new Dictionary<String, String>();
            var headerParams = new Dictionary<String, String>();
            var formParams = new Dictionary<String, String>();
            var fileParams = new Dictionary<String, FileParameter>();
            String postBody = null;
    
                                    postBody = ApiClient.Serialize(body); // http body (model) parameter

            // authentication setting, if any
            String[] authSettings = new String[] { "apiKeyAuth" };
    
            // make the HTTP request
            IRestResponse response = (IRestResponse) ApiClient.CallApi(path, Method.POST, queryParams, postBody, headerParams, formParams, fileParams, authSettings);
    
            if (((int)response.StatusCode) >= 400)
                throw new ApiException ((int)response.StatusCode, "Error calling PlaceMailOrder: " + response.Content, response.Content);
            else if (((int)response.StatusCode) == 0)
                throw new ApiException ((int)response.StatusCode, "Error calling PlaceMailOrder: " + response.ErrorMessage, response.ErrorMessage);
    
            return;
        }
    
        /// <summary>
        /// Sends an Email with Advanced Options Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
        /// </summary>
        /// <param name="body"></param>
        /// <returns>GenericResponse</returns>
        public GenericResponse SendAdvMailById (SendMail body)
        {
            // verify the required parameter 'body' is set
            if (body == null) throw new ApiException(400, "Missing required parameter 'body' when calling SendAdvMailById");
    
            var path = "/mail/advsend";
            path = path.Replace("{format}", "json");
                
            var queryParams = new Dictionary<String, String>();
            var headerParams = new Dictionary<String, String>();
            var formParams = new Dictionary<String, String>();
            var fileParams = new Dictionary<String, FileParameter>();
            String postBody = null;
    
                                    postBody = ApiClient.Serialize(body); // http body (model) parameter

            // authentication setting, if any
            String[] authSettings = new String[] { "apiKeyAuth" };
    
            // make the HTTP request
            IRestResponse response = (IRestResponse) ApiClient.CallApi(path, Method.POST, queryParams, postBody, headerParams, formParams, fileParams, authSettings);
    
            if (((int)response.StatusCode) >= 400)
                throw new ApiException ((int)response.StatusCode, "Error calling SendAdvMailById: " + response.Content, response.Content);
            else if (((int)response.StatusCode) == 0)
                throw new ApiException ((int)response.StatusCode, "Error calling SendAdvMailById: " + response.ErrorMessage, response.ErrorMessage);
    
            return (GenericResponse) ApiClient.Deserialize(response.Content, typeof(GenericResponse), response.Headers);
        }
    
        /// <summary>
        /// Sends an Email Sends An email through one of your mail orders.
        /// </summary>
        /// <param name="body"></param>
        /// <returns>GenericResponse</returns>
        public GenericResponse SendMailById (SendMail body)
        {
            // verify the required parameter 'body' is set
            if (body == null) throw new ApiException(400, "Missing required parameter 'body' when calling SendMailById");
    
            var path = "/mail/send";
            path = path.Replace("{format}", "json");
                
            var queryParams = new Dictionary<String, String>();
            var headerParams = new Dictionary<String, String>();
            var formParams = new Dictionary<String, String>();
            var fileParams = new Dictionary<String, FileParameter>();
            String postBody = null;
    
                                    postBody = ApiClient.Serialize(body); // http body (model) parameter

            // authentication setting, if any
            String[] authSettings = new String[] { "apiKeyAuth" };
    
            // make the HTTP request
            IRestResponse response = (IRestResponse) ApiClient.CallApi(path, Method.POST, queryParams, postBody, headerParams, formParams, fileParams, authSettings);
    
            if (((int)response.StatusCode) >= 400)
                throw new ApiException ((int)response.StatusCode, "Error calling SendMailById: " + response.Content, response.Content);
            else if (((int)response.StatusCode) == 0)
                throw new ApiException ((int)response.StatusCode, "Error calling SendMailById: " + response.ErrorMessage, response.ErrorMessage);
    
            return (GenericResponse) ApiClient.Deserialize(response.Content, typeof(GenericResponse), response.Headers);
        }
    
        /// <summary>
        /// Sends an Email Sends An email through one of your mail orders.
        /// </summary>
        /// <param name="subject"></param>
        /// <param name="body"></param>
        /// <param name="from"></param>
        /// <param name="to"></param>
        /// <param name="id"></param>
        /// <param name="replyto"></param>
        /// <param name="cc"></param>
        /// <param name="bcc"></param>
        /// <param name="attachments"></param>
        /// <returns>GenericResponse</returns>
        public GenericResponse SendMailById (string subject, string body, List<SendMailFrom> from, List<MailContact> to, long? id, List<MailContact> replyto, List<MailContact> cc, List<MailContact> bcc, List<MailAttachment> attachments)
        {
            // verify the required parameter 'subject' is set
            if (subject == null) throw new ApiException(400, "Missing required parameter 'subject' when calling SendMailById");
            // verify the required parameter 'body' is set
            if (body == null) throw new ApiException(400, "Missing required parameter 'body' when calling SendMailById");
            // verify the required parameter 'from' is set
            if (from == null) throw new ApiException(400, "Missing required parameter 'from' when calling SendMailById");
            // verify the required parameter 'to' is set
            if (to == null) throw new ApiException(400, "Missing required parameter 'to' when calling SendMailById");
            // verify the required parameter 'id' is set
            if (id == null) throw new ApiException(400, "Missing required parameter 'id' when calling SendMailById");
            // verify the required parameter 'replyto' is set
            if (replyto == null) throw new ApiException(400, "Missing required parameter 'replyto' when calling SendMailById");
            // verify the required parameter 'cc' is set
            if (cc == null) throw new ApiException(400, "Missing required parameter 'cc' when calling SendMailById");
            // verify the required parameter 'bcc' is set
            if (bcc == null) throw new ApiException(400, "Missing required parameter 'bcc' when calling SendMailById");
            // verify the required parameter 'attachments' is set
            if (attachments == null) throw new ApiException(400, "Missing required parameter 'attachments' when calling SendMailById");
    
            var path = "/mail/send";
            path = path.Replace("{format}", "json");
                
            var queryParams = new Dictionary<String, String>();
            var headerParams = new Dictionary<String, String>();
            var formParams = new Dictionary<String, String>();
            var fileParams = new Dictionary<String, FileParameter>();
            String postBody = null;
    
                                    if (subject != null) formParams.Add("subject", ApiClient.ParameterToString(subject)); // form parameter
if (body != null) formParams.Add("body", ApiClient.ParameterToString(body)); // form parameter
if (from != null) formParams.Add("from", ApiClient.ParameterToString(from)); // form parameter
if (to != null) formParams.Add("to", ApiClient.ParameterToString(to)); // form parameter
if (id != null) formParams.Add("id", ApiClient.ParameterToString(id)); // form parameter
if (replyto != null) formParams.Add("replyto", ApiClient.ParameterToString(replyto)); // form parameter
if (cc != null) formParams.Add("cc", ApiClient.ParameterToString(cc)); // form parameter
if (bcc != null) formParams.Add("bcc", ApiClient.ParameterToString(bcc)); // form parameter
if (attachments != null) formParams.Add("attachments", ApiClient.ParameterToString(attachments)); // form parameter

            // authentication setting, if any
            String[] authSettings = new String[] { "apiKeyAuth" };
    
            // make the HTTP request
            IRestResponse response = (IRestResponse) ApiClient.CallApi(path, Method.POST, queryParams, postBody, headerParams, formParams, fileParams, authSettings);
    
            if (((int)response.StatusCode) >= 400)
                throw new ApiException ((int)response.StatusCode, "Error calling SendMailById: " + response.Content, response.Content);
            else if (((int)response.StatusCode) == 0)
                throw new ApiException ((int)response.StatusCode, "Error calling SendMailById: " + response.ErrorMessage, response.ErrorMessage);
    
            return (GenericResponse) ApiClient.Deserialize(response.Content, typeof(GenericResponse), response.Headers);
        }
    
        /// <summary>
        /// validatess order details before placing an order 
        /// </summary>
        /// <returns></returns>
        public void ValidateMailOrder ()
        {
    
            var path = "/mail/order";
            path = path.Replace("{format}", "json");
                
            var queryParams = new Dictionary<String, String>();
            var headerParams = new Dictionary<String, String>();
            var formParams = new Dictionary<String, String>();
            var fileParams = new Dictionary<String, FileParameter>();
            String postBody = null;
    
                                    
            // authentication setting, if any
            String[] authSettings = new String[] { "apiKeyAuth" };
    
            // make the HTTP request
            IRestResponse response = (IRestResponse) ApiClient.CallApi(path, Method.GET, queryParams, postBody, headerParams, formParams, fileParams, authSettings);
    
            if (((int)response.StatusCode) >= 400)
                throw new ApiException ((int)response.StatusCode, "Error calling ValidateMailOrder: " + response.Content, response.Content);
            else if (((int)response.StatusCode) == 0)
                throw new ApiException ((int)response.StatusCode, "Error calling ValidateMailOrder: " + response.ErrorMessage, response.ErrorMessage);
    
            return;
        }
    
        /// <summary>
        /// displays the mail log By passing in the appropriate options, you can search for available inventory in the system 
        /// </summary>
        /// <param name="id">The ID of your mail order this will be sent through.</param>
        /// <param name="searchString">pass an optional search string for looking up inventory</param>
        /// <param name="skip">number of records to skip for pagination</param>
        /// <param name="limit">maximum number of records to return</param>
        /// <returns>List&lt;MailLog&gt;</returns>
        public List<MailLog> ViewMailLogById (long? id, string searchString, int? skip, int? limit)
        {
    
            var path = "/mail/log";
            path = path.Replace("{format}", "json");
                
            var queryParams = new Dictionary<String, String>();
            var headerParams = new Dictionary<String, String>();
            var formParams = new Dictionary<String, String>();
            var fileParams = new Dictionary<String, FileParameter>();
            String postBody = null;
    
             if (id != null) queryParams.Add("id", ApiClient.ParameterToString(id)); // query parameter
 if (searchString != null) queryParams.Add("searchString", ApiClient.ParameterToString(searchString)); // query parameter
 if (skip != null) queryParams.Add("skip", ApiClient.ParameterToString(skip)); // query parameter
 if (limit != null) queryParams.Add("limit", ApiClient.ParameterToString(limit)); // query parameter
                        
            // authentication setting, if any
            String[] authSettings = new String[] { "apiKeyAuth" };
    
            // make the HTTP request
            IRestResponse response = (IRestResponse) ApiClient.CallApi(path, Method.GET, queryParams, postBody, headerParams, formParams, fileParams, authSettings);
    
            if (((int)response.StatusCode) >= 400)
                throw new ApiException ((int)response.StatusCode, "Error calling ViewMailLogById: " + response.Content, response.Content);
            else if (((int)response.StatusCode) == 0)
                throw new ApiException ((int)response.StatusCode, "Error calling ViewMailLogById: " + response.ErrorMessage, response.ErrorMessage);
    
            return (List<MailLog>) ApiClient.Deserialize(response.Content, typeof(List<MailLog>), response.Headers);
        }
    
    }
}
