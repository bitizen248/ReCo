/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.iate.reco.obj;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bitizen
 */
public class RecoProject implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String name;
    private long timestamp;
    
    private String requestRoot;
    
    private List<ProjectRequest> requests;

    public RecoProject(String name, String requestRoot) {
        this.name = name;
        this.timestamp = System.currentTimeMillis();
        this.requestRoot = requestRoot;
        this.requests = new ArrayList<>();
    }

    public void addNewRequest() {
        requests.add(new ProjectRequest("NewRequest" + requests.size()));
    }

    public void removeRequest(int number) {
        requests.remove(number);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRequestRoot() {
        return requestRoot;
    }

    public void setRequestRoot(String requestRoot) {
        this.requestRoot = requestRoot;
    }

    public List<ProjectRequest> getRequests() {
        return requests;
    }

    public void setRequests(List<ProjectRequest> requests) {
        this.requests = requests;
    }

    public long getTimestamp() {
        return timestamp;
    }
    
}
