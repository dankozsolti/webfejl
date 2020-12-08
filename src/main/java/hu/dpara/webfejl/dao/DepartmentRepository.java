package hu.dpara.webfejl.dao;

import hu.dpara.webfejl.dao.entity.DepartmentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DepartmentRepository extends CrudRepository<DepartmentEntity, Integer> {

    //@Override
    Optional<DepartmentEntity> findByDeptNo(String deptNo);

    void deleteByDeptNo(String deptNo);
}
