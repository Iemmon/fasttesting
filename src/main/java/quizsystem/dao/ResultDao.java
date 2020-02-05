package quizsystem.dao;

import quizsystem.entity.Result;

import java.util.List;

public interface ResultDao extends CrudDao<Result> {

    List<Result> findAllByUserId(Long id);
}
