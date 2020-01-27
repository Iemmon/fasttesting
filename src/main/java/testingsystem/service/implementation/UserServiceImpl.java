package testingsystem.service.implementation;

import testingsystem.database.dao.interfacepack.UserDao;
import testingsystem.domain.User;
import testingsystem.service.PasswordEncryption;
import testingsystem.service.interfacepack.UserService;
import testingsystem.service.validator.Validator;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserDao userRepository;
    private final PasswordEncryption passwordEncryption;
    private final Validator<User> userValidator;
    private final int USERS_PER_PAGE = 5;

    public UserServiceImpl(UserDao userRepository, PasswordEncryption passwordEncryption,
                           Validator<User> userValidator) {
        this.userRepository = userRepository;
        this.passwordEncryption = passwordEncryption;
        this.userValidator = userValidator;
    }

    @Override
    public boolean login(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            String encryptPassword = passwordEncryption.encrypt(password, user.get().getSalt());
            return user.get().getPassword().contentEquals(encryptPassword);
        }
        return false;
    }

    @Override
    public Optional<Object> register(User user) {
        if (userValidator.validate(user) && !userRepository.findByEmail(user.getEmail()).isPresent()) {
            String encryptPassword = passwordEncryption.encrypt(user.getPassword(), user.getSalt());
            user.setPassword(encryptPassword);
            userRepository.save(user);
            return Optional.of(user);
        }
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
