package quizsystem.command;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import quizsystem.entity.Result;
import quizsystem.entity.User;
import quizsystem.service.ResultService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserResultsCommandTest {

    @Mock
    private ResultService resultService;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpSession session;

    @InjectMocks
    private UserResultsCommand userResultsCommand;

    @Test
    public void executeShouldRedirectToResultsPage() {
        User user = User.builder().withId(1L).build();

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute(anyString())).thenReturn(user);

        List<Result> resultList = Collections.singletonList(new Result(100, new quizsystem.entity.Test(9L, "sdf"), 10L));
//        when(resultService.getAllResults(eq(1L))).thenReturn(resultList);

        String resultsPage = userResultsCommand.execute(request);
        assertEquals("results.jsp", resultsPage);

        verify(request).setAttribute(eq("results"), eq(resultList));
    }
}