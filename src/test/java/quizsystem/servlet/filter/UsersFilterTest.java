package quizsystem.servlet.filter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import quizsystem.entity.Role;
import quizsystem.entity.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UsersFilterTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private FilterChain filterChain;

    @Mock
    private HttpSession session;

    @Test
    public void testAccessWithStudentRole() throws IOException, ServletException {
        User user = User.builder().withRole(Role.STUDENT).build();

        when(session.getAttribute(eq("currentUser"))).thenReturn(user);
        when(request.getParameter(eq("command"))).thenReturn("users");
        when(request.getSession()).thenReturn(session);

        UsersFilter usersFilter = new UsersFilter();

        usersFilter.doFilter(request, response, filterChain);
        verify(response).sendError(HttpServletResponse.SC_FORBIDDEN);
    }

    @Test
    public void testAccessUnauthorized() throws IOException, ServletException {
        when(session.getAttribute(eq("currentUser"))).thenReturn(null);
        when(request.getParameter(eq("command"))).thenReturn(null);
        when(request.getSession()).thenReturn(session);

        UsersFilter usersFilter = new UsersFilter();

        usersFilter.doFilter(request, response, filterChain);
        verify(filterChain).doFilter(request, response);
    }
}