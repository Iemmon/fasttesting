package testingsystem.service.interfacepack;

import testingsystem.domain.Test;

import java.util.List;

public interface TestService {

    Test get(Long id);

    List<Test> getAll();
}
