package hu.dpara.webfejl.controller;

import hu.dpara.webfejl.controller.dto.DepartmentDto;
import hu.dpara.webfejl.controller.dto.DepartmentRequestDto;
import hu.dpara.webfejl.exception.DepartmentAlreadyExistsException;
import hu.dpara.webfejl.exception.UnknownDepartmentException;
import hu.dpara.webfejl.model.Department;
import hu.dpara.webfejl.services.DepartmentService;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping(path = "/department")
public class DepartmentController {

    private final DepartmentService service;

    @GetMapping("/getAll")
    public Collection<DepartmentDto> listDepartment(){
        return service.getAllDepartment()
                .stream()
                .map(model -> DepartmentDto.builder()
                        .deptNo(model.getDeptNo())
                        .deptName(model.getDeptName())
                        .build())
                .collect(Collectors.toList());
    }

    @PostMapping("/create")
    public String record(@Valid @RequestBody DepartmentRequestDto requestDto) {

        try {
            service.recordDepartment(new Department(
                    requestDto.getDeptNo(),
                    requestDto.getDeptName()

            ));
        } catch ( DepartmentAlreadyExistsException e){
            log.error("Exception: {} handled with message: "+e.getMessage(),e.getClass());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
        return "Department successfully created";
    }

    @DeleteMapping("/delete/{deptNo}")
    public String deleteDepartment(@PathVariable("deptNo") String deptNo)  {
        try{
            service.deleteDepartmentByDeptNo(deptNo);
        }catch (UnknownDepartmentException e){
            log.error("Exception: {} handled with message: "+e.getMessage(),e.getClass());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
        return "Department successfully deleted";
    }


    @PutMapping("/update")
    public String update(@Valid @RequestBody DepartmentRequestDto departmentDto) {
        try{
            service.updateDepartment(new Department(
                    departmentDto.getDeptNo(),
                    departmentDto.getDeptName()
            ));
        }catch (UnknownDepartmentException e){
            log.error("Exception: {} handled with message: "+e.getMessage(),e.getClass());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
        return "Department successfully updated";
    }
}