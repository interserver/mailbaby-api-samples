-module(openapi_raw_mail).

-include("openapi.hrl").

-export([openapi_raw_mail/0]).

-export([openapi_raw_mail/1]).

-export_type([openapi_raw_mail/0]).

-type openapi_raw_mail() ::
  [ {'raw_email', binary() }
  ].


openapi_raw_mail() ->
    openapi_raw_mail([]).

openapi_raw_mail(Fields) ->
  Default = [ {'raw_email', binary() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

