package testingsystem.service;

import testingsystem.entity.Test;

import java.util.List;

public interface TestService {

    List<Test> findAllByTopicId(Long id);
}
