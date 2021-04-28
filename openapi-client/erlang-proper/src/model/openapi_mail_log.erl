-module(openapi_mail_log).

-include("openapi.hrl").

-export([openapi_mail_log/0]).

-export([openapi_mail_log/1]).

-export_type([openapi_mail_log/0]).

-type openapi_mail_log() ::
  [ {'id', integer() }
  ].


openapi_mail_log() ->
    openapi_mail_log([]).

openapi_mail_log(Fields) ->
  Default = [ {'id', integer() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

