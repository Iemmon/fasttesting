package quizsystem.command;

import javax.servlet.http.HttpServletRequest;

public class LoginViewCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "login.jsp";
    }
}
