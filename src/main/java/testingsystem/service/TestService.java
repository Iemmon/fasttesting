package testingsystem.service;

import testingsystem.entity.Test;

import java.util.List;

public interface TestService {

    Test get(Long id);

    List<Test> getAll();
}
