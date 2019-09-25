package com.codegym.controller;

import com.codegym.entity.Contact;
import com.codegym.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ContactController {

  @Autowired
  private ContactService contactService;

  @GetMapping("/")
  public String list(Model model) {
    model.addAttribute("contacts", contactService.findAll());
    return "list";
  }

  @GetMapping("/search")
  public String search(@RequestParam("term") String term, Model model) {
    if (StringUtils.isEmpty(term)) {
      return "redirect:/";
    }
    model.addAttribute("contacts", contactService.search(term));
    return "list";
  }

  @GetMapping("/add")
  public String add(Model model) {
    model.addAttribute("contact", new Contact());
    return "form";
  }

  @PostMapping("/save")
  public String save(@Valid Contact contact, BindingResult result, RedirectAttributes redirect) {
    if (result.hasErrors()) {
      return "form";
    }
    contactService.save(contact);
    redirect.addFlashAttribute("successMessage", "Saved contact successfully!");
    return "redirect:/";
  }

  @GetMapping("/{id}/edit")
  public String edit(@PathVariable("id") int id, Model model) {
    model.addAttribute("contact", contactService.findById(id));
    return "form";
  }

  @GetMapping("/{id}/delete")
  public String delete(@PathVariable int id, RedirectAttributes redirect) {
    contactService.delete(id);
    redirect.addFlashAttribute("successMessage", "Deleted contact successfully!");
    return "redirect:/";
  }
}
