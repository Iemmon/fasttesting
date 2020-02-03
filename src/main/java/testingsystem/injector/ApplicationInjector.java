package testingsystem.injector;

import testingsystem.dao.TestDao;
import testingsystem.dao.TopicDao;
import testingsystem.dao.connectionpool.ConnectionPool;
import testingsystem.dao.connectionpool.HikariCPDataSource;
import testingsystem.dao.impl.QuestionDaoImpl;
import testingsystem.dao.impl.TestDaoImpl;
import testingsystem.dao.impl.TopicDaoImpl;
import testingsystem.dao.impl.UserDaoImpl;
import testingsystem.dao.QuestionDao;
import testingsystem.dao.UserDao;
import testingsystem.entity.Topic;
import testingsystem.entity.User;
import testingsystem.service.QuestionService;
import testingsystem.service.TestService;
import testingsystem.service.TopicService;
import testingsystem.service.encryptor.PasswordEncryption;
import testingsystem.service.impl.QuestionServiceImpl;
import testingsystem.service.impl.TestServiceImpl;
import testingsystem.service.impl.TopicServiceImpl;
import testingsystem.service.impl.UserServiceImpl;
import testingsystem.service.UserService;
import testingsystem.service.validator.UserValidator;
import testingsystem.service.validator.Validator;

public class ApplicationInjector {

    private static final ApplicationInjector INSTANCE = new ApplicationInjector();

    private static final Validator<User> USER_VALIDATOR = new UserValidator();

    private static final PasswordEncryption PASSWORD_ENCRYPTION = new PasswordEncryption();

    private static final ConnectionPool DATA_SOURCE = new HikariCPDataSource();

    //    TODO: Change to private
    public static final UserDao USER_DAO = new UserDaoImpl(DATA_SOURCE);

    public static final TopicDao TOPIC_DAO = new TopicDaoImpl(DATA_SOURCE);
    public static final TestDao TEST_DAO = new TestDaoImpl(DATA_SOURCE);
    public static final QuestionDao QUESTION_DAO = new QuestionDaoImpl(DATA_SOURCE);


    private static final UserService USER_SERVICE = new UserServiceImpl(USER_DAO, PASSWORD_ENCRYPTION, USER_VALIDATOR);
    private static final TopicService TOPIC_SERVICE = new TopicServiceImpl(TOPIC_DAO);
    private static final TestService TEST_SERVICE = new TestServiceImpl(TEST_DAO);
    private static final QuestionService QUESTION_SERVICE = new QuestionServiceImpl(QUESTION_DAO);


    private ApplicationInjector() {
    }

    public static ApplicationInjector getInstance() {
        return INSTANCE;
    }

    public static UserService getUserService() {
        return USER_SERVICE;
    }

    public static TopicService getTopicService() {
        return TOPIC_SERVICE;
    }

    public static TestService getTestService() {
        return TEST_SERVICE;
    }
    public static QuestionService getQuestionService(){
        return QUESTION_SERVICE;
    }

}
