package quizsystem.injector;

import quizsystem.dao.*;
import quizsystem.dao.connectionpool.ConnectionPool;
import quizsystem.dao.connectionpool.HikariCPDataSource;
import quizsystem.dao.impl.*;
import quizsystem.entity.User;
import quizsystem.service.*;
import quizsystem.service.encryptor.PasswordEncryption;
import quizsystem.service.impl.*;
import quizsystem.service.validator.UserValidator;
import quizsystem.service.validator.Validator;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ApplicationInjector {

    private static final ApplicationInjector INSTANCE = new ApplicationInjector();

    private static final Validator<User> USER_VALIDATOR = new UserValidator();

    private static final PasswordEncryption PASSWORD_ENCRYPTION = new PasswordEncryption();

    private static final ResourceBundle RESOURCE_FILE = PropertyResourceBundle.getBundle("properties");

    private static final ConnectionPool DATA_SOURCE = new HikariCPDataSource();

    private static final UserDao USER_DAO = new UserDaoImpl(DATA_SOURCE);

    private static final TopicDao TOPIC_DAO = new TopicDaoImpl(DATA_SOURCE);

    private static final TestDao TEST_DAO = new TestDaoImpl(DATA_SOURCE);

    private static final QuestionDao QUESTION_DAO = new QuestionDaoImpl(DATA_SOURCE);

    private static final ResultDao RESULT_DAO = new ResultDaoImpl(DATA_SOURCE);

    private static final UserService USER_SERVICE = new UserServiceImpl(USER_DAO, PASSWORD_ENCRYPTION, USER_VALIDATOR);

    private static final TopicService TOPIC_SERVICE = new TopicServiceImpl(TOPIC_DAO);

    private static final TestService TEST_SERVICE = new TestServiceImpl(TEST_DAO);

    private static final QuestionService QUESTION_SERVICE = new QuestionServiceImpl(QUESTION_DAO);

    private static final ResultService RESULT_SERVICE = new ResultServiceImpl(RESULT_DAO);

    private ApplicationInjector() {
    }

    public static ApplicationInjector getInstance() {
        return INSTANCE;
    }

    public UserService getUserService() {
        return USER_SERVICE;
    }

    public TopicService getTopicService() {
        return TOPIC_SERVICE;
    }

    public TestService getTestService() {
        return TEST_SERVICE;
    }

    public QuestionService getQuestionService() {
        return QUESTION_SERVICE;
    }

    public ResourceBundle getResourceBundle() {
        return RESOURCE_FILE;
    }

    public ResultService getResultService(){
        return RESULT_SERVICE;
    }
}
