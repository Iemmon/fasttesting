package quizsystem.servlet.filter;

import quizsystem.entity.Role;
import quizsystem.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UsersFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String command = request.getParameter("command");
        User user = (User)session.getAttribute("currentUser");
        if(command.contentEquals("users") && user.getRole().equals(Role.ADMIN)){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        } else {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}
