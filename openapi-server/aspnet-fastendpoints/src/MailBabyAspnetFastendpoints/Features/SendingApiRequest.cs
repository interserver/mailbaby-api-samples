
using MailBabyAspnetFastendpoints.Models;

namespace MailBabyAspnetFastendpoints.Features;


public class RawMailRequest
{
    /// <summary>
    /// 
    /// </summary>
    [FastEndpoints.FromBody]
    public SendMailRaw sendMailRaw { get; set; }
}
public class SendAdvMailRequest
{
    /// <summary>
    /// The subject line of the email.
    /// </summary>
    [FastEndpoints.BindFrom("subject")]
    public string Subject { get; set; }
    /// <summary>
    /// The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;.
    /// </summary>
    [FastEndpoints.BindFrom("body")]
    public string Body { get; set; }
    /// <summary>
    /// The sender address.  Accepts a plain email string, an RFC 822 named string (&#x60;\\\&quot;Name &lt;email&gt;\\\&quot;&#x60;), or a &#x60;{\\\&quot;email\\\&quot;: \\\&quot;...\\\&quot;, \\\&quot;name\\\&quot;: \\\&quot;...\\\&quot;}&#x60; object.
    /// </summary>
    [FastEndpoints.BindFrom("from")]
    public EmailAddressTypes From { get; set; }
    /// <summary>
    /// One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.
    /// </summary>
    [FastEndpoints.BindFrom("to")]
    public EmailAddressesTypes To { get; set; }
    /// <summary>
    /// Optional.  One or more addresses to set as the &#x60;Reply-To&#x60; header. When recipients reply to the message their email client will address the reply to these addresses instead of &#x60;from&#x60;.
    /// </summary>
    [FastEndpoints.BindFrom("replyto")]
    public EmailAddressesTypes? Replyto { get; set; }
    /// <summary>
    /// Optional.  Carbon-copy recipients.  These addresses are listed in the &#x60;Cc&#x60; header and are visible to all recipients.
    /// </summary>
    [FastEndpoints.BindFrom("cc")]
    public EmailAddressesTypes? Cc { get; set; }
    /// <summary>
    /// Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.
    /// </summary>
    [FastEndpoints.BindFrom("bcc")]
    public EmailAddressesTypes? Bcc { get; set; }
    /// <summary>
    /// Optional list of file attachments.  Each file must be base64-encoded. Include &#x60;filename&#x60; so recipients see a meaningful attachment name.
    /// </summary>
    [FastEndpoints.BindFrom("attachments")]
    public List<MailAttachment>? Attachments { get; set; }
    /// <summary>
    /// Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;.
    /// </summary>
    [FastEndpoints.BindFrom("id")]
    public long? Id { get; set; }
}
public class SendMailRequest
{
    /// <summary>
    /// 
    /// </summary>
    [FastEndpoints.BindFrom("to")]
    public SendMailTo To { get; set; }
    /// <summary>
    /// The sender address.  This is used as both the &#x60;From&#x60; header and the &#x60;Reply-To&#x60; header automatically.  Must be a valid email address authorized for your mail order.
    /// </summary>
    [FastEndpoints.BindFrom("from")]
    public string From { get; set; }
    /// <summary>
    /// The subject line of the email.
    /// </summary>
    [FastEndpoints.BindFrom("subject")]
    public string Subject { get; set; }
    /// <summary>
    /// The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;.
    /// </summary>
    [FastEndpoints.BindFrom("body")]
    public string Body { get; set; }
    /// <summary>
    /// Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;.
    /// </summary>
    [FastEndpoints.BindFrom("id")]
    public long? Id { get; set; }
}


