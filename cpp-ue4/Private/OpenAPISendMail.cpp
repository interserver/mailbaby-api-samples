/**
 * Mail Baby API
 * This is an API for accesssing the mail services.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: detain@interserver.net
 *
 * NOTE: This class is auto generated by OpenAPI Generator
 * https://github.com/OpenAPITools/openapi-generator
 * Do not edit the class manually.
 */

#include "OpenAPISendMail.h"

#include "OpenAPIModule.h"
#include "OpenAPIHelpers.h"

#include "Templates/SharedPointer.h"

namespace OpenAPI 
{

void OpenAPISendMail::WriteJson(JsonWriter& Writer) const
{
	Writer->WriteObjectStart();
	Writer->WriteIdentifierPrefix(TEXT("id")); WriteJsonValue(Writer, Id);
	Writer->WriteIdentifierPrefix(TEXT("from")); WriteJsonValue(Writer, From);
	Writer->WriteIdentifierPrefix(TEXT("to")); WriteJsonValue(Writer, To);
	Writer->WriteIdentifierPrefix(TEXT("subject")); WriteJsonValue(Writer, Subject);
	Writer->WriteIdentifierPrefix(TEXT("body")); WriteJsonValue(Writer, Body);
	if (Replyto.IsSet())
	{
		Writer->WriteIdentifierPrefix(TEXT("replyto")); WriteJsonValue(Writer, Replyto.GetValue());	
	}
	if (Cc.IsSet())
	{
		Writer->WriteIdentifierPrefix(TEXT("cc")); WriteJsonValue(Writer, Cc.GetValue());	
	}
	if (Bcc.IsSet())
	{
		Writer->WriteIdentifierPrefix(TEXT("bcc")); WriteJsonValue(Writer, Bcc.GetValue());	
	}
	if (Attachments.IsSet())
	{
		Writer->WriteIdentifierPrefix(TEXT("attachments")); WriteJsonValue(Writer, Attachments.GetValue());	
	}
	Writer->WriteObjectEnd();
}

bool OpenAPISendMail::FromJson(const TSharedPtr<FJsonValue>& JsonValue)
{
	const TSharedPtr<FJsonObject>* Object;
	if (!JsonValue->TryGetObject(Object))
		return false;

	bool ParseSuccess = true;

	ParseSuccess &= TryGetJsonValue(*Object, TEXT("id"), Id);
	ParseSuccess &= TryGetJsonValue(*Object, TEXT("from"), From);
	ParseSuccess &= TryGetJsonValue(*Object, TEXT("to"), To);
	ParseSuccess &= TryGetJsonValue(*Object, TEXT("subject"), Subject);
	ParseSuccess &= TryGetJsonValue(*Object, TEXT("body"), Body);
	ParseSuccess &= TryGetJsonValue(*Object, TEXT("replyto"), Replyto);
	ParseSuccess &= TryGetJsonValue(*Object, TEXT("cc"), Cc);
	ParseSuccess &= TryGetJsonValue(*Object, TEXT("bcc"), Bcc);
	ParseSuccess &= TryGetJsonValue(*Object, TEXT("attachments"), Attachments);

	return ParseSuccess;
}

}