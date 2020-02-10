package quizsystem.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command{

    @Override
    public String execute(HttpServletRequest request) {
        final HttpSession session = request.getSession();
        session.invalidate();
        return "login.jsp";
    }

}
