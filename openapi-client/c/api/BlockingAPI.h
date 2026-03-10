#include <stdlib.h>
#include <stdio.h>
#include "../include/apiClient.h"
#include "../include/list.h"
#include "../external/cJSON.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"
#include "../model/deny_rule_record.h"
#include "../model/email_address_param.h"
#include "../model/error_message.h"
#include "../model/generic_response.h"
#include "../model/mail_blocks.h"

// Enum TYPE for BlockingAPI_addRule
typedef enum  { mailbaby_email_delivery_and_management_service_api_addRule_TYPE_NULL = 0, mailbaby_email_delivery_and_management_service_api_addRule_TYPE_domain, mailbaby_email_delivery_and_management_service_api_addRule_TYPE_email, mailbaby_email_delivery_and_management_service_api_addRule_TYPE_startswith, mailbaby_email_delivery_and_management_service_api_addRule_TYPE_destination } mailbaby_email_delivery_and_management_service_api_addRule_type_e;


// Creates a new email deny rule
//
// Adds a deny rule to block specific senders, domains, destinations, or sender prefixes from being relayed through your mail account.  The `type` field selects the matching strategy: - **`email`** — exact match against the SMTP envelope `MAIL FROM` address. - **`domain`** — matches any sender address at the specified domain. - **`destination`** — exact match against the SMTP envelope `RCPT TO` address. - **`startswith`** — matches any sender address whose local-part (the portion   before the `@`) starts with the given string.  Only alphanumeric characters   and `+`, `_`, `.`, `-` are permitted in the prefix.   If `username` is provided it must be the SMTP username of one of your active mail orders (e.g. `mb20682`).  If omitted the rule is associated with your first active order.  On success the response `text` field contains the newly created rule's `id`, which can later be passed to `DELETE /mail/rules/{ruleId}` to remove it. 
//
generic_response_t*
BlockingAPI_addRule(apiClient_t *apiClient, mailbaby_email_delivery_and_management_service_api_addRule_type_e type, char *data, char *user);


// Removes a deny mail rule
//
// Permanently removes a single deny rule identified by its numeric `ruleId`.  The `ruleId` is the `id` field returned by `GET /mail/rules` or the `text` field from a successful `POST /mail/rules` response.  Only rules belonging to your own active mail account(s) can be deleted — the server will reject attempts to delete rules that belong to a different account. 
//
generic_response_t*
BlockingAPI_deleteRule(apiClient_t *apiClient, int *ruleId);


// Removes an email address from the block lists
//
// Delists an email address from all three block list stores: 1. The rspamd spam-filter database (`fromemail` / envelope sender records). 2. The MailChannels integration block table. 3. The MailBaby internal block table.  Use `GET /mail/blocks` to discover which addresses are currently blocked.  The `from` field in any returned block entry is a valid input for this call.  **Note:** Delisting an address removes it from the block tracking databases but does not prevent the spam filter from re-blocking it if future messages continue to trigger filter rules. 
//
generic_response_t*
BlockingAPI_delistBlock(apiClient_t *apiClient, email_address_param_t *email_address_param);


// Displays a list of blocked email addresses
//
// Returns addresses and messages that have been flagged by the spam filtering system for your mail account(s).  Three categories are returned:  - **`local`** — messages flagged by the `LOCAL_BL_RCPT` rspamd rule.  These are   messages sent to recipients on your account's local block list. - **`mbtrap`** — messages flagged by the `MBTRAP` rspamd rule.  These are messages   that triggered MailBaby's internal trap / honeypot detection. - **`subject`** — senders whose recent messages contain spam-indicative subjects   (strings containing `@`, `smtp`, `socks4`, or `socks5`) with high repetition   (more than 4 identical subjects from the same sender in the last 3 days).   The `local` and `mbtrap` results cover the last 5 days.  The `subject` results cover the last 3 days.  A sender address returned in any of these lists can be delisted using `POST /mail/blocks/delete` with the `email` field set to that address. 
//
mail_blocks_t*
BlockingAPI_getMailBlocks(apiClient_t *apiClient);


// Displays a listing of deny email rules
//
// Returns all deny rules you have configured for your active mail account(s). Deny rules are evaluated **before** a message is transmitted and cause it to be rejected immediately when it matches.  Four rule types are supported: | `type` | `data` format | Effect | |--------|---------------|--------| | `email` | `user@domain.com` | Rejects any message from this exact sender address | | `domain` | `domain.com` | Rejects any message from any address at this domain | | `destination` | `user@domain.com` | Rejects any message addressed to this recipient | | `startswith` | `prefix` | Rejects any message whose sender address begins with this string (alphanumeric, `+`, `_`, `.`, `-` only) |  Use `POST /mail/rules` to add new rules and `DELETE /mail/rules/{ruleId}` to remove them.  The `id` field in each returned record is the value needed for the delete call. 
//
list_t*
BlockingAPI_getRules(apiClient_t *apiClient);


