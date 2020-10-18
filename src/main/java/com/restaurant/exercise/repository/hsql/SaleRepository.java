package com.restaurant.exercise.repository.hsql;

import com.restaurant.exercise.repository.model.Sale;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale,Integer> {
    List<Sale> findAllByDate(LocalDate date);
}
