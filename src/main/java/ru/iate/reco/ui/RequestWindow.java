/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.iate.reco.ui;

import com.mashape.unirest.http.HttpResponse;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 *
 * @author Bitizen
 */
public class RequestWindow extends javax.swing.JFrame {

    private Observable<HttpResponse> request;
    private String response;
    /**
     * Creates new form RequestWindow
     */
    public RequestWindow(Observable<HttpResponse> request, String response) {  
        this.request = request;
        this.response = response;
        initComponents();  
    }

        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.Box.Filler filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(16, 0), new java.awt.Dimension(16, 0), new java.awt.Dimension(16, 32767));
        javax.swing.Box.Filler filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 16), new java.awt.Dimension(0, 16), new java.awt.Dimension(32767, 16));
        javax.swing.Box.Filler filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(16, 0), new java.awt.Dimension(16, 0), new java.awt.Dimension(16, 32767));
        javax.swing.JPanel view = new javax.swing.JPanel();
        javax.swing.JPanel supAnswer = new javax.swing.JPanel();
        javax.swing.JLabel supAnswerLabel = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        supAnswerView = new javax.swing.JTextPane();
        javax.swing.Box.Filler filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(24, 0), new java.awt.Dimension(24, 0), new java.awt.Dimension(32767, 0));
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        actualAnswerView = new javax.swing.JTextPane();
        javax.swing.JPanel actionBar = new javax.swing.JPanel();
        javax.swing.Box.Filler filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        ok = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().add(filler1, java.awt.BorderLayout.EAST);
        getContentPane().add(filler3, java.awt.BorderLayout.NORTH);
        getContentPane().add(filler2, java.awt.BorderLayout.WEST);

        view.setLayout(new javax.swing.BoxLayout(view, javax.swing.BoxLayout.LINE_AXIS));

        supAnswer.setPreferredSize(new java.awt.Dimension(184, 268));
        supAnswer.setLayout(new javax.swing.BoxLayout(supAnswer, javax.swing.BoxLayout.PAGE_AXIS));

        supAnswerLabel.setText("Supposed answer");
        supAnswer.add(supAnswerLabel);

        supAnswerView.setEnabled(false);
        jScrollPane1.setViewportView(supAnswerView);

        supAnswer.add(jScrollPane1);

        view.add(supAnswer);
        view.add(filler5);

        jPanel4.setPreferredSize(new java.awt.Dimension(184, 268));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel2.setText("Actual answer");
        jPanel4.add(jLabel2);

        actualAnswerView.setEnabled(false);
        jScrollPane2.setViewportView(actualAnswerView);

        jPanel4.add(jScrollPane2);

        view.add(jPanel4);

        getContentPane().add(view, java.awt.BorderLayout.CENTER);
        supAnswerView.setText(response);
        request
        .observeOn(Schedulers.io())
        .subscribe(r -> {
            actualAnswerView.setText(r.getBody().toString());
        });

        actionBar.setLayout(new javax.swing.BoxLayout(actionBar, javax.swing.BoxLayout.LINE_AXIS));
        actionBar.add(filler4);

        ok.setText("OK");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        actionBar.add(ok);

        getContentPane().add(actionBar, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        dispose();
    }//GEN-LAST:event_okActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane actualAnswerView;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton ok;
    private javax.swing.JTextPane supAnswerView;
    // End of variables declaration//GEN-END:variables
}
