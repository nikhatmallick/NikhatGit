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

@Controller
@RequestMapping("/catalog")
public class CatalogController {
	private CatalogService catalogService;

	@Autowired
	public void setCatalogService(CatalogService catalogService) {
		this.catalogService = catalogService;
	}
	
	@RequestMapping("/list")
	public ModelAndView catalogList(Model model) {
		System.out.println("============in CatalogList");
		List<Catalog> catalogs = catalogService.getCatalogs();
		model.addAttribute("catalogList", catalogs);
		return new ModelAndView("catalog/catalogList");		
	}
	

	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addCatalog(Model model) {
		System.out.println("==== in add catalog");
		model.addAttribute(new Catalog());
		return "catalog/addCatalog";
	}
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addCatalogSave(@Valid Catalog catalog, BindingResult bindingResult) {
		System.out.println("=== in addCatalogSave");
		if(bindingResult.hasErrors()) {
			return "catalog/addCatalog";
		}
		catalogService.insertCatalog(catalog);
		return "redirect:/catalog/list.html";
	}
}
