# MailBlockClickHouse

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Date** | **string** | The date the block event was recorded. | 
**From** | **string** | The SMTP envelope sender (&#x60;MAIL FROM&#x60;) address of the blocked message. Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist it. | 
**MessageId** | Pointer to **NullableString** | The &#x60;Message-ID&#x60; header of the blocked message, or &#x60;null&#x60; if not present. | [optional] 
**Subject** | **string** | The &#x60;Subject&#x60; header of the blocked message. | 
**To** | **string** | The serialized list of recipients of the blocked message. | 

## Methods

### NewMailBlockClickHouse

`func NewMailBlockClickHouse(date string, from string, subject string, to string, ) *MailBlockClickHouse`

NewMailBlockClickHouse instantiates a new MailBlockClickHouse object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewMailBlockClickHouseWithDefaults

`func NewMailBlockClickHouseWithDefaults() *MailBlockClickHouse`

NewMailBlockClickHouseWithDefaults instantiates a new MailBlockClickHouse object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetDate

`func (o *MailBlockClickHouse) GetDate() string`

GetDate returns the Date field if non-nil, zero value otherwise.

### GetDateOk

`func (o *MailBlockClickHouse) GetDateOk() (*string, bool)`

GetDateOk returns a tuple with the Date field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDate

`func (o *MailBlockClickHouse) SetDate(v string)`

SetDate sets Date field to given value.


### GetFrom

`func (o *MailBlockClickHouse) GetFrom() string`

GetFrom returns the From field if non-nil, zero value otherwise.

### GetFromOk

`func (o *MailBlockClickHouse) GetFromOk() (*string, bool)`

GetFromOk returns a tuple with the From field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFrom

`func (o *MailBlockClickHouse) SetFrom(v string)`

SetFrom sets From field to given value.


### GetMessageId

`func (o *MailBlockClickHouse) GetMessageId() string`

GetMessageId returns the MessageId field if non-nil, zero value otherwise.

### GetMessageIdOk

`func (o *MailBlockClickHouse) GetMessageIdOk() (*string, bool)`

GetMessageIdOk returns a tuple with the MessageId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMessageId

`func (o *MailBlockClickHouse) SetMessageId(v string)`

SetMessageId sets MessageId field to given value.

### HasMessageId

`func (o *MailBlockClickHouse) HasMessageId() bool`

HasMessageId returns a boolean if a field has been set.

### SetMessageIdNil

`func (o *MailBlockClickHouse) SetMessageIdNil(b bool)`

 SetMessageIdNil sets the value for MessageId to be an explicit nil

### UnsetMessageId
`func (o *MailBlockClickHouse) UnsetMessageId()`

UnsetMessageId ensures that no value is present for MessageId, not even an explicit nil
### GetSubject

`func (o *MailBlockClickHouse) GetSubject() string`

GetSubject returns the Subject field if non-nil, zero value otherwise.

### GetSubjectOk

`func (o *MailBlockClickHouse) GetSubjectOk() (*string, bool)`

GetSubjectOk returns a tuple with the Subject field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSubject

`func (o *MailBlockClickHouse) SetSubject(v string)`

SetSubject sets Subject field to given value.


### GetTo

`func (o *MailBlockClickHouse) GetTo() string`

GetTo returns the To field if non-nil, zero value otherwise.

### GetToOk

`func (o *MailBlockClickHouse) GetToOk() (*string, bool)`

GetToOk returns a tuple with the To field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTo

`func (o *MailBlockClickHouse) SetTo(v string)`

SetTo sets To field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


