package com.customer.save.service.gateway.repository;

import com.customer.save.service.domain.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CustomerRepository extends CrudRepository<Customer, UUID> {

}