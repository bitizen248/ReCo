/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.iate.reco.ui;

import ru.iate.reco.obj.ProjectListModel;
import ru.iate.reco.obj.RecoProject;
import ru.iate.reco.obj.RequestMenuModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.io.IOException;
import ru.iate.reco.factory.ProjectFactory;

/**
 *
 * @author Bitizen
 */
public class ProjectWindow extends javax.swing.JFrame {
    
    private RecoProject project;
    private String pathToProject;

    /**
     * Creates new form ProjectWindow
     */
    public ProjectWindow(RecoProject project, String path) {
      this.project = project;
      this.pathToProject = path;
      initComponents();
      refreshList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        root = new javax.swing.JPanel();
        toolbar = new javax.swing.JPanel();
        save = new javax.swing.JButton();
        projectView = new javax.swing.JPanel();
        javax.swing.JSplitPane jSplitPane1 = new javax.swing.JSplitPane();
        javax.swing.JPanel menu = new javax.swing.JPanel();
        javax.swing.JPanel jPanel3 = new javax.swing.JPanel();
        addRequest = new javax.swing.JButton();
        removeRequest = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        projectMenu = new javax.swing.JList<>();
        frame = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 500));

        root.setLayout(new java.awt.BorderLayout());

        toolbar.setLayout(new javax.swing.BoxLayout(toolbar, javax.swing.BoxLayout.LINE_AXIS));

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        toolbar.add(save);

        root.add(toolbar, java.awt.BorderLayout.PAGE_START);

        projectView.setLayout(new javax.swing.BoxLayout(projectView, javax.swing.BoxLayout.LINE_AXIS));

        menu.setAlignmentX(0.0F);
        menu.setAlignmentY(0.0F);
        menu.setMinimumSize(new java.awt.Dimension(100, 52));
        menu.setPreferredSize(new java.awt.Dimension(50, 245));
        menu.setLayout(new javax.swing.BoxLayout(menu, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel3.setAlignmentX(0.0F);
        jPanel3.setAlignmentY(0.0F);
        jPanel3.setPreferredSize(new java.awt.Dimension(40, 20));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.X_AXIS));

        addRequest.setText("+");
        addRequest.setAlignmentY(0.0F);
        addRequest.setMargin(new java.awt.Insets(0, 0, 0, 0));
        addRequest.setMaximumSize(new java.awt.Dimension(20, 20));
        addRequest.setMinimumSize(new java.awt.Dimension(20, 20));
        addRequest.setPreferredSize(new java.awt.Dimension(20, 20));
        addRequest.setRolloverEnabled(true);
        addRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRequestActionPerformed(evt);
            }
        });
        jPanel3.add(addRequest);

        removeRequest.setText("-");
        removeRequest.setAlignmentY(0.0F);
        removeRequest.setMaximumSize(new java.awt.Dimension(20, 20));
        removeRequest.setMinimumSize(new java.awt.Dimension(20, 20));
        removeRequest.setPreferredSize(new java.awt.Dimension(20, 20));
        removeRequest.setRolloverEnabled(true);
        removeRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeRequestActionPerformed(evt);
            }
        });
        jPanel3.add(removeRequest);

        menu.add(jPanel3);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(300, 300));

        projectMenu.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        projectMenu.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && projectMenu.getSelectedIndex() != -1) {
                frame.removeAll();
                if (projectMenu.getSelectedIndex() == 0) {
                    ProjectPanel panel = new ProjectPanel(this);
                    frame.add(panel);
                } else {
                    RequestPanel panel = new RequestPanel();
                    frame.add(panel);
                }
                frame.updateUI();
            }
        });
        jScrollPane1.setViewportView(projectMenu);

        menu.add(jScrollPane1);

        jSplitPane1.setLeftComponent(menu);

        frame.setLayout(new javax.swing.BoxLayout(frame, javax.swing.BoxLayout.LINE_AXIS));
        jSplitPane1.setRightComponent(frame);

        projectView.add(jSplitPane1);

        root.add(projectView, java.awt.BorderLayout.CENTER);

        getContentPane().add(root, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");
        menuBar.add(jMenu1);

        jMenu2.setText("Edit");
        menuBar.add(jMenu2);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRequestActionPerformed
        project.addNewRequest();
        refreshList();
//        menuModel.
//        projectMenu.chang
    }//GEN-LAST:event_addRequestActionPerformed

    private void removeRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeRequestActionPerformed

    }//GEN-LAST:event_removeRequestActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        try {
            ProjectFactory.saveProject(project, pathToProject);
        } catch (IOException e) {
            // TODO: 16.05.17 вывод ошибки
            e.printStackTrace();
        }
    }//GEN-LAST:event_saveActionPerformed

    private void refreshList() {
        DefaultListModel<String> model = new DefaultListModel<>();
        ProjectListModel modelGenerator = new ProjectListModel(project);
        for (int i = 0; i < modelGenerator.getSize(); i++) {
            model.add(i, modelGenerator.getElementAt(i));
        }
        projectMenu.setModel(model);
    }

    public RecoProject getProject() {
        return project;
    }

    public void setProject(RecoProject project) {
        this.project = project;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRequest;
    private javax.swing.JPanel frame;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JList<String> projectMenu;
    private javax.swing.JPanel projectView;
    private javax.swing.JButton removeRequest;
    private javax.swing.JPanel root;
    private javax.swing.JButton save;
    private javax.swing.JPanel toolbar;
    // End of variables declaration//GEN-END:variables
}
