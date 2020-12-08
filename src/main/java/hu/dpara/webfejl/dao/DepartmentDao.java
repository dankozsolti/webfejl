package hu.dpara.webfejl.dao;

import hu.dpara.webfejl.exception.DepartmentAlreadyExistsException;
import hu.dpara.webfejl.exception.UnknownDepartmentException;
import hu.dpara.webfejl.model.Department;

import java.util.Collection;

public interface DepartmentDao {

    Collection<Department> readAll();
    Department readByDeptNo(String deptNo) throws UnknownDepartmentException;
    void createDepartment(Department department) throws DepartmentAlreadyExistsException;
    void deleteByDeptNo(String deptNo) throws UnknownDepartmentException;
    void update(Department department) throws UnknownDepartmentException;

}
