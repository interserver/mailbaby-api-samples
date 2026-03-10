using System;
using System.Text;
using System.Collections;
using System.Collections.Generic;
using System.Runtime.Serialization;
using Newtonsoft.Json;

namespace IO.Swagger.Model {

  /// <summary>
  /// A single email record in the mail log.  Combines data from the message store (envelope metadata), the queue release table (delivery status and response), and the sender delivery table (MX routing details).  Key field relationships with other API calls: - The &#x60;id&#x60; field matches the &#x60;mailid&#x60; query parameter on &#x60;GET /mail/log&#x60; and   the &#x60;text&#x60; field of a successful send response. - The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist a   flagged sender. - The &#x60;user&#x60; field is the SMTP username (e.g. &#x60;mb5658&#x60;) corresponding to the   &#x60;username&#x60; field in &#x60;GET /mail&#x60; / &#x60;GET /mail/{id}&#x60;.
  /// </summary>
  [DataContract]
  public class MailLogEntry {
    /// <summary>
    /// Internal auto-increment database row ID.  Not meaningful outside the API.
    /// </summary>
    /// <value>Internal auto-increment database row ID.  Not meaningful outside the API.</value>
    [DataMember(Name="_id", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "_id")]
    public int? Id { get; set; }

    /// <summary>
    /// The relay-assigned mail ID (18–19 hex characters).  This is the value returned as `text` by the sending endpoints and accepted as the `mailid` filter on `GET /mail/log`.
    /// </summary>
    /// <value>The relay-assigned mail ID (18–19 hex characters).  This is the value returned as `text` by the sending endpoints and accepted as the `mailid` filter on `GET /mail/log`.</value>
    [DataMember(Name="id", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "id")]
    public string Id { get; set; }

    /// <summary>
    /// SMTP envelope `MAIL FROM` address (may differ from the `From:` header).
    /// </summary>
    /// <value>SMTP envelope `MAIL FROM` address (may differ from the `From:` header).</value>
    [DataMember(Name="from", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "from")]
    public string From { get; set; }

    /// <summary>
    /// SMTP envelope `RCPT TO` address.
    /// </summary>
    /// <value>SMTP envelope `RCPT TO` address.</value>
    [DataMember(Name="to", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "to")]
    public string To { get; set; }

    /// <summary>
    /// The `Subject` header value, if available.
    /// </summary>
    /// <value>The `Subject` header value, if available.</value>
    [DataMember(Name="subject", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "subject")]
    public string Subject { get; set; }

    /// <summary>
    /// The `Message-ID` header value, if present.  Can be used with the `messageId` filter on `GET /mail/log` for subsequent lookups.
    /// </summary>
    /// <value>The `Message-ID` header value, if present.  Can be used with the `messageId` filter on `GET /mail/log` for subsequent lookups.</value>
    [DataMember(Name="messageId", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "messageId")]
    public string MessageId { get; set; }

    /// <summary>
    /// Human-readable creation timestamp in `YYYY-MM-DD HH:MM:SS` format.
    /// </summary>
    /// <value>Human-readable creation timestamp in `YYYY-MM-DD HH:MM:SS` format.</value>
    [DataMember(Name="created", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "created")]
    public string Created { get; set; }

    /// <summary>
    /// Unix timestamp of message acceptance.  Corresponds to the `startDate` and `endDate` filter parameters on `GET /mail/log`.
    /// </summary>
    /// <value>Unix timestamp of message acceptance.  Corresponds to the `startDate` and `endDate` filter parameters on `GET /mail/log`.</value>
    [DataMember(Name="time", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "time")]
    public int? Time { get; set; }

    /// <summary>
    /// The SMTP AUTH username used to submit the message (e.g. `mb5658`). Corresponds to the `username` field in `GET /mail` orders.
    /// </summary>
    /// <value>The SMTP AUTH username used to submit the message (e.g. `mb5658`). Corresponds to the `username` field in `GET /mail` orders.</value>
    [DataMember(Name="user", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "user")]
    public string User { get; set; }

    /// <summary>
    /// SMTP transaction type negotiated with the relay (e.g. `ESMTPSA`).
    /// </summary>
    /// <value>SMTP transaction type negotiated with the relay (e.g. `ESMTPSA`).</value>
    [DataMember(Name="transtype", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "transtype")]
    public string Transtype { get; set; }

    /// <summary>
    /// IP address of the client that submitted the message to the relay. Corresponds to the `origin` filter parameter on `GET /mail/log`.
    /// </summary>
    /// <value>IP address of the client that submitted the message to the relay. Corresponds to the `origin` filter parameter on `GET /mail/log`.</value>
    [DataMember(Name="origin", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "origin")]
    public string Origin { get; set; }

    /// <summary>
    /// Relay interface name that accepted the message (e.g. `feeder`).
    /// </summary>
    /// <value>Relay interface name that accepted the message (e.g. `feeder`).</value>
    [DataMember(Name="interface", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "interface")]
    public string _Interface { get; set; }

    /// <summary>
    /// The sending zone assigned by the relay for outbound delivery.
    /// </summary>
    /// <value>The sending zone assigned by the relay for outbound delivery.</value>
    [DataMember(Name="sendingZone", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "sendingZone")]
    public string SendingZone { get; set; }

    /// <summary>
    /// Size of the message body in bytes.
    /// </summary>
    /// <value>Size of the message body in bytes.</value>
    [DataMember(Name="bodySize", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "bodySize")]
    public int? BodySize { get; set; }

