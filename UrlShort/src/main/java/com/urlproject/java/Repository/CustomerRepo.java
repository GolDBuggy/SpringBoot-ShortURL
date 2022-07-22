package com.urlproject.java.Repository;

import com.urlproject.java.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepo extends JpaRepository<Customer,Long> {

    @Query("select u from Customer u where u.id= :paramId")
    public Customer findId(@Param("paramId") Long id);
}
