package com.task.productTask.Repositatory;

import com.task.productTask.Entity.Catagory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatagoryRepositatory extends JpaRepository<Catagory, Long> {
}
