package com.niki.spring.springjdbcprojectuci.frontend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niki.spring.springjdbcprojectuci.catalogs.model.Catalog;
import com.niki.spring.springjdbcprojectuci.catalogs.service.CatalogService;
import com.niki.spring.springjdbcprojectuci.products.model.Items;
import com.niki.spring.springjdbcprojectuci.products.model.Orders;
import com.niki.spring.springjdbcprojectuci.products.model.Product;
import com.niki.spring.springjdbcprojectuci.products.model.Product_Order;

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
		//return new ModelAndView("product/productList");
		model.addAttribute("selectedProducts", new Items());
		return new ModelAndView("product/productList3");
	}
	
	//product purchase
	@RequestMapping("/listProducts2Purchase")
	public ModelAndView productList4(Model model) {
		System.out.println("======= in productList");
		List<Product> products = catalogService.getProducts();
		model.addAttribute("productList", products);
		//return new ModelAndView("product/productList");
		model.addAttribute("selectedProducts", new Items());
		return new ModelAndView("product/productList4");
	}
	@RequestMapping("/addOrder")
	public ModelAndView Product_OrderPage(@RequestParam("product_id") int product_id, Model model,
			@Valid Orders orders, BindingResult bindingResult) {
		System.out.println("======= in ProductOrderForm");
		//Product product = catalogService.getProduct(product_id);
	//	catalogService.insertOrder(orders);
	//	catalogService.insertProduct_Order(new Product_Order(0,orders.getOrder_id(),product_id,orders.getOrder_amount()));
		//catalogService.updateProduct(product_id, product);
	//	model.addAttribute("product", product);
		return new ModelAndView("product/addOrder");
	}
	@RequestMapping(value="/addOrder", method=RequestMethod.POST)
	public ModelAndView addProductOrderSave(@Valid Orders orders, BindingResult bindingResult) {
		System.out.println("=== in addProductSave");
		ModelAndView modelandview = new ModelAndView();
		if(bindingResult.hasErrors()) {
			modelandview.setViewName("product/addOrder");
			//return "product/addOrder";
			return modelandview;
		}
		catalogService.insertOrder(orders);
		modelandview.addObject("orders",orders);
		modelandview.setViewName("order/orderResult");
	//	return "redirect:/order/list";
		return modelandview;
		//return "/order/orderResult";
	}
	//works
	// After submitting Delete from Department List Form
	/*@RequestMapping(value="/list", method=RequestMethod.POST)
	public String deleteDepartments(@ModelAttribute Items selectedDepartments) {
		System.out.println("======= in deleteDepartments");
		for (String deptIdStr : selectedDepartments.getItemList()) {
			System.out.println("delete department id=" + deptIdStr);
			try { 
				int deptId = Integer.parseInt(deptIdStr);
			    courseService.deleteDepartment(deptId);
			}
			catch (Exception e) {}
		}
		return "redirect:/department/list.html";
	}*/
	// Add order
		@RequestMapping(value="/addOrderPage")
		public ModelAndView showaddOrderPage( ) {
			System.out.println("==== in add order form");
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("addOrder");
		//	model.addAttribute(new Orders());
		//	model.addAttribute("productList",catalogService.getProducts());
			return modelAndView;
		}
		@RequestMapping(value="/addOrderPage", method=RequestMethod.POST)
		public String addOrderSave(@Valid Orders orders, BindingResult bindingResult) {
			System.out.println("=== in addOrderSave");
			if(bindingResult.hasErrors()) {
				return "order/addOrder";
			}
			catalogService.insertOrder(orders);
			//int product_order_id, int order_id, int product_id, Double order_amount
		//catalogService.insertProduct_Order(0,order.getOrder_id());
			return "redirect:/order/orderResult";
		}
	
	// Add Product
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
	// VIEW Product DETAILS

		@RequestMapping("/view")
		public ModelAndView productView(@RequestParam("product_id") int product_id, Model model) {
			System.out.println("======= in productView");
			Product product = catalogService.getProduct(product_id);
			model.addAttribute("product", product);
			return new ModelAndView("product/viewProduct");
		}
	
	// DELETE Product

		// After submitting Delete from Product List Form
		@RequestMapping(value="/list", method=RequestMethod.POST)
		public String deleteProducts(@ModelAttribute Items selectedProducts) {
			System.out.println("======= in deleteProducts");
			for (String prodIdStr : selectedProducts.getItemList()) {
				System.out.println("delete product id=" + prodIdStr);
				try { 
					int prodId = Integer.parseInt(prodIdStr);
				    catalogService.deleteProductbyId(prodId);
				}
				catch (Exception e) {}
			}
			return "redirect:/product/list.html";
		}
		// UPDATE PRODUCT

		@RequestMapping(value="/edit/{product_id}", method=RequestMethod.GET)
		public String editProduct(@PathVariable int product_id, Model model) {
			System.out.println("======= in editProduct");
			Product product = catalogService.getProduct(product_id);
			model.addAttribute("product", product);
			model.addAttribute("catalogList",catalogService.getCatalogs());
			return "product/editProduct";
		}
		
		@RequestMapping(value="/edit/{product_id}", method=RequestMethod.POST)
		public String editProductSave(@PathVariable int product_id, 
				@Valid Product product, BindingResult bindingResult) {
			System.out.println("======= in editProductSave");
			if(bindingResult.hasErrors()) {
				return "product/editProduct";
			}
			catalogService.updateProduct(product_id, product);
			return "redirect:/product/list.html";
		}
//purchase Product
		
		@RequestMapping(value="/purchaseProduct", method=RequestMethod.POST)
		public String purchaseProducts(@ModelAttribute Items selectedProducts) {
			System.out.println("======= in purchaseProduct");
			Product product=null;
			for (String prodIdStr : selectedProducts.getItemList()) {
				System.out.println("purchase product id=" + prodIdStr);
				try { 
					int prodId = Integer.parseInt(prodIdStr);
					 product = catalogService.getProduct(prodId);
					//model.addAttribute("product", product);
				  //  catalogService.insertOrder(0,);
					 //   catalogService.insertProduct_Order(new Product_Order(0,));
				   // catalogService.updateProduct(prodId, product);
				}
				catch (Exception e) {}
			}
			return "redirect:/product/list.html";
		}
}
