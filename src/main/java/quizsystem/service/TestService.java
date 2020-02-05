package quizsystem.service;

import quizsystem.entity.Test;

import java.util.List;

public interface TestService {

    List<Test> findAllByTopicId(Long id);
}
