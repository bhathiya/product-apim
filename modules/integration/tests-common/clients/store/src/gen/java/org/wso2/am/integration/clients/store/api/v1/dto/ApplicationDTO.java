/*
 * WSO2 API Manager - Developer Portal
 * This document specifies a **RESTful API** for WSO2 **API Manager** - **Developer Portal**. Please see [full OpenAPI Specification](https://raw.githubusercontent.com/wso2/carbon-apimgt/v6.7.206/components/apimgt/org.wso2.carbon.apimgt.rest.api.store.v1/src/main/resources/store-api.yaml) of the API which is written using [OAS 3.0](http://swagger.io/) specification.  # Authentication Our REST APIs are protected using OAuth2 and access control is achieved through scopes. Before you start invoking the API, you need to obtain an access token with the required scopes. This guide will walk you through the steps that you will need to follow to obtain an access token. First you need to obtain the consumer key/secret key pair by calling the dynamic client registration (DCR) endpoint. You can add your preferred grant types in the payload. A Sample payload is shown below. ```   {   \"callbackUrl\":\"www.google.lk\",   \"clientName\":\"rest_api_devportal\",   \"owner\":\"admin\",   \"grantType\":\"client_credentials password refresh_token\",   \"saasApp\":true   } ``` Create a file (payload.json) with the above sample payload, and use the cURL shown below to invoke the DCR endpoint. Authorization header of this should contain the base64 encoded admin username and password. **Format of the request** ```   curl -X POST -H \"Authorization: Basic Base64(admin_username:admin_password)\" -H \"Content-Type: application/json\"   \\ -d @payload.json https://<host>:<servlet_port>/client-registration/v0.17/register ``` **Sample request** ```   curl -X POST -H \"Authorization: Basic YWRtaW46YWRtaW4=\" -H \"Content-Type: application/json\"   \\ -d @payload.json https://localhost:9443/client-registration/v0.17/register ``` Following is a sample response after invoking the above curl. ``` { \"clientId\": \"fOCi4vNJ59PpHucC2CAYfYuADdMa\", \"clientName\": \"rest_api_store\", \"callBackURL\": \"www.google.lk\", \"clientSecret\": \"a4FwHlq0iCIKVs2MPIIDnepZnYMa\", \"isSaasApplication\": true, \"appOwner\": \"admin\", \"jsonString\": \"{\\\"grant_types\\\":\\\"client_credentials password refresh_token\\\",\\\"redirect_uris\\\":\\\"www.google.lk\\\",\\\"client_name\\\":\\\"rest_api_devportal\\\"}\", \"jsonAppAttribute\": \"{}\", \"tokenType\": null } ``` Next you must use the above client id and secret to obtain the access token. We will be using the password grant type for this, you can use any grant type you desire. You also need to add the proper **scope** when getting the access token. All possible scopes for devportal REST API can be viewed in **OAuth2 Security** section of this document and scope for each resource is given in **authorization** section of resource documentation. Following is the format of the request if you are using the password grant type. ``` curl -k -d \"grant_type=password&username=<admin_username>&password=<admin_password>&scope=<scopes separated by space>\" \\ -H \"Authorization: Basic base64(cliet_id:client_secret)\" \\ https://<host>:<gateway_port>/token ``` **Sample request** ``` curl https://localhost:8243/token -k \\ -H \"Authorization: Basic Zk9DaTR2Tko1OVBwSHVjQzJDQVlmWXVBRGRNYTphNEZ3SGxxMGlDSUtWczJNUElJRG5lcFpuWU1h\" \\ -d \"grant_type=password&username=admin&password=admin&scope=apim:subscribe apim:api_key\" ``` Shown below is a sample response to the above request. ``` { \"access_token\": \"e79bda48-3406-3178-acce-f6e4dbdcbb12\", \"refresh_token\": \"a757795d-e69f-38b8-bd85-9aded677a97c\", \"scope\": \"apim:subscribe apim:api_key\", \"token_type\": \"Bearer\", \"expires_in\": 3600 } ``` Now you have a valid access token, which you can use to invoke an API. Navigate through the API descriptions to find the required API, obtain an access token as described above and invoke the API with the authentication header. If you use a different authentication mechanism, this process may change.  # Try out in Postman If you want to try-out the embedded postman collection with \"Run in Postman\" option, please follow the guidelines listed below. * All of the OAuth2 secured endpoints have been configured with an Authorization Bearer header with a parameterized access token. Before invoking any REST API resource make sure you run the `Register DCR Application` and `Generate Access Token` requests to fetch an access token with all required scopes. * Make sure you have an API Manager instance up and running. * Update the `basepath` parameter to match the hostname and port of the APIM instance.  [![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/5bc0161b8aa7e701d7bf) 
 *
 * The version of the OpenAPI document: v1.1
 * Contact: architecture@wso2.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.wso2.am.integration.clients.store.api.v1.dto;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.wso2.am.integration.clients.store.api.v1.dto.ApplicationKeyDTO;
import org.wso2.am.integration.clients.store.api.v1.dto.ScopeInfoDTO;

/**
 * ApplicationDTO
 */

