package testingsystem.service.impl;

import testingsystem.dao.TestDao;
import testingsystem.entity.Test;
import testingsystem.service.TestService;

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
