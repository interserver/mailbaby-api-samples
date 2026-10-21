package org.openapitools.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import javax.validation.Valid;

import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * Extended mail order record including the current SMTP password.  Returned by &#x60;GET /mail/{id}&#x60;.  The &#x60;username&#x60; and &#x60;password&#x60; fields can be used to authenticate directly against &#x60;relay.mailbaby.net:25&#x60; via SMTP AUTH if you prefer to send via a native SMTP client rather than the REST API.
 **/
@ApiModel(description = "Extended mail order record including the current SMTP password.  Returned by `GET /mail/{id}`.  The `username` and `password` fields can be used to authenticate directly against `relay.mailbaby.net:25` via SMTP AUTH if you prefer to send via a native SMTP client rather than the REST API.")
@JsonTypeName("MailOrderDetail")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", comments = "Generator version: 7.26.0")
public class MailOrderDetail   {
  private Integer id;
  public enum StatusEnum {

    ACTIVE(String.valueOf("active")), CANCELED(String.valueOf("canceled")), UNKNOWN_DEFAULT_OPEN_API(String.valueOf("unknown_default_open_api"));


    private String value;

    StatusEnum (String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    /**
     * Convert a String into String, as specified in the
     * <a href="https://download.oracle.com/otndocs/jcp/jaxrs-2_0-fr-eval-spec/index.html">See JAX RS 2.0 Specification, section 3.2, p. 12</a>
     */
    public static StatusEnum fromString(String s) {
        for (StatusEnum b : StatusEnum.values()) {
            // using Objects.toString() to be safe if value type non-object type
            // because types like 'int' etc. will be auto-boxed
            if (java.util.Objects.toString(b.value).equals(s)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected string value '" + s + "'");
    }

    @JsonCreator
    public static StatusEnum fromValue(String value) {
        for (StatusEnum b : StatusEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        return UNKNOWN_DEFAULT_OPEN_API;
    }
}

  private StatusEnum status;
  private String username;
  private String password;
  private String comment;

  public MailOrderDetail() {
  }

  @JsonCreator
  public MailOrderDetail(
    @JsonProperty(required = true, value = "id") Integer id,
    @JsonProperty(required = true, value = "status") StatusEnum status,
    @JsonProperty(required = true, value = "username") String username,
    @JsonProperty(required = true, value = "password") String password
  ) {
    this.id = id;
    this.status = status;
    this.username = username;
    this.password = password;
  }

  /**
   * The unique numeric ID of the mail order.  Used as the &#x60;id&#x60; parameter on sending calls, log queries, and stats queries.
   **/
  public MailOrderDetail id(Integer id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(example = "21472", required = true, value = "The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries.")
  @JsonProperty(required = true, value = "id")
  @NotNull public Integer getId() {
    return id;
  }

  @JsonProperty(required = true, value = "id")
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * The current order status.  Only &#x60;active&#x60; orders can be used for sending. &#x60;canceled&#x60; orders are retained for history but cannot send.
   **/
  public MailOrderDetail status(StatusEnum status) {
    this.status = status;
    return this;
  }

  
  @ApiModelProperty(example = "active", required = true, value = "The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.")
  @JsonProperty(required = true, value = "status")
  @NotNull public StatusEnum getStatus() {
    return status;
  }

  @JsonProperty(required = true, value = "status")
  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  /**
   * The SMTP AUTH username for this order, always in the format &#x60;mb&lt;id&gt;&#x60;. Use together with the password from &#x60;GET /mail/{id}&#x60; to authenticate directly against &#x60;relay.mailbaby.net:25&#x60; if needed.
   **/
  public MailOrderDetail username(String username) {
    this.username = username;
    return this;
  }

  
  @ApiModelProperty(example = "mb21472", required = true, value = "The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed.")
  @JsonProperty(required = true, value = "username")
  @NotNull  @Pattern(regexp="^mb\\d+$")public String getUsername() {
    return username;
  }

  @JsonProperty(required = true, value = "username")
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * The current SMTP AUTH password for this mail order.  Use with the &#x60;username&#x60; field to authenticate against &#x60;relay.mailbaby.net:25&#x60;.
   **/
  public MailOrderDetail password(String password) {
    this.password = password;
    return this;
  }

  
  @ApiModelProperty(example = "s3cr3tpassword", required = true, value = "The current SMTP AUTH password for this mail order.  Use with the `username` field to authenticate against `relay.mailbaby.net:25`.")
  @JsonProperty(required = true, value = "password")
  @NotNull public String getPassword() {
    return password;
  }

  @JsonProperty(required = true, value = "password")
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment.
   **/
  public MailOrderDetail comment(String comment) {
    this.comment = comment;
    return this;
  }

  
  @ApiModelProperty(value = "Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment.")
  @JsonProperty("comment")
  public String getComment() {
    return comment;
  }

  @JsonProperty("comment")
  public void setComment(String comment) {
    this.comment = comment;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MailOrderDetail mailOrderDetail = (MailOrderDetail) o;
    return Objects.equals(this.id, mailOrderDetail.id) &&
        Objects.equals(this.status, mailOrderDetail.status) &&
        Objects.equals(this.username, mailOrderDetail.username) &&
        Objects.equals(this.password, mailOrderDetail.password) &&
        Objects.equals(this.comment, mailOrderDetail.comment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, username, password, comment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MailOrderDetail {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }


}
