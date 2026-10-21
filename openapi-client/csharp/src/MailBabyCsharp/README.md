# Created with Openapi Generator

<a id="cli"></a>
## Creating the library
Create a config.yaml file similar to what is below, then run the following powershell command to generate the library `java -jar "<path>/openapi-generator/modules/openapi-generator-cli/target/openapi-generator-cli.jar" generate -c config.yaml`

```yaml
generatorName: csharp
inputSpec: /home/sites/mailbaby-mail-api/public/spec/openapi.yaml
outputDir: out

# https://openapi-generator.tech/docs/generators/csharp
additionalProperties:
  packageGuid: '{593715BC-CB78-46C2-8374-39FF34C469F2}'

# https://openapi-generator.tech/docs/integrations/#github-integration
# gitHost:
# gitUserId:
# gitRepoId:

# https://openapi-generator.tech/docs/globals
# globalProperties:

# https://openapi-generator.tech/docs/customization/#inline-schema-naming
# inlineSchemaOptions:

# https://openapi-generator.tech/docs/customization/#name-mapping
# modelNameMappings:
# nameMappings:

# https://openapi-generator.tech/docs/customization/#openapi-normalizer
# openapiNormalizer:

# templateDir: https://openapi-generator.tech/docs/templating/#modifying-templates

# releaseNote:
```

<a id="usage"></a>
## Using the library in your project

```cs
using Microsoft.Extensions.Hosting;
using Microsoft.Extensions.DependencyInjection;
using MailBabyCsharp.Api;
using MailBabyCsharp.Client;
using MailBabyCsharp.Model;
using MailBabyCsharp.Extensions;

namespace YourProject
{
    public class Program
    {
        public static async Task Main(string[] args)
        {
            HostApplicationBuilder builder = Host.CreateApplicationBuilder(args);

            builder.ConfigureApi(options =>
            {
                // The type of token here depends on the api security specifications
                // Available token types are ApiKeyToken, BasicToken, BearerToken, HttpSigningToken, and OAuthToken.
                BearerToken token = new("<your token>");
                options.AddTokens(token);

                // optionally choose the method the tokens will be provided with, default is RateLimitProvider
                options.UseProvider<RateLimitProvider<BearerToken>, BearerToken>();

                options.ConfigureJsonOptions(jsonOptions =>
                {
                    // your custom converters if any
                });

                options.AddApiHttpClients(client =>
                {
                    // client configuration
                }, clientBuilder =>
                {
                    clientBuilder
                        .AddRetryPolicy(2)
                        .AddTimeoutPolicy(TimeSpan.FromSeconds(5))
                        .AddCircuitBreakerPolicy(10, TimeSpan.FromSeconds(30));
                        // add whatever middleware you prefer
                });
            });

            IHost host = builder.Build();
            var api = host.Services.GetRequiredService<IBlockingApi>();
            IAddRuleApiResponse apiResponse = await api.AddRuleAsync("todo");
            GenericResponse? model = apiResponse.Ok();
        }
    }
}
```
<a id="questions"></a>
## Questions

- What about HttpRequest failures and retries?
  Configure Polly in the IHttpClientBuilder
- How are tokens used?
  Tokens are provided by a TokenProvider class. The default is RateLimitProvider which will perform client side rate limiting.
  Other providers can be used with the UseProvider method.
- Does an HttpRequest throw an error when the server response is not Ok?
  It depends how you made the request. If the return type is ApiResponse<T> no error will be thrown, though the Content property will be null.
  StatusCode and ReasonPhrase will contain information about the error.
  If the return type is T, then it will throw. If the return type is TOrDefault, it will return null.
- How do I validate requests and process responses?
  Use the provided On and After partial methods in the api classes.

## Api Information
- appName: MailBaby Email Delivery and Management Service API
- appVersion: 1.5.0
- appDescription: **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.**  # Overview  This is the API interface to the [Mail Baby](https://mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net).  # Mail Orders  Every sending account in MailBaby is backed by a **Mail Order** — a provisioned sending credential with a numeric &#x60;id&#x60; and a corresponding SMTP username (&#x60;mb&lt;id&gt;&#x60;).  Most calls accept an optional &#x60;id&#x60; parameter; when omitted the API automatically selects the first active order on your account. Use &#x60;GET /mail&#x60; to list all orders, and &#x60;GET /mail/{id}&#x60; to inspect a single order including its current SMTP password.  # Sending Email  Three sending methods are available depending on your use-case: | Endpoint | Best for | |- -- -- -- -- -|- -- -- -- -- -| | &#x60;POST /mail/send&#x60; | Simple single-recipient messages | | &#x60;POST /mail/advsend&#x60; | Multiple recipients, CC/BCC, attachments, named contacts | | &#x60;POST /mail/rawsend&#x60; | Pre-built RFC 822 messages (e.g. DKIM-signed payloads) |  After a successful send each endpoint returns a &#x60;GenericResponse&#x60; whose &#x60;text&#x60; field contains the **transaction ID** assigned by the relay.  This ID can later be matched against entries in &#x60;GET /mail/log&#x60; via the &#x60;mailid&#x60; query parameter.  # Filtering &amp; Logs  &#x60;GET /mail/log&#x60; provides paginated access to every message accepted by the relay for your account. Combine any of the query parameters to narrow results — e.g. &#x60;from&#x60;, &#x60;to&#x60;, &#x60;subject&#x60;, &#x60;messageId&#x60;, &#x60;origin&#x60;, &#x60;mx&#x60;, &#x60;startDate&#x60;/&#x60;endDate&#x60;, and &#x60;delivered&#x60;.  # Blocking  Two independent mechanisms exist for suppressing unwanted email: - **Block lists** (&#x60;GET /mail/blocks&#x60;, &#x60;POST /mail/blocks/delete&#x60;) — addresses flagged by the   system spam filters (LOCAL_BL_RCPT / MBTRAP rules in rspamd, and suspicious subjects). - **Deny rules** (&#x60;GET /mail/rules&#x60;, &#x60;POST /mail/rules&#x60;, &#x60;DELETE /mail/rules/{ruleId}&#x60;) —   custom rules you configure to reject specific senders, domains, destination addresses, or   subject-line prefixes before a message is even attempted.   # Authentication  In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. Pass your key in the &#x60;X-API-KEY&#x60; HTTP request header for every protected call. 

## Build
This C# SDK is automatically generated by the [OpenAPI Generator](https://openapi-generator.tech) project.

- SDK version: 1.0.0
- Generator version: 7.26.0
- Build package: org.openapitools.codegen.languages.CSharpClientCodegen
