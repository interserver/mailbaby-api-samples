/* 
 * MailBaby Email Delivery and Management Service API
 *
 * **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
 *
 * OpenAPI spec version: 1.1.0
 * Contact: support@interserver.net
 * Generated by: https://github.com/swagger-api/swagger-codegen.git
 */
using System;
using System.Linq;
using System.IO;
using System.Text;
using System.Text.RegularExpressions;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Runtime.Serialization;
using Newtonsoft.Json;
using Newtonsoft.Json.Converters;
using System.ComponentModel.DataAnnotations;
using SwaggerDateConverter = IO.Swagger.Client.SwaggerDateConverter;
namespace IO.Swagger.Model
{
    /// <summary>
    /// An email record
    /// </summary>
    [DataContract]
        public partial class MailLogEntry :  IEquatable<MailLogEntry>, IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="MailLogEntry" /> class.
        /// </summary>
        /// <param name="id">internal db id (required).</param>
        /// <param name="id">mail id (required).</param>
        /// <param name="from">from address (required).</param>
        /// <param name="to">to address (required).</param>
        /// <param name="subject">email subject (required).</param>
        /// <param name="messageId">message id.</param>
        /// <param name="created">creation date (required).</param>
        /// <param name="time">creation timestamp (required).</param>
        /// <param name="user">user account (required).</param>
        /// <param name="transtype">transaction type (required).</param>
        /// <param name="origin">origin ip (required).</param>
        /// <param name="_interface">interface name (required).</param>
        /// <param name="sendingZone">sending zone (required).</param>
        /// <param name="bodySize">email body size in bytes (required).</param>
        /// <param name="seq">index of email in the to adderess list (required).</param>
        /// <param name="recipient">to address this email is being sent to (required).</param>
        /// <param name="domain">to address domain (required).</param>
        /// <param name="locked">locked status (required).</param>
        /// <param name="lockTime">lock timestamp (required).</param>
        /// <param name="assigned">assigned server (required).</param>
        /// <param name="queued">queued timestamp (required).</param>
        /// <param name="mxHostname">mx hostname (required).</param>
        /// <param name="response">mail delivery response (required).</param>
        public MailLogEntry(int? id = default(int?), string id = default(string), string from = default(string), string to = default(string), string subject = default(string), string messageId = default(string), string created = default(string), int? time = default(int?), string user = default(string), string transtype = default(string), string origin = default(string), string _interface = default(string), string sendingZone = default(string), int? bodySize = default(int?), int? seq = default(int?), string recipient = default(string), string domain = default(string), int? locked = default(int?), string lockTime = default(string), string assigned = default(string), string queued = default(string), string mxHostname = default(string), string response = default(string))
        {
            // to ensure "id" is required (not null)
            if (id == null)
            {
                throw new InvalidDataException("id is a required property for MailLogEntry and cannot be null");
            }
            else
            {
                this.Id = id;
            }
            // to ensure "id" is required (not null)
            if (id == null)
            {
                throw new InvalidDataException("id is a required property for MailLogEntry and cannot be null");
            }
            else
            {
                this.Id = id;
            }
            // to ensure "from" is required (not null)
            if (from == null)
            {
                throw new InvalidDataException("from is a required property for MailLogEntry and cannot be null");
            }
            else
            {
                this.From = from;
            }
            // to ensure "to" is required (not null)
            if (to == null)
            {
                throw new InvalidDataException("to is a required property for MailLogEntry and cannot be null");
            }
            else
            {
                this.To = to;
            }
            // to ensure "subject" is required (not null)
            if (subject == null)
            {
                throw new InvalidDataException("subject is a required property for MailLogEntry and cannot be null");
            }
            else
            {
                this.Subject = subject;
            }
            // to ensure "created" is required (not null)
            if (created == null)
            {
                throw new InvalidDataException("created is a required property for MailLogEntry and cannot be null");
            }
            else
            {
                this.Created = created;
            }
            // to ensure "time" is required (not null)
            if (time == null)
            {
                throw new InvalidDataException("time is a required property for MailLogEntry and cannot be null");
            }
            else
            {
                this.Time = time;
            }
            // to ensure "user" is required (not null)
            if (user == null)
            {
                throw new InvalidDataException("user is a required property for MailLogEntry and cannot be null");
            }
            else
            {
                this.User = user;
            }
            // to ensure "transtype" is required (not null)
            if (transtype == null)
            {
                throw new InvalidDataException("transtype is a required property for MailLogEntry and cannot be null");
            }
            else
            {
                this.Transtype = transtype;
            }
            // to ensure "origin" is required (not null)
            if (origin == null)
            {
                throw new InvalidDataException("origin is a required property for MailLogEntry and cannot be null");
            }
            else
            {
                this.Origin = origin;
            }
            // to ensure "_interface" is required (not null)
            if (_interface == null)
            {
                throw new InvalidDataException("_interface is a required property for MailLogEntry and cannot be null");
            }
            else
            {
                this._Interface = _interface;
            }
            // to ensure "sendingZone" is required (not null)
            if (sendingZone == null)
            {
                throw new InvalidDataException("sendingZone is a required property for MailLogEntry and cannot be null");
            }
            else
            {
                this.SendingZone = sendingZone;
            }
            // to ensure "bodySize" is required (not null)
            if (bodySize == null)
            {
                throw new InvalidDataException("bodySize is a required property for MailLogEntry and cannot be null");
            }
            else
            {
                this.BodySize = bodySize;
            }
            // to ensure "seq" is required (not null)
            if (seq == null)
            {
                throw new InvalidDataException("seq is a required property for MailLogEntry and cannot be null");
            }
            else
            {
                this.Seq = seq;
            }
            // to ensure "recipient" is required (not null)
            if (recipient == null)
            {
                throw new InvalidDataException("recipient is a required property for MailLogEntry and cannot be null");
            }
            else
            {
                this.Recipient = recipient;
            }
            // to ensure "domain" is required (not null)
            if (domain == null)
            {
                throw new InvalidDataException("domain is a required property for MailLogEntry and cannot be null");
            }
            else
            {
                this.Domain = domain;
            }
            // to ensure "locked" is required (not null)
            if (locked == null)
            {
                throw new InvalidDataException("locked is a required property for MailLogEntry and cannot be null");
            }
            else
            {
                this.Locked = locked;
            }
            // to ensure "lockTime" is required (not null)
            if (lockTime == null)
            {
                throw new InvalidDataException("lockTime is a required property for MailLogEntry and cannot be null");
            }
            else
            {
                this.LockTime = lockTime;
            }
            // to ensure "assigned" is required (not null)
            if (assigned == null)
            {
                throw new InvalidDataException("assigned is a required property for MailLogEntry and cannot be null");
            }
            else
            {
                this.Assigned = assigned;
            }
            // to ensure "queued" is required (not null)
            if (queued == null)
            {
                throw new InvalidDataException("queued is a required property for MailLogEntry and cannot be null");
            }
            else
            {
                this.Queued = queued;
            }
            // to ensure "mxHostname" is required (not null)
            if (mxHostname == null)
            {
                throw new InvalidDataException("mxHostname is a required property for MailLogEntry and cannot be null");
            }
            else
            {
                this.MxHostname = mxHostname;
            }
            // to ensure "response" is required (not null)
            if (response == null)
            {
                throw new InvalidDataException("response is a required property for MailLogEntry and cannot be null");
            }
            else
            {
                this.Response = response;
            }
            this.MessageId = messageId;
        }
        
