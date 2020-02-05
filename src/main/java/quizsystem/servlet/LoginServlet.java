package quizsystem.servlet;

import quizsystem.entity.User;
import quizsystem.injector.ApplicationInjector;
import quizsystem.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class LoginServlet extends HttpServlet {
    private final UserService userService;

    public LoginServlet() {
        ApplicationInjector injector = ApplicationInjector.getInstance();
        this.userService = injector.getUserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String hasError = req.getParameter("has_error");
        req.setAttribute("error", hasError != null);
        req.getRequestDispatcher("login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");

        Optional<User> user = userService.login(email, pass);
        if(user.isPresent()){
            req.getSession().setAttribute("currentUser", user.get());
            resp.sendRedirect(req.getContextPath() + "/topics");
        } else {
            resp.sendRedirect(req.getContextPath() + "/login?has_error");
        }

    }
}
