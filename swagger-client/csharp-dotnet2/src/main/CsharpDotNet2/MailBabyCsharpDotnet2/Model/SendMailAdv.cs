using System;
using System.Text;
using System.Collections;
using System.Collections.Generic;
using System.Runtime.Serialization;
using Newtonsoft.Json;

namespace IO.Swagger.Model {

  /// <summary>
  /// Request body for &#x60;POST /mail/advsend&#x60;.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;replyto&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;) each accept either a plain RFC 822 string (e.g. &#x60;\&quot;Joe &lt;joe@example.com&gt;\&quot;&#x60; or a comma-separated list) or a structured array of &#x60;{\&quot;email\&quot;: \&quot;...\&quot;, \&quot;name\&quot;: \&quot;...\&quot;}&#x60; objects.  HTML detection is automatic based on whether &#x60;body&#x60; contains HTML tags.
  /// </summary>
  [DataContract]
  public class SendMailAdv {
    /// <summary>
    /// The subject line of the email.
    /// </summary>
    /// <value>The subject line of the email.</value>
    [DataMember(Name="subject", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "subject")]
    public string Subject { get; set; }

    /// <summary>
    /// The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
    /// </summary>
    /// <value>The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.</value>
    [DataMember(Name="body", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "body")]
    public string Body { get; set; }

    /// <summary>
    /// The sender address.  Accepts a plain email string, an RFC 822 named string (`\"Name <email>\"`), or a `{\"email\": \"...\", \"name\": \"...\"}` object.
    /// </summary>
    /// <value>The sender address.  Accepts a plain email string, an RFC 822 named string (`\"Name <email>\"`), or a `{\"email\": \"...\", \"name\": \"...\"}` object.</value>
    [DataMember(Name="from", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "from")]
    public AllOfSendMailAdvFrom From { get; set; }

    /// <summary>
    /// One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.
    /// </summary>
    /// <value>One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.</value>
    [DataMember(Name="to", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "to")]
    public AllOfSendMailAdvTo To { get; set; }

    /// <summary>
    /// Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`.
    /// </summary>
    /// <value>Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`.</value>
    [DataMember(Name="replyto", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "replyto")]
    public AllOfSendMailAdvReplyto Replyto { get; set; }

    /// <summary>
    /// Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients.
    /// </summary>
    /// <value>Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients.</value>
    [DataMember(Name="cc", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "cc")]
    public AllOfSendMailAdvCc Cc { get; set; }

    /// <summary>
    /// Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.
    /// </summary>
    /// <value>Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.</value>
    [DataMember(Name="bcc", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "bcc")]
    public AllOfSendMailAdvBcc Bcc { get; set; }

    /// <summary>
    /// Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.
    /// </summary>
    /// <value>Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.</value>
    [DataMember(Name="attachments", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "attachments")]
    public List<MailAttachment> Attachments { get; set; }

    /// <summary>
    /// Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
    /// </summary>
    /// <value>Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.</value>
    [DataMember(Name="id", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "id")]
    public long? Id { get; set; }


    /// <summary>
    /// Get the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()  {
      var sb = new StringBuilder();
      sb.Append("class SendMailAdv {\n");
      sb.Append("  Subject: ").Append(Subject).Append("\n");
      sb.Append("  Body: ").Append(Body).Append("\n");
      sb.Append("  From: ").Append(From).Append("\n");
      sb.Append("  To: ").Append(To).Append("\n");
      sb.Append("  Replyto: ").Append(Replyto).Append("\n");
      sb.Append("  Cc: ").Append(Cc).Append("\n");
      sb.Append("  Bcc: ").Append(Bcc).Append("\n");
      sb.Append("  Attachments: ").Append(Attachments).Append("\n");
      sb.Append("  Id: ").Append(Id).Append("\n");
      sb.Append("}\n");
      return sb.ToString();
    }

    /// <summary>
    /// Get the JSON string presentation of the object
    /// </summary>
    /// <returns>JSON string presentation of the object</returns>
    public string ToJson() {
      return JsonConvert.SerializeObject(this, Formatting.Indented);
    }

}
}
