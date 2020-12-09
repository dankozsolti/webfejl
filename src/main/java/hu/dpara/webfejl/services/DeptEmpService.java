package hu.dpara.webfejl.services;

import hu.dpara.webfejl.dao.entity.DepartmentEntity;
import hu.dpara.webfejl.dao.entity.EmployeeEntity;
import hu.dpara.webfejl.exception.DeptEmpAlreadyExistsException;
import hu.dpara.webfejl.exception.UnknownDepartmentException;
import hu.dpara.webfejl.exception.UnknownDeptEmpException;
import hu.dpara.webfejl.exception.UnknownEmployeeException;
import hu.dpara.webfejl.model.DeptEmp;

import java.util.Collection;

public interface DeptEmpService {

    Collection<DeptEmp> getAllDeptEmp();
    void recordDeptEmp(DeptEmp deptEmp) throws DeptEmpAlreadyExistsException, UnknownEmployeeException, UnknownDepartmentException;
    void deleteDeptEmpByEmpNoAndDeptNo(EmployeeEntity empNo, DepartmentEntity deptNo) throws UnknownDeptEmpException,UnknownEmployeeException, UnknownDepartmentException;
    void updateDeptEmp(DeptEmp deptEmp) throws UnknownDeptEmpException, UnknownEmployeeException, UnknownDepartmentException;

}
