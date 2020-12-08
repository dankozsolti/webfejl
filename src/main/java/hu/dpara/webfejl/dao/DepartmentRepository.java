package hu.dpara.webfejl.dao;

import hu.dpara.webfejl.dao.entity.DepartmentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DepartmentRepository extends CrudRepository<DepartmentEntity, String> {

    //@Override
    Optional<DepartmentEntity> findByDeptNo(String deptNo);

    void deleteById(String deptNo);

}
