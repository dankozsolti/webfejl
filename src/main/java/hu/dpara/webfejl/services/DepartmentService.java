package hu.dpara.webfejl.services;

import hu.dpara.webfejl.exception.DepartmentAlreadyExistsException;
import hu.dpara.webfejl.exception.UnknownDepartmentException;
import hu.dpara.webfejl.model.Department;

import java.util.Collection;

public interface DepartmentService {

    Collection<Department> getAllDepartment();
    void recordDepartment(Department department) throws DepartmentAlreadyExistsException;
    void deleteDepartmentByDeptNo(String deptNo) throws UnknownDepartmentException;
    void updateDepartment(Department department) throws UnknownDepartmentException;

}
