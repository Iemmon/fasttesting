package quizsystem.command;

import javax.servlet.http.HttpServletRequest;

public class HomeCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "home.jsp";
    }
}
