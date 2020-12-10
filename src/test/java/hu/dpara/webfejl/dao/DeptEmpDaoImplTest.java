package hu.dpara.webfejl.dao;

import hu.dpara.webfejl.dao.entity.DepartmentEntity;
import hu.dpara.webfejl.dao.entity.DeptEmpEntity;
import hu.dpara.webfejl.dao.entity.EmployeeEntity;
import hu.dpara.webfejl.exception.DeptEmpAlreadyExistsException;
import hu.dpara.webfejl.exception.UnknownDepartmentException;
import hu.dpara.webfejl.exception.UnknownDeptEmpException;
import hu.dpara.webfejl.exception.UnknownEmployeeException;
import hu.dpara.webfejl.model.DeptEmp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeptEmpDaoImplTest {

    @InjectMocks
    private DeptEmpDaoImpl dao;

    @Mock
    private DeptEmpRepository deptEmpRepository;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private DepartmentRepository departmentRepository;

    private EmployeeEntity getDefaultEmployeeEntity() {
        return new EmployeeEntity(
                1,
                Date.valueOf("2000-12-12"),
                "Teszt",
                "Elek",
                "M",
                Date.valueOf("2020-12-12")
        );
    }

    private DepartmentEntity getDefaultDepartmentEntity(){
        return new DepartmentEntity(
                "d001",
                "Teszt"
        );
    }



    @Test
    void createDeptEmp() throws DeptEmpAlreadyExistsException, UnknownDepartmentException, UnknownEmployeeException {

        when(deptEmpRepository.findByEmpNoAndDeptNo(getDefaultEmployeeEntity(),getDefaultDepartmentEntity())).thenReturn(Optional.empty());
        when(employeeRepository.findById(anyInt())).thenReturn(Optional.of(getDefaultEmployeeEntity()));
        when(departmentRepository.findById(anyString())).thenReturn(Optional.of(getDefaultDepartmentEntity()));
        dao.createDeptEmp(getDeptEmp());
        verify(deptEmpRepository, times(1)).save(getDeptEmpEntity());
        when(deptEmpRepository.findByEmpNoAndDeptNo(getDefaultEmployeeEntity(),getDefaultDepartmentEntity())).thenReturn(Optional.of(getDeptEmpEntity()));

        assertThrows(DeptEmpAlreadyExistsException.class, () -> {
            dao.createDeptEmp(getDeptEmp());
        });

    }

    @Test
    void readAll() {
        when(deptEmpRepository.findAll()).thenReturn(getDeptEmpEntities());
        assertEquals(dao.readAll(),getDeptEmpS());
    }

    @Test
    void deleteByDeptNo() throws UnknownDeptEmpException {
        when(deptEmpRepository.findByEmpNoAndDeptNo(getDefaultEmployeeEntity(),getDefaultDepartmentEntity())).thenReturn(Optional.of(getDeptEmpEntity()));
        dao.deleteByEmpNoAndDeptNo(getDefaultEmployeeEntity(),getDefaultDepartmentEntity());
        verify(deptEmpRepository,times(1)).findByEmpNoAndDeptNo(getDefaultEmployeeEntity(),getDefaultDepartmentEntity());
    }

    @Test
    void update() throws UnknownDeptEmpException, UnknownDepartmentException, UnknownEmployeeException {
        when(deptEmpRepository.findByEmpNoAndDeptNo(getDefaultEmployeeEntity(),getDefaultDepartmentEntity())).thenReturn(Optional.of(getDeptEmpEntity()));

        when(employeeRepository.findById(anyInt())).thenReturn(Optional.of(getDefaultEmployeeEntity()));
        when(departmentRepository.findById(anyString())).thenReturn(Optional.of(getDefaultDepartmentEntity()));
        dao.update(getDeptEmp());
        verify(deptEmpRepository,times(1)).save(getDeptEmpEntity());
    }



    private DeptEmp getDeptEmp() {
        return new DeptEmp(
                1,
                "d001",
                Date.valueOf("1999-01-01"),
                Date.valueOf("2020-12-12")

        );
    }

    private DeptEmpEntity getDeptEmpEntity(){
        return new DeptEmpEntity(
                getDefaultEmployeeEntity(),
                getDefaultDepartmentEntity(),
                Date.valueOf("1999-01-01"),
                Date.valueOf("2020-12-12")
        );
    }

    private Collection<DeptEmp> getDeptEmpS(){
        return Arrays.asList(
                new DeptEmp(
                        1,
                        "d001",
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2020-12-12")
                ),
                new DeptEmp(
                        1,
                        "d001",
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2021-12-12")
                ),
                new DeptEmp(
                        1,
                        "d001",
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2022-12-12")
                ),
                new DeptEmp(
                        1,
                        "d001",
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2023-12-12")
                ),
                new DeptEmp(
                        1,
                        "d001",
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2024-12-12")
                )
        );
    }

    private Collection<DeptEmpEntity> getDeptEmpEntities() {
        return Arrays.asList(
                new DeptEmpEntity(
                        getDefaultEmployeeEntity(),
                        getDefaultDepartmentEntity(),
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2020-12-12")
                ),
                new DeptEmpEntity(
                        getDefaultEmployeeEntity(),
                        getDefaultDepartmentEntity(),
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2021-12-12")
                ),
                new DeptEmpEntity(
                        getDefaultEmployeeEntity(),
                        getDefaultDepartmentEntity(),
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2022-12-12")
                ),
                new DeptEmpEntity(
                        getDefaultEmployeeEntity(),
                        getDefaultDepartmentEntity(),
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2023-12-12")
                ),
                new DeptEmpEntity(
                        getDefaultEmployeeEntity(),
                        getDefaultDepartmentEntity(),
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2024-12-12")
                )
        );
    }
}
