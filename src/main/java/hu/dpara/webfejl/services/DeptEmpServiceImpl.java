package hu.dpara.webfejl.services;

import hu.dpara.webfejl.dao.DepartmentDao;
import hu.dpara.webfejl.dao.DeptEmpDao;
import hu.dpara.webfejl.dao.entity.DepartmentEntity;
import hu.dpara.webfejl.dao.entity.EmployeeEntity;
import hu.dpara.webfejl.exception.*;
import hu.dpara.webfejl.model.Department;
import hu.dpara.webfejl.model.DeptEmp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeptEmpServiceImpl implements DeptEmpService{

    private final DeptEmpDao deptEmpDao;

    @Override
    public Collection<DeptEmp> getAllDeptEmp() {
        return deptEmpDao.readAll();
    }

    @Override
    public void recordDeptEmp(DeptEmp deptEmp) throws DeptEmpAlreadyExistsException, UnknownEmployeeException, UnknownDepartmentException {
        deptEmpDao.createDeptEmp(deptEmp);
    }

    @Override
    public void deleteDeptEmpByEmpNoAndDeptNo(EmployeeEntity empNo, DepartmentEntity deptNo) throws UnknownDeptEmpException, UnknownEmployeeException, UnknownDepartmentException {
        deptEmpDao.deleteByEmpNoAndDeptNo(empNo, deptNo);
    }

    @Override
    public void updateDeptEmp(DeptEmp deptEmp) throws UnknownDeptEmpException, UnknownEmployeeException, UnknownDepartmentException {
        deptEmpDao.update(deptEmp);
    }
}