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
    public partial class StatusApi
    { 
        [FunctionName("StatusApi_PingServer")]
        public async Task<ActionResult<string>> _PingServer([HttpTrigger(AuthorizationLevel.Anonymous, "Get", Route = "ping")]HttpRequest req, ExecutionContext context)
        {
            var method = this.GetType().GetMethod("PingServer");
            return method != null
                ? (await ((Task<string>)method.Invoke(this, new object[] { req, context })).ConfigureAwait(false))
                : new StatusCodeResult((int)HttpStatusCode.NotImplemented);
        }
    }
}
