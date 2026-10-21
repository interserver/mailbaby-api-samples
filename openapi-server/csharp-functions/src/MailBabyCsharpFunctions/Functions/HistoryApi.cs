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
    public partial class HistoryApi
    { 
        [FunctionName("HistoryApi_GetStats")]
        public async Task<ActionResult<MailStatsType>> _GetStats([HttpTrigger(AuthorizationLevel.Anonymous, "Get", Route = "mail/stats")]HttpRequest req, ExecutionContext context)
        {
            var method = this.GetType().GetMethod("GetStats");
            return method != null
                ? (await ((Task<MailStatsType>)method.Invoke(this, new object[] { req, context })).ConfigureAwait(false))
                : new StatusCodeResult((int)HttpStatusCode.NotImplemented);
        }

        [FunctionName("HistoryApi_ViewMailLog")]
        public async Task<ActionResult<MailLog>> _ViewMailLog([HttpTrigger(AuthorizationLevel.Anonymous, "Get", Route = "mail/log")]HttpRequest req, ExecutionContext context)
        {
            var method = this.GetType().GetMethod("ViewMailLog");
            return method != null
                ? (await ((Task<MailLog>)method.Invoke(this, new object[] { req, context })).ConfigureAwait(false))
                : new StatusCodeResult((int)HttpStatusCode.NotImplemented);
        }
    }
}
