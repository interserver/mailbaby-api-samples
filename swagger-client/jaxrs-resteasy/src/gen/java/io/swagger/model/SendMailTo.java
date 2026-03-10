package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;   //
/**
* The primary recipient address for a simple send request. Accepts a single email address string or an array of email address strings for multiple recipients.
*/
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
  @JsonSubTypes({
})
public interface SendMailTo {
}
