namespace MailBabyAspnetFastendpoints.Models;


/// <summary>
/// A complete deny rule record as returned by &#x60;GET /mail/rules&#x60;.  Combines the rule definition fields (&#x60;DenyRuleNew&#x60;) with server-assigned metadata (&#x60;id&#x60; and &#x60;created&#x60;).  The &#x60;id&#x60; value is required by &#x60;DELETE /mail/rules/{ruleId}&#x60;.
/// </summary>
public class DenyRuleRecord 
{
    
    /// <summary>
    /// The matching strategy for this rule.  `email` blocks an exact sender address, `domain` blocks all senders at a domain, `destination` blocks an exact recipient address, and `startswith` blocks any sender whose local-part begins with the given prefix.
    /// </summary>
    /// <value>The matching strategy for this rule.  `email` blocks an exact sender address, `domain` blocks all senders at a domain, `destination` blocks an exact recipient address, and `startswith` blocks any sender whose local-part begins with the given prefix.</value>
    public enum TypeEnum
    {
        
        /// <summary>
        /// Enum DomainEnum for domain
        /// </summary>
        DomainEnum = 1,
        
        /// <summary>
        /// Enum EmailEnum for email
        /// </summary>
        EmailEnum = 2,
        
        /// <summary>
        /// Enum StartswithEnum for startswith
        /// </summary>
        StartswithEnum = 3,
        
        /// <summary>
        /// Enum DestinationEnum for destination
        /// </summary>
        DestinationEnum = 4,
        
        /// <summary>
        /// Enum UnknownDefaultOpenApiEnum for unknown_default_open_api
        /// </summary>
        UnknownDefaultOpenApiEnum = 5
    }

    public TypeEnum Type { get; set; }
    public string Data { get; set; }
    public string Id { get; set; }
    public DateTime Created { get; set; }
    public string User { get; set; }
}


