-module(MailBabyErlangProper_mail_attachment).

-include("MailBabyErlangProper.hrl").

-export([MailBabyErlangProper_mail_attachment/0]).

-export([MailBabyErlangProper_mail_attachment/1]).

-export_type([MailBabyErlangProper_mail_attachment/0]).

-type MailBabyErlangProper_mail_attachment() ::
  [ {'filename', binary() }
  | {'data', MailBabyErlangProper_byte_array:MailBabyErlangProper_byte_array() }
  ].


MailBabyErlangProper_mail_attachment() ->
    MailBabyErlangProper_mail_attachment([]).

MailBabyErlangProper_mail_attachment(Fields) ->
  Default = [ {'filename', binary() }
            , {'data', binary() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

