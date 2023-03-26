/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Helper;
import Controller.SQLite; 
import Controller.Secure; 
import Model.Logs;
import Model.User;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author beepxD
 */
public class MgmtUser extends javax.swing.JPanel {

    public SQLite sqlite;
    public DefaultTableModel tableModel;
    public Dialog dialogBox; 
    private User currentUser;
    public Helper helper = new Helper();
    DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern(Logs.datetimeformatstring);
    
    public MgmtUser(SQLite sqlite) {
        initComponents();
        this.sqlite = sqlite;
        tableModel = (DefaultTableModel)table.getModel();
        table.getTableHeader().setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));
//        UNCOMMENT TO DISABLE BUTTONS
//        editBtn.setVisible(false);
//        deleteBtn.setVisible(false);
//        lockBtn.setVisible(false);
//        chgpassBtn.setVisible(false);
    }
    
    public void setCurrentuser(User currentUser) {
        this.currentUser = currentUser;
    }
    
    public User getCurrentUser() {
        return this.currentUser;
    }
    
    public void init(){
        // CLEAR TABLE
        for(int nCtr = tableModel.getRowCount(); nCtr > 0; nCtr--){
            tableModel.removeRow(0);
        }
        
        // LOAD CONTENTS
        loadContents();
        dialogBox = new Dialog();
    }
    
    public void loadContents() {
        ArrayList<User> users = sqlite.getUsers();
        for(int nCtr = 0; nCtr < users.size(); nCtr++){
            tableModel.addRow(new Object[]{
                users.get(nCtr).getUsername(), 
//                users.get(nCtr).getPasswordHash(), 
                users.get(nCtr).getRole(), 
                users.get(nCtr).getLocked(),
                users.get(nCtr).getDisabled()});
            
        }
    }
    
    public void reloadContents() {
        for(int nCtr = tableModel.getRowCount(); nCtr > 0; nCtr--){
            tableModel.removeRow(0);
        }
        loadContents();
    }

    public void designer(JTextField component, String text){
        component.setSize(70, 600);
        component.setFont(new java.awt.Font("Tahoma", 0, 18));
        component.setBackground(new java.awt.Color(240, 240, 240));
        component.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        component.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), text, javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12)));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        editRoleBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        lockBtn = new javax.swing.JButton();
        chgpassBtn = new javax.swing.JButton();
        enableDisableAccBtn = new javax.swing.JButton();

        table.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Username", "Role", "Locked", "Disabled"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(24);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(160);
            table.getColumnModel().getColumn(1).setPreferredWidth(100);
            table.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        editRoleBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editRoleBtn.setText("EDIT ROLE");
        editRoleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRoleBtnActionPerformed(evt);
            }
        });

        deleteBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteBtn.setText("DELETE");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        lockBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lockBtn.setText("LOCK/UNLOCK");
        lockBtn.setToolTipText("");
        lockBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lockBtnActionPerformed(evt);
            }
        });

        chgpassBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chgpassBtn.setText("CHANGE PASS");
        chgpassBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chgpassBtnActionPerformed(evt);
            }
        });

        enableDisableAccBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        enableDisableAccBtn.setText("ENABLE / DISABLE");
        enableDisableAccBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enableDisableAccBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editRoleBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(lockBtn)
                        .addGap(0, 0, 0)
                        .addComponent(enableDisableAccBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(chgpassBtn))
                    .addComponent(jScrollPane1))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editRoleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lockBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chgpassBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(enableDisableAccBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editRoleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editRoleBtnActionPerformed
        User currUser = getCurrentUser();
        
        // Ensures the role is admin
        if(table.getSelectedRow() >= 0  && currUser != null && currUser.getRole() == 5){
            System.out.println("Current user username: " + currUser.getUsername() + ", role: " + currUser.getRole());
            String[] options = {"2-CLIENT","3-STAFF","4-MANAGER","5-ADMIN"};
            
            JComboBox optionList = new JComboBox(options);
            optionList.setSelectedIndex((int)tableModel.getValueAt(table.getSelectedRow(), 1) - 2);
            String result = (String) JOptionPane.showInputDialog(null, "USER: " + tableModel.getValueAt(table.getSelectedRow(), 0), 
                "EDIT USER ROLE", JOptionPane.QUESTION_MESSAGE, null, options, options[(int)tableModel.getValueAt(table.getSelectedRow(), 1) - 2]);
            
            System.out.println("result: " + result);
            
            if(result != null){
                String username = tableModel.getValueAt(table.getSelectedRow(), 0).toString();
                
                // If admin is trying to change their role
                if (username.equalsIgnoreCase(currUser.getUsername())) {
                    dialogBox.showErrorDialog("Error Role Change", "You cannot set/update your own role.");
                } else {
                    User user = sqlite.getUser(username);
                    int oldRole = user.getRole();

                    int role = Character.getNumericValue(result.charAt(0));
                    user.setRole(role);
                    //Log old role to new role
                    String desc = "Role of user " + "\"" + username + "\"" + " edited from " + oldRole + " to " + role + "."; 
                    String timestamp = helper.getCurrentTimestamp();
                    sqlite.addLogs("editRoleSuccess", currUser.getUsername(), desc, timestamp);
                    
//                    sqlite.addLogs(result, username, result, username);

                    // If role is 1 somehow, default to 2 set disable to 1, separated from role to not overwrite old role
                    if (role == 1) {
                        user.setRole(2);
                        // Log
                    }

                    // Update user in DB
                    sqlite.updateUser(user);
                    reloadContents();
                }
            }
        }
    }//GEN-LAST:event_editRoleBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        User currUser = getCurrentUser();
        
        if(table.getSelectedRow() >= 0){
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + tableModel.getValueAt(table.getSelectedRow(), 0) + "?", "Delete User", JOptionPane.YES_NO_OPTION);
            String username = tableModel.getValueAt(table.getSelectedRow(), 0).toString();
            if (result == JOptionPane.YES_OPTION) {
                if (username.equalsIgnoreCase(currUser.getUsername())) {
                    dialogBox.showErrorDialog("Error Role Change", "You cannot delete your own account.");
                    String desc = currUser.getUsername() + " attempted to delete user " + "\"" + username + "\"" + " but failed.";
                    String timestamp = helper.getCurrentTimestamp();
                    sqlite.addLogs("deletedUserFailed", currUser.getUsername(), desc, timestamp);
                } else {
                     sqlite.removeUser(username);
                    String desc = "User " + "\"" + username + "\"" + " deleted."; 
                    String timestamp = helper.getCurrentTimestamp();
                    sqlite.addLogs("deletedUserSuccess", currUser.getUsername(), desc, timestamp);
                    System.out.println(tableModel.getValueAt(table.getSelectedRow(), 0));
                    reloadContents();
                }
               
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void lockBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lockBtnActionPerformed
        
        User currUser = getCurrentUser();
        
        if(table.getSelectedRow() >= 0  && currUser != null && currUser.getRole() == 5){
            String state = "lock";
            if("1".equals(tableModel.getValueAt(table.getSelectedRow(), 2) + "")){
                state = "unlock";
            } 
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to " + state + " " + tableModel.getValueAt(table.getSelectedRow(), 0) + "?", state.toUpperCase() + " USER", JOptionPane.YES_NO_OPTION);
            
            if (result == JOptionPane.YES_OPTION) {
                String username = tableModel.getValueAt(table.getSelectedRow(), 0).toString();
                System.out.println(username);
                if (username.equalsIgnoreCase(currUser.getUsername())) {
                     dialogBox.showErrorDialog("Error Locking Account", "You cannot lock your own account.");
                } else {
                    User user = sqlite.getUser(username);
                
                    if (user.getLocked() == 1 && state.equals("unlock")) 
                        user.setLocked(0);

                    // Else if user is indeed unlocked and you want to lock them
                    else if (user.getLocked() == 0 && state.equals("lock"))
                        user.setLocked(1);

                    sqlite.updateUser(user);
                    String desc = "User " + "\"" + username + "\"" + " has now been "+ state + "ed."; 
                    String timestamp = helper.getCurrentTimestamp();
                    sqlite.addLogs("lockUserSuccess", currUser.getUsername(), desc, timestamp);
                    reloadContents();
//                System.out.println("Clicked yes");
                }
                
            } else {
                System.out.println("Canceled");
            }
            
            
        }
    }//GEN-LAST:event_lockBtnActionPerformed

