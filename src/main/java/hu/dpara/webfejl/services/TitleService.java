package hu.dpara.webfejl.services;

import hu.dpara.webfejl.dao.entity.EmployeeEntity;
import hu.dpara.webfejl.dao.entity.TitleId;
import hu.dpara.webfejl.exception.TitleAlreadyExistsException;
import hu.dpara.webfejl.exception.UnknownEmployeeException;
import hu.dpara.webfejl.exception.UnknownTitleException;
import hu.dpara.webfejl.model.Title;

import java.sql.Date;
import java.util.Collection;

public interface TitleService {

    Collection<Title> getAllTitle();
    void recordTitle(Title title) throws TitleAlreadyExistsException, UnknownEmployeeException;
    void deleteByEmpNoAndTitleAndFromDate(EmployeeEntity empNo, String title, Date fromDate) throws UnknownTitleException, UnknownEmployeeException;
    void updateTitle(Title title) throws UnknownTitleException, UnknownEmployeeException;

}
