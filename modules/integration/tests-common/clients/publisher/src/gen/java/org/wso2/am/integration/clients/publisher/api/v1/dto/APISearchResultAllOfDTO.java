/*
 * WSO2 API Manager - Publisher API
 * This document specifies a **RESTful API** for WSO2 **API Manager** - **Publisher**.  # Authentication Our REST APIs are protected using OAuth2 and access control is achieved through scopes. Before you start invoking the the API you need to obtain an access token with the required scopes. This guide will walk you through the steps that you will need to follow to obtain an access token. First you need to obtain the consumer key/secret key pair by calling the dynamic client registration (DCR) endpoint. You can add your preferred grant types in the payload. A Sample payload is shown below. ```   {   \"callbackUrl\":\"www.google.lk\",   \"clientName\":\"rest_api_publisher\",   \"owner\":\"admin\",   \"grantType\":\"client_credentials password refresh_token\",   \"saasApp\":true   } ``` Create a file (payload.json) with the above sample payload, and use the cURL shown bellow to invoke the DCR endpoint. Authorization header of this should contain the base64 encoded admin username and password. **Format of the request** ```   curl -X POST -H \"Authorization: Basic Base64(admin_username:admin_password)\" -H \"Content-Type: application/json\"   \\ -d @payload.json https://<host>:<servlet_port>/client-registration/v0.17/register ``` **Sample request** ```   curl -X POST -H \"Authorization: Basic YWRtaW46YWRtaW4=\" -H \"Content-Type: application/json\"   \\ -d @payload.json https://localhost:9443/client-registration/v0.17/register ``` Following is a sample response after invoking the above curl. ``` { \"clientId\": \"fOCi4vNJ59PpHucC2CAYfYuADdMa\", \"clientName\": \"rest_api_publisher\", \"callBackURL\": \"www.google.lk\", \"clientSecret\": \"a4FwHlq0iCIKVs2MPIIDnepZnYMa\", \"isSaasApplication\": true, \"appOwner\": \"admin\", \"jsonString\": \"{\\\"grant_types\\\":\\\"client_credentials password refresh_token\\\",\\\"redirect_uris\\\":\\\"www.google.lk\\\",\\\"client_name\\\":\\\"rest_api123\\\"}\", \"jsonAppAttribute\": \"{}\", \"tokenType\": null } ``` Next you must use the above client id and secret to obtain the access token. We will be using the password grant type for this, you can use any grant type you desire. You also need to add the proper **scope** when getting the access token. All possible scopes for publisher REST API can be viewed in **OAuth2 Security** section of this document and scope for each resource is given in **authorization** section of resource documentation. Following is the format of the request if you are using the password grant type. ``` curl -k -d \"grant_type=password&username=<admin_username>&password=<admin_passowrd&scope=<scopes seperated by space>\" \\ -H \"Authorization: Basic base64(cliet_id:client_secret)\" \\ https://<host>:<gateway_port>/token ``` **Sample request** ``` curl https://localhost:8243/token -k \\ -H \"Authorization: Basic Zk9DaTR2Tko1OVBwSHVjQzJDQVlmWXVBRGRNYTphNEZ3SGxxMGlDSUtWczJNUElJRG5lcFpuWU1h\" \\ -d \"grant_type=password&username=admin&password=admin&scope=apim:api_view apim:api_create\" ``` Shown below is a sample response to the above request. ``` { \"access_token\": \"e79bda48-3406-3178-acce-f6e4dbdcbb12\", \"refresh_token\": \"a757795d-e69f-38b8-bd85-9aded677a97c\", \"scope\": \"apim:api_create apim:api_view\", \"token_type\": \"Bearer\", \"expires_in\": 3600 } ``` Now you have a valid access token, which you can use to invoke an API. Navigate through the API descriptions to find the required API, obtain an access token as described above and invoke the API with the authentication header. If you use a different authentication mechanism, this process may change.  # Try out in Postman If you want to try-out the embedded postman collection with \"Run in Postman\" option, please follow the guidelines listed below. * All of the OAuth2 secured endpoints have been configured with an Authorization Bearer header with a parameterized access token. Before invoking any REST API resource make sure you run the `Register DCR Application` and `Generate Access Token` requests to fetch an access token with all required scopes. * Make sure you have an API Manager instance up and running. * Update the `basepath` parameter to match the hostname and port of the APIM instance.  [![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/a09044034b5c3c1b01a9) 
 *
 * The version of the OpenAPI document: v1.1
 * Contact: architecture@wso2.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.wso2.am.integration.clients.publisher.api.v1.dto;

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

/**
* APISearchResultAllOfDTO
*/

