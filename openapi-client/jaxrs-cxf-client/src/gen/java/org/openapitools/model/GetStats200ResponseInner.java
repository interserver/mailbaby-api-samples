package org.openapitools.model;


import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


public class GetStats200ResponseInner  {
  
  @ApiModelProperty(example = "1234", required = true, value = "")
  private Integer id;

  @ApiModelProperty(example = "active", required = true, value = "")
  private String status;

  @ApiModelProperty(example = "mb1234", required = true, value = "")
  private String username;

  @ApiModelProperty(example = "guest123", value = "")
  private String password;

  @ApiModelProperty(example = "main mail account", value = "")
  private String comment;
 /**
   * Get id
   * @return id
  **/
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public GetStats200ResponseInner id(Integer id) {
    this.id = id;
    return this;
  }

 /**
   * Get status
   * @return status
  **/
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public GetStats200ResponseInner status(String status) {
    this.status = status;
    return this;
  }

 /**
   * Get username
   * @return username
  **/
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public GetStats200ResponseInner username(String username) {
    this.username = username;
    return this;
  }

 /**
   * Get password
   * @return password
  **/
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public GetStats200ResponseInner password(String password) {
    this.password = password;
    return this;
  }

 /**
   * Get comment
   * @return comment
  **/
  @JsonProperty("comment")
  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public GetStats200ResponseInner comment(String comment) {
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
    GetStats200ResponseInner getStats200ResponseInner = (GetStats200ResponseInner) o;
    return Objects.equals(this.id, getStats200ResponseInner.id) &&
        Objects.equals(this.status, getStats200ResponseInner.status) &&
        Objects.equals(this.username, getStats200ResponseInner.username) &&
        Objects.equals(this.password, getStats200ResponseInner.password) &&
        Objects.equals(this.comment, getStats200ResponseInner.comment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, username, password, comment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetStats200ResponseInner {\n");
    
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

