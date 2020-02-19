package quizsystem.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import quizsystem.dao.ResultDao;
import quizsystem.dao.pagination.Page;
import quizsystem.dao.pagination.PageRequest;
import quizsystem.entity.Result;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ResultServiceImplTest {

    @Mock
    private ResultDao resultDao;

    @InjectMocks
    private ResultServiceImpl resultService;

    @Test
    public void getAllResults() {
        Page<Result> results = mock(Page.class);
        when(resultDao.countByUserId(anyLong())).thenReturn(16L);
        when(resultDao.findAllByUserId(any(Long.class), any(PageRequest.class))).thenReturn(results);

        assertSame(results, resultService.getAllResults(5L, "1", 5));
    }

    @Test
    public void saveShouldSaveResultToDB(){
        Result result = mock(Result.class);

        resultService.saveResult(result);
        verify(resultDao).save(eq(result));
    }
}
