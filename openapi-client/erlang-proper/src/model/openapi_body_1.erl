-module(openapi_body_1).

-include("openapi.hrl").

-export([openapi_body_1/0]).

-export([openapi_body_1/1]).

-export_type([openapi_body_1/0]).

-type openapi_body_1() ::
  [ {'to', binary() }
  | {'from', binary() }
  | {'subject', binary() }
  | {'body', binary() }
  ].


openapi_body_1() ->
    openapi_body_1([]).

openapi_body_1(Fields) ->
  Default = [ {'to', binary() }
            , {'from', binary() }
            , {'subject', binary() }
            , {'body', binary() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

