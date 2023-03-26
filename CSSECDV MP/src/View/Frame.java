package View;

import Controller.Helper;
import Controller.Main;
import Model.User;
import Model.Logs;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.WindowConstants;
import Controller.Secure;
import static Controller.Secure.DialogBox;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Frame extends javax.swing.JFrame {

    public Frame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Container = new javax.swing.JPanel();
        HomePnl = new javax.swing.JPanel();
        Content = new javax.swing.JPanel();
        Navigation = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JButton();
        changePassBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setMinimumSize(new java.awt.Dimension(800, 450));

        HomePnl.setBackground(new java.awt.Color(102, 102, 102));
        HomePnl.setPreferredSize(new java.awt.Dimension(801, 500));

        javax.swing.GroupLayout ContentLayout = new javax.swing.GroupLayout(Content);
        Content.setLayout(ContentLayout);
        ContentLayout.setHorizontalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
        );
        ContentLayout.setVerticalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Navigation.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SECURITY Svcs");
        jLabel1.setToolTipText("");

        logoutBtn.setBackground(new java.awt.Color(250, 250, 250));
        logoutBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        logoutBtn.setText("LOGOUT");
        logoutBtn.setFocusable(false);
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        changePassBtn.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        changePassBtn.setText("Change Password");
        changePassBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePassBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NavigationLayout = new javax.swing.GroupLayout(Navigation);
        Navigation.setLayout(NavigationLayout);
        NavigationLayout.setHorizontalGroup(
            NavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavigationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(changePassBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(logoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        NavigationLayout.setVerticalGroup(
            NavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavigationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 341, Short.MAX_VALUE)
                .addComponent(changePassBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout HomePnlLayout = new javax.swing.GroupLayout(HomePnl);
        HomePnl.setLayout(HomePnlLayout);
        HomePnlLayout.setHorizontalGroup(
            HomePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomePnlLayout.createSequentialGroup()
                .addComponent(Navigation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HomePnlLayout.setVerticalGroup(
            HomePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Navigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ContainerLayout = new javax.swing.GroupLayout(Container);
        Container.setLayout(ContainerLayout);
        ContainerLayout.setHorizontalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
            .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(HomePnl, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE))
        );
        ContainerLayout.setVerticalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(HomePnl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void designer(JTextField component, String text){
        component.setSize(70, 600);
        component.setFont(new java.awt.Font("Tahoma", 0, 18));
        component.setBackground(new java.awt.Color(240, 240, 240));
        component.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        component.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), text, javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12)));
    }
    
    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        loginPnl.clear();
        // log the logout to db
        String formattedDateTime= helper.getCurrentTimestamp();
        //String formattedDateTime = datetimeformatter.format(LocalDateTime.now());
        main.sqlite.addLogs("logout", this.currentUser.getUsername(), "User logged out", formattedDateTime);
        this.currentUser = null;
        frameView.show(Container, "loginPnl");
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void changePassBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePassBtnActionPerformed
        // TODO add your handling code here: 
        JPasswordField oldPassword = new JPasswordField();
        JPasswordField password = new JPasswordField();
        JPasswordField confpass = new JPasswordField();
        designer(oldPassword, "OLD PASSWORD");
        designer(password, "NEW PASSWORD");
        designer(confpass, "CONFIRM PASSWORD");

        Object[] message = {
            "Enter New Password:", oldPassword, password, confpass
        };
        String username = currentUser.getUsername();
        int result = JOptionPane.showConfirmDialog(null, message, "Change Password for " + username , JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);

        if (result == JOptionPane.OK_OPTION) {
            //String username = tableModel.getValueAt(table.getSelectedRow(), 0).toString();
//                System.out.println(username);
//            User user = sqlite.getUser(username);
            if (currentUser.validate(username, oldPassword.getPassword())) {
                String newpassStr = new String(password.getPassword());
                String confpassStr = new String(confpass.getPassword());
                if (newpassStr.equals(confpassStr) && Secure.isValidPassword(newpassStr)) {
                    currentUser.setSalt(User.generateSalt());
                    currentUser.setPasswordHash(User.hashPassword(newpassStr, currentUser.getSalt()));
                    boolean status = main.sqlite.updateUser(username, currentUser);
                    if (status) {
                        dialogBox.showSuccessDialog("Change password success", "User password changed successfully.");
                    }
                }
                else {
                    String passCriteria = Secure.getPassCriteria();
                    dialogBox.showErrorDialog("Error changing password", "Both passwords do not match or password does not follow the required criteria. " + passCriteria);

                }
            }
            else {
                dialogBox.showErrorDialog("Error changing password", "Current password is incorrect.");
            }
        }
    }//GEN-LAST:event_changePassBtnActionPerformed

    public Main main;
    public Secure secure = new Secure();
    public Helper helper = new Helper();
    public Login loginPnl = new Login();
    public Register registerPnl = new Register();
    public Dialog dialogBox = new Dialog();
    
    private AdminHome adminHomePnl = new AdminHome();
    private ManagerHome managerHomePnl = new ManagerHome();
    private StaffHome staffHomePnl = new StaffHome();
    private ClientHome clientHomePnl = new ClientHome();
    
    private CardLayout contentView = new CardLayout();
    private CardLayout frameView = new CardLayout();
    private User currentUser = null;
    
    DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern(Logs.datetimeformatstring);
    
    public void init(Main controller){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("CSSECDV - SECURITY Svcs");
        this.setLocationRelativeTo(null);
        
        this.main = controller;
        loginPnl.frame = this;
        registerPnl.frame = this;
        loginPnl.init(main.sqlite);
        adminHomePnl.init(main.sqlite);
        clientHomePnl.init(main.sqlite);
        managerHomePnl.init(main.sqlite);
        staffHomePnl.init(main.sqlite);
        
        Container.setLayout(frameView);
        Container.add(loginPnl, "loginPnl");
        Container.add(registerPnl, "registerPnl");
        Container.add(HomePnl, "homePnl");
        frameView.show(Container, "loginPnl");
        
        Content.setLayout(contentView);
        Content.add(adminHomePnl, "adminHomePnl");
        Content.add(managerHomePnl, "managerHomePnl");
        Content.add(staffHomePnl, "staffHomePnl");
        Content.add(clientHomePnl, "clientHomePnl");
        
        this.setVisible(true);
    }
    
    public void mainNav(){
        
        // authenticate user
        String username = loginPnl.getLoginUsername().trim();
        String lowercase_username = username.toLowerCase();
        char[] password = loginPnl.getLoginPassword();
        
        try {
            User user = main.sqlite.getUser(lowercase_username); 
            secure.checkUserStatus(user);
            
            if (user.validate(lowercase_username, password) && user.getLocked() != 1) {
                
                // Set last user log in
                String currTimestamp = helper.getCurrentTimestamp();
                secure.unlockUser(user);
                user.setLastLogin(currTimestamp);
                this.currentUser = user;
                main.sqlite.updateUser(user);
                
                //Check if user is disabled and role
                int disabled = user.getDisabled();
                int role = user.getRole();
                
                if (disabled != 1) {
                    switch (role) {
                        case 2:
                            clientHomePnl.showPnl("home");
                            clientHomePnl.setCurrentUser(this.currentUser);
                            clientHomePnl.setButtonsBlack(); //reset button colors
                            contentView.show(Content, "clientHomePnl");
                            break;
                        case 3:
                            staffHomePnl.showPnl("home");
                            staffHomePnl.setCurrentUser(this.currentUser);
                            staffHomePnl.setButtonsBlack();
                            contentView.show(Content, "staffHomePnl");
                            break;
                        case 4:
                            managerHomePnl.showPnl("home");
                            managerHomePnl.setCurrentUser(this.currentUser);
                            System.out.println("Current user: " + this.currentUser.getUsername() + ", role: " + this.currentUser.getRole());
                            managerHomePnl.setButtonsBlack();
                            contentView.show(Content, "managerHomePnl");
                            break;
                        case 5:
                            adminHomePnl.showPnl("home");
                            adminHomePnl.setCurrentUser(this.currentUser);
                            System.out.println("Current user: " + this.currentUser.getUsername() + ", role: " + this.currentUser.getRole());
                            adminHomePnl.setButtonsBlack();
                            contentView.show(Content, "adminHomePnl");
                            break;
                    }
                    frameView.show(Container, "homePnl");
                    String formattedDateTime = helper.getCurrentTimestamp();
                    main.sqlite.addLogs("loginSuccess", lowercase_username, "User logged in successfully.", formattedDateTime);
                } else {
                    dialogBox.showErrorDialog("Account Disabled", "Account is currently disabled. Please communicate with the Admin in-person in order to re-enable the account.");
                }
                
            }
            else if (!user.validate(lowercase_username, password)) {
                // If user is not yet locked
                if(user.getLocked() == 0) {
                    secure.recordFailAttempt(user);
//                    String formattedDateTime = datetimeformatter.format(LocalDateTime.now());
                    String formattedDateTime = helper.getCurrentTimestamp();                    
                    main.sqlite.addLogs("authenticationError", lowercase_username, "Incorrect username or password entered during login.", formattedDateTime);
                   if (user.getLocked() == 1) {
                       formattedDateTime = datetimeformatter.format(LocalDateTime.now());
                       main.sqlite.addLogs("loginFail", user.getUsername(), "User has been locked out.", formattedDateTime);
                      
                   }
                    dialogBox.showErrorDialog("Authentication failed", "Username or password is incorrect.");  
                }
               
            }
            main.sqlite.updateUser(user);
        }
        catch (NullPointerException e) {
            dialogBox.showErrorDialog("Authentication failed", "Username or password is incorrect."); 
        }
        
    }
    
    public void loginNav(){
        loginPnl.clear();
        frameView.show(Container, "loginPnl");
    }
    
    public void registerNav(){
        registerPnl.clear();
        frameView.show(Container, "registerPnl");
    }
    
    public boolean registerAction(String username, String password, String confpass){
        
        //Convert username to lowercase
        String lowercase_username = username.toLowerCase().trim();
        User user = main.sqlite.getUser(lowercase_username);
        
        // By default false so that user will not return to login page if error occurs
        boolean result = false; 
        
        // Check if ny of the fields are empty
        boolean isEmptyField = Secure.regIsEmpty(lowercase_username, password, confpass);
        if(!isEmptyField){
            
            // Check based on username policy and password policy
            boolean isValidPassword = Secure.isValidPassword(password);
            boolean isValidUsername = Secure.validUsername(lowercase_username);
            
            if (!isValidUsername) {
                DialogBox.showErrorDialog("Registration Error", "Username should be 5-30 characters long and contain only alphanumeric characters, periods, or underscores.");
            }
            // If there are no empty fields and username and password are valid
            if (!isEmptyField && isValidUsername && isValidPassword) {
                
                // If user already exists
                if (user != null) {
                    dialogBox.showErrorDialog("Registration Error", "Username already taken, please enter a different username.");
                } else {
                    if (password.equals(confpass)) {
                        user = new User(lowercase_username, password);
                        main.sqlite.addUser(user.getUsername(), user.getPasswordHash(), user.getSalt(), 2, 0);
                        dialogBox.showSuccessDialog("Registration Success", "User account registered successfully.");
                        
                        // log the successful registration to db
                        String formattedDateTime = helper.getCurrentTimestamp();                        
                        main.sqlite.addLogs("registrationSuccess", lowercase_username, "User registered successfully.", formattedDateTime);
                        result = true;
                    }
                    else {
                        //System.out.println("password and confpss dont match");
                        dialogBox.showErrorDialog("Registration Error", "Make sure both passwords match.");
                    }
                }
            } else if (!isValidPassword) {
                String passCriteria = Secure.getPassCriteria();
                dialogBox.showErrorDialog("Registration Error", "Invalid password. " + passCriteria);
            }
        }
        return result;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Container;
    private javax.swing.JPanel Content;
    private javax.swing.JPanel HomePnl;
    private javax.swing.JPanel Navigation;
    private javax.swing.JButton changePassBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logoutBtn;
    // End of variables declaration//GEN-END:variables
}
