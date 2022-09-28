package com.sotong.projectcms.business.service.eshop;

import com.sotong.projectcms.business.service.eshop.api.ProductService;
import com.sotong.projectcms.persistence.entity.eshop.Product;
import com.sotong.projectcms.persistence.repository.eshop.ProductRepository;
import com.sotong.projectcms.web.admin.form.ProductForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Samuel Butta
 */
@Service
public class ProductServiceImpl implements ProductService {


    private ProductRepository productRepository;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void saveProduct(ProductForm productForm) {
        Optional<Product> productOpt = Optional.ofNullable(productRepository.getById(productForm.getProductId()));
        Product product = productOpt.orElse(new Product());

        product.setTitle(productForm.getTitle());
        product.setPrice(productForm.getPrice());

        productRepository.save(product);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

}
