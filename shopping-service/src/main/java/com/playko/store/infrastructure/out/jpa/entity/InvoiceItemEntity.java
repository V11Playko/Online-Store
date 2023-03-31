package com.playko.store.infrastructure.out.jpa.entity;

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

@Entity
@Table(name = "tbl_item")
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceItemEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItem;
    @Column(name = "Cantidad", length = 50)
    private Double quantityItem;
    @Column(name = "Precio", length = 50)
    private Double priceItem;
    @Column(name = "Id_Producto", length = 50)
    private Long productId;
}
