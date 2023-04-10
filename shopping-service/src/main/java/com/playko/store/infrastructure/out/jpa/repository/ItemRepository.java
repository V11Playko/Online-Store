package com.playko.store.infrastructure.out.jpa.repository;

import com.playko.store.infrastructure.out.jpa.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
}
