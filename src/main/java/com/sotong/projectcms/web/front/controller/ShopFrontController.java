package com.sotong.projectcms.web.front.controller;

import com.sotong.projectcms.config.anotation.FrontController;
import com.sotong.projectcms.web.front.controller.parent.FrontAbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Samuel Butta
 */

@FrontController
public class ShopFrontController extends FrontAbstractController {

//    private final ProductService productService;

//    @Autowired
//    public ShopFrontController(ProductService productService) {
//        this.productService = productService;
//    }

//    @RequestMapping(value = "/products")
//    public String order(Model model) {
//        List<Product> products = productService.findAllProducts();
//        model.addAttribute("products", products);
//
//        return "front/products";
//    }

}
