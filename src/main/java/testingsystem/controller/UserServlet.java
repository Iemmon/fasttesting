package testingsystem.controller;

import testingsystem.entity.User;
import testingsystem.injector.ApplicationInjector;
import testingsystem.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {

    private final UserService userService;

    public UserServlet() {
        ApplicationInjector injector = ApplicationInjector.getInstance();
        this.userService = injector.getUserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> users = userService.findAll();
        req.setAttribute("users", users);

        req.getRequestDispatcher("users.jsp").forward(req, resp);
    }
}
