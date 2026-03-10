-module(openapi_mail_stats_volume).

-include("openapi.hrl").

-export([openapi_mail_stats_volume/0]).

-export([openapi_mail_stats_volume/1]).

-export_type([openapi_mail_stats_volume/0]).

-type openapi_mail_stats_volume() ::
  [ {'to', map() }
  | {'from', map() }
  | {'ip', map() }
  ].


openapi_mail_stats_volume() ->
    openapi_mail_stats_volume([]).

openapi_mail_stats_volume(Fields) ->
  Default = [ {'to', map() }
            , {'from', map() }
            , {'ip', map() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

