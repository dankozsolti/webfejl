package hu.dpara.webfejl.dao;

import hu.dpara.webfejl.exception.DepartmentAlreadyExistsException;
import hu.dpara.webfejl.exception.UnknownDepartmentException;
import hu.dpara.webfejl.model.Department;

import java.util.Collection;

public interface DepartmentDao {

    void createDepartment(Department department) throws DepartmentAlreadyExistsException;
    Collection<Department> readAll();
    Department readByDeptNo(String deptNo) throws UnknownDepartmentException;
    void deleteByDeptNo(String deptNo) throws UnknownDepartmentException;
    void update(Department department) throws UnknownDepartmentException;

}
