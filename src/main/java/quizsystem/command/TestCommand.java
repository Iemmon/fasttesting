package quizsystem.command;

import quizsystem.dao.pagination.Page;
import quizsystem.entity.Test;
import quizsystem.service.TestService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
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
        List<Test> tests = testService.findAllByTopicId(topicId);
        request.setAttribute("tests", tests);
        return "tests.jsp";
    }
}
