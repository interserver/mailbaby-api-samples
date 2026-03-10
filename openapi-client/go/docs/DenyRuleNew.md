# DenyRuleNew

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**User** | Pointer to **string** | Optional SMTP username of the mail order to associate this rule with (e.g. &#x60;mb20682&#x60;).  If omitted the first active order is used.  Valid usernames are the &#x60;username&#x60; values returned by &#x60;GET /mail&#x60;. | [optional] 
**Type** | **string** | The type of deny rule. | 
**Data** | **string** | The value to match against, interpreted according to &#x60;type&#x60;: a full email address for &#x60;email&#x60;/&#x60;destination&#x60;, a domain name for &#x60;domain&#x60;, or an alphanumeric prefix string for &#x60;startswith&#x60;. | 

## Methods

### NewDenyRuleNew

`func NewDenyRuleNew(type_ string, data string, ) *DenyRuleNew`

NewDenyRuleNew instantiates a new DenyRuleNew object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewDenyRuleNewWithDefaults

`func NewDenyRuleNewWithDefaults() *DenyRuleNew`

NewDenyRuleNewWithDefaults instantiates a new DenyRuleNew object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetUser

`func (o *DenyRuleNew) GetUser() string`

GetUser returns the User field if non-nil, zero value otherwise.

### GetUserOk

`func (o *DenyRuleNew) GetUserOk() (*string, bool)`

GetUserOk returns a tuple with the User field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUser

`func (o *DenyRuleNew) SetUser(v string)`

SetUser sets User field to given value.

### HasUser

`func (o *DenyRuleNew) HasUser() bool`

HasUser returns a boolean if a field has been set.

### GetType

`func (o *DenyRuleNew) GetType() string`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *DenyRuleNew) GetTypeOk() (*string, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *DenyRuleNew) SetType(v string)`

SetType sets Type field to given value.


### GetData

`func (o *DenyRuleNew) GetData() string`

GetData returns the Data field if non-nil, zero value otherwise.

### GetDataOk

`func (o *DenyRuleNew) GetDataOk() (*string, bool)`

GetDataOk returns a tuple with the Data field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetData

`func (o *DenyRuleNew) SetData(v string)`

SetData sets Data field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


