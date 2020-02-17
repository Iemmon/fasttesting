package quizsystem.dao;

import quizsystem.dao.pagination.Page;
import quizsystem.dao.pagination.PageRequest;
import quizsystem.entity.Result;

import java.util.List;

public interface ResultDao extends CrudDao<Result> {

    List<Result> findAllByUserId(Long id);

    Page<Result> findAllByUserId(Long id, PageRequest pageRequest);

    Long countByUserId(Long userId);
}
