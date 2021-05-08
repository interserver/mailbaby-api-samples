-module(openapi_inline_response_401).

-include("openapi.hrl").

-export([openapi_inline_response_401/0]).

-export([openapi_inline_response_401/1]).

-export_type([openapi_inline_response_401/0]).

-type openapi_inline_response_401() ::
  [ {'code', binary() }
  | {'message', binary() }
  ].


openapi_inline_response_401() ->
    openapi_inline_response_401([]).

openapi_inline_response_401(Fields) ->
  Default = [ {'code', binary() }
            , {'message', binary() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

