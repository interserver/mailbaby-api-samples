-module(MailBabyErlangProper_deny_rule_record).

-include("MailBabyErlangProper.hrl").

-export([MailBabyErlangProper_deny_rule_record/0]).

-export([MailBabyErlangProper_deny_rule_record/1]).

-export_type([MailBabyErlangProper_deny_rule_record/0]).

-type MailBabyErlangProper_deny_rule_record() ::
  [ {'type', binary() }
  | {'data', binary() }
  | {'id', binary() }
  | {'created', datetime() }
  | {'user', binary() }
  ].


MailBabyErlangProper_deny_rule_record() ->
    MailBabyErlangProper_deny_rule_record([]).

MailBabyErlangProper_deny_rule_record(Fields) ->
  Default = [ {'type', elements([<<"domain">>, <<"email">>, <<"startswith">>, <<"destination">>]) }
            , {'data', binary() }
            , {'id', binary() }
            , {'created', datetime() }
            , {'user', binary() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

