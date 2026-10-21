#import "OAIHistoryApi.h"
#import "OAIQueryParamCollection.h"
#import "OAIApiClient.h"
#import "OAIDateOrTimestamp.h"
#import "OAIErrorMessage.h"
#import "OAIMailLog.h"
#import "OAIMailStatsType.h"


@interface OAIHistoryApi ()

@property (nonatomic, strong, readwrite) NSMutableDictionary *mutableDefaultHeaders;

@end

@implementation OAIHistoryApi

NSString* kOAIHistoryApiErrorDomain = @"OAIHistoryApiErrorDomain";
NSInteger kOAIHistoryApiMissingParamErrorCode = 234513;

@synthesize apiClient = _apiClient;

#pragma mark - Initialize methods

- (instancetype) init {
    return [self initWithApiClient:[OAIApiClient sharedClient]];
}


-(instancetype) initWithApiClient:(OAIApiClient *)apiClient {
    self = [super init];
    if (self) {
        _apiClient = apiClient;
        _mutableDefaultHeaders = [NSMutableDictionary dictionary];
    }
    return self;
}

#pragma mark -

-(NSString*) defaultHeaderForKey:(NSString*)key {
    return self.mutableDefaultHeaders[key];
}

-(void) setDefaultHeaderValue:(NSString*) value forKey:(NSString*)key {
    [self.mutableDefaultHeaders setValue:value forKey:key];
}

-(NSDictionary *)defaultHeaders {
    return self.mutableDefaultHeaders;
}

#pragma mark - Api Methods

///
/// Account usage, cost, and volume statistics for a time window
/// **Use this for dashboards or billing-cycle reviews.** Returns aggregate sending statistics for your mail account(s). The `time` query param controls the window for `received`, `sent`, and `volume` (`1h`, `24h`, `7d`, `month`, `day`, `billing`, `all`). The `usage` and `cost` fields are always for the current billing cycle, regardless of `time`.  The response includes: - **`usage`** — total messages accepted by the relay during the current billing   cycle (used for cost calculation). - **`cost`** — estimated cost for the billing cycle based on the base plan price   plus per-email charges. - **`received`** / **`sent`** — count of messages accepted by the relay /   successfully delivered to the destination MX within the selected `time` window. - **`volume`** — top-500 breakdown of message counts grouped by source IP (`ip`),   destination address (`to`), and sender address (`from`) within the selected window.   **Time windows** (controlled by the `time` parameter): | Value | Window | |-------|--------| | `1h` | Last 1 hour (default) | | `24h` | Last 24 hours | | `7d` | Last 7 days | | `month` | Current calendar month (1st to now) | | `day` | Today (midnight to now) | | `billing` | Current billing cycle (last invoice date to next invoice date) | | `all` | All time | 
///  @param time The time window to scope `received`, `sent`, and `volume` statistics. Does not affect `usage` or `cost`, which are always calculated over the current billing cycle. Defaults to `1h`. (optional, default to @"1h")
///
///  @returns OAIMailStatsType*
///
-(NSURLSessionTask*) getStatsWithTime: (NSString*) time
    completionHandler: (void (^)(OAIMailStatsType* output, NSError* error)) handler {
    NSMutableString* resourcePath = [NSMutableString stringWithFormat:@"/mail/stats"];

    NSMutableDictionary *pathParams = [[NSMutableDictionary alloc] init];

    NSMutableDictionary* queryParams = [[NSMutableDictionary alloc] init];
    if (time != nil) {
        queryParams[@"time"] = time;
    }
    NSMutableDictionary* headerParams = [NSMutableDictionary dictionaryWithDictionary:self.apiClient.configuration.defaultHeaders];
    [headerParams addEntriesFromDictionary:self.defaultHeaders];
    // HTTP header `Accept`
    NSString *acceptHeader = [self.apiClient.sanitizer selectHeaderAccept:@[@"application/json"]];
    if(acceptHeader.length > 0) {
        headerParams[@"Accept"] = acceptHeader;
    }

    // response content type
    NSString *responseContentType = [[acceptHeader componentsSeparatedByString:@", "] firstObject] ?: @"";

    // request content type
    NSString *requestContentType = [self.apiClient.sanitizer selectHeaderContentType:@[]];

    // Authentication setting
    NSArray *authSettings = @[@"apiKeyAuth"];

    id bodyParam = nil;
    NSMutableDictionary *formParams = [[NSMutableDictionary alloc] init];
    NSMutableDictionary *localVarFiles = [[NSMutableDictionary alloc] init];

    return [self.apiClient requestWithPath: resourcePath
                                    method: @"GET"
                                pathParams: pathParams
                               queryParams: queryParams
                                formParams: formParams
                                     files: localVarFiles
                                      body: bodyParam
                              headerParams: headerParams
                              authSettings: authSettings
                        requestContentType: requestContentType
                       responseContentType: responseContentType
                              responseType: @"OAIMailStatsType*"
                           completionBlock: ^(id data, NSError *error) {
                                if(handler) {
                                    handler((OAIMailStatsType*)data, error);
                                }
                            }];
}

