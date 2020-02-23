package quizsystem.service.impl;

import quizsystem.dao.UserDao;
import quizsystem.dao.pagination.Page;
import quizsystem.dao.pagination.PageRequest;
import quizsystem.dao.pagination.PageRequestParser;
import quizsystem.entity.Role;
import quizsystem.entity.User;
import quizsystem.service.UserService;
import quizsystem.service.encryptor.PasswordEncryption;
import quizsystem.service.validator.Validator;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final PasswordEncryption passwordEncryption;
    private final Validator<User> userValidator;

    public UserServiceImpl(UserDao userDao, PasswordEncryption passwordEncryption,
                           Validator<User> userValidator) {
        this.userDao = userDao;
        this.passwordEncryption = passwordEncryption;
        this.userValidator = userValidator;
    }

    @Override
    public Optional<User> login(String email, String password) {

        Optional<User> user = userDao.findByEmail(email);
        if (user.isPresent()) {
            String encryptPassword = passwordEncryption.encrypt(password);
            if (user.get().getPassword().contentEquals(encryptPassword)) {
                return user;
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> register(String email, String password, String confirmedPass) {

        if (    userValidator.validatePasswordsAreSimilar(password, confirmedPass)
                && userValidator.validateEmail(email)
                && userValidator.validatePassword(password)
                && !userDao.findByEmail(email).isPresent()         ) {
            String encryptPassword = passwordEncryption.encrypt(password);
            User userToSave = User.builder()
                    .withEmail(email)
                    .withPassword(encryptPassword)
                    .withRole(Role.STUDENT)
                    .build();
            return Optional.of(userDao.save(userToSave));
        }
        return Optional.empty();
    }

    @Override
    public Page<User> findAll(String page, int itemsPerPage) {
        PageRequest pageRequest = PageRequestParser.parseIntoPageRequest(page, userDao.count());
        return userDao.findAll(pageRequest);
    }
}
