-module(MailBabyErlangProper_mail_block_click_house).

-include("MailBabyErlangProper.hrl").

-export([MailBabyErlangProper_mail_block_click_house/0]).

-export([MailBabyErlangProper_mail_block_click_house/1]).

-export_type([MailBabyErlangProper_mail_block_click_house/0]).

-type MailBabyErlangProper_mail_block_click_house() ::
  [ {'date', date() }
  | {'from', binary() }
  | {'subject', binary() }
  | {'to', binary() }
  | {'messageId', binary() }
  ].


MailBabyErlangProper_mail_block_click_house() ->
    MailBabyErlangProper_mail_block_click_house([]).

MailBabyErlangProper_mail_block_click_house(Fields) ->
  Default = [ {'date', date() }
            , {'from', binary() }
            , {'subject', binary() }
            , {'to', binary() }
            , {'messageId', binary() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

