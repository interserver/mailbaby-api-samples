-module(openapi_mail_attachment).

-export([encode/1]).

-export_type([openapi_mail_attachment/0]).

-type openapi_mail_attachment() ::
    #{ 'filename' := binary(),
       'data' := openapi_byte_array:openapi_byte_array()
     }.

encode(#{ 'filename' := Filename,
          'data' := Data
        }) ->
    #{ 'filename' => Filename,
       'data' => Data
     }.
