package uz.pdp.task1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.task1.entity.Company;
import uz.pdp.task1.payload.ApiResponse;
import uz.pdp.task1.payload.CompanyDto;
import uz.pdp.task1.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Company> companies = companyService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(companies);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCompany(@PathVariable Long id){
        Company company = companyService.getCompany(id);
        return ResponseEntity.status(HttpStatus.OK).body(company);
    }

    @PostMapping
    public ResponseEntity<?> addCompany(@RequestBody CompanyDto companyDto){
        ApiResponse apiResponse = companyService.addCompany(companyDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }
}
