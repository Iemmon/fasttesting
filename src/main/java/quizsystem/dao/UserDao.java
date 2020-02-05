package quizsystem.dao;

import quizsystem.dao.exception.DataBaseSqlRuntimeException;
import quizsystem.dao.pagination.Page;
import quizsystem.dao.pagination.PageRequest;
import quizsystem.entity.User;

import java.util.Optional;

public interface UserDao extends CrudDao<User> {
    Optional<User> findByEmail(String email) throws DataBaseSqlRuntimeException;
    Page findAll(PageRequest pageRequest);
}
