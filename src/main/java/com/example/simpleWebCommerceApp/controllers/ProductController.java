package com.example.simpleWebCommerceApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.simpleWebCommerceApp.models.Product;
import com.example.simpleWebCommerceApp.services.ProductService;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * @return
     */
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    /**
     * @param id
     * @return
     */
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);

        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    /**
     * @param product
     * @return
     */
    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile) {
        try {
            Product newProduct = productService.addProduct(product, imageFile);
            return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @param id
     * @param product
     * @return
     */
    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestPart Product product,
            MultipartFile imageFile) throws IOException {
        Product updatedProduct = null;

        try {
            updatedProduct = productService.updateProduct(id, product, imageFile);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
        }

        if (updatedProduct == null) {
            return new ResponseEntity<>("Failed to updated", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Updated", HttpStatus.OK);
    }

    /**
     * @param id
     * @return
     */
    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        Product deletedProduct = productService.getProductById(id);
        if (deletedProduct == null) {
            return new ResponseEntity<>("Failed to delete", HttpStatus.BAD_REQUEST);
        }
        productService.deleteProduct(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable Long productId) {
        Product product = productService.getProductById(productId);
        byte[] imageFile = product.getImageData();
        if (imageFile == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok() //
                .contentType(MediaType.valueOf(product.getImageType())) //
                .body(imageFile);
    }
}
