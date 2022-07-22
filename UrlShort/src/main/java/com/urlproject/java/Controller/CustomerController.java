package com.urlproject.java.Controller;

import com.urlproject.java.Model.Customer;
import com.urlproject.java.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;


    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAll(){
        return ResponseEntity.ok(service.customers());
    }

    @PostMapping("/save")
    public Customer save(@RequestBody Customer customer){
        service.save(customer);
        return customer;
    }

    @PutMapping("/update")
    public Customer update(@RequestBody Customer customer){
        service.save(customer);
        return customer;
    }

    @DeleteMapping("/delete")
    public String delete(){
        service.deleteAll();
        return "Customers Deleted Successfully!";
    }


    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        service.deleteById(id);
        return "Customers Deleted Successfully!";
    }


    @GetMapping("/{id}")
    public Customer getId(@PathVariable long id){
        return service.findById(id);
    }



}
