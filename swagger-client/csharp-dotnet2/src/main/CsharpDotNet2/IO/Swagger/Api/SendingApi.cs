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
    public interface ISendingApi
    {
        /// <summary>
        /// Sends an Email with Advanced Options Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  &#x60;&#x60;&#x60;BasicForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;subject&#x3D;Welcome&#x27; \\ - -data &#x27;body&#x3D;Hello&#x27; \\ - -data from&#x3D;user@domain.com \\ - -data to&#x3D;support@interserver.net &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;subject&#x3D;Welcome&#x27; \\ - -data &#x27;body&#x3D;Hello&#x27; \\ - -data from&#x3D;user@domain.com \\ - -data \&quot;to[0][name]&#x3D;Joe\&quot; \\ - -data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;subject&#x3D;Welcome&#x27; \\ - -data &#x27;body&#x3D;Hello&#x27; \\ - -data from&#x3D;\&quot;Joe &lt;user@domain.com&gt;\&quot; \\ - -data to&#x3D;\&quot;Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;subject&#x3D;Welcome&#x27; \\ - -data &#x27;body&#x3D;Hello&#x27; \\ - -data from&#x3D;user@domain.com \\ - -data \&quot;to&#x3D;support@interserver.net, support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToFullForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;subject&#x3D;Welcome&#x27; \\ - -data &#x27;body&#x3D;Hello&#x27; \\ - -data from&#x3D;user@domain.com \\ - -data \&quot;to&#x3D;Joe &lt;support@interserver.net&gt;, Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToArrayForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;subject&#x3D;Welcome&#x27; \\ - -data &#x27;body&#x3D;Hello&#x27; \\ - -data from&#x3D;user@domain.com \\ - -data \&quot;to[0][name]&#x3D;Joe\&quot; \\ - -data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; \\ - -data \&quot;to[1][name]&#x3D;Joe\&quot; \\ - -data \&quot;to[1][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;BasicJson curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/json&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;user@domain.com\&quot;, \&quot;to\&quot;: \&quot;support@interserver.net\&quot; }&#x27; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayJson curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/json&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: {\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;user@domain.com\&quot;}, \&quot;to\&quot;: [{\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;support@interserver.net\&quot;}] }&#x27; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailJson curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/json&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;Joe &lt;user@domain.com&gt;\&quot;, \&quot;to\&quot;: \&quot;Joe &lt;support@interserver.net&gt;\&quot; }&#x27; &#x60;&#x60;&#x60; 
        /// </summary>
        /// <param name="subject"></param>
        /// <param name="body"></param>
        /// <param name="from"></param>
        /// <param name="to"></param>
        /// <param name="replyto"></param>
        /// <param name="cc"></param>
        /// <param name="bcc"></param>
        /// <param name="attachments"></param>
        /// <param name="id"></param>
        /// <returns>GenericResponse</returns>
        GenericResponse SendAdvMail (string subject, string body, EmailAddressTypes from, EmailAddressesTypes to, EmailAddressesTypes replyto, EmailAddressesTypes cc, EmailAddressesTypes bcc, List<MailAttachment> attachments, long? id);
        /// <summary>
        /// Sends an Email with Advanced Options Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  &#x60;&#x60;&#x60;BasicForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;subject&#x3D;Welcome&#x27; \\ - -data &#x27;body&#x3D;Hello&#x27; \\ - -data from&#x3D;user@domain.com \\ - -data to&#x3D;support@interserver.net &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;subject&#x3D;Welcome&#x27; \\ - -data &#x27;body&#x3D;Hello&#x27; \\ - -data from&#x3D;user@domain.com \\ - -data \&quot;to[0][name]&#x3D;Joe\&quot; \\ - -data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;subject&#x3D;Welcome&#x27; \\ - -data &#x27;body&#x3D;Hello&#x27; \\ - -data from&#x3D;\&quot;Joe &lt;user@domain.com&gt;\&quot; \\ - -data to&#x3D;\&quot;Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;subject&#x3D;Welcome&#x27; \\ - -data &#x27;body&#x3D;Hello&#x27; \\ - -data from&#x3D;user@domain.com \\ - -data \&quot;to&#x3D;support@interserver.net, support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToFullForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;subject&#x3D;Welcome&#x27; \\ - -data &#x27;body&#x3D;Hello&#x27; \\ - -data from&#x3D;user@domain.com \\ - -data \&quot;to&#x3D;Joe &lt;support@interserver.net&gt;, Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToArrayForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;subject&#x3D;Welcome&#x27; \\ - -data &#x27;body&#x3D;Hello&#x27; \\ - -data from&#x3D;user@domain.com \\ - -data \&quot;to[0][name]&#x3D;Joe\&quot; \\ - -data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; \\ - -data \&quot;to[1][name]&#x3D;Joe\&quot; \\ - -data \&quot;to[1][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;BasicJson curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/json&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;user@domain.com\&quot;, \&quot;to\&quot;: \&quot;support@interserver.net\&quot; }&#x27; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayJson curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/json&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: {\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;user@domain.com\&quot;}, \&quot;to\&quot;: [{\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;support@interserver.net\&quot;}] }&#x27; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailJson curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/json&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;Joe &lt;user@domain.com&gt;\&quot;, \&quot;to\&quot;: \&quot;Joe &lt;support@interserver.net&gt;\&quot; }&#x27; &#x60;&#x60;&#x60; 
        /// </summary>
        /// <param name="body"></param>
        /// <returns>GenericResponse</returns>
        GenericResponse SendAdvMail (SendMailAdv body);
        /// <summary>
        /// Sends an Email Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
        /// </summary>
        /// <param name="to"></param>
        /// <param name="from"></param>
        /// <param name="subject"></param>
        /// <param name="body"></param>
        /// <returns>GenericResponse</returns>
        GenericResponse SendMail (string to, string from, string subject, string body);
        /// <summary>
        /// Sends an Email Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
        /// </summary>
        /// <param name="body"></param>
        /// <returns>GenericResponse</returns>
        GenericResponse SendMail (SendMail body);
    }
  
    /// <summary>
    /// Represents a collection of functions to interact with the API endpoints
    /// </summary>
    public class SendingApi : ISendingApi
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="SendingApi"/> class.
        /// </summary>
        /// <param name="apiClient"> an instance of ApiClient (optional)</param>
        /// <returns></returns>
        public SendingApi(ApiClient apiClient = null)
        {
            if (apiClient == null) // use the default one in Configuration
                this.ApiClient = Configuration.DefaultApiClient; 
            else
                this.ApiClient = apiClient;
        }
    
        /// <summary>
        /// Initializes a new instance of the <see cref="SendingApi"/> class.
        /// </summary>
        /// <returns></returns>
        public SendingApi(String basePath)
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
        /// Sends an Email with Advanced Options Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  &#x60;&#x60;&#x60;BasicForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;subject&#x3D;Welcome&#x27; \\ - -data &#x27;body&#x3D;Hello&#x27; \\ - -data from&#x3D;user@domain.com \\ - -data to&#x3D;support@interserver.net &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;subject&#x3D;Welcome&#x27; \\ - -data &#x27;body&#x3D;Hello&#x27; \\ - -data from&#x3D;user@domain.com \\ - -data \&quot;to[0][name]&#x3D;Joe\&quot; \\ - -data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;subject&#x3D;Welcome&#x27; \\ - -data &#x27;body&#x3D;Hello&#x27; \\ - -data from&#x3D;\&quot;Joe &lt;user@domain.com&gt;\&quot; \\ - -data to&#x3D;\&quot;Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;subject&#x3D;Welcome&#x27; \\ - -data &#x27;body&#x3D;Hello&#x27; \\ - -data from&#x3D;user@domain.com \\ - -data \&quot;to&#x3D;support@interserver.net, support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToFullForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;subject&#x3D;Welcome&#x27; \\ - -data &#x27;body&#x3D;Hello&#x27; \\ - -data from&#x3D;user@domain.com \\ - -data \&quot;to&#x3D;Joe &lt;support@interserver.net&gt;, Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToArrayForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;subject&#x3D;Welcome&#x27; \\ - -data &#x27;body&#x3D;Hello&#x27; \\ - -data from&#x3D;user@domain.com \\ - -data \&quot;to[0][name]&#x3D;Joe\&quot; \\ - -data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; \\ - -data \&quot;to[1][name]&#x3D;Joe\&quot; \\ - -data \&quot;to[1][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;BasicJson curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/json&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;user@domain.com\&quot;, \&quot;to\&quot;: \&quot;support@interserver.net\&quot; }&#x27; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayJson curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/json&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: {\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;user@domain.com\&quot;}, \&quot;to\&quot;: [{\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;support@interserver.net\&quot;}] }&#x27; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailJson curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/json&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;Joe &lt;user@domain.com&gt;\&quot;, \&quot;to\&quot;: \&quot;Joe &lt;support@interserver.net&gt;\&quot; }&#x27; &#x60;&#x60;&#x60; 
        /// </summary>
        /// <param name="subject"></param>
        /// <param name="body"></param>
        /// <param name="from"></param>
        /// <param name="to"></param>
        /// <param name="replyto"></param>
        /// <param name="cc"></param>
        /// <param name="bcc"></param>
        /// <param name="attachments"></param>
        /// <param name="id"></param>
        /// <returns>GenericResponse</returns>
        public GenericResponse SendAdvMail (string subject, string body, EmailAddressTypes from, EmailAddressesTypes to, EmailAddressesTypes replyto, EmailAddressesTypes cc, EmailAddressesTypes bcc, List<MailAttachment> attachments, long? id)
        {
            // verify the required parameter 'subject' is set
            if (subject == null) throw new ApiException(400, "Missing required parameter 'subject' when calling SendAdvMail");
            // verify the required parameter 'body' is set
            if (body == null) throw new ApiException(400, "Missing required parameter 'body' when calling SendAdvMail");
            // verify the required parameter 'from' is set
            if (from == null) throw new ApiException(400, "Missing required parameter 'from' when calling SendAdvMail");
            // verify the required parameter 'to' is set
            if (to == null) throw new ApiException(400, "Missing required parameter 'to' when calling SendAdvMail");
            // verify the required parameter 'replyto' is set
            if (replyto == null) throw new ApiException(400, "Missing required parameter 'replyto' when calling SendAdvMail");
            // verify the required parameter 'cc' is set
            if (cc == null) throw new ApiException(400, "Missing required parameter 'cc' when calling SendAdvMail");
            // verify the required parameter 'bcc' is set
            if (bcc == null) throw new ApiException(400, "Missing required parameter 'bcc' when calling SendAdvMail");
            // verify the required parameter 'attachments' is set
            if (attachments == null) throw new ApiException(400, "Missing required parameter 'attachments' when calling SendAdvMail");
            // verify the required parameter 'id' is set
            if (id == null) throw new ApiException(400, "Missing required parameter 'id' when calling SendAdvMail");
    
            var path = "/mail/advsend";
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
if (replyto != null) formParams.Add("replyto", ApiClient.ParameterToString(replyto)); // form parameter
if (cc != null) formParams.Add("cc", ApiClient.ParameterToString(cc)); // form parameter
if (bcc != null) formParams.Add("bcc", ApiClient.ParameterToString(bcc)); // form parameter
if (attachments != null) formParams.Add("attachments", ApiClient.ParameterToString(attachments)); // form parameter
if (id != null) formParams.Add("id", ApiClient.ParameterToString(id)); // form parameter

            // authentication setting, if any
            String[] authSettings = new String[] { "apiKeyAuth" };
    
            // make the HTTP request
            IRestResponse response = (IRestResponse) ApiClient.CallApi(path, Method.POST, queryParams, postBody, headerParams, formParams, fileParams, authSettings);
    
            if (((int)response.StatusCode) >= 400)
                throw new ApiException ((int)response.StatusCode, "Error calling SendAdvMail: " + response.Content, response.Content);
            else if (((int)response.StatusCode) == 0)
                throw new ApiException ((int)response.StatusCode, "Error calling SendAdvMail: " + response.ErrorMessage, response.ErrorMessage);
    
            return (GenericResponse) ApiClient.Deserialize(response.Content, typeof(GenericResponse), response.Headers);
        }
    
        /// <summary>
        /// Sends an Email with Advanced Options Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  &#x60;&#x60;&#x60;BasicForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;subject&#x3D;Welcome&#x27; \\ - -data &#x27;body&#x3D;Hello&#x27; \\ - -data from&#x3D;user@domain.com \\ - -data to&#x3D;support@interserver.net &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;subject&#x3D;Welcome&#x27; \\ - -data &#x27;body&#x3D;Hello&#x27; \\ - -data from&#x3D;user@domain.com \\ - -data \&quot;to[0][name]&#x3D;Joe\&quot; \\ - -data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;subject&#x3D;Welcome&#x27; \\ - -data &#x27;body&#x3D;Hello&#x27; \\ - -data from&#x3D;\&quot;Joe &lt;user@domain.com&gt;\&quot; \\ - -data to&#x3D;\&quot;Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;subject&#x3D;Welcome&#x27; \\ - -data &#x27;body&#x3D;Hello&#x27; \\ - -data from&#x3D;user@domain.com \\ - -data \&quot;to&#x3D;support@interserver.net, support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToFullForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;subject&#x3D;Welcome&#x27; \\ - -data &#x27;body&#x3D;Hello&#x27; \\ - -data from&#x3D;user@domain.com \\ - -data \&quot;to&#x3D;Joe &lt;support@interserver.net&gt;, Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToArrayForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;subject&#x3D;Welcome&#x27; \\ - -data &#x27;body&#x3D;Hello&#x27; \\ - -data from&#x3D;user@domain.com \\ - -data \&quot;to[0][name]&#x3D;Joe\&quot; \\ - -data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; \\ - -data \&quot;to[1][name]&#x3D;Joe\&quot; \\ - -data \&quot;to[1][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;BasicJson curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/json&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;user@domain.com\&quot;, \&quot;to\&quot;: \&quot;support@interserver.net\&quot; }&#x27; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayJson curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/json&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: {\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;user@domain.com\&quot;}, \&quot;to\&quot;: [{\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;support@interserver.net\&quot;}] }&#x27; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailJson curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/json&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;Joe &lt;user@domain.com&gt;\&quot;, \&quot;to\&quot;: \&quot;Joe &lt;support@interserver.net&gt;\&quot; }&#x27; &#x60;&#x60;&#x60; 
        /// </summary>
        /// <param name="body"></param>
        /// <returns>GenericResponse</returns>
        public GenericResponse SendAdvMail (SendMailAdv body)
        {
            // verify the required parameter 'body' is set
            if (body == null) throw new ApiException(400, "Missing required parameter 'body' when calling SendAdvMail");
    
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
                throw new ApiException ((int)response.StatusCode, "Error calling SendAdvMail: " + response.Content, response.Content);
            else if (((int)response.StatusCode) == 0)
                throw new ApiException ((int)response.StatusCode, "Error calling SendAdvMail: " + response.ErrorMessage, response.ErrorMessage);
    
            return (GenericResponse) ApiClient.Deserialize(response.Content, typeof(GenericResponse), response.Headers);
        }
    
        /// <summary>
        /// Sends an Email Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
        /// </summary>
        /// <param name="to"></param>
        /// <param name="from"></param>
        /// <param name="subject"></param>
        /// <param name="body"></param>
        /// <returns>GenericResponse</returns>
        public GenericResponse SendMail (string to, string from, string subject, string body)
        {
            // verify the required parameter 'to' is set
            if (to == null) throw new ApiException(400, "Missing required parameter 'to' when calling SendMail");
            // verify the required parameter 'from' is set
            if (from == null) throw new ApiException(400, "Missing required parameter 'from' when calling SendMail");
            // verify the required parameter 'subject' is set
            if (subject == null) throw new ApiException(400, "Missing required parameter 'subject' when calling SendMail");
            // verify the required parameter 'body' is set
            if (body == null) throw new ApiException(400, "Missing required parameter 'body' when calling SendMail");
    
            var path = "/mail/send";
            path = path.Replace("{format}", "json");
                
            var queryParams = new Dictionary<String, String>();
            var headerParams = new Dictionary<String, String>();
            var formParams = new Dictionary<String, String>();
            var fileParams = new Dictionary<String, FileParameter>();
            String postBody = null;
    
                                    if (to != null) formParams.Add("to", ApiClient.ParameterToString(to)); // form parameter
if (from != null) formParams.Add("from", ApiClient.ParameterToString(from)); // form parameter
if (subject != null) formParams.Add("subject", ApiClient.ParameterToString(subject)); // form parameter
if (body != null) formParams.Add("body", ApiClient.ParameterToString(body)); // form parameter

            // authentication setting, if any
            String[] authSettings = new String[] { "apiKeyAuth" };
    
            // make the HTTP request
            IRestResponse response = (IRestResponse) ApiClient.CallApi(path, Method.POST, queryParams, postBody, headerParams, formParams, fileParams, authSettings);
    
            if (((int)response.StatusCode) >= 400)
                throw new ApiException ((int)response.StatusCode, "Error calling SendMail: " + response.Content, response.Content);
            else if (((int)response.StatusCode) == 0)
                throw new ApiException ((int)response.StatusCode, "Error calling SendMail: " + response.ErrorMessage, response.ErrorMessage);
    
            return (GenericResponse) ApiClient.Deserialize(response.Content, typeof(GenericResponse), response.Headers);
        }
    
        /// <summary>
        /// Sends an Email Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
        /// </summary>
        /// <param name="body"></param>
        /// <returns>GenericResponse</returns>
        public GenericResponse SendMail (SendMail body)
        {
            // verify the required parameter 'body' is set
            if (body == null) throw new ApiException(400, "Missing required parameter 'body' when calling SendMail");
    
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
                throw new ApiException ((int)response.StatusCode, "Error calling SendMail: " + response.Content, response.Content);
            else if (((int)response.StatusCode) == 0)
                throw new ApiException ((int)response.StatusCode, "Error calling SendMail: " + response.ErrorMessage, response.ErrorMessage);
    
            return (GenericResponse) ApiClient.Deserialize(response.Content, typeof(GenericResponse), response.Headers);
        }
    
    }
}
