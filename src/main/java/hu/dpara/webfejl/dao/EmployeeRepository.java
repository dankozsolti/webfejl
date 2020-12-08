package hu.dpara.webfejl.dao;

import hu.dpara.webfejl.dao.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {

    @Override
    Optional<EmployeeEntity> findById(Integer empNo);

    @Override
    void deleteById(Integer empNo);

}