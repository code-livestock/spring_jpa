package com.anyi.dao;

import com.anyi.pojo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sun.awt.SunHints;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>,JpaSpecificationExecutor<Customer> {
    @Query(value = "select  c from Customer c where c.id =?1 ")
    public List<Customer> findCustomer(String id);

    public Customer findByName(String name);
}
