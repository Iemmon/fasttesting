package quizsystem.command;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)
public class HomeCommandTest {

    @Mock
    private HttpServletRequest request;

    private HomeCommand command = new HomeCommand();

    @Test
    public void executeShouldReturnHomeJSP() {
        String home = command.execute(request);
        assertEquals("home.jsp", home);
    }
}