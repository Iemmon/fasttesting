package testingsystem.dao.interfacepack;

import testingsystem.dao.exception.DataBaseSqlRuntimeException;
import testingsystem.dao.pagination.Page;
import testingsystem.dao.pagination.PageRequest;
import testingsystem.entity.User;

import java.util.Optional;

public interface UserDao extends CrudDao<User> {
    Optional<User> findByEmail(String email) throws DataBaseSqlRuntimeException;
    Page findAll(PageRequest pageRequest);
}
