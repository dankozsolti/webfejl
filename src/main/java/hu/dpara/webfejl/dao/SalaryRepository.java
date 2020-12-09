package hu.dpara.webfejl.dao;

import hu.dpara.webfejl.dao.entity.EmployeeEntity;
import hu.dpara.webfejl.dao.entity.SalaryEntity;
import hu.dpara.webfejl.dao.entity.SalaryId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.Optional;

public interface SalaryRepository extends CrudRepository<SalaryEntity, SalaryId> {

    Optional<SalaryEntity> findByEmpNo(EmployeeEntity empNo);

    @Transactional
    void deleteByEmpNoAndFromDate(EmployeeEntity empNo, Date fromDate);

}
