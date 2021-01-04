package com.jetherrodrigues.sds2.domain.product;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable, Comparable<Product> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private String imageUri;

    @Deprecated
    public Product() {}

    public Product name(final String name) {
        this.name = name;
        return this;
    }

    public Product price(final BigDecimal price) {
        this.price = price;
        return this;
    }

    public Product description(final String description) {
        this.description = description;
        return this;
    }

    public Product imageUri(final String imageUri) {
        this.imageUri = imageUri;
        return this;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUri() {
        return imageUri;
    }

    @Override
    public int compareTo(final Product product) {
        return this.price.compareTo(product.getPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id.equals(product.id) &&
                imageUri.equals(product.imageUri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imageUri);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", imageUri='" + imageUri + '\'' +
                '}';
    }

}
