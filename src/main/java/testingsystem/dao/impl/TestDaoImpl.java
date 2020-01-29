package testingsystem.dao.impl;

import org.apache.log4j.Logger;
import testingsystem.dao.ConnectionPool;
import testingsystem.dao.exception.DataBaseSqlRuntimeException;
import testingsystem.dao.interfacepack.TestDao;
import testingsystem.entity.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TestDaoImpl extends AbstractCrudDaoImpl<Test> implements TestDao {
    protected static final Logger LOGGER = Logger.getLogger(TestDaoImpl.class);

    private static final String FIND_BY_ID_QUERY = "SELECT * FROM tests WHERE id=?";
    private static final String FIND_BY_TOPIC_ID_QUERY = "SELECT * FROM tests WHERE topic_id=?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM tests";
    private static final String DELETE_QUERY = "DELETE FROM tests WHERE id=?";
    private static final String SAVE_QUERY = "INSERT INTO ";
    private static final String COUNT_QUERY = "SELECT COUNT(*) FROM tests";
    private static final String UPDATE_QUERY = "UPDATE tests SET name=? WHERE id=?";


    public TestDaoImpl(ConnectionPool pool) {
        super(pool, FIND_BY_ID_QUERY, FIND_ALL_QUERY, COUNT_QUERY);
    }

    @Override
    public void save(Test entity) {
        try (final PreparedStatement preparedStatement = pool.getConnection().prepareStatement(SAVE_QUERY)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn(String.format(SAVE_QUERY + " failed", e));
            throw new DataBaseSqlRuntimeException("Test saving failed", e);
        }
    }

    @Override
    public Optional<Test> findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<Test> findAll() {
        return super.findAll();
    }

    @Override
    public List<Test> findAllByTopicId(Long topicId) {
        return super.findAllByParam(topicId, FIND_BY_TOPIC_ID_QUERY, LONG_PARAM_SETTER);
    }

    @Override
    public long count() {
        return super.count();
    }

    @Override
    public void update(Test entity) {
        try(final PreparedStatement preparedStatement = pool.getConnection().prepareStatement(UPDATE_QUERY)){
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setLong(2, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            LOGGER.warn(String.format(UPDATE_QUERY + " failed", e));
            throw new DataBaseSqlRuntimeException("Test update fail", e);
        }
    }

    @Override
    public void deleteById(Long id) {
        try (final PreparedStatement preparedStatement = pool.getConnection().prepareStatement(DELETE_QUERY)) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.warn(String.format(DELETE_QUERY + " failed", e));
            throw new DataBaseSqlRuntimeException("No tests were found", e);
        }
    }

    @Override
    protected Test mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return new Test(resultSet.getLong("id"), resultSet.getString("name"));
    }
}
