using System;
using System.Text;
using System.Collections;
using System.Collections.Generic;
using System.Runtime.Serialization;
using Newtonsoft.Json;

namespace IO.Swagger.Model {

  /// <summary>
  /// A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (&#x60;LOCAL_BL_RCPT&#x60; or &#x60;MBTRAP&#x60;). The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.
  /// </summary>
  [DataContract]
  public class MailBlockClickHouse {
    /// <summary>
    /// The date the block event was recorded.
    /// </summary>
    /// <value>The date the block event was recorded.</value>
    [DataMember(Name="date", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "date")]
    public DateTime? Date { get; set; }

    /// <summary>
    /// The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.
    /// </summary>
    /// <value>The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.</value>
    [DataMember(Name="from", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "from")]
    public string From { get; set; }

    /// <summary>
    /// The `Message-ID` header of the blocked message, or `null` if not present.
    /// </summary>
    /// <value>The `Message-ID` header of the blocked message, or `null` if not present.</value>
    [DataMember(Name="messageId", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "messageId")]
    public string MessageId { get; set; }

    /// <summary>
    /// The `Subject` header of the blocked message.
    /// </summary>
    /// <value>The `Subject` header of the blocked message.</value>
    [DataMember(Name="subject", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "subject")]
    public string Subject { get; set; }

    /// <summary>
    /// The serialized list of recipients of the blocked message.
    /// </summary>
    /// <value>The serialized list of recipients of the blocked message.</value>
    [DataMember(Name="to", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "to")]
    public string To { get; set; }


    /// <summary>
    /// Get the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()  {
      var sb = new StringBuilder();
      sb.Append("class MailBlockClickHouse {\n");
      sb.Append("  Date: ").Append(Date).Append("\n");
      sb.Append("  From: ").Append(From).Append("\n");
      sb.Append("  MessageId: ").Append(MessageId).Append("\n");
      sb.Append("  Subject: ").Append(Subject).Append("\n");
      sb.Append("  To: ").Append(To).Append("\n");
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
