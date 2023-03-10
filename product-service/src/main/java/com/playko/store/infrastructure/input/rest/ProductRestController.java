package com.playko.store.infrastructure.input.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.playko.store.application.dto.request.ProductRequestDto;
import com.playko.store.application.dto.response.ProductResponseDto;
import com.playko.store.application.handler.IProductHandler;
import com.playko.store.domain.model.CategoryModel;
import com.playko.store.infrastructure.exception.ErrorMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Valid
@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductRestController {
    private final IProductHandler productHandler;
    private final ErrorMessage errorMessage;
    @Operation(summary = "Add a new Product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Product already exists", content = @Content)
    })
    @GetMapping("/all")
    public ResponseEntity<List<ProductResponseDto>> listProduct(@RequestParam(name = "categoryId", required = false) Long categoryId){
        List<ProductResponseDto> products = new ArrayList<>();
        if (categoryId == null){
            products = productHandler.listAllProduct();
            if (products.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }else{
            products = productHandler.findByCategory((CategoryModel) products);
            if (products.isEmpty()){
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.ok(products);
        }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable("id") Long id){
        ProductResponseDto product = productHandler.getProduct(id);
        if (product == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }
    @Operation(summary = "Add a new Product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Product already exists", content = @Content)
    })
    @PostMapping("/createProduct")
    public ResponseEntity<Void> createProduct(@RequestBody ProductRequestDto product, BindingResult result) {
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        productHandler.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @Operation(summary = "Updated Product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product Updated", content = @Content),
            @ApiResponse(responseCode = "409", description = "Product already exists", content = @Content)
    })
    @PutMapping("/putProduct/{id}")
    public ResponseEntity<Void> putProduct(@PathVariable("id") Long id, @RequestBody ProductRequestDto product) {
        product.setId(id);
        productHandler.updateProduct(product);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @Operation(summary = "Delete Product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product Delete", content = @Content),
            @ApiResponse(responseCode = "409", description = "conflict with server", content = @Content)
    })
    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        productHandler.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @Operation(summary = "Updated Stock Product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Updated Stock Product", content = @Content),
            @ApiResponse(responseCode = "409", description = "Stock Product already exists", content = @Content)
    })
    @PutMapping("/{id}/stock")
    public ResponseEntity<Void> updateStockProduct(@PathVariable Long id,@RequestParam(name = "quantity", required = true) Double quantity) {
        productHandler.updateStock(id, quantity);
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

