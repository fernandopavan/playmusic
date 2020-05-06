package com.customer.save.api.gateway.http;

import com.customer.save.api.gateway.json.CustomerJson;
import com.customer.save.api.service.SaveCustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/v1")
public class CustomerController {

    @Autowired
    private SaveCustomerService saveCustomerService;

    @PostMapping("/")
    public String create(@RequestBody CustomerJson customerJson) throws ExecutionException, InterruptedException, JsonProcessingException {
        return saveCustomerService.execute(customerJson);
    }

}