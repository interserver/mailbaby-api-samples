# MailBabyEmailDeliveryAndManagementServiceAPI

**Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 

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
