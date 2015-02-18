package com.fornsys.mapper.controllers;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/")
public class IndexController {
	private static final Logger _log = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping(value={"/", "/index"}, method=RequestMethod.GET)
	public String doGet() {
		_log.info("index");
		return "index";
	}
	
	@PostConstruct
	public void afterClass() {
		_log.info("Hello.");
	}
}
