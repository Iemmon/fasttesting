package testingsystem.controller;

import testingsystem.entity.Role;
import testingsystem.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        if(request.getRequestURI().contains("/login") || request.getRequestURI().contains("/register")){
            filterChain.doFilter(servletRequest, servletResponse);
        }
        User user = (User) session.getAttribute("currentUser");
        if(user == null || !user.getRole().equals(Role.STUDENT)){
            servletRequest.getRequestDispatcher("/login").forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
