/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.iate.reco.obj;

/**
 *
 * @author Bitizen
 */
public enum RequestType {
    GET(0),
    POST(1),
    PUT(2),
    PATCH(3),
    DELETE(4),
    HEAD(5),
    OPTIONS(6);
    
    private int requestCode;

    private RequestType(int requestCode) {
        this.requestCode = requestCode;
    }

    public int getRequestCode() {
        return requestCode;
    }
    
    
    public static String[] getTypes(){
        return new String[]{"GET", "POST", "PUT", "PATCH", "DELETE", "HEAD", "OPTIONS"};
    }
}
