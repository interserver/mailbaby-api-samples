# SendMail

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **int64** | The ID of the Mail order within our system to use as the Mail Account. | 
**From** | [**MailContact**](MailContact.md) |  | 
**To** | [**[]MailContact**](MailContact.md) | The Contact whom is the primary recipient of this email. | 
**Subject** | **string** | The subject or title of the email | 
**Body** | **string** | The main email contents. | 
**Replyto** | Pointer to [**[]MailContact**](MailContact.md) | Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address. | [optional] 
**Cc** | Pointer to [**[]MailContact**](MailContact.md) | Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional] 
**Bcc** | Pointer to [**[]MailContact**](MailContact.md) | Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional] 
**Attachments** | Pointer to [**[]MailAttachment**](MailAttachment.md) | Optional file attachments to include in the email | [optional] 

## Methods

### NewSendMail

`func NewSendMail(id int64, from MailContact, to []MailContact, subject string, body string, ) *SendMail`

NewSendMail instantiates a new SendMail object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewSendMailWithDefaults

`func NewSendMailWithDefaults() *SendMail`

NewSendMailWithDefaults instantiates a new SendMail object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

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


### GetFrom

`func (o *SendMail) GetFrom() MailContact`

GetFrom returns the From field if non-nil, zero value otherwise.

### GetFromOk

`func (o *SendMail) GetFromOk() (*MailContact, bool)`

GetFromOk returns a tuple with the From field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFrom

`func (o *SendMail) SetFrom(v MailContact)`

SetFrom sets From field to given value.


### GetTo

`func (o *SendMail) GetTo() []MailContact`

GetTo returns the To field if non-nil, zero value otherwise.

### GetToOk

`func (o *SendMail) GetToOk() (*[]MailContact, bool)`

GetToOk returns a tuple with the To field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTo

`func (o *SendMail) SetTo(v []MailContact)`

SetTo sets To field to given value.


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


### GetReplyto

`func (o *SendMail) GetReplyto() []MailContact`

GetReplyto returns the Replyto field if non-nil, zero value otherwise.

### GetReplytoOk

`func (o *SendMail) GetReplytoOk() (*[]MailContact, bool)`

GetReplytoOk returns a tuple with the Replyto field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetReplyto

`func (o *SendMail) SetReplyto(v []MailContact)`

SetReplyto sets Replyto field to given value.

### HasReplyto

`func (o *SendMail) HasReplyto() bool`

HasReplyto returns a boolean if a field has been set.

### GetCc

`func (o *SendMail) GetCc() []MailContact`

GetCc returns the Cc field if non-nil, zero value otherwise.

### GetCcOk

`func (o *SendMail) GetCcOk() (*[]MailContact, bool)`

GetCcOk returns a tuple with the Cc field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCc

`func (o *SendMail) SetCc(v []MailContact)`

SetCc sets Cc field to given value.

### HasCc

`func (o *SendMail) HasCc() bool`

HasCc returns a boolean if a field has been set.

### GetBcc

`func (o *SendMail) GetBcc() []MailContact`

GetBcc returns the Bcc field if non-nil, zero value otherwise.

### GetBccOk

`func (o *SendMail) GetBccOk() (*[]MailContact, bool)`

GetBccOk returns a tuple with the Bcc field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetBcc

`func (o *SendMail) SetBcc(v []MailContact)`

SetBcc sets Bcc field to given value.

### HasBcc

`func (o *SendMail) HasBcc() bool`

HasBcc returns a boolean if a field has been set.

### GetAttachments

`func (o *SendMail) GetAttachments() []MailAttachment`

GetAttachments returns the Attachments field if non-nil, zero value otherwise.

### GetAttachmentsOk

`func (o *SendMail) GetAttachmentsOk() (*[]MailAttachment, bool)`

GetAttachmentsOk returns a tuple with the Attachments field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAttachments

`func (o *SendMail) SetAttachments(v []MailAttachment)`

SetAttachments sets Attachments field to given value.

### HasAttachments

`func (o *SendMail) HasAttachments() bool`

HasAttachments returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


