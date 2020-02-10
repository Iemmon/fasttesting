package quizsystem.command;

import quizsystem.entity.Result;
import quizsystem.entity.User;
import quizsystem.service.ResultService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UserResultsCommand implements Command {

    private final ResultService resultService;


    public UserResultsCommand(ResultService resultService) {
        this.resultService = resultService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("currentUser");
        List<Result> results = resultService.getAllResults(user.getUserId());
        request.setAttribute("results", results);
        return "results.jsp";
    }
}
