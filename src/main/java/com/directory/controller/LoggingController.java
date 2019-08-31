package com.directory.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author R_Legend
 *This calss is responsible to configuring logger 
 */
@RestController
public class LoggingController {

	Logger logger = LoggerFactory.getLogger(LoggingController.class);

	/**
	 * @return
	 */
	@RequestMapping("/")
	public String index() {
		logger.trace("A TRACE Message");
		logger.debug("A DEBUG Message");
		logger.info("An INFO Message");
		logger.warn("A WARN Message");
		logger.error("An ERROR Message");

		return "Check the Logs to see the out come";
	}

}
