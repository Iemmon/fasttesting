package testingsystem.service;

import testingsystem.entity.Result;
import testingsystem.entity.Test;
import testingsystem.entity.User;

import java.util.List;

public interface ResultService {

    Result add(Test test, User user, int score);

    List<Result> getAllResults(User user);

}
