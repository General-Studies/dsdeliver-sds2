package com.jetherrodrigues.sds2.repository;

import com.jetherrodrigues.sds2.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
