
# Table `MailLog`
(mapped from: MailLog)

## Properties
Name | Mapping | SQL Type | Default | Type | Description | Notes
---- | ------- | -------- | ------- | ---- | ----------- | -----
**total** | total | int NOT NULL |  | **kotlin.Int** | Total number of log entries that match the supplied filters, regardless of &#x60;skip&#x60; and &#x60;limit&#x60;.  Use this to calculate the number of pages: &#x60;ceil(total / limit)&#x60;. | 
**skip** | skip | int NOT NULL |  | **kotlin.Int** | The &#x60;skip&#x60; value used for this page (echoed from the request). | 
**limit** | limit | int NOT NULL |  | **kotlin.Int** | The &#x60;limit&#x60; value used for this page (echoed from the request). | 
**emails** | `One-To-Many` | `----` | `----`  | [**kotlin.Array&lt;MailLogEntry&gt;**](MailLogEntry.md) |  | 





# **Table `MailLogMailLogEntry`**
(mapped from: MailLogMailLogEntry)

## Properties
Name | Mapping | SQL Type | Default | Type | Description | Notes
---- | ------- | -------- | ------- | ---- | ----------- | -----
mailLog | mailLog | long | | kotlin.Long | Primary Key | *one*
mailLogEntry | mailLogEntry | long | | kotlin.Long | Foreign Key | *many*



