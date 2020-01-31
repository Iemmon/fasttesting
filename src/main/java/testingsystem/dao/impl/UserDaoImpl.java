package testingsystem.dao.impl;

import org.apache.log4j.Logger;
import testingsystem.dao.connectionpool.ConnectionPool;
import testingsystem.dao.exception.DataBaseSqlRuntimeException;
import testingsystem.dao.UserDao;
import testingsystem.dao.pagination.Page;
import testingsystem.dao.pagination.PageRequest;
import testingsystem.entity.Role;
import testingsystem.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private static final String DELETE_QUERY = "DELETE FROM users WHERE id=?";
    private static final String SAVE_QUERY = "INSERT INTO users (email, password, salt) VALUES (?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE users (email, password) VALUES (?, ?) ON DUPLICATE KEY UPDATE email=VALUES(email), password=VALUES(password)";
    private static final String COUNT_QUERY = "SELECT COUNT(*) FROM users";

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
    public Page findAll(PageRequest pageRequest) {
        List<User> entities = new ArrayList<>();
        try (final PreparedStatement preparedStatement =
                     pool.getConnection().prepareStatement(FIND_WITH_PAGINATION_QUERY)) {
            preparedStatement.setInt(1, pageRequest.getItemsPerPage());
            preparedStatement.setInt(2, pageRequest.getPageNumber() * pageRequest.getItemsPerPage());

            final ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                final User optionalEntity = mapResultSetToEntity(resultSet);
                entities.add(optionalEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Page(entities, pageRequest.getPageNumber(), pageRequest.getItemsPerPage(), count() / pageRequest.getItemsPerPage());
    }

    @Override
    public void save(User entity) {
        try (final PreparedStatement preparedStatement = pool.getConnection().prepareStatement(SAVE_QUERY);) {
            preparedStatement.setString(1, entity.getEmail());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setString(3, entity.getSalt());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.warn(String.format(SAVE_QUERY + " failed", e));
            throw new DataBaseSqlRuntimeException("User was not saved", e);
        }
    }

    @Override
    public void update(User entity) {
        try (final PreparedStatement preparedStatement = pool.getConnection().prepareStatement(UPDATE_QUERY)) {
            preparedStatement.setString(1, entity.getEmail());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn(String.format(UPDATE_QUERY + " failed", e));
            throw new DataBaseSqlRuntimeException("User update failed", e);
        }
    }

    @Override
    public void deleteById(Long id) {
        try (final PreparedStatement preparedStatement = pool.getConnection().prepareStatement(DELETE_QUERY)) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.warn(String.format(DELETE_QUERY + " failed", e));
            throw new DataBaseSqlRuntimeException("No users were found", e);
        }
    }

    @Override
    protected User mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return User.builder()
                .withId(resultSet.getLong("id"))
                .withEmail(resultSet.getString("email"))
                .withPassword(resultSet.getString("password"))
                .withSalt(resultSet.getString("salt"))
                .withRole(Role.valueOf(resultSet.getString("role")))
                .build();
    }

}
