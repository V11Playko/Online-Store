package com.playko.store.infrastructure.out.jpa.repository;

import com.playko.store.infrastructure.out.jpa.entity.CustomerEntity;
import com.playko.store.infrastructure.out.jpa.entity.RegionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long> {
    List<CustomerEntity> findByRegion(RegionEntity region);
}
