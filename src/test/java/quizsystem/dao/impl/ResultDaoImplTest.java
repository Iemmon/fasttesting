package quizsystem.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import quizsystem.entity.Result;
import quizsystem.injector.ApplicationInjector;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ResultDaoImplTest {

    private ResultDaoImpl resultDaoObject;

    @Mock
    ResultSet resultSet;

    @Before
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        Class<ApplicationInjector> injectorClass = ApplicationInjector.class;
        Field resultDao = injectorClass.getDeclaredField("RESULT_DAO");
        resultDao.setAccessible(true);
        resultDaoObject = (ResultDaoImpl) resultDao.get(null);
    }

    @Test
    public void saveShouldReturnResultWithId() {
        Result result = new Result(10, new quizsystem.entity.Test(1L, "Test"), 1L);
        Result savedResult = resultDaoObject.save(result);

        assertNotNull(savedResult.getId());
    }

    @Test
    public void findAllByUserIdShouldReturnListOfResults() {
        List<Result> resultList = resultDaoObject.findAllByUserId(1L);
        assertTrue(resultList.size() > 0);
    }

    @Test
    public void mapResultSetToEntityShouldReturnResult() throws SQLException {
        when(resultSet.getString("name")).thenReturn("Test");
        when(resultSet.getLong("test_id")).thenReturn(1L);
        when(resultSet.getLong("id")).thenReturn(1L);
        when(resultSet.getInt(eq("score"))).thenReturn(10);
        when(resultSet.getLong("user_id")).thenReturn(1L);

        quizsystem.entity.Test test = new quizsystem.entity.Test(1L, "Test");
        Result result = new Result(1L, 10, new quizsystem.entity.Test(1L, "Test"), 1L);

        assertEquals(result, resultDaoObject.mapResultSetToEntity(resultSet));
    }
}