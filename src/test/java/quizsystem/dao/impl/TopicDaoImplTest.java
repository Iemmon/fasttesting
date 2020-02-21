package quizsystem.dao.impl;

import org.junit.Before;
import org.junit.Test;
import quizsystem.entity.Topic;
import quizsystem.injector.ApplicationInjector;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.Assert.*;

public class TopicDaoImplTest {

    private TopicDaoImpl topicDaoObject;

    @Before
    public void setup() throws NoSuchFieldException, IllegalAccessException {
        Class<ApplicationInjector> injectorClass = ApplicationInjector.class;
        Field topicDao = injectorClass.getDeclaredField("TOPIC_DAO");
        topicDao.setAccessible(true);
        topicDaoObject = (TopicDaoImpl) topicDao.get(null);
    }

    @Test
    public void testIfFindByTopicIdReturnsList(){
        List<Topic> topic = topicDaoObject.findAll();
        assertEquals(2, topic.size());
    }
}