package com.playko.store.infrastructure.out.jpa.entity;

import com.playko.store.domain.model.InvoiceModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "invoice")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class InvoiceEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private String description;
    private Long customerId;
    private LocalDate createAt;
    private String state;

    // Una factura puede tener muchos items
    @OneToMany(mappedBy = "invoice")
    private List<ItemEntity> items;

    public static InvoiceEntity ofInvoiceModel(InvoiceModel invoiceModel) {
        return InvoiceEntity.builder()
                .number(invoiceModel.getNumber())
                .description(invoiceModel.getDescription())
                .customerId(invoiceModel.getCustomerId())
                .createAt(invoiceModel.getCreateAt())
                .state(invoiceModel.getState())
                .items(ItemEntity.ofItemModelList(invoiceModel.getItems()))
                .build();
    }
}
