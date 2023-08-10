-module(openapi_get_stats_200_response_inner).

-export([encode/1]).

-export_type([openapi_get_stats_200_response_inner/0]).

-type openapi_get_stats_200_response_inner() ::
    #{ 'id' := integer(),
       'status' := binary(),
       'username' := binary(),
       'password' => binary(),
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
