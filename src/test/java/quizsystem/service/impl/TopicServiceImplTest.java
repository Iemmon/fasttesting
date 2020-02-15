package quizsystem.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import quizsystem.dao.TopicDao;
import quizsystem.entity.Topic;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TopicServiceImplTest {

    @Mock
    private TopicDao topicDao;

    @InjectMocks
    private TopicServiceImpl topicService;

    @Test
    public void findAllShouldReturnAllTopics() {
        List<Topic> topicList = new ArrayList<>();

        assertEquals(topicList, topicService.findAll());
        verify(topicDao, times(1)).findAll();
    }
}