package net.codejava.contact.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.contact.dao.ContactDAO;
import net.codejava.contact.model.Contact;

@Controller
public class MainController {
	
	@Autowired 
	private ContactDAO contactDAO;
	
	@RequestMapping(value = "/")
	public ModelAndView contactList(ModelAndView mv) {
		List<Contact> contactList = contactDAO.list();
		mv.setViewName("index");
		mv.addObject("listContact",contactList);
		return mv;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView mv) {
		Contact newContact = new Contact();
		mv.addObject("contact", newContact);
		mv.setViewName("contact_form");
		return mv;
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Contact contact) {
		if(contact.getId() == null) {
			contactDAO.save(contact);
		}else {
			contactDAO.update(contact);
		}
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/edit", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Contact contact = contactDAO.get(id);
		ModelAndView mv = new ModelAndView("contact_form");
		mv.addObject("contact", contact);
		return mv;
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public ModelAndView deleteContact(@RequestParam Integer id) {
		contactDAO.delete(id);
		return new ModelAndView("redirect:/");
	}
}
