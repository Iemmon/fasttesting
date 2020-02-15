package quizsystem.dao.impl;

import org.apache.log4j.Logger;
import quizsystem.dao.TestDao;
import quizsystem.dao.connectionpool.ConnectionPool;
import quizsystem.dao.exception.DataBaseSqlRuntimeException;
import quizsystem.entity.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TestDaoImpl extends AbstractCrudDaoImpl<Test> implements TestDao {
    protected static final Logger LOGGER = Logger.getLogger(TestDaoImpl.class);

    private static final String FIND_BY_ID_QUERY = "SELECT * FROM tests WHERE id=?";
    private static final String FIND_BY_TOPIC_ID_QUERY = "SELECT * FROM tests WHERE topic_id=?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM tests";
    private static final String COUNT_QUERY = "SELECT COUNT(*) FROM tests";


    public TestDaoImpl(ConnectionPool pool) {
        super(pool, FIND_BY_ID_QUERY, FIND_ALL_QUERY, COUNT_QUERY);
    }

    @Override
    public List<Test> findAllByTopicId(Long topicId) {
        return super.findAllByParam(topicId, FIND_BY_TOPIC_ID_QUERY, LONG_PARAM_SETTER);
    }

    @Override
    protected Test mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return new Test(resultSet.getLong("id"), resultSet.getString("name"));
    }
}
