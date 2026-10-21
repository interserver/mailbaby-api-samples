using System;
using System.Text;
using System.Collections;
using System.Collections.Generic;
using System.Runtime.Serialization;
using Newtonsoft.Json;

namespace IO.Swagger.Model {

  /// <summary>
  /// Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.
  /// </summary>
  [DataContract]
  public class MailStatsVolume {
    /// <summary>
    /// Message counts keyed by destination (envelope `to`) email address.
    /// </summary>
    /// <value>Message counts keyed by destination (envelope `to`) email address.</value>
    [DataMember(Name="to", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "to")]
    public Dictionary<string, int?> To { get; set; }

    /// <summary>
    /// Message counts keyed by sender (envelope `from`) email address.
    /// </summary>
    /// <value>Message counts keyed by sender (envelope `from`) email address.</value>
    [DataMember(Name="from", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "from")]
    public Dictionary<string, int?> From { get; set; }

    /// <summary>
    /// Message counts keyed by originating client IP address.
    /// </summary>
    /// <value>Message counts keyed by originating client IP address.</value>
    [DataMember(Name="ip", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "ip")]
    public Dictionary<string, int?> Ip { get; set; }


    /// <summary>
    /// Get the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()  {
      var sb = new StringBuilder();
      sb.Append("class MailStatsVolume {\n");
      sb.Append("  To: ").Append(To).Append("\n");
      sb.Append("  From: ").Append(From).Append("\n");
      sb.Append("  Ip: ").Append(Ip).Append("\n");
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
