package hu.dpara.webfejl.dao;

import hu.dpara.webfejl.dao.entity.DepartmentEntity;
import hu.dpara.webfejl.dao.entity.DeptEmpEntity;
import hu.dpara.webfejl.dao.entity.DeptEmpId;
import hu.dpara.webfejl.dao.entity.EmployeeEntity;
import hu.dpara.webfejl.model.DeptEmp;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.Optional;

public interface DeptEmpRepository extends CrudRepository<DeptEmpEntity, DeptEmpId> {

    @Transactional
    Optional<DeptEmpEntity> findByEmpNoAndDeptNo(EmployeeEntity empNo, DepartmentEntity deptNo);

    @Transactional
    void deleteByEmpNoAndDeptNo(EmployeeEntity empNo, DepartmentEntity deptNo);

}