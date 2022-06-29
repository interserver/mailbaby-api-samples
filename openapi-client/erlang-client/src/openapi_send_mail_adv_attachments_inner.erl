-module(openapi_send_mail_adv_attachments_inner).

-export([encode/1]).

-export_type([openapi_send_mail_adv_attachments_inner/0]).

-type openapi_send_mail_adv_attachments_inner() ::
    #{ 'filename' => binary(),
       'data' := binary()
     }.

encode(#{ 'filename' := Filename,
          'data' := Data
        }) ->
    #{ 'filename' => Filename,
       'data' => Data
     }.
