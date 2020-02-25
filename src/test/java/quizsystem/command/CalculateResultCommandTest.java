package quizsystem.command;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import quizsystem.entity.Question;
import quizsystem.entity.Result;
import quizsystem.entity.User;
import quizsystem.service.MailSender;
import quizsystem.service.QuestionService;
import quizsystem.service.ResultService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CalculateResultCommandTest {

    @Mock
    private QuestionService questionService;

    @Mock
    private ResultService resultService;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpSession session;

    @Mock
    private MailSender mailSender;

    @InjectMocks
    private CalculateResultCommand command;

    @Test
    public void execute() {
        Map<String, String[]> results = new HashMap<>();
        results.put("1", null);
        results.put("2", null);
        results.put("3", null);
        Set<Long> userAnswers = results.keySet().stream().map(Long::parseLong).collect(Collectors.toSet());

        when(request.getParameterMap()).thenReturn(results);
        when(request.getParameter(eq("test_id"))).thenReturn("1");
        when(request.getSession()).thenReturn(session);
        User user = User.builder().withId(1L).build();
        when(session.getAttribute("currentUser")).thenReturn(user);

        List<Question> incorrectQ = new ArrayList<>();
        when(questionService.getIncorrectAnsweredQuestions(1L, userAnswers)).thenReturn(incorrectQ);

        List<Question> basicQuestionList = new ArrayList<>();
        basicQuestionList.add(null);
        when(questionService.findAllByTestId(1L)).thenReturn(basicQuestionList);

        String testResultPage = command.execute(request);
        assertEquals("testresult.jsp", testResultPage);

        Result result = new Result(100, new quizsystem.entity.Test(1L), 1L);

        verify(resultService).saveResult(eq(result));

        verify(request).setAttribute(eq("ans"), eq(userAnswers));
        verify(request).setAttribute(eq("score"), eq(100));
        verify(request).setAttribute(eq("test_results"), eq(incorrectQ));

    }
}