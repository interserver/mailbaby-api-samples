package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;   //
/**
* EmailAddressTypes
*/
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
  @JsonSubTypes({
  @JsonSubTypes.Type(value = EmailAddress.class, name = "EmailAddress"),
  @JsonSubTypes.Type(value = EmailAddressName.class, name = "EmailAddressName")
})
public interface EmailAddressTypes {
}
