/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.iate.reco.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ru.iate.reco.obj.RecoProject;

/**
 *
 * @author Egor
 */
public class ProjectFactory {
    
    public static RecoProject openProject(String path) throws IOException, ClassNotFoundException {
        RecoProject projectObj = null;
        
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        projectObj = (RecoProject) ois.readObject();
        ois.close();
        
        return projectObj;
    }
    
    public static void saveProject(RecoProject project, String path) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(project);
        oos.close();
    }
}
