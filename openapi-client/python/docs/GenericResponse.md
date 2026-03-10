# GenericResponse

Standard success response returned by write operations (send, add rule, delete, etc.).  The `status` field is always `\"ok\"` on success.  The `text` field carries operation-specific data — for sending calls it contains the relay transaction ID; for create calls it contains the new record's ID; for delete calls it contains a confirmation string.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**status** | **str** | Always &#x60;\&quot;ok\&quot;&#x60; on success. | [optional] 
**text** | **str** | Operation-specific result string.  For send operations this is the relay transaction ID (e.g. &#x60;185caa69ff7000f47c&#x60;) which can be used as the &#x60;mailid&#x60; parameter in &#x60;GET /mail/log&#x60;.  For create operations this is the new record&#39;s numeric ID.  For delete operations this is a human-readable confirmation. | [optional] 

## Example

```python
from openapi_client.models.generic_response import GenericResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GenericResponse from a JSON string
generic_response_instance = GenericResponse.from_json(json)
# print the JSON string representation of the object
print(GenericResponse.to_json())

# convert the object into a dict
generic_response_dict = generic_response_instance.to_dict()
# create an instance of GenericResponse from a dict
generic_response_from_dict = GenericResponse.from_dict(generic_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


