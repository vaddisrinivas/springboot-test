package com.learning.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;

@Entity
@Getter
@Setter
@Table(name = "Product")
public class Product {

    @jakarta.persistence.Id
    @GeneratedValue
    @ReadOnlyProperty
    private long id;
    private String name;
    private String description;
    private Double price;

}