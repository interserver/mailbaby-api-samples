# SendMail

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**To** | [**SendMailTo**](SendMailTo.md) |  | 
**From** | **string** | The sender address.  This is used as both the &#x60;From&#x60; header and the &#x60;Reply-To&#x60; header automatically.  Must be a valid email address authorized for your mail order. | 
**Subject** | **string** | The subject line of the email. | 
**Body** | **string** | The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;. | 
**Id** | Pointer to **int64** | Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;. | [optional] 

## Methods

### NewSendMail

`func NewSendMail(to SendMailTo, from string, subject string, body string, ) *SendMail`

NewSendMail instantiates a new SendMail object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewSendMailWithDefaults

`func NewSendMailWithDefaults() *SendMail`

NewSendMailWithDefaults instantiates a new SendMail object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetTo

`func (o *SendMail) GetTo() SendMailTo`

GetTo returns the To field if non-nil, zero value otherwise.

### GetToOk

`func (o *SendMail) GetToOk() (*SendMailTo, bool)`

GetToOk returns a tuple with the To field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTo

`func (o *SendMail) SetTo(v SendMailTo)`

SetTo sets To field to given value.


### GetFrom

`func (o *SendMail) GetFrom() string`

GetFrom returns the From field if non-nil, zero value otherwise.

### GetFromOk

`func (o *SendMail) GetFromOk() (*string, bool)`

GetFromOk returns a tuple with the From field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFrom

`func (o *SendMail) SetFrom(v string)`

SetFrom sets From field to given value.


### GetSubject

`func (o *SendMail) GetSubject() string`

GetSubject returns the Subject field if non-nil, zero value otherwise.

### GetSubjectOk

`func (o *SendMail) GetSubjectOk() (*string, bool)`

GetSubjectOk returns a tuple with the Subject field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSubject

`func (o *SendMail) SetSubject(v string)`

SetSubject sets Subject field to given value.


### GetBody

`func (o *SendMail) GetBody() string`

GetBody returns the Body field if non-nil, zero value otherwise.

### GetBodyOk

`func (o *SendMail) GetBodyOk() (*string, bool)`

GetBodyOk returns a tuple with the Body field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetBody

`func (o *SendMail) SetBody(v string)`

SetBody sets Body field to given value.


### GetId

`func (o *SendMail) GetId() int64`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *SendMail) GetIdOk() (*int64, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *SendMail) SetId(v int64)`

SetId sets Id field to given value.

### HasId

`func (o *SendMail) HasId() bool`

HasId returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


