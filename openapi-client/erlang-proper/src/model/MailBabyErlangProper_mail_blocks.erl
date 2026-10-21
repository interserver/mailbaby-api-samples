-module(MailBabyErlangProper_mail_blocks).

-include("MailBabyErlangProper.hrl").

-export([MailBabyErlangProper_mail_blocks/0]).

-export([MailBabyErlangProper_mail_blocks/1]).

-export_type([MailBabyErlangProper_mail_blocks/0]).

-type MailBabyErlangProper_mail_blocks() ::
  [ {'local', list(MailBabyErlangProper_mail_block_click_house:MailBabyErlangProper_mail_block_click_house()) }
  | {'mbtrap', list(MailBabyErlangProper_mail_block_click_house:MailBabyErlangProper_mail_block_click_house()) }
  | {'subject', list(MailBabyErlangProper_mail_block_rspamd:MailBabyErlangProper_mail_block_rspamd()) }
  ].


MailBabyErlangProper_mail_blocks() ->
    MailBabyErlangProper_mail_blocks([]).

MailBabyErlangProper_mail_blocks(Fields) ->
  Default = [ {'local', list(MailBabyErlangProper_mail_block_click_house:MailBabyErlangProper_mail_block_click_house()) }
            , {'mbtrap', list(MailBabyErlangProper_mail_block_click_house:MailBabyErlangProper_mail_block_click_house()) }
            , {'subject', list(MailBabyErlangProper_mail_block_rspamd:MailBabyErlangProper_mail_block_rspamd()) }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

