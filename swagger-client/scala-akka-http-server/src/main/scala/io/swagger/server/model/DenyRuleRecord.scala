package io.swagger.server.model

import java.util.Date

/**
 * = DenyRuleRecord =
 *
 * A complete deny rule record as returned by `GET /mail/rules`.  Combines the rule definition fields (`DenyRuleNew`) with server-assigned metadata (`id` and `created`).  The `id` value is required by `DELETE /mail/rules/{ruleId}`.
 *
 * @param id The numeric ID of the deny rule, as a string.  Pass this as `ruleId` to `DELETE /mail/rules/{ruleId}` to remove the rule. for example: ''41124''
 * @param created The timestamp when the rule was created.
 * @param user Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`. for example: ''mb20682''
 * @param `type` The type of deny rule. for example: ''email''
 * @param data The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`. for example: ''domeinwo@server.guesshost.net''
 */
case class DenyRuleRecord (
  id: String,
  created: Date,
  user: Option[String],
  `type`: String,
  data: String
)

