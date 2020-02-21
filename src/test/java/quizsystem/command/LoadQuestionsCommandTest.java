package quizsystem.command;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import quizsystem.entity.Question;
import quizsystem.service.QuestionService;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LoadQuestionsCommandTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private LoadQuestionsCommand command;

    @Mock
    private HttpServletRequest request;

    @Test
    public void executeTest() {
        List<Question> questionList = new ArrayList<>();
        when(request.getParameter(anyString())).thenReturn("1");
        when(questionService.findAllByTestId(1L)).thenReturn(questionList);

        String result = command.execute(request);
        assertEquals("questions.jsp", result);
        verify(request).setAttribute("questions", questionList);
    }
}