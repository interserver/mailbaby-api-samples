# MailOrder
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **Int32** | The unique numeric ID of the mail order.  Used as the &#x60;id&#x60; parameter on sending calls, log queries, and stats queries. | 
**Status** | **String** | The current order status.  Only &#x60;active&#x60; orders can be used for sending. &#x60;canceled&#x60; orders are retained for history but cannot send. | 
**Username** | **String** | The SMTP AUTH username for this order, always in the format &#x60;mb&lt;id&gt;&#x60;. Use together with the password from &#x60;GET /mail/{id}&#x60; to authenticate directly against &#x60;relay.mailbaby.net:25&#x60; if needed. | 
**Comment** | **String** | Optional human-readable note associated with the order. | [optional] 

## Examples

- Prepare the resource
```powershell
$MailOrder = Initialize-PSOpenAPIToolsMailOrder  -Id 21472 `
 -Status active `
 -Username mb21472 `
 -Comment null
```

- Convert the resource to JSON
```powershell
$MailOrder | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

