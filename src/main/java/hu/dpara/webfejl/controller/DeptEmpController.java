package hu.dpara.webfejl.controller;

import hu.dpara.webfejl.controller.dto.DepartmentDto;
import hu.dpara.webfejl.controller.dto.DepartmentRequestDto;
import hu.dpara.webfejl.controller.dto.DeptEmpDto;
import hu.dpara.webfejl.controller.dto.DeptEmpRequestDto;
import hu.dpara.webfejl.dao.entity.DepartmentEntity;
import hu.dpara.webfejl.dao.entity.EmployeeEntity;
import hu.dpara.webfejl.exception.*;
import hu.dpara.webfejl.model.Department;
import hu.dpara.webfejl.model.DeptEmp;
import hu.dpara.webfejl.services.DepartmentService;
import hu.dpara.webfejl.services.DeptEmpService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Collection;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/dept_emp")
public class DeptEmpController {

    private final DeptEmpService service;

    @GetMapping("/getAll")
    public Collection<DeptEmpDto> listDeptEmp(){
        return service.getAllDeptEmp()
                .stream()
                .map(model -> DeptEmpDto.builder()
                        .empNo(model.getEmpNo())
                        .deptNo(model.getDeptNo())
                        .fromDate(model.getFromDate())
                        .toDate(model.getToDate())
                        .build())
                .collect(Collectors.toList());
    }

    @PostMapping("/create")
    public String record(@Valid @RequestBody DeptEmpRequestDto requestDto) {

        try {
            service.recordDeptEmp(new DeptEmp(
                    requestDto.getEmpNo(),
                    requestDto.getDeptNo(),
                    requestDto.getFromDate(),
                    requestDto.getToDate()

            ));
        } catch (DeptEmpAlreadyExistsException | UnknownEmployeeException | UnknownDepartmentException e){
            log.error("Exception: {} handled with message: "+e.getMessage(),e.getClass());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
        return "DeptEmp successfully created";
    }

    @DeleteMapping("/delete/{empNo}/{deptNo}")
    public String deleteDeptEmp(@PathVariable("empNo") EmployeeEntity empNo, @PathVariable("deptNo") DepartmentEntity deptNo)  {
        try{
            service.deleteDeptEmpByEmpNoAndDeptNo(empNo, deptNo);
        }catch (UnknownDeptEmpException e){
            log.error("Exception: {} handled with message: "+e.getMessage(),e.getClass());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        } catch (UnknownDepartmentException | UnknownEmployeeException e) {
            e.printStackTrace();
        }
        return "DeptEmp successfully deleted";
    }


    @PutMapping("/update")
    public String update(@Valid @RequestBody DeptEmpRequestDto deptEmpRequestDto) {
        try{
            service.updateDeptEmp(new DeptEmp(
                    deptEmpRequestDto.getEmpNo(),
                    deptEmpRequestDto.getDeptNo(),
                    deptEmpRequestDto.getFromDate(),
                    deptEmpRequestDto.getToDate()
            ));
        }catch (UnknownDeptEmpException | UnknownEmployeeException | UnknownDepartmentException e){
            log.error("Exception: {} handled with message: "+e.getMessage(),e.getClass());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
        return "DeptEmp successfully updated";
    }
}