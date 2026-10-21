namespace MailBabyAspnetFastendpoints.Models;


/// <summary>
/// The fields required to create a new email deny rule via &#x60;POST /mail/rules&#x60;. The &#x60;type&#x60; controls what &#x60;data&#x60; is matched against: - &#x60;email&#x60; — exact sender address match - &#x60;domain&#x60; — all senders from a domain - &#x60;destination&#x60; — exact recipient address match - &#x60;startswith&#x60; — sender local-part prefix match (alphanumeric + &#x60;+_.-&#x60; only)
/// </summary>
public class DenyRuleNew 
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
    public string User { get; set; }
}


