package uz.pdp.task1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.task1.entity.Address;
import uz.pdp.task1.entity.Department;
import uz.pdp.task1.entity.Worker;
import uz.pdp.task1.payload.ApiResponse;
import uz.pdp.task1.payload.WorkerDto;
import uz.pdp.task1.repository.AddressRepo;
import uz.pdp.task1.repository.DepartmentRepo;
import uz.pdp.task1.repository.WorkerRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {

    @Autowired
    WorkerRepo workerRepo;

    @Autowired
    AddressRepo addressRepo;

    @Autowired
    DepartmentRepo departmentRepo;

    public List<Worker> getAll() {
        return workerRepo.findAll();
    }

    public Worker getWorker(Long id) {
        Optional<Worker> optionalWorker = workerRepo.findById(id);
        return optionalWorker.orElse(null);
    }

    public ApiResponse addWorker(WorkerDto workerDto) {
        boolean existsByPhoneNumber = workerRepo.existsByPhoneNumber(workerDto.getPhoneNumber());
        if (existsByPhoneNumber)
            return new ApiResponse("Bunday ishchi mavjud!", false);
        Worker worker = new Worker();
        worker.setName(workerDto.getName());
        worker.setPhoneNumber(workerDto.getPhoneNumber());
        Address address = new Address();
        address.setStreet(workerDto.getStreet());
        address.setHomeNumber(workerDto.getHomeNumber());
        addressRepo.save(address);
        worker.setAddress(address);
        Department department = new Department();
        department.setDepartmentName(workerDto.getDepartmentName());
        departmentRepo.save(department);
        worker.setDepartment(department);
        workerRepo.save(worker);
        return new ApiResponse("Worker added!", true);
    }


    public ApiResponse editWorker(Long id, WorkerDto workerDto) {
        boolean numberAndIdNot = workerRepo.existsByPhoneNumberAndIdNot(workerDto.getPhoneNumber(), id);
        if (numberAndIdNot){
            return new ApiResponse("Bunday telefon raqamli ishchi mavjud!", false);
        }
        Optional<Worker> optionalWorker = workerRepo.findById(id);
        if (!optionalWorker.isPresent()){

            return new ApiResponse("Worker not found!", false);
        }

        Worker worker = optionalWorker.get();
        worker.setName(workerDto.getName());
        worker.setPhoneNumber(workerDto.getPhoneNumber());
        Address address = new Address();
        address.setStreet(workerDto.getStreet());
        address.setHomeNumber(workerDto.getHomeNumber());
        addressRepo.save(address);
        worker.setAddress(address);
        Department department = new Department();
        department.setDepartmentName(workerDto.getDepartmentName());
        departmentRepo.save(department);
        worker.setDepartment(department);
        workerRepo.save(worker);
        return new ApiResponse("Worker edited!", true);
    }

    public ApiResponse deleteWorker(Long id) {
        workerRepo.deleteById(id);
        return new ApiResponse("Worker deleted!", true);
    }
}
