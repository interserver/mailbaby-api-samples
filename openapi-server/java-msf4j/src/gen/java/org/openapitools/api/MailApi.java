package org.openapitools.api;

import org.openapitools.model.*;
import org.openapitools.api.MailApiService;
import org.openapitools.api.factories.MailApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import org.openapitools.model.DenyRuleRecord;
import org.openapitools.model.EmailAddressParam;
import org.openapitools.model.EmailAddressTypes;
import org.openapitools.model.EmailAddressesTypes;
import org.openapitools.model.ErrorMessage;
import org.openapitools.model.GenericResponse;
import java.util.List;
import org.openapitools.model.MailAttachment;
import org.openapitools.model.MailBlocks;
import org.openapitools.model.MailLog;
import org.openapitools.model.MailOrder;
import org.openapitools.model.MailOrderDetail;
import org.openapitools.model.MailStatsType;
import org.openapitools.model.SendMailRaw;
import org.openapitools.model.SendMailTo;

import java.util.List;
import org.openapitools.api.NotFoundException;

import java.io.InputStream;

import org.wso2.msf4j.formparam.FormDataParam;
import org.wso2.msf4j.formparam.FileInfo;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/mail")


@io.swagger.annotations.Api(description = "the mail API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaMSF4JServerCodegen", comments = "Generator version: 7.26.0")
public class MailApi  {
   private final MailApiService delegate = MailApiServiceFactory.getMailApi();

