/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.iate.reco.obj;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Bitizen
 */
public class RecoProject implements Serializable {
    
    private String name;
    private long timestamp;
    
    private List<Request> requests;
}
