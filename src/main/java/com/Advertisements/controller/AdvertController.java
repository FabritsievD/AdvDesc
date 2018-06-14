package com.Advertisements.controller;

import com.Advertisements.model.Advert;
import com.Advertisements.model.Section;
import com.Advertisements.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Map;

@Controller
public class AdvertController {
	private AdvertService advertService;

	@Autowired
	public void setAdvertService(AdvertService advertService) {
		this.advertService = advertService;
	}

	@RequestMapping(value = "/")
		public String getHomePage(){
		return "home";
	}

	@RequestMapping(value="/adverts",method = RequestMethod.GET)
	public String listAdverts(Model model){
		model.addAttribute("advert", new Advert());
		model.addAttribute("listAdverts",this.advertService.getAllAdverts());
		return "adverts";
	}


	@RequestMapping(value = "/adverts/add", method = RequestMethod.POST)
	public String addAdvert(@ModelAttribute("advert") Advert advert){
		if(advert.getId()==0){
			this.advertService.addAdvert(advert);
		}
		else {
			this.advertService.updateAdvert(advert);
			}

		return "redirect:/adverts";
	}

	@RequestMapping("/remove/{id}")
	public String removeAdvert(@PathVariable("id") int id){
		this.advertService.removeAdvert(id);
		return "redirect:/adverts";
	}

	@RequestMapping("/edit/{id}")
	public String editAdvert(@PathVariable("id") int id, Model model){
		model.addAttribute("advert",this.advertService.getAdvertById(id));
		model.addAttribute("listAdverts",this.advertService.getAllAdverts());
		return "adverts";
	}

	@RequestMapping("/advertData/{id}")
	public String advertData(@PathVariable("id") int id, Model model){
		model.addAttribute("advert",this.advertService.getAdvertById(id));
		return "advertData";
	}

	@RequestMapping(value="/select",method = RequestMethod.GET)
	public String select(@RequestParam Map<String, String> params, Model model){
		//model.addAttribute("advert", new Advert());
		model.addAttribute("listAdverts",this.advertService.getAdvertsByParams(params));
		return "select";
	}
}

