/**
 * MailBaby Email Delivery and Management Service API
 * **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
 *
 * OpenAPI spec version: 1.1.0
 * Contact: support@interserver.net
 *
 * NOTE: This class is auto generated by OpenAPI Generator
 * https://github.com/OpenAPITools/openapi-generator
 * Do not edit the class manually.
 */

#pragma once

#include "OpenAPIBaseModel.h"
#include "OpenAPISendingApi.h"

#include "OpenAPIEmailAddressName.h"
#include "OpenAPIGenericResponse.h"
#include "OpenAPIGetMailOrders401Response.h"
#include "OpenAPIMailAttachment.h"

namespace OpenAPI
{

/* Sends an Email with Advanced Options
 *
 * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
*/
class OPENAPI_API OpenAPISendingApi::SendAdvMailRequest : public Request
{
public:
    virtual ~SendAdvMailRequest() {}
	void SetupHttpRequest(const FHttpRequestRef& HttpRequest) const final;
	FString ComputePath() const final;

	/* The subject or title of the email */
	FString Subject;
	/* The main email contents. */
	FString Body;
	OpenAPIEmailAddressName From;
	/* A list of destionation email addresses to send this to */
	TArray<OpenAPIEmailAddressName> To;
	/* (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. */
	TOptional<TArray<OpenAPIEmailAddressName>> Replyto;
	/* (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. */
	TOptional<TArray<OpenAPIEmailAddressName>> Cc;
	/* (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. */
	TOptional<TArray<OpenAPIEmailAddressName>> Bcc;
	/* (optional) File attachments to include in the email.  The file contents must be base64 encoded! */
	TOptional<TArray<OpenAPIMailAttachment>> Attachments;
	/* (optional)  ID of the Mail order within our system to use as the Mail Account. */
	TOptional<int64> Id;
};

class OPENAPI_API OpenAPISendingApi::SendAdvMailResponse : public Response
{
public:
    virtual ~SendAdvMailResponse() {}
	void SetHttpResponseCode(EHttpResponseCodes::Type InHttpResponseCode) final;
	bool FromJson(const TSharedPtr<FJsonValue>& JsonValue) final;

    OpenAPIGenericResponse Content;
};

/* Sends an Email
 *
 * Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
*/
class OPENAPI_API OpenAPISendingApi::SendMailRequest : public Request
{
public:
    virtual ~SendMailRequest() {}
	void SetupHttpRequest(const FHttpRequestRef& HttpRequest) const final;
	FString ComputePath() const final;

	/* The Contact whom is the primary recipient of this email. */
	FString To;
	/* The contact whom is the this email is from. */
	FString From;
	/* The subject or title of the email */
	FString Subject;
	/* The main email contents. */
	FString Body;
};

class OPENAPI_API OpenAPISendingApi::SendMailResponse : public Response
{
public:
    virtual ~SendMailResponse() {}
	void SetHttpResponseCode(EHttpResponseCodes::Type InHttpResponseCode) final;
	bool FromJson(const TSharedPtr<FJsonValue>& JsonValue) final;

    OpenAPIGenericResponse Content;
};

}