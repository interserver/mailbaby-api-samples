/**
 * Mail Baby API
 * This is an API defintion for accesssing the Mail.Baby mail service.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: detain@interserver.net
 *
 * NOTE: This class is auto generated by OpenAPI Generator
 * https://github.com/OpenAPITools/openapi-generator
 * Do not edit the class manually.
 */

#pragma once

#include "OpenAPIBaseModel.h"
#include "OpenAPIMailAttachment.h"
#include "OpenAPIMailContact.h"
#include "OpenAPISendMailAdvFrom.h"

namespace OpenAPI 
{

/*
 * OpenAPISendMailAdv
 *
 * Details for an Email
 */
class OPENAPI_API OpenAPISendMailAdv : public Model
{
public:
    virtual ~OpenAPISendMailAdv() {}
	bool FromJson(const TSharedPtr<FJsonValue>& JsonValue) final;
	void WriteJson(JsonWriter& Writer) const final;

	/* The subject or title of the email */
	FString Subject;
	/* The main email contents. */
	FString Body;
	/* The contact whom is the this email is from. */
	TArray<OpenAPISendMailAdvFrom> From;
	/* The Contact whom is the primary recipient of this email. */
	TArray<OpenAPIMailContact> To;
	/* The ID of the Mail order within our system to use as the Mail Account. */
	int64 Id = 0;
	/* Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address. */
	TOptional<TArray<OpenAPIMailContact>> Replyto;
	/* Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. */
	TOptional<TArray<OpenAPIMailContact>> Cc;
	/* Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. */
	TOptional<TArray<OpenAPIMailContact>> Bcc;
	/* Optional file attachments to include in the email */
	TOptional<TArray<OpenAPIMailAttachment>> Attachments;
};

}