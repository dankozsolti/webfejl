package hu.dpara.webfejl.dao;

import hu.dpara.webfejl.dao.entity.DepartmentEntity;
import hu.dpara.webfejl.dao.entity.DeptManagerEntity;
import hu.dpara.webfejl.dao.entity.EmployeeEntity;
import hu.dpara.webfejl.exception.DeptManagerAlreadyExistsException;
import hu.dpara.webfejl.exception.UnknownDepartmentException;
import hu.dpara.webfejl.exception.UnknownDeptManagerException;
import hu.dpara.webfejl.exception.UnknownEmployeeException;
import hu.dpara.webfejl.model.DeptManager;
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
class DeptManagerDaoImplTest {

    @InjectMocks
    private DeptManagerDaoImpl dao;

    @Mock
    private DeptManagerRepository deptManagerRepository;

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
    void createDeptManager() throws DeptManagerAlreadyExistsException, UnknownDepartmentException, UnknownEmployeeException {

        when(deptManagerRepository.findByEmpNoAndDeptNo(getDefaultEmployeeEntity(),getDefaultDepartmentEntity())).thenReturn(Optional.empty());
        when(employeeRepository.findById(anyInt())).thenReturn(Optional.of(getDefaultEmployeeEntity()));
        when(departmentRepository.findById(anyString())).thenReturn(Optional.of(getDefaultDepartmentEntity()));
        dao.createDeptManager(getDeptManager());
        verify(deptManagerRepository, times(1)).save(getDeptManagerEntity());
        when(deptManagerRepository.findByEmpNoAndDeptNo(getDefaultEmployeeEntity(),getDefaultDepartmentEntity())).thenReturn(Optional.of(getDeptManagerEntity()));

        assertThrows(DeptManagerAlreadyExistsException.class, () -> {
            dao.createDeptManager(getDeptManager());
        });

    }

    @Test
    void readAll() {
        when(deptManagerRepository.findAll()).thenReturn(getDeptManagerEntities());
        assertEquals(dao.readAll(),getDeptManagerS());
    }

    @Test
    void deleteByDeptNo() throws UnknownDeptManagerException {
        when(deptManagerRepository.findByEmpNoAndDeptNo(getDefaultEmployeeEntity(),getDefaultDepartmentEntity())).thenReturn(Optional.of(getDeptManagerEntity()));
        dao.deleteByEmpNoAndDeptNo(getDefaultEmployeeEntity(),getDefaultDepartmentEntity());
        verify(deptManagerRepository,times(1)).findByEmpNoAndDeptNo(getDefaultEmployeeEntity(),getDefaultDepartmentEntity());
    }

    @Test
    void update() throws UnknownDeptManagerException, UnknownDepartmentException, UnknownEmployeeException {
        when(deptManagerRepository.findByEmpNoAndDeptNo(getDefaultEmployeeEntity(),getDefaultDepartmentEntity())).thenReturn(Optional.of(getDeptManagerEntity()));

        when(employeeRepository.findById(anyInt())).thenReturn(Optional.of(getDefaultEmployeeEntity()));
        when(departmentRepository.findById(anyString())).thenReturn(Optional.of(getDefaultDepartmentEntity()));
        dao.update(getDeptManager());
        verify(deptManagerRepository,times(1)).save(getDeptManagerEntity());
    }



    private DeptManager getDeptManager() {
        return new DeptManager(
                1,
                "d001",
                Date.valueOf("1999-01-01"),
                Date.valueOf("2020-12-12")

        );
    }

    private DeptManagerEntity getDeptManagerEntity(){
        return new DeptManagerEntity(
                getDefaultEmployeeEntity(),
                getDefaultDepartmentEntity(),
                Date.valueOf("1999-01-01"),
                Date.valueOf("2020-12-12")
        );
    }

    private Collection<DeptManager> getDeptManagerS(){
        return Arrays.asList(
                new DeptManager(
                        1,
                        "d001",
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2020-12-12")
                ),
                new DeptManager(
                        1,
                        "d001",
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2021-12-12")
                ),
                new DeptManager(
                        1,
                        "d001",
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2022-12-12")
                ),
                new DeptManager(
                        1,
                        "d001",
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2023-12-12")
                ),
                new DeptManager(
                        1,
                        "d001",
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2024-12-12")
                )
        );
    }

    private Collection<DeptManagerEntity> getDeptManagerEntities() {
        return Arrays.asList(
                new DeptManagerEntity(
                        getDefaultEmployeeEntity(),
                        getDefaultDepartmentEntity(),
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2020-12-12")
                ),
                new DeptManagerEntity(
                        getDefaultEmployeeEntity(),
                        getDefaultDepartmentEntity(),
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2021-12-12")
                ),
                new DeptManagerEntity(
                        getDefaultEmployeeEntity(),
                        getDefaultDepartmentEntity(),
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2022-12-12")
                ),
                new DeptManagerEntity(
                        getDefaultEmployeeEntity(),
                        getDefaultDepartmentEntity(),
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2023-12-12")
                ),
                new DeptManagerEntity(
                        getDefaultEmployeeEntity(),
                        getDefaultDepartmentEntity(),
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2024-12-12")
                )
        );
    }
}

