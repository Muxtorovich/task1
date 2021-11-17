package uz.pdp.task1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.task1.entity.Company;
import uz.pdp.task1.payload.ApiResponse;
import uz.pdp.task1.payload.CompanyDto;
import uz.pdp.task1.repository.CompanyRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepo companyRepo;

    public List<Company> getAll() {
        List<Company> companyList = companyRepo.findAll();
        return companyList;
    }

    public Company getCompany(Long id) {
        Optional<Company> optionalCompany = companyRepo.findById(id);
        if (optionalCompany.isPresent()){
            Company company = optionalCompany.get();
            return company;
        }
        return null;
    }

    public ApiResponse addCompany(CompanyDto companyDto) {
        Company company = new Company();
        company.setCompName(companyDto.getCompName());
        company.setDirectorName(companyDto.getDirectorName());
        company.setAddress(companyDto.getAddress());
        companyRepo.save(company);
        return new ApiResponse("Company added!", true);
    }
}
