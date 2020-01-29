package testingsystem.service.interfacepack;

import testingsystem.entity.Test;

import java.util.List;

public interface TestService {

    Test get(Long id);

    List<Test> getAll();
}
