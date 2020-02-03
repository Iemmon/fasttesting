package testingsystem.service;

import testingsystem.dao.exception.DataBaseSqlRuntimeException;
import testingsystem.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> login(String email, String password) throws DataBaseSqlRuntimeException;

    Optional<User> register(User user) throws DataBaseSqlRuntimeException;

    List<User> findAll();
}
