package uz.pdp.task1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.task1.entity.Department;
import uz.pdp.task1.payload.ApiResponse;
import uz.pdp.task1.payload.DepartmentDto;
import uz.pdp.task1.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Department> departmentList = departmentService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(departmentList);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getDepartment(@PathVariable Long id) {
        Department department = departmentService.getDepartment(id);
        return ResponseEntity.status(HttpStatus.OK).body(department);
    }

    @PostMapping
    public ResponseEntity<?> addDepartment(@RequestBody DepartmentDto departmentDto) {
        ApiResponse apiResponse = departmentService.addDepartment(departmentDto);
        return ResponseEntity.status(apiResponse.isSuccess()?HttpStatus.CREATED:HttpStatus.CONFLICT).body(apiResponse);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> editDepartment(@PathVariable Long id, @RequestBody DepartmentDto departmentDto){
        ApiResponse apiResponse = departmentService.editDepartment(id, departmentDto);
        return ResponseEntity.status(apiResponse.isSuccess()?HttpStatus.ACCEPTED:HttpStatus.CONFLICT).body(apiResponse);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Long id){
        ApiResponse apiResponse = departmentService.deleteDepartment(id);
        return ResponseEntity.status(apiResponse.isSuccess()?202:409).body(apiResponse);
    }

}
