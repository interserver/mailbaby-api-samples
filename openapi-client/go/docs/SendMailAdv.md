# SendMailAdv

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Subject** | **string** | The subject or title of the email | 
**Body** | **string** | The main email contents. | 
**From** | [**EmailAddressTypes**](EmailAddressTypes.md) |  | 
**To** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | 
**Replyto** | Pointer to [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] 
**Cc** | Pointer to [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] 
**Bcc** | Pointer to [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] 
**Attachments** | Pointer to [**[]MailAttachment**](MailAttachment.md) | (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional] 
**Id** | Pointer to **int64** | (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional] 

## Methods

### NewSendMailAdv

`func NewSendMailAdv(subject string, body string, from EmailAddressTypes, to EmailAddressesTypes, ) *SendMailAdv`

NewSendMailAdv instantiates a new SendMailAdv object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewSendMailAdvWithDefaults

`func NewSendMailAdvWithDefaults() *SendMailAdv`

NewSendMailAdvWithDefaults instantiates a new SendMailAdv object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetSubject

`func (o *SendMailAdv) GetSubject() string`

GetSubject returns the Subject field if non-nil, zero value otherwise.

### GetSubjectOk

`func (o *SendMailAdv) GetSubjectOk() (*string, bool)`

GetSubjectOk returns a tuple with the Subject field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSubject

`func (o *SendMailAdv) SetSubject(v string)`

SetSubject sets Subject field to given value.


### GetBody

`func (o *SendMailAdv) GetBody() string`

GetBody returns the Body field if non-nil, zero value otherwise.

### GetBodyOk

`func (o *SendMailAdv) GetBodyOk() (*string, bool)`

GetBodyOk returns a tuple with the Body field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetBody

`func (o *SendMailAdv) SetBody(v string)`

SetBody sets Body field to given value.


### GetFrom

`func (o *SendMailAdv) GetFrom() EmailAddressTypes`

GetFrom returns the From field if non-nil, zero value otherwise.

### GetFromOk

`func (o *SendMailAdv) GetFromOk() (*EmailAddressTypes, bool)`

GetFromOk returns a tuple with the From field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFrom

`func (o *SendMailAdv) SetFrom(v EmailAddressTypes)`

SetFrom sets From field to given value.


### GetTo

`func (o *SendMailAdv) GetTo() EmailAddressesTypes`

GetTo returns the To field if non-nil, zero value otherwise.

### GetToOk

`func (o *SendMailAdv) GetToOk() (*EmailAddressesTypes, bool)`

GetToOk returns a tuple with the To field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTo

`func (o *SendMailAdv) SetTo(v EmailAddressesTypes)`

SetTo sets To field to given value.


### GetReplyto

`func (o *SendMailAdv) GetReplyto() EmailAddressesTypes`

GetReplyto returns the Replyto field if non-nil, zero value otherwise.

### GetReplytoOk

`func (o *SendMailAdv) GetReplytoOk() (*EmailAddressesTypes, bool)`

GetReplytoOk returns a tuple with the Replyto field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetReplyto

`func (o *SendMailAdv) SetReplyto(v EmailAddressesTypes)`

SetReplyto sets Replyto field to given value.

### HasReplyto

`func (o *SendMailAdv) HasReplyto() bool`

HasReplyto returns a boolean if a field has been set.

### GetCc

`func (o *SendMailAdv) GetCc() EmailAddressesTypes`

GetCc returns the Cc field if non-nil, zero value otherwise.

### GetCcOk

`func (o *SendMailAdv) GetCcOk() (*EmailAddressesTypes, bool)`

GetCcOk returns a tuple with the Cc field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCc

`func (o *SendMailAdv) SetCc(v EmailAddressesTypes)`

SetCc sets Cc field to given value.

### HasCc

`func (o *SendMailAdv) HasCc() bool`

HasCc returns a boolean if a field has been set.

### GetBcc

`func (o *SendMailAdv) GetBcc() EmailAddressesTypes`

GetBcc returns the Bcc field if non-nil, zero value otherwise.

### GetBccOk

`func (o *SendMailAdv) GetBccOk() (*EmailAddressesTypes, bool)`

GetBccOk returns a tuple with the Bcc field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetBcc

`func (o *SendMailAdv) SetBcc(v EmailAddressesTypes)`

SetBcc sets Bcc field to given value.

### HasBcc

`func (o *SendMailAdv) HasBcc() bool`

HasBcc returns a boolean if a field has been set.

### GetAttachments

`func (o *SendMailAdv) GetAttachments() []MailAttachment`

GetAttachments returns the Attachments field if non-nil, zero value otherwise.

### GetAttachmentsOk

`func (o *SendMailAdv) GetAttachmentsOk() (*[]MailAttachment, bool)`

GetAttachmentsOk returns a tuple with the Attachments field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAttachments

`func (o *SendMailAdv) SetAttachments(v []MailAttachment)`

SetAttachments sets Attachments field to given value.

### HasAttachments

`func (o *SendMailAdv) HasAttachments() bool`

HasAttachments returns a boolean if a field has been set.

### GetId

`func (o *SendMailAdv) GetId() int64`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *SendMailAdv) GetIdOk() (*int64, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *SendMailAdv) SetId(v int64)`

SetId sets Id field to given value.

### HasId

`func (o *SendMailAdv) HasId() bool`

HasId returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


