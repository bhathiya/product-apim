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
import org.wso2.am.integration.clients.publisher.api.v1.dto.PodStatusDTO;

/**
* DeploymentClusterStatusDTO
*/

public class DeploymentClusterStatusDTO {
        public static final String SERIALIZED_NAME_CLUSTER_NAME = "clusterName";
        @SerializedName(SERIALIZED_NAME_CLUSTER_NAME)
            private String clusterName;

        public static final String SERIALIZED_NAME_PODS_RUNNING = "podsRunning";
        @SerializedName(SERIALIZED_NAME_PODS_RUNNING)
            private Integer podsRunning;

        public static final String SERIALIZED_NAME_HEALTH_STATUS = "healthStatus";
        @SerializedName(SERIALIZED_NAME_HEALTH_STATUS)
            private List<PodStatusDTO> healthStatus = new ArrayList<>();


        public DeploymentClusterStatusDTO clusterName(String clusterName) {
        
        this.clusterName = clusterName;
        return this;
        }

    /**
        * Get clusterName
    * @return clusterName
    **/
      @ApiModelProperty(example = "Minikube", required = true, value = "")
    
    public String getClusterName() {
        return clusterName;
    }


        public void setClusterName(String clusterName) {
            this.clusterName = clusterName;
        }


        public DeploymentClusterStatusDTO podsRunning(Integer podsRunning) {
        
        this.podsRunning = podsRunning;
        return this;
        }

    /**
        * Get podsRunning
    * @return podsRunning
    **/
      @ApiModelProperty(required = true, value = "")
    
    public Integer getPodsRunning() {
        return podsRunning;
    }


        public void setPodsRunning(Integer podsRunning) {
            this.podsRunning = podsRunning;
        }


        public DeploymentClusterStatusDTO healthStatus(List<PodStatusDTO> healthStatus) {
        
        this.healthStatus = healthStatus;
        return this;
        }

    /**
        * Get healthStatus
    * @return healthStatus
    **/
      @ApiModelProperty(required = true, value = "")
    
    public List<PodStatusDTO> getHealthStatus() {
        return healthStatus;
    }


        public void setHealthStatus(List<PodStatusDTO> healthStatus) {
            this.healthStatus = healthStatus;
        }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
        return true;
        }
        if (o == null || getClass() != o.getClass()) {
        return false;
        }
            DeploymentClusterStatusDTO deploymentClusterStatus = (DeploymentClusterStatusDTO) o;
            return Objects.equals(this.clusterName, deploymentClusterStatus.clusterName) &&
            Objects.equals(this.podsRunning, deploymentClusterStatus.podsRunning) &&
            Objects.equals(this.healthStatus, deploymentClusterStatus.healthStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clusterName, podsRunning, healthStatus);
    }


@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append("class DeploymentClusterStatusDTO {\n");
    sb.append("    clusterName: ").append(toIndentedString(clusterName)).append("\n");
    sb.append("    podsRunning: ").append(toIndentedString(podsRunning)).append("\n");
    sb.append("    healthStatus: ").append(toIndentedString(healthStatus)).append("\n");
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

