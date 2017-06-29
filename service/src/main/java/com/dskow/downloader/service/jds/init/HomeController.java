package com.dskow.downloader.service.jds.init;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home redirection to swagger api documentation
 */
@Controller
public class HomeController {
	// Define a static LOGGER variable so that it references the
	// Logger instance named "HomeController".
	private static final Logger LOGGER = LogManager.getLogger(HomeController.class);

	@RequestMapping(value = "/")
	public String index() {
		LOGGER.debug("swagger-ui.html");
		return "redirect:swagger-ui.html";
	}
}
