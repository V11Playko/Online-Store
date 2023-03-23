package com.playko.store.application.dto.response;

import com.playko.store.domain.model.RegionModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponseDto {
    private Long id;
    private String dni;
    private String firstName;
    private String lastName;
    private String email;
    private String photoUrl;
    private RegionModel regionModel;
    private String state;
}
