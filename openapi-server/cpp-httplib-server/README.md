# cpp-httplib-server - C++ Server

## Overview

This server was generated using the [OpenAPI Generator](https://openapi-generator.tech) project.
It uses the [cpp-httplib](https://github.com/yhirose/cpp-httplib) library to implement a lightweight HTTP server
with JSON request/response handling via [nlohmann/json](https://github.com/nlohmann/json).

## Requirements

- C++17 compatible compiler
- CMake (3.14 or higher)
- OpenSSL (for HTTPS support)
- ZLIB (for compression support)

**Note:** The following libraries are automatically downloaded via CMake FetchContent:
- [cpp-httplib](https://github.com/yhirose/cpp-httplib) v0.15.3
- [nlohmann/json](https://github.com/nlohmann/json) v3.11.3

### Platform-Specific Installation

**Linux (Ubuntu/Debian):**
```bash
sudo apt-get update
sudo apt-get install -y libssl-dev zlib1g-dev cmake build-essential
```

**macOS:**
```bash
brew install openssl zlib cmake
```

**Windows:**
```powershell
# Using vcpkg
vcpkg install openssl:x64-windows zlib:x64-windows

# Then configure CMake with vcpkg toolchain:
cmake -B build -DCMAKE_TOOLCHAIN_FILE=[vcpkg_root]/scripts/buildsystems/vcpkg.cmake
```

## Project Structure

```
├── CMakeLists.txt          # Project build configuration
├── README.md               # This file
├── models/                  # Generated model classes
└── api/                    # Generated API handler classes
```

## Building the Project

```bash
mkdir build
cd build
cmake ..
make
```

## Working with Models

### Model Classes

#### models::DateOrTimestamp

```cpp
// Create a model
auto model = models::DateOrTimestamp();

// Serialize to JSON
nlohmann::json json = models::DateOrTimestamp::toJson(model);
std::string jsonString = json.dump();

// Deserialize from JSON
auto parsedModel = models::DateOrTimestamp::fromJson(nlohmann::json::parse(jsonString));
```
#### models::DenyRuleNew

```cpp
// Create a model
auto model = models::DenyRuleNew();
model.setType(/* value */);  // Set type
model.setData(/* value */);  // Set data
model.setUser(/* value */);  // Set user

// Serialize to JSON
nlohmann::json json = models::DenyRuleNew::toJson(model);
std::string jsonString = json.dump();

// Deserialize from JSON
auto parsedModel = models::DenyRuleNew::fromJson(nlohmann::json::parse(jsonString));
```
#### models::DenyRuleRecord

```cpp
// Create a model
auto model = models::DenyRuleRecord();
model.setId(/* value */);  // Set id
model.setCreated(/* value */);  // Set created

// Serialize to JSON
nlohmann::json json = models::DenyRuleRecord::toJson(model);
std::string jsonString = json.dump();

// Deserialize from JSON
auto parsedModel = models::DenyRuleRecord::fromJson(nlohmann::json::parse(jsonString));
```
#### models::EmailAddressName

```cpp
// Create a model
auto model = models::EmailAddressName();
model.setEmail(/* value */);  // Set email
model.setName(/* value */);  // Set name

// Serialize to JSON
nlohmann::json json = models::EmailAddressName::toJson(model);
std::string jsonString = json.dump();

// Deserialize from JSON
auto parsedModel = models::EmailAddressName::fromJson(nlohmann::json::parse(jsonString));
```
#### models::EmailAddressParam

```cpp
// Create a model
auto model = models::EmailAddressParam();
model.setEmail(/* value */);  // Set email

// Serialize to JSON
nlohmann::json json = models::EmailAddressParam::toJson(model);
std::string jsonString = json.dump();

// Deserialize from JSON
auto parsedModel = models::EmailAddressParam::fromJson(nlohmann::json::parse(jsonString));
```
#### models::EmailAddressTypes

```cpp
// Create a model
auto model = models::EmailAddressTypes();
model.setEmail(/* value */);  // Set email
model.setName(/* value */);  // Set name

// Serialize to JSON
nlohmann::json json = models::EmailAddressTypes::toJson(model);
std::string jsonString = json.dump();

// Deserialize from JSON
auto parsedModel = models::EmailAddressTypes::fromJson(nlohmann::json::parse(jsonString));
```
#### models::EmailAddressesTypes

```cpp
// Create a model
auto model = models::EmailAddressesTypes();

// Serialize to JSON
nlohmann::json json = models::EmailAddressesTypes::toJson(model);
std::string jsonString = json.dump();

// Deserialize from JSON
auto parsedModel = models::EmailAddressesTypes::fromJson(nlohmann::json::parse(jsonString));
```
#### models::ErrorMessage

```cpp
// Create a model
auto model = models::ErrorMessage();
model.setCode(/* value */);  // Set code
model.setMessage(/* value */);  // Set message

// Serialize to JSON
nlohmann::json json = models::ErrorMessage::toJson(model);
std::string jsonString = json.dump();

// Deserialize from JSON
auto parsedModel = models::ErrorMessage::fromJson(nlohmann::json::parse(jsonString));
```
#### models::GenericResponse

```cpp
// Create a model
auto model = models::GenericResponse();
model.setStatus(/* value */);  // Set status
model.setText(/* value */);  // Set text

// Serialize to JSON
nlohmann::json json = models::GenericResponse::toJson(model);
std::string jsonString = json.dump();

// Deserialize from JSON
auto parsedModel = models::GenericResponse::fromJson(nlohmann::json::parse(jsonString));
```
#### models::MailAttachment

```cpp
// Create a model
auto model = models::MailAttachment();
model.setFilename(/* value */);  // Set filename
model.setData(/* value */);  // Set data

// Serialize to JSON
nlohmann::json json = models::MailAttachment::toJson(model);
std::string jsonString = json.dump();

// Deserialize from JSON
auto parsedModel = models::MailAttachment::fromJson(nlohmann::json::parse(jsonString));
```
#### models::MailBlockClickHouse

```cpp
// Create a model
auto model = models::MailBlockClickHouse();
model.setDate(/* value */);  // Set date
model.setFrom(/* value */);  // Set from
model.setSubject(/* value */);  // Set subject
model.setTo(/* value */);  // Set to
model.setMessageId(/* value */);  // Set messageId

// Serialize to JSON
nlohmann::json json = models::MailBlockClickHouse::toJson(model);
std::string jsonString = json.dump();

// Deserialize from JSON
auto parsedModel = models::MailBlockClickHouse::fromJson(nlohmann::json::parse(jsonString));
```
#### models::MailBlockRspamd

```cpp
// Create a model
auto model = models::MailBlockRspamd();
model.setFrom(/* value */);  // Set from
model.setSubject(/* value */);  // Set subject

// Serialize to JSON
nlohmann::json json = models::MailBlockRspamd::toJson(model);
std::string jsonString = json.dump();

// Deserialize from JSON
auto parsedModel = models::MailBlockRspamd::fromJson(nlohmann::json::parse(jsonString));
```
#### models::MailBlocks

```cpp
// Create a model
auto model = models::MailBlocks();
model.setLocal(/* value */);  // Set local
model.setMbtrap(/* value */);  // Set mbtrap
model.setSubject(/* value */);  // Set subject

// Serialize to JSON
nlohmann::json json = models::MailBlocks::toJson(model);
std::string jsonString = json.dump();

// Deserialize from JSON
auto parsedModel = models::MailBlocks::fromJson(nlohmann::json::parse(jsonString));
```
#### models::MailLog

```cpp
// Create a model
auto model = models::MailLog();
model.setTotal(/* value */);  // Set total
model.setSkip(/* value */);  // Set skip
model.setLimit(/* value */);  // Set limit
model.setEmails(/* value */);  // Set emails

// Serialize to JSON
nlohmann::json json = models::MailLog::toJson(model);
std::string jsonString = json.dump();

// Deserialize from JSON
auto parsedModel = models::MailLog::fromJson(nlohmann::json::parse(jsonString));
```
#### models::MailLogEntry

```cpp
// Create a model
auto model = models::MailLogEntry();
model.setId(/* value */);  // Set _id
model.setId(/* value */);  // Set id
model.setFrom(/* value */);  // Set from
model.setTo(/* value */);  // Set to
model.setCreated(/* value */);  // Set created
model.setTime(/* value */);  // Set time
model.setUser(/* value */);  // Set user
model.setTranstype(/* value */);  // Set transtype
model.setOrigin(/* value */);  // Set origin
model.setInterface(/* value */);  // Set interface
model.setSubject(/* value */);  // Set subject
model.setMessageId(/* value */);  // Set messageId
model.setSendingZone(/* value */);  // Set sendingZone
model.setBodySize(/* value */);  // Set bodySize
model.setSeq(/* value */);  // Set seq
model.setDelivered(/* value */);  // Set delivered
model.setCode(/* value */);  // Set code
model.setResponse(/* value */);  // Set response
model.setRecipient(/* value */);  // Set recipient
model.setDomain(/* value */);  // Set domain
model.setLocked(/* value */);  // Set locked
model.setLockTime(/* value */);  // Set lockTime
model.setAssigned(/* value */);  // Set assigned
model.setQueued(/* value */);  // Set queued
model.setMxHostname(/* value */);  // Set mxHostname

// Serialize to JSON
nlohmann::json json = models::MailLogEntry::toJson(model);
std::string jsonString = json.dump();

// Deserialize from JSON
auto parsedModel = models::MailLogEntry::fromJson(nlohmann::json::parse(jsonString));
```
#### models::MailOrder

```cpp
// Create a model
auto model = models::MailOrder();
model.setId(/* value */);  // Set id
model.setStatus(/* value */);  // Set status
model.setUsername(/* value */);  // Set username
model.setComment(/* value */);  // Set comment

// Serialize to JSON
nlohmann::json json = models::MailOrder::toJson(model);
std::string jsonString = json.dump();

// Deserialize from JSON
auto parsedModel = models::MailOrder::fromJson(nlohmann::json::parse(jsonString));
```
#### models::MailOrderDetail

```cpp
// Create a model
auto model = models::MailOrderDetail();
model.setPassword(/* value */);  // Set password

// Serialize to JSON
nlohmann::json json = models::MailOrderDetail::toJson(model);
std::string jsonString = json.dump();

// Deserialize from JSON
auto parsedModel = models::MailOrderDetail::fromJson(nlohmann::json::parse(jsonString));
```
#### models::MailStatsType

```cpp
// Create a model
auto model = models::MailStatsType();
model.setTime(/* value */);  // Set time
model.setUsage(/* value */);  // Set usage
model.setCurrency(/* value */);  // Set currency
model.setCost(/* value */);  // Set cost
model.setReceived(/* value */);  // Set received
model.setSent(/* value */);  // Set sent
model.setVolume(/* value */);  // Set volume

// Serialize to JSON
nlohmann::json json = models::MailStatsType::toJson(model);
std::string jsonString = json.dump();

// Deserialize from JSON
auto parsedModel = models::MailStatsType::fromJson(nlohmann::json::parse(jsonString));
```
#### models::MailStatsVolume

```cpp
// Create a model
auto model = models::MailStatsVolume();
model.setTo(/* value */);  // Set to
model.setFrom(/* value */);  // Set from
model.setIp(/* value */);  // Set ip

// Serialize to JSON
nlohmann::json json = models::MailStatsVolume::toJson(model);
std::string jsonString = json.dump();

// Deserialize from JSON
auto parsedModel = models::MailStatsVolume::fromJson(nlohmann::json::parse(jsonString));
```
#### models::SendMail

```cpp
// Create a model
auto model = models::SendMail();
model.setTo(/* value */);  // Set to
model.setFrom(/* value */);  // Set from
model.setSubject(/* value */);  // Set subject
model.setBody(/* value */);  // Set body
model.setId(/* value */);  // Set id

// Serialize to JSON
nlohmann::json json = models::SendMail::toJson(model);
std::string jsonString = json.dump();

// Deserialize from JSON
auto parsedModel = models::SendMail::fromJson(nlohmann::json::parse(jsonString));
```
#### models::SendMailAdv

```cpp
// Create a model
auto model = models::SendMailAdv();
model.setSubject(/* value */);  // Set subject
model.setBody(/* value */);  // Set body
model.setFrom(/* value */);  // Set from
model.setTo(/* value */);  // Set to
model.setReplyto(/* value */);  // Set replyto
model.setCc(/* value */);  // Set cc
model.setBcc(/* value */);  // Set bcc
model.setAttachments(/* value */);  // Set attachments
model.setId(/* value */);  // Set id

// Serialize to JSON
nlohmann::json json = models::SendMailAdv::toJson(model);
std::string jsonString = json.dump();

// Deserialize from JSON
auto parsedModel = models::SendMailAdv::fromJson(nlohmann::json::parse(jsonString));
```
#### models::SendMailRaw

```cpp
// Create a model
auto model = models::SendMailRaw();
model.setRawEmail(/* value */);  // Set raw_email
model.setId(/* value */);  // Set id

// Serialize to JSON
nlohmann::json json = models::SendMailRaw::toJson(model);
std::string jsonString = json.dump();

// Deserialize from JSON
auto parsedModel = models::SendMailRaw::fromJson(nlohmann::json::parse(jsonString));
```
#### models::SendMailTo

```cpp
// Create a model
auto model = models::SendMailTo();

// Serialize to JSON
nlohmann::json json = models::SendMailTo::toJson(model);
std::string jsonString = json.dump();

// Deserialize from JSON
auto parsedModel = models::SendMailTo::fromJson(nlohmann::json::parse(jsonString));
```

## Implementing API Handlers

### API Classes

Each API is generated as an abstract base class with pure virtual methods that you must implement.

#### Blocking

Create a class that inherits from the generated base class:

```cpp
#include "api/BlockingApi.h"

class BlockingImpl : public Api::Blocking {
public:
    MailrulesPostResponse handlePostForMailrules() override {

        // Implement your business logic here

        // Return success response (HTTP HTTP_RESPONSE_CODE_GENERIC_RESPONSE):
        models::GenericResponse successResponse;
        // ... populate response ...
        return successResponse;

        // Or return error response (HTTP HTTP_RESPONSE_CODE_ERROR_MESSAGE):
        // models::ErrorMessage errorResponse;
        // return errorResponse;
    }

    MailrulesruleIdDeleteResponse handleDeleteForMailrulesruleId(const MailrulesruleIdDeleteRequest& params) override {
        // Access request parameters:
        // Path: params.m_ruleId

        // Implement your business logic here

        // Return success response (HTTP HTTP_RESPONSE_CODE_GENERIC_RESPONSE):
        models::GenericResponse successResponse;
        // ... populate response ...
        return successResponse;

        // Or return error response (HTTP HTTP_RESPONSE_CODE_ERROR_MESSAGE):
        // models::ErrorMessage errorResponse;
        // return errorResponse;
    }

    MailblocksdeletePostResponse handlePostForMailblocksdelete(const MailblocksdeletePostRequest& params) override {
        // Access request parameters:
        // Body: params.m_request (std::optional<models::EmailAddressParam>)

        // Implement your business logic here

        // Return success response (HTTP HTTP_RESPONSE_CODE_GENERIC_RESPONSE):
        models::GenericResponse successResponse;
        // ... populate response ...
        return successResponse;

        // Or return error response (HTTP HTTP_RESPONSE_CODE_ERROR_MESSAGE):
        // models::ErrorMessage errorResponse;
        // return errorResponse;
    }

    MailblocksGetResponse handleGetForMailblocks() override {

        // Implement your business logic here

        // Return success response (HTTP HTTP_RESPONSE_CODE_MAIL_BLOCKS):
        models::MailBlocks successResponse;
        // ... populate response ...
        return successResponse;

        // Or return error response (HTTP HTTP_RESPONSE_CODE_ERROR_MESSAGE):
        // models::ErrorMessage errorResponse;
        // return errorResponse;
    }

    MailrulesGetResponse handleGetForMailrules() override {

        // Implement your business logic here

        // Return success response (HTTP HTTP_RESPONSE_CODE_DENY_RULE_RECORD):
        models::DenyRuleRecord successResponse;
        // ... populate response ...
        return successResponse;

        // Or return error response (HTTP HTTP_RESPONSE_CODE_ERROR_MESSAGE):
        // models::ErrorMessage errorResponse;
        // return errorResponse;
    }

};
```
#### History

Create a class that inherits from the generated base class:

```cpp
#include "api/HistoryApi.h"

class HistoryImpl : public Api::History {
public:
    MailstatsGetResponse handleGetForMailstats(const MailstatsGetRequest& params) override {
        // Access request parameters:
        // Query: params.m_time (optional)

        // Implement your business logic here

        // Return success response (HTTP HTTP_RESPONSE_CODE_MAIL_STATS_TYPE):
        models::MailStatsType successResponse;
        // ... populate response ...
        return successResponse;

        // Or return error response (HTTP HTTP_RESPONSE_CODE_ERROR_MESSAGE):
        // models::ErrorMessage errorResponse;
        // return errorResponse;
    }

    MaillogGetResponse handleGetForMaillog(const MaillogGetRequest& params) override {
        // Access request parameters:
        // Query: params.m_id (optional)
        // Query: params.m_origin (optional)
        // Query: params.m_mx (optional)
        // Query: params.m_from (optional)
        // Query: params.m_to (optional)
        // Query: params.m_subject (optional)
        // Query: params.m_mailid (optional)
        // Query: params.m_messageId (optional)
        // Query: params.m_replyto (optional)
        // Query: params.m_headerfrom (optional)
        // Query: params.m_delivered (optional)
        // Query: params.m_skip (optional)
        // Query: params.m_limit (optional)
        // Query: params.m_startDate (optional)
        // Query: params.m_endDate (optional)
        // Query: params.m_sort (optional)
        // Query: params.m_dir (optional)
        // Query: params.m_groupby (optional)

        // Implement your business logic here

        // Return success response (HTTP HTTP_RESPONSE_CODE_MAIL_LOG):
        models::MailLog successResponse;
        // ... populate response ...
        return successResponse;

        // Or return error response (HTTP HTTP_RESPONSE_CODE_ERROR_MESSAGE):
        // models::ErrorMessage errorResponse;
        // return errorResponse;
    }

};
```
#### Sending

Create a class that inherits from the generated base class:

```cpp
#include "api/SendingApi.h"

class SendingImpl : public Api::Sending {
public:
    MailrawsendPostResponse handlePostForMailrawsend(const MailrawsendPostRequest& params) override {
        // Access request parameters:
        // Body: params.m_request (std::optional<models::SendMailRaw>)

        // Implement your business logic here

        // Return success response (HTTP HTTP_RESPONSE_CODE_GENERIC_RESPONSE):
        models::GenericResponse successResponse;
        // ... populate response ...
        return successResponse;

        // Or return error response (HTTP HTTP_RESPONSE_CODE_ERROR_MESSAGE):
        // models::ErrorMessage errorResponse;
        // return errorResponse;
    }

    MailadvsendPostResponse handlePostForMailadvsend() override {

        // Implement your business logic here

        // Return success response (HTTP HTTP_RESPONSE_CODE_GENERIC_RESPONSE):
        models::GenericResponse successResponse;
        // ... populate response ...
        return successResponse;

        // Or return error response (HTTP HTTP_RESPONSE_CODE_ERROR_MESSAGE):
        // models::ErrorMessage errorResponse;
        // return errorResponse;
    }

    MailsendPostResponse handlePostForMailsend() override {

        // Implement your business logic here

        // Return success response (HTTP HTTP_RESPONSE_CODE_GENERIC_RESPONSE):
        models::GenericResponse successResponse;
        // ... populate response ...
        return successResponse;

        // Or return error response (HTTP HTTP_RESPONSE_CODE_ERROR_MESSAGE):
        // models::ErrorMessage errorResponse;
        // return errorResponse;
    }

};
```
#### Services

Create a class that inherits from the generated base class:

```cpp
#include "api/ServicesApi.h"

class ServicesImpl : public Api::Services {
public:
    MailidGetResponse handleGetForMailid(const MailidGetRequest& params) override {
        // Access request parameters:
        // Path: params.m_id

        // Implement your business logic here

        // Return success response (HTTP HTTP_RESPONSE_CODE_MAIL_ORDER_DETAIL):
        models::MailOrderDetail successResponse;
        // ... populate response ...
        return successResponse;

        // Or return error response (HTTP HTTP_RESPONSE_CODE_ERROR_MESSAGE):
        // models::ErrorMessage errorResponse;
        // return errorResponse;
    }

    MailGetResponse handleGetForMail() override {

        // Implement your business logic here

        // Return success response (HTTP HTTP_RESPONSE_CODE_MAIL_ORDER):
        models::MailOrder successResponse;
        // ... populate response ...
        return successResponse;

        // Or return error response (HTTP HTTP_RESPONSE_CODE_ERROR_MESSAGE):
        // models::ErrorMessage errorResponse;
        // return errorResponse;
    }

};
```
#### Status

Create a class that inherits from the generated base class:

```cpp
#include "api/StatusApi.h"

class StatusImpl : public Api::Status {
public:
    PingGetResponse handleGetForPing() override {

        // Implement your business logic here

        // Return success response (HTTP HTTP_RESPONSE_CODE_PRIMITIVE_STRING):
        std::string successResponse;
        // ... populate response ...
        return successResponse;
    }

};
```

## Running the Server

Here's a complete example of setting up and running the server:

```cpp
#include <httplib.h>
#include <memory>

#include "api/BlockingApi.h"

#include "api/HistoryApi.h"

#include "api/SendingApi.h"

#include "api/ServicesApi.h"

#include "api/StatusApi.h"

#include "api/AuthenticationManager.h"

int main() {
    httplib::Server server;

    // Create authentication manager (required for this API)
    auto authMgr = std::make_shared<MyAuthManager>();

    // Create API implementations

    BlockingImpl blocking;

    HistoryImpl history;

    SendingImpl sending;

    ServicesImpl services;

    StatusImpl status;


    // Register routes

    blocking.registerRoutes(server, authMgr);

    history.registerRoutes(server, authMgr);

    sending.registerRoutes(server, authMgr);

    services.registerRoutes(server, authMgr);

    status.registerRoutes(server, authMgr);


    // Start server
    std::cout << "Server starting on http://localhost:8080" << std::endl;
    server.listen("localhost", 8080);

    return 0;
}
```

### With Authentication

When authentication is required, you must:
1. Implement the `AuthenticationManager` interface (see Authentication section below)
2. Pass the authentication manager to `registerRoutes()`


## Authentication

This API requires authentication. Implement the `AuthenticationManager` interface to provide your authentication logic:

```cpp
#include "api/AuthenticationManager.h"

class MyAuthManager : public Api::AuthenticationManager {
public:
    bool validateApiKey(const std::string& key) override {
        // Validate API key from header, query, or cookie
        // Example: check against database or cache
        return checkApiKeyInDatabase(key);
    }

    bool validateBearerToken(const std::string& token) override {
        // Validate JWT or other bearer tokens
        // Example: verify signature and expiration
        return jwt::verify(token, secret_key);
    }

    bool validateBasicAuth(const std::string& username, const std::string& password) override {
        // Validate username/password credentials
        // Example: check against user database with hashed passwords
        auto user = findUser(username);
        return user && bcrypt::verify(password, user->passwordHash);
    }

    bool validateOAuth2(const std::string& token, const std::vector<std::string>& scopes) override {
        // Validate OAuth2 token and check required scopes
        // Example: introspect token and verify scopes
        auto introspection = oauthProvider.introspect(token);
        return introspection.active && hasAllScopes(introspection.scopes, scopes);
    }
};
```

### Authentication Flow

1. The server automatically extracts credentials from requests (headers, query params, cookies)
2. Before calling your handler, it validates credentials using your `AuthenticationManager`
3. If validation fails, the server returns HTTP 401 Unauthorized automatically
4. If validation succeeds, your handler is called

### Security Schemes

The generated code supports:
- **API Key**: Header, query parameter, or cookie-based authentication
- **Bearer Token**: Authorization header with "Bearer" scheme (e.g., JWT)
- **Basic Auth**: HTTP Basic authentication (username:password)
- **OAuth2**: OAuth 2.0 token-based authentication with scope validation


## Error Handling

### Response Variants

Each API endpoint that returns data uses `std::variant` to represent multiple possible response types (success and errors):

```cpp
// Example: endpoint returns success (User) or errors (NotFound, ServerError)
using GetUserResponse = std::variant<User, NotFound, ServerError>;

GetUserResponse handleGetUser(const GetUserRequest& params) override {
    if (userExists(params.m_userId)) {
        User user = fetchUser(params.m_userId);
        return user;  // Automatically sets HTTP 200
    } else {
        NotFound error;
        error.setMessage("User not found");
        return error;  // Automatically sets HTTP 404
    }
}
```

The server automatically:
- Detects which type is returned from the variant
- Sets the appropriate HTTP status code
- Serializes the response to JSON

### HTTP Status Codes

Status codes are automatically set based on the response type you return. Each model type is associated with a specific HTTP status code defined in your OpenAPI specification.

**Optimized Status Code Constants:**
The generator only creates HTTP status code constants (e.g., `HTTP_RESPONSE_CODE_200`, `HTTP_RESPONSE_CODE_404`) for codes actually used by your API operations. This reduces code bloat and compilation time compared to generating all possible HTTP status codes.

### Parameter Validation

The generated code automatically validates:
- **Required parameters**: Returns HTTP 400 if missing
- **Type conversion**: Returns HTTP 400 if parameter cannot be converted to expected type
- **JSON parsing**: Returns HTTP 400 if request body is invalid JSON

Custom validation logic should be implemented in your handler methods.

### Working with Optional Parameters

Optional parameters and model fields use `std::optional`:

```cpp
void handleRequest(const RequestParams& params) override {
    // Check if optional query parameter is present
    if (params.m_optionalParam) {
        auto value = *params.m_optionalParam;  // Dereference to get value
        // Use value...
    }

    // Check if optional request body is present
    if (params.m_request) {
        auto body = *params.m_request;  // Dereference to get body
        // Use body...
    }
}
```

## Advanced Features

### Parameter Serialization Styles

The generator supports various parameter serialization styles as defined in OpenAPI:

- **simple**: Comma-separated values (default for path/header)
- **form**: Ampersand-separated values (default for query)
- **spaceDelimited**: Space-separated values
- **pipeDelimited**: Pipe-separated values
- **deepObject**: Nested object notation for query parameters

These are automatically handled during parameter parsing.

### Enum Handling

All generated enums automatically include an `UNSPECIFIED` value as the first enum entry for safe initialization:

```cpp
enum class Status {
    UNSPECIFIED = 0,  // Added automatically for safety
    PENDING,
    APPROVED,
    REJECTED
};

// Safe default initialization
Status status;  // Defaults to UNSPECIFIED (0)

// Explicit initialization
Status activeStatus = Status::APPROVED;

// Enum serialization/deserialization
// UNSPECIFIED is not a valid API value and indicates uninitialized state
```

**Why UNSPECIFIED?**
- Provides a safe default value for uninitialized enums
- Prevents undefined behavior from using uninitialized enum values
- Makes it clear when an enum hasn't been set vs. having a valid API value
- Does not appear in OpenAPI spec - internal C++ implementation detail

### Union Types (anyOf/oneOf)

When your OpenAPI spec uses `anyOf` or `oneOf`, the generated code uses `std::variant`:

```cpp
// OpenAPI: { "anyOf": [{"type": "string"}, {"type": "number"}] }
using MyUnionType = std::variant<std::string, double>;

// In your model:
MyUnionType value;

// Use std::visit to handle different types:
std::visit([](const auto& v) {
    using T = std::decay_t<decltype(v)>;
    if constexpr (std::is_same_v<T, std::string>) {
        std::cout << "String: " << v << std::endl;
    } else if constexpr (std::is_same_v<T, double>) {
        std::cout << "Number: " << v << std::endl;
    }
}, value);
```

## Additional Resources

- [cpp-httplib Documentation](https://github.com/yhirose/cpp-httplib)
- [nlohmann/json Documentation](https://github.com/nlohmann/json)
- [OpenAPI Generator Documentation](https://openapi-generator.tech/docs/generators/cpp-httplib-server)
- [OpenAPI Specification](https://swagger.io/specification/)

- [cpp-httplib Documentation](https://github.com/yhirose/cpp-httplib)
- [nlohmann/json Documentation](https://github.com/nlohmann/json)
- [OpenAPI Generator Documentation](https://openapi-generator.tech/docs/generators/)
