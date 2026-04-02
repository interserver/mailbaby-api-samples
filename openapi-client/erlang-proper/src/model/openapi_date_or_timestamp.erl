-module(openapi_date_or_timestamp).

-include("openapi.hrl").

-export([openapi_date_or_timestamp/0]).

-export([openapi_date_or_timestamp/1]).

-export_type([openapi_date_or_timestamp/0]).

-type openapi_date_or_timestamp() ::
  [ 
  ].


openapi_date_or_timestamp() ->
    openapi_date_or_timestamp([]).

openapi_date_or_timestamp(Fields) ->
  Default = [ 
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

