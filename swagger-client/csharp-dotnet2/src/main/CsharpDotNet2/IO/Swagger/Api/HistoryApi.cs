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
    public interface IHistoryApi
    {
        /// <summary>
        /// Account usage statistics. Returns information about the usage on your mail accounts.
        /// </summary>
        /// <returns>List&lt;InlineResponse200&gt;</returns>
        List<InlineResponse200> GetStats ();
        /// <summary>
        /// displays the mail log Get a listing of the emails sent through this system 
        /// </summary>
        /// <param name="id">The ID of your mail order this will be sent through.</param>
        /// <param name="origin">originating ip address sending mail</param>
        /// <param name="mx">mx record mail was sent to</param>
        /// <param name="from">from email address</param>
        /// <param name="to">to/destination email address</param>
        /// <param name="subject">subject containing this string</param>
        /// <param name="mailid">mail id</param>
        /// <param name="skip">number of records to skip for pagination</param>
        /// <param name="limit">maximum number of records to return</param>
        /// <param name="startDate">earliest date to get emails in unix timestamp format</param>
        /// <param name="endDate">earliest date to get emails in unix timestamp format</param>
        /// <param name="replyto">Reply-To Email Address</param>
        /// <param name="headerfrom">Header From Email Address</param>
        /// <returns>MailLog</returns>
        MailLog ViewMailLog (long? id, string origin, string mx, string from, string to, string subject, string mailid, int? skip, int? limit, long? startDate, long? endDate, string replyto, string headerfrom);
    }
  
    /// <summary>
    /// Represents a collection of functions to interact with the API endpoints
    /// </summary>
    public class HistoryApi : IHistoryApi
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="HistoryApi"/> class.
        /// </summary>
        /// <param name="apiClient"> an instance of ApiClient (optional)</param>
        /// <returns></returns>
        public HistoryApi(ApiClient apiClient = null)
        {
            if (apiClient == null) // use the default one in Configuration
                this.ApiClient = Configuration.DefaultApiClient; 
            else
                this.ApiClient = apiClient;
        }
    
        /// <summary>
        /// Initializes a new instance of the <see cref="HistoryApi"/> class.
        /// </summary>
        /// <returns></returns>
        public HistoryApi(String basePath)
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
        /// Account usage statistics. Returns information about the usage on your mail accounts.
        /// </summary>
        /// <returns>List&lt;InlineResponse200&gt;</returns>
        public List<InlineResponse200> GetStats ()
        {
    
            var path = "/mail/stats";
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
                throw new ApiException ((int)response.StatusCode, "Error calling GetStats: " + response.Content, response.Content);
            else if (((int)response.StatusCode) == 0)
                throw new ApiException ((int)response.StatusCode, "Error calling GetStats: " + response.ErrorMessage, response.ErrorMessage);
    
            return (List<InlineResponse200>) ApiClient.Deserialize(response.Content, typeof(List<InlineResponse200>), response.Headers);
        }
    
        /// <summary>
        /// displays the mail log Get a listing of the emails sent through this system 
        /// </summary>
        /// <param name="id">The ID of your mail order this will be sent through.</param>
        /// <param name="origin">originating ip address sending mail</param>
        /// <param name="mx">mx record mail was sent to</param>
        /// <param name="from">from email address</param>
        /// <param name="to">to/destination email address</param>
        /// <param name="subject">subject containing this string</param>
        /// <param name="mailid">mail id</param>
        /// <param name="skip">number of records to skip for pagination</param>
        /// <param name="limit">maximum number of records to return</param>
        /// <param name="startDate">earliest date to get emails in unix timestamp format</param>
        /// <param name="endDate">earliest date to get emails in unix timestamp format</param>
        /// <param name="replyto">Reply-To Email Address</param>
        /// <param name="headerfrom">Header From Email Address</param>
        /// <returns>MailLog</returns>
        public MailLog ViewMailLog (long? id, string origin, string mx, string from, string to, string subject, string mailid, int? skip, int? limit, long? startDate, long? endDate, string replyto, string headerfrom)
        {
    
            var path = "/mail/log";
            path = path.Replace("{format}", "json");
                
            var queryParams = new Dictionary<String, String>();
            var headerParams = new Dictionary<String, String>();
            var formParams = new Dictionary<String, String>();
            var fileParams = new Dictionary<String, FileParameter>();
            String postBody = null;
    
             if (id != null) queryParams.Add("id", ApiClient.ParameterToString(id)); // query parameter
 if (origin != null) queryParams.Add("origin", ApiClient.ParameterToString(origin)); // query parameter
 if (mx != null) queryParams.Add("mx", ApiClient.ParameterToString(mx)); // query parameter
 if (from != null) queryParams.Add("from", ApiClient.ParameterToString(from)); // query parameter
 if (to != null) queryParams.Add("to", ApiClient.ParameterToString(to)); // query parameter
 if (subject != null) queryParams.Add("subject", ApiClient.ParameterToString(subject)); // query parameter
 if (mailid != null) queryParams.Add("mailid", ApiClient.ParameterToString(mailid)); // query parameter
 if (skip != null) queryParams.Add("skip", ApiClient.ParameterToString(skip)); // query parameter
 if (limit != null) queryParams.Add("limit", ApiClient.ParameterToString(limit)); // query parameter
 if (startDate != null) queryParams.Add("startDate", ApiClient.ParameterToString(startDate)); // query parameter
 if (endDate != null) queryParams.Add("endDate", ApiClient.ParameterToString(endDate)); // query parameter
 if (replyto != null) queryParams.Add("replyto", ApiClient.ParameterToString(replyto)); // query parameter
 if (headerfrom != null) queryParams.Add("headerfrom", ApiClient.ParameterToString(headerfrom)); // query parameter
                        
            // authentication setting, if any
            String[] authSettings = new String[] { "apiKeyAuth" };
    
            // make the HTTP request
            IRestResponse response = (IRestResponse) ApiClient.CallApi(path, Method.GET, queryParams, postBody, headerParams, formParams, fileParams, authSettings);
    
            if (((int)response.StatusCode) >= 400)
                throw new ApiException ((int)response.StatusCode, "Error calling ViewMailLog: " + response.Content, response.Content);
            else if (((int)response.StatusCode) == 0)
                throw new ApiException ((int)response.StatusCode, "Error calling ViewMailLog: " + response.ErrorMessage, response.ErrorMessage);
    
            return (MailLog) ApiClient.Deserialize(response.Content, typeof(MailLog), response.Headers);
        }
    
    }
}
