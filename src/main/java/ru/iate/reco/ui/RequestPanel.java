/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file,    @Override
    public void insertUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 choose Tools | Templates
 * and open the template in the editor.
 */
package ru.iate.reco.ui;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import ru.iate.reco.factory.RequestFactory;
import ru.iate.reco.obj.ProjectRequest;
import ru.iate.reco.obj.Request;

/**
 *
 * @author Bitizen
 */
public class RequestPanel extends javax.swing.JPanel {

    private String root;
    private ProjectWindow window;
    private int index;
    /**
     * Creates new form RequestFrame
     */
    public RequestPanel(String root, ProjectWindow window, int index) {
        this.root = root;
        this.window = window;
        this.index = index;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        requestField = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        startRequest = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        javax.swing.JPanel requestPanel = new javax.swing.JPanel();
        javax.swing.JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        requestPane = new javax.swing.JTextPane();
        responsePanel = new javax.swing.JPanel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        responsePane = new javax.swing.JTextPane();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel1.setPreferredSize(new java.awt.Dimension(0, 32));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setText(" Request Address:");
        jPanel1.add(jLabel1);

        requestField.setText(window.getProject().getRequests().get(index).getRequestAddress());
        requestField.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                removeUpdate(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                window.getProject().getRequests().get(index).setRequestAddress(requestField.getText());
                window.getRootPane().updateUI();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        requestField.setMaximumSize(new java.awt.Dimension(200, 26));
        requestField.setPreferredSize(new java.awt.Dimension(200, 26));
        jPanel1.add(requestField);
        jPanel1.add(filler1);

        startRequest.setText("Start");
        startRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startRequestActionPerformed(evt);
            }
        });
        jPanel1.add(startRequest);

        add(jPanel1);

        requestPanel.setLayout(new java.awt.BorderLayout());

        requestPane.setText(window.getProject().getRequests().get(index).getRequest());
        requestPane.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                removeUpdate(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                window.getProject().getRequests().get(index).setRequest(requestPane.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        jScrollPane2.setViewportView(requestPane);

        requestPanel.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Request", requestPanel);

        responsePanel.setLayout(new java.awt.BorderLayout());

        responsePane.setText(window.getProject().getRequests().get(index).getResponse());
        requestPane.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                removeUpdate(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                window.getProject().getRequests().get(index).setResponse(responsePane.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        jScrollPane1.setViewportView(responsePane);

        responsePanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Response", responsePanel);

        add(jTabbedPane1);
    }// </editor-fold>//GEN-END:initComponents

    private void startRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startRequestActionPerformed
        // TODO add your handling code here:
        Request request = new Request();
        //RequestFactory.request(rawRequest)
    }//GEN-LAST:event_startRequestActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField requestField;
    private javax.swing.JTextPane requestPane;
    private javax.swing.JTextPane responsePane;
    private javax.swing.JPanel responsePanel;
    private javax.swing.JButton startRequest;
    // End of variables declaration//GEN-END:variables
}
