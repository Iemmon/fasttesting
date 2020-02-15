package quizsystem.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import quizsystem.entity.Question;
import quizsystem.entity.Role;
import quizsystem.entity.User;
import quizsystem.injector.ApplicationInjector;

import java.lang.reflect.Field;
import java.sql.ResultSet;

import static org.junit.Assert.assertNotNull;

public class QuestionDaoImplTest {
    Class<ApplicationInjector> injectorClass;
    Field questionDao;
    QuestionDaoImpl questionDaoObject;

    @Mock
    ResultSet resultSet;

    @Before
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        injectorClass = ApplicationInjector.class;
        questionDao = injectorClass.getDeclaredField("QUESTION_DAO");
        questionDao.setAccessible(true);
        questionDaoObject = (QuestionDaoImpl) questionDao.get(null);
        //to create field, object which contains this field is needed
    }

    @Test
    public void saveShouldSaveQuestionToDB() {
        Question question = new Question("Question text");
        Question savedResult = questionDaoObject.save(question);

        assertNotNull(savedResult.getId());
    }

    @Test
    public void findAllByTestId() {
    }

    @Test
    public void mapResultSetToEntityShouldReturnQuestion() {
    }
}