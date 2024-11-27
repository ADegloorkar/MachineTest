package com.task.productTask.Service;

import com.task.productTask.Entity.Catagory;
import com.task.productTask.Entity.ProductEntity;
import com.task.productTask.Repositatory.CatagoryRepositatory;
import com.task.productTask.Repositatory.ProductRepositatory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceClass {

    @Autowired
    private CatagoryRepositatory catagoryRepositatory;

    @Autowired
    private ProductRepositatory productRepositatory;

    // Create a new Category
    public String saveinfo(Catagory catagory) {
        for (ProductEntity productEntity : catagory.getProductEntities()) {
            // Associate category with each product
            productEntity.setCatagory(catagory);
        }
        catagoryRepositatory.save(catagory);
        return "Record added successfully!";
    }

    // Get all categories with pagination
    public Page<Catagory> getAllCategories(Pageable pageable) {
        return catagoryRepositatory.findAll(pageable);
    }

    // Get a category by ID
    public Catagory findbyid(Long id) {
        return catagoryRepositatory.findById(id).orElse(null);
    }

    // Delete a category by ID
    public String deletebyid(Long id) {
        if (catagoryRepositatory.existsById(id)) {
            catagoryRepositatory.deleteById(id);
            return "Category deleted successfully!";
        } else {
            return "Category not found!";
        }
    }

    // Update a category by ID
    public String update(Long id, Catagory updatedCategory) {
        Catagory existingCategory = catagoryRepositatory.findById(id).orElse(null);
        if (existingCategory != null) {
            if (updatedCategory.getCname() != null) {
                existingCategory.setCname(updatedCategory.getCname());
            }
            catagoryRepositatory.save(existingCategory);
            return "Category updated successfully!";
        } else {
            return "Category not found!";
        }
    }

    // Get all products with pagination
    public Page<ProductEntity> getAllProducts(Pageable pageable) {
        return productRepositatory.findAll(pageable);
    }

    // Create a new product and link it to a category
    public String saveProduct(Long categoryId, ProductEntity productEntity) {
        Catagory catagory = catagoryRepositatory.findById(categoryId).orElse(null);
        if (catagory == null) {
            return "Category with ID " + categoryId + " not found!";
        }
        productEntity.setCatagory(catagory); // Link product to category
        productRepositatory.save(productEntity);
        return "Product added successfully!";
    }

    // Get a product by ID
    public ProductEntity findProductByid(Long id) {
        return productRepositatory.findById(id).orElse(null);
    }

    // Delete a product by ID
    public String deleteProductByid(Long id) {
        if (productRepositatory.existsById(id)) {
            productRepositatory.deleteById(id);
            return "Product deleted successfully!";
        } else {
            return "Product not found!";
        }
    }

    // Update a product by ID
    public String updateProductByid(Long id, ProductEntity updatedProduct) {
        ProductEntity existingProduct = productRepositatory.findById(id).orElse(null);
        if (existingProduct != null) {
            if (updatedProduct.getPname() != null) {
                existingProduct.setPname(updatedProduct.getPname());
            }
            if (updatedProduct.getPrice() != null) {
                existingProduct.setPrice(updatedProduct.getPrice());
            }
            productRepositatory.save(existingProduct);
            return "Product updated successfully!";
        } else {
            return "Product not found!";
        }
    }
}