        /// <summary>
        /// internal db id
        /// </summary>
        /// <value>internal db id</value>
        [DataMember(Name="_id", EmitDefaultValue=false)]
        public int? Id { get; set; }

        /// <summary>
        /// mail id
        /// </summary>
        /// <value>mail id</value>
        [DataMember(Name="id", EmitDefaultValue=false)]
        public string Id { get; set; }

        /// <summary>
        /// from address
        /// </summary>
        /// <value>from address</value>
        [DataMember(Name="from", EmitDefaultValue=false)]
        public string From { get; set; }

        /// <summary>
        /// to address
        /// </summary>
        /// <value>to address</value>
        [DataMember(Name="to", EmitDefaultValue=false)]
        public string To { get; set; }

        /// <summary>
        /// email subject
        /// </summary>
        /// <value>email subject</value>
        [DataMember(Name="subject", EmitDefaultValue=false)]
        public string Subject { get; set; }

        /// <summary>
        /// message id
        /// </summary>
        /// <value>message id</value>
        [DataMember(Name="messageId", EmitDefaultValue=false)]
        public string MessageId { get; set; }

        /// <summary>
        /// creation date
        /// </summary>
        /// <value>creation date</value>
        [DataMember(Name="created", EmitDefaultValue=false)]
        public string Created { get; set; }

