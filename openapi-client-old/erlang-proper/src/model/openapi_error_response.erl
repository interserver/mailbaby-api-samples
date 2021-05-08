-module(openapi_error_response).

-include("openapi.hrl").

-export([openapi_error_response/0]).

-export([openapi_error_response/1]).

-export_type([openapi_error_response/0]).

-type openapi_error_response() ::
  [ {'code', binary() }
  | {'message', binary() }
  ].


openapi_error_response() ->
    openapi_error_response([]).

openapi_error_response(Fields) ->
  Default = [ {'code', binary() }
            , {'message', binary() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

