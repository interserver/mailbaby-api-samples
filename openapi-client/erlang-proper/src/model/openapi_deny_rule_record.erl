-module(openapi_deny_rule_record).

-include("openapi.hrl").

-export([openapi_deny_rule_record/0]).

-export([openapi_deny_rule_record/1]).

-export_type([openapi_deny_rule_record/0]).

-type openapi_deny_rule_record() ::
  [ {'id', integer() }
  | {'created', datetime() }
  | {'user', binary() }
  | {'type', binary() }
  | {'data', binary() }
  ].


openapi_deny_rule_record() ->
    openapi_deny_rule_record([]).

openapi_deny_rule_record(Fields) ->
  Default = [ {'id', integer() }
            , {'created', datetime() }
            , {'user', binary() }
            , {'type', elements([<<"domain">>, <<"email">>, <<"startswith">>]) }
            , {'data', binary() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

