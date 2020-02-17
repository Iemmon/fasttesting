package quizsystem.service;

import quizsystem.dao.pagination.Page;
import quizsystem.dao.pagination.PageRequest;
import quizsystem.entity.Test;

import java.util.List;

public interface TestService {

    List<Test> findAllByTopicId(Long id);
    Page<Test> findAllByTopicId(Long topicId, String page, int itemsPerPage);
    
}
