--  Mail Baby API
--  This is an API for accesssing the mail services.
--
--  The version of the OpenAPI document: 1.0.0
--  Contact: detain@interserver.net
--
--  NOTE: This package is auto generated by OpenAPI-Generator 5.1.0.
--  https://openapi-generator.tech
--  Do not edit the class manually.

with Swagger.Streams;
with Ada.Containers.Vectors;
package .Models is
   pragma Style_Checks ("-mr");



   type MailLog_Type is
     record
       Id : Swagger.Nullable_Long;
     end record;

   package MailLog_Type_Vectors is
      new Ada.Containers.Vectors (Index_Type   => Positive,
                                  Element_Type => MailLog_Type);

   procedure Serialize (Into  : in out Swagger.Streams.Output_Stream'Class;
                        Name  : in String;
                        Value : in MailLog_Type);

   procedure Serialize (Into  : in out Swagger.Streams.Output_Stream'Class;
                        Name  : in String;
                        Value : in MailLog_Type_Vectors.Vector);

   procedure Deserialize (From  : in Swagger.Value_Type;
                          Name  : in String;
                          Value : out MailLog_Type);

   procedure Deserialize (From  : in Swagger.Value_Type;
                          Name  : in String;
                          Value : out MailLog_Type_Vectors.Vector);




   type GenericResponse_Type is
     record
       Status : Swagger.Nullable_UString;
       Status_Text : Swagger.Nullable_UString;
     end record;

   package GenericResponse_Type_Vectors is
      new Ada.Containers.Vectors (Index_Type   => Positive,
                                  Element_Type => GenericResponse_Type);

   procedure Serialize (Into  : in out Swagger.Streams.Output_Stream'Class;
                        Name  : in String;
                        Value : in GenericResponse_Type);

   procedure Serialize (Into  : in out Swagger.Streams.Output_Stream'Class;
                        Name  : in String;
                        Value : in GenericResponse_Type_Vectors.Vector);

   procedure Deserialize (From  : in Swagger.Value_Type;
                          Name  : in String;
                          Value : out GenericResponse_Type);

   procedure Deserialize (From  : in Swagger.Value_Type;
                          Name  : in String;
                          Value : out GenericResponse_Type_Vectors.Vector);




   type Error_Type is
     record
       Code : Swagger.UString;
       Message : Swagger.UString;
     end record;

   package Error_Type_Vectors is
      new Ada.Containers.Vectors (Index_Type   => Positive,
                                  Element_Type => Error_Type);

   procedure Serialize (Into  : in out Swagger.Streams.Output_Stream'Class;
                        Name  : in String;
                        Value : in Error_Type);

   procedure Serialize (Into  : in out Swagger.Streams.Output_Stream'Class;
                        Name  : in String;
                        Value : in Error_Type_Vectors.Vector);

   procedure Deserialize (From  : in Swagger.Value_Type;
                          Name  : in String;
                          Value : out Error_Type);

   procedure Deserialize (From  : in Swagger.Value_Type;
                          Name  : in String;
                          Value : out Error_Type_Vectors.Vector);




   type MailOrder_Type is
     record
       Id : Integer;
       Status : Swagger.UString;
       Username : Swagger.UString;
       Password : Swagger.Nullable_UString;
       Comment : Swagger.Nullable_UString;
     end record;

   package MailOrder_Type_Vectors is
      new Ada.Containers.Vectors (Index_Type   => Positive,
                                  Element_Type => MailOrder_Type);

   procedure Serialize (Into  : in out Swagger.Streams.Output_Stream'Class;
                        Name  : in String;
                        Value : in MailOrder_Type);

   procedure Serialize (Into  : in out Swagger.Streams.Output_Stream'Class;
                        Name  : in String;
                        Value : in MailOrder_Type_Vectors.Vector);

   procedure Deserialize (From  : in Swagger.Value_Type;
                          Name  : in String;
                          Value : out MailOrder_Type);

   procedure Deserialize (From  : in Swagger.Value_Type;
                          Name  : in String;
                          Value : out MailOrder_Type_Vectors.Vector);



end .Models;