package quizsystem.command;

import quizsystem.entity.Question;
import quizsystem.entity.Result;
import quizsystem.entity.Test;
import quizsystem.entity.User;
import quizsystem.service.MailSender;
import quizsystem.service.impl.MailSenderImpl;
import quizsystem.service.QuestionService;
import quizsystem.service.ResultService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CalculateResultCommand implements Command {

    private final QuestionService questionService;
    private final ResultService resultService;
    private final MailSender mailSender;


    public CalculateResultCommand(QuestionService questionService, ResultService resultService, MailSender mailSender) {
        this.questionService = questionService;
        this.resultService = resultService;
        this.mailSender = mailSender;
    }

    @Override
    public String execute(HttpServletRequest request) {
        Set<Long> userAnswers = getUserAnswers(request);

        Long testId = Long.parseLong(request.getParameter("test_id"));
        Test test = new Test(testId);
        User user = (User)request.getSession().getAttribute("currentUser");
        Long userId = user.getUserId();

        List<Question> incorrectQ = questionService.getIncorrectAnsweredQuestions(testId, userAnswers);
        List<Question> basicQuestionList = questionService.findAllByTestId(testId);

        Integer score = (int)(100 * (double)(basicQuestionList.size() - incorrectQ.size())/basicQuestionList.size());

        Result result = new Result(score, test, userId);
        resultService.saveResult(result);

        mailSender.sendMail(user.getEmail(), test.getName(), score);

        request.setAttribute("test_results", incorrectQ);
        request.setAttribute("score", score);
        request.setAttribute("ans", userAnswers);
        return "testresult.jsp";
    }

    private Set<Long> getUserAnswers(HttpServletRequest request){
        Set<Long> userAnswers = new HashSet<>();
        for(String key : request.getParameterMap().keySet()){
            if(!key.matches("[0-9]+")){
                continue;
            }
            userAnswers.add(Long.parseLong(key));
        }
        return userAnswers;
    }
}
