package testingsystem.database.dao.implementation;

import testingsystem.database.dao.interfacepack.TopicDao;
import testingsystem.database.dao.pagination.Page;
import testingsystem.database.dao.pagination.PageRequest;
import testingsystem.domain.Topic;

import java.util.List;
import java.util.Optional;

public class TopicDaoImpl implements TopicDao {

    @Override
    public void save(Topic entity) {

    }

    @Override
    public Optional<Topic> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Topic> findAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void update(Topic entity) {

    }

    @Override
    public void deleteById(Integer id) {

    }
}
