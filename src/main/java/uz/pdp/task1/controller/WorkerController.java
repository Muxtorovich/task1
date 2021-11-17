package uz.pdp.task1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.task1.entity.Worker;
import uz.pdp.task1.payload.ApiResponse;
import uz.pdp.task1.payload.WorkerDto;
import uz.pdp.task1.service.WorkerService;

import java.util.List;

@RestController
@RequestMapping("/api/worker")
public class WorkerController {

    @Autowired
    WorkerService workerService;

    @GetMapping
    public List<Worker> getAll(){
        List<Worker> workerList = workerService.getAll();
        return workerList;
    }

    @GetMapping("{id}")
    public Worker getWorker(@PathVariable Long id){
        Worker worker = workerService.getWorker(id);
        return worker;
    }

    @PostMapping
    public ResponseEntity<?> addWorker(@RequestBody WorkerDto workerDto){
        ApiResponse apiResponse = workerService.addWorker(workerDto);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @PutMapping("{id}")
    public ApiResponse editWorker(@PathVariable Long id, @RequestBody WorkerDto workerDto){
        ApiResponse apiResponse = workerService.editWorker(id, workerDto);
        return apiResponse;
    }

    @DeleteMapping("{id}")
    public ApiResponse deleteWorker(@PathVariable Long id){
        ApiResponse apiResponse = workerService.deleteWorker(id);
        return apiResponse;
    }

}
