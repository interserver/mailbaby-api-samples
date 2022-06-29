-module(openapi_get_mail_orders_401_response).

-include("openapi.hrl").

-export([openapi_get_mail_orders_401_response/0]).

-export([openapi_get_mail_orders_401_response/1]).

-export_type([openapi_get_mail_orders_401_response/0]).

-type openapi_get_mail_orders_401_response() ::
  [ {'code', binary() }
  | {'message', binary() }
  ].


openapi_get_mail_orders_401_response() ->
    openapi_get_mail_orders_401_response([]).

openapi_get_mail_orders_401_response(Fields) ->
  Default = [ {'code', binary() }
            , {'message', binary() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

