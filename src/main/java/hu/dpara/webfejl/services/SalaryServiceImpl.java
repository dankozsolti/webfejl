package hu.dpara.webfejl.services;

import hu.dpara.webfejl.dao.SalaryDao;
import hu.dpara.webfejl.dao.entity.EmployeeEntity;
import hu.dpara.webfejl.dao.entity.SalaryId;
import hu.dpara.webfejl.exception.SalaryAlreadyExistsException;
import hu.dpara.webfejl.exception.UnknownEmployeeException;
import hu.dpara.webfejl.exception.UnknownSalaryException;
import hu.dpara.webfejl.model.Salary;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.Collection;

@Slf4j
@Service
@RequiredArgsConstructor
public class SalaryServiceImpl implements SalaryService{

    private final SalaryDao salaryDao;

    @Override
    public Collection<Salary> getAllSalary() {
        return salaryDao.readAll();
    }

    @Override
    public void recordSalary(Salary salary) throws SalaryAlreadyExistsException, UnknownEmployeeException {
        salaryDao.createSalary(salary);
    }

    @Transactional
    public void deleteByEmpNoAndFromDate(EmployeeEntity empNo, Date fromDate) throws UnknownSalaryException, UnknownEmployeeException {
        salaryDao.deleteByEmpNoAndFromDate(empNo, fromDate);
    }

    @Override
    public void updateSalary(Salary salary) throws UnknownSalaryException, UnknownEmployeeException {
        salaryDao.update(salary);
    }
}
