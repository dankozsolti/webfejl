package hu.dpara.webfejl.dao;

import hu.dpara.webfejl.dao.entity.EmployeeEntity;
import hu.dpara.webfejl.dao.entity.SalaryId;
import hu.dpara.webfejl.exception.SalaryAlreadyExistsException;
import hu.dpara.webfejl.exception.UnknownEmployeeException;
import hu.dpara.webfejl.exception.UnknownSalaryException;
import hu.dpara.webfejl.model.Salary;

import java.sql.Date;
import java.util.Collection;

public interface SalaryDao {

    Collection<Salary> readAll();
    Salary readByEmpNo(EmployeeEntity empNo) throws UnknownSalaryException;
    void createSalary(Salary salary) throws SalaryAlreadyExistsException, UnknownEmployeeException;
    void deleteByEmpNoAndFromDate(EmployeeEntity empNo, Date fromDate) throws UnknownSalaryException, UnknownEmployeeException;
    void update(Salary salary) throws UnknownSalaryException, UnknownEmployeeException;

}
