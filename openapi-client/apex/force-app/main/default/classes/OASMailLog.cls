/*
 * Mail Baby API
 * This is an API defintion for accesssing the Mail.Baby mail service.
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: detain@interserver.net
 *
 * NOTE: This class is auto generated by the OAS code generator program.
 * https://github.com/OpenAPITools/openapi-generator
 * Do not edit the class manually.
 */

/**
 * Mail Order Details
 */
public class OASMailLog {
    /**
     * Get id
     * @return id
     */
    public Long id { get; set; }

    public static OASMailLog getExample() {
        OASMailLog mailLog = new OASMailLog();
          mailLog.id = 123456789L;
        return mailLog;
    }

    public Boolean equals(Object obj) {
        if (obj instanceof OASMailLog) {           
            OASMailLog mailLog = (OASMailLog) obj;
            return this.id == mailLog.id;
        }
        return false;
    }

    public Integer hashCode() {
        Integer hashCode = 43;
        hashCode = (17 * hashCode) + (id == null ? 0 : System.hashCode(id));
        return hashCode;
    }
}
