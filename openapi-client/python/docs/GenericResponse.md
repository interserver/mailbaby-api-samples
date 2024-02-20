# GenericResponse


## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**status** | **str** |  | [optional] 
**text** | **str** |  | [optional] 

## Example

```python
from openapi_client.models.generic_response import GenericResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GenericResponse from a JSON string
generic_response_instance = GenericResponse.from_json(json)
# print the JSON string representation of the object
print GenericResponse.to_json()

# convert the object into a dict
generic_response_dict = generic_response_instance.to_dict()
# create an instance of GenericResponse from a dict
generic_response_form_dict = generic_response.from_dict(generic_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


