package com.playko.store.infrastructure.input.rest;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.playko.store.application.dto.request.InvoiceRequestDto;
import com.playko.store.application.dto.request.SaveInvoiceRequestDto;
import com.playko.store.application.dto.response.InvoiceResponseDto;
import com.playko.store.application.handler.IInvoiceHandler;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/invoice")
@RequiredArgsConstructor
public class InvoiceRestController {
    private final IInvoiceHandler invoiceHandler;
    private final ErrorMessage errorMessage;

    @Operation(summary = "Add a new Invoice")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Invoice created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Invoice already exists", content = @Content)
    })
    @GetMapping("/all")
    public ResponseEntity<List<InvoiceResponseDto>> listInvoice(@RequestParam(name = "itemId", required = false) Long itemId) {
        List<InvoiceResponseDto> invoices = new ArrayList<>();
        if (itemId == null) {
            invoices = invoiceHandler.listAllInvoice();
            if (invoices.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.ok(invoices);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<InvoiceResponseDto> getInvoice(@PathVariable("id") Long id) {
        InvoiceResponseDto invoice = invoiceHandler.getInvoice(id);
        if (invoice == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(invoice);
    }

    @Operation(summary = "Add a new Invoice")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Invoice created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Invoice already exists", content = @Content)
    })
    @PostMapping("/createInvoice")
    public ResponseEntity<Void> createInvoice(@RequestBody SaveInvoiceRequestDto request) {
        invoiceHandler.createInvoice(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Updated Invoice")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Invoice Updated", content = @Content),
            @ApiResponse(responseCode = "409", description = "Invoice already exists", content = @Content)
    })
    @PutMapping("/putInvoice/{id}")
    public ResponseEntity<Void> putInvoice(@PathVariable("id") Long id, @RequestBody InvoiceRequestDto invoice) {
        invoice.setId(id);
        invoiceHandler.updateInvoice(invoice);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Operation(summary = "Invoice Product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Invoice Delete", content = @Content),
            @ApiResponse(responseCode = "409", description = "conflict with server", content = @Content)
    })
    @DeleteMapping("/deleteInvoice/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable("id") Long id) {
        invoiceHandler.deleteInvoice(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    private String formatMessage(BindingResult result) {
        List<Map<String, String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String, String> error = new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;

                }).collect(Collectors.toList());
        com.playko.store.infrastructure.exception.ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
