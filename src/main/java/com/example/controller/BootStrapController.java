package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

/*
 * MVC(Model-View-Control)하에서 프로그래밍한다는 것은 컨트롤러를 사용한다는 것
 * --> 소프트웨어 디자인 패턴
 * 컨트롤러 웹브라우저의 요청을 처리하는 것
 */
@Controller
@RequestMapping("/bootstrap")			//bootstrap으로 시작하는 요청은 모두 이 컨트롤러를 사용한다.
@Log
public class BootStrapController {

	@GetMapping("/merge")							// bootstrap/merge & get요청으로 들어오면 실행
	public String htmlMerge(){
		
		log.info("/bootstrap/merge htmlMerge().......");
		
		return "jsp/bootstrap/merge";
	}

	@GetMapping("/gridsample")
	public String gridSample(){
		
		log.info("/bootstrap/gridsample gridSample().......");
		
		return "jsp/bootstrap/gridsample";
	}	
	
	@GetMapping("/gridsample2")
	public String gridSample2(){
		
		log.info("/bootstrap/gridsample2 gridSample2().......");
		
		return "thymeleaf/bootstrap/gridsample";
	}
}
