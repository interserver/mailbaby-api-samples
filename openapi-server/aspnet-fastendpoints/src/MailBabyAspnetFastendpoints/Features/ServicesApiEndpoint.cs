using MailBabyAspnetFastendpoints.Models;

namespace MailBabyAspnetFastendpoints.Features;



/// <summary>
/// Get one mail order&#39;s full detail including SMTP password
/// </summary>

public class GetMailOrderByIdEndpoint : FastEndpoints.Endpoint<GetMailOrderByIdRequest, MailOrderDetail>
{
    public override void Configure()
    {
        Get("/mail/{id}");
        
        
        AllowAnonymous();
        
        Description(x =>
        {
            x.WithTags("Services");
            FastEndpoints.RouteHandlerBuilderExtensions.ProducesProblemFE(x, 400);
            FastEndpoints.RouteHandlerBuilderExtensions.ProducesProblemFE(x, 401);
            FastEndpoints.RouteHandlerBuilderExtensions.ProducesProblemFE(x, 404);
        });

        Summary(s => {
            s.Summary = "Get one mail order&#39;s full detail including SMTP password";
            s.RequestParam(r => r.Id, "The numeric ID of the mail order.");
            s.Responses[200] = "OK";
            s.Responses[400] = "Bad request — one or more input parameters were missing or invalid.";
            s.Responses[401] = "Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).";
            s.Responses[404] = "The specified resource was not found or does not belong to your account.";
        });
    }

    public override async Task HandleAsync(GetMailOrderByIdRequest req, CancellationToken ct)
    {
        //Response = new()
        //{
            //...
        //};
        //return Task.CompletedTask;
    }
}


/// <summary>
/// List your provisioned mail orders (sending accounts)
/// </summary>

public class GetMailOrdersEndpoint : FastEndpoints.EndpointWithoutRequest<List<MailOrder>>
{
    public override void Configure()
    {
        Get("/mail");
        
        
        AllowAnonymous();
        
        Description(x =>
        {
            x.WithTags("Services");
            FastEndpoints.RouteHandlerBuilderExtensions.ProducesProblemFE(x, 401);
        });

        Summary(s => {
            s.Summary = "List your provisioned mail orders (sending accounts)";
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

