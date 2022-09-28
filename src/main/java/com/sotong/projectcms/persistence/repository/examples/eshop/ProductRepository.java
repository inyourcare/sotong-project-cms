package com.sotong.projectcms.persistence.repository.examples.eshop;

import com.sotong.projectcms.persistence.entity.examples.eshop.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Samuel Butta
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

//    public Optional<Product> getById(Long productId);
    public Product getById(Long productId);

}
