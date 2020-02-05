package quizsystem.dao;

import quizsystem.entity.Test;

import java.util.List;

public interface TestDao extends CrudDao<Test> {
    List<Test> findAllByTopicId(Long topicId);
}
