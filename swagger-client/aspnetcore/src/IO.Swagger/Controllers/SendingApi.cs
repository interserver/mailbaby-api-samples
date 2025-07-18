/*
 * MailBaby Email Delivery and Management Service API
 *
 * **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
 *
 * OpenAPI spec version: 1.1.0
 * Contact: support@interserver.net
 * Generated by: https://github.com/swagger-api/swagger-codegen.git
 */
using System;
using System.Collections.Generic;
using Microsoft.AspNetCore.Mvc;
using Swashbuckle.AspNetCore.Annotations;
using Swashbuckle.AspNetCore.SwaggerGen;
using Newtonsoft.Json;
using System.ComponentModel.DataAnnotations;
using IO.Swagger.Attributes;
using IO.Swagger.Security;
using Microsoft.AspNetCore.Authorization;
using IO.Swagger.Models;

namespace IO.Swagger.Controllers
{ 
    /// <summary>
    /// 
    /// </summary>
    [ApiController]
    public class SendingApiController : ControllerBase
    { 
        /// <summary>
        /// Sends an Email with Advanced Options
        /// </summary>
        /// <remarks>Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  &#x60;&#x60;&#x60;BasicForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;subject&#x3D;Welcome&#x27; \\ - -data &#x27;body&#x3D;Hello&#x27; \\ - -data from&#x3D;user@domain.com \\ - -data to&#x3D;support@interserver.net &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;subject&#x3D;Welcome&#x27; \\ - -data &#x27;body&#x3D;Hello&#x27; \\ - -data from&#x3D;user@domain.com \\ - -data \&quot;to[0][name]&#x3D;Joe\&quot; \\ - -data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;subject&#x3D;Welcome&#x27; \\ - -data &#x27;body&#x3D;Hello&#x27; \\ - -data from&#x3D;\&quot;Joe &lt;user@domain.com&gt;\&quot; \\ - -data to&#x3D;\&quot;Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;subject&#x3D;Welcome&#x27; \\ - -data &#x27;body&#x3D;Hello&#x27; \\ - -data from&#x3D;user@domain.com \\ - -data \&quot;to&#x3D;support@interserver.net, support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToFullForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;subject&#x3D;Welcome&#x27; \\ - -data &#x27;body&#x3D;Hello&#x27; \\ - -data from&#x3D;user@domain.com \\ - -data \&quot;to&#x3D;Joe &lt;support@interserver.net&gt;, Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToArrayForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;subject&#x3D;Welcome&#x27; \\ - -data &#x27;body&#x3D;Hello&#x27; \\ - -data from&#x3D;user@domain.com \\ - -data \&quot;to[0][name]&#x3D;Joe\&quot; \\ - -data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; \\ - -data \&quot;to[1][name]&#x3D;Joe\&quot; \\ - -data \&quot;to[1][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;BasicJson curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/json&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;user@domain.com\&quot;, \&quot;to\&quot;: \&quot;support@interserver.net\&quot; }&#x27; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayJson curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/json&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: {\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;user@domain.com\&quot;}, \&quot;to\&quot;: [{\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;support@interserver.net\&quot;}] }&#x27; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailJson curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header &#x27;Accept: application/json&#x27; \\ - -header &#x27;Content-Type: application/json&#x27; \\ - -header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ - -data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;Joe &lt;user@domain.com&gt;\&quot;, \&quot;to\&quot;: \&quot;Joe &lt;support@interserver.net&gt;\&quot; }&#x27; &#x60;&#x60;&#x60; </remarks>
        /// <param name="body"></param>
        /// <response code="200">search results matching criteria</response>
        /// <response code="400">Error message when there was a problem with the input parameters.</response>
        /// <response code="401">Unauthorized</response>
        /// <response code="404">The specified resource was not found</response>
        [HttpPost]
        [Route("/mail/advsend")]
        [Authorize(AuthenticationSchemes = ApiKeyAuthenticationHandler.SchemeName)]
        [ValidateModelState]
        [SwaggerOperation("SendAdvMail")]
        [SwaggerResponse(statusCode: 200, type: typeof(GenericResponse), description: "search results matching criteria")]
        [SwaggerResponse(statusCode: 400, type: typeof(ErrorMessage), description: "Error message when there was a problem with the input parameters.")]
        [SwaggerResponse(statusCode: 401, type: typeof(ErrorMessage), description: "Unauthorized")]
        [SwaggerResponse(statusCode: 404, type: typeof(ErrorMessage), description: "The specified resource was not found")]
        public virtual IActionResult SendAdvMail([FromBody]SendMailAdv body)
        { 
            //TODO: Uncomment the next line to return response 200 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(200, default(GenericResponse));

            //TODO: Uncomment the next line to return response 400 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(400, default(ErrorMessage));

            //TODO: Uncomment the next line to return response 401 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(401, default(ErrorMessage));

            //TODO: Uncomment the next line to return response 404 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(404, default(ErrorMessage));
            string exampleJson = null;
            exampleJson = "{\n  \"text\" : \"The command completed successfully.\",\n  \"status\" : \"ok\"\n}";
            
                        var example = exampleJson != null
                        ? JsonConvert.DeserializeObject<GenericResponse>(exampleJson)
                        : default(GenericResponse);            //TODO: Change the data returned
            return new ObjectResult(example);
        }

        /// <summary>
        /// Sends an Email
        /// </summary>
        /// <remarks>Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. </remarks>
        /// <param name="body"></param>
        /// <response code="200">search results matching criteria</response>
        /// <response code="400">Error message when there was a problem with the input parameters.</response>
        /// <response code="401">Unauthorized</response>
        /// <response code="404">The specified resource was not found</response>
        [HttpPost]
        [Route("/mail/send")]
        [Authorize(AuthenticationSchemes = ApiKeyAuthenticationHandler.SchemeName)]
        [ValidateModelState]
        [SwaggerOperation("SendMail")]
        [SwaggerResponse(statusCode: 200, type: typeof(GenericResponse), description: "search results matching criteria")]
        [SwaggerResponse(statusCode: 400, type: typeof(ErrorMessage), description: "Error message when there was a problem with the input parameters.")]
        [SwaggerResponse(statusCode: 401, type: typeof(ErrorMessage), description: "Unauthorized")]
        [SwaggerResponse(statusCode: 404, type: typeof(ErrorMessage), description: "The specified resource was not found")]
        public virtual IActionResult SendMail([FromBody]SendMail body)
        { 
            //TODO: Uncomment the next line to return response 200 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(200, default(GenericResponse));

            //TODO: Uncomment the next line to return response 400 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(400, default(ErrorMessage));

            //TODO: Uncomment the next line to return response 401 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(401, default(ErrorMessage));

            //TODO: Uncomment the next line to return response 404 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(404, default(ErrorMessage));
            string exampleJson = null;
            exampleJson = "{\n  \"text\" : \"The command completed successfully.\",\n  \"status\" : \"ok\"\n}";
            
                        var example = exampleJson != null
                        ? JsonConvert.DeserializeObject<GenericResponse>(exampleJson)
                        : default(GenericResponse);            //TODO: Change the data returned
            return new ObjectResult(example);
        }
    }
}
