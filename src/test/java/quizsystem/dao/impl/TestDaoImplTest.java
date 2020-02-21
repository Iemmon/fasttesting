package quizsystem.dao.impl;

import org.junit.Before;
import org.junit.Test;
import quizsystem.injector.ApplicationInjector;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestDaoImplTest {

    private TestDaoImpl testDaoObject;

    @Before
    public void setup() throws NoSuchFieldException, IllegalAccessException {
        Class<ApplicationInjector> injectorClass = ApplicationInjector.class;
        Field testDao = injectorClass.getDeclaredField("TEST_DAO");
        testDao.setAccessible(true);
        testDaoObject = (TestDaoImpl) testDao.get(null);
    }

    @Test
    public void testIfFindByTopicIdReturnsList(){
        List<quizsystem.entity.Test> tests = testDaoObject.findAllByTopicId(1L);
        assertEquals(2, tests.size());
    }
}
