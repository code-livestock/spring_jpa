package com.anyi.web;

import com.anyi.pojo.Customer;
import com.anyi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@ResponseBody
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customer/findCustomerByName")
    public Customer findByName(@RequestBody Customer customer) {
        String name = customer.getName();
        return customerService.findByName(name);
    };
    @RequestMapping(value = "/customer/findCustomerByJpql")
    public List<Customer> findCustomerByJpql(@RequestBody Customer customer) {
        String id= customer.getId();
       return customerService.findCustomerByJPQL(id);
    };
    @RequestMapping(value = "/customer/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {
        customer.setCreateTime(new Date());
        customerService.save(customer);
        return customer;
    };
    @RequestMapping(value = "/customer/findCustomer")
    public List<Customer> findCustomerByCondition(@RequestBody Customer customer){
        return  customerService.findCustomerByCondition(customer);
    }
    @RequestMapping(value = "/customer/findAllSort")
    public List<Customer> findAllSort(){
        return  customerService.findAllSort();
    }
    @RequestMapping(value = "/customer/findCustomerBySpecification")
    public Page<Customer> findCustomerBySpecification(@RequestBody Customer customer){
        int page = 0;
        int size = 10;
        return  customerService.findCustomerBySpecification(customer,page,size);
    }
}
