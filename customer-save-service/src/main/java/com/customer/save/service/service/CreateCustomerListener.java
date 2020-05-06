package com.customer.save.service.service;


import com.customer.save.service.domain.Customer;
import com.customer.save.service.gateway.json.CustomerJson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateCustomerListener {

    @Autowired
    private CreateCustomerService createCustomerService;

    @SendTo
    @KafkaListener(topics = "${kafka.topic.request-topic}")
    public String listen(String json) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        CustomerJson customerJson = mapper.readValue(json, CustomerJson.class);

        Customer build = Customer.builder()
                .country(customerJson.getCountry())
                .musicStyle(customerJson.getMusicStyle())
                .name(customerJson.getName())
                .build();

        UUID uuid = createCustomerService.execute(build);

        customerJson.setUuid(uuid.toString());

        return mapper.writeValueAsString(customerJson);
    }

}