package testingsystem.service;

import testingsystem.domain.Test;

import java.util.List;

public interface TestService {

    Test add();

    boolean delete(Long id);

    Test get(Long id);

    List<Test> getAll();
}
