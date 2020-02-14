package quizsystem.dao.impl;

import org.apache.log4j.Logger;
import quizsystem.dao.connectionpool.ConnectionPool;
import quizsystem.dao.CrudDao;
import quizsystem.dao.exception.DataBaseSqlRuntimeException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;


public abstract class AbstractCrudDaoImpl<E> implements CrudDao<E> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractCrudDaoImpl.class);

    protected final ConnectionPool pool;
    private final String findByIdQuery;
    private final String findAll;
    private final String countAll;
    protected final BiConsumer<PreparedStatement, Long> LONG_PARAM_SETTER = ((preparedStatement, number) -> {
        try {
            preparedStatement.setLong(1, number);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    });

    protected AbstractCrudDaoImpl(ConnectionPool pool, String findByIdQuery, String findAll, String countAll) {
        this.findByIdQuery = findByIdQuery;
        this.findAll = findAll;
        this.countAll = countAll;
        this.pool = pool;
    }

    @Override
    public E save(E entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<E> findById(Long id) throws DataBaseSqlRuntimeException {
        return findByParam(id, findByIdQuery, LONG_PARAM_SETTER);
    }

    protected <P> Optional<E> findByParam(P param, String findByParam, BiConsumer<PreparedStatement, P> designatedParamSetter) {
        try (final PreparedStatement preparedStatement =
                     pool.getConnection().prepareStatement(findByParam)) {

            designatedParamSetter.accept(preparedStatement, param);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(mapResultSetToEntity(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.warn(String.format(findByParam + " failed", e));
            throw new DataBaseSqlRuntimeException("Nothing was found", e);
        }
        return Optional.empty();
    }

    protected <P> List<E> findAllByParam(P param, String findByParam, BiConsumer<PreparedStatement, P> designatedParamSetter) {
        try (final PreparedStatement preparedStatement =
                     pool.getConnection().prepareStatement(findByParam)) {

            designatedParamSetter.accept(preparedStatement, param);
            return getDataFromResultSet(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.warn(String.format(findByParam + " failed", e));
            throw new DataBaseSqlRuntimeException("Nothing was found", e);
        }
    }

    @Override
    public List<E> findAll() {
        try (final PreparedStatement preparedStatement =
                     pool.getConnection().prepareStatement(findAll)) {
            return getDataFromResultSet(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.warn(String.format(findAll + " failed", e));
            throw new DataBaseSqlRuntimeException("No entries were found", e);
        }
    }

    private List<E> getDataFromResultSet(PreparedStatement preparedStatement) {
        try (final ResultSet resultSet = preparedStatement.executeQuery()) {
            List<E> entities = new ArrayList<>();
            while (resultSet.next()) {
                final E optionalEntity = mapResultSetToEntity(resultSet);
                entities.add(optionalEntity);
            }
            return entities;
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.warn(String.format("Unable to get data from result set", e));
            throw new DataBaseSqlRuntimeException("Unable to get data from result set", e);
        }
    }

    @Override
    public long count() {
        try (final PreparedStatement preparedStatement = pool.getConnection().prepareStatement(countAll);  ResultSet rs = preparedStatement.executeQuery();) {
            if (rs.next()) {
                return rs.getLong(1);
            }
            return 0;
        } catch (SQLException e) {
            LOGGER.warn(String.format(countAll + " failed", e));
            e.printStackTrace();
            throw new DataBaseSqlRuntimeException("Count failed", e);
        }
    }

    @Override
    public void update(E entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException();
    }

    protected abstract E mapResultSetToEntity(ResultSet resultSet) throws SQLException;
}
