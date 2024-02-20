using System;
using System.Text;
using System.Collections;
using System.Collections.Generic;
using System.Runtime.Serialization;
using Newtonsoft.Json;

namespace IO.Swagger.Model {

  /// <summary>
  /// Details for an Email
  /// </summary>
  [DataContract]
  public class SendMailAdv {
    /// <summary>
    /// The subject or title of the email
    /// </summary>
    /// <value>The subject or title of the email</value>
    [DataMember(Name="subject", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "subject")]
    public string Subject { get; set; }

    /// <summary>
    /// The main email contents.
    /// </summary>
    /// <value>The main email contents.</value>
    [DataMember(Name="body", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "body")]
    public string Body { get; set; }

    /// <summary>
    /// Gets or Sets From
    /// </summary>
    [DataMember(Name="from", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "from")]
    public EmailAddressTypes From { get; set; }

    /// <summary>
    /// Gets or Sets To
    /// </summary>
    [DataMember(Name="to", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "to")]
    public EmailAddressesTypes To { get; set; }

    /// <summary>
    /// Gets or Sets Replyto
    /// </summary>
    [DataMember(Name="replyto", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "replyto")]
    public EmailAddressesTypes Replyto { get; set; }

    /// <summary>
    /// Gets or Sets Cc
    /// </summary>
    [DataMember(Name="cc", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "cc")]
    public EmailAddressesTypes Cc { get; set; }

    /// <summary>
    /// Gets or Sets Bcc
    /// </summary>
    [DataMember(Name="bcc", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "bcc")]
    public EmailAddressesTypes Bcc { get; set; }

    /// <summary>
    /// (optional) File attachments to include in the email.  The file contents must be base64 encoded!
    /// </summary>
    /// <value>(optional) File attachments to include in the email.  The file contents must be base64 encoded!</value>
    [DataMember(Name="attachments", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "attachments")]
    public List<MailAttachment> Attachments { get; set; }

    /// <summary>
    /// (optional)  ID of the Mail order within our system to use as the Mail Account.
    /// </summary>
    /// <value>(optional)  ID of the Mail order within our system to use as the Mail Account.</value>
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
