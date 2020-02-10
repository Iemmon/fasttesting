package quizsystem.command;

import javax.servlet.http.HttpServletRequest;

public class RegisterViewCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "register.jsp";
    }
}
