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
import java.util.ArrayList;
import java.util.List;
import org.wso2.am.integration.clients.publisher.api.v1.dto.DeploymentsDTO;
import org.wso2.am.integration.clients.publisher.api.v1.dto.EnvironmentDTO;
import org.wso2.am.integration.clients.publisher.api.v1.dto.MonetizationAttributeDTO;

/**
* SettingsDTO
*/

public class SettingsDTO {
        public static final String SERIALIZED_NAME_STORE_URL = "storeUrl";
        @SerializedName(SERIALIZED_NAME_STORE_URL)
            private String storeUrl;

        public static final String SERIALIZED_NAME_ENVIRONMENT = "environment";
        @SerializedName(SERIALIZED_NAME_ENVIRONMENT)
            private List<EnvironmentDTO> environment = null;

        public static final String SERIALIZED_NAME_SCOPES = "scopes";
        @SerializedName(SERIALIZED_NAME_SCOPES)
            private List<String> scopes = null;

        public static final String SERIALIZED_NAME_MONETIZATION_ATTRIBUTES = "monetizationAttributes";
        @SerializedName(SERIALIZED_NAME_MONETIZATION_ATTRIBUTES)
            private List<MonetizationAttributeDTO> monetizationAttributes = null;

        public static final String SERIALIZED_NAME_SECURITY_AUDIT_PROPERTIES = "securityAuditProperties";
        @SerializedName(SERIALIZED_NAME_SECURITY_AUDIT_PROPERTIES)
            private Object securityAuditProperties;

        public static final String SERIALIZED_NAME_EXTERNAL_STORES_ENABLED = "externalStoresEnabled";
        @SerializedName(SERIALIZED_NAME_EXTERNAL_STORES_ENABLED)
            private Boolean externalStoresEnabled;

        public static final String SERIALIZED_NAME_DOC_VISIBILITY_ENABLED = "docVisibilityEnabled";
        @SerializedName(SERIALIZED_NAME_DOC_VISIBILITY_ENABLED)
            private Boolean docVisibilityEnabled;

        public static final String SERIALIZED_NAME_CROSS_TENANT_SUBSCRIPTION_ENABLED = "crossTenantSubscriptionEnabled";
        @SerializedName(SERIALIZED_NAME_CROSS_TENANT_SUBSCRIPTION_ENABLED)
            private Boolean crossTenantSubscriptionEnabled = false;

        public static final String SERIALIZED_NAME_DEPLOYMENTS = "deployments";
        @SerializedName(SERIALIZED_NAME_DEPLOYMENTS)
            private List<DeploymentsDTO> deployments = null;


        public SettingsDTO storeUrl(String storeUrl) {
        
        this.storeUrl = storeUrl;
        return this;
        }

