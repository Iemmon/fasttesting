package quizsystem.command;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.reset;

@RunWith(MockitoJUnitRunner.class)
public class HomeLoginRegisterCommandTest {

    @Mock
    private HttpServletRequest request;

    private HomeCommand homeCommand = new HomeCommand();

    private LoginViewCommand loginViewCommand = new LoginViewCommand();

    private RegisterViewCommand registerViewCommand = new RegisterViewCommand();

    @After
    public void resetMocks() {
        reset(request);
    }

    @Test
    public void homeCommandShouldReturnHomeJSP() {
        String home = homeCommand.execute(request);
        assertEquals("home.jsp", home);
    }

    @Test
    public void loginViewCommandShouldReturnLoginJSP(){
        String login = loginViewCommand.execute(request);
        assertEquals("login.jsp", login);
    }

    @Test
    public void registerViewCommandShouldReturnRegisterJSP(){
        String register = registerViewCommand.execute(request);
        assertEquals("register.jsp", register);
    }
}