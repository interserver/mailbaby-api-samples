# EmailAddressesTypes



## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**value** | This is a oneOf model. The value must be exactly one of the following types: String, Vector{EmailAddressName} | A flexible email address list that accepts either a plain RFC 822 string or a structured array of contact objects.  When a string is provided it is parsed as a comma-separated list of RFC 822 addresses (supporting the &#x60;\&quot;Name &lt;email&gt;\&quot;&#x60; and bare &#x60;email&#x60; formats).  When an array is provided each entry must have at least an &#x60;email&#x60; field with an optional &#x60;name&#x60; field. | [optional] 




[[Back to Model list]](../README.md#models) [[Back to API list]](../README.md#api-endpoints) [[Back to README]](../README.md)


