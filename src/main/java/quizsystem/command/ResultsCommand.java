package quizsystem.command;

import quizsystem.dao.pagination.Page;
import quizsystem.entity.Result;
import quizsystem.entity.User;
import quizsystem.service.ResultService;

import javax.servlet.http.HttpServletRequest;
import java.util.ResourceBundle;

public class ResultsCommand implements Command {

    private final ResultService resultService;
    private final ResourceBundle resourceBundle;

    public ResultsCommand(ResultService resultService, ResourceBundle resourceBundle) {

        this.resultService = resultService;
        this.resourceBundle = resourceBundle;
    }

    @Override
    public String execute(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("currentUser");
        int itemsPerPage = Integer.parseInt(resourceBundle.getString("itemsPerPage"));
        String page = request.getParameter("page");
        Page <Result> results = resultService.getAllResults(user.getUserId(), page, itemsPerPage);
        request.setAttribute("results", results.getItems());
        request.setAttribute("maxPages", results.getMaxPageNumber());
        return "results.jsp";
    }
}
