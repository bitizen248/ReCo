/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.iate.reco.obj;

import com.google.gson.JsonObject;
import com.mashape.unirest.request.HttpRequestWithBody;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Bitizen
 */
public class Request {
    
     private String address;
     private RequestType requestType;
     private Map<String, String> headers;
     
     private Map<String, Object> requestParamsGet;
     private Object requestParamsPost;

    public Request(String root, ProjectRequest request) {
        this.address =  root + request.getRequestAddress();
        this.requestType = request.getType();
        this.headers = new HashMap<>();
        if (this.requestType == RequestType.GET
                || this.requestType == RequestType.HEAD) {
            this.requestParamsPost = new HashMap<>();
        } else {
            this.requestParamsPost = request.getRequest();
        }
    }
     
     

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, Object> getRequestParamsGet() {
        return requestParamsGet;
    }

    public void setRequestParamsGet(Map<String, Object> requestParamsGet) {
        this.requestParamsGet = requestParamsGet;
    }

    public Object getRequestParamsPost() {
        return requestParamsPost;
    }

    public void setRequestParamsPost(Object requestParamsPost) {
        this.requestParamsPost = requestParamsPost;
    }
}
