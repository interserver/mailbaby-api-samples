/*
 * Mail Baby API
 *
 * This is an API defintion for accesssing the Mail.Baby mail service.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: detain@interserver.net
 * Generated by: https://github.com/swagger-api/swagger-codegen.git
 */
using System;
using System.Linq;
using System.IO;
using System.Text;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel.DataAnnotations;
using System.Runtime.Serialization;
using Newtonsoft.Json;

namespace IO.Swagger.Models
{ 
    /// <summary>
    /// Details for an Email
    /// </summary>
    [DataContract]
    public partial class SendMail : IEquatable<SendMail>
    { 
        /// <summary>
        /// The Contact whom is the primary recipient of this email.
        /// </summary>
        /// <value>The Contact whom is the primary recipient of this email.</value>
        [Required]
        [DataMember(Name="to")]
        public string To { get; set; }

        /// <summary>
        /// The contact whom is the this email is from.
        /// </summary>
        /// <value>The contact whom is the this email is from.</value>
        [Required]
        [DataMember(Name="from")]
        public string From { get; set; }

        /// <summary>
        /// The subject or title of the email
        /// </summary>
        /// <value>The subject or title of the email</value>
        [Required]
        [DataMember(Name="subject")]
        public string Subject { get; set; }

        /// <summary>
        /// The main email contents.
        /// </summary>
        /// <value>The main email contents.</value>
        [Required]
        [DataMember(Name="body")]
        public string Body { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class SendMail {\n");
            sb.Append("  To: ").Append(To).Append("\n");
            sb.Append("  From: ").Append(From).Append("\n");
            sb.Append("  Subject: ").Append(Subject).Append("\n");
            sb.Append("  Body: ").Append(Body).Append("\n");
            sb.Append("}\n");
            return sb.ToString();
        }

        /// <summary>
        /// Returns the JSON string presentation of the object
        /// </summary>
        /// <returns>JSON string presentation of the object</returns>
        public string ToJson()
        {
            return JsonConvert.SerializeObject(this, Formatting.Indented);
        }

        /// <summary>
        /// Returns true if objects are equal
        /// </summary>
        /// <param name="obj">Object to be compared</param>
        /// <returns>Boolean</returns>
        public override bool Equals(object obj)
        {
            if (ReferenceEquals(null, obj)) return false;
            if (ReferenceEquals(this, obj)) return true;
            return obj.GetType() == GetType() && Equals((SendMail)obj);
        }

        /// <summary>
        /// Returns true if SendMail instances are equal
        /// </summary>
        /// <param name="other">Instance of SendMail to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(SendMail other)
        {
            if (ReferenceEquals(null, other)) return false;
            if (ReferenceEquals(this, other)) return true;

            return 
                (
                    To == other.To ||
                    To != null &&
                    To.Equals(other.To)
                ) && 
                (
                    From == other.From ||
                    From != null &&
                    From.Equals(other.From)
                ) && 
                (
                    Subject == other.Subject ||
                    Subject != null &&
                    Subject.Equals(other.Subject)
                ) && 
                (
                    Body == other.Body ||
                    Body != null &&
                    Body.Equals(other.Body)
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
                var hashCode = 41;
                // Suitable nullity checks etc, of course :)
                    if (To != null)
                    hashCode = hashCode * 59 + To.GetHashCode();
                    if (From != null)
                    hashCode = hashCode * 59 + From.GetHashCode();
                    if (Subject != null)
                    hashCode = hashCode * 59 + Subject.GetHashCode();
                    if (Body != null)
                    hashCode = hashCode * 59 + Body.GetHashCode();
                return hashCode;
            }
        }

        #region Operators
        #pragma warning disable 1591

        public static bool operator ==(SendMail left, SendMail right)
        {
            return Equals(left, right);
        }

        public static bool operator !=(SendMail left, SendMail right)
        {
            return !Equals(left, right);
        }

        #pragma warning restore 1591
        #endregion Operators
    }
}