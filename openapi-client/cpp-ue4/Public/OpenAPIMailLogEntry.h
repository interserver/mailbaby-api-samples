/**
 * MailBaby Email Delivery API
 * **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.**   # 📌 Overview  This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net).   # 🔐 Authentication  In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site.    We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
 *
 * OpenAPI spec version: 1.0.0
 * Contact: support@interserver.net
 *
 * NOTE: This class is auto generated by OpenAPI Generator
 * https://github.com/OpenAPITools/openapi-generator
 * Do not edit the class manually.
 */

#pragma once

#include "OpenAPIBaseModel.h"

namespace OpenAPI
{

/*
 * OpenAPIMailLogEntry
 *
 * An email record
 */
class OPENAPI_API OpenAPIMailLogEntry : public Model
{
public:
    virtual ~OpenAPIMailLogEntry() {}
	bool FromJson(const TSharedPtr<FJsonValue>& JsonValue) final;
	void WriteJson(JsonWriter& Writer) const final;

	/* internal db id */
	int32 Id = 0;
	/* mail id */
	FString Id;
	/* from address */
	FString From;
	/* to address */
	FString To;
	/* email subject */
	FString Subject;
	/* message id */
	FString MessageId;
	/* creation date */
	FString Created;
	/* creation timestamp */
	int32 Time = 0;
	/* user account */
	FString User;
	/* transaction type */
	FString Transtype;
	/* transaction host */
	FString Transhost;
	/* origin host */
	FString Originhost;
	/* origin ip */
	FString Origin;
	/* interface name */
	FString Interface;
	/* date processed */
	FString Date;
	/* sending zone */
	FString SendingZone;
	/* email body size in bytes */
	int32 BodySize = 0;
	/* md5 sum of the email */
	FString SourceMd5;
	/* delivery sequency */
	int32 Seq = 0;
	/* to address domain */
	FString Domain;
	/* email receiver address */
	FString Recipient;
	/* locked status */
	int32 Locked = 0;
	/* lock timestamp */
	int32 LockTime = 0;
	/* assigned server */
	FString Assigned;
	/* queued timestamp */
	FString Queued;
	/* lock id */
	FString Lock;
	/* logger */
	FString Logger;
	/* mx port number */
	int32 MxPort = 0;
	/* connection key */
	FString ConnectionKey;
	/* mx hostname */
	FString MxHostname;
	/* body hash */
	FString SentBodyHash;
	/* sent body size in bytes */
	int32 SentBodySize = 0;
	/* md5 checksum matching result */
	int32 Md5Match = 0;
};

}
