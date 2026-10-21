using System.IO;
using System.Net;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Azure.WebJobs;
using Microsoft.Azure.WebJobs.Extensions.Http;
using Microsoft.Azure.WebJobs.Extensions.OpenApi.Core.Attributes;
using Microsoft.Azure.WebJobs.Extensions.OpenApi.Core.Enums;
using Microsoft.Extensions.Logging;
using Microsoft.OpenApi.Models;
using Newtonsoft.Json;
using Org.OpenAPITools.Models;

namespace MailBabyCsharpFunctions.Functions
{ 
    public partial class SendingApi
    { 
        [FunctionName("SendingApi_RawMail")]
        public async Task<ActionResult<GenericResponse>> _RawMail([HttpTrigger(AuthorizationLevel.Anonymous, "Post", Route = "mail/rawsend")]HttpRequest req, ExecutionContext context)
        {
            var method = this.GetType().GetMethod("RawMail");
            return method != null
                ? (await ((Task<GenericResponse>)method.Invoke(this, new object[] { req, context })).ConfigureAwait(false))
                : new StatusCodeResult((int)HttpStatusCode.NotImplemented);
        }

        [FunctionName("SendingApi_SendAdvMail")]
        public async Task<ActionResult<GenericResponse>> _SendAdvMail([HttpTrigger(AuthorizationLevel.Anonymous, "Post", Route = "mail/advsend")]HttpRequest req, ExecutionContext context)
        {
            var method = this.GetType().GetMethod("SendAdvMail");
            return method != null
                ? (await ((Task<GenericResponse>)method.Invoke(this, new object[] { req, context })).ConfigureAwait(false))
                : new StatusCodeResult((int)HttpStatusCode.NotImplemented);
        }

        [FunctionName("SendingApi_SendMail")]
        public async Task<ActionResult<GenericResponse>> _SendMail([HttpTrigger(AuthorizationLevel.Anonymous, "Post", Route = "mail/send")]HttpRequest req, ExecutionContext context)
        {
            var method = this.GetType().GetMethod("SendMail");
            return method != null
                ? (await ((Task<GenericResponse>)method.Invoke(this, new object[] { req, context })).ConfigureAwait(false))
                : new StatusCodeResult((int)HttpStatusCode.NotImplemented);
        }
    }
}
