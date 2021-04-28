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
  public class SendMail {
    /// <summary>
    /// The ID of the Mail order within our system to use as the Mail Account.
    /// </summary>
    /// <value>The ID of the Mail order within our system to use as the Mail Account.</value>
    [DataMember(Name="id", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "id")]
    public long? Id { get; set; }

    /// <summary>
    /// Gets or Sets From
    /// </summary>
    [DataMember(Name="from", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "from")]
    public MailContact From { get; set; }

    /// <summary>
    /// The Contact whom is the primary recipient of this email.
    /// </summary>
    /// <value>The Contact whom is the primary recipient of this email.</value>
    [DataMember(Name="to", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "to")]
    public List<MailContact> To { get; set; }

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
    /// Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address.
    /// </summary>
    /// <value>Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address.</value>
    [DataMember(Name="replyto", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "replyto")]
    public List<MailContact> Replyto { get; set; }

    /// <summary>
    /// Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
    /// </summary>
    /// <value>Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.</value>
    [DataMember(Name="cc", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "cc")]
    public List<MailContact> Cc { get; set; }

    /// <summary>
    /// Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
    /// </summary>
    /// <value>Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.</value>
    [DataMember(Name="bcc", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "bcc")]
    public List<MailContact> Bcc { get; set; }

    /// <summary>
    /// Optional file attachments to include in the email
    /// </summary>
    /// <value>Optional file attachments to include in the email</value>
    [DataMember(Name="attachments", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "attachments")]
    public List<MailAttachment> Attachments { get; set; }


    /// <summary>
    /// Get the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()  {
      var sb = new StringBuilder();
      sb.Append("class SendMail {\n");
      sb.Append("  Id: ").Append(Id).Append("\n");
      sb.Append("  From: ").Append(From).Append("\n");
      sb.Append("  To: ").Append(To).Append("\n");
      sb.Append("  Subject: ").Append(Subject).Append("\n");
      sb.Append("  Body: ").Append(Body).Append("\n");
      sb.Append("  Replyto: ").Append(Replyto).Append("\n");
      sb.Append("  Cc: ").Append(Cc).Append("\n");
      sb.Append("  Bcc: ").Append(Bcc).Append("\n");
      sb.Append("  Attachments: ").Append(Attachments).Append("\n");
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
