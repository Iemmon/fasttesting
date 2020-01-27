package testingsystem.database.dao.implementation;

import testingsystem.database.dao.interfacepack.ResultDao;
import testingsystem.domain.Result;

import java.util.List;
import java.util.Optional;

public class ResultDaoImpl implements ResultDao {
    @Override
    public void save(Result entity) {

    }

    @Override
    public Optional<Result> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Result> findAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void update(Result entity) {

    }

    @Override
    public void deleteById(Integer id) {

    }
}
