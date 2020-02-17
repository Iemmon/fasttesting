package quizsystem.command;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import quizsystem.entity.User;
import quizsystem.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginCommandTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private LoginCommand loginCommand;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpSession session;

    @Test
    public void executeShouldLoginSuccessfullyAndRedirectToHomePage() {
        String email = request.getParameter("email");
        String password = request.getParameter("pass");

        User user = User.builder().withEmail(email).withPassword(password).build();
        when(userService.login(email, password)).thenReturn(Optional.of(user));
        when(request.getSession()).thenReturn(session);

        String homePage = loginCommand.execute(request);
        assertEquals("home.jsp", homePage);

        verify(session).setAttribute("currentUser", user);
    }

    @Test
    public void executeLoginShouldFailAndRedirectToLogin(){
        String email = request.getParameter("email");
        String password = request.getParameter("pass");

        when(userService.login(email, password)).thenReturn(Optional.empty());

        String loginPage = loginCommand.execute(request);
        assertEquals("login.jsp", loginPage);
        verify(request).setAttribute("has_error", true);
    }
}