package hu.dpara.webfejl.services;

import hu.dpara.webfejl.dao.DepartmentDao;
import hu.dpara.webfejl.exception.DepartmentAlreadyExistsException;
import hu.dpara.webfejl.exception.UnknownDepartmentException;
import hu.dpara.webfejl.model.Department;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentDao departmentDao;

    @Override
    public Collection<Department> getAllDepartment() {
        return departmentDao.readAll();
    }

    @Override
    public void recordDepartment(Department department) throws DepartmentAlreadyExistsException {
        departmentDao.createDepartment(department);
    }
    @Override
    public void deleteDepartmentByDeptNo(String deptNo) throws UnknownDepartmentException {
        departmentDao.deleteByDeptNo(deptNo);
    }

    @Override
    public void updateDepartment(Department department) throws UnknownDepartmentException {
        departmentDao.update(department);
    }
}
