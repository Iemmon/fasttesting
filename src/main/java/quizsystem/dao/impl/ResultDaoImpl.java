package quizsystem.dao.impl;

import org.apache.log4j.Logger;
import quizsystem.dao.ResultDao;
import quizsystem.dao.connectionpool.ConnectionPool;
import quizsystem.dao.exception.DataBaseSqlRuntimeException;
import quizsystem.entity.Result;
import quizsystem.entity.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ResultDaoImpl extends AbstractCrudDaoImpl<Result> implements ResultDao {
    protected static final Logger LOGGER = Logger.getLogger(ResultDaoImpl.class);

    private static final String SAVE_QUERY = "INSERT INTO results (test_id, score, user_id) VALUES (?, ?, ?)";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM results WHERE id=?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM results";
    private static final String COUNT_QUERY = "SELECT COUNT(*) FROM results";
    private static final String FIND_ALL_BY_USER_ID_QUERY = "SELECT * FROM results LEFT JOIN tests ON test_id=tests.id WHERE user_id=?";

    public ResultDaoImpl(ConnectionPool pool) {
        super(pool, FIND_BY_ID_QUERY, FIND_ALL_QUERY, COUNT_QUERY);
    }

    @Override
    public Result save(Result entity) {
        try (final PreparedStatement preparedStatement = pool.getConnection().prepareStatement(SAVE_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, entity.getTest().getId());
            preparedStatement.setInt(2, entity.getScore());
            preparedStatement.setLong(3, entity.getUserId());
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            return getResultByGeneratedKey(preparedStatement, entity);
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.warn(String.format(SAVE_QUERY + " failed", e));
            throw new DataBaseSqlRuntimeException("Result saving failed", e);
        }
    }

    @Override
    public List<Result> findAllByUserId(Long id) {
        return findAllByParam(id, FIND_ALL_BY_USER_ID_QUERY, LONG_PARAM_SETTER);
    }

    @Override
    protected Result mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        Test test = new Test(resultSet.getLong("test_id"), resultSet.getString("name"));
        return new Result(resultSet.getLong("id"), resultSet.getInt("score"), test, resultSet.getLong("user_id"));
    }

    private Result getResultByGeneratedKey(PreparedStatement preparedStatement, Result entity) throws SQLException {
        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return new Result(generatedKeys.getLong(1), entity.getScore(), entity.getTest(), entity.getUserId());
            } else {
                throw new SQLException("Result creation failed, no ID obtained.");
            }
        }
    }
}
