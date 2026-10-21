-module(MailBabyErlangClient_mail_attachment).

-export([encode/1]).

-export_type([MailBabyErlangClient_mail_attachment/0]).

-type MailBabyErlangClient_mail_attachment() ::
    #{ 'filename' := binary(),
       'data' := MailBabyErlangClient_byte_array:MailBabyErlangClient_byte_array()
     }.

encode(#{ 'filename' := Filename,
          'data' := Data
        }) ->
    #{ 'filename' => Filename,
       'data' => Data
     }.
