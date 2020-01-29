package testingsystem.service.interfacepack;

import testingsystem.dao.exception.DataBaseSqlRuntimeException;
import testingsystem.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    boolean login(String email, String password) throws DataBaseSqlRuntimeException;

    Optional<Object> register(User user) throws DataBaseSqlRuntimeException;

    List<User> findAll();
}
