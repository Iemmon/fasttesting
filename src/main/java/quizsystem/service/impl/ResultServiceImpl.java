package quizsystem.service.impl;

import quizsystem.dao.ResultDao;
import quizsystem.dao.pagination.Page;
import quizsystem.dao.pagination.PageRequest;
import quizsystem.dao.pagination.PageRequestParser;
import quizsystem.entity.Result;
import quizsystem.service.ResultService;

import java.util.List;

public class ResultServiceImpl implements ResultService {
    private final ResultDao resultDao;

    public ResultServiceImpl(ResultDao resultDao) {
        this.resultDao = resultDao;
    }

    public void saveResult(Result result){
        resultDao.save(result);
    }

    @Override
    public Page<Result> getAllResults(Long userId, String page, int itemsPerPage) {
        PageRequest pageRequest = PageRequestParser.parseIntoPageRequest(page, resultDao.countByUserId(userId));
        return resultDao.findAllByUserId(userId, pageRequest);
    }
}