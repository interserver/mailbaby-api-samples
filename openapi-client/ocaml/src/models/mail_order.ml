(*
 * This file has been generated by the OCamlClientCodegen generator for openapi-generator.
 *
 * Generated by: https://openapi-generator.tech
 *
 * Schema Mail_order.t : A mail order record
 *)

type t = {
    (* The ID of the order. *)
    id: int32;
    (* The order status. *)
    status: string;
    (* The username to use for this order. *)
    username: string;
    (* Optional order comment. *)
    comment: string option [@default None];
} [@@deriving yojson { strict = false }, show ];;

(** A mail order record *)
let create (id : int32) (status : string) (username : string) : t = {
    id = id;
    status = status;
    username = username;
    comment = None;
}
