package org.openapitools.model;

import groovy.transform.Canonical
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Canonical
class MailOrder {
    
    Integer id
    
    String status
    
    String username
    
    String password
    
    String comment
}
