package testingsystem.dao;

import testingsystem.entity.Question;

import java.util.List;

public interface QuestionDao extends CrudDao<Question> {

    List<Question> findAllByTestId(Long id);
}
