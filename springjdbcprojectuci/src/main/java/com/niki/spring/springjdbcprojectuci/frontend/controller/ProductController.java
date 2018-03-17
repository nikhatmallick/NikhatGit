package com.niki.spring.springjdbcprojectuci.frontend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niki.spring.springjdbcprojectuci.catalogs.model.Catalog;
import com.niki.spring.springjdbcprojectuci.catalogs.service.CatalogService;
import com.niki.spring.springjdbcprojectuci.products.model.Product;

@Controller
@RequestMapping("/product")
public class ProductController {
	private CatalogService catalogService;

	@Autowired
	public void setCatalogService(CatalogService catalogService) {
		this.catalogService = catalogService;
	}
	
	@RequestMapping("/list")
	public ModelAndView productList(Model model) {
		System.out.println("======= in productList");
		List<Product> products = catalogService.getProducts();
		model.addAttribute("productList", products);
		return new ModelAndView("product/productList");
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addProduct(Model model) {
		System.out.println("==== in add product");
		model.addAttribute(new Product());
		model.addAttribute("catalogList",catalogService.getCatalogs());
		return "product/addProduct";
	}
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addProductSave(@Valid Product product, BindingResult bindingResult) {
		System.out.println("=== in addProductSave");
		if(bindingResult.hasErrors()) {
			return "product/addProduct";
		}
		catalogService.insertProduct(product);
		return "redirect:/product/list";
	}
	
}
