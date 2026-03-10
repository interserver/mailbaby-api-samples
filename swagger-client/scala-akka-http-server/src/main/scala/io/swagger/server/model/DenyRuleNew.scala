package io.swagger.server.model


/**
 * = DenyRuleNew =
 *
 * The fields required to create a new email deny rule via `POST /mail/rules`. The `type` controls what `data` is matched against: - `email` — exact sender address match - `domain` — all senders from a domain - `destination` — exact recipient address match - `startswith` — sender local-part prefix match (alphanumeric + `+_.-` only)
 *
 * @param user Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`. for example: ''mb20682''
 * @param `type` The type of deny rule. for example: ''email''
 * @param data The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`. for example: ''domeinwo@server.guesshost.net''
 */
case class DenyRuleNew (
  user: Option[String],
  `type`: String,
  data: String
)