    @POST
    @Path("/rules")
    @Consumes({ "application/x-www-form-urlencoded", "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create a deny rule to block a sender, domain, destination, or prefix", notes = "**Use this to prevent future relay attempts that match a pattern.** Required: `type` (`email`, `domain`, `destination`, or `startswith`) and `data` (the value to match). Optional: `user` (SMTP username; auto-selects first active order if omitted). Adds a deny rule to block specific senders, domains, destinations, or sender prefixes from being relayed through your mail account.  The `type` field selects the matching strategy: - **`email`** — exact match against the SMTP envelope `MAIL FROM` address. - **`domain`** — matches any sender address at the specified domain. - **`destination`** — exact match against the SMTP envelope `RCPT TO` address. - **`startswith`** — matches any sender address whose local-part (the portion   before the `@`) starts with the given string.  Only alphanumeric characters   and `+`, `_`, `.`, `-` are permitted in the prefix.   If `username` is provided it must be the SMTP username of one of your active mail orders (e.g. `mb20682`).  If omitted the rule is associated with your first active order.  On success the response `text` field contains the newly created rule's `id`, which can later be passed to `DELETE /mail/rules/{ruleId}` to remove it. ", response = GenericResponse.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "apiKeyAuth")
    }, tags={ "Blocking", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Rule created successfully", response = GenericResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request — one or more input parameters were missing or invalid.", response = GenericResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).", response = GenericResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "The specified resource was not found or does not belong to your account.", response = GenericResponse.class) })
    public Response addRule(@ApiParam(value = "The matching strategy for this rule.  `email` blocks an exact sender address, `domain` blocks all senders at a domain, `destination` blocks an exact recipient address, and `startswith` blocks any sender whose local-part begins with the given prefix.", required=true, allowableValues="domain, email, startswith, destination")  @FormParam("type")  String type
,@ApiParam(value = "The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.", required=true)  @FormParam("data")  String data
,@ApiParam(value = "Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.")  @FormParam("user")  String user
)
    throws NotFoundException {
        return delegate.addRule(type,data,user);
    }
    @DELETE
    @Path("/rules/{ruleId}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete a deny rule by its numeric ruleId", notes = "**Destructive — permanently removes the rule.** Required: `ruleId` (path param; obtain from the `id` field returned by `GET /mail/rules` or the `text` field returned by `POST /mail/rules`). Permanently removes a single deny rule identified by its numeric `ruleId`.  The `ruleId` is the `id` field returned by `GET /mail/rules` or the `text` field from a successful `POST /mail/rules` response.  Only rules belonging to your own active mail account(s) can be deleted — the server will reject attempts to delete rules that belong to a different account. ", response = GenericResponse.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "apiKeyAuth")
    }, tags={ "Blocking", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Rule deleted successfully", response = GenericResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request — one or more input parameters were missing or invalid.", response = GenericResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).", response = GenericResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "The specified resource was not found or does not belong to your account.", response = GenericResponse.class) })
    public Response deleteRule(@ApiParam(value = "The numeric ID of the deny rule to delete.  Obtain this from the `id` field in `GET /mail/rules` or the `text` field of a `POST /mail/rules` response.",required=true) @PathParam("ruleId") Integer ruleId
)
    throws NotFoundException {
        return delegate.deleteRule(ruleId);
    }
    @POST
    @Path("/blocks/delete")
    @Consumes({ "application/json", "application/x-www-form-urlencoded" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delist an email address from the spam-filter block lists", notes = "**Destructive — wipes block records for the given address.** Required: `email` (must be a valid address; typically a `from` value previously returned by `GET /mail/blocks` or `GET /mail/log`). Delists an email address from all three block list stores: 1. The rspamd spam-filter database (`fromemail` / envelope sender records). 2. The MailChannels integration block table. 3. The MailBaby internal block table.  Use `GET /mail/blocks` to discover which addresses are currently blocked.  The `from` field in any returned block entry is a valid input for this call.  **Note:** Delisting an address removes it from the block tracking databases but does not prevent the spam filter from re-blocking it if future messages continue to trigger filter rules. ", response = GenericResponse.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "apiKeyAuth")
    }, tags={ "Blocking", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Address successfully delisted", response = GenericResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request — one or more input parameters were missing or invalid.", response = GenericResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).", response = GenericResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "The specified resource was not found or does not belong to your account.", response = GenericResponse.class) })
    public Response delistBlock(@ApiParam(value = "" ,required=true) EmailAddressParam emailAddressParam
)
    throws NotFoundException {
        return delegate.delistBlock(emailAddressParam);
    }
    @GET
    @Path("/blocks")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List addresses currently flagged by spam-filter block lists", notes = "**Use this to discover which addresses to delist.** The `from` value of any returned entry can be passed to `POST /mail/blocks/delete` (as the `email` field) to remove the block. Returns addresses and messages that have been flagged by the spam filtering system for your mail account(s). Three categories are returned:  - **`local`** — messages flagged by the `LOCAL_BL_RCPT` rspamd rule.  These are   messages sent to recipients on your account's local block list. - **`mbtrap`** — messages flagged by the `MBTRAP` rspamd rule.  These are messages   that triggered MailBaby's internal trap / honeypot detection. - **`subject`** — senders whose recent messages contain spam-indicative subjects   (strings containing `@`, `smtp`, `socks4`, or `socks5`) with high repetition   (more than 4 identical subjects from the same sender in the last 3 days).   The `local` and `mbtrap` results cover the last 5 days.  The `subject` results cover the last 3 days.  A sender address returned in any of these lists can be delisted using `POST /mail/blocks/delete` with the `email` field set to that address. ", response = MailBlocks.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "apiKeyAuth")
    }, tags={ "Blocking", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = MailBlocks.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).", response = MailBlocks.class) })
    public Response getMailBlocks()
    throws NotFoundException {
        return delegate.getMailBlocks();
    }
    @GET
    @Path("/{id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get one mail order's full detail including SMTP password", notes = "**Returns the SMTP password** in addition to the basic `GET /mail` fields. Use when you need to authenticate against `relay.mailbaby.net:25` from an SMTP client directly. Required: `id` (path; obtain from `GET /mail`). Returns the full detail record for one specific mail order identified by its numeric `id`.  The `username` and `password` values returned here can be used directly to authenticate against `relay.mailbaby.net:25` (SMTP AUTH) if you need to send email via a native SMTP client rather than through the REST API.  The `id` path parameter is the same integer `id` value returned by `GET /mail`. ", response = MailOrderDetail.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "apiKeyAuth")
    }, tags={ "Services", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = MailOrderDetail.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request — one or more input parameters were missing or invalid.", response = MailOrderDetail.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).", response = MailOrderDetail.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "The specified resource was not found or does not belong to your account.", response = MailOrderDetail.class) })
    public Response getMailOrderById(@ApiParam(value = "The numeric ID of the mail order.",required=true) @PathParam("id") Long id
)
    throws NotFoundException {
        return delegate.getMailOrderById(id);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List your provisioned mail orders (sending accounts)", notes = "Use this **before sending** if you need to discover which mail order `id` to pass to `/mail/send`, `/mail/advsend`, `/mail/rawsend`, `/mail/log`, or `/mail/stats`. Returns every mail order (active **and** canceled) on your account. Each record includes the numeric `id`, the `status` (`active` or `canceled`), the SMTP `username` (always `mb<id>`), and an optional `comment`.  The `id` values returned here are used as the `id` input parameter on all sending endpoints (`/mail/send`, `/mail/advsend`, `/mail/rawsend`) as well as the log and stats queries.  When the `id` parameter is omitted on those calls the API automatically picks the **first active** order returned by this endpoint.  To retrieve full details — including the current SMTP password — for a single order use `GET /mail/{id}`. ", response = MailOrder.class, responseContainer = "List", authorizations = {
        @io.swagger.annotations.Authorization(value = "apiKeyAuth")
    }, tags={ "Services", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = MailOrder.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).", response = MailOrder.class, responseContainer = "List") })
    public Response getMailOrders()
    throws NotFoundException {
        return delegate.getMailOrders();
    }
    @GET
    @Path("/rules")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List custom deny rules (sender / domain / destination / prefix)", notes = "**Use this to inspect or pick a `ruleId` to delete.** Returns all deny rules you have configured for your active mail account(s). Deny rules are evaluated **before** a message is transmitted and cause it to be rejected immediately when it matches.  Four rule types are supported: | `type` | `data` format | Effect | |--------|---------------|--------| | `email` | `user@domain.com` | Rejects any message from this exact sender address | | `domain` | `domain.com` | Rejects any message from any address at this domain | | `destination` | `user@domain.com` | Rejects any message addressed to this recipient | | `startswith` | `prefix` | Rejects any message whose sender address begins with this string (alphanumeric, `+`, `_`, `.`, `-` only) |  Use `POST /mail/rules` to add new rules and `DELETE /mail/rules/{ruleId}` to remove them.  The `id` field in each returned record is the value needed for the delete call. ", response = DenyRuleRecord.class, responseContainer = "List", authorizations = {
        @io.swagger.annotations.Authorization(value = "apiKeyAuth")
    }, tags={ "Blocking", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = DenyRuleRecord.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).", response = DenyRuleRecord.class, responseContainer = "List") })
    public Response getRules()
    throws NotFoundException {
        return delegate.getRules();
    }
    @GET
    @Path("/stats")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Account usage, cost, and volume statistics for a time window", notes = "**Use this for dashboards or billing-cycle reviews.** Returns aggregate sending statistics for your mail account(s). The `time` query param controls the window for `received`, `sent`, and `volume` (`1h`, `24h`, `7d`, `month`, `day`, `billing`, `all`). The `usage` and `cost` fields are always for the current billing cycle, regardless of `time`.  The response includes: - **`usage`** — total messages accepted by the relay during the current billing   cycle (used for cost calculation). - **`cost`** — estimated cost for the billing cycle based on the base plan price   plus per-email charges. - **`received`** / **`sent`** — count of messages accepted by the relay /   successfully delivered to the destination MX within the selected `time` window. - **`volume`** — top-500 breakdown of message counts grouped by source IP (`ip`),   destination address (`to`), and sender address (`from`) within the selected window.   **Time windows** (controlled by the `time` parameter): | Value | Window | |-------|--------| | `1h` | Last 1 hour (default) | | `24h` | Last 24 hours | | `7d` | Last 7 days | | `month` | Current calendar month (1st to now) | | `day` | Today (midnight to now) | | `billing` | Current billing cycle (last invoice date to next invoice date) | | `all` | All time | ", response = MailStatsType.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "apiKeyAuth")
    }, tags={ "History", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = MailStatsType.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).", response = MailStatsType.class) })
    public Response getStats(@ApiParam(value = "The time window to scope `received`, `sent`, and `volume` statistics. Does not affect `usage` or `cost`, which are always calculated over the current billing cycle. Defaults to `1h`.", allowableValues="all, billing, month, 7d, 24h, day, 1h", defaultValue="1h") @DefaultValue("1h") @QueryParam("time") String time
)
    throws NotFoundException {
        return delegate.getStats(time);
    }
    @POST
    @Path("/rawsend")
    @Consumes({ "application/json", "multipart/form-data" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Send a pre-built RFC 822 message verbatim (preserves DKIM)", notes = "**Use this when you have already built (and possibly DKIM-signed) the full RFC 822 message yourself** and want the relay to transmit it byte-for-byte. Required: `raw_email` (full RFC 822 string with headers + body). Optional: `id` (mail order to authenticate as). Accepts a complete, pre-built RFC 822 email message (headers + body) as a string and injects it into the relay without any modification.  This endpoint is particularly useful when the message has already been **DKIM-signed** — because the relay transmits the exact bytes you provide, the DKIM signature remains intact. If you use the other sending endpoints the relay may add or reorder headers, breaking an existing signature.  The `From` and recipient addresses are parsed automatically from the message headers (`From`, `To`, `Cc`, `Bcc`).  You do **not** need to specify them separately.  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  The SMTP credentials for the selected order are used to authenticate with the relay.  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record. ", response = GenericResponse.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "apiKeyAuth")
    }, tags={ "Sending", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Email accepted for delivery", response = GenericResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request — one or more input parameters were missing or invalid.", response = GenericResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).", response = GenericResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "The specified resource was not found or does not belong to your account.", response = GenericResponse.class) })
    public Response rawMail(@ApiParam(value = "" ,required=true) SendMailRaw sendMailRaw
)
    throws NotFoundException {
        return delegate.rawMail(sendMailRaw);
    }
    @POST
    @Path("/advsend")
    @Consumes({ "application/x-www-form-urlencoded", "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Send email with multiple recipients, CC/BCC, attachments, named contacts", notes = "**Use this when the simple send is not enough** — multiple recipients, CC/BCC, named contacts, custom Reply-To, or file attachments. Required: `from`, `to`, `subject`, `body`. Optional: `cc`, `bcc`, `replyto`, `attachments` (array of `{filename,data}` with base64 data), `id`. Sends through one of your mail orders with full control over recipients, headers, and attachments.  **Content-type flexibility** — the request body may be submitted as either `application/x-www-form-urlencoded` or `application/json`.  When using form encoding, address fields (`from`, `to`, `replyto`, `cc`, `bcc`) accept both a plain RFC 822 comma-separated string (e.g. `\"Joe <joe@example.com>, jane@example.com\"`) and the structured `[{\"email\":\"...\",\"name\":\"...\"}]` array format.  When using JSON, both formats are equally supported.  **HTML detection** is automatic — if `body` contains HTML tags the `Content-Type` is set to `text/html`; otherwise `text/plain`.  **Attachments** must be base64-encoded.  Each attachment requires at least a `data` field; the optional `filename` field controls the attachment name shown to recipients.  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  On success the response `text` field contains the relay transaction ID which can be looked up in `GET /mail/log` via the `mailid` query parameter.  ## Examples  ### Form — basic string addresses ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' \\   -d 'body=Hello' \\   -d from=user@domain.com \\   -d to=support@interserver.net ``` ### Form — RFC 822 named addresses ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' \\   -d 'body=Hello' \\   -d 'from=Joe <user@domain.com>' \\   -d 'to=Jane <support@interserver.net>' ``` ### Form — multiple recipients as array ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' -d 'body=Hello' \\   -d from=user@domain.com \\   -d 'to[0][name]=Joe' -d 'to[0][email]=support@interserver.net' \\   -d 'to[1][name]=Jane' -d 'to[1][email]=jane@interserver.net' ``` ### JSON — structured objects ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/json' \\   -d '{     \"subject\": \"Welcome\",     \"body\": \"<h1>Hello</h1>\",     \"from\": {\"email\": \"user@domain.com\", \"name\": \"Sender Name\"},     \"to\": [{\"email\": \"joe@client.com\", \"name\": \"Joe Client\"}],     \"cc\": [{\"email\": \"manager@client.com\"}],     \"attachments\": [{\"filename\": \"report.pdf\", \"data\": \"BASE64_DATA\"}]   }' ``` ", response = GenericResponse.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "apiKeyAuth")
    }, tags={ "Sending", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Email accepted for delivery", response = GenericResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request — one or more input parameters were missing or invalid.", response = GenericResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).", response = GenericResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "The specified resource was not found or does not belong to your account.", response = GenericResponse.class) })
    public Response sendAdvMail(@ApiParam(value = "The subject line of the email.", required=true)  @FormParam("subject")  String subject
,@ApiParam(value = "The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.", required=true)  @FormParam("body")  String body
,@ApiParam(value = "The sender address.  Accepts a plain email string, an RFC 822 named string (`\\\"Name <email>\\\"`), or a `{\\\"email\\\": \\\"...\\\", \\\"name\\\": \\\"...\\\"}` object.", required=true)  @FormParam("from")  EmailAddressTypes from
,@ApiParam(value = "One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.", required=true)  @FormParam("to")  EmailAddressesTypes to
,@ApiParam(value = "Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`.")  @FormParam("replyto")  EmailAddressesTypes replyto
,@ApiParam(value = "Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients.")  @FormParam("cc")  EmailAddressesTypes cc
,@ApiParam(value = "Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.")  @FormParam("bcc")  EmailAddressesTypes bcc
,@ApiParam(value = "Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.")  @FormParam("attachments")  List<@Valid MailAttachment> attachments
,@ApiParam(value = "Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.")  @FormParam("id")  Long id
)
    throws NotFoundException {
        return delegate.sendAdvMail(subject,body,from,to,replyto,cc,bcc,attachments,id);
    }
    @POST
    @Path("/send")
    @Consumes({ "application/x-www-form-urlencoded", "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Send a simple email (single recipient, plain or HTML)", notes = "**Use this for the simplest case** — one or a few plain-string recipients, no attachments, no CC/BCC, no named contacts. Required: `from`, `to`, `subject`, `body`. Optional: `id` (selects which mail order to send through; auto-selects your first active order if omitted). Sends through one of your mail orders using a flat set of fields.  **HTML detection** is automatic — if the `body` value contains any HTML tags the message will be sent as `text/html`; otherwise it is sent as `text/plain`.  The `from` address is also automatically set as the `Reply-To` header.  *Note*: If you need to send to multiple recipients, add CC/BCC, or include file attachments, use `POST /mail/advsend` instead.  If you have a pre-built RFC 822 message (e.g. already DKIM-signed), use `POST /mail/rawsend`.  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record. ", response = GenericResponse.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "apiKeyAuth")
    }, tags={ "Sending", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Email accepted for delivery", response = GenericResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request — one or more input parameters were missing or invalid.", response = GenericResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).", response = GenericResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "The specified resource was not found or does not belong to your account.", response = GenericResponse.class) })
    public Response sendMail(@ApiParam(value = "", required=true)  @FormParam("to")  SendMailTo to
,@ApiParam(value = "The sender address.  This is used as both the `From` header and the `Reply-To` header automatically.  Must be a valid email address authorized for your mail order.", required=true)  @FormParam("from")  String from
,@ApiParam(value = "The subject line of the email.", required=true)  @FormParam("subject")  String subject
,@ApiParam(value = "The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.", required=true)  @FormParam("body")  String body
,@ApiParam(value = "Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.")  @FormParam("id")  Long id
)
    throws NotFoundException {
        return delegate.sendMail(to,from,subject,body,id);
    }
    @GET
    @Path("/log")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Query the mail delivery log (filterable, paginated)", notes = "**Use this to find or audit sent messages.** All filters are optional and combinable. The most useful filters: `mailid` (the transaction id returned by a send call), `from` / `to` (envelope addresses), `subject`, `messageId` (case-insensitive substring on the `Message-ID` header), `delivered` (`1`=delivered, `0`=queued/failed), and the `startDate`/`endDate` date range. Returns a paginated list of every email message accepted by the relay for your mail account(s).  **Row grouping** is controlled by the `groupby` parameter.  By default (`groupby=recipient`), the response contains one row per delivery attempt — so a single message sent to 4 recipients produces 4 rows, each with its own `recipient`, `delivered`, `response`, and `mxHostname` values.  Set `groupby=message` to collapse to one row per message (delivery fields will reflect one arbitrary recipient).  **Pagination** is controlled by `skip` and `limit`.  The `total` in the response reflects the row count **after** grouping, so it matches the number of pages you need to fetch.  **Date filtering** accepts either a Unix timestamp (integer) or a date string parseable by PHP `strtotime()` such as `2024-01-15`, `last monday`, or `2024-01-01 00:00:00`.  Examples: `startDate=1704067200&endDate=1706745599` or `startDate=2024-01-01&endDate=2024-01-31`.  **Sorting** is controlled by `sort` and `dir`.  Currently the only sort key is `time` (default), which orders by internal row ID.  **Delivery status** can be filtered with the `delivered` parameter: `delivered=1` returns only successfully delivered messages; `delivered=0` returns messages still in queue or that failed.  **Address filtering** distinguishes between the SMTP envelope address (`from`, `to`) and message headers (`headerfrom` for the `From:` header, `replyto` for `Reply-To:`). These may differ when a message is sent on behalf of another address.  The `mailid` parameter corresponds to the `id` field in the returned `MailLogEntry` objects, **not** the `_id` field.  It also matches the transaction ID returned in the `text` field of a successful send response from `/mail/send`, `/mail/advsend`, or `/mail/rawsend`.  The `messageId` parameter searches the `Message-ID` email header (case-insensitive substring match). ", response = MailLog.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "apiKeyAuth")
    }, tags={ "History", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Paginated list of mail log entries", response = MailLog.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request — one or more input parameters were missing or invalid.", response = MailLog.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).", response = MailLog.class) })
    public Response viewMailLog(@ApiParam(value = "The numeric ID of the mail order to filter by.  When omitted, logs from the first active mail order are returned.  Obtain valid IDs from `GET /mail` or `GET /mail/{id}`.") @QueryParam("id") Long id
,@ApiParam(value = "Filter by the originating IP address from which the message was submitted to the relay.  Must be a valid IPv4 or IPv6 address.") @QueryParam("origin") String origin
,@ApiParam(value = "Filter by the MX hostname the relay attempted delivery to.  For example `mx.google.com` would return messages destined for Gmail recipients. Maps to `mxHostname` in the `MailLogEntry` response.") @QueryParam("mx") String mx
,@ApiParam(value = "Filter by SMTP envelope `MAIL FROM` address (exact match).  This is the address the relay used for bounce handling and may differ from the `From:` message header.  For header-level filtering use `headerfrom`.") @QueryParam("from") String from
,@ApiParam(value = "Filter by SMTP envelope `RCPT TO` address (exact match).  This is the delivery address used by the relay and may differ from the `To:` header when BCC recipients are involved.") @QueryParam("to") String to
,@ApiParam(value = "Filter by email `Subject` header (exact match).  To search for a substring, include it in the full subject text.") @QueryParam("subject") String subject
,@ApiParam(value = "Filter by the relay-assigned mail ID string (exact match).  This corresponds to the `id` field in `MailLogEntry` and to the `text` value returned by the sending endpoints on success.  Format is an 18–19 character hexadecimal string such as `185997065c60008840`.") @QueryParam("mailid") String mailid
,@ApiParam(value = "Filter by the `Message-ID` email header using a substring (case-insensitive) match. The `Message-ID` is assigned by the sending mail client and is visible in the `messageId` field of `MailLogEntry`.  Useful when you know the message ID generated by your application but not the relay `mailid`.") @QueryParam("messageId") String messageId
,@ApiParam(value = "Filter by the `Reply-To` message header address (exact match).  Only returns messages where this header was explicitly set.") @QueryParam("replyto") String replyto
,@ApiParam(value = "Filter by the `From` message header address (exact match).  This is the human-visible sender address and may differ from the SMTP envelope `from` parameter when sending on behalf of another address.") @QueryParam("headerfrom") String headerfrom
,@ApiParam(value = "Filter by delivery status.  `1` returns only messages that were successfully delivered to the destination MX.  `0` returns messages that are still queued, deferred, or failed.  Omit to return all messages regardless of delivery status.", allowableValues="0, 1") @QueryParam("delivered") Integer delivered
,@ApiParam(value = "Number of records to skip for pagination.  Use in combination with `limit` to page through large result sets.  Defaults to `0` (no skip).", defaultValue="0") @DefaultValue("0") @QueryParam("skip") Integer skip
,@ApiParam(value = "Maximum number of records to return per page.  Defaults to `100`. Maximum allowed value is `10000`.  The response also includes a `total` field with the full matched count so you can calculate the number of pages.", defaultValue="100") @DefaultValue("100") @QueryParam("limit") Integer limit
,@ApiParam(value = "Earliest date to include.  Accepts either a Unix timestamp (integer seconds since epoch) or a date string parseable by `strtotime()` such as `2024-01-15` or `last monday`.  Messages with a `time` value **greater than or equal to** this value will be included.") @QueryParam("startDate") String startDate
,@ApiParam(value = "Latest date to include.  Accepts either a Unix timestamp (integer seconds since epoch) or a date string parseable by `strtotime()` such as `2024-01-31` or `yesterday`. Messages with a `time` value **less than or equal to** this value will be included.") @QueryParam("endDate") String endDate
,@ApiParam(value = "Field to sort results by.  Currently only `time` is supported (sorts by internal row ID which corresponds to chronological order).", allowableValues="time", defaultValue="time") @DefaultValue("time") @QueryParam("sort") String sort
,@ApiParam(value = "Sort direction.  `desc` returns newest first (default), `asc` returns oldest first.", allowableValues="asc, desc", defaultValue="desc") @DefaultValue("desc") @QueryParam("dir") String dir
,@ApiParam(value = "Controls how results are grouped.  `recipient` (default) returns one row per delivery attempt — a message sent to 4 recipients produces 4 rows, each with its own `recipient`, `delivered`, `response`, and delivery metadata.  `message` collapses to one row per unique message ID; delivery-level fields will reflect one arbitrary recipient per message.  The `total` count in the response matches the grouping mode.", allowableValues="message, recipient", defaultValue="recipient") @DefaultValue("recipient") @QueryParam("groupby") String groupby
)
    throws NotFoundException {
        return delegate.viewMailLog(id,origin,mx,from,to,subject,mailid,messageId,replyto,headerfrom,delivered,skip,limit,startDate,endDate,sort,dir,groupby);
    }
}
