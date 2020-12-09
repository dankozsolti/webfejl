package hu.dpara.webfejl.services;

import hu.dpara.webfejl.dao.entity.DepartmentEntity;
import hu.dpara.webfejl.dao.entity.EmployeeEntity;
import hu.dpara.webfejl.exception.*;
import hu.dpara.webfejl.model.DeptManager;

import java.util.Collection;

public interface DeptManagerService {

    Collection<DeptManager> getAllDeptManager();
    void recordDeptManager(DeptManager deptManager) throws DeptManagerAlreadyExistsException, UnknownEmployeeException, UnknownDepartmentException;
    void deleteDeptManagerByEmpNoAndDeptNo(EmployeeEntity empNo, DepartmentEntity deptNo) throws UnknownDeptManagerException,UnknownEmployeeException, UnknownDepartmentException;
    void updateDeptManager(DeptManager deptManager) throws UnknownDeptManagerException, UnknownEmployeeException, UnknownDepartmentException;

}
