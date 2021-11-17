package uz.pdp.task1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.task1.entity.Company;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Long> {
}
