package hu.dpara.webfejl.dao;

import hu.dpara.webfejl.exception.DepartmentAlreadyExistsException;
import hu.dpara.webfejl.exception.EmployeeAlreadyExistsException;
import hu.dpara.webfejl.exception.UnknownDepartmentException;
import hu.dpara.webfejl.exception.UnknownEmployeeException;
import hu.dpara.webfejl.model.Department;
import hu.dpara.webfejl.model.Employee;

import java.util.Collection;

public interface EmployeeDao {

    Collection<Employee> readAll();
    Employee readByEmpNo(int empNo) throws UnknownEmployeeException;
    void createEmployee(Employee employee) throws EmployeeAlreadyExistsException;
    void deleteByEmpNo(int empNo) throws UnknownEmployeeException;
    void update(Employee employee) throws UnknownEmployeeException;

}
