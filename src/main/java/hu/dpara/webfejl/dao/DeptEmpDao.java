package hu.dpara.webfejl.dao;

import hu.dpara.webfejl.dao.entity.DepartmentEntity;
import hu.dpara.webfejl.dao.entity.EmployeeEntity;
import hu.dpara.webfejl.exception.*;
import hu.dpara.webfejl.model.Department;
import hu.dpara.webfejl.model.DeptEmp;

import java.util.Collection;

public interface DeptEmpDao {

    Collection<DeptEmp> readAll();
    DeptEmp readByEmpNoAndDeptNo(EmployeeEntity empNo, DepartmentEntity deptNo) throws UnknownDeptEmpException;
    void createDeptEmp(DeptEmp deptEmp) throws DeptEmpAlreadyExistsException, UnknownEmployeeException, UnknownDepartmentException;
    void deleteByEmpNoAndDeptNo(EmployeeEntity empNo, DepartmentEntity deptNo) throws UnknownDeptEmpException;
    void update(DeptEmp deptEmp) throws UnknownDeptEmpException, UnknownEmployeeException, UnknownDepartmentException;

}
