package quizsystem.servlet.filter;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import quizsystem.entity.Role;
import quizsystem.entity.User;

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

    LoginFilter loginFilter = new LoginFilter();


    @Test
    public void testLogin () throws IOException, ServletException {

        when(request.getParameter(eq("command"))).thenReturn("login");
        when(request.getSession()).thenReturn(session);

        loginFilter.doFilter(request, response, filterChain);

        verify(filterChain).doFilter(request, response);
    }

    @Test
    public void testUserUnauthorizedShouldRedirectToLogin () throws IOException, ServletException {
        String contextPath = "/path/";

        when(request.getParameter(eq("command"))).thenReturn(null);
        when(session.getAttribute(eq("currentUser"))).thenReturn(null);

        when(request.getSession()).thenReturn(session);
        when(request.getContextPath()).thenReturn(contextPath);

        loginFilter.doFilter(request, response, filterChain);

        verify(response).sendRedirect(contextPath + "/?command=login");
    }

    @Test
    public void testUserAuthorizedShoudExecuteDoFilter () throws IOException, ServletException {
        String contextPath = "/path/";

        User user = User.builder().withEmail("email@gmail.com").withPassword("sdfsdf").withRole(Role.STUDENT).build();


        when(request.getParameter(eq("command"))).thenReturn("anyCommand");
        when(session.getAttribute(eq("currentUser"))).thenReturn(user);

        when(request.getSession()).thenReturn(session);
        when(request.getContextPath()).thenReturn(contextPath);

        loginFilter.doFilter(request, response, filterChain);

        verify(filterChain).doFilter(request, response);
    }

    @Test
    public void testUserUnauthorizedTryToRegister () throws IOException, ServletException {
        String contextPath = "/path/";

        when(request.getParameter(eq("command"))).thenReturn("signup");
        when(session.getAttribute(eq("currentUser"))).thenReturn(null);

        when(request.getSession()).thenReturn(session);
        when(request.getContextPath()).thenReturn(contextPath);

        loginFilter.doFilter(request, response, filterChain);

        verify(filterChain).doFilter(request, response);
    }

    @After
    public void resetTest(){
        reset(request, response, session, filterChain);
    }
}