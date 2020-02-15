package quizsystem.command;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import quizsystem.service.UserService;

import javax.servlet.http.HttpServletRequest;

@RunWith(MockitoJUnitRunner.class)
public class RegisterCommandTest {

    @Mock
    public UserService userService;

    @InjectMocks
    public RegisterCommand registerCommand;

    @Mock
    public HttpServletRequest request;

    @Test
    public void executeShouldReturnJSPFileName() {

    }
}