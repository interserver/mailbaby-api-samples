# GetStats200ResponseInner


## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **int** |  | 
**status** | **str** |  | 
**username** | **str** |  | 
**password** | **str** |  | [optional] 
**comment** | **str** |  | [optional] 

## Example

```python
from openapi_client.models.get_stats200_response_inner import GetStats200ResponseInner

# TODO update the JSON string below
json = "{}"
# create an instance of GetStats200ResponseInner from a JSON string
get_stats200_response_inner_instance = GetStats200ResponseInner.from_json(json)
# print the JSON string representation of the object
print GetStats200ResponseInner.to_json()

# convert the object into a dict
get_stats200_response_inner_dict = get_stats200_response_inner_instance.to_dict()
# create an instance of GetStats200ResponseInner from a dict
get_stats200_response_inner_form_dict = get_stats200_response_inner.from_dict(get_stats200_response_inner_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


