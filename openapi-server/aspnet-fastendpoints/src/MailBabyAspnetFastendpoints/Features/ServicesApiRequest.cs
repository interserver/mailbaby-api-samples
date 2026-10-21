
using MailBabyAspnetFastendpoints.Models;

namespace MailBabyAspnetFastendpoints.Features;


public class GetMailOrderByIdRequest
{
    /// <summary>
    /// The numeric ID of the mail order.
    /// </summary>
    [FastEndpoints.BindFrom("id")]
    public long Id { get; set; }
}
public class GetMailOrdersRequest
{
}


