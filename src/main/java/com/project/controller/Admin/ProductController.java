package com.project.controller.Admin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.models.Category;
import com.project.models.product;
import com.project.service.CategoryService;
import com.project.service.ProductService;
import com.project.service.StorageService;

@Controller
@RequestMapping("/admin")
public class ProductController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    StorageService service;
    @Autowired
    ProductService productService;
    
    @GetMapping("/product")
    public String index(Model model) {
        List<product> listCategory = this.productService.getAll();
        model.addAttribute("listCategory", listCategory);
        return "admin/product/index";
    }
    
    @GetMapping("/product-add")
    public String add(Model model) {
        product product = new product();
        model.addAttribute("product", product);
        
        List<Category> listcate = this.categoryService.getAll();
        model.addAttribute("listcate", listcate);
        
        return "admin/product/add";
    }
    
    @PostMapping("/product-add")
    public String save(@ModelAttribute("product") product product, @RequestParam("fileimage") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                String filename = file.getOriginalFilename();
                Path path = Paths.get("uploads/" + filename);
                
                // Tạo thư mục nếu chưa tồn tại
                Files.createDirectories(path.getParent());
                
                // Ghi tệp vào hệ thống tập tin
                Files.write(path, file.getBytes());
                
                // Cập nhật tên tệp vào đối tượng sản phẩm
                product.setImage(filename);
            } catch (IOException e) {
                e.printStackTrace();
                return "admin/product/add";
            }
        }
        
        if (this.productService.create(product)) {
            return "redirect:/admin/product";
        } else {
            return "admin/product/add";
        }
    }

    @GetMapping("/edit-product/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        product product = this.productService.finByID(id);
        model.addAttribute("product", product);
        List<Category> listcate = this.categoryService.getAll();
        model.addAttribute("listcate", listcate);
        return "admin/product/edit";
    }

    @PostMapping("/edit-product")
    public String update( @ModelAttribute("product") product product, @RequestParam("fileimage") MultipartFile file) {
    	  if (!file.isEmpty()) {
              try {
                  String filename = file.getOriginalFilename();
                  Path path = Paths.get("uploads/" + filename);
                  
                  // Tạo thư mục nếu chưa tồn tại
                  Files.createDirectories(path.getParent());
                  
                  // Ghi tệp vào hệ thống tập tin
                  Files.write(path, file.getBytes());
                  
                  // Cập nhật tên tệp vào đối tượng sản phẩm
                  product.setImage(filename);
              } catch (IOException e) {
                  e.printStackTrace();
                  return "admin/product/edit";
              }
          }
          
         
        if (this.productService.update(product)) {
            return "redirect:/admin/product";
        } else {
            return "admin/product/edit";
        }
    }

    @GetMapping("/delete-product/{id}")
    public String delete(@PathVariable("id") Integer id) {
    	
        if (this.productService.delete(id)) {
            return "redirect:/admin/product";
        } else {
            return "redirect:/admin/product";
        }
    }

    @PostMapping("/delete-products")
	public String deleteproduct(@RequestParam("ids") List<Integer> ids) {
	    if (ids != null && !ids.isEmpty()) {
	        for (Integer id : ids) {
	            this.productService.delete(id);
	        }
	    }
	    return "redirect:/admin/category";
	}

}
