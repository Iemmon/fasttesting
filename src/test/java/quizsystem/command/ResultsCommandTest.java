package quizsystem.command;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import quizsystem.dao.pagination.Page;
import quizsystem.entity.Result;
import quizsystem.entity.User;
import quizsystem.service.ResultService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import static java.util.ResourceBundle.getBundle;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ResultsCommandTest {

    @Spy
    private ResourceBundle resourceBundle = getBundle("properties");

    @Mock
    private ResultService resultService;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpSession session;

    @InjectMocks
    private ResultsCommand resultsCommand;



//    User user = (User) request.getSession().getAttribute("currentUser");
//        int itemsPerPage = Integer.parseInt(resourceBundle.getString("itemsPerPage"));
//        String page = request.getParameter("page");
//        Page <Result> results = resultService.getAllResults(user.getUserId(), page, itemsPerPage);
//        request.setAttribute("results", results.getItems());
//        request.setAttribute("maxPages", results.getMaxPageNumber());
//        return "results.jsp";

    @Test
    public void executeShouldRedirectToResultsPage() {
        User user = User.builder().withId(1L).build();

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute(anyString())).thenReturn(user);
        String page = "1";
        when(request.getParameter(eq("page"))).thenReturn(page);

        List<Result> resultList = Collections.singletonList(new Result(100, new quizsystem.entity.Test(9L, "sdf"), 10L));
        Page<Result> resultPage = new Page<>(resultList, 1, 5, 2);

        when(resultService.getAllResults(eq(1L), eq(page), eq(5))).thenReturn(resultPage);

        String resultsPage = resultsCommand.execute(request);
        assertEquals("results.jsp", resultsPage);

        verify(request).setAttribute(eq("results"), eq(resultList));
    }
}