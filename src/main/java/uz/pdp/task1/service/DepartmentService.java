package uz.pdp.task1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import uz.pdp.task1.entity.Address;
import uz.pdp.task1.entity.Company;
import uz.pdp.task1.entity.Department;
import uz.pdp.task1.payload.ApiResponse;
import uz.pdp.task1.payload.DepartmentDto;
import uz.pdp.task1.repository.AddressRepo;
import uz.pdp.task1.repository.CompanyRepo;
import uz.pdp.task1.repository.DepartmentRepo;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    AddressRepo addressRepo;

    @Autowired
    CompanyRepo companyRepo;

    @Autowired
    DepartmentRepo departmentRepo;

    public ApiResponse addDepartment(@RequestBody DepartmentDto departmentDto){
        boolean existsByDepartmentName = departmentRepo.existsByDepartmentName(departmentDto.getDepartmentName());
        if (existsByDepartmentName)
            return new ApiResponse("Bunday department mavjud!", false);
        Address address = new Address();
        address.setStreet(departmentDto.getStreet());
        address.setHomeNumber(departmentDto.getHomeNumber());
        addressRepo.save(address);
        Department department = new Department();
        department.setDepartmentName(departmentDto.getDepartmentName());
        Company company = new Company();
        company.setCompName(departmentDto.getCompany());
        company.setDirectorName(departmentDto.getCompanyDirector());
        company.setAddress(address);
        companyRepo.save(company);
        department.setCompany(company);
        departmentRepo.save(department);
        return new ApiResponse("Department added!", true);
    }

    public List<Department> getAll() {
        List<Department> departmentList = departmentRepo.findAll();
        return departmentList;
    }

    public Department getDepartment(Long id) {
        Optional<Department> optionalDepartment = departmentRepo.findById(id);
        if (optionalDepartment.isPresent()){
            Department department = optionalDepartment.get();
            return department;
        }
        return null;
    }

    public ApiResponse editDepartment(Long id, DepartmentDto departmentDto) {
        Optional<Department> optionalDepartment = departmentRepo.findById(id);
        if (optionalDepartment.isPresent()){
            Address address = new Address();
            address.setStreet(departmentDto.getStreet());
            address.setHomeNumber(departmentDto.getHomeNumber());
            addressRepo.save(address);
            Company company = new Company();
            company.setCompName(departmentDto.getCompany());
            company.setDirectorName(departmentDto.getCompanyDirector());
            company.setAddress(address);
            companyRepo.save(company);
            Department department = optionalDepartment.get();
            department.setDepartmentName(departmentDto.getDepartmentName());
            department.setCompany(company);
            departmentRepo.save(department);
            return new ApiResponse("Department edited!", true);
        }
        return new ApiResponse("Department not found!", false);
    }

    public ApiResponse deleteDepartment(Long id) {
        try {
            departmentRepo.deleteById(id);
            return new ApiResponse("Department deleted!", true);
        }catch (Exception e){
            return new ApiResponse("Error!!!", false);
        }
    }
}
