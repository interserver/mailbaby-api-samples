namespace MailBabyAspnetFastendpoints.Models;


/// <summary>
/// A mail service order record.  Each order represents one provisioned sending account with a dedicated SMTP username.  The &#x60;id&#x60; is the numeric identifier used across most API calls.  The &#x60;username&#x60; is always &#x60;mb&lt;id&gt;&#x60; and is the SMTP AUTH username for &#x60;relay.mailbaby.net&#x60;.
/// </summary>
public class MailOrder 
{
    public int Id { get; set; }
    
    /// <summary>
    /// The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.
    /// </summary>
    /// <value>The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.</value>
    public enum StatusEnum
    {
        
        /// <summary>
        /// Enum ActiveEnum for active
        /// </summary>
        ActiveEnum = 1,
        
        /// <summary>
        /// Enum CanceledEnum for canceled
        /// </summary>
        CanceledEnum = 2,
        
        /// <summary>
        /// Enum UnknownDefaultOpenApiEnum for unknown_default_open_api
        /// </summary>
        UnknownDefaultOpenApiEnum = 3
    }

    public StatusEnum Status { get; set; }
    public string Username { get; set; }
    public string Comment { get; set; }
}


