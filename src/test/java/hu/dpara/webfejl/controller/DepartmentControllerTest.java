package hu.dpara.webfejl.controller;

import hu.dpara.webfejl.controller.dto.DepartmentDto;
import hu.dpara.webfejl.controller.dto.DepartmentRequestDto;
import hu.dpara.webfejl.exception.DepartmentAlreadyExistsException;
import hu.dpara.webfejl.exception.UnknownDepartmentException;
import hu.dpara.webfejl.model.Department;
import hu.dpara.webfejl.services.DepartmentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentControllerTest {

    @InjectMocks
    private DepartmentController departmentController;

    @Mock
    private DepartmentService departmentService;

    @Test
    void listDepartments() {
        when(departmentService.getAllDepartment()).thenReturn(getDepartments());
        departmentController.listDepartment();
        verify(departmentService,times(1)).getAllDepartment();
        assertEquals(getDepartmentDtoS(),departmentController.listDepartment());
    }

    @Test
    void record() throws DepartmentAlreadyExistsException {
        departmentController.record(getDefaultDepartmentRequestDto());
        verify(departmentService,times(1)).recordDepartment(getDefaultDepartment());
        doThrow(DepartmentAlreadyExistsException.class).when(departmentService).recordDepartment(getDefaultDepartment());
        assertThrows(ResponseStatusException.class,()->{
           departmentController.record(getDefaultDepartmentRequestDto());
        });
    }

    @Test
    void update() throws UnknownDepartmentException {
        departmentController.update(getDefaultDepartmentRequestDto());
        verify(departmentService,times(1)).updateDepartment(getDefaultDepartment());
        doThrow(UnknownDepartmentException.class).when(departmentService).updateDepartment(getDefaultDepartment());
        assertThrows(ResponseStatusException.class,()->{
           departmentController.update(getDefaultDepartmentRequestDto());
        });
    }

    @Test
    void deleteDepartment() throws UnknownDepartmentException {
        departmentController.deleteDepartment(anyString());
        verify(departmentService,times(1)).deleteDepartmentByDeptNo(anyString());
        doThrow(UnknownDepartmentException.class).when(departmentService).deleteDepartmentByDeptNo(anyString());
        assertThrows(ResponseStatusException.class,()-> {
            departmentController.deleteDepartment(anyString());
        });
    }

    private Department getDefaultDepartment() {
        return new Department(
                "d020",
                "TestDepartment"
        );
    }

    private DepartmentRequestDto getDefaultDepartmentRequestDto() {
        return new DepartmentRequestDto(
                "d020",
                "TestDepartment"
        );
    }

    private Collection<Department> getDepartments() {
        return Arrays.asList(

                new Department(
                        "d020",
                        "TestDepartment"
                ),
                new Department(
                        "d021",
                        "TestDepartment2"
                ),
                new Department(
                        "d022",
                        "TestDepartment3"
                ),
                new Department(
                        "d023",
                        "TestDepartment4"
                ),
                new Department(
                        "d024",
                        "TestDepartment5"
                )
        );

    }

    private Collection<DepartmentDto> getDepartmentDtoS() {
        return Arrays.asList(

                new DepartmentDto(
                        "d020",
                        "TestDepartment"
                ),
                new DepartmentDto(
                        "d021",
                        "TestDepartment2"
                ),
                new DepartmentDto(
                        "d022",
                        "TestDepartment3"
                ),
                new DepartmentDto(
                        "d023",
                        "TestDepartment4"
                ),
                new DepartmentDto(
                        "d024",
                        "TestDepartment5"
                )
        );

    }


}
