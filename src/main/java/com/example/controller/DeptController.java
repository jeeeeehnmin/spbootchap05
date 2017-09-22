package com.example.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.DeptVO;
import com.example.repository.DeptRepository;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/dept")
@Log
public class DeptController {
  
  @Inject
  DeptRepository deptRepository;
  
  @GetMapping("/list")
  @Transactional
  public String list(Model model) {
    log.info("/dept/list 호출됨");
    
    List<DeptVO> depts = deptRepository.findAll();
    depts.forEach(e -> System.out.println(e));
    model.addAttribute("depts", depts);
    
    return "jsp/dept/list";
  }
  
  @GetMapping("/listemp")
  @Transactional
  public String listWithEmp(Model model) {
    log.info("/dept/listemp 호출됨");
    
    List<DeptVO> depts = deptRepository.findAll();
    depts.forEach(e -> System.out.println(e));
    model.addAttribute("depts", depts);
    
    return "jsp/dept/listemp";
  }

  @GetMapping("/list2")
  @Transactional
  public String list2(Model model) {  
    log.info("/thymeleaf/list2 호출됨");
    
    List<DeptVO> depts = deptRepository.findAll();
    depts.forEach(e -> System.out.println(e));
    model.addAttribute("depts", depts);
    
    return "thymeleaf/dept/list";
  }
  
  @GetMapping("/list2emp")
  @Transactional
  public String list2WithEmp(Model model) {
    log.info("/dept/list2emp 호출됨");
    
    List<DeptVO> depts = deptRepository.findAll();
    depts.forEach(e -> System.out.println(e));
    model.addAttribute("depts", depts);
    
    return "thymeleaf/dept/listemp";
  }
  
  /*
   * 유저가 요청한 도메인을 컨트롤러가 미리 매핑해 놓은 주소와 일치하는지 스프링부트가 판단해서 연결시켜주면,
   * 그때 해당 컨트롤러 클래스의 매핑 주소에 맞는 메소드가 실행되는거야
   * 그래서 뭐 불러오고 뭐하고 리턴값으로 jsp나, thymeleaf의 파일 위치를 가리키면( Forward )
   * 웹브라우져에 그 페이지가 뜨게 되는거징
   */
  
}