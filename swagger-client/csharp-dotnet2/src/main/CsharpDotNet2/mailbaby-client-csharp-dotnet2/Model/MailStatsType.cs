using System;
using System.Text;
using System.Collections;
using System.Collections.Generic;
using System.Runtime.Serialization;
using Newtonsoft.Json;

namespace IO.Swagger.Model {

  /// <summary>
  /// Account usage statistics returned by &#x60;GET /mail/stats&#x60;.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.
  /// </summary>
  [DataContract]
  public class MailStatsType {
    /// <summary>
    /// The time window these `received`, `sent`, and `volume` statistics cover.
    /// </summary>
    /// <value>The time window these `received`, `sent`, and `volume` statistics cover.</value>
    [DataMember(Name="time", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "time")]
    public string Time { get; set; }

    /// <summary>
    /// Total messages accepted during the current billing cycle.  Used to calculate the `cost` value.
    /// </summary>
    /// <value>Total messages accepted during the current billing cycle.  Used to calculate the `cost` value.</value>
    [DataMember(Name="usage", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "usage")]
    public int? Usage { get; set; }

    /// <summary>
    /// The ISO 4217 currency code for this account (e.g. `USD`).
    /// </summary>
    /// <value>The ISO 4217 currency code for this account (e.g. `USD`).</value>
    [DataMember(Name="currency", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "currency")]
    public string Currency { get; set; }

    /// <summary>
    /// Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).
    /// </summary>
    /// <value>Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).</value>
    [DataMember(Name="cost", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "cost")]
    public double? Cost { get; set; }

    /// <summary>
    /// Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue.
    /// </summary>
    /// <value>Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue.</value>
    [DataMember(Name="received", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "received")]
    public int? Received { get; set; }

    /// <summary>
    /// Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`.
    /// </summary>
    /// <value>Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`.</value>
    [DataMember(Name="sent", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "sent")]
    public int? Sent { get; set; }

    /// <summary>
    /// Gets or Sets Volume
    /// </summary>
    [DataMember(Name="volume", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "volume")]
    public MailStatsTypeVolume Volume { get; set; }


    /// <summary>
    /// Get the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()  {
      var sb = new StringBuilder();
      sb.Append("class MailStatsType {\n");
      sb.Append("  Time: ").Append(Time).Append("\n");
      sb.Append("  Usage: ").Append(Usage).Append("\n");
      sb.Append("  Currency: ").Append(Currency).Append("\n");
      sb.Append("  Cost: ").Append(Cost).Append("\n");
      sb.Append("  Received: ").Append(Received).Append("\n");
      sb.Append("  Sent: ").Append(Sent).Append("\n");
      sb.Append("  Volume: ").Append(Volume).Append("\n");
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
