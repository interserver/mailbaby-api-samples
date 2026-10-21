-module(MailBabyErlangProper_send_mail).

-include("MailBabyErlangProper.hrl").

-export([MailBabyErlangProper_send_mail/0]).

-export([MailBabyErlangProper_send_mail/1]).

-export_type([MailBabyErlangProper_send_mail/0]).

-type MailBabyErlangProper_send_mail() ::
  [ {'to', MailBabyErlangProper_send_mail_to:MailBabyErlangProper_send_mail_to() }
  | {'from', binary() }
  | {'subject', binary() }
  | {'body', binary() }
  | {'id', integer() }
  ].


MailBabyErlangProper_send_mail() ->
    MailBabyErlangProper_send_mail([]).

MailBabyErlangProper_send_mail(Fields) ->
  Default = [ {'to', MailBabyErlangProper_send_mail_to:MailBabyErlangProper_send_mail_to() }
            , {'from', binary() }
            , {'subject', binary() }
            , {'body', binary() }
            , {'id', integer() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

