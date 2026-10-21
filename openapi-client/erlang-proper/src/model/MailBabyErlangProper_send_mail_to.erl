-module(MailBabyErlangProper_send_mail_to).

-include("MailBabyErlangProper.hrl").

-export([MailBabyErlangProper_send_mail_to/0]).

-export([MailBabyErlangProper_send_mail_to/1]).

-export_type([MailBabyErlangProper_send_mail_to/0]).

-type MailBabyErlangProper_send_mail_to() ::
  [ 
  ].


MailBabyErlangProper_send_mail_to() ->
    MailBabyErlangProper_send_mail_to([]).

MailBabyErlangProper_send_mail_to(Fields) ->
  Default = [ 
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

