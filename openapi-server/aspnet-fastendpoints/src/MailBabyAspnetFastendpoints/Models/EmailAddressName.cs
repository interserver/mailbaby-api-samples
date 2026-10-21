namespace MailBabyAspnetFastendpoints.Models;


/// <summary>
/// An email contact with an optional display name.  Used in structured address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;, &#x60;replyto&#x60;) in &#x60;SendMailAdv&#x60;.
/// </summary>
public class EmailAddressName 
{
    public string Email { get; set; }
    public string Name { get; set; }
}


