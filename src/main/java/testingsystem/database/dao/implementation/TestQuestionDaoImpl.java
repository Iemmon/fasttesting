package testingsystem.database.dao.implementation;

import testingsystem.database.dao.interfacepack.TestQuestionDao;
import testingsystem.database.dao.pagination.Page;
import testingsystem.database.dao.pagination.PageRequest;
import testingsystem.domain.Question;

import java.util.List;
import java.util.Optional;

public class TestQuestionDaoImpl implements TestQuestionDao {
    @Override
    public void save(Question entity) {

    }

    @Override
    public Optional<Question> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Question> findAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void update(Question entity) {

    }

    @Override
    public void deleteById(Integer id) {

    }
}
