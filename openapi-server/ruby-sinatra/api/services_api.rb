require 'json'


MyApp.add_route('GET', '/mail/{id}', {
  "resourcePath" => "/Services",
  "summary" => "Get one mail order's full detail including SMTP password",
  "nickname" => "get_mail_order_by_id",
  "responseClass" => "MailOrderDetail",
  "endpoint" => "/mail/{id}",
  "notes" => "**Returns the SMTP password** in addition to the basic `GET /mail` fields. Use when you need to authenticate against `relay.mailbaby.net:25` from an SMTP client directly. Required: `id` (path; obtain from `GET /mail`). Returns the full detail record for one specific mail order identified by its numeric `id`.  The `username` and `password` values returned here can be used directly to authenticate against `relay.mailbaby.net:25` (SMTP AUTH) if you need to send email via a native SMTP client rather than through the REST API.  The `id` path parameter is the same integer `id` value returned by `GET /mail`. ",
  "parameters" => [
    {
      "name" => "id",
      "description" => "The numeric ID of the mail order.",
      "dataType" => "Integer",
      "paramType" => "path",
    },
    ]}) do
  cross_origin
  # the guts live here

  {"message" => "yes, it worked"}.to_json
end


MyApp.add_route('GET', '/mail', {
  "resourcePath" => "/Services",
  "summary" => "List your provisioned mail orders (sending accounts)",
  "nickname" => "get_mail_orders",
  "responseClass" => "Array<MailOrder>",
  "endpoint" => "/mail",
  "notes" => "Use this **before sending** if you need to discover which mail order `id` to pass to `/mail/send`, `/mail/advsend`, `/mail/rawsend`, `/mail/log`, or `/mail/stats`. Returns every mail order (active **and** canceled) on your account. Each record includes the numeric `id`, the `status` (`active` or `canceled`), the SMTP `username` (always `mb<id>`), and an optional `comment`.  The `id` values returned here are used as the `id` input parameter on all sending endpoints (`/mail/send`, `/mail/advsend`, `/mail/rawsend`) as well as the log and stats queries.  When the `id` parameter is omitted on those calls the API automatically picks the **first active** order returned by this endpoint.  To retrieve full details — including the current SMTP password — for a single order use `GET /mail/{id}`. ",
  "parameters" => [
    ]}) do
  cross_origin
  # the guts live here

  {"message" => "yes, it worked"}.to_json
end

