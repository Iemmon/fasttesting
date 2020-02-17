package quizsystem.dao;

import quizsystem.dao.pagination.Page;
import quizsystem.dao.pagination.PageRequest;
import quizsystem.entity.Test;

import java.util.List;

public interface TestDao extends CrudDao<Test> {
    List<Test> findAllByTopicId(Long topicId);

    Page<Test> findAllByTopicId(Long topicId, PageRequest pageRequest);
}
