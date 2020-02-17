package quizsystem.command;

import quizsystem.dao.pagination.Page;
import quizsystem.entity.Test;
import quizsystem.service.TestService;

import javax.servlet.http.HttpServletRequest;
import java.util.ResourceBundle;

public class TestCommand implements Command {

    private final TestService testService;
    private final ResourceBundle resourceBundle;

    public TestCommand(TestService testService, ResourceBundle resourceBundle) {
        this.testService = testService;
        this.resourceBundle = resourceBundle;
    }

    @Override
    public String execute(HttpServletRequest request) {
        Long topicId = Long.valueOf(request.getParameter("topic_id"));
        int itemsPerPage = Integer.parseInt(resourceBundle.getString("itemsPerPage"));
        String page = request.getParameter("page");
        Page<Test> tests = testService.findAllByTopicId(topicId, page, itemsPerPage);
        request.setAttribute("tests", tests.getItems());
        request.setAttribute("maxPages", tests.getMaxPageNumber());
        return "tests.jsp";
    }
}
