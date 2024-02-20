-module(openapi_send_mail_adv).

-include("openapi.hrl").

-export([openapi_send_mail_adv/0]).

-export([openapi_send_mail_adv/1]).

-export_type([openapi_send_mail_adv/0]).

-type openapi_send_mail_adv() ::
  [ {'subject', binary() }
  | {'body', binary() }
  | {'from', openapi_email_address_types:openapi_email_address_types() }
  | {'to', openapi_email_addresses_types:openapi_email_addresses_types() }
  | {'replyto', openapi_email_addresses_types:openapi_email_addresses_types() }
  | {'cc', openapi_email_addresses_types:openapi_email_addresses_types() }
  | {'bcc', openapi_email_addresses_types:openapi_email_addresses_types() }
  | {'attachments', list(openapi_mail_attachment:openapi_mail_attachment()) }
  | {'id', integer() }
  ].


openapi_send_mail_adv() ->
    openapi_send_mail_adv([]).

openapi_send_mail_adv(Fields) ->
  Default = [ {'subject', binary() }
            , {'body', binary() }
            , {'from', openapi_email_address_types:openapi_email_address_types() }
            , {'to', openapi_email_addresses_types:openapi_email_addresses_types() }
            , {'replyto', openapi_email_addresses_types:openapi_email_addresses_types() }
            , {'cc', openapi_email_addresses_types:openapi_email_addresses_types() }
            , {'bcc', openapi_email_addresses_types:openapi_email_addresses_types() }
            , {'attachments', list(openapi_mail_attachment:openapi_mail_attachment()) }
            , {'id', integer() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

