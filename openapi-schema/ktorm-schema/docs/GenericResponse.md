
# Table `GenericResponse`
(mapped from: GenericResponse)

## Properties
Name | Mapping | SQL Type | Default | Type | Description | Notes
---- | ------- | -------- | ------- | ---- | ----------- | -----
**status** | status | text NOT NULL |  | **kotlin.String** | Always &#x60;\&quot;ok\&quot;&#x60; on success. | 
**text** | text | text NOT NULL |  | **kotlin.String** | Operation-specific result string.  For send operations this is the relay transaction ID (e.g. &#x60;185caa69ff7000f47c&#x60;) which can be used as the &#x60;mailid&#x60; parameter in &#x60;GET /mail/log&#x60;.  For create operations this is the new record&#39;s numeric ID.  For delete operations this is a human-readable confirmation. | 




