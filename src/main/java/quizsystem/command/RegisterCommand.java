package quizsystem.command;

import quizsystem.entity.User;
import quizsystem.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class RegisterCommand implements Command{
    private final UserService userService;

    public RegisterCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        String confPass = request.getParameter("confpass");

        Optional<User> user = userService.register(email, password, confPass);
        if(user.isPresent()) {
            final HttpSession session = request.getSession();
            session.setAttribute("currentUser", user.get());
            return "home.jsp";
        } else {
            request.setAttribute("has_error", true);
            return "register.jsp";
        }
    }
}
