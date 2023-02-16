package com.referral.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.referral.entity.Referral;
import com.referral.service.ReferralService;

@Controller
public class ReferralController {

	@Autowired
	private ReferralService service;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<Referral> listReferral = service.listAll();
		model.addAttribute("listReferrals", listReferral);

		return "index";
	}

	@RequestMapping("/new")
	public String showNewReferral(Model model) {
		Referral referral = new Referral();
		model.addAttribute("referral", referral);

		return "add-user";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveReferral(@ModelAttribute("referral") Referral referral) {
		service.save(referral);

		return "redirect:/";
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditReferral(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("update-user");
	    Referral referral = service.get(id);
	    mav.addObject("referral", referral);
	     
	    return mav;
	}
	@RequestMapping("/delete/{id}")
	public String deleteReferral(@PathVariable(name = "id") int id) {
	    service.delete(id);
	    return "redirect:/";       
	}
}
