package quizsystem.dao.impl;

import org.junit.Before;
import org.junit.Test;
import quizsystem.dao.pagination.Page;
import quizsystem.dao.pagination.PageRequest;
import quizsystem.entity.Result;
import quizsystem.entity.Role;
import quizsystem.entity.User;
import quizsystem.injector.ApplicationInjector;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
    public void saveShouldReturnUserWithId() {
        User user = User.builder().withEmail("email@gmail.com").withPassword("alreadyEncryptedPass").withRole(Role.STUDENT).build();
        User savedResult = userDaoObject.save(user);

        assertNotNull(savedResult.getUserId());
    }

    @Test
    public void testCountMethodReturnsNumOfEntities() {
        assertEquals(16, userDaoObject.count());
    }

    @Test
    public void testFindAllUsersWithPaginationShouldReturnPage(){
        Page page = userDaoObject.findAll(new PageRequest(2, 5, 16));
        assertEquals(2, page.getPageNumber());
        assertEquals(5, page.getItemsPerPage());
        assertEquals(16, page.getMaxPageNumber());
    }

    @Test
    public void testSaveShouldSaveUserToDB(){
        User user = User.builder()
                .withEmail("username@bla.bla")
                .withPassword("QWERTY")
                .withRole(Role.STUDENT)
                .build();
        User user1 = userDaoObject.save(user);
        assertEquals(17L, (long) user1.getUserId());
    }

    @Test
    public void testFindUserByEmailShouldReturnUser(){
        User user = userDaoObject.findByEmail("roman@yahoo.com").get();
        assertEquals(7L, (long)user.getUserId());
    }
}
