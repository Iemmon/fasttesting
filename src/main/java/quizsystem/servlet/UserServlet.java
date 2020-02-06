package quizsystem.servlet;

import quizsystem.dao.pagination.Page;
import quizsystem.entity.User;
import quizsystem.injector.ApplicationInjector;
import quizsystem.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

public class UserServlet extends HttpServlet {

    private final UserService userService;
    private final ResourceBundle resourceBundle;

    public UserServlet() {
        ApplicationInjector injector = ApplicationInjector.getInstance();
        this.userService = injector.getUserService();
        this.resourceBundle = injector.getResourceBundle();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        int page = Integer.parseInt(resourceBundle.getString("defaultPageNumber"));
        int itemsPerPage = Integer.parseInt(resourceBundle.getString("itemsPerPage"));
//
//        if(req.getParameter("page") != null && req.getParameter("page").matches("(\\-)?[0-9]+")){
//            page = Integer.parseInt(req.getParameter("page"));
//        }

        Page<User> users = userService.findAll(resourceBundle.getString("defaultPageNumber"), itemsPerPage);
        req.setAttribute("users", users.getItems());
        req.setAttribute("page", users.getPageNumber());
        req.setAttribute("maxPages", users.getMaxPageNumber());

        req.getRequestDispatcher("users.jsp").forward(req, resp);
    }
}
