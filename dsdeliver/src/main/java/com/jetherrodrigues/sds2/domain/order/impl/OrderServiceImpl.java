package com.jetherrodrigues.sds2.domain.order.impl;

import com.jetherrodrigues.sds2.domain.order.Order;
import com.jetherrodrigues.sds2.domain.order.OrderService;
import com.jetherrodrigues.sds2.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order save(final Order order) {
        return orderRepository.save(order);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Order> findOne(final Long id) {
        return orderRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Order getOne(final Long id) {
        return orderRepository.getOne(id);
    }

    @Override
    public void delete(final Long id) {
        orderRepository.deleteById(id);
    }

}
