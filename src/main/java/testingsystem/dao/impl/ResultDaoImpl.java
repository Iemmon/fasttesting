package testingsystem.dao.impl;

import org.apache.log4j.Logger;
import testingsystem.dao.ConnectionPool;
import testingsystem.dao.exception.DataBaseSqlRuntimeException;
import testingsystem.dao.interfacepack.ResultDao;
import testingsystem.entity.Result;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ResultDaoImpl extends AbstractCrudDaoImpl<Result> implements ResultDao {
    protected static final Logger LOGGER = Logger.getLogger(ResultDaoImpl.class);

    private static final String SAVE_QUERY = "INSERT INTO results (id, test_id, score) VALUES (?, ?, ?)";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM results WHERE id=?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM results";
    private static final String COUNT_QUERY = "SELECT COUNT(*) FROM results";

    protected ResultDaoImpl(ConnectionPool pool) {
        super(pool, FIND_BY_ID_QUERY, FIND_ALL_QUERY, COUNT_QUERY);
    }

    @Override
    public void save(Result entity) {
        try (final PreparedStatement preparedStatement = pool.getConnection().prepareStatement(SAVE_QUERY)) {
            preparedStatement.setLong(1, entity.getId());
            preparedStatement.setLong(2, entity.getTest().getId());
            preparedStatement.setInt(3, entity.getScore());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn(String.format(SAVE_QUERY + " failed", e));
            throw new DataBaseSqlRuntimeException("Result saving failed", e);
        }
    }

    @Override
    public Optional<Result> findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<Result> findAll() {
        return super.findAll();
    }

    @Override
    public long count() {
        return super.count();
    }

    @Override
    public void update(Result entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected Result mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return new Result(resultSet.getLong("id"), resultSet.getInt("score"));
    }
}
