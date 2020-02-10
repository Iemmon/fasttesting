package quizsystem.service.encryptor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PasswordEncryptionTest {

    @Parameterized.Parameter
    public String password;
    @Parameterized.Parameter(1)
    public String expectedPassword;

    @Parameterized.Parameters
    public static String[][] data() {
        return new String[][]{
                {"Password", "5qkoTx+FKzIV4yMzFKfCtA=="},
                {"ASNveVEi5j5", "raRwQ30x5m/Gg+XbFNtRRg=="},
                {"93745hHhjdhJHKfu", "UJVRLKs6j4DJxM8X3dY2aw=="},
                {"sakboi592fSr", "fNaM//UUYsy/OnnYiO++ow=="}
        };
    }

    @Test
    public void encryptOutputShouldMatchExpectedValue() {
        PasswordEncryption encryption = new PasswordEncryption();
        assertEquals(expectedPassword, encryption.encrypt(password));
    }
}