package com.Advertisements.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.Advertisements.model.Advert;
import com.Advertisements.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdvertController {
	private AdvertService advertService;

	@Autowired
	public void setAdvertService(AdvertService advertService) {
		this.advertService = advertService;
	}

	@RequestMapping(value="adverts",method = RequestMethod.GET)
	public String listAdverts(Model model){
		model.addAttribute("adverts", new Advert());
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

	@RequestMapping("edit/{id}")
	public String editAdvert(@PathVariable("id") int id, Model model){
		model.addAttribute("advert",this.advertService.getAdvertById(id));
		model.addAttribute("listAdverts",this.advertService.getAllAdverts());
		return "adverts";
	}

	@RequestMapping("advertData/{id}")
	public String advertData(@PathVariable("id") int id, Model model){
		model.addAttribute("advert",this.advertService.getAdvertById(id));
		return "advertData";
	}
}

