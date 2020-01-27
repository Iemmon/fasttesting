package testingsystem.injector;

import testingsystem.database.ConnectionPool;
import testingsystem.database.HikariCPDataSource;
import testingsystem.database.dao.implementation.UserDaoImpl;
import testingsystem.database.dao.interfacepack.UserDao;
import testingsystem.domain.User;
import testingsystem.service.PasswordEncryption;
import testingsystem.service.implementation.UserServiceImpl;
import testingsystem.service.interfacepack.UserService;
import testingsystem.service.validator.UserValidator;
import testingsystem.service.validator.Validator;

import java.sql.Connection;

public class ApplicationInjector {

    private static final ApplicationInjector INSTANCE = new ApplicationInjector();

    private static final Validator<User> USER_VALIDATOR = new UserValidator();

    private static final PasswordEncryption PASSWORD_ENCRYPTION = new PasswordEncryption();

    private static final ConnectionPool DATA_SOURCE = new HikariCPDataSource();

    private static final UserDao USER_DAO = new UserDaoImpl(DATA_SOURCE);

    private static final UserService USER_SERVICE = new UserServiceImpl(USER_DAO, PASSWORD_ENCRYPTION, USER_VALIDATOR);

    private ApplicationInjector() {

    }

    public static ApplicationInjector getInstance() {
        return INSTANCE;
    }

    public static UserService getUserService() {
        return USER_SERVICE;
    }
}
