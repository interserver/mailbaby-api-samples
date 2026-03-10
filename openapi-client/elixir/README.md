# MailBabyEmailDeliveryAndManagementServiceAPI

**Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.**  # Overview  This is the API interface to the [Mail Baby](https://mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net).  # Mail Orders  Every sending account in MailBaby is backed by a **Mail Order** — a provisioned sending credential with a numeric &#x60;id&#x60; and a corresponding SMTP username (&#x60;mb&lt;id&gt;&#x60;).  Most calls accept an optional &#x60;id&#x60; parameter; when omitted the API automatically selects the first active order on your account. Use &#x60;GET /mail&#x60; to list all orders, and &#x60;GET /mail/{id}&#x60; to inspect a single order including its current SMTP password.  # Sending Email  Three sending methods are available depending on your use-case: | Endpoint | Best for | |----------|----------| | &#x60;POST /mail/send&#x60; | Simple single-recipient messages | | &#x60;POST /mail/advsend&#x60; | Multiple recipients, CC/BCC, attachments, named contacts | | &#x60;POST /mail/rawsend&#x60; | Pre-built RFC 822 messages (e.g. DKIM-signed payloads) |  After a successful send each endpoint returns a &#x60;GenericResponse&#x60; whose &#x60;text&#x60; field contains the **transaction ID** assigned by the relay.  This ID can later be matched against entries in &#x60;GET /mail/log&#x60; via the &#x60;mailid&#x60; query parameter.  # Filtering &amp; Logs  &#x60;GET /mail/log&#x60; provides paginated access to every message accepted by the relay for your account.  Combine any of the query parameters to narrow results — e.g. &#x60;from&#x60;, &#x60;to&#x60;, &#x60;subject&#x60;, &#x60;messageId&#x60;, &#x60;origin&#x60;, &#x60;mx&#x60;, &#x60;startDate&#x60;/&#x60;endDate&#x60;, and &#x60;delivered&#x60;.  # Blocking  Two independent mechanisms exist for suppressing unwanted email: - **Block lists** (&#x60;GET /mail/blocks&#x60;, &#x60;POST /mail/blocks/delete&#x60;) — addresses flagged by the   system spam filters (LOCAL_BL_RCPT / MBTRAP rules in rspamd, and suspicious subjects). - **Deny rules** (&#x60;GET /mail/rules&#x60;, &#x60;POST /mail/rules&#x60;, &#x60;DELETE /mail/rules/{ruleId}&#x60;) —   custom rules you configure to reject specific senders, domains, destination addresses, or   subject-line prefixes before a message is even attempted.   # Authentication  In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. Pass your key in the &#x60;X-API-KEY&#x60; HTTP request header for every protected call. 

## Building

To install the required dependencies and to build the elixir project, run:

```console
mix local.hex --force
mix do deps.get, compile
```

## Installation

If [available in Hex][], the package can be installed by adding `mail_baby_email_delivery_and_management_service_api` to
your list of dependencies in `mix.exs`:

```elixir
def deps do
  [{:mail_baby_email_delivery_and_management_service_api, "~> 1.0.0"}]
end
```

Documentation can be generated with [ExDoc][] and published on [HexDocs][]. Once published, the docs can be found at
[https://hexdocs.pm/mail_baby_email_delivery_and_management_service_api][docs].

## Configuration

You can override the URL of your server (e.g. if you have a separate development and production server in your
configuration files).

```elixir
config :mail_baby_email_delivery_and_management_service_api, base_url: "https://api.mailbaby.net"
```

Multiple clients for the same API with different URLs can be created passing different `base_url`s when calling
`MailBabyEmailDeliveryAndManagementServiceAPI.Connection.new/1`:

```elixir
client = MailBabyEmailDeliveryAndManagementServiceAPI.Connection.new(base_url: "https://api.mailbaby.net")
```

[exdoc]: https://github.com/elixir-lang/ex_doc
[hexdocs]: https://hexdocs.pm
[available in hex]: https://hex.pm/docs/publish
[docs]: https://hexdocs.pm/mail_baby_email_delivery_and_management_service_api
