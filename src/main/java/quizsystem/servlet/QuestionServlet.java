package quizsystem.servlet;

import quizsystem.entity.Question;
import quizsystem.injector.ApplicationInjector;
import quizsystem.service.QuestionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class QuestionServlet extends HttpServlet {

    private final QuestionService questionService;

    public QuestionServlet() {
        this.questionService = ApplicationInjector.getInstance().getQuestionService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long testId = Long.valueOf(req.getParameter("test_id"));
        List<Question> questions = questionService.findAllByTestId(testId);
        req.setAttribute("questions", questions);
        req.getRequestDispatcher("questions.jsp").forward(req, resp);
    }
}
