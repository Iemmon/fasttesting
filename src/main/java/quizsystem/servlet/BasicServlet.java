package quizsystem.servlet;

import quizsystem.command.Command;
import quizsystem.injector.ApplicationInjector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class BasicServlet extends HttpServlet {
    private final Map<String, Command> commandNameToCommand;
    private final Command defaultCommand;

    public BasicServlet() {
        final ApplicationInjector injector = ApplicationInjector.getInstance();
        this.commandNameToCommand = injector.getCommands();
        this.defaultCommand = request -> "problem.jsp";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
        final String page = commandNameToCommand.getOrDefault(command, defaultCommand).execute(request);
        request.getRequestDispatcher(page).forward(request, response);
    }
}
