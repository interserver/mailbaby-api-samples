
using MailBabyAspnetFastendpoints.Models;

namespace MailBabyAspnetFastendpoints.Features;


public class AddRuleRequest
{
    /// <summary>
    /// Optional SMTP username of the mail order to associate this rule with (e.g. &#x60;mb20682&#x60;).  If omitted the first active order is used.  Valid usernames are the &#x60;username&#x60; values returned by &#x60;GET /mail&#x60;.
    /// </summary>
    [FastEndpoints.BindFrom("user")]
    public string? User { get; set; }
    /// <summary>
    /// The matching strategy for this rule.  &#x60;email&#x60; blocks an exact sender address, &#x60;domain&#x60; blocks all senders at a domain, &#x60;destination&#x60; blocks an exact recipient address, and &#x60;startswith&#x60; blocks any sender whose local-part begins with the given prefix.
    /// </summary>
    [FastEndpoints.BindFrom("type")]
    public string Type { get; set; }
    /// <summary>
    /// The value to match against, interpreted according to &#x60;type&#x60;: a full email address for &#x60;email&#x60;/&#x60;destination&#x60;, a domain name for &#x60;domain&#x60;, or an alphanumeric prefix string for &#x60;startswith&#x60;.
    /// </summary>
    [FastEndpoints.BindFrom("data")]
    public string Data { get; set; }
}
public class DeleteRuleRequest
{
    /// <summary>
    /// The numeric ID of the deny rule to delete.  Obtain this from the &#x60;id&#x60; field in &#x60;GET /mail/rules&#x60; or the &#x60;text&#x60; field of a &#x60;POST /mail/rules&#x60; response.
    /// </summary>
    [FastEndpoints.BindFrom("ruleId")]
    public int RuleId { get; set; }
}
public class DelistBlockRequest
{
    /// <summary>
    /// 
    /// </summary>
    [FastEndpoints.FromBody]
    public EmailAddressParam emailAddressParam { get; set; }
}
public class GetMailBlocksRequest
{
}
public class GetRulesRequest
{
}


