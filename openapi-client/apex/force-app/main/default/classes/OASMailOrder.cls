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
 * OASMailOrder
 */
public class OASMailOrder {
    /**
     * Get id
     * @return id
     */
    public Integer id { get; set; }

    /**
     * Get status
     * @return status
     */
    public String status { get; set; }

    /**
     * Get username
     * @return username
     */
    public String username { get; set; }

    /**
     * Get password
     * @return password
     */
    public String password { get; set; }

    /**
     * Get comment
     * @return comment
     */
    public String comment { get; set; }

    public static OASMailOrder getExample() {
        OASMailOrder mailOrder = new OASMailOrder();
          mailOrder.id = 1234;
          mailOrder.status = 'active';
          mailOrder.username = 'mb1234';
          mailOrder.password = 'guest123';
          mailOrder.comment = 'main mail account';
        return mailOrder;
    }

    public Boolean equals(Object obj) {
        if (obj instanceof OASMailOrder) {           
            OASMailOrder mailOrder = (OASMailOrder) obj;
            return this.id == mailOrder.id
                && this.status == mailOrder.status
                && this.username == mailOrder.username
                && this.password == mailOrder.password
                && this.comment == mailOrder.comment;
        }
        return false;
    }

    public Integer hashCode() {
        Integer hashCode = 43;
        hashCode = (17 * hashCode) + (id == null ? 0 : System.hashCode(id));
        hashCode = (17 * hashCode) + (status == null ? 0 : System.hashCode(status));
        hashCode = (17 * hashCode) + (username == null ? 0 : System.hashCode(username));
        hashCode = (17 * hashCode) + (password == null ? 0 : System.hashCode(password));
        hashCode = (17 * hashCode) + (comment == null ? 0 : System.hashCode(comment));
        return hashCode;
    }
}
