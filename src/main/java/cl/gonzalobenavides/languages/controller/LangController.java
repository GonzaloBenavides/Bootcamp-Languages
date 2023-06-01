package cl.gonzalobenavides.languages.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.gonzalobenavides.languages.controller.service.LangService;
import cl.gonzalobenavides.languages.model.Language;
import jakarta.validation.Valid;

@Controller
public class LangController {

	@Autowired
	LangService service;

	@RequestMapping("/")
	public String goHome() {
		return "redirect:/languages";
	}

	@RequestMapping(path = "/languages", method = RequestMethod.GET)
	public String getLanguages(Model mod, RedirectAttributes red) {
		mod.addAttribute("languages", service.findAllLanguages());
		if (!mod.containsAttribute("newLang"))
			mod.addAttribute("newLang", new Language());
		return "index.jsp";
	}

	@RequestMapping(path = "/languages/{id}/edit", method = RequestMethod.GET)
	public String editLanguages(@Valid @ModelAttribute Language newLang, BindingResult res, Model mod,
			@PathVariable("id") Long id, RedirectAttributes red) {
		mod.addAttribute("languages", service.findAllLanguages());
		if (!mod.containsAttribute("newLang")) {
			try {
				mod.addAttribute("newLang", service.findById(id));
			} catch (NoSuchElementException se) {
				red.addFlashAttribute("error", "No existe el lenguaje con id: " + id);
				return "redirect:/languages";
			}
		}
		return "../../edit.jsp";
	}

	@RequestMapping(path = "/languages/{id}", method = RequestMethod.GET)
	public String checkLanguages(Model mod, @PathVariable("id") Long id, @ModelAttribute Language newLang,
			BindingResult res, RedirectAttributes red) {
		if (!mod.containsAttribute("newLang")) {
			try {
				mod.addAttribute("newLang", service.findById(id));
			} catch (NoSuchElementException se) {
				red.addFlashAttribute("error", "No existe el lenguaje con id: " + id);
				return "redirect:/languages";
			}
		}
		return "../lang.jsp";
	}

	@PostMapping(path = "/languages")
	public String newLanguage(@Valid @ModelAttribute Language newLang, BindingResult res, Model mod,
			RedirectAttributes red) {
		if (res.hasErrors()) {
			red.addFlashAttribute("org.springframework.validation.BindingResult.newLang", res);
			red.addFlashAttribute("newLang", newLang);

			return "redirect:/languages";
		}
		service.saveLanguage(newLang);

		mod.addAttribute("languages", service.findAllLanguages());
		return "redirect:/languages";
	}

	@PutMapping(path = "/languages/{id}")
	public String changeLanguage(@Valid @ModelAttribute Language newLang, BindingResult res,
			@PathVariable("id") Long id, Model mod, RedirectAttributes red) {
		if (res.hasErrors()) {
			red.addFlashAttribute("org.springframework.validation.BindingResult.newLang", res);
			red.addFlashAttribute("newLang", newLang);
			return "redirect:/languages/" + id + "/edit";
		}

		try {
			service.saveLanguage(newLang);
		} catch (NoSuchElementException se) {
			red.addFlashAttribute("error", "No existe el lenguaje con id: " + id);
			return "redirect:/languages";
		}

		return "redirect:/languages";
	}

	@RequestMapping(path = "/languages/{id}", method = RequestMethod.DELETE)
	public String deleteLanguage(@PathVariable("id") Long id, RedirectAttributes red) {

		try {
			service.deleteLanguage(service.findById(id));
		} catch (NoSuchElementException se) {
			red.addFlashAttribute("error", "No existe el lenguaje con id: " + id);
			return "redirect:/languages";
		}

		return "redirect:/languages";
	}

}
