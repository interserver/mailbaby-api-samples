# MailAttachment

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Filename** | Pointer to **string** | Optional filename to specify for the attachment. | [optional] 
**Data** | ***os.File** | Contents of the attached file | 

## Methods

### NewMailAttachment

`func NewMailAttachment(data *os.File, ) *MailAttachment`

NewMailAttachment instantiates a new MailAttachment object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewMailAttachmentWithDefaults

`func NewMailAttachmentWithDefaults() *MailAttachment`

NewMailAttachmentWithDefaults instantiates a new MailAttachment object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetFilename

`func (o *MailAttachment) GetFilename() string`

GetFilename returns the Filename field if non-nil, zero value otherwise.

### GetFilenameOk

`func (o *MailAttachment) GetFilenameOk() (*string, bool)`

GetFilenameOk returns a tuple with the Filename field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFilename

`func (o *MailAttachment) SetFilename(v string)`

SetFilename sets Filename field to given value.

### HasFilename

`func (o *MailAttachment) HasFilename() bool`

HasFilename returns a boolean if a field has been set.

### GetData

`func (o *MailAttachment) GetData() *os.File`

GetData returns the Data field if non-nil, zero value otherwise.

### GetDataOk

`func (o *MailAttachment) GetDataOk() (**os.File, bool)`

GetDataOk returns a tuple with the Data field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetData

`func (o *MailAttachment) SetData(v *os.File)`

SetData sets Data field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


