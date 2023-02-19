package Model;
import org.apache.commons.codec.binary.Hex;
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
    private int role = 2;
    private int locked = 0;
    
    public User(String username, String password){
        this.username = username;
        this.passwordhash = setPasswordHash(password);
    }
    
    public User(int id, String username, String passwordhash, int role, int locked){
        this.id = id;
        this.username = username;
        this.passwordhash = passwordhash;
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

    public static String setPasswordHash(String password) {
        System.out.println(password);
        // create secure RNG
        try {
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");     
            // create 16-byte salt
            byte[] salt = new byte[16];
            random.nextBytes(salt);
            String saltStr = Hex.encodeHexString(salt);
            System.out.println("salt = " + saltStr);
            // hash the password and the salt
            try {
                SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
                PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), saltStr, 10000, 256); 
                SecretKey key = factory.generateSecret(spec);
                byte[] hash = key.getEncoded();
                String hashStr = new String(hash);
                System.out.println(hashStr);
                return hashStr;
    //            System.out.println(hash.equals(this.passwordhash.getBytes()));
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                throw new RuntimeException(e);
            }
        } catch (NoSuchAlgorithmException e) {
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
}
