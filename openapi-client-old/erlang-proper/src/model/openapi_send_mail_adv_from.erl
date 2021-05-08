-module(openapi_send_mail_adv_from).

-include("openapi.hrl").

-export([openapi_send_mail_adv_from/0]).

-export([openapi_send_mail_adv_from/1]).

-export_type([openapi_send_mail_adv_from/0]).

-type openapi_send_mail_adv_from() ::
  [ {'email', binary() }
  | {'name', binary() }
  ].


openapi_send_mail_adv_from() ->
    openapi_send_mail_adv_from([]).

openapi_send_mail_adv_from(Fields) ->
  Default = [ {'email', binary() }
            , {'name', binary() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

