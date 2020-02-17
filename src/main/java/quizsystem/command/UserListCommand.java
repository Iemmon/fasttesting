package quizsystem.command;

import quizsystem.dao.pagination.Page;
import quizsystem.entity.User;
import quizsystem.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ResourceBundle;

public class UserListCommand implements Command {

    private final ResourceBundle resourceBundle;
    private final UserService userService;

    public UserListCommand(ResourceBundle resourceBundle, UserService userService) {
        this.resourceBundle = resourceBundle;
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        int itemsPerPage = Integer.parseInt(resourceBundle.getString("itemsPerPage"));
        Page<User> users = userService.findAll(request.getParameter("page"), itemsPerPage);
        request.setAttribute("users", users.getItems());
        request.setAttribute("maxPages", users.getMaxPageNumber());

        return "users.jsp";
    }
}
