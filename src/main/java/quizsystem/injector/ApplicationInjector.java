package quizsystem.injector;

import quizsystem.command.*;
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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import static java.util.ResourceBundle.getBundle;

public class ApplicationInjector {

    private static final ApplicationInjector INSTANCE = new ApplicationInjector();

    private static final Validator<User> USER_VALIDATOR = new UserValidator();

    private static final PasswordEncryption PASSWORD_ENCRYPTION = new PasswordEncryption();

    private static final ResourceBundle RESOURCE_FILE = getBundle("properties");

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

    private static final Command LOGIN_COMMAND = new LoginUserCommand(USER_SERVICE);

    private static final Command LOGOUT_COMMAND = new LogoutCommand();

    private static final Command REGISTER_COMMAND = new RegisterCommand(USER_SERVICE);

    private static final Command USER_RESULTS_COMMAND = new UserResultsCommand(RESULT_SERVICE);

    private static final Command CALCULATE_RESULT_COMMAND = new CalculateResultCommand(QUESTION_SERVICE, RESULT_SERVICE);

    private static final Command TEST_COMMAND = new TestCommand(TEST_SERVICE);

    private static final Command USER_COMMAND = new UserCommand(RESOURCE_FILE, USER_SERVICE);

    private static final Command QUESTIONS_COMMAND = new LoadQuestionsCommand(QUESTION_SERVICE);

    private static final Command VIEW_LOGIN_COMMAND = new LoginViewCommand();

    private static final Command VIEW_REGISTER_COMMAND = new RegisterViewCommand();

    private static final Command TOPIC_COMMAND = new TopicCommand(TOPIC_SERVICE);

    private static final Command HOME_COMMAND = new HomeCommand();

    private static final Map<String, Command> COMMAND_NAME_TO_COMMAND = initUserCommand();

    private static Map<String, Command> initUserCommand() {
        Map<String, Command> commandMap = new HashMap<>();
        commandMap.put("register", VIEW_REGISTER_COMMAND);
        commandMap.put("login", VIEW_LOGIN_COMMAND);
        commandMap.put("processlogin", LOGIN_COMMAND);
        commandMap.put("logout", LOGOUT_COMMAND);
        commandMap.put("results", USER_RESULTS_COMMAND);
        commandMap.put("processregister", REGISTER_COMMAND);
        commandMap.put("result", CALCULATE_RESULT_COMMAND);
        commandMap.put("tests", TEST_COMMAND);
        commandMap.put("users", USER_COMMAND);
        commandMap.put("questions", QUESTIONS_COMMAND);
        commandMap.put("topics", TOPIC_COMMAND);
        commandMap.put("home", HOME_COMMAND);

        return Collections.unmodifiableMap(commandMap);
    }

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

    public Map<String, Command> getCommands(){
        return COMMAND_NAME_TO_COMMAND;
    }

}
