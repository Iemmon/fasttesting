package testingsystem;

import testingsystem.database.HikariCPDataSource;
import testingsystem.domain.Role;
import testingsystem.domain.User;
import testingsystem.injector.ApplicationInjector;
import testingsystem.service.PasswordEncryption;
import testingsystem.service.implementation.UserServiceImpl;
import testingsystem.service.interfacepack.UserService;

import java.sql.Connection;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws Exception {
        UserService userService = ApplicationInjector.getUserService();
        User user = User.builder()
                .withEmail("hrbfosd@gmail.com")
                .withPassword ("Re1iab1ePa$$")
                .withRole(Role.STUDENT)
                .build();
        if(userService.register(user).isPresent()){
            System.out.println("signed up");
        } else {
            System.out.println("fail");
        }
        System.out.println(userService.login("hrbfosd@gmail.com", "Re1iab1ePa$$"));

    }

}

