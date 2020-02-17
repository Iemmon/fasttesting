package quizsystem.command;

import quizsystem.entity.Role;
import quizsystem.entity.User;
import quizsystem.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LoginCommand implements Command {
    private final UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        final String email = request.getParameter("email");
        final String password = request.getParameter("pass");
        Optional<User> user = userService.login(email, password);
        if(user.isPresent()) {
            final HttpSession session = request.getSession();
            session.setAttribute("currentUser", user.get());
            return "home.jsp";
        } else {
            request.setAttribute("has_error", true);
            return "login.jsp";
        }
    }
}
