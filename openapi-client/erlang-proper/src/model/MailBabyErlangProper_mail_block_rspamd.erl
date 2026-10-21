-module(MailBabyErlangProper_mail_block_rspamd).

-include("MailBabyErlangProper.hrl").

-export([MailBabyErlangProper_mail_block_rspamd/0]).

-export([MailBabyErlangProper_mail_block_rspamd/1]).

-export_type([MailBabyErlangProper_mail_block_rspamd/0]).

-type MailBabyErlangProper_mail_block_rspamd() ::
  [ {'from', binary() }
  | {'subject', binary() }
  ].


MailBabyErlangProper_mail_block_rspamd() ->
    MailBabyErlangProper_mail_block_rspamd([]).

MailBabyErlangProper_mail_block_rspamd(Fields) ->
  Default = [ {'from', binary() }
            , {'subject', binary() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

