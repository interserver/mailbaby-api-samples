-module(MailBabyErlangClient_history_api).

-export([get_stats/1, get_stats/2,
         view_mail_log/1, view_mail_log/2]).

-define(BASE_URL, <<"">>).

%% @doc Account usage, cost, and volume statistics for a time window
%% **Use this for dashboards or billing-cycle reviews.** Returns aggregate sending statistics for your mail account(s). The `time` query param controls the window for `received`, `sent`, and `volume` (`1h`, `24h`, `7d`, `month`, `day`, `billing`, `all`). The `usage` and `cost` fields are always for the current billing cycle, regardless of `time`.  The response includes: - **`usage`** — total messages accepted by the relay during the current billing   cycle (used for cost calculation). - **`cost`** — estimated cost for the billing cycle based on the base plan price   plus per-email charges. - **`received`** / **`sent`** — count of messages accepted by the relay /   successfully delivered to the destination MX within the selected `time` window. - **`volume`** — top-500 breakdown of message counts grouped by source IP (`ip`),   destination address (`to`), and sender address (`from`) within the selected window.   **Time windows** (controlled by the `time` parameter): | Value | Window | |-------|--------| | `1h` | Last 1 hour (default) | | `24h` | Last 24 hours | | `7d` | Last 7 days | | `month` | Current calendar month (1st to now) | | `day` | Today (midnight to now) | | `billing` | Current billing cycle (last invoice date to next invoice date) | | `all` | All time | 
-spec get_stats(ctx:ctx()) -> {ok, MailBabyErlangClient_mail_stats_type:MailBabyErlangClient_mail_stats_type(), MailBabyErlangClient_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), MailBabyErlangClient_utils:response_info()}.
get_stats(Ctx) ->
    get_stats(Ctx, #{}).

-spec get_stats(ctx:ctx(), maps:map()) -> {ok, MailBabyErlangClient_mail_stats_type:MailBabyErlangClient_mail_stats_type(), MailBabyErlangClient_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), MailBabyErlangClient_utils:response_info()}.
get_stats(Ctx, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(MailBabyErlangClient_api, config, #{})),

    Method = get,
    Path = [?BASE_URL, "/mail/stats"],
    QS = lists:flatten([])++MailBabyErlangClient_utils:optional_params(['time'], _OptionalParams),
    Headers = [],
    Body1 = [],
    ContentTypeHeader = MailBabyErlangClient_utils:select_header_content_type([]),
    Opts = maps:get(hackney_opts, Optional, []),

    MailBabyErlangClient_utils:request(Ctx, Method, Path, QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).

%% @doc Query the mail delivery log (filterable, paginated)
%% **Use this to find or audit sent messages.** All filters are optional and combinable. The most useful filters: `mailid` (the transaction id returned by a send call), `from` / `to` (envelope addresses), `subject`, `messageId` (case-insensitive substring on the `Message-ID` header), `delivered` (`1`=delivered, `0`=queued/failed), and the `startDate`/`endDate` date range. Returns a paginated list of every email message accepted by the relay for your mail account(s).  **Row grouping** is controlled by the `groupby` parameter.  By default (`groupby=recipient`), the response contains one row per delivery attempt — so a single message sent to 4 recipients produces 4 rows, each with its own `recipient`, `delivered`, `response`, and `mxHostname` values.  Set `groupby=message` to collapse to one row per message (delivery fields will reflect one arbitrary recipient).  **Pagination** is controlled by `skip` and `limit`.  The `total` in the response reflects the row count **after** grouping, so it matches the number of pages you need to fetch.  **Date filtering** accepts either a Unix timestamp (integer) or a date string parseable by PHP `strtotime()` such as `2024-01-15`, `last monday`, or `2024-01-01 00:00:00`.  Examples: `startDate=1704067200&endDate=1706745599` or `startDate=2024-01-01&endDate=2024-01-31`.  **Sorting** is controlled by `sort` and `dir`.  Currently the only sort key is `time` (default), which orders by internal row ID.  **Delivery status** can be filtered with the `delivered` parameter: `delivered=1` returns only successfully delivered messages; `delivered=0` returns messages still in queue or that failed.  **Address filtering** distinguishes between the SMTP envelope address (`from`, `to`) and message headers (`headerfrom` for the `From:` header, `replyto` for `Reply-To:`). These may differ when a message is sent on behalf of another address.  The `mailid` parameter corresponds to the `id` field in the returned `MailLogEntry` objects, **not** the `_id` field.  It also matches the transaction ID returned in the `text` field of a successful send response from `/mail/send`, `/mail/advsend`, or `/mail/rawsend`.  The `messageId` parameter searches the `Message-ID` email header (case-insensitive substring match). 
-spec view_mail_log(ctx:ctx()) -> {ok, MailBabyErlangClient_mail_log:MailBabyErlangClient_mail_log(), MailBabyErlangClient_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), MailBabyErlangClient_utils:response_info()}.
view_mail_log(Ctx) ->
    view_mail_log(Ctx, #{}).

-spec view_mail_log(ctx:ctx(), maps:map()) -> {ok, MailBabyErlangClient_mail_log:MailBabyErlangClient_mail_log(), MailBabyErlangClient_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), MailBabyErlangClient_utils:response_info()}.
view_mail_log(Ctx, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(MailBabyErlangClient_api, config, #{})),

    Method = get,
    Path = [?BASE_URL, "/mail/log"],
    QS = lists:flatten([])++MailBabyErlangClient_utils:optional_params(['id', 'origin', 'mx', 'from', 'to', 'subject', 'mailid', 'messageId', 'replyto', 'headerfrom', 'delivered', 'skip', 'limit', 'startDate', 'endDate', 'sort', 'dir', 'groupby'], _OptionalParams),
    Headers = [],
    Body1 = [],
    ContentTypeHeader = MailBabyErlangClient_utils:select_header_content_type([]),
    Opts = maps:get(hackney_opts, Optional, []),

    MailBabyErlangClient_utils:request(Ctx, Method, Path, QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).


