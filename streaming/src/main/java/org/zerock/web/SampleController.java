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
	public String getData(@RequestBody String data,Model model) {

		logger.info("post called....");
		//ResponseEntity<String> entity = null;
		/*try {
			entity = new ResponseEntity<String>(data,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}*/
		model.addAttribute("serverTime", data );
		return "home";
	}
	@RequestMapping(value="test", method = RequestMethod.GET)
	public String getData(Model model) {

		logger.info("post called....");
		//ResponseEntity<String> entity = null;
		/*try {
			entity = new ResponseEntity<String>(data,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}*/
		return "home";
	}
	@RequestMapping("/")
	public String dab() {
		logger.info("dob called....");
		return "StreamView";
	}
}
