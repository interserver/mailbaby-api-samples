-module(openapi_get_stats_200_response_inner).

-include("openapi.hrl").

-export([openapi_get_stats_200_response_inner/0]).

-export([openapi_get_stats_200_response_inner/1]).

-export_type([openapi_get_stats_200_response_inner/0]).

-type openapi_get_stats_200_response_inner() ::
  [ {'id', integer() }
  | {'status', binary() }
  | {'username', binary() }
  | {'password', binary() }
  | {'comment', binary() }
  ].


openapi_get_stats_200_response_inner() ->
    openapi_get_stats_200_response_inner([]).

openapi_get_stats_200_response_inner(Fields) ->
  Default = [ {'id', integer() }
            , {'status', binary() }
            , {'username', binary() }
            , {'password', binary() }
            , {'comment', binary() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

