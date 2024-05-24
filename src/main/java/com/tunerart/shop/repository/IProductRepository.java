package com.tunerart.shop.repository;

import com.tunerart.shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
    @Query(value = "SELECT * FROM product WHERE LOWER(name) LIKE LOWER(CONCAT('%', :name, '%'))",nativeQuery = true)
    Optional<Product> findProductByNameContainingIgnoreCase(@Param("name") String name);
}
