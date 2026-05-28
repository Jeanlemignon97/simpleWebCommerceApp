package com.example.simpleWebCommerceApp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
@Entity
@Data // Auto-generate get, set, tostring, equals, hashcode
@AllArgsConstructor // Auto-generate constructor with all arguments
@NoArgsConstructor // Auto-generate default constructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private String category;
    private Date releaseDate;
    private boolean isAvailable;
    private String brand;
    private String imageUrl;
    private String imageType;
    @Lob // Large Object to store image data
    private byte[] imageData;
}
