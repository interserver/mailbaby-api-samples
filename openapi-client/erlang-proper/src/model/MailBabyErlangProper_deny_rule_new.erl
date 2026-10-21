-module(MailBabyErlangProper_deny_rule_new).

-include("MailBabyErlangProper.hrl").

-export([MailBabyErlangProper_deny_rule_new/0]).

-export([MailBabyErlangProper_deny_rule_new/1]).

-export_type([MailBabyErlangProper_deny_rule_new/0]).

-type MailBabyErlangProper_deny_rule_new() ::
  [ {'type', binary() }
  | {'data', binary() }
  | {'user', binary() }
  ].


MailBabyErlangProper_deny_rule_new() ->
    MailBabyErlangProper_deny_rule_new([]).

MailBabyErlangProper_deny_rule_new(Fields) ->
  Default = [ {'type', elements([<<"domain">>, <<"email">>, <<"startswith">>, <<"destination">>]) }
            , {'data', binary() }
            , {'user', binary() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

