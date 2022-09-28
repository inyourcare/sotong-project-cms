package com.sotong.projectcms.persistence.entity.examples.eshop;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Samuel Butta
 */
@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Double price;

    @Column
    private String title;

}
