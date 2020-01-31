package testingsystem.dao.impl;

import testingsystem.dao.connectionpool.ConnectionPool;
import testingsystem.dao.exception.DataBaseSqlRuntimeException;
import testingsystem.dao.TopicDao;
import testingsystem.entity.Topic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class TopicDaoImpl extends AbstractCrudDaoImpl<Topic> implements TopicDao {
    private static Logger log = Logger.getLogger(TopicDaoImpl.class.getName());

    private static final String SAVE_QUERY = "INSERT INTO topics name=?";
    private static final String DELETE_QUERY = "DELETE FROM topics WHERE id=?";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM topics WHERE id=?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM topics";
    private static final String COUNT_QUERY = "SELECT COUNT(*) FROM users";
    private static final String UPDATE_QUERY = "UPDATE topics SET name=? WHERE id=?";


    public TopicDaoImpl(ConnectionPool pool) {
        super(pool, FIND_BY_ID_QUERY, FIND_ALL_QUERY, COUNT_QUERY);
    }

    @Override
    public void save(Topic entity) {
        try (final PreparedStatement preparedStatement = pool.getConnection().prepareStatement(SAVE_QUERY)) {
            preparedStatement.setString(1, entity.getTopicName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn(String.format(SAVE_QUERY + " failed", e));
            throw new DataBaseSqlRuntimeException("Topic saving failed", e);
        }
    }

    @Override
    public void update(Topic entity) {
        try (final PreparedStatement preparedStatement = pool.getConnection().prepareStatement(UPDATE_QUERY)) {
            preparedStatement.setString(1, entity.getTopicName());
            preparedStatement.setLong(2, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn(String.format(UPDATE_QUERY + " failed", e));
            throw new DataBaseSqlRuntimeException("Topic update failed", e);
        }
    }

    @Override
    public void deleteById(Long id) {
        try (final PreparedStatement preparedStatement = pool.getConnection().prepareStatement(DELETE_QUERY)) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.warn(String.format(DELETE_QUERY + " failed", e));
            throw new DataBaseSqlRuntimeException("No topics were found", e);
        }
    }

    @Override
    protected Topic mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return new Topic(resultSet.getLong("id"), resultSet.getString("name"));
    }

}
