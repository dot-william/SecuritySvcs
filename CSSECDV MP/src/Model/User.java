package Model;
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
        this.setPasswordHash(password);
    }
    
    public User(int id, String username, String password, int role, int locked){
        this.id = id;
        this.username = username;
        this.setPasswordHash(password);
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

    public void setPasswordHash(String password) {
        // create secure RNG
        SecureRandom random = new SecureRandom(); 
        // create 16-byte salt
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        System.out.println(salt);
        // hash the password and the salt
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128); 
            SecretKey key = factory.generateSecret(spec);
            byte[] hash = key.getEncoded();
            this.passwordhash = new String(hash);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
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
