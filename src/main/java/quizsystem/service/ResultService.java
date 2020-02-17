package quizsystem.service;

import quizsystem.dao.pagination.Page;
import quizsystem.entity.Result;

import java.util.List;

public interface ResultService {

   // List<Result> getAllResults(Long id);

    void saveResult(Result result);

    Page<Result> getAllResults(Long user, String page, int itemsPerPage);
}
