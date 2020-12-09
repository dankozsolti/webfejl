package hu.dpara.webfejl.dao;

import hu.dpara.webfejl.dao.entity.EmployeeEntity;
import hu.dpara.webfejl.dao.entity.SalaryEntity;
import hu.dpara.webfejl.dao.entity.TitleEntity;
import hu.dpara.webfejl.dao.entity.TitleId;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.Optional;

public interface TitleRepository extends CrudRepository<TitleEntity, TitleId> {

    Optional<TitleEntity> findByEmpNo(EmployeeEntity empNo);

    @Transactional
    void deleteByEmpNoAndTitleAndFromDate(EmployeeEntity empNo, String title, Date fromDate);

}