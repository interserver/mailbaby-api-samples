-module(openapi_email_addresses_types).

-include("openapi.hrl").

-export([openapi_email_addresses_types/0]).

-export([openapi_email_addresses_types/1]).

-export_type([openapi_email_addresses_types/0]).

-type openapi_email_addresses_types() ::
  [ 
  ].


openapi_email_addresses_types() ->
    openapi_email_addresses_types([]).

openapi_email_addresses_types(Fields) ->
  Default = [ 
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

