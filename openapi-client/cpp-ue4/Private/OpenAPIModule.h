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

#pragma once

#include "Modules/ModuleInterface.h"
#include "Modules/ModuleManager.h"
#include "Logging/LogMacros.h"

DECLARE_LOG_CATEGORY_EXTERN(LogOpenAPI, Log, All);

class OPENAPI_API OpenAPIModule : public IModuleInterface
{
public:
	void StartupModule() final;
	void ShutdownModule() final;
};