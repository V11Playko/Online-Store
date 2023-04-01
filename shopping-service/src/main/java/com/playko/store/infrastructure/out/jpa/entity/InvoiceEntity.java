package com.playko.store.infrastructure.out.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_invoice")
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private String description;
    private Long customerId;
    private Date createAt;
    private String state;

    // Una factura puede tener muchos items
    @OneToMany(mappedBy = "invoice",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ItemEntity> items;
}
