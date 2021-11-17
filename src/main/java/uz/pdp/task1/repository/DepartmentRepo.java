package uz.pdp.task1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.task1.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
    boolean existsByDepartmentName(String departmentName);
}
