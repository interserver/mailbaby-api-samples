package org.openapitools.server.model;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;


/**
 * A file attachment for use with `POST /mail/advsend`.  The file content must be base64-encoded.  The `filename` is shown to recipients in their email client.
 */
public class MailAttachment   {

    private String filename;
    private byte[] data;

    /**
     * Default constructor.
     */
    public MailAttachment() {
    // JSON-B / Jackson
    }

    /**
     * Create MailAttachment.
     *
     * @param filename The filename shown to recipients (e.g. &#x60;report.pdf&#x60;, &#x60;invoice.xlsx&#x60;).
     * @param data The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.
     */
    public MailAttachment(
        String filename, 
        byte[] data
    ) {
        this.filename = filename;
        this.data = data;
    }



    /**
     * The filename shown to recipients (e.g. `report.pdf`, `invoice.xlsx`).
     * @return filename
     */
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.
     * @return data
     */
    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    /**
      * Create a string representation of this pojo.
    **/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MailAttachment {\n");
        
        sb.append("    filename: ").append(toIndentedString(filename)).append("\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
    */
    private static String toIndentedString(Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n    ");
    }
}

