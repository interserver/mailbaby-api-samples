-module(openapi_send_mail).

-include("openapi.hrl").

-export([openapi_send_mail/0]).

-export([openapi_send_mail/1]).

-export_type([openapi_send_mail/0]).

-type openapi_send_mail() ::
  [ {'id', integer() }
  | {'from', openapi_mail_contact:openapi_mail_contact() }
  | {'to', list(openapi_mail_contact:openapi_mail_contact()) }
  | {'subject', binary() }
  | {'body', binary() }
  | {'replyto', list(openapi_mail_contact:openapi_mail_contact()) }
  | {'cc', list(openapi_mail_contact:openapi_mail_contact()) }
  | {'bcc', list(openapi_mail_contact:openapi_mail_contact()) }
  | {'attachments', list(openapi_mail_attachment:openapi_mail_attachment()) }
  ].


openapi_send_mail() ->
    openapi_send_mail([]).

openapi_send_mail(Fields) ->
  Default = [ {'id', integer() }
            , {'from', openapi_mail_contact:openapi_mail_contact() }
            , {'to', list(openapi_mail_contact:openapi_mail_contact()) }
            , {'subject', binary() }
            , {'body', binary() }
            , {'replyto', list(openapi_mail_contact:openapi_mail_contact()) }
            , {'cc', list(openapi_mail_contact:openapi_mail_contact()) }
            , {'bcc', list(openapi_mail_contact:openapi_mail_contact()) }
            , {'attachments', list(openapi_mail_attachment:openapi_mail_attachment()) }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

