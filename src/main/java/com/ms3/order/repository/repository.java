package com.ms3.order.repository;
import com.ms3.order.model.order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repository extends JpaRepository<order, Long>  {
}
