package com.jetherrodrigues.sds2.domain.product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product save(final Product product);

    List<Product> findAll();

    Optional<Product> findOne(final Long id);

    Product getOne(final Long id);

    void delete(final Long id);

}
