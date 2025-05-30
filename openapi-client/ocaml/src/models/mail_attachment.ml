(*
 * This file has been generated by the OCamlClientCodegen generator for openapi-generator.
 *
 * Generated by: https://openapi-generator.tech
 *
 * Schema Mail_attachment.t : (optional) File attachments to include in the email.  The file contents must be base64
 *)

type t = {
    (* The filename of the attached file. *)
      filename: string
          
          
        
        ; [@key "filename"]
    (* The file contents base64 encoded *)
      data: string
          
          
        
        ; [@key "data"]
} [@@deriving yojson { strict = false }, show ];;

(** (optional) File attachments to include in the email.  The file contents must be base64 *)
let create (filename : string) (data : string) : t = {
    filename = filename;
    data = data;
}

