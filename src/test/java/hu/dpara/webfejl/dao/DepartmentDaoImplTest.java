package hu.dpara.webfejl.dao;

import hu.dpara.webfejl.dao.entity.DepartmentEntity;
import hu.dpara.webfejl.exception.DepartmentAlreadyExistsException;
import hu.dpara.webfejl.exception.UnknownDepartmentException;
import hu.dpara.webfejl.model.Department;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentDaoImplTest {

    @InjectMocks
    private DepartmentDaoImpl dao;
    @Mock
    private DepartmentRepository departmentRepository;


    @Test
    void createDepartment() throws DepartmentAlreadyExistsException {

        when(departmentRepository.findById(anyString())).thenReturn(Optional.empty());

        dao.createDepartment(getDepartment());
        verify(departmentRepository, times(1)).save(getDepartmentEntity());

        when(departmentRepository.findById(anyString())).thenReturn(Optional.of(getDepartmentEntity()));

        assertThrows(DepartmentAlreadyExistsException.class, () -> {
            dao.createDepartment(getDepartment());
        });

    }

    @Test
    void readAll() {
        when(departmentRepository.findAll()).thenReturn(getDepartmentEntities());
        assertEquals(dao.readAll(),getDepartments());
    }

    @Test
    void deleteByDeptNo() throws UnknownDepartmentException{
        when(departmentRepository.findById(anyString())).thenReturn(Optional.of(getDepartmentEntity()));
        dao.deleteByDeptNo("d020");
        verify(departmentRepository,times(1)).deleteById("d020");
    }

    @Test
    void update() throws UnknownDepartmentException {
        when(departmentRepository.findById(anyString())).thenReturn(Optional.of(getDepartmentEntity()));
        dao.update(getDepartment());
        verify(departmentRepository,times(1)).save(getDepartmentEntity());
    }



    private Department getDepartment() {
        return new Department(
                "d020",
                "TestDepartment"

        );
    }

    private DepartmentEntity getDepartmentEntity(){
        return new DepartmentEntity(
                "d020",
                "TestDepartment"
        );
    }

    private Collection<Department> getDepartments(){
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

    private Collection<DepartmentEntity> getDepartmentEntities() {
        return Arrays.asList(
                new DepartmentEntity(
                        "d020",
                        "TestDepartment"
                ),
                new DepartmentEntity(
                        "d021",
                        "TestDepartment2"
                ),
                new DepartmentEntity(
                        "d022",
                        "TestDepartment3"

                ),
                new DepartmentEntity(
                        "d023",
                        "TestDepartment4"

                ),
                new DepartmentEntity(
                        "d024",
                        "TestDepartment5"

                )
        );
    }
}
