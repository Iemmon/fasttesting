package quizsystem.service.impl;

import quizsystem.dao.QuestionDao;
import quizsystem.entity.Question;
import quizsystem.service.QuestionService;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;

    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public List<Question> findAllByTestId(Long id) {
        return questionDao.findAllByTestId(id);
    }
}
