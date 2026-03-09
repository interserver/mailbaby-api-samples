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
    public interface IBlockingApi
    {
        /// <summary>
        /// Creates a new email deny rule. Adds a new email deny rule into the system to block new emails that match the given criteria
        /// </summary>
        /// <param name="user"></param>
        /// <param name="type"></param>
        /// <param name="data"></param>
        /// <returns>GenericResponse</returns>
        GenericResponse AddRule (string user, string type, string data);
        /// <summary>
        /// Creates a new email deny rule. Adds a new email deny rule into the system to block new emails that match the given criteria
        /// </summary>
        /// <param name="body">These are the fields needed to create a new email deny rule.</param>
        /// <returns>GenericResponse</returns>
        GenericResponse AddRule (DenyRuleNew body);
        /// <summary>
        /// Removes an deny mail rule. Removes one of the configured deny mail rules from the system.
        /// </summary>
        /// <param name="ruleId">The ID of the Rules entry.</param>
        /// <returns>GenericResponse</returns>
        GenericResponse DeleteRule (int? ruleId);
        /// <summary>
        /// Removes an email address from the blocked list Removes an email address from the various block lists. 
        /// </summary>
        /// <param name="body"></param>
        /// <returns>GenericResponse</returns>
        GenericResponse DelistBlock (string body);
        /// <summary>
        /// displays a list of blocked email addresses 
        /// </summary>
        /// <returns>MailBlocks</returns>
        MailBlocks GetMailBlocks ();
        /// <summary>
        /// Displays a listing of deny email rules. Returns a listing of all the deny block rules you have configured.
        /// </summary>
        /// <returns>List&lt;DenyRuleRecord&gt;</returns>
        List<DenyRuleRecord> GetRules ();
    }
  
    /// <summary>
    /// Represents a collection of functions to interact with the API endpoints
    /// </summary>
    public class BlockingApi : IBlockingApi
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="BlockingApi"/> class.
        /// </summary>
        /// <param name="apiClient"> an instance of ApiClient (optional)</param>
        /// <returns></returns>
        public BlockingApi(ApiClient apiClient = null)
        {
            if (apiClient == null) // use the default one in Configuration
                this.ApiClient = Configuration.DefaultApiClient; 
            else
                this.ApiClient = apiClient;
        }
    
        /// <summary>
        /// Initializes a new instance of the <see cref="BlockingApi"/> class.
        /// </summary>
        /// <returns></returns>
        public BlockingApi(String basePath)
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
        /// Creates a new email deny rule. Adds a new email deny rule into the system to block new emails that match the given criteria
        /// </summary>
        /// <param name="user"></param>
        /// <param name="type"></param>
        /// <param name="data"></param>
        /// <returns>GenericResponse</returns>
        public GenericResponse AddRule (string user, string type, string data)
        {
            // verify the required parameter 'user' is set
            if (user == null) throw new ApiException(400, "Missing required parameter 'user' when calling AddRule");
            // verify the required parameter 'type' is set
            if (type == null) throw new ApiException(400, "Missing required parameter 'type' when calling AddRule");
            // verify the required parameter 'data' is set
            if (data == null) throw new ApiException(400, "Missing required parameter 'data' when calling AddRule");
    
            var path = "/mail/rules";
            path = path.Replace("{format}", "json");
                
            var queryParams = new Dictionary<String, String>();
            var headerParams = new Dictionary<String, String>();
            var formParams = new Dictionary<String, String>();
            var fileParams = new Dictionary<String, FileParameter>();
            String postBody = null;
    
                                    if (user != null) formParams.Add("user", ApiClient.ParameterToString(user)); // form parameter
if (type != null) formParams.Add("type", ApiClient.ParameterToString(type)); // form parameter
if (data != null) formParams.Add("data", ApiClient.ParameterToString(data)); // form parameter

            // authentication setting, if any
            String[] authSettings = new String[] { "apiKeyAuth" };
    
            // make the HTTP request
            IRestResponse response = (IRestResponse) ApiClient.CallApi(path, Method.POST, queryParams, postBody, headerParams, formParams, fileParams, authSettings);
    
            if (((int)response.StatusCode) >= 400)
                throw new ApiException ((int)response.StatusCode, "Error calling AddRule: " + response.Content, response.Content);
            else if (((int)response.StatusCode) == 0)
                throw new ApiException ((int)response.StatusCode, "Error calling AddRule: " + response.ErrorMessage, response.ErrorMessage);
    
            return (GenericResponse) ApiClient.Deserialize(response.Content, typeof(GenericResponse), response.Headers);
        }
    
        /// <summary>
        /// Creates a new email deny rule. Adds a new email deny rule into the system to block new emails that match the given criteria
        /// </summary>
        /// <param name="body">These are the fields needed to create a new email deny rule.</param>
        /// <returns>GenericResponse</returns>
        public GenericResponse AddRule (DenyRuleNew body)
        {
            // verify the required parameter 'body' is set
            if (body == null) throw new ApiException(400, "Missing required parameter 'body' when calling AddRule");
    
            var path = "/mail/rules";
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
                throw new ApiException ((int)response.StatusCode, "Error calling AddRule: " + response.Content, response.Content);
            else if (((int)response.StatusCode) == 0)
                throw new ApiException ((int)response.StatusCode, "Error calling AddRule: " + response.ErrorMessage, response.ErrorMessage);
    
            return (GenericResponse) ApiClient.Deserialize(response.Content, typeof(GenericResponse), response.Headers);
        }
    
        /// <summary>
        /// Removes an deny mail rule. Removes one of the configured deny mail rules from the system.
        /// </summary>
        /// <param name="ruleId">The ID of the Rules entry.</param>
        /// <returns>GenericResponse</returns>
        public GenericResponse DeleteRule (int? ruleId)
        {
            // verify the required parameter 'ruleId' is set
            if (ruleId == null) throw new ApiException(400, "Missing required parameter 'ruleId' when calling DeleteRule");
    
            var path = "/mail/rules/{ruleId}";
            path = path.Replace("{format}", "json");
            path = path.Replace("{" + "ruleId" + "}", ApiClient.ParameterToString(ruleId));
    
            var queryParams = new Dictionary<String, String>();
            var headerParams = new Dictionary<String, String>();
            var formParams = new Dictionary<String, String>();
            var fileParams = new Dictionary<String, FileParameter>();
            String postBody = null;
    
                                    
            // authentication setting, if any
            String[] authSettings = new String[] { "apiKeyAuth" };
    
            // make the HTTP request
            IRestResponse response = (IRestResponse) ApiClient.CallApi(path, Method.DELETE, queryParams, postBody, headerParams, formParams, fileParams, authSettings);
    
            if (((int)response.StatusCode) >= 400)
                throw new ApiException ((int)response.StatusCode, "Error calling DeleteRule: " + response.Content, response.Content);
            else if (((int)response.StatusCode) == 0)
                throw new ApiException ((int)response.StatusCode, "Error calling DeleteRule: " + response.ErrorMessage, response.ErrorMessage);
    
            return (GenericResponse) ApiClient.Deserialize(response.Content, typeof(GenericResponse), response.Headers);
        }
    
        /// <summary>
        /// Removes an email address from the blocked list Removes an email address from the various block lists. 
        /// </summary>
        /// <param name="body"></param>
        /// <returns>GenericResponse</returns>
        public GenericResponse DelistBlock (string body)
        {
            // verify the required parameter 'body' is set
            if (body == null) throw new ApiException(400, "Missing required parameter 'body' when calling DelistBlock");
    
            var path = "/mail/blocks/delete";
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
                throw new ApiException ((int)response.StatusCode, "Error calling DelistBlock: " + response.Content, response.Content);
            else if (((int)response.StatusCode) == 0)
                throw new ApiException ((int)response.StatusCode, "Error calling DelistBlock: " + response.ErrorMessage, response.ErrorMessage);
    
            return (GenericResponse) ApiClient.Deserialize(response.Content, typeof(GenericResponse), response.Headers);
        }
    
        /// <summary>
        /// displays a list of blocked email addresses 
        /// </summary>
        /// <returns>MailBlocks</returns>
        public MailBlocks GetMailBlocks ()
        {
    
            var path = "/mail/blocks";
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
                throw new ApiException ((int)response.StatusCode, "Error calling GetMailBlocks: " + response.Content, response.Content);
            else if (((int)response.StatusCode) == 0)
                throw new ApiException ((int)response.StatusCode, "Error calling GetMailBlocks: " + response.ErrorMessage, response.ErrorMessage);
    
            return (MailBlocks) ApiClient.Deserialize(response.Content, typeof(MailBlocks), response.Headers);
        }
    
        /// <summary>
        /// Displays a listing of deny email rules. Returns a listing of all the deny block rules you have configured.
        /// </summary>
        /// <returns>List&lt;DenyRuleRecord&gt;</returns>
        public List<DenyRuleRecord> GetRules ()
        {
    
            var path = "/mail/rules";
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
                throw new ApiException ((int)response.StatusCode, "Error calling GetRules: " + response.Content, response.Content);
            else if (((int)response.StatusCode) == 0)
                throw new ApiException ((int)response.StatusCode, "Error calling GetRules: " + response.ErrorMessage, response.ErrorMessage);
    
            return (List<DenyRuleRecord>) ApiClient.Deserialize(response.Content, typeof(List<DenyRuleRecord>), response.Headers);
        }
    
    }
}
