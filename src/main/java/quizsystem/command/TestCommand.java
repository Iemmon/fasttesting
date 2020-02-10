package quizsystem.command;

import quizsystem.entity.Test;
import quizsystem.service.TestService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class TestCommand implements Command {

    private final TestService testService;

    public TestCommand(TestService testService) {
        this.testService = testService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        Long topicId = Long.valueOf(request.getParameter("topic_id"));
        List<Test> tests = testService.findAllByTopicId(topicId);
        request.setAttribute("tests", tests);
        return "tests.jsp";
    }
}
