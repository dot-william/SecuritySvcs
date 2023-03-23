/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.SQLite;
import Model.History;
import Model.Logs;
import Model.Product;
import Model.User;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BeepXD
 */
public class ManagerHome extends javax.swing.JPanel {

    public MgmtHistory mgmtHistory;
    public MgmtLogs mgmtLogs;
    public MgmtProduct mgmtProduct;
    public MgmtUser mgmtUser;
    private User currentUser; 
    private CardLayout contentView = new CardLayout();
    
    public ManagerHome() {
        initComponents();
    }
    
    public void init(SQLite sqlite){
        mgmtHistory = new MgmtHistory(sqlite);
        mgmtLogs = new MgmtLogs(sqlite);
        mgmtProduct = new MgmtProduct(sqlite);
        mgmtUser = new MgmtUser(sqlite); 
        
        Content.setLayout(contentView);
        Content.add(new Home("WELCOME MANAGER!", new java.awt.Color(153,102,255)), "home");
        Content.add(mgmtUser, "mgmtUser");
        Content.add(mgmtHistory, "mgmtHistory");
        Content.add(mgmtProduct, "mgmtProduct");
        Content.add(mgmtLogs, "mgmtLogs");
        
//        UNCOMMENT TO DISABLE BUTTONS
//        historyBtn.setVisible(false);
//        usersBtn.setVisible(false);
//        productsBtn.setVisible(false);
//        logsBtn.setVisible(false);
    }
    
    public void setCurrentUser(User currentUser) {
        if (currentUser != null)
            this.currentUser = currentUser;  
        else
            this.currentUser = null;
    }
    
    public void showPnl(String panelName){
        contentView.show(Content, panelName);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Content = new javax.swing.JPanel();
        productsBtn1 = new javax.swing.JButton();
        historyBtn1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 102, 255));

        Content.setBackground(new java.awt.Color(153, 102, 255));

        javax.swing.GroupLayout ContentLayout = new javax.swing.GroupLayout(Content);
        Content.setLayout(ContentLayout);
        ContentLayout.setHorizontalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        ContentLayout.setVerticalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 271, Short.MAX_VALUE)
        );

        productsBtn1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        productsBtn1.setText("MANAGE PRODUCTS");
        productsBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productsBtn1ActionPerformed(evt);
            }
        });

        historyBtn1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        historyBtn1.setText("VIEW USER HISTORY");
        historyBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(productsBtn1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(historyBtn1)
                        .addGap(0, 287, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productsBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(historyBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void productsBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productsBtn1ActionPerformed
        // TODO add your handling code here: 
        mgmtProduct.init(this.currentUser);
        productsBtn1.setForeground(Color.red);
        historyBtn1.setForeground(Color.black);
//        logsBtn.setForeground(Color.black);
        contentView.show(Content, "mgmtProduct");
    }//GEN-LAST:event_productsBtn1ActionPerformed

    private void historyBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyBtn1ActionPerformed
        // TODO add your handling code here:
        mgmtHistory.init(this.currentUser);
//        usersBtn.setForeground(Color.black);
        productsBtn1.setForeground(Color.black);
        historyBtn1.setForeground(Color.red);
//        logsBtn.setForeground(Color.black);
        contentView.show(Content, "mgmtHistory");
    }//GEN-LAST:event_historyBtn1ActionPerformed
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Content;
    private javax.swing.JButton historyBtn1;
    private javax.swing.JButton productsBtn1;
    // End of variables declaration//GEN-END:variables
}
