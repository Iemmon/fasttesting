package quizsystem.servlet.filter;

import quizsystem.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();

        String command = request.getParameter("command");
        User currentUser = (User) session.getAttribute("currentUser");

        if (
                currentUser != null ||
                        (command != null && (command.contentEquals("login") || command.contentEquals("signup") || command.contentEquals("processlogin") || command.contentEquals("register")))
        ) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            ((HttpServletResponse) servletResponse).sendRedirect(request.getContextPath() + "/?command=login");
        }
    }
}
