package hu.dpara.webfejl.dao;

import hu.dpara.webfejl.dao.entity.DepartmentEntity;
import hu.dpara.webfejl.dao.entity.EmployeeEntity;
import hu.dpara.webfejl.exception.*;
import hu.dpara.webfejl.model.DeptManager;
import hu.dpara.webfejl.model.DeptManager;

import java.util.Collection;

public interface DeptManagerDao {

    Collection<DeptManager> readAll();
    DeptManager readByEmpNoAndDeptNo(EmployeeEntity empNo, DepartmentEntity deptNo) throws UnknownDeptManagerException;
    void createDeptManager(DeptManager deptManager) throws DeptManagerAlreadyExistsException, UnknownEmployeeException, UnknownDepartmentException;
    void deleteByEmpNoAndDeptNo(EmployeeEntity empNo, DepartmentEntity deptNo) throws UnknownDeptManagerException;
    void update(DeptManager deptManager) throws UnknownDeptManagerException, UnknownEmployeeException, UnknownDepartmentException;

}
