package testingsystem.service;

import testingsystem.entity.Question;

import java.util.List;

public interface QuestionService {

    List<Question> findAllByTestId(Long id);

}
