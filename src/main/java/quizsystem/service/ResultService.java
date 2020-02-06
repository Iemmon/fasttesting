package quizsystem.service;

import quizsystem.entity.Result;

import java.util.List;

public interface ResultService {

    List<Result> getAllResults(Long id);

    void saveResult(Result result);
}
