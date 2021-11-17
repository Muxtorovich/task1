package uz.pdp.task1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.task1.entity.Address;
import uz.pdp.task1.service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping
    public List<Address> getAddress(){
        List<Address> address = addressService.getAddress();
        return address;
    }
}
