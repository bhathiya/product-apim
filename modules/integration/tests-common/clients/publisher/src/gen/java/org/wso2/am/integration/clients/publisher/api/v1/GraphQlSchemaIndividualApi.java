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


package org.wso2.am.integration.clients.publisher.api.v1;

import org.wso2.am.integration.clients.publisher.api.ApiCallback;
import org.wso2.am.integration.clients.publisher.api.ApiClient;
import org.wso2.am.integration.clients.publisher.api.ApiException;
import org.wso2.am.integration.clients.publisher.api.ApiResponse;
import org.wso2.am.integration.clients.publisher.api.Configuration;
import org.wso2.am.integration.clients.publisher.api.Pair;
import org.wso2.am.integration.clients.publisher.api.ProgressRequestBody;
import org.wso2.am.integration.clients.publisher.api.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import org.wso2.am.integration.clients.publisher.api.v1.dto.ErrorDTO;
import org.wso2.am.integration.clients.publisher.api.v1.dto.GraphQLSchemaDTO;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphQlSchemaIndividualApi {
    private ApiClient localVarApiClient;

    public GraphQlSchemaIndividualApi() {
        this(Configuration.getDefaultApiClient());
    }

    public GraphQlSchemaIndividualApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for apisApiIdGraphqlSchemaGet
     * @param apiId **API ID** consisting of the **UUID** of the API.  (required)
     * @param accept Media types acceptable for the response. Default is application/json.  (optional, default to &quot;application/json&quot;)
     * @param ifNoneMatch Validator for conditional requests; based on the ETag of the formerly retrieved variant of the resource.  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK. Requested GraphQL Schema DTO object belongs to the API  </td><td>  * ETag - Entity Tag of the response resource. Used by caches, or in conditional requests (Will be supported in future).  <br>  * Last-Modified - Date and time the resource has been modifed the last time. Used by caches, or in conditional requests (Will be supported in future).  <br>  * Content-Type - The content type of the body.  <br>  </td></tr>
        <tr><td> 304 </td><td> Not Modified. Empty body because the client has already the latest version of the requested resource (Will be supported in future).  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found. The specified resource does not exist. </td><td>  -  </td></tr>
        <tr><td> 406 </td><td> Not Acceptable. The requested media type is not supported. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call apisApiIdGraphqlSchemaGetCall(String apiId, String accept, String ifNoneMatch, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/apis/{apiId}/graphql-schema"
            .replaceAll("\\{" + "apiId" + "\\}", localVarApiClient.escapeString(apiId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (accept != null) {
            localVarHeaderParams.put("Accept", localVarApiClient.parameterToString(accept));
        }

        if (ifNoneMatch != null) {
            localVarHeaderParams.put("If-None-Match", localVarApiClient.parameterToString(ifNoneMatch));
        }

        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "OAuth2Security" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call apisApiIdGraphqlSchemaGetValidateBeforeCall(String apiId, String accept, String ifNoneMatch, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'apiId' is set
        if (apiId == null) {
            throw new ApiException("Missing the required parameter 'apiId' when calling apisApiIdGraphqlSchemaGet(Async)");
        }
        

        okhttp3.Call localVarCall = apisApiIdGraphqlSchemaGetCall(apiId, accept, ifNoneMatch, _callback);
        return localVarCall;

    }

    /**
     * Get the Schema of a GraphQL API
     * This operation can be used to retrieve the Schema definition of a GraphQL API. 
     * @param apiId **API ID** consisting of the **UUID** of the API.  (required)
     * @param accept Media types acceptable for the response. Default is application/json.  (optional, default to &quot;application/json&quot;)
     * @param ifNoneMatch Validator for conditional requests; based on the ETag of the formerly retrieved variant of the resource.  (optional)
     * @return GraphQLSchemaDTO
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK. Requested GraphQL Schema DTO object belongs to the API  </td><td>  * ETag - Entity Tag of the response resource. Used by caches, or in conditional requests (Will be supported in future).  <br>  * Last-Modified - Date and time the resource has been modifed the last time. Used by caches, or in conditional requests (Will be supported in future).  <br>  * Content-Type - The content type of the body.  <br>  </td></tr>
        <tr><td> 304 </td><td> Not Modified. Empty body because the client has already the latest version of the requested resource (Will be supported in future).  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found. The specified resource does not exist. </td><td>  -  </td></tr>
        <tr><td> 406 </td><td> Not Acceptable. The requested media type is not supported. </td><td>  -  </td></tr>
     </table>
     */
    public GraphQLSchemaDTO apisApiIdGraphqlSchemaGet(String apiId, String accept, String ifNoneMatch) throws ApiException {
        ApiResponse<GraphQLSchemaDTO> localVarResp = apisApiIdGraphqlSchemaGetWithHttpInfo(apiId, accept, ifNoneMatch);
        return localVarResp.getData();
    }

    /**
     * Get the Schema of a GraphQL API
     * This operation can be used to retrieve the Schema definition of a GraphQL API. 
     * @param apiId **API ID** consisting of the **UUID** of the API.  (required)
     * @param accept Media types acceptable for the response. Default is application/json.  (optional, default to &quot;application/json&quot;)
     * @param ifNoneMatch Validator for conditional requests; based on the ETag of the formerly retrieved variant of the resource.  (optional)
     * @return ApiResponse&lt;GraphQLSchemaDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK. Requested GraphQL Schema DTO object belongs to the API  </td><td>  * ETag - Entity Tag of the response resource. Used by caches, or in conditional requests (Will be supported in future).  <br>  * Last-Modified - Date and time the resource has been modifed the last time. Used by caches, or in conditional requests (Will be supported in future).  <br>  * Content-Type - The content type of the body.  <br>  </td></tr>
        <tr><td> 304 </td><td> Not Modified. Empty body because the client has already the latest version of the requested resource (Will be supported in future).  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found. The specified resource does not exist. </td><td>  -  </td></tr>
        <tr><td> 406 </td><td> Not Acceptable. The requested media type is not supported. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<GraphQLSchemaDTO> apisApiIdGraphqlSchemaGetWithHttpInfo(String apiId, String accept, String ifNoneMatch) throws ApiException {
        okhttp3.Call localVarCall = apisApiIdGraphqlSchemaGetValidateBeforeCall(apiId, accept, ifNoneMatch, null);
        Type localVarReturnType = new TypeToken<GraphQLSchemaDTO>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get the Schema of a GraphQL API (asynchronously)
     * This operation can be used to retrieve the Schema definition of a GraphQL API. 
     * @param apiId **API ID** consisting of the **UUID** of the API.  (required)
     * @param accept Media types acceptable for the response. Default is application/json.  (optional, default to &quot;application/json&quot;)
     * @param ifNoneMatch Validator for conditional requests; based on the ETag of the formerly retrieved variant of the resource.  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK. Requested GraphQL Schema DTO object belongs to the API  </td><td>  * ETag - Entity Tag of the response resource. Used by caches, or in conditional requests (Will be supported in future).  <br>  * Last-Modified - Date and time the resource has been modifed the last time. Used by caches, or in conditional requests (Will be supported in future).  <br>  * Content-Type - The content type of the body.  <br>  </td></tr>
        <tr><td> 304 </td><td> Not Modified. Empty body because the client has already the latest version of the requested resource (Will be supported in future).  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found. The specified resource does not exist. </td><td>  -  </td></tr>
        <tr><td> 406 </td><td> Not Acceptable. The requested media type is not supported. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call apisApiIdGraphqlSchemaGetAsync(String apiId, String accept, String ifNoneMatch, final ApiCallback<GraphQLSchemaDTO> _callback) throws ApiException {

        okhttp3.Call localVarCall = apisApiIdGraphqlSchemaGetValidateBeforeCall(apiId, accept, ifNoneMatch, _callback);
        Type localVarReturnType = new TypeToken<GraphQLSchemaDTO>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
