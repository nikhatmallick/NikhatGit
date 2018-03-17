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
import com.niki.spring.springjdbcprojectuci.products.model.Orders;
import com.niki.spring.springjdbcprojectuci.products.model.Product;

@Controller
@RequestMapping("/order")
public class OrderController {
	private CatalogService catalogService;

	@Autowired
	public void setCatalogService(CatalogService catalogService) {
		this.catalogService = catalogService;
	}
	
	@RequestMapping("/list")
	public ModelAndView orderList(Model model) {
		System.out.println("======= in orderList");
		List<Orders> orders = catalogService.getOrders();
		model.addAttribute("orderList", orders);
		return new ModelAndView("order/orderList");
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addOrder(Model model) {
		System.out.println("==== in add order");
		model.addAttribute(new Orders());
		//model.addAttribute("catalogList",catalogService.getCatalogs());
		return "order/addOrder";
	}
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addOrderSave(@Valid Orders order, BindingResult bindingResult) {
		System.out.println("=== in addOrderSave");
		if(bindingResult.hasErrors()) {
			return "order/addOrder";
		}
		catalogService.insertOrder(order);
		return "redirect:/order/list";
	}
	
}