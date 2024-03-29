/*
 * MailBaby Email Delivery and Management Service API
 * **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.**\n# Overview\nThis is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net).\n# Authentication\nIn order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site.\nWe support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page.\n
 *
 * The version of the OpenAPI document: 1.1.0
 * Contact: support@interserver.net
 *
 * NOTE: This class is auto generated by the OAS code generator program.
 * https://github.com/OpenAPITools/openapi-generator
 * Do not edit the class manually.
 */

/**
 * The listing of blocked emails.
 */
public class OASMailBlocks {
    /**
     * Get local
     * @return local
     */
    public List<OASMailBlockClickHouse> local { get; set; }

    /**
     * Get mbtrap
     * @return mbtrap
     */
    public List<OASMailBlockClickHouse> mbtrap { get; set; }

    /**
     * Get subject
     * @return subject
     */
    public List<OASMailBlockRspamd> subject { get; set; }

    public OASMailBlocks() {
        local = new List<OASMailBlockClickHouse>();
        mbtrap = new List<OASMailBlockClickHouse>();
        subject = new List<OASMailBlockRspamd>();
    }

    public static OASMailBlocks getExample() {
        OASMailBlocks mailBlocks = new OASMailBlocks();
          mailBlocks.local = new List<OASMailBlockClickHouse>{OASMailBlockClickHouse.getExample()};
          mailBlocks.mbtrap = new List<OASMailBlockClickHouse>{OASMailBlockClickHouse.getExample()};
          mailBlocks.subject = new List<OASMailBlockRspamd>{OASMailBlockRspamd.getExample()};
        return mailBlocks;
    }

    public Boolean equals(Object obj) {
        if (obj instanceof OASMailBlocks) {           
            OASMailBlocks mailBlocks = (OASMailBlocks) obj;
            return this.local == mailBlocks.local
                && this.mbtrap == mailBlocks.mbtrap
                && this.subject == mailBlocks.subject;
        }
        return false;
    }

    public Integer hashCode() {
        Integer hashCode = 43;
        hashCode = (17 * hashCode) + (local == null ? 0 : System.hashCode(local));
        hashCode = (17 * hashCode) + (mbtrap == null ? 0 : System.hashCode(mbtrap));
        hashCode = (17 * hashCode) + (subject == null ? 0 : System.hashCode(subject));
        return hashCode;
    }
}

