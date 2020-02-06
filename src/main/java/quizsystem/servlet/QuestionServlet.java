package quizsystem.servlet;

import quizsystem.entity.Question;
import quizsystem.entity.Result;
import quizsystem.entity.User;
import quizsystem.injector.ApplicationInjector;
import quizsystem.service.QuestionService;
import quizsystem.service.ResultService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class QuestionServlet extends HttpServlet {

    private final QuestionService questionService;
    private final ResultService resultService;

    public QuestionServlet() {
        this.questionService = ApplicationInjector.getInstance().getQuestionService();
        this.resultService = ApplicationInjector.getInstance().getResultService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long testId = Long.valueOf(req.getParameter("test_id"));
        List<Question> questions = questionService.findAllByTestId(testId);
        req.setAttribute("questions", questions);
        req.setAttribute("test_id", testId);
        req.getRequestDispatcher("questions.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Set<Long> userAnswers = new HashSet<>();
        for(String key : req.getParameterMap().keySet()){
            if(!key.matches("[0-9]+")){
                continue;
            }
            userAnswers.add(Long.parseLong(key));
        }
        Long testId = Long.parseLong(req.getParameter("test_id"));
        Long userId = ((User)req.getSession().getAttribute("currentUser")).getUserId();

        List<Question> incorrectQ = questionService.getIncorrectAnsweredQuestions(testId, userAnswers);
        List<Question> basicQuestionList = questionService.findAllByTestId(testId);

        Integer score = (int)(100 * (double)(basicQuestionList.size() - incorrectQ.size())/basicQuestionList.size());
        Result result = new Result(score, testId, userId);
        resultService.saveResult(result);

        req.setAttribute("test_results", incorrectQ);
        req.setAttribute("score", score);
        req.setAttribute("ans", userAnswers);

        req.getRequestDispatcher("testresult.jsp").forward(req, resp);
    }
}