///
/// Query the mail delivery log (filterable, paginated)
/// **Use this to find or audit sent messages.** All filters are optional and combinable. The most useful filters: `mailid` (the transaction id returned by a send call), `from` / `to` (envelope addresses), `subject`, `messageId` (case-insensitive substring on the `Message-ID` header), `delivered` (`1`=delivered, `0`=queued/failed), and the `startDate`/`endDate` date range. Returns a paginated list of every email message accepted by the relay for your mail account(s).  **Row grouping** is controlled by the `groupby` parameter.  By default (`groupby=recipient`), the response contains one row per delivery attempt — so a single message sent to 4 recipients produces 4 rows, each with its own `recipient`, `delivered`, `response`, and `mxHostname` values.  Set `groupby=message` to collapse to one row per message (delivery fields will reflect one arbitrary recipient).  **Pagination** is controlled by `skip` and `limit`.  The `total` in the response reflects the row count **after** grouping, so it matches the number of pages you need to fetch.  **Date filtering** accepts either a Unix timestamp (integer) or a date string parseable by PHP `strtotime()` such as `2024-01-15`, `last monday`, or `2024-01-01 00:00:00`.  Examples: `startDate=1704067200&endDate=1706745599` or `startDate=2024-01-01&endDate=2024-01-31`.  **Sorting** is controlled by `sort` and `dir`.  Currently the only sort key is `time` (default), which orders by internal row ID.  **Delivery status** can be filtered with the `delivered` parameter: `delivered=1` returns only successfully delivered messages; `delivered=0` returns messages still in queue or that failed.  **Address filtering** distinguishes between the SMTP envelope address (`from`, `to`) and message headers (`headerfrom` for the `From:` header, `replyto` for `Reply-To:`). These may differ when a message is sent on behalf of another address.  The `mailid` parameter corresponds to the `id` field in the returned `MailLogEntry` objects, **not** the `_id` field.  It also matches the transaction ID returned in the `text` field of a successful send response from `/mail/send`, `/mail/advsend`, or `/mail/rawsend`.  The `messageId` parameter searches the `Message-ID` email header (case-insensitive substring match). 
///  @param _id The numeric ID of the mail order to filter by.  When omitted, logs from the first active mail order are returned.  Obtain valid IDs from `GET /mail` or `GET /mail/{id}`. (optional)
///
///  @param origin Filter by the originating IP address from which the message was submitted to the relay.  Must be a valid IPv4 or IPv6 address. (optional)
///
///  @param mx Filter by the MX hostname the relay attempted delivery to.  For example `mx.google.com` would return messages destined for Gmail recipients. Maps to `mxHostname` in the `MailLogEntry` response. (optional)
///
///  @param from Filter by SMTP envelope `MAIL FROM` address (exact match).  This is the address the relay used for bounce handling and may differ from the `From:` message header.  For header-level filtering use `headerfrom`. (optional)
///
///  @param to Filter by SMTP envelope `RCPT TO` address (exact match).  This is the delivery address used by the relay and may differ from the `To:` header when BCC recipients are involved. (optional)
///
///  @param subject Filter by email `Subject` header (exact match).  To search for a substring, include it in the full subject text. (optional)
///
///  @param mailid Filter by the relay-assigned mail ID string (exact match).  This corresponds to the `id` field in `MailLogEntry` and to the `text` value returned by the sending endpoints on success.  Format is an 18–19 character hexadecimal string such as `185997065c60008840`. (optional)
///
///  @param messageId Filter by the `Message-ID` email header using a substring (case-insensitive) match. The `Message-ID` is assigned by the sending mail client and is visible in the `messageId` field of `MailLogEntry`.  Useful when you know the message ID generated by your application but not the relay `mailid`. (optional)
///
///  @param replyto Filter by the `Reply-To` message header address (exact match).  Only returns messages where this header was explicitly set. (optional)
///
///  @param headerfrom Filter by the `From` message header address (exact match).  This is the human-visible sender address and may differ from the SMTP envelope `from` parameter when sending on behalf of another address. (optional)
///
///  @param delivered Filter by delivery status.  `1` returns only messages that were successfully delivered to the destination MX.  `0` returns messages that are still queued, deferred, or failed.  Omit to return all messages regardless of delivery status. (optional)
///
///  @param skip Number of records to skip for pagination.  Use in combination with `limit` to page through large result sets.  Defaults to `0` (no skip). (optional, default to @0)
///
///  @param limit Maximum number of records to return per page.  Defaults to `100`. Maximum allowed value is `10000`.  The response also includes a `total` field with the full matched count so you can calculate the number of pages. (optional, default to @100)
///
///  @param startDate Earliest date to include.  Accepts either a Unix timestamp (integer seconds since epoch) or a date string parseable by `strtotime()` such as `2024-01-15` or `last monday`.  Messages with a `time` value **greater than or equal to** this value will be included. (optional)
///
///  @param endDate Latest date to include.  Accepts either a Unix timestamp (integer seconds since epoch) or a date string parseable by `strtotime()` such as `2024-01-31` or `yesterday`. Messages with a `time` value **less than or equal to** this value will be included. (optional)
///
///  @param sort Field to sort results by.  Currently only `time` is supported (sorts by internal row ID which corresponds to chronological order). (optional, default to @"time")
///
///  @param dir Sort direction.  `desc` returns newest first (default), `asc` returns oldest first. (optional, default to @"desc")
///
///  @param groupby Controls how results are grouped.  `recipient` (default) returns one row per delivery attempt — a message sent to 4 recipients produces 4 rows, each with its own `recipient`, `delivered`, `response`, and delivery metadata.  `message` collapses to one row per unique message ID; delivery-level fields will reflect one arbitrary recipient per message.  The `total` count in the response matches the grouping mode. (optional, default to @"recipient")
///
///  @returns OAIMailLog*
///
-(NSURLSessionTask*) viewMailLogWithId: (NSNumber*) _id
    origin: (NSString*) origin
    mx: (NSString*) mx
    from: (NSString*) from
    to: (NSString*) to
    subject: (NSString*) subject
    mailid: (NSString*) mailid
    messageId: (NSString*) messageId
    replyto: (NSString*) replyto
    headerfrom: (NSString*) headerfrom
    delivered: (NSNumber*) delivered
    skip: (NSNumber*) skip
    limit: (NSNumber*) limit
    startDate: (OAIDateOrTimestamp) startDate
    endDate: (OAIDateOrTimestamp) endDate
    sort: (NSString*) sort
    dir: (NSString*) dir
    groupby: (NSString*) groupby
    completionHandler: (void (^)(OAIMailLog* output, NSError* error)) handler {
    NSMutableString* resourcePath = [NSMutableString stringWithFormat:@"/mail/log"];

    NSMutableDictionary *pathParams = [[NSMutableDictionary alloc] init];

    NSMutableDictionary* queryParams = [[NSMutableDictionary alloc] init];
    if (_id != nil) {
        queryParams[@"id"] = _id;
    }
    if (origin != nil) {
        queryParams[@"origin"] = origin;
    }
    if (mx != nil) {
        queryParams[@"mx"] = mx;
    }
    if (from != nil) {
        queryParams[@"from"] = from;
    }
    if (to != nil) {
        queryParams[@"to"] = to;
    }
    if (subject != nil) {
        queryParams[@"subject"] = subject;
    }
    if (mailid != nil) {
        queryParams[@"mailid"] = mailid;
    }
    if (messageId != nil) {
        queryParams[@"messageId"] = messageId;
    }
    if (replyto != nil) {
        queryParams[@"replyto"] = replyto;
    }
    if (headerfrom != nil) {
        queryParams[@"headerfrom"] = headerfrom;
    }
    if (delivered != nil) {
        queryParams[@"delivered"] = delivered;
    }
    if (skip != nil) {
        queryParams[@"skip"] = skip;
    }
    if (limit != nil) {
        queryParams[@"limit"] = limit;
    }
    if (startDate != nil) {
        queryParams[@"startDate"] = startDate;
    }
    if (endDate != nil) {
        queryParams[@"endDate"] = endDate;
    }
    if (sort != nil) {
        queryParams[@"sort"] = sort;
    }
    if (dir != nil) {
        queryParams[@"dir"] = dir;
    }
    if (groupby != nil) {
        queryParams[@"groupby"] = groupby;
    }
    NSMutableDictionary* headerParams = [NSMutableDictionary dictionaryWithDictionary:self.apiClient.configuration.defaultHeaders];
    [headerParams addEntriesFromDictionary:self.defaultHeaders];
    // HTTP header `Accept`
    NSString *acceptHeader = [self.apiClient.sanitizer selectHeaderAccept:@[@"application/json"]];
    if(acceptHeader.length > 0) {
        headerParams[@"Accept"] = acceptHeader;
    }

    // response content type
    NSString *responseContentType = [[acceptHeader componentsSeparatedByString:@", "] firstObject] ?: @"";

    // request content type
    NSString *requestContentType = [self.apiClient.sanitizer selectHeaderContentType:@[]];

    // Authentication setting
    NSArray *authSettings = @[@"apiKeyAuth"];

    id bodyParam = nil;
    NSMutableDictionary *formParams = [[NSMutableDictionary alloc] init];
    NSMutableDictionary *localVarFiles = [[NSMutableDictionary alloc] init];

    return [self.apiClient requestWithPath: resourcePath
                                    method: @"GET"
                                pathParams: pathParams
                               queryParams: queryParams
                                formParams: formParams
                                     files: localVarFiles
                                      body: bodyParam
                              headerParams: headerParams
                              authSettings: authSettings
                        requestContentType: requestContentType
                       responseContentType: responseContentType
                              responseType: @"OAIMailLog*"
                           completionBlock: ^(id data, NSError *error) {
                                if(handler) {
                                    handler((OAIMailLog*)data, error);
                                }
                            }];
}



@end
