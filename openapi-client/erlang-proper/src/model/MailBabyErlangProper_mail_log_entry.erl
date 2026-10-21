-module(MailBabyErlangProper_mail_log_entry).

-include("MailBabyErlangProper.hrl").

-export([MailBabyErlangProper_mail_log_entry/0]).

-export([MailBabyErlangProper_mail_log_entry/1]).

-export_type([MailBabyErlangProper_mail_log_entry/0]).

-type MailBabyErlangProper_mail_log_entry() ::
  [ {'_id', integer() }
  | {'id', binary() }
  | {'from', binary() }
  | {'to', binary() }
  | {'created', binary() }
  | {'time', integer() }
  | {'user', binary() }
  | {'transtype', binary() }
  | {'origin', binary() }
  | {'interface', binary() }
  | {'subject', binary() }
  | {'messageId', binary() }
  | {'sendingZone', binary() }
  | {'bodySize', integer() }
  | {'seq', integer() }
  | {'delivered', integer() }
  | {'code', integer() }
  | {'response', binary() }
  | {'recipient', binary() }
  | {'domain', binary() }
  | {'locked', integer() }
  | {'lockTime', binary() }
  | {'assigned', binary() }
  | {'queued', binary() }
  | {'mxHostname', binary() }
  ].


MailBabyErlangProper_mail_log_entry() ->
    MailBabyErlangProper_mail_log_entry([]).

MailBabyErlangProper_mail_log_entry(Fields) ->
  Default = [ {'_id', integer() }
            , {'id', binary(18, 19) }
            , {'from', binary() }
            , {'to', binary() }
            , {'created', binary() }
            , {'time', integer() }
            , {'user', binary() }
            , {'transtype', binary() }
            , {'origin', binary() }
            , {'interface', binary() }
            , {'subject', binary() }
            , {'messageId', binary() }
            , {'sendingZone', binary() }
            , {'bodySize', integer() }
            , {'seq', integer() }
            , {'delivered', integer() }
            , {'code', integer() }
            , {'response', binary() }
            , {'recipient', binary() }
            , {'domain', binary() }
            , {'locked', integer() }
            , {'lockTime', binary() }
            , {'assigned', binary() }
            , {'queued', binary() }
            , {'mxHostname', binary() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

