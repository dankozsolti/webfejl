package hu.dpara.webfejl.services;

import hu.dpara.webfejl.dao.entity.EmployeeEntity;
import hu.dpara.webfejl.dao.entity.SalaryId;
import hu.dpara.webfejl.exception.SalaryAlreadyExistsException;
import hu.dpara.webfejl.exception.UnknownEmployeeException;
import hu.dpara.webfejl.exception.UnknownSalaryException;
import hu.dpara.webfejl.model.Salary;

import java.sql.Date;
import java.util.Collection;

public interface SalaryService {

    Collection<Salary> getAllSalary();
    void recordSalary(Salary salary) throws SalaryAlreadyExistsException, UnknownEmployeeException;
    void deleteByEmpNoAndFromDate(EmployeeEntity empNo, Date fromDate) throws UnknownSalaryException, UnknownEmployeeException;
    void updateSalary(Salary salary) throws UnknownSalaryException, UnknownEmployeeException;

}