public class ApplicationDTO {
  public static final String SERIALIZED_NAME_APPLICATION_ID = "applicationId";
  @SerializedName(SERIALIZED_NAME_APPLICATION_ID)
  private String applicationId;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_THROTTLING_POLICY = "throttlingPolicy";
  @SerializedName(SERIALIZED_NAME_THROTTLING_POLICY)
  private String throttlingPolicy;

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  /**
   * Type of the access token generated for this application.  **OAUTH:** A UUID based access token **JWT:** A self-contained, signed JWT based access token which is issued by default. 
   */
  @JsonAdapter(TokenTypeEnum.Adapter.class)
  public enum TokenTypeEnum {
    OAUTH("OAUTH"),
    
    JWT("JWT");

    private String value;

    TokenTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TokenTypeEnum fromValue(String value) {
      for (TokenTypeEnum b : TokenTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<TokenTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TokenTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TokenTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return TokenTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_TOKEN_TYPE = "tokenType";
  @SerializedName(SERIALIZED_NAME_TOKEN_TYPE)
  private TokenTypeEnum tokenType = TokenTypeEnum.JWT;

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private String status = "";

  public static final String SERIALIZED_NAME_GROUPS = "groups";
  @SerializedName(SERIALIZED_NAME_GROUPS)
  private List<String> groups = null;

  public static final String SERIALIZED_NAME_SUBSCRIPTION_COUNT = "subscriptionCount";
  @SerializedName(SERIALIZED_NAME_SUBSCRIPTION_COUNT)
  private Integer subscriptionCount;

  public static final String SERIALIZED_NAME_KEYS = "keys";
  @SerializedName(SERIALIZED_NAME_KEYS)
  private List<ApplicationKeyDTO> keys = null;

  public static final String SERIALIZED_NAME_ATTRIBUTES = "attributes";
  @SerializedName(SERIALIZED_NAME_ATTRIBUTES)
  private Map<String, String> attributes = null;

  public static final String SERIALIZED_NAME_SUBSCRIPTION_SCOPES = "subscriptionScopes";
  @SerializedName(SERIALIZED_NAME_SUBSCRIPTION_SCOPES)
  private List<ScopeInfoDTO> subscriptionScopes = null;

  public static final String SERIALIZED_NAME_OWNER = "owner";
  @SerializedName(SERIALIZED_NAME_OWNER)
  private String owner;

  public static final String SERIALIZED_NAME_HASH_ENABLED = "hashEnabled";
  @SerializedName(SERIALIZED_NAME_HASH_ENABLED)
  private Boolean hashEnabled;


   /**
   * Get applicationId
   * @return applicationId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "01234567-0123-0123-0123-012345678901", value = "")

  public String getApplicationId() {
    return applicationId;
  }




  public ApplicationDTO name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "CalculatorApp", required = true, value = "")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public ApplicationDTO throttlingPolicy(String throttlingPolicy) {
    
    this.throttlingPolicy = throttlingPolicy;
    return this;
  }

   /**
   * Get throttlingPolicy
   * @return throttlingPolicy
  **/
  @ApiModelProperty(example = "Unlimited", required = true, value = "")

  public String getThrottlingPolicy() {
    return throttlingPolicy;
  }


  public void setThrottlingPolicy(String throttlingPolicy) {
    this.throttlingPolicy = throttlingPolicy;
  }


  public ApplicationDTO description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Sample calculator application", value = "")

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }


  public ApplicationDTO tokenType(TokenTypeEnum tokenType) {
    
    this.tokenType = tokenType;
    return this;
  }

   /**
   * Type of the access token generated for this application.  **OAUTH:** A UUID based access token **JWT:** A self-contained, signed JWT based access token which is issued by default. 
   * @return tokenType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "JWT", value = "Type of the access token generated for this application.  **OAUTH:** A UUID based access token **JWT:** A self-contained, signed JWT based access token which is issued by default. ")

  public TokenTypeEnum getTokenType() {
    return tokenType;
  }


  public void setTokenType(TokenTypeEnum tokenType) {
    this.tokenType = tokenType;
  }


   /**
   * Get status
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "APPROVED", value = "")

  public String getStatus() {
    return status;
  }




  public ApplicationDTO groups(List<String> groups) {
    
    this.groups = groups;
    return this;
  }

  public ApplicationDTO addGroupsItem(String groupsItem) {
    if (this.groups == null) {
      this.groups = new ArrayList<>();
    }
    this.groups.add(groupsItem);
    return this;
  }

   /**
   * Get groups
   * @return groups
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "[]", value = "")

  public List<String> getGroups() {
    return groups;
  }


  public void setGroups(List<String> groups) {
    this.groups = groups;
  }


   /**
   * Get subscriptionCount
   * @return subscriptionCount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getSubscriptionCount() {
    return subscriptionCount;
  }




  public ApplicationDTO keys(List<ApplicationKeyDTO> keys) {
    
    this.keys = keys;
    return this;
  }

  public ApplicationDTO addKeysItem(ApplicationKeyDTO keysItem) {
    if (this.keys == null) {
      this.keys = new ArrayList<>();
    }
    this.keys.add(keysItem);
    return this;
  }

   /**
   * Get keys
   * @return keys
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "[]", value = "")

  public List<ApplicationKeyDTO> getKeys() {
    return keys;
  }


  public void setKeys(List<ApplicationKeyDTO> keys) {
    this.keys = keys;
  }


  public ApplicationDTO attributes(Map<String, String> attributes) {
    
    this.attributes = attributes;
    return this;
  }

  public ApplicationDTO putAttributesItem(String key, String attributesItem) {
    if (this.attributes == null) {
      this.attributes = new HashMap<>();
    }
    this.attributes.put(key, attributesItem);
    return this;
  }

   /**
   * Get attributes
   * @return attributes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "{}", value = "")

  public Map<String, String> getAttributes() {
    return attributes;
  }


  public void setAttributes(Map<String, String> attributes) {
    this.attributes = attributes;
  }


  public ApplicationDTO subscriptionScopes(List<ScopeInfoDTO> subscriptionScopes) {
    
    this.subscriptionScopes = subscriptionScopes;
    return this;
  }

  public ApplicationDTO addSubscriptionScopesItem(ScopeInfoDTO subscriptionScopesItem) {
    if (this.subscriptionScopes == null) {
      this.subscriptionScopes = new ArrayList<>();
    }
    this.subscriptionScopes.add(subscriptionScopesItem);
    return this;
  }

   /**
   * Get subscriptionScopes
   * @return subscriptionScopes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "[]", value = "")

  public List<ScopeInfoDTO> getSubscriptionScopes() {
    return subscriptionScopes;
  }


  public void setSubscriptionScopes(List<ScopeInfoDTO> subscriptionScopes) {
    this.subscriptionScopes = subscriptionScopes;
  }


   /**
   * Application created user 
   * @return owner
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "admin", value = "Application created user ")

  public String getOwner() {
    return owner;
  }




   /**
   * Get hashEnabled
   * @return hashEnabled
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "")

  public Boolean getHashEnabled() {
    return hashEnabled;
  }




  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApplicationDTO application = (ApplicationDTO) o;
    return Objects.equals(this.applicationId, application.applicationId) &&
        Objects.equals(this.name, application.name) &&
        Objects.equals(this.throttlingPolicy, application.throttlingPolicy) &&
        Objects.equals(this.description, application.description) &&
        Objects.equals(this.tokenType, application.tokenType) &&
        Objects.equals(this.status, application.status) &&
        Objects.equals(this.groups, application.groups) &&
        Objects.equals(this.subscriptionCount, application.subscriptionCount) &&
        Objects.equals(this.keys, application.keys) &&
        Objects.equals(this.attributes, application.attributes) &&
        Objects.equals(this.subscriptionScopes, application.subscriptionScopes) &&
        Objects.equals(this.owner, application.owner) &&
        Objects.equals(this.hashEnabled, application.hashEnabled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applicationId, name, throttlingPolicy, description, tokenType, status, groups, subscriptionCount, keys, attributes, subscriptionScopes, owner, hashEnabled);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApplicationDTO {\n");
    sb.append("    applicationId: ").append(toIndentedString(applicationId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    throttlingPolicy: ").append(toIndentedString(throttlingPolicy)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    tokenType: ").append(toIndentedString(tokenType)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
    sb.append("    subscriptionCount: ").append(toIndentedString(subscriptionCount)).append("\n");
    sb.append("    keys: ").append(toIndentedString(keys)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    subscriptionScopes: ").append(toIndentedString(subscriptionScopes)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    hashEnabled: ").append(toIndentedString(hashEnabled)).append("\n");
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

