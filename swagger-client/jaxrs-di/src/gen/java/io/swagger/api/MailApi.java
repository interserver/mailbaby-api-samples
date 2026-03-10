package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.MailApiService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import io.swagger.model.DenyRuleNew;
import io.swagger.model.DenyRuleRecord;
import io.swagger.model.EmailAddressParam;
import io.swagger.model.EmailAddressTypes;
import io.swagger.model.EmailAddressesTypes;
import io.swagger.model.ErrorMessage;
import io.swagger.model.GenericResponse;
import io.swagger.model.MailAttachment;
import io.swagger.model.MailBlocks;
import io.swagger.model.MailLog;
import io.swagger.model.MailOrder;
import io.swagger.model.MailOrderDetail;
import io.swagger.model.MailStatsType;
import io.swagger.model.SendMail;
import io.swagger.model.SendMailAdv;
import io.swagger.model.SendMailRaw;
import io.swagger.model.SendMailTo;

import java.util.Map;
import java.util.List;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/mail")



public class MailApi  {

   private MailApiService delegate;

   protected MailApi() {
   }

   @javax.inject.Inject
   public MailApi(MailApiService delegate) {
      this.delegate = delegate;
   }

    @POST
    @Path("/rules")
    @Consumes({ "application/x-www-form-urlencoded", "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Creates a new email deny rule", description = "Adds a deny rule to block specific senders, domains, destinations, or sender prefixes from being relayed through your mail account.  The `type` field selects the matching strategy: - **`email`** — exact match against the SMTP envelope `MAIL FROM` address. - **`domain`** — matches any sender address at the specified domain. - **`destination`** — exact match against the SMTP envelope `RCPT TO` address. - **`startswith`** — matches any sender address whose local-part (the portion   before the `@`) starts with the given string.  Only alphanumeric characters   and `+`, `_`, `.`, `-` are permitted in the prefix.   If `username` is provided it must be the SMTP username of one of your active mail orders (e.g. `mb20682`).  If omitted the rule is associated with your first active order.  On success the response `text` field contains the newly created rule's `id`, which can later be passed to `DELETE /mail/rules/{ruleId}` to remove it. ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Blocking" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Rule created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad request — one or more input parameters were missing or invalid.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "401", description = "Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found or does not belong to your account.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public Response addRule(@Parameter(description = "", required=true)  @FormParam("user")  String user,@Parameter(description = "", required=true, schema=@Schema(allowableValues={ "domain", "email", "startswith", "destination" })
)  @FormParam("type")  String type,@Parameter(description = "", required=true)  @FormParam("data")  String data,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addRule(user,type,data,securityContext);
    }
    @POST
    @Path("/rules")
    @Consumes({ "application/x-www-form-urlencoded", "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Creates a new email deny rule", description = "Adds a deny rule to block specific senders, domains, destinations, or sender prefixes from being relayed through your mail account.  The `type` field selects the matching strategy: - **`email`** — exact match against the SMTP envelope `MAIL FROM` address. - **`domain`** — matches any sender address at the specified domain. - **`destination`** — exact match against the SMTP envelope `RCPT TO` address. - **`startswith`** — matches any sender address whose local-part (the portion   before the `@`) starts with the given string.  Only alphanumeric characters   and `+`, `_`, `.`, `-` are permitted in the prefix.   If `username` is provided it must be the SMTP username of one of your active mail orders (e.g. `mb20682`).  If omitted the rule is associated with your first active order.  On success the response `text` field contains the newly created rule's `id`, which can later be passed to `DELETE /mail/rules/{ruleId}` to remove it. ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Blocking" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Rule created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad request — one or more input parameters were missing or invalid.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "401", description = "Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found or does not belong to your account.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public Response addRule(@Parameter(in = ParameterIn.DEFAULT, description = "Fields required to create a new email deny rule." ,required=true) DenyRuleNew body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addRule(body,securityContext);
    }
    @DELETE
    @Path("/rules/{ruleId}")
    
    @Produces({ "application/json" })
    @Operation(summary = "Removes a deny mail rule", description = "Permanently removes a single deny rule identified by its numeric `ruleId`.  The `ruleId` is the `id` field returned by `GET /mail/rules` or the `text` field from a successful `POST /mail/rules` response.  Only rules belonging to your own active mail account(s) can be deleted — the server will reject attempts to delete rules that belong to a different account. ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Blocking" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Rule deleted successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad request — one or more input parameters were missing or invalid.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "401", description = "Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found or does not belong to your account.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public Response deleteRule(@Parameter(in = ParameterIn.PATH, description = "The numeric ID of the deny rule to delete.  Obtain this from the `id` field in `GET /mail/rules` or the `text` field of a `POST /mail/rules` response.",required=true) @PathParam("ruleId") Integer ruleId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteRule(ruleId,securityContext);
    }
    @POST
    @Path("/blocks/delete")
    @Consumes({ "application/json", "multipart/form-data" })
    @Produces({ "application/json" })
    @Operation(summary = "Removes an email address from the block lists", description = "Delists an email address from all three block list stores: 1. The rspamd spam-filter database (`fromemail` / envelope sender records). 2. The MailChannels integration block table. 3. The MailBaby internal block table.  Use `GET /mail/blocks` to discover which addresses are currently blocked.  The `from` field in any returned block entry is a valid input for this call.  **Note:** Delisting an address removes it from the block tracking databases but does not prevent the spam filter from re-blocking it if future messages continue to trigger filter rules. ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Blocking" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Address successfully delisted", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad request — one or more input parameters were missing or invalid.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "401", description = "Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found or does not belong to your account.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public Response delistBlock(@Parameter(in = ParameterIn.DEFAULT, description = "" ,required=true) EmailAddressParam body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.delistBlock(body,securityContext);
    }
    @POST
    @Path("/blocks/delete")
    @Consumes({ "application/json", "multipart/form-data" })
    @Produces({ "application/json" })
    @Operation(summary = "Removes an email address from the block lists", description = "Delists an email address from all three block list stores: 1. The rspamd spam-filter database (`fromemail` / envelope sender records). 2. The MailChannels integration block table. 3. The MailBaby internal block table.  Use `GET /mail/blocks` to discover which addresses are currently blocked.  The `from` field in any returned block entry is a valid input for this call.  **Note:** Delisting an address removes it from the block tracking databases but does not prevent the spam filter from re-blocking it if future messages continue to trigger filter rules. ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Blocking" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Address successfully delisted", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad request — one or more input parameters were missing or invalid.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "401", description = "Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found or does not belong to your account.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public Response delistBlock(@Parameter(description = "", required=true)  @FormParam("email")  String email,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.delistBlock(email,securityContext);
    }
    @GET
    @Path("/blocks")
    
    @Produces({ "application/json" })
    @Operation(summary = "Displays a list of blocked email addresses", description = "Returns addresses and messages that have been flagged by the spam filtering system for your mail account(s).  Three categories are returned:  - **`local`** — messages flagged by the `LOCAL_BL_RCPT` rspamd rule.  These are   messages sent to recipients on your account's local block list. - **`mbtrap`** — messages flagged by the `MBTRAP` rspamd rule.  These are messages   that triggered MailBaby's internal trap / honeypot detection. - **`subject`** — senders whose recent messages contain spam-indicative subjects   (strings containing `@`, `smtp`, `socks4`, or `socks5`) with high repetition   (more than 4 identical subjects from the same sender in the last 3 days).   The `local` and `mbtrap` results cover the last 5 days.  The `subject` results cover the last 3 days.  A sender address returned in any of these lists can be delisted using `POST /mail/blocks/delete` with the `email` field set to that address. ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Blocking" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MailBlocks.class))),
        
        @ApiResponse(responseCode = "401", description = "Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public Response getMailBlocks(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getMailBlocks(securityContext);
    }
    @GET
    @Path("/{id}")
    
    @Produces({ "application/json" })
    @Operation(summary = "Displays details for a single mail order", description = "Returns the full detail record for one specific mail order identified by its numeric `id`.  In addition to the fields returned by `GET /mail`, this endpoint also includes the current **SMTP password** for the order.  The `username` and `password` values returned here can be used directly to authenticate against `relay.mailbaby.net:25` (SMTP AUTH) if you need to send email via a native SMTP client rather than through the REST API.  The `id` path parameter is the same integer `id` value returned by `GET /mail`. ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Services" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MailOrderDetail.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad request — one or more input parameters were missing or invalid.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "401", description = "Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found or does not belong to your account.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public Response getMailOrderById(@Parameter(in = ParameterIn.PATH, description = "The numeric ID of the mail order.",required=true) @PathParam("id") Long id,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getMailOrderById(id,securityContext);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @Operation(summary = "Displays a list of mail service orders", description = "Returns every mail order (active **and** inactive) associated with your account. Each record includes the numeric `id`, the `status` (`active` or `canceled`), the SMTP `username` (always `mb<id>`), and an optional human-readable `comment`.  The `id` values returned here are used as the `id` input parameter on all sending endpoints (`/mail/send`, `/mail/advsend`, `/mail/rawsend`) as well as the log and stats queries.  When the `id` parameter is omitted on those calls the API automatically picks the **first active** order returned by this endpoint.  To retrieve full details — including the current SMTP password — for a single order use `GET /mail/{id}`. ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Services" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MailOrder.class)))),
        
        @ApiResponse(responseCode = "401", description = "Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public Response getMailOrders(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getMailOrders(securityContext);
    }
    @GET
    @Path("/rules")
    
    @Produces({ "application/json" })
    @Operation(summary = "Displays a listing of deny email rules", description = "Returns all deny rules you have configured for your active mail account(s). Deny rules are evaluated **before** a message is transmitted and cause it to be rejected immediately when it matches.  Four rule types are supported: | `type` | `data` format | Effect | |--------|---------------|--------| | `email` | `user@domain.com` | Rejects any message from this exact sender address | | `domain` | `domain.com` | Rejects any message from any address at this domain | | `destination` | `user@domain.com` | Rejects any message addressed to this recipient | | `startswith` | `prefix` | Rejects any message whose sender address begins with this string (alphanumeric, `+`, `_`, `.`, `-` only) |  Use `POST /mail/rules` to add new rules and `DELETE /mail/rules/{ruleId}` to remove them.  The `id` field in each returned record is the value needed for the delete call. ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Blocking" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = DenyRuleRecord.class)))),
        
        @ApiResponse(responseCode = "401", description = "Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public Response getRules(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getRules(securityContext);
    }
    @GET
    @Path("/stats")
    
    @Produces({ "application/json" })
    @Operation(summary = "Account usage statistics", description = "Returns aggregate sending statistics for your mail account(s) across a selectable time window.  Useful for dashboards, billing reviews, and detecting unusual traffic patterns.  The response includes: - **`usage`** — total messages accepted by the relay during the current billing   cycle (used for cost calculation). - **`cost`** — estimated cost for the billing cycle based on the base plan price   plus per-email charges. - **`received`** / **`sent`** — count of messages accepted by the relay /   successfully delivered to the destination MX within the selected `time` window. - **`volume`** — top-500 breakdown of message counts grouped by source IP (`ip`),   destination address (`to`), and sender address (`from`) within the selected window.   **Time windows** (controlled by the `time` parameter): | Value | Window | |-------|--------| | `1h` | Last 1 hour (default) | | `24h` | Last 24 hours | | `7d` | Last 7 days | | `month` | Current calendar month (1st to now) | | `day` | Today (midnight to now) | | `billing` | Current billing cycle (last invoice date to next invoice date) | | `all` | All time | ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "History" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MailStatsType.class))),
        
        @ApiResponse(responseCode = "401", description = "Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public Response getStats(@Parameter(in = ParameterIn.QUERY, description = "The time window to scope `received`, `sent`, and `volume` statistics. Does not affect `usage` or `cost`, which are always calculated over the current billing cycle.  Defaults to `1h`.", schema=@Schema(allowableValues={ "all", "billing", "month", "7d", "24h", "day", "1h" })
) @DefaultValue("1h") @QueryParam("time") String time,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getStats(time,securityContext);
    }
    @POST
    @Path("/rawsend")
    @Consumes({ "application/json", "multipart/form-data" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends a raw RFC 822 email", description = "Accepts a complete, pre-built RFC 822 email message (headers + body) as a string and injects it into the relay without any modification.  This endpoint is particularly useful when the message has already been **DKIM-signed** — because the relay transmits the exact bytes you provide, the DKIM signature remains intact.  If you use the other sending endpoints the relay may add or reorder headers, breaking an existing signature.  The `From` and recipient addresses are parsed automatically from the message headers (`From`, `To`, `Cc`, `Bcc`).  You do **not** need to specify them separately.  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  The SMTP credentials for the selected order are used to authenticate with the relay.  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record. ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Sending" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Email accepted for delivery", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad request — one or more input parameters were missing or invalid.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "401", description = "Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found or does not belong to your account.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public Response rawMail(@Parameter(in = ParameterIn.DEFAULT, description = "" ,required=true) SendMailRaw body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.rawMail(body,securityContext);
    }
    @POST
    @Path("/rawsend")
    @Consumes({ "application/json", "multipart/form-data" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends a raw RFC 822 email", description = "Accepts a complete, pre-built RFC 822 email message (headers + body) as a string and injects it into the relay without any modification.  This endpoint is particularly useful when the message has already been **DKIM-signed** — because the relay transmits the exact bytes you provide, the DKIM signature remains intact.  If you use the other sending endpoints the relay may add or reorder headers, breaking an existing signature.  The `From` and recipient addresses are parsed automatically from the message headers (`From`, `To`, `Cc`, `Bcc`).  You do **not** need to specify them separately.  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  The SMTP credentials for the selected order are used to authenticate with the relay.  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record. ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Sending" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Email accepted for delivery", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad request — one or more input parameters were missing or invalid.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "401", description = "Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found or does not belong to your account.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public Response rawMail(@Parameter(description = "", required=true)  @FormParam("raw_email")  String rawEmail,@Parameter(description = "", required=true)  @FormParam("id")  Long id,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.rawMail(rawEmail,id,securityContext);
    }
    @POST
    @Path("/advsend")
    @Consumes({ "application/x-www-form-urlencoded", "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email with Advanced Options", description = "Sends an email through one of your mail orders with full control over recipients, headers, and attachments.  Supports multiple To / CC / BCC addresses, named contacts, Reply-To overrides, and base64-encoded file attachments.  **Content-type flexibility** — the request body may be submitted as either `application/x-www-form-urlencoded` or `application/json`.  When using form encoding, address fields (`from`, `to`, `replyto`, `cc`, `bcc`) accept both a plain RFC 822 comma-separated string (e.g. `\"Joe <joe@example.com>, jane@example.com\"`) and the structured `[{\"email\":\"...\",\"name\":\"...\"}]` array format.  When using JSON, both formats are equally supported.  **HTML detection** is automatic — if `body` contains HTML tags the `Content-Type` is set to `text/html`; otherwise `text/plain`.  **Attachments** must be base64-encoded.  Each attachment requires at least a `data` field; the optional `filename` field controls the attachment name shown to recipients.  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  On success the response `text` field contains the relay transaction ID which can be looked up in `GET /mail/log` via the `mailid` query parameter.  ## Examples  ### Form — basic string addresses ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' \\   -d 'body=Hello' \\   -d from=user@domain.com \\   -d to=support@interserver.net ``` ### Form — RFC 822 named addresses ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' \\   -d 'body=Hello' \\   -d 'from=Joe <user@domain.com>' \\   -d 'to=Jane <support@interserver.net>' ``` ### Form — multiple recipients as array ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' -d 'body=Hello' \\   -d from=user@domain.com \\   -d 'to[0][name]=Joe' -d 'to[0][email]=support@interserver.net' \\   -d 'to[1][name]=Jane' -d 'to[1][email]=jane@interserver.net' ``` ### JSON — structured objects ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/json' \\   -d '{     \"subject\": \"Welcome\",     \"body\": \"<h1>Hello</h1>\",     \"from\": {\"email\": \"user@domain.com\", \"name\": \"Sender Name\"},     \"to\": [{\"email\": \"joe@client.com\", \"name\": \"Joe Client\"}],     \"cc\": [{\"email\": \"manager@client.com\"}],     \"attachments\": [{\"filename\": \"report.pdf\", \"data\": \"BASE64_DATA\"}]   }' ``` ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Sending" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Email accepted for delivery", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad request — one or more input parameters were missing or invalid.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "401", description = "Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found or does not belong to your account.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public Response sendAdvMail(@Parameter(description = "", required=true)  @FormParam("subject")  String subject,@Parameter(description = "", required=true)  @FormParam("body")  String body,@Parameter(description = "", required=true)  @FormParam("from")  EmailAddressTypes from,@Parameter(description = "", required=true)  @FormParam("to")  EmailAddressesTypes to,@Parameter(description = "", required=true)  @FormParam("replyto")  EmailAddressesTypes replyto,@Parameter(description = "", required=true)  @FormParam("cc")  EmailAddressesTypes cc,@Parameter(description = "", required=true)  @FormParam("bcc")  EmailAddressesTypes bcc,@Parameter(description = "", required=true)  @FormParam("attachments")  List<MailAttachment> attachments,@Parameter(description = "", required=true)  @FormParam("id")  Long id,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.sendAdvMail(subject,body,from,to,replyto,cc,bcc,attachments,id,securityContext);
    }
    @POST
    @Path("/advsend")
    @Consumes({ "application/x-www-form-urlencoded", "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email with Advanced Options", description = "Sends an email through one of your mail orders with full control over recipients, headers, and attachments.  Supports multiple To / CC / BCC addresses, named contacts, Reply-To overrides, and base64-encoded file attachments.  **Content-type flexibility** — the request body may be submitted as either `application/x-www-form-urlencoded` or `application/json`.  When using form encoding, address fields (`from`, `to`, `replyto`, `cc`, `bcc`) accept both a plain RFC 822 comma-separated string (e.g. `\"Joe <joe@example.com>, jane@example.com\"`) and the structured `[{\"email\":\"...\",\"name\":\"...\"}]` array format.  When using JSON, both formats are equally supported.  **HTML detection** is automatic — if `body` contains HTML tags the `Content-Type` is set to `text/html`; otherwise `text/plain`.  **Attachments** must be base64-encoded.  Each attachment requires at least a `data` field; the optional `filename` field controls the attachment name shown to recipients.  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  On success the response `text` field contains the relay transaction ID which can be looked up in `GET /mail/log` via the `mailid` query parameter.  ## Examples  ### Form — basic string addresses ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' \\   -d 'body=Hello' \\   -d from=user@domain.com \\   -d to=support@interserver.net ``` ### Form — RFC 822 named addresses ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' \\   -d 'body=Hello' \\   -d 'from=Joe <user@domain.com>' \\   -d 'to=Jane <support@interserver.net>' ``` ### Form — multiple recipients as array ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' -d 'body=Hello' \\   -d from=user@domain.com \\   -d 'to[0][name]=Joe' -d 'to[0][email]=support@interserver.net' \\   -d 'to[1][name]=Jane' -d 'to[1][email]=jane@interserver.net' ``` ### JSON — structured objects ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/json' \\   -d '{     \"subject\": \"Welcome\",     \"body\": \"<h1>Hello</h1>\",     \"from\": {\"email\": \"user@domain.com\", \"name\": \"Sender Name\"},     \"to\": [{\"email\": \"joe@client.com\", \"name\": \"Joe Client\"}],     \"cc\": [{\"email\": \"manager@client.com\"}],     \"attachments\": [{\"filename\": \"report.pdf\", \"data\": \"BASE64_DATA\"}]   }' ``` ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Sending" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Email accepted for delivery", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad request — one or more input parameters were missing or invalid.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "401", description = "Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found or does not belong to your account.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public Response sendAdvMail(@Parameter(in = ParameterIn.DEFAULT, description = "" ,required=true) SendMailAdv body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.sendAdvMail(body,securityContext);
    }
    @POST
    @Path("/send")
    @Consumes({ "application/x-www-form-urlencoded", "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email", description = "Sends an email through one of your mail orders using a simple flat set of fields. This is the quickest way to send a single-recipient plain-text or HTML message.  **HTML detection** is automatic — if the `body` value contains any HTML tags the message will be sent as `text/html`; otherwise it is sent as `text/plain`.  The `from` address is also automatically set as the `Reply-To` header.  *Note*: If you need to send to multiple recipients, add CC/BCC, or include file attachments, use `POST /mail/advsend` instead.  If you have a pre-built RFC 822 message (e.g. already DKIM-signed), use `POST /mail/rawsend`.  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record. ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Sending" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Email accepted for delivery", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad request — one or more input parameters were missing or invalid.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "401", description = "Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found or does not belong to your account.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public Response sendMail(@Parameter(description = "", required=true)  @FormParam("to")  SendMailTo to,@Parameter(description = "", required=true)  @FormParam("from")  String from,@Parameter(description = "", required=true)  @FormParam("subject")  String subject,@Parameter(description = "", required=true)  @FormParam("body")  String body,@Parameter(description = "", required=true)  @FormParam("id")  Long id,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.sendMail(to,from,subject,body,id,securityContext);
    }
    @POST
    @Path("/send")
    @Consumes({ "application/x-www-form-urlencoded", "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Sends an Email", description = "Sends an email through one of your mail orders using a simple flat set of fields. This is the quickest way to send a single-recipient plain-text or HTML message.  **HTML detection** is automatic — if the `body` value contains any HTML tags the message will be sent as `text/html`; otherwise it is sent as `text/plain`.  The `from` address is also automatically set as the `Reply-To` header.  *Note*: If you need to send to multiple recipients, add CC/BCC, or include file attachments, use `POST /mail/advsend` instead.  If you have a pre-built RFC 822 message (e.g. already DKIM-signed), use `POST /mail/rawsend`.  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record. ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "Sending" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Email accepted for delivery", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad request — one or more input parameters were missing or invalid.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "401", description = "Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found or does not belong to your account.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public Response sendMail(@Parameter(in = ParameterIn.DEFAULT, description = "" ,required=true) SendMail body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.sendMail(body,securityContext);
    }
    @GET
    @Path("/log")
    
    @Produces({ "application/json" })
    @Operation(summary = "Displays the mail log", description = "Returns a paginated list of every email message accepted by the relay for your mail account(s).  All filter parameters are optional and combinable.  **Pagination** is controlled by `skip` and `limit`.  The response includes a `total` count so clients can determine how many pages exist.  **Date filtering** uses Unix timestamps (`startDate` / `endDate`).  For example, to retrieve emails sent in January 2024: `startDate=1704067200&endDate=1706745599`.  **Delivery status** can be filtered with the `delivered` parameter: `delivered=1` returns only successfully delivered messages; `delivered=0` returns messages still in queue or that failed.  **Address filtering** distinguishes between the SMTP envelope address (`from`, `to`) and message headers (`headerfrom` for the `From:` header, `replyto` for `Reply-To:`). These may differ when a message is sent on behalf of another address.  The `mailid` parameter corresponds to the `id` field in the returned `MailLogEntry` objects, **not** the `_id` field.  It also matches the transaction ID returned in the `text` field of a successful send response from `/mail/send`, `/mail/advsend`, or `/mail/rawsend`.  The `messageId` parameter searches the `Message-ID` email header (case-insensitive substring match). ", security = {
        @SecurityRequirement(name = "apiKeyAuth")    }, tags={ "History" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Paginated list of mail log entries", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MailLog.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad request — one or more input parameters were missing or invalid.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        
        @ApiResponse(responseCode = "401", description = "Authentication failed.  Ensure you are sending a valid `X-API-KEY` header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
    public Response viewMailLog(@Parameter(in = ParameterIn.QUERY, description = "The numeric ID of the mail order to filter by.  When omitted, logs from the first active mail order are returned.  Obtain valid IDs from `GET /mail` or `GET /mail/{id}`.") @QueryParam("id") Long id,@Parameter(in = ParameterIn.QUERY, description = "Filter by the originating IP address from which the message was submitted to the relay.  Must be a valid IPv4 or IPv6 address.") @QueryParam("origin") String origin,@Parameter(in = ParameterIn.QUERY, description = "Filter by the MX hostname the relay attempted delivery to.  For example `mx.google.com` would return messages destined for Gmail recipients. Maps to `mxHostname` in the `MailLogEntry` response.") @QueryParam("mx") String mx,@Parameter(in = ParameterIn.QUERY, description = "Filter by SMTP envelope `MAIL FROM` address (exact match).  This is the address the relay used for bounce handling and may differ from the `From:` message header.  For header-level filtering use `headerfrom`.") @QueryParam("from") String from,@Parameter(in = ParameterIn.QUERY, description = "Filter by SMTP envelope `RCPT TO` address (exact match).  This is the delivery address used by the relay and may differ from the `To:` header when BCC recipients are involved.") @QueryParam("to") String to,@Parameter(in = ParameterIn.QUERY, description = "Filter by email `Subject` header (exact match).  To search for a substring, include it in the full subject text.") @QueryParam("subject") String subject,@Parameter(in = ParameterIn.QUERY, description = "Filter by the relay-assigned mail ID string (exact match).  This corresponds to the `id` field in `MailLogEntry` and to the `text` value returned by the sending endpoints on success.  Format is an 18–19 character hexadecimal string such as `185997065c60008840`.") @QueryParam("mailid") String mailid,@Parameter(in = ParameterIn.QUERY, description = "Filter by the `Message-ID` email header using a substring (case-insensitive) match.  The `Message-ID` is assigned by the sending mail client and is visible in the `messageId` field of `MailLogEntry`.  Useful when you know the message ID generated by your application but not the relay `mailid`.") @QueryParam("messageId") String messageId,@Parameter(in = ParameterIn.QUERY, description = "Filter by the `Reply-To` message header address (exact match).  Only returns messages where this header was explicitly set.") @QueryParam("replyto") String replyto,@Parameter(in = ParameterIn.QUERY, description = "Filter by the `From` message header address (exact match).  This is the human-visible sender address and may differ from the SMTP envelope `from` parameter when sending on behalf of another address.") @QueryParam("headerfrom") String headerfrom,@Parameter(in = ParameterIn.QUERY, description = "Filter by delivery status.  `1` returns only messages that were successfully delivered to the destination MX.  `0` returns messages that are still queued, deferred, or failed.  Omit to return all messages regardless of delivery status.", schema=@Schema(allowableValues={ "0", "1" })
) @QueryParam("delivered") Integer delivered,@Parameter(in = ParameterIn.QUERY, description = "Number of records to skip for pagination.  Use in combination with `limit` to page through large result sets.  Defaults to `0` (no skip).", schema=@Schema(allowableValues={ "0" })
) @DefaultValue("0") @QueryParam("skip") Integer skip,@Parameter(in = ParameterIn.QUERY, description = "Maximum number of records to return per page.  Defaults to `100`. Maximum allowed value is `10000`.  The response also includes a `total` field with the full matched count so you can calculate the number of pages.", schema=@Schema(allowableValues={ "1", "10000" }, minimum="1", maximum="10000")
) @DefaultValue("100") @QueryParam("limit") Integer limit,@Parameter(in = ParameterIn.QUERY, description = "Earliest date to include, as a Unix timestamp (seconds since epoch). Messages with a `time` value **greater than or equal to** this value will be included.", schema=@Schema(allowableValues={ "0", "9999999999" }, maximum="9999999999")
) @QueryParam("startDate") Long startDate,@Parameter(in = ParameterIn.QUERY, description = "Latest date to include, as a Unix timestamp (seconds since epoch). Messages with a `time` value **less than or equal to** this value will be included.", schema=@Schema(allowableValues={ "0", "9999999999" }, maximum="9999999999")
) @QueryParam("endDate") Long endDate,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.viewMailLog(id,origin,mx,from,to,subject,mailid,messageId,replyto,headerfrom,delivered,skip,limit,startDate,endDate,securityContext);
    }
}
