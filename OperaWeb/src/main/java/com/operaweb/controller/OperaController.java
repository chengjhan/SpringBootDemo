package com.operaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.operaweb.model.entity.Opera;
import com.operaweb.model.service.OperaService;

@Controller
@RequestMapping(value = "/opera")
public class OperaController {

	@Autowired
	private OperaService operaService;

	@GetMapping()
	public String index(@RequestParam(value = "q", required = false, defaultValue = "") String q,
			@RequestParam(value = "s", required = false, defaultValue = "") String s,
			@RequestParam(value = "p", required = false, defaultValue = "1") String p, Model model) {

		int pageNumber = Integer.parseInt(p);
		int pageSize = 10;

		model.addAttribute("sTitle", !"title_asc".equals(s) ? "title_asc" : "title_desc");
		model.addAttribute("sYear", !"year_asc".equals(s) ? "year_asc" : "year_desc");
		model.addAttribute("operaPagination", operaService.search(q, s, pageNumber, pageSize));

		return "opera/index";
	}

	@GetMapping(value = "/detail/{id}")
	public String detail(@PathVariable(value = "id") Integer id, Model model) {

		model.addAttribute("opera", operaService.findById(id));

		return "opera/detail";
	}

	@GetMapping(value = "/create")
	public String create(Model model) {

		model.addAttribute("opera", new Opera());

		return "opera/create";
	}

	@PostMapping(value = "/create.do")
	public String createAction(@ModelAttribute(value = "opera") Opera opera) {

		operaService.create(opera);

		return "redirect:/opera";
	}

	@GetMapping(value = "/edit/{id}")
	public String edit(@PathVariable(value = "id") Integer id, Model model) {

		model.addAttribute("opera", operaService.findById(id));

		return "opera/edit";
	}

	@PostMapping(value = "/edit.do")
	public String editAction(@ModelAttribute(value = "opera") Opera opera) {

		operaService.create(opera);

		return "redirect:/opera";
	}

	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Integer id, Model model) {

		model.addAttribute("opera", operaService.findById(id));

		return "opera/delete";
	}

	@PostMapping(value = "/delete.do")
	public String deleteAction(@ModelAttribute(value = "opera") Opera opera) {

		operaService.delete(opera.getOperaId());

		return "redirect:/opera";
	}

	@GetMapping(value = "/delete2/{id}")
	public String delete2(@PathVariable(value = "id") Integer id) {

		operaService.delete(id);

		return "redirect:/opera";
	}

}
