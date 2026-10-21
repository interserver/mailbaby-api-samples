-module(MailBabyErlangClient_mail_order_detail).

-export([encode/1]).

-export_type([MailBabyErlangClient_mail_order_detail/0]).

-type MailBabyErlangClient_mail_order_detail() ::
    #{ 'id' := integer(),
       'status' := binary(),
       'username' := binary(),
       'password' := binary(),
       'comment' => binary()
     }.

encode(#{ 'id' := Id,
          'status' := Status,
          'username' := Username,
          'password' := Password,
          'comment' := Comment
        }) ->
    #{ 'id' => Id,
       'status' => Status,
       'username' => Username,
       'password' => Password,
       'comment' => Comment
     }.
