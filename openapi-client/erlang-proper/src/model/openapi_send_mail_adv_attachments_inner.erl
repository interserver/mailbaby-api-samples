-module(openapi_send_mail_adv_attachments_inner).

-include("openapi.hrl").

-export([openapi_send_mail_adv_attachments_inner/0]).

-export([openapi_send_mail_adv_attachments_inner/1]).

-export_type([openapi_send_mail_adv_attachments_inner/0]).

-type openapi_send_mail_adv_attachments_inner() ::
  [ {'filename', binary() }
  | {'data', binary() }
  ].


openapi_send_mail_adv_attachments_inner() ->
    openapi_send_mail_adv_attachments_inner([]).

openapi_send_mail_adv_attachments_inner(Fields) ->
  Default = [ {'filename', binary() }
            , {'data', binary() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

