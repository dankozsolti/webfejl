package hu.dpara.webfejl.services;

import hu.dpara.webfejl.dao.TitleDao;
import hu.dpara.webfejl.dao.entity.EmployeeEntity;
import hu.dpara.webfejl.dao.entity.TitleId;
import hu.dpara.webfejl.exception.TitleAlreadyExistsException;
import hu.dpara.webfejl.exception.UnknownEmployeeException;
import hu.dpara.webfejl.exception.UnknownTitleException;
import hu.dpara.webfejl.model.Title;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.Collection;

@Slf4j
@Service
@RequiredArgsConstructor
public class TitleServiceImpl implements TitleService{

    private final TitleDao titleDao;

    @Override
    public Collection<Title> getAllTitle() {
        return titleDao.readAll();
    }

    @Override
    public void recordTitle(Title Title) throws TitleAlreadyExistsException, UnknownEmployeeException {
        titleDao.createTitle(Title);
    }
    @Transactional
    public void deleteByEmpNoAndTitleAndFromDate(EmployeeEntity empNo, String title, Date fromDate) throws UnknownTitleException, UnknownEmployeeException {
        titleDao.deleteByEmpNoAndTitleAndFromDate(empNo,title,fromDate);
    }

    @Override
    public void updateTitle(Title Title) throws UnknownTitleException, UnknownEmployeeException {
        titleDao.update(Title);
    }
}