package quizsystem.service;

import quizsystem.entity.Question;

import java.util.List;

public interface QuestionService {

    List<Question> findAllByTestId(Long id);

}
