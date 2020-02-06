package quizsystem.service.encryptor;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class PasswordEncryption {

    private static final int STRENGTH = 65536;
    private static final int LENGTH = 128;
    private static final String SALT = "asdfg";

    public String encrypt(String password) {
        char[] passCharArray = password.toCharArray();
            return Base64.getEncoder().encodeToString(hash(passCharArray, SALT.getBytes()));
    }

    private byte[] hash(char[] password, byte[] salt) {
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            PBEKeySpec spec = new PBEKeySpec(password, salt, STRENGTH, LENGTH);
            SecretKey key = skf.generateSecret(spec);
            return key.getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }
}
