package quizsystem.command;

import quizsystem.dao.pagination.Page;
import quizsystem.entity.Result;
import quizsystem.service.ResultService;

import javax.servlet.http.HttpServletRequest;
import java.util.ResourceBundle;

public class ResultByUserCommand implements Command{

    private final ResultService resultService;
    private final ResourceBundle resourceBundle;

    public ResultByUserCommand(ResultService resultService, ResourceBundle resourceBundle) {
        this.resultService = resultService;
        this.resourceBundle = resourceBundle;
    }


    @Override
    public String execute(HttpServletRequest request) {
        Long userId = Long.parseLong(request.getParameter("user"));
        int itemsPerPage = Integer.parseInt(resourceBundle.getString("itemsPerPage"));
        String page = request.getParameter("page");
        Page<Result> results = resultService.getAllResults(userId, page, itemsPerPage);
        request.setAttribute("results", results.getItems());
        request.setAttribute("maxPages", results.getMaxPageNumber());
        return "results.jsp";
    }
}
