-module(openapi_email_address_types).

-include("openapi.hrl").

-export([openapi_email_address_types/0]).

-export([openapi_email_address_types/1]).

-export_type([openapi_email_address_types/0]).

-type openapi_email_address_types() ::
  [ {'email', binary() }
  | {'name', binary() }
  ].


openapi_email_address_types() ->
    openapi_email_address_types([]).

openapi_email_address_types(Fields) ->
  Default = [ {'email', binary() }
            , {'name', binary() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

