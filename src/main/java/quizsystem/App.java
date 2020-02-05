package quizsystem;

import quizsystem.dao.pagination.Page;
import quizsystem.dao.pagination.PageRequest;
import quizsystem.entity.User;
import quizsystem.injector.ApplicationInjector;

public class App {
    public static void main(String[] args) {
        Page<User> users = ApplicationInjector.getInstance().getUserService().findAll(new PageRequest(0, 20));
        System.out.println("items per page " + users.getItemsPerPage());
        System.out.println("max page number " + users.getMaxPageNumber());
        System.out.println("page number " + users.getPageNumber());
        for (User u : users.getItems()){
            System.out.println(u);
        }

    }
}

