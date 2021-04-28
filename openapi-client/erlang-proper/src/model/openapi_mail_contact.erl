-module(openapi_mail_contact).

-include("openapi.hrl").

-export([openapi_mail_contact/0]).

-export([openapi_mail_contact/1]).

-export_type([openapi_mail_contact/0]).

-type openapi_mail_contact() ::
  [ {'email', binary() }
  | {'name', binary() }
  ].


openapi_mail_contact() ->
    openapi_mail_contact([]).

openapi_mail_contact(Fields) ->
  Default = [ {'email', binary() }
            , {'name', binary() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

