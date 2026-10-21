namespace MailBabyAspnetFastendpoints.Models;


/// <summary>
/// Request body for &#x60;POST /mail/advsend&#x60;.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;replyto&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;) each accept either a plain RFC 822 string (e.g. &#x60;\&quot;Joe &lt;joe@example.com&gt;\&quot;&#x60; or a comma-separated list) or a structured array of &#x60;{\&quot;email\&quot;: \&quot;...\&quot;, \&quot;name\&quot;: \&quot;...\&quot;}&#x60; objects.  HTML detection is automatic based on whether &#x60;body&#x60; contains HTML tags.
/// </summary>
public class SendMailAdv 
{
    public string Subject { get; set; }
    public string Body { get; set; }
    public EmailAddressTypes From { get; set; }
    public EmailAddressesTypes To { get; set; }
    public EmailAddressesTypes Replyto { get; set; }
    public EmailAddressesTypes Cc { get; set; }
    public EmailAddressesTypes Bcc { get; set; }
    public List<MailAttachment> Attachments { get; set; }
    public long Id { get; set; }
}


