package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;
import io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * InlineResponse200
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-03-13T09:48:13.426799911-04:00[America/New_York]")


public class InlineResponse200   {
  @JsonProperty("id")

  private Integer id = null;

  @JsonProperty("status")

  private String status = null;

  @JsonProperty("username")

  private String username = null;

  @JsonProperty("password")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String password = null;

  @JsonProperty("comment")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String comment = null;


  public InlineResponse200 id(Integer id) { 

    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  
  @Schema(example = "1234", required = true, description = "")
  
  @NotNull
  public Integer getId() {  
    return id;
  }



  public void setId(Integer id) { 

    this.id = id;
  }

  public InlineResponse200 status(String status) { 

    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   **/
  
  @Schema(example = "active", required = true, description = "")
  
  @NotNull
  public String getStatus() {  
    return status;
  }



  public void setStatus(String status) { 

    this.status = status;
  }

  public InlineResponse200 username(String username) { 

    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
   **/
  
  @Schema(example = "mb1234", required = true, description = "")
  
  @NotNull
  public String getUsername() {  
    return username;
  }



  public void setUsername(String username) { 

    this.username = username;
  }

  public InlineResponse200 password(String password) { 

    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
   **/
  
  @Schema(example = "guest123", description = "")
  
  public String getPassword() {  
    return password;
  }



  public void setPassword(String password) { 
    this.password = password;
  }

  public InlineResponse200 comment(String comment) { 

    this.comment = comment;
    return this;
  }

  /**
   * Get comment
   * @return comment
   **/
  
  @Schema(example = "main mail account", description = "")
  
  public String getComment() {  
    return comment;
  }



  public void setComment(String comment) { 
    this.comment = comment;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse200 inlineResponse200 = (InlineResponse200) o;
    return Objects.equals(this.id, inlineResponse200.id) &&
        Objects.equals(this.status, inlineResponse200.status) &&
        Objects.equals(this.username, inlineResponse200.username) &&
        Objects.equals(this.password, inlineResponse200.password) &&
        Objects.equals(this.comment, inlineResponse200.comment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, username, password, comment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");
    
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
