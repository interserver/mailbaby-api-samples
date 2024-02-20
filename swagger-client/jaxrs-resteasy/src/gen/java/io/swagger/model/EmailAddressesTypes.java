package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;   //
/**
* EmailAddressesTypes
*/
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
  @JsonSubTypes({
  @JsonSubTypes.Type(value = EmailAddress.class, name = "EmailAddress"),
  @JsonSubTypes.Type(value = EmailAddressNames.class, name = "EmailAddressNames")
})
public interface EmailAddressesTypes {
}
