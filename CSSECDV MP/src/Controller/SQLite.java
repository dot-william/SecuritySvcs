package Controller;

import Model.History;
import Model.Logs;
import Model.Product;
import Model.User;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement; 
import java.util.Date;
//import java.time.LocalDateTime;


public class SQLite {
    
    public int DEBUG_MODE = 0;
    String driverURL = "jdbc:sqlite:" + "database.db";
    
    public void createNewDatabase() {
        try (Connection conn = DriverManager.getConnection(driverURL)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("Database database.db created.");
            }
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void createHistoryTable() {
        String sql = "CREATE TABLE IF NOT EXISTS history (\n"
            + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + " username TEXT NOT NULL,\n"
            + " name TEXT NOT NULL,\n"
            + " stock INTEGER DEFAULT 0,\n"
            + " timestamp TEXT NOT NULL\n"
            + ");";
           
//        PreparedStatement pstmt = conn.prepareStatement(sql)
        try (Connection conn = DriverManager.getConnection(driverURL);
            PreparedStatement pstmt = conn.prepareStatement(sql)) 
        {
            pstmt.execute();
            System.out.println("Table history in database.db created.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void createLogsTable() {
        String sql = "CREATE TABLE IF NOT EXISTS logs (\n"
            + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + " event TEXT NOT NULL,\n"
            + " username TEXT NOT NULL,\n"
            + " desc TEXT NOT NULL,\n"
            + " timestamp TEXT NOT NULL\n"
            + ");";

        try (Connection conn = DriverManager.getConnection(driverURL);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.execute();
            System.out.println("Table logs in database.db created.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
     
    public void createProductTable() {
        String sql = "CREATE TABLE IF NOT EXISTS product (\n"
            + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + " name TEXT NOT NULL UNIQUE,\n"
            + " stock INTEGER DEFAULT 0,\n"
            + " price REAL DEFAULT 0.00\n"
            + ");";

        try (Connection conn = DriverManager.getConnection(driverURL);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.execute();
            System.out.println("Table product in database.db created.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
     
    public void createUserTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
            + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + " username TEXT NOT NULL UNIQUE,\n"
            + " passwordhash TEXT NOT NULL,\n"
            + " salt TEXT NOT NULL, \n"
            + " role INTEGER DEFAULT 2,\n"
            + " locked INTEGER DEFAULT 0,\n"
            + " failedAttempts INTEGER DEFAULT 0,\n"
            + " lastFailed TEXT DEFAULT NULL,\n"
            + " lastLogin TEXT DEFAULT NULL\n"
            + ");";

        try (Connection conn = DriverManager.getConnection(driverURL);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.execute();
            System.out.println("Table users in database.db created.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void dropHistoryTable() {
        String sql = "DROP TABLE IF EXISTS history;";

        try (Connection conn = DriverManager.getConnection(driverURL);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.execute();
            System.out.println("Table history in database.db dropped.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void dropLogsTable() {
        String sql = "DROP TABLE IF EXISTS logs;";

        try (Connection conn = DriverManager.getConnection(driverURL);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.execute();
            System.out.println("Table logs in database.db dropped.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void dropProductTable() {
        String sql = "DROP TABLE IF EXISTS product;";

        try (Connection conn = DriverManager.getConnection(driverURL);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.execute();
            System.out.println("Table product in database.db dropped.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void dropUserTable() {
        String sql = "DROP TABLE IF EXISTS users;";

        try (Connection conn = DriverManager.getConnection(driverURL);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.execute();
            System.out.println("Table users in database.db dropped.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void addHistory(String username, String name, int stock, String timestamp) {
//        String sql = "INSERT INTO history(username,name,stock,timestamp) VALUES('" + username + "','" + name + "','" + stock + "','" + timestamp + "')";
        String sql = "INSERT INTO history(username,name,stock,timestamp) VALUES(?, ?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, username);
            pstmt.setString(2, name);
            pstmt.setInt(3, stock);
            pstmt.setString(4, timestamp);
            pstmt.execute();
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void addLogs(String event, String username, String desc, String timestamp) {
//        String sql = "INSERT INTO logs(event,username,desc,timestamp) VALUES('" + event + "','" + username + "','" + desc + "','" + timestamp + "')";
        String sql = "INSERT INTO logs(event,username,desc,timestamp) VALUES(?, ?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, event);
            pstmt.setString(2, username); 
            pstmt.setString(3, desc); 
            pstmt.setString(4, timestamp); 
            pstmt.execute();
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void addProduct(String name, int stock, double price) {
//        String sql = "INSERT INTO product(name,stock,price) VALUES('" + name + "','" + stock + "','" + price + "')";
        String sql = "INSERT INTO product(name,stock,price) VALUES(?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, name);
            pstmt.setInt(2, stock);
            pstmt.setDouble(3, price);
            pstmt.execute();
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void addUser(String username, String passwordhash, String salt) {
//        String sql = "INSERT INTO users(username,passwordhash,salt) VALUES('" + username + "','" + passwordhash + "','" + salt + "')";
        String sql = "INSERT INTO users(username,passwordhash,salt) VALUES(?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, username);
            pstmt.setString(2, passwordhash); 
            pstmt.setString(3, salt);
            pstmt.execute();
            
//      PREPARED STATEMENT EXAMPLE
//      String sql = "INSERT INTO users(username,password) VALUES(?,?)";
//      PreparedStatement pstmt = conn.prepareStatement(sql)) {
//      pstmt.setString(1, username);
//      pstmt.setString(2, password);
//      pstmt.executeUpdate();
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    
    public ArrayList<History> getHistory(){
        String sql = "SELECT id, username, name, stock, timestamp FROM history";
        ArrayList<History> histories = new ArrayList<History>();
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()){
            
            while (rs.next()) {
                histories.add(new History(rs.getInt("id"),
                                   rs.getString("username"),
                                   rs.getString("name"),
                                   rs.getInt("stock"),
                                   rs.getString("timestamp")));
            }
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return histories;
    }
        
    public ArrayList<History> getSelfHistory(User currentUser){
        String sql = "SELECT id, username, name, stock, timestamp FROM history WHERE username = ?";
        ArrayList<History> histories = new ArrayList<>();
        String username = currentUser.getUsername();
        System.out.println(username);
        try (Connection conn = DriverManager.getConnection(driverURL);
            PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery(); 
            while (rs.next()) {
                histories.add(new History(rs.getInt("id"),
                                   rs.getString("username"),
                                   rs.getString("name"),
                                   rs.getInt("stock"),
                                   rs.getString("timestamp")));
            }
        } 
        catch (Exception ex) {
            System.out.print(ex);
        }
        return histories;
    }
    
    public boolean clearLogs() {
        String sql = "DELETE FROM logs;"; 
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ){
            int i = pstmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.print(ex);
            return false;
        }
    }
    
    public ArrayList<Logs> getLogs(){
        String sql = "SELECT id, event, username, desc, timestamp FROM logs";
        ArrayList<Logs> logs = new ArrayList<Logs>();
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()){
            
            while (rs.next()) {
                logs.add(new Logs(rs.getInt("id"),
                                   rs.getString("event"),
                                   rs.getString("username"),
                                   rs.getString("desc"),
                                   rs.getString("timestamp")));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return logs;
    }
    
    public ArrayList<Product> getProduct(){
        String sql = "SELECT id, name, stock, price FROM product";
        ArrayList<Product> products = new ArrayList<Product>();
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()){
            
            while (rs.next()) {
                products.add(new Product(rs.getInt("id"),
                                   rs.getString("name"),
                                   rs.getInt("stock"),
                                   rs.getFloat("price")));
            }
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return products;
    }
    
    public ArrayList<User> getUsers(){
        String sql = "SELECT id, username, passwordhash, salt, role, locked, failedAttempts, lastFailed, lastLogin FROM users";
        ArrayList<User> users = new ArrayList<>();
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()){
            
            while (rs.next()) {
                users.add(new User(rs.getInt("id"),
                                   rs.getString("username"),
                                   rs.getString("passwordhash"),
                                   rs.getString("salt"),
                                   rs.getInt("role"),
                                   rs.getInt("locked"),
                                   rs.getInt("failedAttempts"),
                                   rs.getString("lastFailed"),
                                   rs.getString("lastLogin")));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return users;
    }
    
    public User getUser(String username) {
        String sql = "SELECT id, username, passwordhash, salt, role, locked, failedAttempts, lastFailed, lastLogin FROM users WHERE username = ?";
        User user = null;
        
        try(Connection conn = DriverManager.getConnection(driverURL);
            PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery(); 
            if (rs.next())
                user = new User(rs.getInt("id"),
                                rs.getString("username"),
                                rs.getString("passwordhash"),
                                rs.getString("salt"),
                                rs.getInt("role"),
                                rs.getInt("locked"),
                                rs.getInt("failedAttempts"),
                                rs.getString("lastFailed"),
                                rs.getString("lastLogin"));
            return user;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }
    
    public boolean updateUser(String oldUsername, User updatedUser) {
        String sql = "UPDATE Users SET username = ?, passwordhash = ?, salt = ?, role = ?, locked = ? WHERE username = ?";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, updatedUser.getUsername());
            pstmt.setString(2, updatedUser.getPasswordHash());
            pstmt.setString(3, updatedUser.getSalt());
            pstmt.setInt(4, updatedUser.getRole());
            pstmt.setInt(5, updatedUser.getLocked()); 
            pstmt.setString(6, oldUsername);
            pstmt.execute();
            
        } catch (Exception ex) {
            System.out.print(ex);
            return false;
        }
        return true;
    }
    
    // Updates all fields from user
    public void updateUser(User updatedUser) {
         String sql = "UPDATE users SET username = ?, passwordhash = ?, salt = ?, role = ?, locked = ?, failedAttempts = ?, lastFailed = ?, lastLogin = ? WHERE username = ?";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, updatedUser.getUsername());
            pstmt.setString(2, updatedUser.getPasswordHash());
            pstmt.setString(3, updatedUser.getSalt());
            pstmt.setInt(4, updatedUser.getRole());
            pstmt.setInt(5, updatedUser.getLocked()); 
            pstmt.setInt(6, updatedUser.getFailedAttempts());
            pstmt.setString(7, updatedUser.getLastFailed());
            pstmt.setString(8, updatedUser.getLastLogin());
            pstmt.setString(9, updatedUser.getUsername());
            pstmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void addUser(String username, String passwordhash, String salt, int role, int failedAttempts) {
//        String salt = User.generateSalt();
//        String passwordhash = User.hashPassword(password, salt);
//        String sql = "INSERT INTO users(username,passwordhash,salt,role) VALUES('" + username + "','" + passwordhash + "','" + salt + "','" + role + "')";
        String sql = "INSERT INTO users(username,passwordhash,salt,role, failedAttempts) VALUES(?,?,?,?,?)";
//        System.out.println("Date being passed: " + date);
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, username);
            pstmt.setString(2, passwordhash);
            pstmt.setString(3, salt);
            pstmt.setInt(4, role);
            pstmt.setInt(5, failedAttempts);
//            pstmt.setObject(6, date);
            pstmt.execute();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void removeUser(String username) {
//        String sql = "DELETE FROM users WHERE username='" + username + "';";
        String sql = "DELETE FROM users WHERE username= ? ;";

        try (Connection conn = DriverManager.getConnection(driverURL);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.execute();
            System.out.println("User " + username + " has been deleted.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public Product getProduct(String name){
//        String sql = "SELECT name, stock, price FROM product WHERE name='" + name + "';";
        String sql = "SELECT name, stock, price FROM product WHERE name= ? ;";
        Product product = null;
        try (Connection conn = DriverManager.getConnection(driverURL);
            PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            product = new Product(rs.getString("name"),
                                   rs.getInt("stock"),
                                   rs.getFloat("price"));
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return product;
    }
    
    
    public void updateUserFailedAttempts (String username, int failedAttempts, String lastFailed) {
        String sql = "UPDATE users SET failedAttempts = ?, lastFailed =? WHERE username = ?;";
        try (Connection conn = DriverManager.getConnection(driverURL);
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, failedAttempts);
            pstmt.setString(2, lastFailed);
            pstmt.setString(3, username);
            pstmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean updatePuchasedProduct(Product product){
        String sql = "UPDATE product SET stock = ? WHERE name = ?;";
        boolean successful = false;
        try (Connection conn = DriverManager.getConnection(driverURL);
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, product.getStock());
            pstmt.setString(2, product.getName());
            pstmt.execute();
            successful = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return successful;
    }
}