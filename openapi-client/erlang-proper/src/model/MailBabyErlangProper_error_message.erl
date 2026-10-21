-module(MailBabyErlangProper_error_message).

-include("MailBabyErlangProper.hrl").

-export([MailBabyErlangProper_error_message/0]).

-export([MailBabyErlangProper_error_message/1]).

-export_type([MailBabyErlangProper_error_message/0]).

-type MailBabyErlangProper_error_message() ::
  [ {'code', integer() }
  | {'message', binary() }
  ].


MailBabyErlangProper_error_message() ->
    MailBabyErlangProper_error_message([]).

MailBabyErlangProper_error_message(Fields) ->
  Default = [ {'code', integer() }
            , {'message', binary() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

