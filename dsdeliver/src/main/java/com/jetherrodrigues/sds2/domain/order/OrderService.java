package com.jetherrodrigues.sds2.domain.order;

import com.jetherrodrigues.sds2.domain.product.Product;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order save(final Order order);

    List<Order> findAll();

    Optional<Order> findOne(final Long id);

    Order getOne(final Long id);

    void delete(final Long id);

}
