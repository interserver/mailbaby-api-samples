# MailBlockClickHouse
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Date** | **System.DateTime** | The date the block event was recorded. | 
**VarFrom** | **String** | The SMTP envelope sender (&#x60;MAIL FROM&#x60;) address of the blocked message. Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist it. | 
**MessageId** | **String** | The &#x60;Message-ID&#x60; header of the blocked message, or &#x60;null&#x60; if not present. | [optional] 
**Subject** | **String** | The &#x60;Subject&#x60; header of the blocked message. | 
**To** | **String** | The serialized list of recipients of the blocked message. | 

## Examples

- Prepare the resource
```powershell
$MailBlockClickHouse = Initialize-PSOpenAPIToolsMailBlockClickHouse  -Date Sun Aug 06 20:00:00 EDT 2023 `
 -VarFrom user@domain.com `
 -MessageId pFaRqFUEWkucjhTuIzYuoAgWU@domain.com `
 -Subject Test Email `
 -To [&#39;client@site.com&#39;]
```

- Convert the resource to JSON
```powershell
$MailBlockClickHouse | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

