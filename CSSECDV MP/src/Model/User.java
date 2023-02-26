package Model;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.DecoderException;
import java.security.SecureRandom;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
import java.util.Date;

public class User {
    private int id;
    private String username;
    private String passwordhash;
    private String salt;
    private int role = 2;
    private int locked = 0;
    private int failedAttempts = 0;
    private String lastFailed = null;
    private String lastLogin = null;
    
    
    // Use this constructor for registration
    public User(String username, String password){
        this.username = username;
        this.salt = generateSalt();
        this.passwordhash = hashPassword(password, this.salt);
        
    }
    
    // Use this constructor when getting existing user
    public User(int id, String username, String passwordhash, String salt, int role, int locked, int failedAttempts, String lastFailed, String lastLogin){
        this.id = id;
        this.username = username;
        this.passwordhash = passwordhash;
        this.salt = salt;
        this.role = role;
        this.locked = locked;
        this.failedAttempts  = failedAttempts;
        this.lastFailed = lastFailed;
        this.lastLogin = lastLogin;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return this.passwordhash;
    }
    
    public boolean validate(String username, char[] password) {
        boolean match = false;
        String hashPwd = hashPassword(new String(password), this.getSalt());
        if (this.getUsername().equals(username) && 
            this.getPasswordHash().equals(hashPwd)) {
            match = true;
        }
        return match;
    }
    
    public static String generateSalt() {
        try {
            // create secure RNG
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");     
            // create 16-byte salt
            byte[] salt = new byte[16];
            random.nextBytes(salt);
            return Hex.encodeHexString(salt);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    public String getSalt() {
        return this.salt;
    }
    
    public static String hashPassword(String password, String saltStr) {  
        try {
            byte[] salt = Hex.decodeHex(saltStr);
            // hash the password and the salt
            try {
                SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
                PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 10000, 256); 
                SecretKey key = factory.generateSecret(spec);
                byte[] hash = key.getEncoded();
                String hashStr = Hex.encodeHexString(hash);
                System.out.println(hashStr);
                return hashStr;
    //            System.out.println(hash.equals(this.passwordhash.getBytes()));
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                throw new RuntimeException(e);
            }
        }
        catch (DecoderException e) {
            throw new RuntimeException(e);
        }
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }
    
    public int getFailedAttempts() {
        return failedAttempts;
    }
    
    public void setFailedAttempts(int failedAttempts){
        this.failedAttempts = failedAttempts;
    }
    
    public String getLastFailed() {
        return lastFailed;
    }
    
    public void setLastFailed(String lastFailed) {
        System.out.println("[USER.JAVA] Timestamp: " + lastFailed);
        this.lastFailed = lastFailed;
    }
    
    public String getLastLogin(){
        return lastLogin;
    }
    
    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }
    
    public Date convertStringtoDate (String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
    
    public String getCurrentTimstamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String ts = sdf.format(timestamp);
        return ts;
    }
}
