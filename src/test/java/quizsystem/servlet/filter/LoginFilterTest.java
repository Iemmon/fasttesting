package quizsystem.servlet.filter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginFilterTest {

    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Mock
    HttpSession session;

    @Mock
    FilterChain filterChain;


    @Test
    public void testLogin () throws IOException, ServletException {
        when(request.getParameter(eq("command"))).thenReturn("login");

        LoginFilter loginFilter = new LoginFilter();

        loginFilter.doFilter(request, response, filterChain);
        verify(filterChain).doFilter(request, response);
    }

    @Test
    public void testAuthorized () throws IOException, ServletException {
        String contextPath = "/path/";

        when(session.getAttribute(eq("currentUser"))).thenReturn(null);
        when(request.getParameter(eq("command"))).thenReturn("anyCommand");
        when(request.getSession()).thenReturn(session);
        when(request.getContextPath()).thenReturn(contextPath);

        LoginFilter loginFilter = new LoginFilter();

        loginFilter.doFilter(request, response, filterChain);
        verify(response).sendRedirect(contextPath + "/?command=login");
    }
}