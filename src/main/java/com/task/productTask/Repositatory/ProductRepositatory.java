package com.task.productTask.Repositatory;

import com.task.productTask.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositatory extends JpaRepository<ProductEntity, Long> {
}
