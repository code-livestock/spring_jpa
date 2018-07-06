package com.anyi.service;

import com.anyi.dao.CustomerRepository;
import com.anyi.dao.impl.CustomerImpl;
import com.anyi.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerImpl customerImpl;
    @Autowired
    private CustomerRepository customerRepository;
    public List<Customer> findCustomerByJPQL(String id){
        return  customerRepository.findCustomer(id);
    }
    public void save(Customer customer) {
        customerRepository.save(customer);
    }
    public List<Customer> findAllSort(){
        return  customerImpl.findAllSort();
    }
    public List<Customer> findCustomerByCondition(Customer customer){
        return  customerImpl.findCustomerByCriteria(customer);
    }
    public Page<Customer> findCustomerBySpecification(Customer customer, int page, int size){
        return  customerImpl.findCustomerBySpecification(customer,page,size);
    }
    public  Customer findByName(String name){
        return  customerRepository.findByName(name);
    }

}