    /**
        * Store URL
    * @return storeUrl
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "https://localhost:9443/devportal", value = "Store URL")
    
    public String getStoreUrl() {
        return storeUrl;
    }


        public void setStoreUrl(String storeUrl) {
            this.storeUrl = storeUrl;
        }


        public SettingsDTO environment(List<EnvironmentDTO> environment) {
        
        this.environment = environment;
        return this;
        }

    /**
        * Get environment
    * @return environment
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(value = "")
    
    public List<EnvironmentDTO> getEnvironment() {
        return environment;
    }


        public void setEnvironment(List<EnvironmentDTO> environment) {
            this.environment = environment;
        }


        public SettingsDTO scopes(List<String> scopes) {
        
        this.scopes = scopes;
        return this;
        }

    /**
        * Get scopes
    * @return scopes
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "[\"apim:api_create\",\"apim:api_publish\"]", value = "")
    
    public List<String> getScopes() {
        return scopes;
    }


        public void setScopes(List<String> scopes) {
            this.scopes = scopes;
        }


        public SettingsDTO monetizationAttributes(List<MonetizationAttributeDTO> monetizationAttributes) {
        
        this.monetizationAttributes = monetizationAttributes;
        return this;
        }

    /**
        * Get monetizationAttributes
    * @return monetizationAttributes
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "[]", value = "")
    
    public List<MonetizationAttributeDTO> getMonetizationAttributes() {
        return monetizationAttributes;
    }


        public void setMonetizationAttributes(List<MonetizationAttributeDTO> monetizationAttributes) {
            this.monetizationAttributes = monetizationAttributes;
        }


        public SettingsDTO securityAuditProperties(Object securityAuditProperties) {
        
        this.securityAuditProperties = securityAuditProperties;
        return this;
        }

    /**
        * Get securityAuditProperties
    * @return securityAuditProperties
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(value = "")
    
    public Object getSecurityAuditProperties() {
        return securityAuditProperties;
    }


        public void setSecurityAuditProperties(Object securityAuditProperties) {
            this.securityAuditProperties = securityAuditProperties;
        }


        public SettingsDTO externalStoresEnabled(Boolean externalStoresEnabled) {
        
        this.externalStoresEnabled = externalStoresEnabled;
        return this;
        }

    /**
        * Is External Stores configuration enabled 
    * @return externalStoresEnabled
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "true", value = "Is External Stores configuration enabled ")
    
    public Boolean isExternalStoresEnabledgetExternalStoresEnabled() {
        return externalStoresEnabled;
    }


        public void setExternalStoresEnabled(Boolean externalStoresEnabled) {
            this.externalStoresEnabled = externalStoresEnabled;
        }


        public SettingsDTO docVisibilityEnabled(Boolean docVisibilityEnabled) {
        
        this.docVisibilityEnabled = docVisibilityEnabled;
        return this;
        }

    /**
        * Is Document Visibility configuration enabled 
    * @return docVisibilityEnabled
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "false", value = "Is Document Visibility configuration enabled ")
    
    public Boolean isDocVisibilityEnabledgetDocVisibilityEnabled() {
        return docVisibilityEnabled;
    }


        public void setDocVisibilityEnabled(Boolean docVisibilityEnabled) {
            this.docVisibilityEnabled = docVisibilityEnabled;
        }


        public SettingsDTO crossTenantSubscriptionEnabled(Boolean crossTenantSubscriptionEnabled) {
        
        this.crossTenantSubscriptionEnabled = crossTenantSubscriptionEnabled;
        return this;
        }

    /**
        * Is Cross Tenant Subscriptions Enabled 
    * @return crossTenantSubscriptionEnabled
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "false", value = "Is Cross Tenant Subscriptions Enabled ")
    
    public Boolean isCrossTenantSubscriptionEnabledgetCrossTenantSubscriptionEnabled() {
        return crossTenantSubscriptionEnabled;
    }


        public void setCrossTenantSubscriptionEnabled(Boolean crossTenantSubscriptionEnabled) {
            this.crossTenantSubscriptionEnabled = crossTenantSubscriptionEnabled;
        }


        public SettingsDTO deployments(List<DeploymentsDTO> deployments) {
        
        this.deployments = deployments;
        return this;
        }

    /**
        * Get deployments
    * @return deployments
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(value = "")
    
    public List<DeploymentsDTO> getDeployments() {
        return deployments;
    }


        public void setDeployments(List<DeploymentsDTO> deployments) {
            this.deployments = deployments;
        }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
        return true;
        }
        if (o == null || getClass() != o.getClass()) {
        return false;
        }
            SettingsDTO settings = (SettingsDTO) o;
            return Objects.equals(this.storeUrl, settings.storeUrl) &&
            Objects.equals(this.environment, settings.environment) &&
            Objects.equals(this.scopes, settings.scopes) &&
            Objects.equals(this.monetizationAttributes, settings.monetizationAttributes) &&
            Objects.equals(this.securityAuditProperties, settings.securityAuditProperties) &&
            Objects.equals(this.externalStoresEnabled, settings.externalStoresEnabled) &&
            Objects.equals(this.docVisibilityEnabled, settings.docVisibilityEnabled) &&
            Objects.equals(this.crossTenantSubscriptionEnabled, settings.crossTenantSubscriptionEnabled) &&
            Objects.equals(this.deployments, settings.deployments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeUrl, environment, scopes, monetizationAttributes, securityAuditProperties, externalStoresEnabled, docVisibilityEnabled, crossTenantSubscriptionEnabled, deployments);
    }


@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append("class SettingsDTO {\n");
    sb.append("    storeUrl: ").append(toIndentedString(storeUrl)).append("\n");
    sb.append("    environment: ").append(toIndentedString(environment)).append("\n");
    sb.append("    scopes: ").append(toIndentedString(scopes)).append("\n");
    sb.append("    monetizationAttributes: ").append(toIndentedString(monetizationAttributes)).append("\n");
    sb.append("    securityAuditProperties: ").append(toIndentedString(securityAuditProperties)).append("\n");
    sb.append("    externalStoresEnabled: ").append(toIndentedString(externalStoresEnabled)).append("\n");
    sb.append("    docVisibilityEnabled: ").append(toIndentedString(docVisibilityEnabled)).append("\n");
    sb.append("    crossTenantSubscriptionEnabled: ").append(toIndentedString(crossTenantSubscriptionEnabled)).append("\n");
    sb.append("    deployments: ").append(toIndentedString(deployments)).append("\n");
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