        /// <summary>
        /// creation timestamp
        /// </summary>
        /// <value>creation timestamp</value>
        [DataMember(Name="time", EmitDefaultValue=false)]
        public int? Time { get; set; }

        /// <summary>
        /// user account
        /// </summary>
        /// <value>user account</value>
        [DataMember(Name="user", EmitDefaultValue=false)]
        public string User { get; set; }

        /// <summary>
        /// transaction type
        /// </summary>
        /// <value>transaction type</value>
        [DataMember(Name="transtype", EmitDefaultValue=false)]
        public string Transtype { get; set; }

        /// <summary>
        /// origin ip
        /// </summary>
        /// <value>origin ip</value>
        [DataMember(Name="origin", EmitDefaultValue=false)]
        public string Origin { get; set; }

        /// <summary>
        /// interface name
        /// </summary>
        /// <value>interface name</value>
        [DataMember(Name="interface", EmitDefaultValue=false)]
        public string _Interface { get; set; }

        /// <summary>
        /// sending zone
        /// </summary>
        /// <value>sending zone</value>
        [DataMember(Name="sendingZone", EmitDefaultValue=false)]
        public string SendingZone { get; set; }

        /// <summary>
        /// email body size in bytes
        /// </summary>
        /// <value>email body size in bytes</value>
        [DataMember(Name="bodySize", EmitDefaultValue=false)]
        public int? BodySize { get; set; }

        /// <summary>
        /// index of email in the to adderess list
        /// </summary>
        /// <value>index of email in the to adderess list</value>
        [DataMember(Name="seq", EmitDefaultValue=false)]
        public int? Seq { get; set; }

        /// <summary>
        /// to address this email is being sent to
        /// </summary>
        /// <value>to address this email is being sent to</value>
        [DataMember(Name="recipient", EmitDefaultValue=false)]
        public string Recipient { get; set; }

        /// <summary>
        /// to address domain
        /// </summary>
        /// <value>to address domain</value>
        [DataMember(Name="domain", EmitDefaultValue=false)]
        public string Domain { get; set; }

        /// <summary>
        /// locked status
        /// </summary>
        /// <value>locked status</value>
        [DataMember(Name="locked", EmitDefaultValue=false)]
        public int? Locked { get; set; }

        /// <summary>
        /// lock timestamp
        /// </summary>
        /// <value>lock timestamp</value>
        [DataMember(Name="lockTime", EmitDefaultValue=false)]
        public string LockTime { get; set; }

        /// <summary>
        /// assigned server
        /// </summary>
        /// <value>assigned server</value>
        [DataMember(Name="assigned", EmitDefaultValue=false)]
        public string Assigned { get; set; }

        /// <summary>
        /// queued timestamp
        /// </summary>
        /// <value>queued timestamp</value>
        [DataMember(Name="queued", EmitDefaultValue=false)]
        public string Queued { get; set; }

        /// <summary>
        /// mx hostname
        /// </summary>
        /// <value>mx hostname</value>
        [DataMember(Name="mxHostname", EmitDefaultValue=false)]
        public string MxHostname { get; set; }

