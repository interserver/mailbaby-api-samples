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
 * An Email Contact
 */
public class OASMailContact {
    /**
     * The email address
     * @return email
     */
    public String email { get; set; }

    /**
     * Optional contact name
     * @return name
     */
    public String name { get; set; }

    public static OASMailContact getExample() {
        OASMailContact mailContact = new OASMailContact();
          mailContact.email = 'johndoe@company.com';
          mailContact.name = 'John Doe';
        return mailContact;
    }

    public Boolean equals(Object obj) {
        if (obj instanceof OASMailContact) {           
            OASMailContact mailContact = (OASMailContact) obj;
            return this.email == mailContact.email
                && this.name == mailContact.name;
        }
        return false;
    }

    public Integer hashCode() {
        Integer hashCode = 43;
        hashCode = (17 * hashCode) + (email == null ? 0 : System.hashCode(email));
        hashCode = (17 * hashCode) + (name == null ? 0 : System.hashCode(name));
        return hashCode;
    }
}
