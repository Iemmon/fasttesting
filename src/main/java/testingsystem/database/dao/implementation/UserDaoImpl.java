package testingsystem.database.dao.implementation;

import testingsystem.database.ConnectionPool;
import testingsystem.database.HikariCPDataSource;
import testingsystem.database.dao.interfacepack.UserDao;
import testingsystem.database.exception.DataBaseSqlRuntimeException;
import testingsystem.domain.Role;
import testingsystem.domain.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl extends AbstractCrudDaoImpl<User> implements UserDao {

    private static final String FIND_BY_EMAIL_QUERY = "SELECT * FROM users WHERE email=?";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM users WHERE id=?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM users";
    private static final String SAVE_QUERY = "INSERT INTO users (email, password, salt) VALUES (?, ?, ?)";

    public UserDaoImpl(ConnectionPool pool) {
        super(pool, FIND_BY_ID_QUERY);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (final PreparedStatement preparedStatement =
                     pool.getConnection().prepareStatement(FIND_BY_EMAIL_QUERY)) {
            preparedStatement.setString(1, email);

            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(mapResultSetToEntity(resultSet));
                }
            }
        } catch (SQLException e) {
            //log
            e.printStackTrace();
            throw new DataBaseSqlRuntimeException("no user found  by email", e);
        }
        return Optional.empty();
    }

    @Override
    public void save(User entity) {
        try (final PreparedStatement preparedStatement = pool.getConnection().prepareStatement(SAVE_QUERY);) {
            preparedStatement.setString(1, entity.getEmail());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setString(3, entity.getSalt());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataBaseSqlRuntimeException("user not saved", e);
        }

    }

    @Override
    public Optional<User> findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<User> findAll() {
        try (final PreparedStatement preparedStatement =
                     pool.getConnection().prepareStatement(FIND_ALL_QUERY)) {
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                List<User> users = new ArrayList<>();
                while (resultSet.next()) {
                    final User optionalUser = mapResultSetToEntity(resultSet);
                    users.add(optionalUser);
                }
                return users;
            }
        } catch (SQLException e) {
            //log
            throw new DataBaseSqlRuntimeException("no users were found", e);
        }
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void deleteById(Integer id) {

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
