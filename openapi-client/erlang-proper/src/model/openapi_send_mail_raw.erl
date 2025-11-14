-module(openapi_send_mail_raw).

-include("openapi.hrl").

-export([openapi_send_mail_raw/0]).

-export([openapi_send_mail_raw/1]).

-export_type([openapi_send_mail_raw/0]).

-type openapi_send_mail_raw() ::
  [ {'raw_email', binary() }
  | {'id', integer() }
  ].


openapi_send_mail_raw() ->
    openapi_send_mail_raw([]).

openapi_send_mail_raw(Fields) ->
  Default = [ {'raw_email', binary() }
            , {'id', integer() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

