package hu.dpara.webfejl.services;

import hu.dpara.webfejl.exception.DepartmentAlreadyExistsException;
import hu.dpara.webfejl.exception.EmployeeAlreadyExistsException;
import hu.dpara.webfejl.exception.UnknownDepartmentException;
import hu.dpara.webfejl.exception.UnknownEmployeeException;
import hu.dpara.webfejl.model.Department;
import hu.dpara.webfejl.model.Employee;

import java.util.Collection;

public interface EmployeeService {

    Collection<Employee> getAllEmployee();
    void recordEmployee(Employee employee) throws EmployeeAlreadyExistsException;
    void deleteEmployeeByEmpNo(int empNo) throws UnknownEmployeeException;
    void updateEmployee(Employee employee) throws UnknownEmployeeException;

}
