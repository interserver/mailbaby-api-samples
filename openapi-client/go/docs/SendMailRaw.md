# SendMailRaw

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**RawEmail** | **string** | The complete RFC 822 email message including all headers and the body. Must include at minimum &#x60;From&#x60;, &#x60;To&#x60;, &#x60;Subject&#x60;, &#x60;Date&#x60;, and &#x60;MIME-Version&#x60; headers.  DKIM signatures in the &#x60;DKIM-Signature&#x60; header are transmitted verbatim and will pass verification at the destination. | 
**Id** | Pointer to **int64** | Optional numeric ID of the mail order to use for SMTP authentication. If omitted the first active order on your account is used.  Valid IDs are returned by &#x60;GET /mail&#x60;. | [optional] 

## Methods

### NewSendMailRaw

`func NewSendMailRaw(rawEmail string, ) *SendMailRaw`

NewSendMailRaw instantiates a new SendMailRaw object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewSendMailRawWithDefaults

`func NewSendMailRawWithDefaults() *SendMailRaw`

NewSendMailRawWithDefaults instantiates a new SendMailRaw object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetRawEmail

`func (o *SendMailRaw) GetRawEmail() string`

GetRawEmail returns the RawEmail field if non-nil, zero value otherwise.

### GetRawEmailOk

`func (o *SendMailRaw) GetRawEmailOk() (*string, bool)`

GetRawEmailOk returns a tuple with the RawEmail field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRawEmail

`func (o *SendMailRaw) SetRawEmail(v string)`

SetRawEmail sets RawEmail field to given value.


### GetId

`func (o *SendMailRaw) GetId() int64`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *SendMailRaw) GetIdOk() (*int64, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *SendMailRaw) SetId(v int64)`

SetId sets Id field to given value.

### HasId

`func (o *SendMailRaw) HasId() bool`

HasId returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


