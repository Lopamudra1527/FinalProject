package dphone.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dphone.customer.entity.Customer;
import dphone.customer.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService service;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<Customer> listCust = service.listAll();
		model.addAttribute("listCustomers", listCust);
		return "index";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditCustomer(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("update-user");
		Customer cust = service.get(id);
		mav.addObject("cust", cust);

		return mav;
	}

	@RequestMapping("/delete/{id}")
	public String deleteReferral(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";
	}
}
