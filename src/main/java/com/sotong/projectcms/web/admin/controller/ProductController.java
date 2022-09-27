package com.sotong.projectcms.web.admin.controller;


import com.sotong.projectcms.config.anotation.AdminController;
import com.sotong.projectcms.persistence.repository.eshop.ProductRepository;
import com.sotong.projectcms.web.admin.controller.parent.AdminAbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author Samuel Butta
 */

@AdminController
@RequestMapping("/admin/product")
public class ProductController extends AdminAbstractController {


//    private ProductService productService;

    private ProductRepository productRepository;

//    @Autowired
//    public ProductController(ProductService productService, ProductRepository productRepository) {
//        this.productService = productService;
//        this.productRepository = productRepository;
//    }


    @RequestMapping("/all")
    public String all(Model model) {
        model.addAttribute("products", productRepository.findAll());

        return "admin/product/all";
    }


//    @RequestMapping("/addProduct")
//    public String addProduct(@RequestParam(required = false) Long productId, ProductForm productForm, Model model) {
//        Optional<Product> productOpt = productRepository.getById(productId);
//
//        productOpt.ifPresent(p -> {
//            productForm.setPrice(p.getPrice());
//            productForm.setTitle(p.getTitle());
//        });
//
//        return "admin/addProduct";
//    }


//    @PostMapping("/addProduct")
//    public String productForm(@Valid ProductForm productForm, BindingResult bindingResult) {
//
//        if (!bindingResult.hasErrors()) {
//            productService.saveProduct(productForm);
//        }
//
//        return redirect("/admin/product/all");
//    }

}
