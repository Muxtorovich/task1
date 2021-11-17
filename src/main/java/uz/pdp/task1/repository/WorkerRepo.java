package uz.pdp.task1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.task1.entity.Worker;

public interface WorkerRepo extends JpaRepository<Worker, Long> {

    boolean existsByPhoneNumber(String phoneNumber);
    boolean existsByPhoneNumberAndIdNot(String phoneNumber, Long id);
}
