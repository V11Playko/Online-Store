package com.playko.store.infrastructure.out.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.playko.store.domain.model.InvoiceItemModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    private Long idInvoice;
    @Column(name = "Numero_factura", length = 50)
    private String numberInvoice;
    @Column(name = "Descripcion_factura", length = 50)
    private String descriptionInvoice;
    @Column(name = "Id_cliente", length = 50)
    private Long customerId;
    @Column(name = "Fecha_factura", length = 50)
    private Date createAtInvoice;
    @Column(name = "Estado_factura", length = 50)
    private String stateInvoice;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_item")
    private List<InvoiceItemEntity> itemInvoice;
}
