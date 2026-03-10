-module(openapi_send_mail).

-include("openapi.hrl").

-export([openapi_send_mail/0]).

-export([openapi_send_mail/1]).

-export_type([openapi_send_mail/0]).

-type openapi_send_mail() ::
  [ {'to', openapi_send_mail_to:openapi_send_mail_to() }
  | {'from', binary() }
  | {'subject', binary() }
  | {'body', binary() }
  | {'id', integer() }
  ].


openapi_send_mail() ->
    openapi_send_mail([]).

openapi_send_mail(Fields) ->
  Default = [ {'to', openapi_send_mail_to:openapi_send_mail_to() }
            , {'from', binary() }
            , {'subject', binary() }
            , {'body', binary() }
            , {'id', integer() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

