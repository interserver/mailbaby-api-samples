-module(openapi_send_mail_to).

-include("openapi.hrl").

-export([openapi_send_mail_to/0]).

-export([openapi_send_mail_to/1]).

-export_type([openapi_send_mail_to/0]).

-type openapi_send_mail_to() ::
  [ 
  ].


openapi_send_mail_to() ->
    openapi_send_mail_to([]).

openapi_send_mail_to(Fields) ->
  Default = [ 
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

