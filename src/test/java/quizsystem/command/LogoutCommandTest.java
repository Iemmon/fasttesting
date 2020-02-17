package quizsystem.command;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LogoutCommandTest {

    LogoutCommand logoutCommand = new LogoutCommand();

    @Mock
    HttpServletRequest request;

    @Mock
    HttpSession session;

    @Test
    public void executeShouldRedirectToLoginPage() {
        when(request.getSession()).thenReturn(session);

        String loginPage = logoutCommand.execute(request);
        assertEquals("login.jsp", loginPage);

        verify(session).invalidate();
    }
}