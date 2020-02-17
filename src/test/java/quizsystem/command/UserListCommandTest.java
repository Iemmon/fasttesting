package quizsystem.command;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import quizsystem.dao.pagination.Page;
import quizsystem.entity.User;
import quizsystem.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static java.util.ResourceBundle.getBundle;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserListCommandTest {

    @Spy
    private ResourceBundle resourceBundle = getBundle("properties");

    @Mock
    private UserService userService;

    @Mock
    private HttpServletRequest request;

    @InjectMocks
    private UserListCommand userListCommand;

    @Test
    public void execute() {
        int itemsPerPage = 5;
        when(request.getParameter(eq("page"))).thenReturn("1");

        Page<User> userPage = new Page<>(new ArrayList<>(), 1, itemsPerPage, 5);
        when(userService.findAll(eq("1"), eq(itemsPerPage))).thenReturn(userPage);

        String usersPage = userListCommand.execute(request);
        assertEquals("users.jsp", usersPage);

        verify(request).setAttribute(eq("users"), eq(userPage.getItems()));
        verify(request).setAttribute(eq("maxPages"), eq(userPage.getMaxPageNumber()));

    }
}