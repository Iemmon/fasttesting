package quizsystem.command;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import quizsystem.service.QuestionService;

import javax.servlet.http.HttpServletRequest;

@RunWith(MockitoJUnitRunner.class)
public class LoadQuestionsCommandTest {

    @Mock
    public QuestionService questionService;

    @InjectMocks
    public LoadQuestionsCommand command;

    @Mock
    public HttpServletRequest request;

    @Test
    public void executeTest() {

    }
}