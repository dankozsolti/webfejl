package hu.dpara.webfejl.controller;

import hu.dpara.webfejl.controller.dto.SalaryDto;
import hu.dpara.webfejl.controller.dto.SalaryRequestDto;
import hu.dpara.webfejl.dao.entity.EmployeeEntity;
import hu.dpara.webfejl.dao.entity.SalaryId;
import hu.dpara.webfejl.exception.SalaryAlreadyExistsException;
import hu.dpara.webfejl.exception.UnknownEmployeeException;
import hu.dpara.webfejl.exception.UnknownSalaryException;
import hu.dpara.webfejl.exception.UnknownTitleException;
import hu.dpara.webfejl.model.Salary;
import hu.dpara.webfejl.services.SalaryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.sql.Date;
import java.util.Collection;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/salaries")
public class SalaryController {

    private final SalaryService service;

    @GetMapping("/getAll")
    public Collection<SalaryDto> listSalary(){
        return service.getAllSalary()
                .stream()
                .map(model -> SalaryDto.builder()
                        .empNo(model.getEmpNo())
                        .salary(model.getSalary())
                        .fromDate(model.getFromDate())
                        .toDate(model.getToDate())
                        .build())
                .collect(Collectors.toList());
    }

    @PostMapping("/create")
    public String record(@Valid @RequestBody SalaryRequestDto requestDto) {

        try {
            service.recordSalary(new Salary(
                    requestDto.getEmpNo(),
                    requestDto.getSalary(),
                    requestDto.getFromDate(),
                    requestDto.getToDate()

            ));
        } catch (SalaryAlreadyExistsException | UnknownEmployeeException e){
            log.error("Exception: {} handled with message: "+e.getMessage(),e.getClass());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
        return "Salary successfully created";
    }

    @DeleteMapping("/delete/{empNo}/{fromDate}")
    public String deleteTitleByEmpNo(@PathVariable("empNo") EmployeeEntity empNo,
                                     @PathVariable("fromDate") Date fromDate)  {
        try{
            service.deleteByEmpNoAndFromDate(empNo,fromDate);
        }catch (UnknownEmployeeException | UnknownSalaryException e){
            log.error("Exception: {} handled with message: "+e.getMessage(),e.getClass());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
        return "Salary successfully deleted";
    }


    @PutMapping("/update")
    public String update(@Valid @RequestBody SalaryRequestDto salaryDto) {
        try{
            service.updateSalary(new Salary(
                    salaryDto.getEmpNo(),
                    salaryDto.getSalary(),
                    salaryDto.getFromDate(),
                    salaryDto.getToDate()
            ));
        }catch (UnknownSalaryException | UnknownEmployeeException e){
            log.error("Exception: {} handled with message: "+e.getMessage(),e.getClass());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
        return "Salary successfully updated";
    }
}
