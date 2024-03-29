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
    /// Mail log records
    /// </summary>
    [DataContract]
        public partial class MailLog :  IEquatable<MailLog>, IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="MailLog" /> class.
        /// </summary>
        /// <param name="total">total number of mail log entries (required).</param>
        /// <param name="skip">number of emails skipped in listing (required).</param>
        /// <param name="limit">number of emails to return (required).</param>
        /// <param name="emails">emails (required).</param>
        public MailLog(int? total = default(int?), int? skip = default(int?), int? limit = default(int?), List<MailLogEntry> emails = default(List<MailLogEntry>))
        {
            // to ensure "total" is required (not null)
            if (total == null)
            {
                throw new InvalidDataException("total is a required property for MailLog and cannot be null");
            }
            else
            {
                this.Total = total;
            }
            // to ensure "skip" is required (not null)
            if (skip == null)
            {
                throw new InvalidDataException("skip is a required property for MailLog and cannot be null");
            }
            else
            {
                this.Skip = skip;
            }
            // to ensure "limit" is required (not null)
            if (limit == null)
            {
                throw new InvalidDataException("limit is a required property for MailLog and cannot be null");
            }
            else
            {
                this.Limit = limit;
            }
            // to ensure "emails" is required (not null)
            if (emails == null)
            {
                throw new InvalidDataException("emails is a required property for MailLog and cannot be null");
            }
            else
            {
                this.Emails = emails;
            }
        }
        
        /// <summary>
        /// total number of mail log entries
        /// </summary>
        /// <value>total number of mail log entries</value>
        [DataMember(Name="total", EmitDefaultValue=false)]
        public int? Total { get; set; }

        /// <summary>
        /// number of emails skipped in listing
        /// </summary>
        /// <value>number of emails skipped in listing</value>
        [DataMember(Name="skip", EmitDefaultValue=false)]
        public int? Skip { get; set; }

        /// <summary>
        /// number of emails to return
        /// </summary>
        /// <value>number of emails to return</value>
        [DataMember(Name="limit", EmitDefaultValue=false)]
        public int? Limit { get; set; }

        /// <summary>
        /// Gets or Sets Emails
        /// </summary>
        [DataMember(Name="emails", EmitDefaultValue=false)]
        public List<MailLogEntry> Emails { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class MailLog {\n");
            sb.Append("  Total: ").Append(Total).Append("\n");
            sb.Append("  Skip: ").Append(Skip).Append("\n");
            sb.Append("  Limit: ").Append(Limit).Append("\n");
            sb.Append("  Emails: ").Append(Emails).Append("\n");
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
            return this.Equals(input as MailLog);
        }

        /// <summary>
        /// Returns true if MailLog instances are equal
        /// </summary>
        /// <param name="input">Instance of MailLog to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(MailLog input)
        {
            if (input == null)
                return false;

            return 
                (
                    this.Total == input.Total ||
                    (this.Total != null &&
                    this.Total.Equals(input.Total))
                ) && 
                (
                    this.Skip == input.Skip ||
                    (this.Skip != null &&
                    this.Skip.Equals(input.Skip))
                ) && 
                (
                    this.Limit == input.Limit ||
                    (this.Limit != null &&
                    this.Limit.Equals(input.Limit))
                ) && 
                (
                    this.Emails == input.Emails ||
                    this.Emails != null &&
                    input.Emails != null &&
                    this.Emails.SequenceEqual(input.Emails)
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
                if (this.Total != null)
                    hashCode = hashCode * 59 + this.Total.GetHashCode();
                if (this.Skip != null)
                    hashCode = hashCode * 59 + this.Skip.GetHashCode();
                if (this.Limit != null)
                    hashCode = hashCode * 59 + this.Limit.GetHashCode();
                if (this.Emails != null)
                    hashCode = hashCode * 59 + this.Emails.GetHashCode();
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
