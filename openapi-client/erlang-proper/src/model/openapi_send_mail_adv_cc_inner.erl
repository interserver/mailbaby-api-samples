-module(openapi_send_mail_adv_cc_inner).

-include("openapi.hrl").

-export([openapi_send_mail_adv_cc_inner/0]).

-export([openapi_send_mail_adv_cc_inner/1]).

-export_type([openapi_send_mail_adv_cc_inner/0]).

-type openapi_send_mail_adv_cc_inner() ::
  [ {'email', binary() }
  | {'name', binary() }
  ].


openapi_send_mail_adv_cc_inner() ->
    openapi_send_mail_adv_cc_inner([]).

openapi_send_mail_adv_cc_inner(Fields) ->
  Default = [ {'email', binary() }
            , {'name', binary() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

