using System;
using System.Text;
using System.Collections;
using System.Collections.Generic;
using System.Runtime.Serialization;
using Newtonsoft.Json;

namespace IO.Swagger.Model {

  /// <summary>
  /// A file attachment for use with &#x60;POST /mail/advsend&#x60;.  The file content must be base64-encoded.  The &#x60;filename&#x60; is shown to recipients in their email client.
  /// </summary>
  [DataContract]
  public class MailAttachment {
    /// <summary>
    /// The filename shown to recipients (e.g. `report.pdf`, `invoice.xlsx`).
    /// </summary>
    /// <value>The filename shown to recipients (e.g. `report.pdf`, `invoice.xlsx`).</value>
    [DataMember(Name="filename", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "filename")]
    public string Filename { get; set; }

    /// <summary>
    /// The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.
    /// </summary>
    /// <value>The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.</value>
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
