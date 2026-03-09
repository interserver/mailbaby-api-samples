using System;
using System.Text;
using System.Collections;
using System.Collections.Generic;
using System.Runtime.Serialization;
using Newtonsoft.Json;

namespace IO.Swagger.Model {

  /// <summary>
  /// Raw Email Object
  /// </summary>
  [DataContract]
  public class SendMailRaw {
    /// <summary>
    /// The entire email contents
    /// </summary>
    /// <value>The entire email contents</value>
    [DataMember(Name="raw_email", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "raw_email")]
    public string RawEmail { get; set; }

    /// <summary>
    /// Optional order id
    /// </summary>
    /// <value>Optional order id</value>
    [DataMember(Name="id", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "id")]
    public int? Id { get; set; }


    /// <summary>
    /// Get the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()  {
      var sb = new StringBuilder();
      sb.Append("class SendMailRaw {\n");
      sb.Append("  RawEmail: ").Append(RawEmail).Append("\n");
      sb.Append("  Id: ").Append(Id).Append("\n");
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
