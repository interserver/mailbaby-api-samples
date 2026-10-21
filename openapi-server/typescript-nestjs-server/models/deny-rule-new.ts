

/**
 * The fields required to create a new email deny rule via `POST /mail/rules`. The `type` controls what `data` is matched against: - `email` — exact sender address match - `domain` — all senders from a domain - `destination` — exact recipient address match - `startswith` — sender local-part prefix match (alphanumeric + `+_.-` only)
 */
export interface DenyRuleNew { 
  /**
   * The matching strategy for this rule.  `email` blocks an exact sender address, `domain` blocks all senders at a domain, `destination` blocks an exact recipient address, and `startswith` blocks any sender whose local-part begins with the given prefix.
   */
  type: DenyRuleNew.TypeEnum;
  /**
   * The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.
   */
  data: string;
  /**
   * Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.
   */
  user?: string;
}
export namespace DenyRuleNew {
  export const TypeEnum = {
    Domain: 'domain',
    Email: 'email',
    Startswith: 'startswith',
    Destination: 'destination',
    UnknownDefaultOpenApi: '11184809',
  } as const;
  export type TypeEnum = typeof TypeEnum[keyof typeof TypeEnum];
}


