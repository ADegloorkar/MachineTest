package com.task.productTask.Controller;

import com.task.productTask.Entity.Catagory;
import com.task.productTask.Entity.ProductEntity;
import com.task.productTask.Service.ServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ControllerClass {

    @Autowired
    ServiceClass serviceClass;

    // GET all categories with pagination
    @GetMapping("/Allcategories")
    public Page<Catagory> getAllCategories(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "5") int size) {
        return serviceClass.getAllCategories(PageRequest.of(page, size));
    }

    // POST - create a new category
    @PostMapping("/Addcategories")
    public String createNewCategories(@RequestBody Catagory category) {
        return serviceClass.saveinfo(category);
    }

    // GET category by ID
    @GetMapping("/showCategories/{id}")
    public Catagory getCategoryById(@PathVariable("id") Long id) {
        return serviceClass.findbyid(id);
    }

    // PUT - update category by ID
    @PutMapping("/UpdateCategories/{id}")
    public String updateCategoryById(@PathVariable("id") Long id,
                                     @RequestBody Catagory category) {
        return serviceClass.update(id, category);
    }

    // DELETE - delete category by ID
    @DeleteMapping("/RemoveCategories/{id}")
    public String deleteCategoryById(@PathVariable("id") Long id) {
        return serviceClass.deletebyid(id);
    }
   // GET all products with pagination
    @GetMapping("/products")
    public Page<ProductEntity> getAllProducts(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "3") int size) {
        return serviceClass.getAllProducts(PageRequest.of(page, size));
    }

    // POST - create a new product under a category
    @PostMapping("/products/{categoryId}")
    public String addProductToCategory(@PathVariable Long categoryId, @RequestBody ProductEntity product) {
        return serviceClass.saveProduct(categoryId, product);
    }

    // GET product by ID
    @GetMapping("/showProducts/{id}")
    public ProductEntity findProductById(@PathVariable("id") Long id) {
        return serviceClass.findProductByid(id);
    }

    // PUT - update product by ID
    @PutMapping("/UpdateProducts/{id}")
    public String updateProductById(@PathVariable("id") Long id,
                                    @RequestBody ProductEntity product) {
        return serviceClass.updateProductByid(id, product);
    }

    // DELETE - delete product by ID
    @DeleteMapping("/RemoveProducts/{id}")
    public String deleteProductById(@PathVariable("id") Long id) {
        return serviceClass.deleteProductByid(id);
    }
}
