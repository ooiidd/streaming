package org.zerock.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController {
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	@RequestMapping(value="data", method = RequestMethod.POST)
	public ResponseEntity<String> getData(@RequestBody String data,Model model) {
		
		ResponseEntity<String> entity = null;
		try {
			entity = new ResponseEntity<String>(data,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping("dob")
	public void dab() {
		logger.info("dob called....");
	}
}
