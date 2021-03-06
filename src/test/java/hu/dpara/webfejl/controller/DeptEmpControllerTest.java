package hu.dpara.webfejl.controller;

import hu.dpara.webfejl.controller.dto.DeptEmpDto;
import hu.dpara.webfejl.controller.dto.DeptEmpRequestDto;
import hu.dpara.webfejl.dao.entity.DepartmentEntity;
import hu.dpara.webfejl.dao.entity.EmployeeEntity;
import hu.dpara.webfejl.exception.DeptEmpAlreadyExistsException;
import hu.dpara.webfejl.exception.UnknownDepartmentException;
import hu.dpara.webfejl.exception.UnknownDeptEmpException;
import hu.dpara.webfejl.exception.UnknownEmployeeException;
import hu.dpara.webfejl.model.DeptEmp;
import hu.dpara.webfejl.services.DeptEmpService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeptEmpControllerTest {

    @InjectMocks
    private DeptEmpController DeptEmpController;

    @Mock
    private DeptEmpService DeptEmpService;

    @Test
    void listDeptEmpS() {
        when(DeptEmpService.getAllDeptEmp()).thenReturn(getDeptEmpS());
        DeptEmpController.listDeptEmp();
        verify(DeptEmpService,times(1)).getAllDeptEmp();
        assertEquals(getDeptEmpDtoS(),DeptEmpController.listDeptEmp());
    }

    @Test
    void record() throws DeptEmpAlreadyExistsException, UnknownDepartmentException, UnknownEmployeeException {
        DeptEmpController.record(getDefaultDeptEmpRequestDto());
        verify(DeptEmpService,times(1)).recordDeptEmp(getDefaultDeptEmp());
        doThrow(DeptEmpAlreadyExistsException.class).when(DeptEmpService).recordDeptEmp(getDefaultDeptEmp());
        assertThrows(ResponseStatusException.class,()->{
            DeptEmpController.record(getDefaultDeptEmpRequestDto());
        });
    }

    @Test
    void update() throws UnknownDeptEmpException, UnknownDepartmentException, UnknownEmployeeException {
        DeptEmpController.update(getDefaultDeptEmpRequestDto());
        verify(DeptEmpService,times(1)).updateDeptEmp(getDefaultDeptEmp());
        doThrow(UnknownDeptEmpException.class).when(DeptEmpService).updateDeptEmp(getDefaultDeptEmp());
        assertThrows(ResponseStatusException.class,()->{
            DeptEmpController.update(getDefaultDeptEmpRequestDto());
        });
    }


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
    void deleteDeptEmp() throws UnknownDeptEmpException, UnknownDepartmentException, UnknownEmployeeException {
        DeptEmpController.deleteDeptEmp(getDefaultEmployeeEntity(),getDefaultDepartmentEntity());
        verify(DeptEmpService,times(1)).deleteDeptEmpByEmpNoAndDeptNo(getDefaultEmployeeEntity(),getDefaultDepartmentEntity());
        doThrow(UnknownDeptEmpException.class).when(DeptEmpService).deleteDeptEmpByEmpNoAndDeptNo(getDefaultEmployeeEntity(),getDefaultDepartmentEntity());
        assertThrows(ResponseStatusException.class,()-> {
            DeptEmpController.deleteDeptEmp(getDefaultEmployeeEntity(),getDefaultDepartmentEntity());
        });
    }



    private DeptEmp getDefaultDeptEmp() {
        return new DeptEmp(
                1,
                "d001",
                Date.valueOf("1999-01-01"),
                Date.valueOf("2020-12-12")

        );
    }

    private DeptEmpRequestDto getDefaultDeptEmpRequestDto() {
        return new DeptEmpRequestDto(
                1,
                "d001",
                Date.valueOf("1999-01-01"),
                Date.valueOf("2020-12-12")
        );
    }

    private Collection<DeptEmp> getDeptEmpS() {
        return Arrays.asList(

                new DeptEmp(
                        1,
                        "d001",
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2020-12-12")
                ),
                new DeptEmp(
                        2,
                        "d002",
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2021-12-12")
                ),
                new DeptEmp(
                        3,
                        "d003",
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2022-12-12")
                ),
                new DeptEmp(
                        4,
                        "d004",
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2023-12-12")
                ),
                new DeptEmp(
                        5,
                        "d005",
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2024-12-12")
                )
        );

    }

    private Collection<DeptEmpDto> getDeptEmpDtoS() {
        return Arrays.asList(

                new DeptEmpDto(
                        1,
                        "d001",
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2020-12-12")
                ),
                new DeptEmpDto(
                        2,
                        "d002",
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2021-12-12")
                ),
                new DeptEmpDto(
                        3,
                        "d003",
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2022-12-12")
                ),
                new DeptEmpDto(
                        4,
                        "d004",
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2023-12-12")
                ),
                new DeptEmpDto(
                        5,
                        "d005",
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2024-12-12")
                )
        );

    }


}
