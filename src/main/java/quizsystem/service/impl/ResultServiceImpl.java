package quizsystem.service.impl;

import quizsystem.dao.ResultDao;
import quizsystem.entity.Result;
import quizsystem.service.ResultService;

import java.util.List;

public class ResultServiceImpl implements ResultService {
    private final ResultDao resultDao;

    public ResultServiceImpl(ResultDao resultDao) {
        this.resultDao = resultDao;
    }

    @Override
    public List<Result> getAllResults(Long user) {
        return resultDao.findAllByUserId(user);
    }
}
