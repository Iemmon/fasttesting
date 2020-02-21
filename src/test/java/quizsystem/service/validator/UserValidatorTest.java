package quizsystem.service.validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import quizsystem.entity.User;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class UserValidatorTest {

    private UserValidator validator = new UserValidator();

    @Parameterized.Parameter
    public String emailForTrue;
    @Parameterized.Parameter(1)
    public String passwordForTrue;
    @Parameterized.Parameter(2)
    public String emailForFalse;
    @Parameterized.Parameter(3)
    public String passwordForFalse;


    @Parameterized.Parameters
    public static String[][] data() {
        return new String[][]{
                {"first1user@gmail.com", "Pssw0rd1", "@email", "pass%"},
                {"wjastwn@qq998.xyz", "G2j3nnvjfn","@@@@@@@@@gmail.com", "AAAAA11___)"},
                {"abunnuredda-9120@yopmail.com", "pas5WooRD","lkfglsdlhshl@@@@@.com","uu&uuuuuu"},
                {"xegep49147@topmail1.net", "T62oookK","TRUEEMAIL.COM@gmail",""},
        };
    }

    @Test
    public void validateUserCheckIfReturnsTrue(){
        User user = User.builder().withEmail("dfgdfgdfg@yahoo.com").withPassword("WEkvsirSDF56").build();
        assertTrue(validator.validate(user));
    }

    @Test
    public void validateEmailCheckIfReturnsTrue() {
        assertTrue(validator.validateEmail(emailForTrue));
    }

    @Test
    public void validatePasswordCheckIfReturnsTrue() {
        assertTrue(validator.validatePassword(passwordForTrue));
    }

    @Test
    public void validatePasswordCheckIfReturnsFalse(){
        assertFalse(validator.validatePassword(passwordForFalse));
    }

    @Test
    public void validateEmailCheckIfReturnsFalse(){
        assertFalse(validator.validateEmail(emailForFalse));
    }
}
