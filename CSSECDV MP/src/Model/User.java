package Model;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.DecoderException;
import java.security.SecureRandom;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class User {
    private int id;
    private String username;
    private String passwordhash;
    private String salt;
    private int role = 2;
    private int locked = 0;
    private int failedAttempts = 0;
    
    public User(String username, String password){
        this.username = username;
        this.salt = generateSalt();
        this.passwordhash = hashPassword(password, this.salt);
        
    }
    
    public User(int id, String username, String passwordhash, String salt, int role, int locked){
        this.id = id;
        this.username = username;
        this.passwordhash = passwordhash;
        this.salt = salt;
        this.role = role;
        this.locked = locked;
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
    
    
}
