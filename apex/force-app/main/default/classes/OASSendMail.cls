/*
 * Mail Baby API
 * This is an API for accesssing the mail services.
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: detain@interserver.net
 *
 * NOTE: This class is auto generated by the OAS code generator program.
 * https://github.com/OpenAPITools/openapi-generator
 * Do not edit the class manually.
 */

/**
 * Details for an Email
 */
public class OASSendMail implements OAS.MappedProperties {
    /**
     * The ID of the Mail order within our system to use as the Mail Account.
     * @return id
     */
    public Long id { get; set; }

    /**
     * Get r_from
     * @return r_from
     */
    public OASMailContact r_from { get; set; }

    /**
     * The Contact whom is the primary recipient of this email.
     * @return to
     */
    public List<OASMailContact> to { get; set; }

    /**
     * The subject or title of the email
     * @return subject
     */
    public String subject { get; set; }

    /**
     * The main email contents.
     * @return body
     */
    public String body { get; set; }

    /**
     * Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address.
     * @return replyto
     */
    public List<OASMailContact> replyto { get; set; }

    /**
     * Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
     * @return cc
     */
    public List<OASMailContact> cc { get; set; }

    /**
     * Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
     * @return bcc
     */
    public List<OASMailContact> bcc { get; set; }

    /**
     * Optional file attachments to include in the email
     * @return attachments
     */
    public List<OASMailAttachment> attachments { get; set; }

    private static final Map<String, String> propertyMappings = new Map<String, String>{
        'from' => 'r_from'
    };

    public Map<String, String> getPropertyMappings() {
        return propertyMappings;
    }

    public OASSendMail() {
        to = new List<OASMailContact>();
        replyto = new List<OASMailContact>();
        cc = new List<OASMailContact>();
        bcc = new List<OASMailContact>();
        attachments = new List<OASMailAttachment>();
    }

    public static OASSendMail getExample() {
        OASSendMail sendMail = new OASSendMail();
          sendMail.id = 123456789L;
          sendMail.r_from = OASMailContact.getExample();
          sendMail.to = new List<OASMailContact>{OASMailContact.getExample()};
          sendMail.subject = 'Your Package has been Delivered!';
          sendMail.body = 'The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else.\n';
          sendMail.replyto = new List<OASMailContact>{OASMailContact.getExample()};
          sendMail.cc = new List<OASMailContact>{OASMailContact.getExample()};
          sendMail.bcc = new List<OASMailContact>{OASMailContact.getExample()};
          sendMail.attachments = new List<OASMailAttachment>{OASMailAttachment.getExample()};
        return sendMail;
    }

    public Boolean equals(Object obj) {
        if (obj instanceof OASSendMail) {           
            OASSendMail sendMail = (OASSendMail) obj;
            return this.id == sendMail.id
                && this.r_from == sendMail.r_from
                && this.to == sendMail.to
                && this.subject == sendMail.subject
                && this.body == sendMail.body
                && this.replyto == sendMail.replyto
                && this.cc == sendMail.cc
                && this.bcc == sendMail.bcc
                && this.attachments == sendMail.attachments;
        }
        return false;
    }

    public Integer hashCode() {
        Integer hashCode = 43;
        hashCode = (17 * hashCode) + (id == null ? 0 : System.hashCode(id));
        hashCode = (17 * hashCode) + (r_from == null ? 0 : System.hashCode(r_from));
        hashCode = (17 * hashCode) + (to == null ? 0 : System.hashCode(to));
        hashCode = (17 * hashCode) + (subject == null ? 0 : System.hashCode(subject));
        hashCode = (17 * hashCode) + (body == null ? 0 : System.hashCode(body));
        hashCode = (17 * hashCode) + (replyto == null ? 0 : System.hashCode(replyto));
        hashCode = (17 * hashCode) + (cc == null ? 0 : System.hashCode(cc));
        hashCode = (17 * hashCode) + (bcc == null ? 0 : System.hashCode(bcc));
        hashCode = (17 * hashCode) + (attachments == null ? 0 : System.hashCode(attachments));
        return hashCode;
    }
}
