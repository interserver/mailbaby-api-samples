package org.openapitools.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Extended mail order record including the current SMTP password.  Returned by `GET /mail/{id}`.  The `username` and `password` fields can be used to authenticate directly against `relay.mailbaby.net:25` via SMTP AUTH if you prefer to send via a native SMTP client rather than the REST API.
 */
@ApiModel(description="Extended mail order record including the current SMTP password.  Returned by `GET /mail/{id}`.  The `username` and `password` fields can be used to authenticate directly against `relay.mailbaby.net:25` via SMTP AUTH if you prefer to send via a native SMTP client rather than the REST API.")

public class MailOrderDetail  {
  
 /**
  * The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries.
  */
  @ApiModelProperty(example = "21472", required = true, value = "The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries.")

  private Integer id;

 /**
  * The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.
  */
  @ApiModelProperty(example = "active", required = true, value = "The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.")

  private String status;

 /**
  * The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed.
  */
  @ApiModelProperty(example = "mb21472", required = true, value = "The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed.")

  private String username;

 /**
  * The current SMTP AUTH password for this mail order.  Use with the `username` field to authenticate against `relay.mailbaby.net:25`.
  */
  @ApiModelProperty(example = "s3cr3tpassword", required = true, value = "The current SMTP AUTH password for this mail order.  Use with the `username` field to authenticate against `relay.mailbaby.net:25`.")

  private String password;

 /**
  * Optional human-readable note associated with the order.
  */
  @ApiModelProperty(value = "Optional human-readable note associated with the order.")

  private String comment;
 /**
   * The unique numeric ID of the mail order.  Used as the &#x60;id&#x60; parameter on sending calls, log queries, and stats queries.
   * @return id
  **/
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public MailOrderDetail id(Integer id) {
    this.id = id;
    return this;
  }

 /**
   * The current order status.  Only &#x60;active&#x60; orders can be used for sending. &#x60;canceled&#x60; orders are retained for history but cannot send.
   * @return status
  **/
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public MailOrderDetail status(String status) {
    this.status = status;
    return this;
  }

 /**
   * The SMTP AUTH username for this order, always in the format &#x60;mb&lt;id&gt;&#x60;. Use together with the password from &#x60;GET /mail/{id}&#x60; to authenticate directly against &#x60;relay.mailbaby.net:25&#x60; if needed.
   * @return username
  **/
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public MailOrderDetail username(String username) {
    this.username = username;
    return this;
  }

 /**
   * The current SMTP AUTH password for this mail order.  Use with the &#x60;username&#x60; field to authenticate against &#x60;relay.mailbaby.net:25&#x60;.
   * @return password
  **/
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public MailOrderDetail password(String password) {
    this.password = password;
    return this;
  }

 /**
   * Optional human-readable note associated with the order.
   * @return comment
  **/
  @JsonProperty("comment")
  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public MailOrderDetail comment(String comment) {
    this.comment = comment;
    return this;
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
  private static String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

