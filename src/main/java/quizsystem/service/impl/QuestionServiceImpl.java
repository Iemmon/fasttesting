package quizsystem.service.impl;

import quizsystem.dao.QuestionDao;
import quizsystem.entity.Answer;
import quizsystem.entity.Question;
import quizsystem.service.QuestionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;

    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public List<Question> findAllByTestId(Long id) {
        return questionDao.findAllByTestId(id);
    }

    @Override
    public List<Question> getIncorrectAnsweredQuestions(Long testId, Set<Long> answeredQuestions) {
        List<Question> incorrectUserQuestions = new ArrayList<>();
        List<Question> questions = questionDao.findAllByTestId(testId);
        for(Question q : questions){
            boolean isCorrectQuestion = true;
            for (Answer a : q.getListOfAnswers()){
                if(!answeredQuestions.contains(a.getId()) && a.isCorrect()){
                    isCorrectQuestion = false;
                }
                if(answeredQuestions.contains(a.getId()) && !a.isCorrect()){
                    isCorrectQuestion = false;
                }
            }
            if(!isCorrectQuestion){
                incorrectUserQuestions.add(q);
            }
        }
        return incorrectUserQuestions;
    }
}