        /// <summary>
        /// mail delivery response
        /// </summary>
        /// <value>mail delivery response</value>
        [DataMember(Name="response", EmitDefaultValue=false)]
        public string Response { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
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
            sb.Append("  Recipient: ").Append(Recipient).Append("\n");
            sb.Append("  Domain: ").Append(Domain).Append("\n");
            sb.Append("  Locked: ").Append(Locked).Append("\n");
            sb.Append("  LockTime: ").Append(LockTime).Append("\n");
            sb.Append("  Assigned: ").Append(Assigned).Append("\n");
            sb.Append("  Queued: ").Append(Queued).Append("\n");
            sb.Append("  MxHostname: ").Append(MxHostname).Append("\n");
            sb.Append("  Response: ").Append(Response).Append("\n");
            sb.Append("}\n");
            return sb.ToString();
        }
  
        /// <summary>
        /// Returns the JSON string presentation of the object
        /// </summary>
        /// <returns>JSON string presentation of the object</returns>
        public virtual string ToJson()
        {
            return JsonConvert.SerializeObject(this, Formatting.Indented);
        }

        /// <summary>
        /// Returns true if objects are equal
        /// </summary>
        /// <param name="input">Object to be compared</param>
        /// <returns>Boolean</returns>
        public override bool Equals(object input)
        {
            return this.Equals(input as MailLogEntry);
        }

        /// <summary>
        /// Returns true if MailLogEntry instances are equal
        /// </summary>
        /// <param name="input">Instance of MailLogEntry to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(MailLogEntry input)
        {
            if (input == null)
                return false;

            return 
                (
                    this.Id == input.Id ||
                    (this.Id != null &&
                    this.Id.Equals(input.Id))
                ) && 
                (
                    this.Id == input.Id ||
                    (this.Id != null &&
                    this.Id.Equals(input.Id))
                ) && 
                (
                    this.From == input.From ||
                    (this.From != null &&
                    this.From.Equals(input.From))
                ) && 
                (
                    this.To == input.To ||
                    (this.To != null &&
                    this.To.Equals(input.To))
                ) && 
                (
                    this.Subject == input.Subject ||
                    (this.Subject != null &&
                    this.Subject.Equals(input.Subject))
                ) && 
                (
                    this.MessageId == input.MessageId ||
                    (this.MessageId != null &&
                    this.MessageId.Equals(input.MessageId))
                ) && 
                (
                    this.Created == input.Created ||
                    (this.Created != null &&
                    this.Created.Equals(input.Created))
                ) && 
                (
                    this.Time == input.Time ||
                    (this.Time != null &&
                    this.Time.Equals(input.Time))
                ) && 
                (
                    this.User == input.User ||
                    (this.User != null &&
                    this.User.Equals(input.User))
                ) && 
                (
                    this.Transtype == input.Transtype ||
                    (this.Transtype != null &&
                    this.Transtype.Equals(input.Transtype))
                ) && 
                (
                    this.Origin == input.Origin ||
                    (this.Origin != null &&
                    this.Origin.Equals(input.Origin))
                ) && 
                (
                    this._Interface == input._Interface ||
                    (this._Interface != null &&
                    this._Interface.Equals(input._Interface))
                ) && 
                (
                    this.SendingZone == input.SendingZone ||
                    (this.SendingZone != null &&
                    this.SendingZone.Equals(input.SendingZone))
                ) && 
                (
                    this.BodySize == input.BodySize ||
                    (this.BodySize != null &&
                    this.BodySize.Equals(input.BodySize))
                ) && 
                (
                    this.Seq == input.Seq ||
                    (this.Seq != null &&
                    this.Seq.Equals(input.Seq))
                ) && 
                (
                    this.Recipient == input.Recipient ||
                    (this.Recipient != null &&
                    this.Recipient.Equals(input.Recipient))
                ) && 
                (
                    this.Domain == input.Domain ||
                    (this.Domain != null &&
                    this.Domain.Equals(input.Domain))
                ) && 
                (
                    this.Locked == input.Locked ||
                    (this.Locked != null &&
                    this.Locked.Equals(input.Locked))
                ) && 
                (
                    this.LockTime == input.LockTime ||
                    (this.LockTime != null &&
                    this.LockTime.Equals(input.LockTime))
                ) && 
                (
                    this.Assigned == input.Assigned ||
                    (this.Assigned != null &&
                    this.Assigned.Equals(input.Assigned))
                ) && 
                (
                    this.Queued == input.Queued ||
                    (this.Queued != null &&
                    this.Queued.Equals(input.Queued))
                ) && 
                (
                    this.MxHostname == input.MxHostname ||
                    (this.MxHostname != null &&
                    this.MxHostname.Equals(input.MxHostname))
                ) && 
                (
                    this.Response == input.Response ||
                    (this.Response != null &&
                    this.Response.Equals(input.Response))
                );
        }

