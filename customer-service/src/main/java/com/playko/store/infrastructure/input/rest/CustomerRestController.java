package com.playko.store.infrastructure.input.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.playko.store.application.dto.response.CustomerResponseDto;
import com.playko.store.application.dto.request.CustomerRequestDto;
import com.playko.store.application.handler.ICustumerHandler;
import com.playko.store.domain.model.RegionModel;
import com.playko.store.infrastructure.exception.ErrorMessage;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerRestController {
    private final ICustumerHandler custumerHandler;
    private final ErrorMessage errorMessage;

    @Operation(summary = "Add a new Customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Customer already exists", content = @Content)
    })
    @GetMapping("/all")
    public ResponseEntity<List<CustomerResponseDto>> listCustomer(@RequestParam(name = "regionId", required = false) Long regionId){
        List<CustomerResponseDto> customers = new ArrayList<>();
        if (regionId == null){
            customers = custumerHandler.listAllCustomer();
            if (customers.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }else {
            customers = custumerHandler.findByRegion((RegionModel) customers);
            if (customers.isEmpty()){
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.ok(customers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerResponseDto> getCustomer(@PathVariable("id") Long id){
        CustomerResponseDto customer = custumerHandler.getCustomer(id);
        if (customer == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }

    @Operation(summary = "Add a new Customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Customer already exists", content = @Content)
    })
    @PostMapping("/createCustomer")
    public ResponseEntity<Void> createCustomer(@RequestBody CustomerRequestDto customer, BindingResult result) {
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        custumerHandler.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Updated Customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer Updated", content = @Content),
            @ApiResponse(responseCode = "409", description = "Customer already exists", content = @Content)
    })
    @PutMapping("/putCustomer/{id}")
    public ResponseEntity<Void> putCustomer(@PathVariable("id") Long id, @RequestBody CustomerRequestDto customer){
        customer.setId(id);
        custumerHandler.updateCustomer(customer);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Operation(summary = "Customer Product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer Delete", content = @Content),
            @ApiResponse(responseCode = "409", description = "conflict with server", content = @Content)
    })
    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Long id){
        custumerHandler.deleteCustomer(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }




    private String formatMessage( BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err ->{
                    Map<String,String>  error =  new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;

                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString="";
        try {
            jsonString = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

}
