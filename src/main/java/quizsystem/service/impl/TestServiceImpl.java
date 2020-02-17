package quizsystem.service.impl;

import quizsystem.dao.TestDao;
import quizsystem.dao.pagination.Page;
import quizsystem.dao.pagination.PageRequest;
import quizsystem.dao.pagination.PageRequestParser;
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

    @Override
    public Page<Test> findAllByTopicId(Long topicId, String page, int itemsPerPage){
        PageRequest pageRequest = PageRequestParser.parseIntoPageRequest(page, testDao.count());
        return testDao.findAllByTopicId(topicId, pageRequest);
    }
}
