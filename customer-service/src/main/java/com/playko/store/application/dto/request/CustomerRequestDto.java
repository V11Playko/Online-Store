package com.playko.store.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequestDto {
    private Long id;
    private String dni;
    private String firstName;
    private String lastName;
    private String email;
    private String photoUrl;
    private String state;
    // Region
    private Long idRegion;
    private String nameRegion;

}
