package quizsystem.command;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import quizsystem.service.TestService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static java.util.ResourceBundle.getBundle;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestCommandTest {
    @Spy
    private ResourceBundle resourceBundle = getBundle("properties");

    @Mock
    private TestService testService;

    @InjectMocks
    private TestCommand testCommand;

    @Mock
    private HttpServletRequest request;


    @Test
    public void executeShouldRedirectToPageWithListOfTests() {
        Long topicId = 1L;
        when(request.getParameter("topic_id")).thenReturn("1");

        List<quizsystem.entity.Test> testList = new ArrayList<>();
        when(testService.findAllByTopicId(topicId)).thenReturn(testList);

        String testsPage = testCommand.execute(request);
        assertEquals("tests.jsp", testsPage);

        verify(request).setAttribute("tests", testList);

    }
}