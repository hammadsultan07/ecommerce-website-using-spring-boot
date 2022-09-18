package com.hammad.major.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hammad.major.model.Category;
import com.hammad.major.service.CategoryService;
import com.hammad.major.service.ProductService;

@Controller
public class Admin_controller 
	{
		@Autowired
		CategoryService categoryService;
		@Autowired
		ProductService productService;

	
		//Admin
		@GetMapping("/admin")
		public String adminHome()
			{
				return "adminHome";
			}

		//Categories
		@GetMapping("/admin/categories")
		public String categories(Model model)
			{
				model.addAttribute("categories",categoryService.getAllCategory());
				return "categories";
			}

		@GetMapping("/admin/categories/add")
		public String getcategoriesadd(Model model)
			{
				model.addAttribute("category",new Category());
				return "categoriesAdd";
			}
		@PostMapping("/admin/categories/add")
		public String postcategoriesadd(@ModelAttribute("category") Category category)
			{
				categoryService.addCategory(category);
				return "redirect:/admin/categories";
}
@GetMapping("/admin/categories/delete/{id}")
public String deletecat(@PathVariable int id)
{
	categoryService.deleteCat(id);
	return "redirect:/admin/categories";
}
@GetMapping("/admin/categories/update/{id}")
public String deletecat(@PathVariable int id,Model model)
{
	Optional<Category> category=categoryService.updateCat(id);
	if(category.isPresent())
	{
		model.addAttribute("category",category.get());
		return "categoriesAdd";
	}
	else
		return "404";
	
}

//product section
	@GetMapping("/admin/products")
	public String products(Model model)
		{
		model.addAttribute("products",productService.getAllProduct());
		return "products";
		}

	/*@GetMapping("/admin/products/add")
	public String productsadd(Model model)
		{
			model.addAttribute("productDTO", new ProductDTO());
			model.addAttribute("categories", categoryService.getAllCategory());
			return "productsAdd";
		}
	@PostMapping("/admin/products/add")
	public String postproductsadd(@ModelAttribute("productDTO") ProductDTO productDTO,@RequestParam("productImage"))
		{
			productService.addProd(productDTO);
			return "redirect:/admin/products";
}*/
}
