using MailBabyAspnetFastendpoints.Models;

namespace MailBabyAspnetFastendpoints.Features;



/// <summary>
/// Create a deny rule to block a sender, domain, destination, or prefix
/// </summary>

public class AddRuleEndpoint : FastEndpoints.Endpoint<AddRuleRequest, GenericResponse>
{
    public override void Configure()
    {
        Post("/mail/rules");
        
        
        AllowAnonymous();
        
        Description(x =>
        {
            x.WithTags("Blocking");
            FastEndpoints.RouteHandlerBuilderExtensions.ProducesProblemFE(x, 400);
            FastEndpoints.RouteHandlerBuilderExtensions.ProducesProblemFE(x, 401);
            FastEndpoints.RouteHandlerBuilderExtensions.ProducesProblemFE(x, 404);
        });

        Summary(s => {
            s.Summary = "Create a deny rule to block a sender, domain, destination, or prefix";
            s.RequestParam(r => r.Type, "The matching strategy for this rule.  &#x60;email&#x60; blocks an exact sender address, &#x60;domain&#x60; blocks all senders at a domain, &#x60;destination&#x60; blocks an exact recipient address, and &#x60;startswith&#x60; blocks any sender whose local-part begins with the given prefix.");
            s.RequestParam(r => r.Data, "The value to match against, interpreted according to &#x60;type&#x60;: a full email address for &#x60;email&#x60;/&#x60;destination&#x60;, a domain name for &#x60;domain&#x60;, or an alphanumeric prefix string for &#x60;startswith&#x60;.");
            s.RequestParam(r => r.User, "Optional SMTP username of the mail order to associate this rule with (e.g. &#x60;mb20682&#x60;).  If omitted the first active order is used.  Valid usernames are the &#x60;username&#x60; values returned by &#x60;GET /mail&#x60;.");
            s.Responses[200] = "Rule created successfully";
            s.Responses[400] = "Bad request — one or more input parameters were missing or invalid.";
            s.Responses[401] = "Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).";
            s.Responses[404] = "The specified resource was not found or does not belong to your account.";
        });
    }

    public override async Task HandleAsync(AddRuleRequest req, CancellationToken ct)
    {
        //Response = new()
        //{
            //...
        //};
        //return Task.CompletedTask;
    }
}


/// <summary>
/// Delete a deny rule by its numeric ruleId
/// </summary>

public class DeleteRuleEndpoint : FastEndpoints.Endpoint<DeleteRuleRequest, GenericResponse>
{
    public override void Configure()
    {
        Delete("/mail/rules/{ruleId}");
        
        
        AllowAnonymous();
        
        Description(x =>
        {
            x.WithTags("Blocking");
            FastEndpoints.RouteHandlerBuilderExtensions.ProducesProblemFE(x, 400);
            FastEndpoints.RouteHandlerBuilderExtensions.ProducesProblemFE(x, 401);
            FastEndpoints.RouteHandlerBuilderExtensions.ProducesProblemFE(x, 404);
        });

        Summary(s => {
            s.Summary = "Delete a deny rule by its numeric ruleId";
            s.RequestParam(r => r.RuleId, "The numeric ID of the deny rule to delete.  Obtain this from the &#x60;id&#x60; field in &#x60;GET /mail/rules&#x60; or the &#x60;text&#x60; field of a &#x60;POST /mail/rules&#x60; response.");
            s.Responses[200] = "Rule deleted successfully";
            s.Responses[400] = "Bad request — one or more input parameters were missing or invalid.";
            s.Responses[401] = "Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).";
            s.Responses[404] = "The specified resource was not found or does not belong to your account.";
        });
    }

    public override async Task HandleAsync(DeleteRuleRequest req, CancellationToken ct)
    {
        //Response = new()
        //{
            //...
        //};
        //return Task.CompletedTask;
    }
}


/// <summary>
/// Delist an email address from the spam-filter block lists
/// </summary>

public class DelistBlockEndpoint : FastEndpoints.Endpoint<DelistBlockRequest, GenericResponse>
{
    public override void Configure()
    {
        Post("/mail/blocks/delete");
        
        
        AllowAnonymous();
        
        Description(x =>
        {
            x.WithTags("Blocking");
            FastEndpoints.RouteHandlerBuilderExtensions.ProducesProblemFE(x, 400);
            FastEndpoints.RouteHandlerBuilderExtensions.ProducesProblemFE(x, 401);
            FastEndpoints.RouteHandlerBuilderExtensions.ProducesProblemFE(x, 404);
        });

        Summary(s => {
            s.Summary = "Delist an email address from the spam-filter block lists";
            s.RequestParam(r => r.emailAddressParam, "");
            s.Responses[200] = "Address successfully delisted";
            s.Responses[400] = "Bad request — one or more input parameters were missing or invalid.";
            s.Responses[401] = "Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).";
            s.Responses[404] = "The specified resource was not found or does not belong to your account.";
        });
    }

    public override async Task HandleAsync(DelistBlockRequest req, CancellationToken ct)
    {
        //Response = new()
        //{
            //...
        //};
        //return Task.CompletedTask;
    }
}


/// <summary>
/// List addresses currently flagged by spam-filter block lists
/// </summary>

public class GetMailBlocksEndpoint : FastEndpoints.EndpointWithoutRequest<MailBlocks>
{
    public override void Configure()
    {
        Get("/mail/blocks");
        
        
        AllowAnonymous();
        
        Description(x =>
        {
            x.WithTags("Blocking");
            FastEndpoints.RouteHandlerBuilderExtensions.ProducesProblemFE(x, 401);
        });

        Summary(s => {
            s.Summary = "List addresses currently flagged by spam-filter block lists";
            s.Responses[200] = "OK";
            s.Responses[401] = "Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).";
        });
    }

    public override async Task HandleAsync(CancellationToken ct)
    {
        //Response = new()
        //{
            //...
        //};
        //return Task.CompletedTask;
    }
}


/// <summary>
/// List custom deny rules (sender / domain / destination / prefix)
/// </summary>

public class GetRulesEndpoint : FastEndpoints.EndpointWithoutRequest<List<DenyRuleRecord>>
{
    public override void Configure()
    {
        Get("/mail/rules");
        
        
        AllowAnonymous();
        
        Description(x =>
        {
            x.WithTags("Blocking");
            FastEndpoints.RouteHandlerBuilderExtensions.ProducesProblemFE(x, 401);
        });

        Summary(s => {
            s.Summary = "List custom deny rules (sender / domain / destination / prefix)";
            s.Responses[200] = "OK";
            s.Responses[401] = "Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).";
        });
    }

    public override async Task HandleAsync(CancellationToken ct)
    {
        //Response = new()
        //{
            //...
        //};
        //return Task.CompletedTask;
    }
}

