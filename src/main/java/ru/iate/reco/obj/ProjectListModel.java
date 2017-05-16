package ru.iate.reco.obj;

import javax.swing.*;

/**
 * Created by Bitizen on 08.05.17.
 */
public class ProjectListModel extends AbstractListModel<String> {

    private RecoProject project;

    public ProjectListModel(RecoProject project) {
        this.project = project;
    }

    @Override
    public int getSize() {
        return project.getRequests().size() + 1;
    }

    @Override
    public String getElementAt(int index) {
        if (index == 0) {
            return new RequestMenuModel(RequestMenuModel.Type.PROJECT, project.getName()).toString();
        } else {
            return new RequestMenuModel(RequestMenuModel.Type.REQUEST, project.getRequests().get(index - 1).getName()).toString();
        }
    }


}
