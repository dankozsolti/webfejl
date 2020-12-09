package hu.dpara.webfejl.dao;

import hu.dpara.webfejl.dao.entity.*;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.Optional;

public interface DeptManagerRepository extends CrudRepository<DeptManagerEntity, DeptManagerId> {

    @Transactional
    Optional<DeptManagerEntity> findByEmpNoAndDeptNo(EmployeeEntity empNo, DepartmentEntity deptNo);

    @Transactional
    void deleteByEmpNoAndDeptNo(EmployeeEntity empNo, DepartmentEntity deptNo);

}