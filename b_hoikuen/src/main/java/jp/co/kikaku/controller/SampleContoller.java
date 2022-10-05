package jp.co.kikaku.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleContoller {
	@RequestMapping(path = "/")
	public String index() {
		return "index";
	}
	
	

}
