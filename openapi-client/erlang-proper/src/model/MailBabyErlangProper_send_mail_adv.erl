-module(MailBabyErlangProper_send_mail_adv).

-include("MailBabyErlangProper.hrl").

-export([MailBabyErlangProper_send_mail_adv/0]).

-export([MailBabyErlangProper_send_mail_adv/1]).

-export_type([MailBabyErlangProper_send_mail_adv/0]).

-type MailBabyErlangProper_send_mail_adv() ::
  [ {'subject', binary() }
  | {'body', binary() }
  | {'from', MailBabyErlangProper_email_address_types:MailBabyErlangProper_email_address_types() }
  | {'to', MailBabyErlangProper_email_addresses_types:MailBabyErlangProper_email_addresses_types() }
  | {'replyto', MailBabyErlangProper_email_addresses_types:MailBabyErlangProper_email_addresses_types() }
  | {'cc', MailBabyErlangProper_email_addresses_types:MailBabyErlangProper_email_addresses_types() }
  | {'bcc', MailBabyErlangProper_email_addresses_types:MailBabyErlangProper_email_addresses_types() }
  | {'attachments', list(MailBabyErlangProper_mail_attachment:MailBabyErlangProper_mail_attachment()) }
  | {'id', integer() }
  ].


MailBabyErlangProper_send_mail_adv() ->
    MailBabyErlangProper_send_mail_adv([]).

MailBabyErlangProper_send_mail_adv(Fields) ->
  Default = [ {'subject', binary() }
            , {'body', binary() }
            , {'from', MailBabyErlangProper_email_address_types:MailBabyErlangProper_email_address_types() }
            , {'to', MailBabyErlangProper_email_addresses_types:MailBabyErlangProper_email_addresses_types() }
            , {'replyto', MailBabyErlangProper_email_addresses_types:MailBabyErlangProper_email_addresses_types() }
            , {'cc', MailBabyErlangProper_email_addresses_types:MailBabyErlangProper_email_addresses_types() }
            , {'bcc', MailBabyErlangProper_email_addresses_types:MailBabyErlangProper_email_addresses_types() }
            , {'attachments', list(MailBabyErlangProper_mail_attachment:MailBabyErlangProper_mail_attachment()) }
            , {'id', integer() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

