using System;
using System.Text;
using System.Collections;
using System.Collections.Generic;
using System.Runtime.Serialization;
using Newtonsoft.Json;

namespace IO.Swagger.Model {

  /// <summary>
  /// 
  /// </summary>
  [DataContract]
  public class Body {
    /// <summary>
    /// The Subject of the email
    /// </summary>
    /// <value>The Subject of the email</value>
    [DataMember(Name="subject", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "subject")]
    public string Subject { get; set; }

    /// <summary>
    /// The contents of the email
    /// </summary>
    /// <value>The contents of the email</value>
    [DataMember(Name="body", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "body")]
    public string _Body { get; set; }

    /// <summary>
    /// The email address of who this email will be sent from.
    /// </summary>
    /// <value>The email address of who this email will be sent from.</value>
    [DataMember(Name="from", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "from")]
    public string From { get; set; }

    /// <summary>
    /// The email address of who this email will be sent to.
    /// </summary>
    /// <value>The email address of who this email will be sent to.</value>
    [DataMember(Name="to", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "to")]
    public string To { get; set; }

    /// <summary>
    /// The ID of your mail order this will be sent through.
    /// </summary>
    /// <value>The ID of your mail order this will be sent through.</value>
    [DataMember(Name="id", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "id")]
    public int? Id { get; set; }

    /// <summary>
    /// The name or title of who this email is being sent to.
    /// </summary>
    /// <value>The name or title of who this email is being sent to.</value>
    [DataMember(Name="toName", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "toName")]
    public string ToName { get; set; }

    /// <summary>
    /// The name or title of who this email is being sent from.
    /// </summary>
    /// <value>The name or title of who this email is being sent from.</value>
    [DataMember(Name="fromName", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "fromName")]
    public string FromName { get; set; }


    /// <summary>
    /// Get the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()  {
      var sb = new StringBuilder();
      sb.Append("class Body {\n");
      sb.Append("  Subject: ").Append(Subject).Append("\n");
      sb.Append("  _Body: ").Append(_Body).Append("\n");
      sb.Append("  From: ").Append(From).Append("\n");
      sb.Append("  To: ").Append(To).Append("\n");
      sb.Append("  Id: ").Append(Id).Append("\n");
      sb.Append("  ToName: ").Append(ToName).Append("\n");
      sb.Append("  FromName: ").Append(FromName).Append("\n");
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
