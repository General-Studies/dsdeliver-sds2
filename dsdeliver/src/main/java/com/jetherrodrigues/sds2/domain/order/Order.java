package com.jetherrodrigues.sds2.domain.order;

import com.jetherrodrigues.sds2.domain.order.type.OrderStatusType;
import com.jetherrodrigues.sds2.domain.product.Product;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.*;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private Double lat;
    private Double lon;
    private Instant moment = Instant.now();
    @Enumerated(EnumType.STRING)
    private OrderStatusType status = OrderStatusType.PENDING;

    @ManyToMany
    @JoinTable(
        name = "tb_order_product",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")
    )
    @OrderBy("name asc")
    private final SortedSet<Product> products = new TreeSet<>();

    @Deprecated
    public Order() {}

    public Set<Product> getProducts() {
        return Collections.unmodifiableSet(products);
    }

    public Order addProduct(final Product product) {
        this.products.add(product);
        return this;
    }

    public BigDecimal getTotal() {
        return products.stream().map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Order address(final String address) {
        this.address = address;
        return this;
    }

    public Order lat(final Double lat) {
        this.lat = lat;
        return this;
    }

    public Order lon(final Double lon) {
        this.lon = lon;
        return this;
    }

    public Order orderToDelivered() {
        this.status = OrderStatusType.DELIVERED;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return id.equals(order.id) &&
                status == order.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", moment=" + moment +
                ", status=" + status +
                ", products=" + products +
                '}';
    }

}
