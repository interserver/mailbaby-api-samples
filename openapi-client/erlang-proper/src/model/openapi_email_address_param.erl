-module(openapi_email_address_param).

-include("openapi.hrl").

-export([openapi_email_address_param/0]).

-export([openapi_email_address_param/1]).

-export_type([openapi_email_address_param/0]).

-type openapi_email_address_param() ::
  [ {'email', binary() }
  ].


openapi_email_address_param() ->
    openapi_email_address_param([]).

openapi_email_address_param(Fields) ->
  Default = [ {'email', binary() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

