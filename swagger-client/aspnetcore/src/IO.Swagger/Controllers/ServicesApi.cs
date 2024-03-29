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
    public class ServicesApiController : ControllerBase
    { 
        /// <summary>
        /// displays a list of mail service orders
        /// </summary>
        /// <remarks>This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.</remarks>
        /// <response code="200">OK</response>
        /// <response code="401">Unauthorized</response>
        /// <response code="404">Unauthorized</response>
        [HttpGet]
        [Route("/mail")]
        [Authorize(AuthenticationSchemes = ApiKeyAuthenticationHandler.SchemeName)]
        [ValidateModelState]
        [SwaggerOperation("GetMailOrders")]
        [SwaggerResponse(statusCode: 200, type: typeof(List<MailOrder>), description: "OK")]
        [SwaggerResponse(statusCode: 401, type: typeof(ErrorMessage), description: "Unauthorized")]
        [SwaggerResponse(statusCode: 404, type: typeof(ErrorMessage), description: "Unauthorized")]
        public virtual IActionResult GetMailOrders()
        { 
            //TODO: Uncomment the next line to return response 200 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(200, default(List<MailOrder>));

            //TODO: Uncomment the next line to return response 401 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(401, default(ErrorMessage));

            //TODO: Uncomment the next line to return response 404 or use other options such as return this.NotFound(), return this.BadRequest(..), ...
            // return StatusCode(404, default(ErrorMessage));
            string exampleJson = null;
            exampleJson = "[ {\n  \"id\" : 21472,\n  \"status\" : \"active\",\n  \"username\" : \"mb21472\"\n}, {\n  \"id\" : 21472,\n  \"status\" : \"active\",\n  \"username\" : \"mb21472\"\n} ]";
            
                        var example = exampleJson != null
                        ? JsonConvert.DeserializeObject<List<MailOrder>>(exampleJson)
                        : default(List<MailOrder>);            //TODO: Change the data returned
            return new ObjectResult(example);
        }
    }
}
