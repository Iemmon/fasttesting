package quizsystem.dao.impl;

import org.apache.log4j.Logger;
import quizsystem.dao.ResultDao;
import quizsystem.dao.connectionpool.ConnectionPool;
import quizsystem.dao.exception.DataBaseSqlRuntimeException;
import quizsystem.entity.Result;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ResultDaoImpl extends AbstractCrudDaoImpl<Result> implements ResultDao {
    protected static final Logger LOGGER = Logger.getLogger(ResultDaoImpl.class);

    private static final String SAVE_QUERY = "INSERT INTO results (test_id, score, user_id) VALUES (?, ?, ?)";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM results WHERE id=?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM results";
    private static final String COUNT_QUERY = "SELECT COUNT(*) FROM results";
    private static final String FIND_ALL_BY_USER_ID_QUERY = "SELECT * FROM results WHERE user_id=?";

    public ResultDaoImpl(ConnectionPool pool) {
        super(pool, FIND_BY_ID_QUERY, FIND_ALL_QUERY, COUNT_QUERY);
    }

    @Override
    public Result save(Result entity) {
        try (final PreparedStatement preparedStatement = pool.getConnection().prepareStatement(SAVE_QUERY)) {
            preparedStatement.setLong(1, entity.getTestId());
            preparedStatement.setInt(2, entity.getScore());
            preparedStatement.setLong(3, entity.getUserId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn(String.format(SAVE_QUERY + " failed", e));
            throw new DataBaseSqlRuntimeException("Result saving failed", e);
        }
        return entity;
    }

    @Override
    public List<Result> findAllByUserId(Long id) {
        return findAllByParam(id, FIND_ALL_BY_USER_ID_QUERY, LONG_PARAM_SETTER);
    }

    @Override
    protected Result mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return new Result(resultSet.getLong("id"), resultSet.getInt("score"), resultSet.getLong("test_id"), resultSet.getLong("user_id"));
    }
}
