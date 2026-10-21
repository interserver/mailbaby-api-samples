using MailBabyAspnetFastendpoints.Models;

namespace MailBabyAspnetFastendpoints.Features;



/// <summary>
/// Send a pre-built RFC 822 message verbatim (preserves DKIM)
/// </summary>

public class RawMailEndpoint : FastEndpoints.Endpoint<RawMailRequest, GenericResponse>
{
    public override void Configure()
    {
        Post("/mail/rawsend");
        
        
        AllowAnonymous();
        
        Description(x =>
        {
            x.WithTags("Sending");
            FastEndpoints.RouteHandlerBuilderExtensions.ProducesProblemFE(x, 400);
            FastEndpoints.RouteHandlerBuilderExtensions.ProducesProblemFE(x, 401);
            FastEndpoints.RouteHandlerBuilderExtensions.ProducesProblemFE(x, 404);
        });

        Summary(s => {
            s.Summary = "Send a pre-built RFC 822 message verbatim (preserves DKIM)";
            s.RequestParam(r => r.sendMailRaw, "");
            s.Responses[200] = "Email accepted for delivery";
            s.Responses[400] = "Bad request — one or more input parameters were missing or invalid.";
            s.Responses[401] = "Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).";
            s.Responses[404] = "The specified resource was not found or does not belong to your account.";
        });
    }

    public override async Task HandleAsync(RawMailRequest req, CancellationToken ct)
    {
        //Response = new()
        //{
            //...
        //};
        //return Task.CompletedTask;
    }
}


/// <summary>
/// Send email with multiple recipients, CC/BCC, attachments, named contacts
/// </summary>

public class SendAdvMailEndpoint : FastEndpoints.Endpoint<SendAdvMailRequest, GenericResponse>
{
    public override void Configure()
    {
        Post("/mail/advsend");
        
        
        AllowAnonymous();
        
        Description(x =>
        {
            x.WithTags("Sending");
            FastEndpoints.RouteHandlerBuilderExtensions.ProducesProblemFE(x, 400);
            FastEndpoints.RouteHandlerBuilderExtensions.ProducesProblemFE(x, 401);
            FastEndpoints.RouteHandlerBuilderExtensions.ProducesProblemFE(x, 404);
        });

        Summary(s => {
            s.Summary = "Send email with multiple recipients, CC/BCC, attachments, named contacts";
            s.RequestParam(r => r.Subject, "The subject line of the email.");
            s.RequestParam(r => r.Body, "The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;.");
            s.RequestParam(r => r.From, "The sender address.  Accepts a plain email string, an RFC 822 named string (&#x60;\\\&quot;Name &lt;email&gt;\\\&quot;&#x60;), or a &#x60;{\\\&quot;email\\\&quot;: \\\&quot;...\\\&quot;, \\\&quot;name\\\&quot;: \\\&quot;...\\\&quot;}&#x60; object.");
            s.RequestParam(r => r.To, "One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.");
            s.RequestParam(r => r.Replyto, "Optional.  One or more addresses to set as the &#x60;Reply-To&#x60; header. When recipients reply to the message their email client will address the reply to these addresses instead of &#x60;from&#x60;.");
            s.RequestParam(r => r.Cc, "Optional.  Carbon-copy recipients.  These addresses are listed in the &#x60;Cc&#x60; header and are visible to all recipients.");
            s.RequestParam(r => r.Bcc, "Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.");
            s.RequestParam(r => r.Attachments, "Optional list of file attachments.  Each file must be base64-encoded. Include &#x60;filename&#x60; so recipients see a meaningful attachment name.");
            s.RequestParam(r => r.Id, "Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;.");
            s.Responses[200] = "Email accepted for delivery";
            s.Responses[400] = "Bad request — one or more input parameters were missing or invalid.";
            s.Responses[401] = "Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).";
            s.Responses[404] = "The specified resource was not found or does not belong to your account.";
        });
    }

    public override async Task HandleAsync(SendAdvMailRequest req, CancellationToken ct)
    {
        //Response = new()
        //{
            //...
        //};
        //return Task.CompletedTask;
    }
}


/// <summary>
/// Send a simple email (single recipient, plain or HTML)
/// </summary>

public class SendMailEndpoint : FastEndpoints.Endpoint<SendMailRequest, GenericResponse>
{
    public override void Configure()
    {
        Post("/mail/send");
        
        
        AllowAnonymous();
        
        Description(x =>
        {
            x.WithTags("Sending");
            FastEndpoints.RouteHandlerBuilderExtensions.ProducesProblemFE(x, 400);
            FastEndpoints.RouteHandlerBuilderExtensions.ProducesProblemFE(x, 401);
            FastEndpoints.RouteHandlerBuilderExtensions.ProducesProblemFE(x, 404);
        });

        Summary(s => {
            s.Summary = "Send a simple email (single recipient, plain or HTML)";
            s.RequestParam(r => r.To, "");
            s.RequestParam(r => r.From, "The sender address.  This is used as both the &#x60;From&#x60; header and the &#x60;Reply-To&#x60; header automatically.  Must be a valid email address authorized for your mail order.");
            s.RequestParam(r => r.Subject, "The subject line of the email.");
            s.RequestParam(r => r.Body, "The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;.");
            s.RequestParam(r => r.Id, "Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;.");
            s.Responses[200] = "Email accepted for delivery";
            s.Responses[400] = "Bad request — one or more input parameters were missing or invalid.";
            s.Responses[401] = "Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).";
            s.Responses[404] = "The specified resource was not found or does not belong to your account.";
        });
    }

    public override async Task HandleAsync(SendMailRequest req, CancellationToken ct)
    {
        //Response = new()
        //{
            //...
        //};
        //return Task.CompletedTask;
    }
}

