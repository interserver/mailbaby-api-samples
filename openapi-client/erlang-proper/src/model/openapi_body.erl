-module(openapi_body).

-include("openapi.hrl").

-export([openapi_body/0]).

-export([openapi_body/1]).

-export_type([openapi_body/0]).

-type openapi_body() ::
  [ {'to', binary() }
  | {'from', binary() }
  | {'subject', binary() }
  | {'body', binary() }
  ].


openapi_body() ->
    openapi_body([]).

openapi_body(Fields) ->
  Default = [ {'to', binary() }
            , {'from', binary() }
            , {'subject', binary() }
            , {'body', binary() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

