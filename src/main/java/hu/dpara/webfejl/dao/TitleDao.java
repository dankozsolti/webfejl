package hu.dpara.webfejl.dao;

import hu.dpara.webfejl.dao.entity.EmployeeEntity;
import hu.dpara.webfejl.dao.entity.TitleId;
import hu.dpara.webfejl.exception.EmployeeAlreadyExistsException;
import hu.dpara.webfejl.exception.TitleAlreadyExistsException;
import hu.dpara.webfejl.exception.UnknownEmployeeException;
import hu.dpara.webfejl.exception.UnknownTitleException;
import hu.dpara.webfejl.model.Employee;
import hu.dpara.webfejl.model.Title;

import java.sql.Date;
import java.util.Collection;

public interface TitleDao {

    Collection<Title> readAll();
    Title readByEmpNo(EmployeeEntity empNo) throws UnknownTitleException;
    void createTitle(Title title) throws TitleAlreadyExistsException, UnknownEmployeeException;
    void deleteByEmpNoAndTitleAndFromDate(EmployeeEntity empNo, String title, Date fromDate) throws UnknownTitleException, UnknownEmployeeException;
    void update(Title title) throws UnknownTitleException, UnknownEmployeeException;

}
