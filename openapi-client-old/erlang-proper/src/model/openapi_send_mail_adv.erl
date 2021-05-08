-module(openapi_send_mail_adv).

-include("openapi.hrl").

-export([openapi_send_mail_adv/0]).

-export([openapi_send_mail_adv/1]).

-export_type([openapi_send_mail_adv/0]).

-type openapi_send_mail_adv() ::
  [ {'subject', binary() }
  | {'body', binary() }
  | {'from', list(openapi_send_mail_adv_from:openapi_send_mail_adv_from()) }
  | {'to', list(openapi_mail_contact:openapi_mail_contact()) }
  | {'id', integer() }
  | {'replyto', list(openapi_mail_contact:openapi_mail_contact()) }
  | {'cc', list(openapi_mail_contact:openapi_mail_contact()) }
  | {'bcc', list(openapi_mail_contact:openapi_mail_contact()) }
  | {'attachments', list(openapi_mail_attachment:openapi_mail_attachment()) }
  ].


openapi_send_mail_adv() ->
    openapi_send_mail_adv([]).

openapi_send_mail_adv(Fields) ->
  Default = [ {'subject', binary() }
            , {'body', binary() }
            , {'from', list(openapi_send_mail_adv_from:openapi_send_mail_adv_from()) }
            , {'to', list(openapi_mail_contact:openapi_mail_contact()) }
            , {'id', integer() }
            , {'replyto', list(openapi_mail_contact:openapi_mail_contact()) }
            , {'cc', list(openapi_mail_contact:openapi_mail_contact()) }
            , {'bcc', list(openapi_mail_contact:openapi_mail_contact()) }
            , {'attachments', list(openapi_mail_attachment:openapi_mail_attachment()) }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

