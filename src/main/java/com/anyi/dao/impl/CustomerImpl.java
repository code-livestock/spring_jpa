package com.anyi.dao.impl;

import com.anyi.dao.CustomerRepository;
import com.anyi.pojo.Customer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerImpl {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private EntityManager entityManager;

    public  List<Customer> findByJPQL(){

        return null;
    };
     public List<Customer> findAllSort(){
         Sort sort = new Sort(Sort.Direction.DESC,"createTime");
         return  customerRepository.findAll(sort);
     };
     public List<Customer> findCustomerByCriteria(Customer customer){
         CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
         CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
         Root<Customer> customerRoot = criteriaQuery.from(Customer.class);
         criteriaQuery.select(customerRoot);//查询全部
         List<Predicate> list = new ArrayList<>();
         Predicate idPre = null;
         if (!StringUtils.isEmpty(customer.getId())){
            list.add(criteriaBuilder.equal(customerRoot.get("id"),customer.getId()));
         }
         if (!StringUtils.isEmpty(customer.getName())){
             list.add(criteriaBuilder.like(customerRoot.get("name"),"%"+customer.getName()+"%"));
         }

         criteriaQuery.where(list.toArray(new Predicate[list.size()]));
         Query query = entityManager.createQuery(criteriaQuery);
         List<Customer> customers = query.getResultList();
         return  customers;
     }
     @Transactional
     public Page<Customer> findCustomerBySpecification(Customer customer, int page, int size){
         Sort sort = new Sort(Sort.Direction.ASC,"createTime");
         Pageable pageable =PageRequest.of(page, size,sort);
         return  customerRepository.findAll(new Specification<Customer>() {
             @Nullable
             @Override
             public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                 List<Predicate> predicates = new ArrayList<>();
//                 root.join()root.getModel().getList()
                 if (!StringUtils.isEmpty(customer.getId())) {
                     predicates.add(criteriaBuilder.equal(root.get("id"),customer.getId()));
                 }
                 if (!StringUtils.isEmpty(customer.getName())){
                     predicates.add(criteriaBuilder.like(root.get("name"),"%"+customer.getName()+"%"));
                 }
                 if (!StringUtils.isEmpty(customer.getPhone())){
                     predicates.add(criteriaBuilder.equal(root.get("phone"),customer.getPhone()));
                 }
                 return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
             }
         },pageable);
     }
}
