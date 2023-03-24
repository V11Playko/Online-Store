package com.playko.store.infrastructure.out.jpa.entity;

import com.playko.store.domain.model.RegionModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tbl_customer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "DNI", length = 50)
    private String dni;
    @Column(name = "Nombre", length = 50)
    private String firstName;
    @Column(name = "Apellido", length = 50)
    private String lastName;
    @Column(name = "Email", length = 50)
    private String email;
    @Column(name = "Foto", length = 50)
    private String photoUrl;
    @Column(name = "Estado", length = 50)
    private String state;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private RegionEntity region;
}
