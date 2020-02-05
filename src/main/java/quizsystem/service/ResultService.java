package quizsystem.service;

import quizsystem.entity.Result;
import quizsystem.entity.User;

import java.util.List;

public interface ResultService {

    List<Result> getAllResults(Long id);

}
