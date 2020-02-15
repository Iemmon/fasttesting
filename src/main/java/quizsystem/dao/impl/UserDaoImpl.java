package quizsystem.dao.impl;

import org.apache.log4j.Logger;
import quizsystem.dao.connectionpool.ConnectionPool;
import quizsystem.dao.exception.DataBaseSqlRuntimeException;
import quizsystem.dao.UserDao;
import quizsystem.dao.pagination.Page;
import quizsystem.dao.pagination.PageRequest;
import quizsystem.entity.Role;
import quizsystem.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;

public class UserDaoImpl extends AbstractCrudDaoImpl<User> implements UserDao {
    protected static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

    private static final String FIND_WITH_PAGINATION_QUERY = "SELECT * FROM users LIMIT ? OFFSET ?";
    private static final String FIND_BY_EMAIL_QUERY = "SELECT * FROM users WHERE email=?";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM users WHERE id=?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM users";
    private static final String SAVE_QUERY = "INSERT INTO users (email, password, role) VALUES (?, ?, ?)";
    private static final String COUNT_QUERY = "SELECT COUNT(*) FROM users";

    private static final String FIND_ALL_SCORE = "SELECT users.id, users.email, users.role, AVG(results.score) as avg_score FROM users LEFT JOIN results ON results.user_id = users.id WHERE users.role = 'STUDENT' GROUP BY users.id  LIMIT ? OFFSET ?";

    private final BiConsumer<PreparedStatement, String> STRING_PARAM_SETTER = ((preparedStatement, string) -> {
        try {
            preparedStatement.setString(1, string);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    });

    public UserDaoImpl(ConnectionPool pool) {
        super(pool, FIND_BY_ID_QUERY, FIND_ALL_QUERY, COUNT_QUERY);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return findByParam(email, FIND_BY_EMAIL_QUERY, STRING_PARAM_SETTER);
    }

    @Override
    public Page<User> findAll(PageRequest pageRequest) {
        List<User> entities = new ArrayList<>();
        try (final PreparedStatement preparedStatement =
                     pool.getConnection().prepareStatement(FIND_ALL_SCORE)) {
            preparedStatement.setInt(1, pageRequest.getItemsPerPage());
            preparedStatement.setInt(2, (pageRequest.getPageNumber() - 1) * pageRequest.getItemsPerPage());

            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    final User optionalEntity = mapResultSetToEntityWithScore(resultSet);
                    entities.add(optionalEntity);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Page<>(entities, pageRequest.getPageNumber(), pageRequest.getItemsPerPage(), pageRequest.getMaxPages());
    }

    @Override
    public User save(User entity) {
        try (final PreparedStatement preparedStatement = pool.getConnection().prepareStatement(SAVE_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, entity.getEmail());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setString(3, entity.getRole().toString());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            return getUserByGeneratedKey(preparedStatement, entity);
        } catch (SQLException e) {
            LOGGER.warn("SQL Exception threw in UserDaoImpl:save: ", e);
            throw new DataBaseSqlRuntimeException("User was not saved", e);
        }
    }

    @Override
    protected User mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return User.builder()
                .withId(resultSet.getLong("id"))
                .withEmail(resultSet.getString("email"))
                .withPassword(resultSet.getString("password"))
                .withRole(Role.valueOf(resultSet.getString("role")))
                .build();
    }

    protected User mapResultSetToEntityWithScore(ResultSet resultSet) throws SQLException {
        return User.builder()
                .withId(resultSet.getLong("id"))
                .withEmail(resultSet.getString("email"))
                .withRole(Role.valueOf(resultSet.getString("role")))
                .withAverageMark(resultSet.getDouble("avg_score"))
                .build();
    }

    private User getUserByGeneratedKey(PreparedStatement preparedStatement, User entity) throws SQLException {
        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return User.builder().withId(generatedKeys.getLong(1))
                        .withEmail(entity.getEmail())
                        .withPassword(entity.getPassword())
                        .withRole(entity.getRole())
                        .build();
            } else {
                throw new SQLException("User creation failed, no ID obtained.");
            }
        }
    }

}
