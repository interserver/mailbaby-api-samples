-module(MailBabyErlangProper_mail_order).

-include("MailBabyErlangProper.hrl").

-export([MailBabyErlangProper_mail_order/0]).

-export([MailBabyErlangProper_mail_order/1]).

-export_type([MailBabyErlangProper_mail_order/0]).

-type MailBabyErlangProper_mail_order() ::
  [ {'id', integer() }
  | {'status', binary() }
  | {'username', binary() }
  | {'comment', binary() }
  ].


MailBabyErlangProper_mail_order() ->
    MailBabyErlangProper_mail_order([]).

MailBabyErlangProper_mail_order(Fields) ->
  Default = [ {'id', integer() }
            , {'status', elements([<<"active">>, <<"canceled">>]) }
            , {'username', binary() }
            , {'comment', binary() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

