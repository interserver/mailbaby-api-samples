-module(MailBabyErlangProper_send_mail_raw).

-include("MailBabyErlangProper.hrl").

-export([MailBabyErlangProper_send_mail_raw/0]).

-export([MailBabyErlangProper_send_mail_raw/1]).

-export_type([MailBabyErlangProper_send_mail_raw/0]).

-type MailBabyErlangProper_send_mail_raw() ::
  [ {'raw_email', binary() }
  | {'id', integer() }
  ].


MailBabyErlangProper_send_mail_raw() ->
    MailBabyErlangProper_send_mail_raw([]).

MailBabyErlangProper_send_mail_raw(Fields) ->
  Default = [ {'raw_email', binary() }
            , {'id', integer() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

