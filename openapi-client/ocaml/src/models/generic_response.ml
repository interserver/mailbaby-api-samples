(*
 * This file has been generated by the OCamlClientCodegen generator for openapi-generator.
 *
 * Generated by: https://openapi-generator.tech
 *
 *)

type t = {
    status: string option [@default None];
    text: string option [@default None];
} [@@deriving yojson { strict = false }, show ];;

let create () : t = {
    status = None;
    text = None;
}

