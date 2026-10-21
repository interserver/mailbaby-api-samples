-module(MailBabyErlangProper_mail_stats_type).

-include("MailBabyErlangProper.hrl").

-export([MailBabyErlangProper_mail_stats_type/0]).

-export([MailBabyErlangProper_mail_stats_type/1]).

-export_type([MailBabyErlangProper_mail_stats_type/0]).

-type MailBabyErlangProper_mail_stats_type() ::
  [ {'time', binary() }
  | {'usage', integer() }
  | {'currency', binary() }
  | {'cost', float() }
  | {'received', integer() }
  | {'sent', integer() }
  | {'volume', MailBabyErlangProper_mail_stats_volume:MailBabyErlangProper_mail_stats_volume() }
  ].


MailBabyErlangProper_mail_stats_type() ->
    MailBabyErlangProper_mail_stats_type([]).

MailBabyErlangProper_mail_stats_type(Fields) ->
  Default = [ {'time', elements([<<"all">>, <<"billing">>, <<"month">>, <<"7d">>, <<"24h">>, <<"day">>, <<"1h">>]) }
            , {'usage', integer() }
            , {'currency', binary() }
            , {'cost', float() }
            , {'received', integer() }
            , {'sent', integer() }
            , {'volume', MailBabyErlangProper_mail_stats_volume:MailBabyErlangProper_mail_stats_volume() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

