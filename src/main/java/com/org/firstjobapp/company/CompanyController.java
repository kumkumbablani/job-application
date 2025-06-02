package com.org.firstjobapp.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }


    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company Added Successfully" , HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Company>> getAllCompany(){
        return new ResponseEntity<>(companyService.getAllCompanies() , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getComapanyById(@PathVariable Long id){
        Company company = companyService.getCompanyById(id);
        if (company != null){
            return new ResponseEntity<>(company , HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@RequestBody Company company ,
                                                @PathVariable Long id){
        companyService.updateCompany(company , id);
        return new ResponseEntity<>("Company Updated Successfully" , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeCompany(@PathVariable Long id){
        boolean isDeleted = companyService.deleteCompanyById(id);
        if (isDeleted){
            return new ResponseEntity<>("Company Deleted Successfully" , HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Company Not Found" , HttpStatus.NOT_FOUND);
        }
    }
}
