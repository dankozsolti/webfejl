package hu.dpara.webfejl.services;

import hu.dpara.webfejl.dao.DeptManagerDao;
import hu.dpara.webfejl.dao.DeptManagerDao;
import hu.dpara.webfejl.dao.entity.DepartmentEntity;
import hu.dpara.webfejl.dao.entity.EmployeeEntity;
import hu.dpara.webfejl.exception.*;
import hu.dpara.webfejl.model.DeptManager;
import hu.dpara.webfejl.model.DeptManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeptManagerServiceImpl implements DeptManagerService{

    private final DeptManagerDao deptManagerDao;

    @Override
    public Collection<DeptManager> getAllDeptManager() {
        return deptManagerDao.readAll();
    }

    @Override
    public void recordDeptManager(DeptManager deptManager) throws DeptManagerAlreadyExistsException, UnknownEmployeeException, UnknownDepartmentException {
        deptManagerDao.createDeptManager(deptManager);
    }

    @Override
    public void deleteDeptManagerByEmpNoAndDeptNo(EmployeeEntity empNo, DepartmentEntity deptNo) throws UnknownDeptManagerException, UnknownEmployeeException, UnknownDepartmentException {
        deptManagerDao.deleteByEmpNoAndDeptNo(empNo, deptNo);
    }

    @Override
    public void updateDeptManager(DeptManager deptManager) throws UnknownDeptManagerException, UnknownEmployeeException, UnknownDepartmentException {
        deptManagerDao.update(deptManager);
    }
}
