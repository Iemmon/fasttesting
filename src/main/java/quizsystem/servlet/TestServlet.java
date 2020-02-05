package quizsystem.servlet;

import quizsystem.entity.Test;
import quizsystem.injector.ApplicationInjector;
import quizsystem.service.TestService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TestServlet extends HttpServlet {
    private final TestService testService;

    public TestServlet() {
        this.testService = ApplicationInjector.getInstance().getTestService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long topicId = Long.valueOf(req.getParameter("topic_id"));
        List<Test> tests = testService.findAllByTopicId(topicId);
        req.setAttribute("tests", tests);
        req.getRequestDispatcher("tests.jsp").forward(req, resp);
    }
}
