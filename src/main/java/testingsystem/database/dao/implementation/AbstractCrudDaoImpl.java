package testingsystem.database.dao.implementation;

import testingsystem.database.ConnectionPool;
import testingsystem.database.dao.interfacepack.CrudDao;
import testingsystem.database.exception.DataBaseSqlRuntimeException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public abstract class AbstractCrudDaoImpl<E> implements CrudDao<E> {
    protected final ConnectionPool pool;
    private final String findById;

    protected AbstractCrudDaoImpl(ConnectionPool pool, String findById) {
        this.findById = findById;
        this.pool = pool;
    }

    @Override
    public void save(E entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<E> findById(Long id) throws DataBaseSqlRuntimeException {
        try (final PreparedStatement preparedStatement =
                     pool.getConnection().prepareStatement(findById)) {
            preparedStatement.setLong(1, id);

            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(mapResultSetToEntity(resultSet));
                }
            }
        } catch (SQLException e) {
            //log
            throw new DataBaseSqlRuntimeException("", e);
        }
        return Optional.empty();
    }

    @Override
    public void update(E entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException();
    }

    protected abstract E mapResultSetToEntity(ResultSet resultSet) throws SQLException;
}
