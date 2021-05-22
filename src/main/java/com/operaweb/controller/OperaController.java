package com.operaweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.operaweb.model.entity.Opera;
import com.operaweb.model.service.OperaService;

@Controller
@RequestMapping(value = "/opera")
public class OperaController {

	@Autowired
	private OperaService operaService;

	@GetMapping()
	public String list(Model model) {

		List<Opera> operaList = operaService.list();
		model.addAttribute("operaList", operaList);

		return "opera/index";
	}

}
