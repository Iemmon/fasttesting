package quizsystem.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import quizsystem.dao.ResultDao;
import quizsystem.entity.Result;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ResultServiceImplTest {

    @Mock
    private ResultDao resultDao;

    @InjectMocks
    private ResultServiceImpl resultService;

    @Test
    public void getAllResults() {
        List<Result> results = new ArrayList<>();
        when(resultDao.findAllByUserId(any(Long.class))).thenReturn(results);
        assertSame(results, resultService.getAllResults(5L));
    }
}
