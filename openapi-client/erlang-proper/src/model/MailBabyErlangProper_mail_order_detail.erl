-module(MailBabyErlangProper_mail_order_detail).

-include("MailBabyErlangProper.hrl").

-export([MailBabyErlangProper_mail_order_detail/0]).

-export([MailBabyErlangProper_mail_order_detail/1]).

-export_type([MailBabyErlangProper_mail_order_detail/0]).

-type MailBabyErlangProper_mail_order_detail() ::
  [ {'id', integer() }
  | {'status', binary() }
  | {'username', binary() }
  | {'password', binary() }
  | {'comment', binary() }
  ].


MailBabyErlangProper_mail_order_detail() ->
    MailBabyErlangProper_mail_order_detail([]).

MailBabyErlangProper_mail_order_detail(Fields) ->
  Default = [ {'id', integer() }
            , {'status', elements([<<"active">>, <<"canceled">>]) }
            , {'username', binary() }
            , {'password', binary() }
            , {'comment', binary() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

