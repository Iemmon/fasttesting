package quizsystem.service;

import quizsystem.dao.exception.DataBaseSqlRuntimeException;
import quizsystem.dao.pagination.Page;
import quizsystem.dao.pagination.PageRequest;
import quizsystem.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> login(String email, String password) throws DataBaseSqlRuntimeException;

    Optional<User> register(String email, String password) throws DataBaseSqlRuntimeException;

    Page<User> findAll(PageRequest pageRequest);
}
