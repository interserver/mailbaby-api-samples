-module(openapi_mail_order_detail).

-include("openapi.hrl").

-export([openapi_mail_order_detail/0]).

-export([openapi_mail_order_detail/1]).

-export_type([openapi_mail_order_detail/0]).

-type openapi_mail_order_detail() ::
  [ {'id', integer() }
  | {'status', binary() }
  | {'username', binary() }
  | {'comment', binary() }
  | {'password', binary() }
  ].


openapi_mail_order_detail() ->
    openapi_mail_order_detail([]).

openapi_mail_order_detail(Fields) ->
  Default = [ {'id', integer() }
            , {'status', binary() }
            , {'username', binary() }
            , {'comment', binary() }
            , {'password', binary() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

