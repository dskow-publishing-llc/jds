/*
 * JournDoc Downloader Client API
 * This is a journdoc downloader client
 *
 * OpenAPI spec version: 1.0.0
 * Contact: david@dskow.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.dskow.downloader.jdd.client.api;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.dskow.downloader.jdd.client.ApiCallback;
import com.dskow.downloader.jdd.client.ApiClient;
import com.dskow.downloader.jdd.client.ApiException;
import com.dskow.downloader.jdd.client.ApiResponse;
import com.dskow.downloader.jdd.client.Configuration;
import com.dskow.downloader.jdd.client.Pair;
import com.dskow.downloader.jdd.client.ProgressRequestBody;
import com.dskow.downloader.jdd.client.ProgressResponseBody;
import com.dskow.downloader.models.client.ResultC;

public class JDDApi {
    private ApiClient apiClient;

    public JDDApi() {
        this(Configuration.getDefaultApiClient());
    }

    public JDDApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for jddEFetchUsingPOST */
    private com.squareup.okhttp.Call jddEFetchUsingGETCall(String db, String id, String rettype, String retmode, String tool, String email, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/entrez/eutils/efetch.fcgi".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (db != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "db", db));
        if (id != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));
        if (retmode != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "rettype", rettype));
        if (retmode != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "retmode", retmode));
        if (tool != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "tool", tool));
        if (email != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "email", email));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "text/xml"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    private com.squareup.okhttp.Call jddEFetchUsingGETValidateBeforeCall(String db, String id, String rettype, String retmode, String tool, String email, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'db' is set
        if (db == null) {
            throw new ApiException("Missing the required parameter 'db' when calling jddEFetchUsingPOST(Async)");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling jddEFetchUsingPOST(Async)");
        }
        
        // verify the required parameter 'rettype' is set
        if (rettype == null) {
            throw new ApiException("Missing the required parameter 'rettype' when calling jddEFetchUsingPOST(Async)");
        }

        // verify the required parameter 'retmode' is set
        if (retmode == null) {
            throw new ApiException("Missing the required parameter 'retmode' when calling jddEFetchUsingPOST(Async)");
        }
        
        // verify the required parameter 'tool' is set
        if (tool == null) {
            throw new ApiException("Missing the required parameter 'tool' when calling jddEFetchUsingPOST(Async)");
        }
        
        // verify the required parameter 'email' is set
        if (email == null) {
            throw new ApiException("Missing the required parameter 'email' when calling jddEFetchUsingPOST(Async)");
        }
        
        
        com.squareup.okhttp.Call call = jddEFetchUsingGETCall(db, id, rettype, retmode, tool, email, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * fetch xml files
     * fetch xml files. 
     * @param db a db name. (required)
     * @param id an id. (required)
     * @param retmode a return mode. (required)
     * @param tool a tool. (required)
     * @param email an email. (required)
     * @return FetchResultC
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public String jddEFetchUsingGET(String db, String id, String rettype, String retmode, String tool, String email) throws ApiException {
        ApiResponse<String> resp = jddEFetchUsingGETWithHttpInfo(db, id, rettype, retmode, tool, email);
        return resp.getData();
    }

    /**
     * fetch xml files
     * fetch xml files. 
     * @param db a db name. (required)
     * @param id an id. (required)
     * @param retmode a return mode. (required)
     * @param tool a tool. (required)
     * @param email an email. (required)
     * @return ApiResponse&lt;FetchResultC&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<String> jddEFetchUsingGETWithHttpInfo(String db, String id, String rettype, String retmode, String tool, String email) throws ApiException {
        com.squareup.okhttp.Call call = jddEFetchUsingGETValidateBeforeCall(db, id, rettype, retmode, tool, email, null, null);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * fetch xml files (asynchronously)
     * fetch xml files. 
     * @param db a db name. (required)
     * @param id an id. (required)
     * @param retmode a return mode. (required)
     * @param tool a tool. (required)
     * @param email an email. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call jddEFetchUsingPOSTAsync(String db, String id, String rettype, String retmode, String tool, String email, final ApiCallback<String> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = jddEFetchUsingGETValidateBeforeCall(db, id, rettype, retmode, tool, email, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for jddSearchUsingPOST */
    private com.squareup.okhttp.Call jddSearchUsingPOSTCall(String db, String term, String retStart, String retMax, String retmode, String tool, String email, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/entrez/eutils/esearch.fcgi".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (db != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "db", db));
        if (term != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "term", term));
        if (retStart != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "retStart", retStart));
        if (retMax != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "retMax", retMax));
        if (retmode != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "retmode", retmode));
        if (tool != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "tool", tool));
        if (email != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "email", email));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    private com.squareup.okhttp.Call jddSearchUsingPOSTValidateBeforeCall(String db, String term, String retStart, String retMax, String retmode, String tool, String email, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'db' is set
        if (db == null) {
            throw new ApiException("Missing the required parameter 'db' when calling jddSearchUsingPOST(Async)");
        }
        
        // verify the required parameter 'term' is set
        if (term == null) {
            throw new ApiException("Missing the required parameter 'term' when calling jddSearchUsingPOST(Async)");
        }
        
        // verify the required parameter 'retStart' is set
        if (retStart == null) {
            throw new ApiException("Missing the required parameter 'retStart' when calling jddSearchUsingPOST(Async)");
        }
        
        // verify the required parameter 'retMax' is set
        if (retMax == null) {
            throw new ApiException("Missing the required parameter 'retMax' when calling jddSearchUsingPOST(Async)");
        }
        
        // verify the required parameter 'retmode' is set
        if (retmode == null) {
            throw new ApiException("Missing the required parameter 'retmode' when calling jddSearchUsingPOST(Async)");
        }
        
        // verify the required parameter 'tool' is set
        if (tool == null) {
            throw new ApiException("Missing the required parameter 'tool' when calling jddSearchUsingPOST(Async)");
        }
        
        // verify the required parameter 'email' is set
        if (email == null) {
            throw new ApiException("Missing the required parameter 'email' when calling jddSearchUsingPOST(Async)");
        }
        
        
        com.squareup.okhttp.Call call = jddSearchUsingPOSTCall(db, term, retStart, retMax, retmode, tool, email, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * searches journal doc
     * searches journal doc. 
     * @param db a db name. (required)
     * @param term a term. (required)
     * @param retStart a ret Start. (required)
     * @param retMax a retMax. (required)
     * @param retmode an retmode. (required)
     * @param tool a tool name. (required)
     * @param email an email. (required)
     * @return ResultC
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ResultC jddSearchUsingPOST(String db, String term, String retStart, String retMax, String retmode, String tool, String email) throws ApiException {
		ApiResponse<ResultC> resp = jddSearchUsingPOSTWithHttpInfo(db, term, retStart, retMax, retmode, tool, email);
        return resp.getData();
    }

    /**
     * searches journal doc
     * searches journal doc. 
     * @param db a db name. (required)
     * @param term a term. (required)
     * @param retStart a ret Start. (required)
     * @param retMax a retMax. (required)
     * @param retmode an retmode. (required)
     * @param tool a tool name. (required)
     * @param email an email. (required)
     * @return ApiResponse&lt;ResultC&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ResultC> jddSearchUsingPOSTWithHttpInfo(String db, String term, String retStart, String retMax, String retmode, String tool, String email) throws ApiException {
        com.squareup.okhttp.Call call = jddSearchUsingPOSTValidateBeforeCall(db, term, retStart, retMax, retmode, tool, email, null, null);
        Type localVarReturnType = new TypeToken<ResultC>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * searches journal doc (asynchronously)
     * searches journal doc. 
     * @param db a db name. (required)
     * @param term a term. (required)
     * @param retStart a ret Start. (required)
     * @param retMax a retMax. (required)
     * @param retmode an retmode. (required)
     * @param tool a tool name. (required)
     * @param email an email. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call jddSearchUsingPOSTAsync(String db, String term, String retStart, String retMax, String retmode, String tool, String email, final ApiCallback<ResultC> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = jddSearchUsingPOSTValidateBeforeCall(db, term, retStart, retMax, retmode, tool, email, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ResultC>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
