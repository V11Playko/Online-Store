package com.playko.store.domain.usecase;

import com.playko.store.application.dto.request.CustomerRequestDto;
import com.playko.store.domain.model.CustomerModel;
import com.playko.store.domain.model.RegionModel;

public class CustomerUseCaseDataTest {
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
}
