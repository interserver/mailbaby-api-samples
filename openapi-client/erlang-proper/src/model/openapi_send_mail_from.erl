-module(openapi_send_mail_from).

-include("openapi.hrl").

-export([openapi_send_mail_from/0]).

-export([openapi_send_mail_from/1]).

-export_type([openapi_send_mail_from/0]).

-type openapi_send_mail_from() ::
  [ {'email', binary() }
  | {'name', binary() }
  ].


openapi_send_mail_from() ->
    openapi_send_mail_from([]).

openapi_send_mail_from(Fields) ->
  Default = [ {'email', binary() }
            , {'name', binary() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

