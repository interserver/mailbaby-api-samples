-module(MailBabyErlangClient_blocking_api).

-export([add_rule/3, add_rule/4,
         delete_rule/2, delete_rule/3,
         delist_block/2, delist_block/3,
         get_mail_blocks/1, get_mail_blocks/2,
         get_rules/1, get_rules/2]).

-define(BASE_URL, <<"">>).

%% @doc Create a deny rule to block a sender, domain, destination, or prefix
%% **Use this to prevent future relay attempts that match a pattern.** Required: `type` (`email`, `domain`, `destination`, or `startswith`) and `data` (the value to match). Optional: `user` (SMTP username; auto-selects first active order if omitted). Adds a deny rule to block specific senders, domains, destinations, or sender prefixes from being relayed through your mail account.  The `type` field selects the matching strategy: - **`email`** — exact match against the SMTP envelope `MAIL FROM` address. - **`domain`** — matches any sender address at the specified domain. - **`destination`** — exact match against the SMTP envelope `RCPT TO` address. - **`startswith`** — matches any sender address whose local-part (the portion   before the `@`) starts with the given string.  Only alphanumeric characters   and `+`, `_`, `.`, `-` are permitted in the prefix.   If `username` is provided it must be the SMTP username of one of your active mail orders (e.g. `mb20682`).  If omitted the rule is associated with your first active order.  On success the response `text` field contains the newly created rule's `id`, which can later be passed to `DELETE /mail/rules/{ruleId}` to remove it. 
-spec add_rule(ctx:ctx(), binary(), binary()) -> {ok, MailBabyErlangClient_generic_response:MailBabyErlangClient_generic_response(), MailBabyErlangClient_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), MailBabyErlangClient_utils:response_info()}.
add_rule(Ctx, Type, Data) ->
    add_rule(Ctx, Type, Data, #{}).

-spec add_rule(ctx:ctx(), binary(), binary(), maps:map()) -> {ok, MailBabyErlangClient_generic_response:MailBabyErlangClient_generic_response(), MailBabyErlangClient_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), MailBabyErlangClient_utils:response_info()}.
add_rule(Ctx, Type, Data, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(MailBabyErlangClient_api, config, #{})),

    Method = post,
    Path = [?BASE_URL, "/mail/rules"],
    QS = [],
    Headers = [],
    Body1 = {form, [{<<"type">>, Type}, {<<"data">>, Data}]++MailBabyErlangClient_utils:optional_params(['user'], _OptionalParams)},
    ContentTypeHeader = MailBabyErlangClient_utils:select_header_content_type([<<"application/x-www-form-urlencoded">>, <<"application/json">>]),
    Opts = maps:get(hackney_opts, Optional, []),

    MailBabyErlangClient_utils:request(Ctx, Method, Path, QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).

%% @doc Delete a deny rule by its numeric ruleId
%% **Destructive — permanently removes the rule.** Required: `ruleId` (path param; obtain from the `id` field returned by `GET /mail/rules` or the `text` field returned by `POST /mail/rules`). Permanently removes a single deny rule identified by its numeric `ruleId`.  The `ruleId` is the `id` field returned by `GET /mail/rules` or the `text` field from a successful `POST /mail/rules` response.  Only rules belonging to your own active mail account(s) can be deleted — the server will reject attempts to delete rules that belong to a different account. 
-spec delete_rule(ctx:ctx(), integer()) -> {ok, MailBabyErlangClient_generic_response:MailBabyErlangClient_generic_response(), MailBabyErlangClient_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), MailBabyErlangClient_utils:response_info()}.
delete_rule(Ctx, RuleId) ->
    delete_rule(Ctx, RuleId, #{}).

-spec delete_rule(ctx:ctx(), integer(), maps:map()) -> {ok, MailBabyErlangClient_generic_response:MailBabyErlangClient_generic_response(), MailBabyErlangClient_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), MailBabyErlangClient_utils:response_info()}.
delete_rule(Ctx, RuleId, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(MailBabyErlangClient_api, config, #{})),

    Method = delete,
    Path = [?BASE_URL, "/mail/rules/", RuleId, ""],
    QS = [],
    Headers = [],
    Body1 = [],
    ContentTypeHeader = MailBabyErlangClient_utils:select_header_content_type([]),
    Opts = maps:get(hackney_opts, Optional, []),

    MailBabyErlangClient_utils:request(Ctx, Method, Path, QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).

%% @doc Delist an email address from the spam-filter block lists
%% **Destructive — wipes block records for the given address.** Required: `email` (must be a valid address; typically a `from` value previously returned by `GET /mail/blocks` or `GET /mail/log`). Delists an email address from all three block list stores: 1. The rspamd spam-filter database (`fromemail` / envelope sender records). 2. The MailChannels integration block table. 3. The MailBaby internal block table.  Use `GET /mail/blocks` to discover which addresses are currently blocked.  The `from` field in any returned block entry is a valid input for this call.  **Note:** Delisting an address removes it from the block tracking databases but does not prevent the spam filter from re-blocking it if future messages continue to trigger filter rules. 
-spec delist_block(ctx:ctx(), MailBabyErlangClient_email_address_param:MailBabyErlangClient_email_address_param()) -> {ok, MailBabyErlangClient_generic_response:MailBabyErlangClient_generic_response(), MailBabyErlangClient_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), MailBabyErlangClient_utils:response_info()}.
delist_block(Ctx, MailBabyErlangClientEmailAddressParam) ->
    delist_block(Ctx, MailBabyErlangClientEmailAddressParam, #{}).

-spec delist_block(ctx:ctx(), MailBabyErlangClient_email_address_param:MailBabyErlangClient_email_address_param(), maps:map()) -> {ok, MailBabyErlangClient_generic_response:MailBabyErlangClient_generic_response(), MailBabyErlangClient_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), MailBabyErlangClient_utils:response_info()}.
delist_block(Ctx, MailBabyErlangClientEmailAddressParam, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(MailBabyErlangClient_api, config, #{})),

    Method = post,
    Path = [?BASE_URL, "/mail/blocks/delete"],
    QS = [],
    Headers = [],
    Body1 = MailBabyErlangClientEmailAddressParam,
    ContentTypeHeader = MailBabyErlangClient_utils:select_header_content_type([<<"application/json">>, <<"application/x-www-form-urlencoded">>]),
    Opts = maps:get(hackney_opts, Optional, []),

    MailBabyErlangClient_utils:request(Ctx, Method, Path, QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).

%% @doc List addresses currently flagged by spam-filter block lists
%% **Use this to discover which addresses to delist.** The `from` value of any returned entry can be passed to `POST /mail/blocks/delete` (as the `email` field) to remove the block. Returns addresses and messages that have been flagged by the spam filtering system for your mail account(s). Three categories are returned:  - **`local`** — messages flagged by the `LOCAL_BL_RCPT` rspamd rule.  These are   messages sent to recipients on your account's local block list. - **`mbtrap`** — messages flagged by the `MBTRAP` rspamd rule.  These are messages   that triggered MailBaby's internal trap / honeypot detection. - **`subject`** — senders whose recent messages contain spam-indicative subjects   (strings containing `@`, `smtp`, `socks4`, or `socks5`) with high repetition   (more than 4 identical subjects from the same sender in the last 3 days).   The `local` and `mbtrap` results cover the last 5 days.  The `subject` results cover the last 3 days.  A sender address returned in any of these lists can be delisted using `POST /mail/blocks/delete` with the `email` field set to that address. 
-spec get_mail_blocks(ctx:ctx()) -> {ok, MailBabyErlangClient_mail_blocks:MailBabyErlangClient_mail_blocks(), MailBabyErlangClient_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), MailBabyErlangClient_utils:response_info()}.
get_mail_blocks(Ctx) ->
    get_mail_blocks(Ctx, #{}).

-spec get_mail_blocks(ctx:ctx(), maps:map()) -> {ok, MailBabyErlangClient_mail_blocks:MailBabyErlangClient_mail_blocks(), MailBabyErlangClient_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), MailBabyErlangClient_utils:response_info()}.
get_mail_blocks(Ctx, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(MailBabyErlangClient_api, config, #{})),

    Method = get,
    Path = [?BASE_URL, "/mail/blocks"],
    QS = [],
    Headers = [],
    Body1 = [],
    ContentTypeHeader = MailBabyErlangClient_utils:select_header_content_type([]),
    Opts = maps:get(hackney_opts, Optional, []),

    MailBabyErlangClient_utils:request(Ctx, Method, Path, QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).

%% @doc List custom deny rules (sender / domain / destination / prefix)
%% **Use this to inspect or pick a `ruleId` to delete.** Returns all deny rules you have configured for your active mail account(s). Deny rules are evaluated **before** a message is transmitted and cause it to be rejected immediately when it matches.  Four rule types are supported: | `type` | `data` format | Effect | |--------|---------------|--------| | `email` | `user@domain.com` | Rejects any message from this exact sender address | | `domain` | `domain.com` | Rejects any message from any address at this domain | | `destination` | `user@domain.com` | Rejects any message addressed to this recipient | | `startswith` | `prefix` | Rejects any message whose sender address begins with this string (alphanumeric, `+`, `_`, `.`, `-` only) |  Use `POST /mail/rules` to add new rules and `DELETE /mail/rules/{ruleId}` to remove them.  The `id` field in each returned record is the value needed for the delete call. 
-spec get_rules(ctx:ctx()) -> {ok, [MailBabyErlangClient_deny_rule_record:MailBabyErlangClient_deny_rule_record()], MailBabyErlangClient_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), MailBabyErlangClient_utils:response_info()}.
get_rules(Ctx) ->
    get_rules(Ctx, #{}).

-spec get_rules(ctx:ctx(), maps:map()) -> {ok, [MailBabyErlangClient_deny_rule_record:MailBabyErlangClient_deny_rule_record()], MailBabyErlangClient_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), MailBabyErlangClient_utils:response_info()}.
get_rules(Ctx, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(MailBabyErlangClient_api, config, #{})),

    Method = get,
    Path = [?BASE_URL, "/mail/rules"],
    QS = [],
    Headers = [],
    Body1 = [],
    ContentTypeHeader = MailBabyErlangClient_utils:select_header_content_type([]),
    Opts = maps:get(hackney_opts, Optional, []),

    MailBabyErlangClient_utils:request(Ctx, Method, Path, QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).


