package quizsystem.command;

import quizsystem.entity.Question;
import quizsystem.entity.Result;
import quizsystem.entity.Test;
import quizsystem.entity.User;
import quizsystem.service.QuestionService;
import quizsystem.service.ResultService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CalculateResultCommand implements Command {

    private final QuestionService questionService;
    private final ResultService resultService;


    public CalculateResultCommand(QuestionService questionService, ResultService resultService) {
        this.questionService = questionService;
        this.resultService = resultService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        Set<Long> userAnswers = new HashSet<>();
        for(String key : request.getParameterMap().keySet()){
            if(!key.matches("[0-9]+")){
                continue;
            }
            userAnswers.add(Long.parseLong(key));
        }
        Long testId = Long.parseLong(request.getParameter("test_id"));
        Test test = new Test(testId);
        Long userId = ((User)request.getSession().getAttribute("currentUser")).getUserId();

        List<Question> incorrectQ = questionService.getIncorrectAnsweredQuestions(testId, userAnswers);
        List<Question> basicQuestionList = questionService.findAllByTestId(testId);

        Integer score = (int)(100 * (double)(basicQuestionList.size() - incorrectQ.size())/basicQuestionList.size());

        Result result = new Result(score, test, userId);
        resultService.saveResult(result);

        request.setAttribute("test_results", incorrectQ);
        request.setAttribute("score", score);
        request.setAttribute("ans", userAnswers);
        return "testresult.jsp";
    }
}
