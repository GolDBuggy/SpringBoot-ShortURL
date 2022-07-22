package com.urlproject.java.Service;

import com.urlproject.java.Exceptions.CustomerNotFoundException;
import com.urlproject.java.Model.Customer;
import com.urlproject.java.Repository.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepo repo;

    public List<Customer> customers(){
        return repo.findAll();
    }

    public Customer findById(Long id){
        Customer customer=repo.findId(id);

        if(customer==null)
            throw new CustomerNotFoundException("Customer Not Found!");


        return customer;
    }

    public void save(Customer customer) {
        repo.save(customer);
    }

    public void deleteAll(){
        repo.deleteAll();
    }


    public void deleteById(Long id){
        if(id==null)
            throw new CustomerNotFoundException("Customer Not Found!");

        repo.deleteById(id);
    }
}
