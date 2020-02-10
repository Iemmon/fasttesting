package quizsystem.command;

import quizsystem.entity.Question;
import quizsystem.service.QuestionService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class LoadQuestionsCommand implements Command{

    private final QuestionService questionService;

    public LoadQuestionsCommand(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        Long testId = Long.valueOf(request.getParameter("test_id"));
        List<Question> questions = questionService.findAllByTestId(testId);
        request.setAttribute("questions", questions);
        return "questions.jsp";
    }
}
