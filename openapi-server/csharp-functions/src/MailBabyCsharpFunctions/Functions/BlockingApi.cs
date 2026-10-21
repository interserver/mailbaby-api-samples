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
    public partial class BlockingApi
    { 
        [FunctionName("BlockingApi_AddRule")]
        public async Task<ActionResult<GenericResponse>> _AddRule([HttpTrigger(AuthorizationLevel.Anonymous, "Post", Route = "mail/rules")]HttpRequest req, ExecutionContext context)
        {
            var method = this.GetType().GetMethod("AddRule");
            return method != null
                ? (await ((Task<GenericResponse>)method.Invoke(this, new object[] { req, context })).ConfigureAwait(false))
                : new StatusCodeResult((int)HttpStatusCode.NotImplemented);
        }

        [FunctionName("BlockingApi_DeleteRule")]
        public async Task<ActionResult<GenericResponse>> _DeleteRule([HttpTrigger(AuthorizationLevel.Anonymous, "Delete", Route = "mail/rules/{ruleId}")]HttpRequest req, ExecutionContext context, int ruleId)
        {
            var method = this.GetType().GetMethod("DeleteRule");
            return method != null
                ? (await ((Task<GenericResponse>)method.Invoke(this, new object[] { req, context, ruleId })).ConfigureAwait(false))
                : new StatusCodeResult((int)HttpStatusCode.NotImplemented);
        }

        [FunctionName("BlockingApi_DelistBlock")]
        public async Task<ActionResult<GenericResponse>> _DelistBlock([HttpTrigger(AuthorizationLevel.Anonymous, "Post", Route = "mail/blocks/delete")]HttpRequest req, ExecutionContext context)
        {
            var method = this.GetType().GetMethod("DelistBlock");
            return method != null
                ? (await ((Task<GenericResponse>)method.Invoke(this, new object[] { req, context })).ConfigureAwait(false))
                : new StatusCodeResult((int)HttpStatusCode.NotImplemented);
        }

        [FunctionName("BlockingApi_GetMailBlocks")]
        public async Task<ActionResult<MailBlocks>> _GetMailBlocks([HttpTrigger(AuthorizationLevel.Anonymous, "Get", Route = "mail/blocks")]HttpRequest req, ExecutionContext context)
        {
            var method = this.GetType().GetMethod("GetMailBlocks");
            return method != null
                ? (await ((Task<MailBlocks>)method.Invoke(this, new object[] { req, context })).ConfigureAwait(false))
                : new StatusCodeResult((int)HttpStatusCode.NotImplemented);
        }

        [FunctionName("BlockingApi_GetRules")]
        public async Task<ActionResult<List<DenyRuleRecord>>> _GetRules([HttpTrigger(AuthorizationLevel.Anonymous, "Get", Route = "mail/rules")]HttpRequest req, ExecutionContext context)
        {
            var method = this.GetType().GetMethod("GetRules");
            return method != null
                ? (await ((Task<List<DenyRuleRecord>>)method.Invoke(this, new object[] { req, context })).ConfigureAwait(false))
                : new StatusCodeResult((int)HttpStatusCode.NotImplemented);
        }
    }
}
