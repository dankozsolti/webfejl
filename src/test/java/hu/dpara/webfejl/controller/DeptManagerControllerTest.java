package hu.dpara.webfejl.controller;

import hu.dpara.webfejl.controller.dto.DeptManagerDto;
import hu.dpara.webfejl.controller.dto.DeptManagerRequestDto;
import hu.dpara.webfejl.dao.entity.DepartmentEntity;
import hu.dpara.webfejl.dao.entity.EmployeeEntity;
import hu.dpara.webfejl.exception.DeptManagerAlreadyExistsException;
import hu.dpara.webfejl.exception.UnknownDepartmentException;
import hu.dpara.webfejl.exception.UnknownDeptManagerException;
import hu.dpara.webfejl.exception.UnknownEmployeeException;
import hu.dpara.webfejl.model.DeptManager;
import hu.dpara.webfejl.services.DeptManagerService;
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
class DeptManagerControllerTest {

    @InjectMocks
    private DeptManagerController DeptManagerController;

    @Mock
    private DeptManagerService DeptManagerService;

    @Test
    void listDeptManagerS() {
        when(DeptManagerService.getAllDeptManager()).thenReturn(getDeptManagerS());
        DeptManagerController.listDeptManager();
        verify(DeptManagerService,times(1)).getAllDeptManager();
        assertEquals(getDeptManagerDtoS(),DeptManagerController.listDeptManager());
    }

    @Test
    void record() throws DeptManagerAlreadyExistsException, UnknownDepartmentException, UnknownEmployeeException {
        DeptManagerController.record(getDefaultDeptManagerRequestDto());
        verify(DeptManagerService,times(1)).recordDeptManager(getDefaultDeptManager());
        doThrow(DeptManagerAlreadyExistsException.class).when(DeptManagerService).recordDeptManager(getDefaultDeptManager());
        assertThrows(ResponseStatusException.class,()->{
            DeptManagerController.record(getDefaultDeptManagerRequestDto());
        });
    }

    @Test
    void update() throws UnknownDeptManagerException, UnknownDepartmentException, UnknownEmployeeException {
        DeptManagerController.update(getDefaultDeptManagerRequestDto());
        verify(DeptManagerService,times(1)).updateDeptManager(getDefaultDeptManager());
        doThrow(UnknownDeptManagerException.class).when(DeptManagerService).updateDeptManager(getDefaultDeptManager());
        assertThrows(ResponseStatusException.class,()->{
            DeptManagerController.update(getDefaultDeptManagerRequestDto());
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
    void deleteDeptManager() throws UnknownDeptManagerException, UnknownDepartmentException, UnknownEmployeeException {
        DeptManagerController.deleteDeptManager(getDefaultEmployeeEntity(),getDefaultDepartmentEntity());
        verify(DeptManagerService,times(1)).deleteDeptManagerByEmpNoAndDeptNo(getDefaultEmployeeEntity(),getDefaultDepartmentEntity());
        doThrow(UnknownDeptManagerException.class).when(DeptManagerService).deleteDeptManagerByEmpNoAndDeptNo(getDefaultEmployeeEntity(),getDefaultDepartmentEntity());
        assertThrows(ResponseStatusException.class,()-> {
            DeptManagerController.deleteDeptManager(getDefaultEmployeeEntity(),getDefaultDepartmentEntity());
        });
    }



    private DeptManager getDefaultDeptManager() {
        return new DeptManager(
                1,
                "d001",
                Date.valueOf("1999-01-01"),
                Date.valueOf("2020-12-12")

        );
    }

    private DeptManagerRequestDto getDefaultDeptManagerRequestDto() {
        return new DeptManagerRequestDto(
                1,
                "d001",
                Date.valueOf("1999-01-01"),
                Date.valueOf("2020-12-12")
        );
    }

    private Collection<DeptManager> getDeptManagerS() {
        return Arrays.asList(

                new DeptManager(
                        1,
                        "d001",
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2020-12-12")
                ),
                new DeptManager(
                        2,
                        "d002",
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2021-12-12")
                ),
                new DeptManager(
                        3,
                        "d003",
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2022-12-12")
                ),
                new DeptManager(
                        4,
                        "d004",
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2023-12-12")
                ),
                new DeptManager(
                        5,
                        "d005",
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2024-12-12")
                )
        );

    }

    private Collection<DeptManagerDto> getDeptManagerDtoS() {
        return Arrays.asList(

                new DeptManagerDto(
                        1,
                        "d001",
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2020-12-12")
                ),
                new DeptManagerDto(
                        2,
                        "d002",
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2021-12-12")
                ),
                new DeptManagerDto(
                        3,
                        "d003",
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2022-12-12")
                ),
                new DeptManagerDto(
                        4,
                        "d004",
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2023-12-12")
                ),
                new DeptManagerDto(
                        5,
                        "d005",
                        Date.valueOf("1999-01-01"),
                        Date.valueOf("2024-12-12")
                )
        );

    }


}