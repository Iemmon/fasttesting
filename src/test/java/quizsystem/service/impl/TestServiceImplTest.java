package quizsystem.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import quizsystem.dao.TestDao;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestServiceImplTest {

    private static final Long TEST_ID = 1L;

    @Mock
    private TestDao testDao;

    @InjectMocks
    private TestServiceImpl testService;

    @Test
    public void findAllByTopicIdShouldReturnList() {

        List<quizsystem.entity.Test> listOfTests = new ArrayList<>();
        when(testDao.findAllByTopicId(TEST_ID)).thenReturn(listOfTests);

        assertEquals(listOfTests, testService.findAllByTopicId(TEST_ID));
    }
}