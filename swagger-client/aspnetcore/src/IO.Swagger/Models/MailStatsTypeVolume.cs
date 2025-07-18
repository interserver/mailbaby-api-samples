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
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel.DataAnnotations;
using System.Runtime.Serialization;
using Newtonsoft.Json;

namespace IO.Swagger.Models
{
    /// <summary>
    /// 
    /// </summary>
    [DataContract]
    public partial class MailStatsTypeVolume : IEquatable<MailStatsTypeVolume>
    { 
        /// <summary>
        /// Gets or Sets To
        /// </summary>

        [DataMember(Name="to")]
        public MailStatsTypeVolumeTo To { get; set; }

        /// <summary>
        /// Gets or Sets From
        /// </summary>

        [DataMember(Name="from")]
        public MailStatsTypeVolumeFrom From { get; set; }

        /// <summary>
        /// Gets or Sets Ip
        /// </summary>

        [DataMember(Name="ip")]
        public MailStatsTypeVolumeIp Ip { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class MailStatsTypeVolume {\n");
            sb.Append("  To: ").Append(To).Append("\n");
            sb.Append("  From: ").Append(From).Append("\n");
            sb.Append("  Ip: ").Append(Ip).Append("\n");
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
            return obj.GetType() == GetType() && Equals((MailStatsTypeVolume)obj);
        }

        /// <summary>
        /// Returns true if MailStatsTypeVolume instances are equal
        /// </summary>
        /// <param name="other">Instance of MailStatsTypeVolume to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(MailStatsTypeVolume other)
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
                    Ip == other.Ip ||
                    Ip != null &&
                    Ip.Equals(other.Ip)
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
                    if (Ip != null)
                    hashCode = hashCode * 59 + Ip.GetHashCode();
                return hashCode;
            }
        }

        #region Operators
        #pragma warning disable 1591

        public static bool operator ==(MailStatsTypeVolume left, MailStatsTypeVolume right)
        {
            return Equals(left, right);
        }

        public static bool operator !=(MailStatsTypeVolume left, MailStatsTypeVolume right)
        {
            return !Equals(left, right);
        }

        #pragma warning restore 1591
        #endregion Operators
    }
}
