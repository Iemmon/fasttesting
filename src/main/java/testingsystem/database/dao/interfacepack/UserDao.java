package testingsystem.database.dao.interfacepack;

import testingsystem.database.exception.DataBaseSqlRuntimeException;
import testingsystem.domain.User;

import java.util.Optional;

public interface UserDao extends CrudDao<User> {
    Optional<User> findByEmail(String email) throws DataBaseSqlRuntimeException;
}
