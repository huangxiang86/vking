package com.vking.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vking.test.dao.PartRepository;
import com.vking.test.data.Part;

@Controller
@RequestMapping("/part")
public class PartController {

	@Autowired
	private PartRepository partRepository;

	@RequestMapping(value = { "/create", "" }, method = RequestMethod.GET)
	public String createPart(
			@RequestParam(value="value",defaultValue="Hello World") String value,
			@RequestParam(value="number",defaultValue="123123") String number) {
		return "test/part/create";
	}

	@RequestMapping(value = { "/create", "" }, method = RequestMethod.POST)
	public String processCreatePart(RedirectAttributes model, Part part) {
		partRepository.save(part);
		model.addFlashAttribute("part", part);
		return "redirect:/part/result";
	}

	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String displayPart() {
		return "test/part/displayPart";
	}

	@RequestMapping(value = "/myservlet", method = RequestMethod.GET)
	public String displayMyservelt(RedirectAttributes model) {
		return "redirect:/custom";
	}

}
