package testingsystem.dao;

import java.util.List;
import java.util.Optional;

public interface CrudDao<E> {

    void save(E entity);

    Optional<E> findById(Long id);

    List<E> findAll();

    long count();

    void update(E entity);

    void deleteById(Long id);
}
