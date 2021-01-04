package com.jetherrodrigues.sds2.domain.product.impl;

import com.jetherrodrigues.sds2.domain.product.Product;
import com.jetherrodrigues.sds2.domain.product.ProductService;
import com.jetherrodrigues.sds2.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(final Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findOne(final Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product getOne(final Long id) {
        return productRepository.getOne(id);
    }

    @Override
    public void delete(final Long id) {
        productRepository.deleteById(id);
    }
}