public class APISearchResultAllOfDTO {
        public static final String SERIALIZED_NAME_DESCRIPTION = "description";
        @SerializedName(SERIALIZED_NAME_DESCRIPTION)
            private String description;

        public static final String SERIALIZED_NAME_CONTEXT = "context";
        @SerializedName(SERIALIZED_NAME_CONTEXT)
            private String context;

        public static final String SERIALIZED_NAME_VERSION = "version";
        @SerializedName(SERIALIZED_NAME_VERSION)
            private String version;

        public static final String SERIALIZED_NAME_PROVIDER = "provider";
        @SerializedName(SERIALIZED_NAME_PROVIDER)
            private String provider;

        public static final String SERIALIZED_NAME_STATUS = "status";
        @SerializedName(SERIALIZED_NAME_STATUS)
            private String status;

        public static final String SERIALIZED_NAME_THUMBNAIL_URI = "thumbnailUri";
        @SerializedName(SERIALIZED_NAME_THUMBNAIL_URI)
            private String thumbnailUri;


        public APISearchResultAllOfDTO description(String description) {
        
        this.description = description;
        return this;
        }

    /**
        * A brief description about the API
    * @return description
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "A calculator API that supports basic operations", value = "A brief description about the API")
    
    public String getDescription() {
        return description;
    }


        public void setDescription(String description) {
            this.description = description;
        }


        public APISearchResultAllOfDTO context(String context) {
        
        this.context = context;
        return this;
        }

    /**
        * A string that represents the context of the user&#39;s request
    * @return context
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "CalculatorAPI", value = "A string that represents the context of the user's request")
    
    public String getContext() {
        return context;
    }


        public void setContext(String context) {
            this.context = context;
        }


        public APISearchResultAllOfDTO version(String version) {
        
        this.version = version;
        return this;
        }

    /**
        * The version of the API
    * @return version
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "1.0.0", value = "The version of the API")
    
    public String getVersion() {
        return version;
    }


        public void setVersion(String version) {
            this.version = version;
        }


        public APISearchResultAllOfDTO provider(String provider) {
        
        this.provider = provider;
        return this;
        }

    /**
        * If the provider value is not given, the user invoking the API will be used as the provider. 
    * @return provider
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "admin", value = "If the provider value is not given, the user invoking the API will be used as the provider. ")
    
    public String getProvider() {
        return provider;
    }


        public void setProvider(String provider) {
            this.provider = provider;
        }


        public APISearchResultAllOfDTO status(String status) {
        
        this.status = status;
        return this;
        }

    /**
        * This describes in which status of the lifecycle the API is
    * @return status
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "CREATED", value = "This describes in which status of the lifecycle the API is")
    
    public String getStatus() {
        return status;
    }


        public void setStatus(String status) {
            this.status = status;
        }


        public APISearchResultAllOfDTO thumbnailUri(String thumbnailUri) {
        
        this.thumbnailUri = thumbnailUri;
        return this;
        }

    /**
        * Get thumbnailUri
    * @return thumbnailUri
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "/apis/01234567-0123-0123-0123-012345678901/thumbnail", value = "")
    
    public String getThumbnailUri() {
        return thumbnailUri;
    }


        public void setThumbnailUri(String thumbnailUri) {
            this.thumbnailUri = thumbnailUri;
        }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
        return true;
        }
        if (o == null || getClass() != o.getClass()) {
        return false;
        }
            APISearchResultAllOfDTO apISearchResultAllOf = (APISearchResultAllOfDTO) o;
            return Objects.equals(this.description, apISearchResultAllOf.description) &&
            Objects.equals(this.context, apISearchResultAllOf.context) &&
            Objects.equals(this.version, apISearchResultAllOf.version) &&
            Objects.equals(this.provider, apISearchResultAllOf.provider) &&
            Objects.equals(this.status, apISearchResultAllOf.status) &&
            Objects.equals(this.thumbnailUri, apISearchResultAllOf.thumbnailUri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, context, version, provider, status, thumbnailUri);
    }


@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append("class APISearchResultAllOfDTO {\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    context: ").append(toIndentedString(context)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    provider: ").append(toIndentedString(provider)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    thumbnailUri: ").append(toIndentedString(thumbnailUri)).append("\n");
sb.append("}");
return sb.toString();
}

/**
* Convert the given object to string with each line indented by 4 spaces
* (except the first line).
*/
private String toIndentedString(Object o) {
if (o == null) {
return "null";
}
return o.toString().replace("\n", "\n    ");
}

}

