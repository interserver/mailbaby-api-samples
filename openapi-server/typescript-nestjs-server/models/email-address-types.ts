import { EmailAddressName } from './email-address-name';


/**
 * A flexible single email address that accepts either a plain address string, an RFC 822 named-address string (`\"Name <email>\"`), or a structured contact object.
 */
/**
 * @type EmailAddressTypes
 * A flexible single email address that accepts either a plain address string, an RFC 822 named-address string (`\"Name <email>\"`), or a structured contact object.
 * @export
 */
export type EmailAddressTypes = EmailAddressName | string;

