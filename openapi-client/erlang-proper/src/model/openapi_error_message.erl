-module(openapi_error_message).

-include("openapi.hrl").

-export([openapi_error_message/0]).

-export([openapi_error_message/1]).

-export_type([openapi_error_message/0]).

-type openapi_error_message() ::
  [ {'code', integer() }
  | {'message', binary() }
  ].


openapi_error_message() ->
    openapi_error_message([]).

openapi_error_message(Fields) ->
  Default = [ {'code', integer() }
            , {'message', binary() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

