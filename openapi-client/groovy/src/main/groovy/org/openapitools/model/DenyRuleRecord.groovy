package org.openapitools.model;

import groovy.transform.Canonical
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Canonical
class DenyRuleRecord {

    enum TypeEnum {
    
        DOMAIN("domain"),
        
        EMAIL("email"),
        
        STARTSWITH("startswith")
    
        private final String value
    
        TypeEnum(String value) {
            this.value = value
        }
    
        String getValue() {
            value
        }
    
        @Override
        String toString() {
            String.valueOf(value)
        }
    }

    /* The type of deny rule. */
    TypeEnum type
    /* The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com. */
    String data
    /* The deny rule Id number. */
    Integer id
    /* the date the rule was created. */
    Date created
    /* Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. */
    String user
}
