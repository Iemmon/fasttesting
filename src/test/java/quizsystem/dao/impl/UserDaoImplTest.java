package quizsystem.dao.impl;

import org.junit.Before;
import org.junit.Test;
import quizsystem.dao.pagination.Page;
import quizsystem.dao.pagination.PageRequest;
import quizsystem.entity.Role;
import quizsystem.entity.User;
import quizsystem.injector.ApplicationInjector;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class UserDaoImplTest {

    Class<ApplicationInjector> injectorClass;
    Field userDao;
    UserDaoImpl userDaoObject;

    @Before
    public void setup() throws NoSuchFieldException, IllegalAccessException {
        injectorClass = ApplicationInjector.class;
        userDao = injectorClass.getDeclaredField("USER_DAO");
        userDao.setAccessible(true);
        userDaoObject = (UserDaoImpl) userDao.get(null);
    }

    @Test
    public void testCountMethod() {
        assertEquals(16, userDaoObject.count());
    }

    @Test
    public void testFindAllUsersWithPagination(){
        Page page = userDaoObject.findAll(new PageRequest(2, 5, 16));
        assertEquals(2, page.getPageNumber());
        assertEquals(5, page.getItemsPerPage());
        assertEquals(16, page.getMaxPageNumber());
        assertEquals(5, page.getItems().size());
    }

    @Test
    public void testIfUserIsSavedToDB(){
        User user = User.builder()
                .withEmail("username@bla.bla")
                .withPassword("QWERTY")
                .withRole(Role.STUDENT)
                .build();
        User user1 = userDaoObject.save(user);
        assertEquals(17L, (long) user1.getUserId());
    }

    @Test
    public void testFindUserByEmail(){
        User user = userDaoObject.findByEmail("roman@yahoo.com").get();
        assertEquals(7L, (long)user.getUserId());
    }
}
