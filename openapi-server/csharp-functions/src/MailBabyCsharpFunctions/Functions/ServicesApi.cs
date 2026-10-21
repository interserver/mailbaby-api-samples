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
    public partial class ServicesApi
    { 
        [FunctionName("ServicesApi_GetMailOrderById")]
        public async Task<ActionResult<MailOrderDetail>> _GetMailOrderById([HttpTrigger(AuthorizationLevel.Anonymous, "Get", Route = "mail/{id}")]HttpRequest req, ExecutionContext context, long id)
        {
            var method = this.GetType().GetMethod("GetMailOrderById");
            return method != null
                ? (await ((Task<MailOrderDetail>)method.Invoke(this, new object[] { req, context, id })).ConfigureAwait(false))
                : new StatusCodeResult((int)HttpStatusCode.NotImplemented);
        }

        [FunctionName("ServicesApi_GetMailOrders")]
        public async Task<ActionResult<List<MailOrder>>> _GetMailOrders([HttpTrigger(AuthorizationLevel.Anonymous, "Get", Route = "mail")]HttpRequest req, ExecutionContext context)
        {
            var method = this.GetType().GetMethod("GetMailOrders");
            return method != null
                ? (await ((Task<List<MailOrder>>)method.Invoke(this, new object[] { req, context })).ConfigureAwait(false))
                : new StatusCodeResult((int)HttpStatusCode.NotImplemented);
        }
    }
}
