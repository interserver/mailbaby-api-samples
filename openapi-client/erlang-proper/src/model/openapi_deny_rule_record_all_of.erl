-module(openapi_deny_rule_record_all_of).

-include("openapi.hrl").

-export([openapi_deny_rule_record_all_of/0]).

-export([openapi_deny_rule_record_all_of/1]).

-export_type([openapi_deny_rule_record_all_of/0]).

-type openapi_deny_rule_record_all_of() ::
  [ {'id', integer() }
  | {'created', datetime() }
  ].


openapi_deny_rule_record_all_of() ->
    openapi_deny_rule_record_all_of([]).

openapi_deny_rule_record_all_of(Fields) ->
  Default = [ {'id', integer() }
            , {'created', datetime() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

