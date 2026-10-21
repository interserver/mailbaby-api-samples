package org.openapitools.server.model

import java.time.OffsetDateTime

/**
 * = DenyRuleRecord =
 *
 * A complete deny rule record as returned by `GET /mail/rules`.  Combines the rule definition fields (`DenyRuleNew`) with server-assigned metadata (`id` and `created`).  The `id` value is required by `DELETE /mail/rules/{ruleId}`.
 *
 * @param `type` The matching strategy for this rule.  `email` blocks an exact sender address, `domain` blocks all senders at a domain, `destination` blocks an exact recipient address, and `startswith` blocks any sender whose local-part begins with the given prefix. for example: ''email''
 * @param data The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`. for example: ''domeinwo@server.guesshost.net''
 * @param id The numeric ID of the deny rule, as a string.  Pass this as `ruleId` to `DELETE /mail/rules/{ruleId}` to remove the rule. for example: ''41124''
 * @param created The timestamp when the rule was created. for example: ''null''
 * @param user Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`. for example: ''mb20682''
*/
final case class DenyRuleRecord (
  `type`: String,
  data: String,
  id: String,
  created: OffsetDateTime,
  user: Option[String] = None
)

