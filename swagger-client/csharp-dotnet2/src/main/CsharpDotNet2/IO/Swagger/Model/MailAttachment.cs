using System;
using System.Text;
using System.Collections;
using System.Collections.Generic;
using System.Runtime.Serialization;
using Newtonsoft.Json;

namespace IO.Swagger.Model {

  /// <summary>
  /// A File attachment for an email
  /// </summary>
  [DataContract]
  public class MailAttachment {
    /// <summary>
    /// Optional filename to specify for the attachment.
    /// </summary>
    /// <value>Optional filename to specify for the attachment.</value>
    [DataMember(Name="filename", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "filename")]
    public string Filename { get; set; }

    /// <summary>
    /// Contents of the attached file
    /// </summary>
    /// <value>Contents of the attached file</value>
    [DataMember(Name="data", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "data")]
    public byte[] Data { get; set; }


    /// <summary>
    /// Get the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()  {
      var sb = new StringBuilder();
      sb.Append("class MailAttachment {\n");
      sb.Append("  Filename: ").Append(Filename).Append("\n");
      sb.Append("  Data: ").Append(Data).Append("\n");
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
