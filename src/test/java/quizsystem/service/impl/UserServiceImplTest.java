package quizsystem.service.impl;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import quizsystem.dao.UserDao;
import quizsystem.entity.User;
import quizsystem.service.encryptor.PasswordEncryption;
import quizsystem.service.validator.Validator;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
    private static final String ENCODED_PASSWORD = "encoded_password";
    private static final String PASSWORD = "password";
    private static final String USER_EMAIL = "user@gmail.com";
    private static final String INCORRECT_PASSWORD = "INCORRECT_PASSWORD";
    private static final String ENCODE_INCORRECT_PASSWORD = "encode_incorrect_password";

    private final User USER = User.builder()
            .withEmail(USER_EMAIL)
            .withPassword(ENCODED_PASSWORD)
            .build();

    @Mock
    private UserDao userDao;
    @Mock
    private PasswordEncryption passwordEncryption;
    @Mock
    private Validator<User> userValidator;

    @InjectMocks
    private UserServiceImpl userService;

    @After
    public void resetMocks() {
        reset(userDao, passwordEncryption, userValidator);
    }

    @Test
    public void userShouldLoginSuccessfully() {
        when(passwordEncryption.encrypt(eq(PASSWORD))).thenReturn(ENCODED_PASSWORD);
        when(userDao.findByEmail(anyString())).thenReturn(Optional.of(USER));
        when(userValidator.validateEmail(USER_EMAIL)).thenReturn(true);

        Optional<User> loggedInUser = userService.login(USER_EMAIL, PASSWORD);
        assertTrue(loggedInUser.isPresent());

        verify(passwordEncryption).encrypt(eq(PASSWORD));
        verify(userDao).findByEmail(eq(USER_EMAIL));
    }

    @Test
    public void userShouldNotLoginAsThereIsNotUserWithSuchEmail() {
        when(passwordEncryption.encrypt(eq(PASSWORD))).thenReturn(ENCODED_PASSWORD);
        when(userDao.findByEmail(anyString())).thenReturn(Optional.empty());
        when(userValidator.validateEmail(USER_EMAIL)).thenReturn(true);

        Optional<User> loggedInUser = userService.login(USER_EMAIL, PASSWORD);
        assertFalse(loggedInUser.isPresent());

        verify(passwordEncryption, times(0)).encrypt(eq(PASSWORD));
        verify(userDao).findByEmail(eq(USER_EMAIL));
    }

    @Test
    public void userShouldNotLoginAsPasswordIsIncorrect() {
        when(passwordEncryption.encrypt(eq(INCORRECT_PASSWORD))).thenReturn(ENCODE_INCORRECT_PASSWORD);
        when(userDao.findByEmail(eq(USER_EMAIL))).thenReturn(Optional.of(USER));
        when(userValidator.validateEmail(USER_EMAIL)).thenReturn(true);

        Optional<User> loggedInUser = userService.login(USER_EMAIL, INCORRECT_PASSWORD);
        assertFalse(loggedInUser.isPresent());

        verify(passwordEncryption).encrypt(eq(INCORRECT_PASSWORD));
        verify(userDao).findByEmail(eq(USER_EMAIL));
    }

    @Test
    public void userShouldRegisterSuccessfully() {
        when(userValidator.validateEmail(USER_EMAIL)).thenReturn(true);
        when(userValidator.validatePassword(PASSWORD)).thenReturn(true);
        when(userDao.findByEmail(anyString())).thenReturn(Optional.empty());
        when(passwordEncryption.encrypt(PASSWORD)).thenReturn(ENCODED_PASSWORD);
        when(userDao.save(any(User.class))).thenReturn(any(User.class));

        Optional<User> registeredUser = userService.register(USER_EMAIL, PASSWORD);
        assertTrue(registeredUser.isPresent());

        verify(userDao).findByEmail(anyString());
        verify(userDao).save(registeredUser.get());
    }

    @Test
    public void userShouldNotRegisterWithInvalidPasswordOrEmail() {
        when(userValidator.validateEmail(USER_EMAIL)).thenReturn(false);
        when(userValidator.validatePassword(PASSWORD)).thenReturn(false);

        Optional<User> registeredUser = userService.register(USER_EMAIL, PASSWORD);
        assertFalse(registeredUser.isPresent());

        verify(userDao, times(0)).findByEmail((anyString()));
        verify(passwordEncryption, times(0)).encrypt(anyString());
        verify(userDao, times(0)).save(any(User.class));
    }

    @Test
    public void userShouldNotRegisterAsEmailIsAlreadyUsed() {
        when(userValidator.validate(any(User.class))).thenReturn(true);
        when(userDao.findByEmail(anyString())).thenReturn(Optional.of(USER));
        when(userDao.save(any(User.class))).thenReturn(any(User.class));

        Optional<User> registeredUser = userService.register(USER_EMAIL, PASSWORD);
        assertFalse(registeredUser.isPresent());

        verify(userDao, times(0)).save(any(User.class));
    }
}