    /// <summary>
    /// Sequence index of this recipient in a multi-recipient message. Starts at 1.
    /// </summary>
    /// <value>Sequence index of this recipient in a multi-recipient message. Starts at 1.</value>
    [DataMember(Name="seq", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "seq")]
    public int? Seq { get; set; }

    /// <summary>
    /// Delivery status flag.  `1` = successfully delivered to destination MX. `0` = queued, deferred, or failed.  `null` = delivery not yet attempted. Corresponds to the `delivered` filter parameter on `GET /mail/log`.
    /// </summary>
    /// <value>Delivery status flag.  `1` = successfully delivered to destination MX. `0` = queued, deferred, or failed.  `null` = delivery not yet attempted. Corresponds to the `delivered` filter parameter on `GET /mail/log`.</value>
    [DataMember(Name="delivered", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "delivered")]
    public int? Delivered { get; set; }

    /// <summary>
    /// The SMTP response string received from the destination MX server upon delivery attempt (e.g. `\"250 2.0.0 Ok queued as C91D83E128C\"`).
    /// </summary>
    /// <value>The SMTP response string received from the destination MX server upon delivery attempt (e.g. `\"250 2.0.0 Ok queued as C91D83E128C\"`).</value>
    [DataMember(Name="response", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "response")]
    public string Response { get; set; }

    /// <summary>
    /// The specific recipient address this delivery record is for.
    /// </summary>
    /// <value>The specific recipient address this delivery record is for.</value>
    [DataMember(Name="recipient", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "recipient")]
    public string Recipient { get; set; }

    /// <summary>
    /// The destination domain.  Corresponds to the `mx` filter parameter (which matches `mxHostname`, not `domain`) on `GET /mail/log`.
    /// </summary>
    /// <value>The destination domain.  Corresponds to the `mx` filter parameter (which matches `mxHostname`, not `domain`) on `GET /mail/log`.</value>
    [DataMember(Name="domain", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "domain")]
    public string Domain { get; set; }

    /// <summary>
    /// Whether the queue entry is currently locked for delivery processing.
    /// </summary>
    /// <value>Whether the queue entry is currently locked for delivery processing.</value>
    [DataMember(Name="locked", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "locked")]
    public int? Locked { get; set; }

    /// <summary>
    /// Millisecond-precision timestamp of the last queue lock acquisition.
    /// </summary>
    /// <value>Millisecond-precision timestamp of the last queue lock acquisition.</value>
    [DataMember(Name="lockTime", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "lockTime")]
    public string LockTime { get; set; }

    /// <summary>
    /// The relay server node assigned to deliver this message.
    /// </summary>
    /// <value>The relay server node assigned to deliver this message.</value>
    [DataMember(Name="assigned", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "assigned")]
    public string Assigned { get; set; }

    /// <summary>
    /// ISO 8601 timestamp when the message was placed into the delivery queue.
    /// </summary>
    /// <value>ISO 8601 timestamp when the message was placed into the delivery queue.</value>
    [DataMember(Name="queued", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "queued")]
    public string Queued { get; set; }

    /// <summary>
    /// The MX hostname the relay connected to for delivery.  Corresponds to the `mx` filter parameter on `GET /mail/log`.
    /// </summary>
    /// <value>The MX hostname the relay connected to for delivery.  Corresponds to the `mx` filter parameter on `GET /mail/log`.</value>
    [DataMember(Name="mxHostname", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "mxHostname")]
    public string MxHostname { get; set; }


    /// <summary>
    /// Get the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()  {
      var sb = new StringBuilder();
      sb.Append("class MailLogEntry {\n");
      sb.Append("  Id: ").Append(Id).Append("\n");
      sb.Append("  Id: ").Append(Id).Append("\n");
      sb.Append("  From: ").Append(From).Append("\n");
      sb.Append("  To: ").Append(To).Append("\n");
      sb.Append("  Subject: ").Append(Subject).Append("\n");
      sb.Append("  MessageId: ").Append(MessageId).Append("\n");
      sb.Append("  Created: ").Append(Created).Append("\n");
      sb.Append("  Time: ").Append(Time).Append("\n");
      sb.Append("  User: ").Append(User).Append("\n");
      sb.Append("  Transtype: ").Append(Transtype).Append("\n");
      sb.Append("  Origin: ").Append(Origin).Append("\n");
      sb.Append("  _Interface: ").Append(_Interface).Append("\n");
      sb.Append("  SendingZone: ").Append(SendingZone).Append("\n");
      sb.Append("  BodySize: ").Append(BodySize).Append("\n");
      sb.Append("  Seq: ").Append(Seq).Append("\n");
      sb.Append("  Delivered: ").Append(Delivered).Append("\n");
      sb.Append("  Response: ").Append(Response).Append("\n");
      sb.Append("  Recipient: ").Append(Recipient).Append("\n");
      sb.Append("  Domain: ").Append(Domain).Append("\n");
      sb.Append("  Locked: ").Append(Locked).Append("\n");
      sb.Append("  LockTime: ").Append(LockTime).Append("\n");
      sb.Append("  Assigned: ").Append(Assigned).Append("\n");
      sb.Append("  Queued: ").Append(Queued).Append("\n");
      sb.Append("  MxHostname: ").Append(MxHostname).Append("\n");
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
