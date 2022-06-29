# GetMailOrders200ResponseInner

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **int32** |  | 
**Status** | **string** |  | 
**Username** | **string** |  | 
**Password** | Pointer to **string** |  | [optional] 
**Comment** | Pointer to **string** |  | [optional] 

## Methods

### NewGetMailOrders200ResponseInner

`func NewGetMailOrders200ResponseInner(id int32, status string, username string, ) *GetMailOrders200ResponseInner`

NewGetMailOrders200ResponseInner instantiates a new GetMailOrders200ResponseInner object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewGetMailOrders200ResponseInnerWithDefaults

`func NewGetMailOrders200ResponseInnerWithDefaults() *GetMailOrders200ResponseInner`

NewGetMailOrders200ResponseInnerWithDefaults instantiates a new GetMailOrders200ResponseInner object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *GetMailOrders200ResponseInner) GetId() int32`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *GetMailOrders200ResponseInner) GetIdOk() (*int32, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *GetMailOrders200ResponseInner) SetId(v int32)`

SetId sets Id field to given value.


### GetStatus

`func (o *GetMailOrders200ResponseInner) GetStatus() string`

GetStatus returns the Status field if non-nil, zero value otherwise.

### GetStatusOk

`func (o *GetMailOrders200ResponseInner) GetStatusOk() (*string, bool)`

GetStatusOk returns a tuple with the Status field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStatus

`func (o *GetMailOrders200ResponseInner) SetStatus(v string)`

SetStatus sets Status field to given value.


### GetUsername

`func (o *GetMailOrders200ResponseInner) GetUsername() string`

GetUsername returns the Username field if non-nil, zero value otherwise.

### GetUsernameOk

`func (o *GetMailOrders200ResponseInner) GetUsernameOk() (*string, bool)`

GetUsernameOk returns a tuple with the Username field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUsername

`func (o *GetMailOrders200ResponseInner) SetUsername(v string)`

SetUsername sets Username field to given value.


### GetPassword

`func (o *GetMailOrders200ResponseInner) GetPassword() string`

GetPassword returns the Password field if non-nil, zero value otherwise.

### GetPasswordOk

`func (o *GetMailOrders200ResponseInner) GetPasswordOk() (*string, bool)`

GetPasswordOk returns a tuple with the Password field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPassword

`func (o *GetMailOrders200ResponseInner) SetPassword(v string)`

SetPassword sets Password field to given value.

### HasPassword

`func (o *GetMailOrders200ResponseInner) HasPassword() bool`

HasPassword returns a boolean if a field has been set.

### GetComment

`func (o *GetMailOrders200ResponseInner) GetComment() string`

GetComment returns the Comment field if non-nil, zero value otherwise.

### GetCommentOk

`func (o *GetMailOrders200ResponseInner) GetCommentOk() (*string, bool)`

GetCommentOk returns a tuple with the Comment field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetComment

`func (o *GetMailOrders200ResponseInner) SetComment(v string)`

SetComment sets Comment field to given value.

### HasComment

`func (o *GetMailOrders200ResponseInner) HasComment() bool`

HasComment returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


