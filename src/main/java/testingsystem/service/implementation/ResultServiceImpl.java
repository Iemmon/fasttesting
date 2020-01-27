package testingsystem.service.implementation;

import testingsystem.domain.Result;
import testingsystem.domain.Test;
import testingsystem.domain.User;
import testingsystem.service.interfacepack.ResultService;

import java.util.List;

public class ResultServiceImpl implements ResultService {
    @Override
    public Result add(Test test, User user, int score) {
        return null;
    }

    @Override
    public List<Result> getAllResults(User user) {
        return null;
    }
}
