package quizsystem.command;

import quizsystem.entity.User;
import quizsystem.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RegisterCommand implements Command{
    private final UserService userService;

    public RegisterCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        final String email = (String) request.getAttribute("email");
        final String password = (String) request.getAttribute("password");

        final User user = userService.register(email, password).get();
        final HttpSession session = request.getSession();
        session.setAttribute("currentUser", user);
        return "home.jsp";
    }



}
