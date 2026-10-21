
# Table `MailAttachment`
(mapped from: MailAttachment)

## Properties
Name | Mapping | SQL Type | Default | Type | Description | Notes
---- | ------- | -------- | ------- | ---- | ----------- | -----
**filename** | filename | text NOT NULL |  | **kotlin.String** | The filename shown to recipients (e.g. &#x60;report.pdf&#x60;, &#x60;invoice.xlsx&#x60;). | 
**data** | data | blob NOT NULL |  | **kotlin.ByteArray** | The file contents as a base64-encoded string.  Decode this to retrieve the original binary file. | 




