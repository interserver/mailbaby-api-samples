# SendMailAdv

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Subject** | **string** | The subject or title of the email | 
**Body** | **string** | The main email contents. | 
**From** | [**[]SendMailAdvFrom**](SendMailAdvFrom.md) | The contact whom is the this email is from. | 
**To** | [**[]MailContact**](MailContact.md) | The Contact whom is the primary recipient of this email. | 
**Id** | **int64** | The ID of the Mail order within our system to use as the Mail Account. | 
**Replyto** | Pointer to [**[]MailContact**](MailContact.md) | Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address. | [optional] 
**Cc** | Pointer to [**[]MailContact**](MailContact.md) | Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional] 
**Bcc** | Pointer to [**[]MailContact**](MailContact.md) | Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional] 
**Attachments** | Pointer to [**[]MailAttachment**](MailAttachment.md) | Optional file attachments to include in the email | [optional] 

## Methods

### NewSendMailAdv

`func NewSendMailAdv(subject string, body string, from []SendMailAdvFrom, to []MailContact, id int64, ) *SendMailAdv`

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

`func (o *SendMailAdv) GetFrom() []SendMailAdvFrom`

GetFrom returns the From field if non-nil, zero value otherwise.

### GetFromOk

`func (o *SendMailAdv) GetFromOk() (*[]SendMailAdvFrom, bool)`

GetFromOk returns a tuple with the From field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFrom

`func (o *SendMailAdv) SetFrom(v []SendMailAdvFrom)`

SetFrom sets From field to given value.


### GetTo

`func (o *SendMailAdv) GetTo() []MailContact`

GetTo returns the To field if non-nil, zero value otherwise.

### GetToOk

`func (o *SendMailAdv) GetToOk() (*[]MailContact, bool)`

GetToOk returns a tuple with the To field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTo

`func (o *SendMailAdv) SetTo(v []MailContact)`

SetTo sets To field to given value.


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


### GetReplyto

`func (o *SendMailAdv) GetReplyto() []MailContact`

GetReplyto returns the Replyto field if non-nil, zero value otherwise.

### GetReplytoOk

`func (o *SendMailAdv) GetReplytoOk() (*[]MailContact, bool)`

GetReplytoOk returns a tuple with the Replyto field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetReplyto

`func (o *SendMailAdv) SetReplyto(v []MailContact)`

SetReplyto sets Replyto field to given value.

### HasReplyto

`func (o *SendMailAdv) HasReplyto() bool`

HasReplyto returns a boolean if a field has been set.

### GetCc

`func (o *SendMailAdv) GetCc() []MailContact`

GetCc returns the Cc field if non-nil, zero value otherwise.

### GetCcOk

`func (o *SendMailAdv) GetCcOk() (*[]MailContact, bool)`

GetCcOk returns a tuple with the Cc field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCc

`func (o *SendMailAdv) SetCc(v []MailContact)`

SetCc sets Cc field to given value.

### HasCc

`func (o *SendMailAdv) HasCc() bool`

HasCc returns a boolean if a field has been set.

### GetBcc

`func (o *SendMailAdv) GetBcc() []MailContact`

GetBcc returns the Bcc field if non-nil, zero value otherwise.

### GetBccOk

`func (o *SendMailAdv) GetBccOk() (*[]MailContact, bool)`

GetBccOk returns a tuple with the Bcc field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetBcc

`func (o *SendMailAdv) SetBcc(v []MailContact)`

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


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


