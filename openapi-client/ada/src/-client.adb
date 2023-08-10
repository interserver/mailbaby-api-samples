--  ------------ EDIT NOTE ------------
--  MailBaby Email Delivery and Management Service API
--  **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
--  This file was generated with openapi-generator.  You can modify it to implement
--  the client.  After you modify this file, you should add the following line
--  to the .openapi-generator-ignore file:
--
--  src/.ads
--
--  Then, you can drop this edit note comment.
--  ------------ EDIT NOTE ------------
with .Clients;
with .Models;
with Swagger;
with Swagger.Credentials.OAuth;
with Util.Http.Clients.Curl;
with Ada.Text_IO;
with Ada.Command_Line;
with Ada.Calendar.Formatting;
with Ada.Exceptions;
procedure .Client is

   use Ada.Text_IO;

   procedure Usage;

   Server    : constant Swagger.UString := Swagger.To_UString ("http://localhost:8080/v2");
   Arg_Count : constant Natural := Ada.Command_Line.Argument_Count;
   Arg       : Positive := 1;

   procedure Usage is
   begin
      Put_Line ("Usage: defaultProject {params}...");
   end Usage;

begin
   if Arg_Count <= 1 then
      Usage;
      return;
   end if;
   Util.Http.Clients.Curl.Register;
   declare
      Command : constant String := Ada.Command_Line.Argument (Arg);
      Item    : constant String := Ada.Command_Line.Argument (Arg + 1);
      Cred    : aliased Swagger.Credentials.OAuth.OAuth2_Credential_Type;
      C       : .Clients.Client_Type;
   begin
      C.Set_Server (Server);
      C.Set_Credentials (Cred'Unchecked_Access);
      Arg := Arg + 2;

   exception
      when E : Constraint_Error =>
         Put_Line ("Constraint error raised: " & Ada.Exceptions.Exception_Message (E));

   end;
end .Client;
