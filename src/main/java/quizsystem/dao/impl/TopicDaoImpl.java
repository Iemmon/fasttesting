package quizsystem.dao.impl;

import quizsystem.dao.TopicDao;
import quizsystem.dao.connectionpool.ConnectionPool;
import quizsystem.entity.Topic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class TopicDaoImpl extends AbstractCrudDaoImpl<Topic> implements TopicDao {
    private static Logger LOG = Logger.getLogger(TopicDaoImpl.class.getName());

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
    protected Topic mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return new Topic(resultSet.getLong("id"), resultSet.getString("name"));
    }

}
