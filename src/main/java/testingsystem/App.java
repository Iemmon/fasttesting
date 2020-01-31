package testingsystem;

import testingsystem.dao.pagination.Page;
import testingsystem.dao.pagination.PageRequest;
import testingsystem.entity.Question;
import testingsystem.entity.Role;
import testingsystem.entity.User;
import testingsystem.injector.ApplicationInjector;
import testingsystem.service.UserService;

import java.util.List;
import java.util.Optional;

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

        Page page = ApplicationInjector.USER_DAO.findAll(new PageRequest(1, 10));
        System.out.println("items per page " + page.getItemsPerPage());
        System.out.println("count "+ ApplicationInjector.USER_DAO.count());
        System.out.println("max page number " + page.getMaxPageNumber());
        System.out.println(userService.login("hrbfosd@gmail.com", "Re1iab1ePa$$"));
       Optional<Question> question = ApplicationInjector.QUESTION_DAO.findById(1L);
        List<Question> listOfQuestions = ApplicationInjector.QUESTION_DAO.findAllByTestId(1L);

        for(Question q : listOfQuestions){
            System.out.println(q.toString());
        }

//        System.out.println(question.get().getMultiChoice().get(0).getAnswerOption());
//        System.out.println(question.get().getMultiChoice().get(0).isCorrect());
    }
}

