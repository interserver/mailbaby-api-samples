-module(openapi_send_mail_adv).

-include("openapi.hrl").

-export([openapi_send_mail_adv/0]).

-export([openapi_send_mail_adv/1]).

-export_type([openapi_send_mail_adv/0]).

-type openapi_send_mail_adv() ::
  [ {'subject', binary() }
  | {'body', binary() }
  | {'from', openapi_send_mail_adv_from:openapi_send_mail_adv_from() }
  | {'to', list(openapi_send_mail_adv_to_inner:openapi_send_mail_adv_to_inner()) }
  | {'replyto', list(openapi_send_mail_adv_replyto_inner:openapi_send_mail_adv_replyto_inner()) }
  | {'cc', list(openapi_send_mail_adv_cc_inner:openapi_send_mail_adv_cc_inner()) }
  | {'bcc', list(openapi_send_mail_adv_bcc_inner:openapi_send_mail_adv_bcc_inner()) }
  | {'attachments', list(openapi_send_mail_adv_attachments_inner:openapi_send_mail_adv_attachments_inner()) }
  | {'id', integer() }
  ].


openapi_send_mail_adv() ->
    openapi_send_mail_adv([]).

openapi_send_mail_adv(Fields) ->
  Default = [ {'subject', binary() }
            , {'body', binary() }
            , {'from', openapi_send_mail_adv_from:openapi_send_mail_adv_from() }
            , {'to', list(openapi_send_mail_adv_to_inner:openapi_send_mail_adv_to_inner()) }
            , {'replyto', list(openapi_send_mail_adv_replyto_inner:openapi_send_mail_adv_replyto_inner()) }
            , {'cc', list(openapi_send_mail_adv_cc_inner:openapi_send_mail_adv_cc_inner()) }
            , {'bcc', list(openapi_send_mail_adv_bcc_inner:openapi_send_mail_adv_bcc_inner()) }
            , {'attachments', list(openapi_send_mail_adv_attachments_inner:openapi_send_mail_adv_attachments_inner()) }
            , {'id', integer() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

