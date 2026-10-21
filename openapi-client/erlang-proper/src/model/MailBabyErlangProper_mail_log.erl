-module(MailBabyErlangProper_mail_log).

-include("MailBabyErlangProper.hrl").

-export([MailBabyErlangProper_mail_log/0]).

-export([MailBabyErlangProper_mail_log/1]).

-export_type([MailBabyErlangProper_mail_log/0]).

-type MailBabyErlangProper_mail_log() ::
  [ {'total', integer() }
  | {'skip', integer() }
  | {'limit', integer() }
  | {'emails', list(MailBabyErlangProper_mail_log_entry:MailBabyErlangProper_mail_log_entry()) }
  ].


MailBabyErlangProper_mail_log() ->
    MailBabyErlangProper_mail_log([]).

MailBabyErlangProper_mail_log(Fields) ->
  Default = [ {'total', integer() }
            , {'skip', integer() }
            , {'limit', integer() }
            , {'emails', list(MailBabyErlangProper_mail_log_entry:MailBabyErlangProper_mail_log_entry()) }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

