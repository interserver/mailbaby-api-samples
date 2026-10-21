using MailBabyAspnetFastendpoints.Models;

namespace MailBabyAspnetFastendpoints.Features;



/// <summary>
/// Health check — verify the API is reachable
/// </summary>

public class PingServerEndpoint : FastEndpoints.EndpointWithoutRequest<string>
{
    public override void Configure()
    {
        Get("/ping");
        
        
        AllowAnonymous();
        
        Description(x =>
        {
            x.WithTags("Status");
            FastEndpoints.RouteHandlerBuilderExtensions.ProducesProblemFE(x, 0);
        });

        Summary(s => {
            s.Summary = "Health check — verify the API is reachable";
            s.Responses[200] = "Server is up and running";
            s.Responses[0] = "Something is wrong";
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

