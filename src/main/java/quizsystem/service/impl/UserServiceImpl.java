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
    private final UserDao userRepository;
    private final PasswordEncryption passwordEncryption;
    private final Validator<User> userValidator;

    public UserServiceImpl(UserDao userRepository, PasswordEncryption passwordEncryption,
                           Validator<User> userValidator) {
        this.userRepository = userRepository;
        this.passwordEncryption = passwordEncryption;
        this.userValidator = userValidator;
    }

    @Override
    public Optional<User> login(String email, String password) {
        if (!userValidator.validateEmail(email)) {
            return Optional.empty();
        }
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            String encryptPassword = passwordEncryption.encrypt(password);
            if (user.get().getPassword().contentEquals(encryptPassword)) {
                return user;
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> register(String email, String password) {
        if (userValidator.validateEmail(email) && userValidator.validatePassword(password) && !userRepository.findByEmail(email).isPresent()) {
            String encryptPassword = passwordEncryption.encrypt(password);
            User userToSave = User.builder()
                    .withEmail(email)
                    .withPassword(encryptPassword)
                    .withRole(Role.STUDENT)
                    .build();
            userRepository.save(userToSave);
            return Optional.of(userToSave);
        }
        return Optional.empty();
    }

    @Override
    public Page<User> findAll(String page, int itemsPerPage) {
        PageRequest pageRequest = PageRequestParser.parseIntoPageRequest(page, itemsPerPage, userRepository.count());
        return userRepository.findAll(pageRequest);
    }
}
