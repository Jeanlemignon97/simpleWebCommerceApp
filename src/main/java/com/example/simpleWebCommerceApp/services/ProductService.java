package com.example.simpleWebCommerceApp.services;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.simpleWebCommerceApp.models.Product;
import com.example.simpleWebCommerceApp.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageData(imageFile.getBytes());
        product.setImageType(imageFile.getContentType());
        product.setImageUrl(imageFile.getOriginalFilename());
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(new Product());
    }

    public Product updateProduct(Long id, Product product, MultipartFile imageFile) throws IOException {
        
        product.setImageData(imageFile.getBytes());
        product.setImageType(imageFile.getContentType());
        product.setImageUrl(imageFile.getOriginalFilename());

        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
