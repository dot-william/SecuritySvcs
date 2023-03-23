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
public class StaffHome extends javax.swing.JPanel {

    public MgmtHistory mgmtHistory;
    public MgmtLogs mgmtLogs;
    public MgmtProduct mgmtProduct;
    public MgmtUser mgmtUser;
    private User currentUser; 
    private CardLayout contentView = new CardLayout();
    
    public StaffHome() {
        initComponents();
    }
    
    public void init(SQLite sqlite){
        mgmtHistory = new MgmtHistory(sqlite);
        mgmtLogs = new MgmtLogs(sqlite);
        mgmtProduct = new MgmtProduct(sqlite);
        mgmtUser = new MgmtUser(sqlite);  
        
        Content.setLayout(contentView);
        Content.add(new Home("WELCOME STAFF!", new java.awt.Color(0,204,102)), "home");
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

        productsBtn = new javax.swing.JButton();
        Content = new javax.swing.JPanel();
        historyBtn = new javax.swing.JButton();
        productsBtn1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 204, 102));

        productsBtn.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        productsBtn.setText("MANAGE PRODUCTS");
        productsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productsBtnActionPerformed(evt);
            }
        });

        Content.setBackground(new java.awt.Color(0, 204, 102));

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

        historyBtn.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        historyBtn.setText("VIEW MY HISTORY");
        historyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyBtnActionPerformed(evt);
            }
        });

        productsBtn1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        productsBtn1.setText("PRODUCTS FOR SALE");
        productsBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productsBtn1ActionPerformed(evt);
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
                        .addComponent(productsBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(historyBtn)
                        .addGap(0, 13, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(historyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productsBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void productsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productsBtnActionPerformed
        mgmtProduct.init();
//        usersBtn.setForeground(Color.black);
        productsBtn.setForeground(Color.red);
        historyBtn.setForeground(Color.black);
//        logsBtn.setForeground(Color.black);
        contentView.show(Content, "mgmtProduct");
    }//GEN-LAST:event_productsBtnActionPerformed

    private void historyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyBtnActionPerformed
        mgmtHistory.init();
//        usersBtn.setForeground(Color.black);
        productsBtn.setForeground(Color.black);
        historyBtn.setForeground(Color.red);
//        logsBtn.setForeground(Color.black);
        contentView.show(Content, "mgmtHistory");
    }//GEN-LAST:event_historyBtnActionPerformed

    private void productsBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productsBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productsBtn1ActionPerformed
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Content;
    private javax.swing.JButton historyBtn;
    private javax.swing.JButton productsBtn;
    private javax.swing.JButton productsBtn1;
    // End of variables declaration//GEN-END:variables
}
