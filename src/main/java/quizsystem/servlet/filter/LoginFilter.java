package quizsystem.servlet.filter;

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
        if (command != null && (command.contentEquals("login") || command.contentEquals("register") || command.contentEquals("processlogin"))) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        if (session.getAttribute("currentUser") == null) {
            ((HttpServletResponse) servletResponse).sendRedirect(request.getContextPath() + "/?command=login");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
