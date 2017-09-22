package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.example.domain.DeptVO;

@Configuration
public class CustomConfig {
   
	/*
	 * bean 어노테이션으로 컨피규레이션으로 등록하면 어디서도 가져다가 쓸 수 있음
	 * 컨트롤러에서 모델에 속성을 저장하고 뷰 기술로 읽어낸다.
	 */
	
   @Bean
   InternalResourceViewResolver jspView() {
      InternalResourceViewResolver vr = new InternalResourceViewResolver();
      vr.setPrefix("/WEB-INF/");
      vr.setSuffix(".jsp");
      vr.setViewNames("jsp/*");
      vr.setViewClass(JstlView.class);
      
      return vr;
   }
   
   @Bean
   DeptVO dept() {
	   DeptVO d = new DeptVO();
	   d.setDeptno(999);
	   d.setDname("xxxxx");
	   d.setLoc("yyyyy");
	   return d;
   }
}