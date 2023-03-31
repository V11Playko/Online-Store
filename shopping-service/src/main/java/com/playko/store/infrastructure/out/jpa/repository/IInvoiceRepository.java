package com.playko.store.infrastructure.out.jpa.repository;

import com.playko.store.infrastructure.out.jpa.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInvoiceRepository extends JpaRepository<InvoiceEntity, Long> {
}
