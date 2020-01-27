package testingsystem.service.interfacepack;

import testingsystem.domain.Result;
import testingsystem.domain.Test;
import testingsystem.domain.User;

import java.util.List;

public interface ResultService {

    Result add(Test test, User user, int score);

    List<Result> getAllResults(User user);

}
