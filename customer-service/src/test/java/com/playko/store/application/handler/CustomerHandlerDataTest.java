package com.playko.store.application.handler;

import com.playko.store.application.dto.request.CustomerRequestDto;
import com.playko.store.domain.model.CustomerModel;
import com.playko.store.domain.model.RegionModel;

import java.util.ArrayList;
import java.util.List;

public class CustomerHandlerDataTest {
    public static CustomerModel obtainCustomer() {

        return new CustomerModel(
                2L,
                "1004925638",
                "Heinner",
                "Vega",
                "ajota@gmail.com",
                "uhasdhuasdkhajksdkasd",
                new RegionModel(
                        2L,
                        "Norte de santander"
                ),
                "CREATED"
        );
    }
    public static CustomerRequestDto obtainCustomerRequest() {
        CustomerRequestDto customer = new CustomerRequestDto();

        customer.setDni("1004925638");
        customer.setFirstName("Heinner");
        customer.setLastName("Vega");
        customer.setEmail("ajota@gmail.com");
        customer.setPhotoUrl("uhasdhuasdkhajksdkasd");
        customer.setState("CREATED");
        RegionModel region = new RegionModel(1L, "Norte de santader");

        return customer;
    }

    public static List<CustomerModel> obtainCustomers() {
        List<CustomerModel> customerList = new ArrayList<>();
        return  customerList;
    }

}
