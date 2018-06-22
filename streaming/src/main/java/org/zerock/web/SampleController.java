package org.zerock.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	private int test=0;
	@RequestMapping("doa")
	public String doa() {
		logger.info("doa called.... test : "+test);
		test++;
		return "result";
	}
	
	@RequestMapping("dob")
	public void dab() {
		logger.info("dob called....");
	}
}
