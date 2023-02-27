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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


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

        javax.swing.GroupLayout NavigationLayout = new javax.swing.GroupLayout(Navigation);
        Navigation.setLayout(NavigationLayout);
        NavigationLayout.setHorizontalGroup(
            NavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavigationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(logoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        NavigationLayout.setVerticalGroup(
            NavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavigationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 392, Short.MAX_VALUE)
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

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        loginPnl.clear();
        // log the logout to db
        String formattedDateTime = datetimeformatter.format(LocalDateTime.now());
        main.sqlite.addLogs("logout", this.currentUser.getUsername(), "User logged out", formattedDateTime);
        this.currentUser = null;
        frameView.show(Container, "loginPnl");
    }//GEN-LAST:event_logoutBtnActionPerformed

    public Main main;
    public Secure secure = new Secure();
    public Helper helper = new Helper();
    public Login loginPnl = new Login();
    public Register registerPnl = new Register();
    public Dialog DialogBox = new Dialog();
    
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
                String currTimestamp = helper.getCurrentTimestamp();
                secure.unlockUser(user);
                user.setLastLogin(currTimestamp);
                this.currentUser = user;
                main.sqlite.updateUser(user); 
                int role = user.getRole();
                // log the successful login to db
                String formattedDateTime = datetimeformatter.format(LocalDateTime.now());
                main.sqlite.addLogs("loginSuccess", lowercase_username, "User logged in successfully.", formattedDateTime);
                switch (role) {
                    case 2:
                        clientHomePnl.showPnl("home");
                        contentView.show(Content, "clientHomePnl");
                        break;
                    case 3:
                        staffHomePnl.showPnl("home");
                        contentView.show(Content, "staffHomePnl");
                        break;
                    case 4:
                        managerHomePnl.showPnl("home");
                        contentView.show(Content, "managerHomePnl");
                        break;
                    case 5:
                        adminHomePnl.showPnl("home");
                        contentView.show(Content, "adminHomePnl");
                        break;
                    default:
                        DialogBox.showErrorDialog("Account disabled", "Account disabled due to multiple failed login attempts, wait 5 minutes before logging in again.");
                        break;
                }
                frameView.show(Container, "homePnl");
            }
            else if (!user.validate(lowercase_username, password)) {
                
                // If user is not yet locked
                if(user.getLocked() == 0) {
                  secure.recordFailAttempt(user);
                  DialogBox.showErrorDialog("Authentication failed", "Username or password is incorrect.");  
                }
              
                String formattedDateTime = datetimeformatter.format(LocalDateTime.now());
                main.sqlite.addLogs("authenticationError", lowercase_username, "Incorrect username or password entered during login.", formattedDateTime);
            }
            
            main.sqlite.updateUser(user);
        }
        catch (NullPointerException e) {
            DialogBox.showErrorDialog("Authentication failed", "Username or password is incorrect."); 
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
        boolean isEmptyField = secure.regIsEmpty(lowercase_username, password, confpass);
        if(!isEmptyField){
            
            // Check based on username policy and password policy
            boolean isValidPassword = secure.isValidPassword(password);
            boolean isValidUsername = secure.validUsername(lowercase_username);

            // If there are no empty fields and username and password are valid
            if (!isEmptyField && isValidUsername && isValidPassword) {
                
                // If user already exists
                if (user != null) {
                    DialogBox.showErrorDialog("Registration error", "Username already taken, please enter a different username.");
                } else {
                    if (password.equals(confpass)) {
                        
                        user = new User(lowercase_username, password);
                        main.sqlite.addUser(user.getUsername(), user.getPasswordHash(), user.getSalt(), 2, 0);
                        DialogBox.showSuccessDialog("Registration success", "User account registered successfully.");
                        // log the successful registration to db
                        String formattedDateTime = datetimeformatter.format(LocalDateTime.now());
                        main.sqlite.addLogs("registrationSuccess", lowercase_username, "User registered successfully.", formattedDateTime);
                        result = true;
                    }
                    else {
                        //System.out.println("password and confpss dont match");
                        DialogBox.showErrorDialog("Registration error", "Make sure both passwords match.");
                    }
                }
            }
        }
        return result;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Container;
    private javax.swing.JPanel Content;
    private javax.swing.JPanel HomePnl;
    private javax.swing.JPanel Navigation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logoutBtn;
    // End of variables declaration//GEN-END:variables
}
