# GenericResponse
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Status** | **String** | Always &#x60;&quot;&quot;ok&quot;&quot;&#x60; on success. | [optional] 
**Text** | **String** | Operation-specific result string.  For send operations this is the relay transaction ID (e.g. &#x60;185caa69ff7000f47c&#x60;) which can be used as the &#x60;mailid&#x60; parameter in &#x60;GET /mail/log&#x60;.  For create operations this is the new record&#39;s numeric ID.  For delete operations this is a human-readable confirmation. | [optional] 

## Examples

- Prepare the resource
```powershell
$GenericResponse = Initialize-PSOpenAPIToolsGenericResponse  -Status ok `
 -Text 185caa69ff7000f47c
```

- Convert the resource to JSON
```powershell
$GenericResponse | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

