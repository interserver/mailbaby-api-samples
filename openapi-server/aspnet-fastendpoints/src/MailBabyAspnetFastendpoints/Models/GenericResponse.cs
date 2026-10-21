namespace MailBabyAspnetFastendpoints.Models;


/// <summary>
/// Standard success response returned by write operations (send, add rule, delete, etc.).  The &#x60;status&#x60; field is always &#x60;\&quot;ok\&quot;&#x60; on success.  The &#x60;text&#x60; field carries operation-specific data — for sending calls it contains the relay transaction ID; for create calls it contains the new record&#39;s ID; for delete calls it contains a confirmation string.
/// </summary>
public class GenericResponse 
{
    public string Status { get; set; }
    public string Text { get; set; }
}


