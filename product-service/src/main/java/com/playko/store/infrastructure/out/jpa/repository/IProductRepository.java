package com.playko.store.infrastructure.out.jpa.repository;

import com.playko.store.infrastructure.out.jpa.entity.CategoryEntity;
import com.playko.store.infrastructure.out.jpa.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface IProductRepository extends JpaRepository<ProductEntity, Long> {
    public List<ProductEntity> findByCategory(CategoryEntity category);
}
