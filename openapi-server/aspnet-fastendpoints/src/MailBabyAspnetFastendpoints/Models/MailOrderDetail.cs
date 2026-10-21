namespace MailBabyAspnetFastendpoints.Models;


/// <summary>
/// Extended mail order record including the current SMTP password.  Returned by &#x60;GET /mail/{id}&#x60;.  The &#x60;username&#x60; and &#x60;password&#x60; fields can be used to authenticate directly against &#x60;relay.mailbaby.net:25&#x60; via SMTP AUTH if you prefer to send via a native SMTP client rather than the REST API.
/// </summary>
public class MailOrderDetail 
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
    public string Password { get; set; }
    public string Comment { get; set; }
}


