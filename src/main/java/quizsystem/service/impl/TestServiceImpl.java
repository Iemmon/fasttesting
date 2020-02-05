package quizsystem.service.impl;

import quizsystem.dao.TestDao;
import quizsystem.entity.Test;
import quizsystem.service.TestService;

import java.util.List;

public class TestServiceImpl implements TestService {

    private final TestDao testDao;

    public TestServiceImpl(TestDao testDao) {
        this.testDao = testDao;
    }

    @Override
    public List<Test> findAllByTopicId(Long id) {
        return testDao.findAllByTopicId(id);
    }
}