//    if(table.getSelectedRow() >= 0){
//            JPasswordField password = new JPasswordField();
//            JPasswordField confpass = new JPasswordField();
//            designer(password, "NEW PASSWORD");
//            designer(confpass, "CONFIRM PASSWORD");
//
//            Object[] message = {
//                "Enter New Password:", password, confpass
//            };
//
//            int result = JOptionPane.showConfirmDialog(null, message, "CHANGE PASSWORD", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);
//
//            if (result == JOptionPane.OK_OPTION) {
//                String username = tableModel.getValueAt(table.getSelectedRow(), 0).toString();
//                User user = sqlite.getUser(username);
//                if (user != null) {
//                    String newpassStr = new String(password.getPassword());
//                    String confpassStr = new String(confpass.getPassword());
//                    if (newpassStr.equals(confpassStr) && Secure.isValidPassword(newpassStr)) {
//                        user.setSalt(User.generateSalt());
//                        user.setPasswordHash(User.hashPassword(newpassStr, user.getSalt()));
//                        boolean status = sqlite.updateUser(username, user);
//                        if (status) {
//                            dialogBox.showSuccessDialog("Reset password success", "User password changed successfully.");
//                        }
//                    }
//                    else {
//                        dialogBox.showErrorDialog("Error resetting password", "Both passwords do not match or password does not follow the required criteria.");
//                    }
//                }
//                else {
//                    dialogBox.showErrorDialog("Error changing password", "Current password is incorrect.");
//                }
//            }
//        }

    private void chgpassBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chgpassBtnActionPerformed
        User currUser = getCurrentUser();
        if(table.getSelectedRow() >= 0  && currUser != null && currUser.getRole() == 5){
            JPasswordField oldPassword = new JPasswordField();
            JPasswordField password = new JPasswordField();
            JPasswordField confpass = new JPasswordField();
            designer(oldPassword, "OLD PASSWORD");
            designer(password, "NEW PASSWORD");
            designer(confpass, "CONFIRM PASSWORD");

            Object[] message = {
                "Enter New Password:", oldPassword, password, confpass
            };
            String username = tableModel.getValueAt(table.getSelectedRow(), 0).toString();
            int result = JOptionPane.showConfirmDialog(null, message, "Change Password for " + username , JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);

            if (result == JOptionPane.OK_OPTION) {
//                String username = tableModel.getValueAt(table.getSelectedRow(), 0).toString();
//                System.out.println(username);
                User user = sqlite.getUser(username);
                if (user.validate(username, oldPassword.getPassword())) {
                    String newpassStr = new String(password.getPassword());
                    String confpassStr = new String(confpass.getPassword());
                    if (newpassStr.equals(confpassStr) && Secure.isValidPassword(newpassStr)) {
                        user.setSalt(User.generateSalt());
                        user.setPasswordHash(User.hashPassword(newpassStr, user.getSalt()));
                        boolean status = sqlite.updateUser(username, user);
                        if (status) {
                            dialogBox.showSuccessDialog("Change password success", "User password changed successfully.");
                            String desc = "User " + "\"" + username + "\"" + " password successfully changed."; 
                            String timestamp = helper.getCurrentTimestamp();
                            sqlite.addLogs("passwordUserSuccess", currUser.getUsername(), desc, timestamp);
                        }
                    } else {
                        String passCriteria = Secure.getPassCriteria();
                        dialogBox.showErrorDialog("Error changing password", "Both passwords do not match or password does not follow the required criteria. " + passCriteria);
                        String desc = "User " + "\"" + username + "\"" + " error in changing password. Both passwords do not match or password does not follow the required criteria."; 
                        String timestamp = helper.getCurrentTimestamp();
                        sqlite.addLogs("passwordUserFailed", currUser.getUsername(), desc, timestamp);
                    }
                } else {
                    dialogBox.showErrorDialog("Error changing password", "Current password is incorrect.");
                    String desc = "User " + "\"" + username + "\"" + " error in changing password. Password entered was incorrect."; 
                    String timestamp = helper.getCurrentTimestamp();
                    sqlite.addLogs("passwordUserFailed", currUser.getUsername(), desc, timestamp);
                }
            }
        }
    }//GEN-LAST:event_chgpassBtnActionPerformed

    private void enableDisableAccBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enableDisableAccBtnActionPerformed
        User currUser = getCurrentUser();
        
        // If there is selected row, current user not null and the role is 5
        if(table.getSelectedRow() >= 0 && currUser != null && currUser.getRole() == 5) {
            System.out.println("Current user username: " + currUser.getUsername() + ", role: " + currUser.getRole());
            String state = "disable";
            System.out.println("value: " + tableModel.getValueAt(table.getSelectedRow(), 3));
            if("1".equals(tableModel.getValueAt(table.getSelectedRow(), 3) + "")){
                state = "enable";
            } 
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to " + state + " " + tableModel.getValueAt(table.getSelectedRow(), 0) + "?", state.toUpperCase() + " USER", JOptionPane.YES_NO_OPTION);
            
            // If user clicks yes
            if (result == JOptionPane.YES_OPTION) {
                String username = tableModel.getValueAt(table.getSelectedRow(), 0).toString();
                System.out.println(username);
                
                if (username.equalsIgnoreCase(currUser.getUsername())) {
                    dialogBox.showErrorDialog("Error Disabling Account", "You cannot disable your own account.");
                    String desc = "User " + "\"" + currUser.getUsername() + "\"" + " tried to " + state + " \"" + username + "\"" + " but failed."; 
                    String timestamp = helper.getCurrentTimestamp();
                    sqlite.addLogs("disableUserFailed", currUser.getUsername(), desc, timestamp);
                } else {
                    User user = sqlite.getUser(username);
                    if (user.getDisabled() == 1 && state.equals("enable")) 
                        user.setDisabled(0);

                    // Else if user is not disabled and admin wants to enable them
                    else if (user.getDisabled() == 0 && state.equals("disable"))
                        user.setDisabled(1);

                    sqlite.updateUser(user);
                    reloadContents();
                    String desc = "User " + "\"" + username + "\"" + " successfully " + state + "d."; 
                    String timestamp = helper.getCurrentTimestamp();
                    sqlite.addLogs(state+"UserSuccess", currUser.getUsername(), desc, timestamp);
                    }
                
            } else {
                String desc = "Canceled enable/disable."; 
                String timestamp = helper.getCurrentTimestamp();
                sqlite.addLogs(state+"UserCanceled", currUser.getUsername(), desc, timestamp);
                System.out.println("Canceled");
            }
            
        }
    }//GEN-LAST:event_enableDisableAccBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chgpassBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editRoleBtn;
    private javax.swing.JButton enableDisableAccBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lockBtn;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