        /// <summary>
        /// Gets the hash code
        /// </summary>
        /// <returns>Hash code</returns>
        public override int GetHashCode()
        {
            unchecked // Overflow is fine, just wrap
            {
                int hashCode = 41;
                if (this.Id != null)
                    hashCode = hashCode * 59 + this.Id.GetHashCode();
                if (this.Id != null)
                    hashCode = hashCode * 59 + this.Id.GetHashCode();
                if (this.From != null)
                    hashCode = hashCode * 59 + this.From.GetHashCode();
                if (this.To != null)
                    hashCode = hashCode * 59 + this.To.GetHashCode();
                if (this.Subject != null)
                    hashCode = hashCode * 59 + this.Subject.GetHashCode();
                if (this.MessageId != null)
                    hashCode = hashCode * 59 + this.MessageId.GetHashCode();
                if (this.Created != null)
                    hashCode = hashCode * 59 + this.Created.GetHashCode();
                if (this.Time != null)
                    hashCode = hashCode * 59 + this.Time.GetHashCode();
                if (this.User != null)
                    hashCode = hashCode * 59 + this.User.GetHashCode();
                if (this.Transtype != null)
                    hashCode = hashCode * 59 + this.Transtype.GetHashCode();
                if (this.Origin != null)
                    hashCode = hashCode * 59 + this.Origin.GetHashCode();
                if (this._Interface != null)
                    hashCode = hashCode * 59 + this._Interface.GetHashCode();
                if (this.SendingZone != null)
                    hashCode = hashCode * 59 + this.SendingZone.GetHashCode();
                if (this.BodySize != null)
                    hashCode = hashCode * 59 + this.BodySize.GetHashCode();
                if (this.Seq != null)
                    hashCode = hashCode * 59 + this.Seq.GetHashCode();
                if (this.Recipient != null)
                    hashCode = hashCode * 59 + this.Recipient.GetHashCode();
                if (this.Domain != null)
                    hashCode = hashCode * 59 + this.Domain.GetHashCode();
                if (this.Locked != null)
                    hashCode = hashCode * 59 + this.Locked.GetHashCode();
                if (this.LockTime != null)
                    hashCode = hashCode * 59 + this.LockTime.GetHashCode();
                if (this.Assigned != null)
                    hashCode = hashCode * 59 + this.Assigned.GetHashCode();
                if (this.Queued != null)
                    hashCode = hashCode * 59 + this.Queued.GetHashCode();
                if (this.MxHostname != null)
                    hashCode = hashCode * 59 + this.MxHostname.GetHashCode();
                if (this.Response != null)
                    hashCode = hashCode * 59 + this.Response.GetHashCode();
                return hashCode;
            }
        }

        /// <summary>
        /// To validate all properties of the instance
        /// </summary>
        /// <param name="validationContext">Validation context</param>
        /// <returns>Validation Result</returns>
        IEnumerable<System.ComponentModel.DataAnnotations.ValidationResult> IValidatableObject.Validate(ValidationContext validationContext)
        {
            yield break;
        }
    }
}
