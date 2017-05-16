/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.iate.reco.obj;

import com.google.gson.JsonObject;
import java.io.Serializable;

/**
 *
 * @author Bitizen
 */
public class ProjectRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    
    private String requestAddress;
    private RequestType type;
    
    private boolean customRoot;
    private String customRootAddress;
    
    private String request;
    private String response;

    public ProjectRequest(String name) {
        this.name = name;
        requestAddress = "/";
        type = RequestType.GET;
        customRoot = false;
        customRootAddress = "";
        request = "{\n}";
        response = "{\n}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRequestAddress() {
        return requestAddress;
    }

    public void setRequestAddress(String requestAddress) {
        this.requestAddress = requestAddress;
    }

    public RequestType getType() {
        return type;
    }

    public void setType(RequestType type) {
        this.type = type;
    }

    public boolean isCustomRoot() {
        return customRoot;
    }

    public void setCustomRoot(boolean customRoot) {
        this.customRoot = customRoot;
    }

    public String getCustomRootAddress() {
        return customRootAddress;
    }

    public void setCustomRootAddress(String customRootAddress) {
        this.customRootAddress = customRootAddress;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    
    
    
}
