package hu.dpara.webfejl.services;

import hu.dpara.webfejl.dao.DeptEmpDao;
import hu.dpara.webfejl.dao.EmployeeDao;
import hu.dpara.webfejl.exception.DeptEmpAlreadyExistsException;
import hu.dpara.webfejl.exception.EmployeeAlreadyExistsException;
import hu.dpara.webfejl.exception.UnknownDeptEmpException;
import hu.dpara.webfejl.exception.UnknownEmployeeException;
import hu.dpara.webfejl.model.DeptEmp;
import hu.dpara.webfejl.model.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeDao employeeDao;

    @Override
    public Collection<Employee> getAllEmployee() {
        return employeeDao.readAll();
    }

    @Override
    public void recordEmployee(Employee employee) throws EmployeeAlreadyExistsException {
        employeeDao.createEmployee(employee);
    }

    @Override
    public void deleteEmployeeByEmpNo(int empNo) throws UnknownEmployeeException {
        employeeDao.deleteByEmpNo(empNo);
    }

    @Override
    public void updateEmployee(Employee employee) throws UnknownEmployeeException {
        employeeDao.update(employee);
    }
}