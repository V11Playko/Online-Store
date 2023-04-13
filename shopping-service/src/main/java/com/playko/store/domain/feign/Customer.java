package com.playko.store.domain.feign;

import lombok.Data;

@Data
public class Customer {
    private Long id;
    private String dni;
    private String firstName;
    private String lastName;
    private String email;
    private String photoUrl;
    private String state;
    private Region region;
}
