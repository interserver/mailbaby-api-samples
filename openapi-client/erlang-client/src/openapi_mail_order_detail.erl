-module(openapi_mail_order_detail).

-export([encode/1]).

-export_type([openapi_mail_order_detail/0]).

-type openapi_mail_order_detail() ::
    #{ 'id' := integer(),
       'status' := binary(),
       'username' := binary(),
       'comment' => binary(),
       'password' := binary()
     }.

encode(#{ 'id' := Id,
          'status' := Status,
          'username' := Username,
          'comment' := Comment,
          'password' := Password
        }) ->
    #{ 'id' => Id,
       'status' => Status,
       'username' => Username,
       'comment' => Comment,
       'password' => Password
     }.
