package com.sotong.projectcms.business.service.eshop.api;

import com.sotong.projectcms.persistence.entity.eshop.Product;
import com.sotong.projectcms.web.admin.form.ProductForm;

import java.util.List;

/**
 * @author Samuel Butta
 */
public interface ProductService {


    void saveProduct(ProductForm productForm);

    List<Product> findAllProducts();

}
