-module(MailBabyErlangClient_mail_block_click_house).

-export([encode/1]).

-export_type([MailBabyErlangClient_mail_block_click_house/0]).

-type MailBabyErlangClient_mail_block_click_house() ::
    #{ 'date' := calendar:date(),
       'from' := binary(),
       'subject' := binary(),
       'to' := binary(),
       'messageId' => binary()
     }.

encode(#{ 'date' := Date,
          'from' := From,
          'subject' := Subject,
          'to' := To,
          'messageId' := MessageId
        }) ->
    #{ 'date' => Date,
       'from' => From,
       'subject' => Subject,
       'to' => To,
       'messageId' => MessageId
     }.
