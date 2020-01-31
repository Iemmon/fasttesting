package testingsystem.dao;

import testingsystem.entity.Test;

import java.util.List;

public interface TestDao extends CrudDao<Test> {
    List<Test> findAllByTopicId(Long topicId);
}
