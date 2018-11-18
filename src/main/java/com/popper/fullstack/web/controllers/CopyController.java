package com.popper.fullstack.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**Copy as Copyrights**/

@Controller
public class CopyController {

	@RequestMapping("/about")
	public String about() {
		return "copy/about";
	}
}
