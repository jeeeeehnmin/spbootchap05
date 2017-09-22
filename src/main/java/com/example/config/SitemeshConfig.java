package com.example.config;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SitemeshConfig {
/*
 * Sitemesh관련 설정 : dependency 추가 + filter 지정
 * 동작 : URL이 request(호출 되기) 전에 먼저 필터가 끼워짐   
 * filter는 view기술(jsp, thymeleaf) 상관없이 먼저 동작하기 때문에 레이아웃 기술 사용할 수 있게 한다.
 * JSP library
 */
	
	
	/*
	 * 필터 만들기
	 */
	@Bean
	FilterRegistrationBean<Filter> testFilter(){
		FilterRegistrationBean<Filter> filter = new FilterRegistrationBean<>();
		
		filter.setFilter(new Filter() {
			
			@Override
			public void init(FilterConfig filterConfig) throws ServletException {
				System.out.println("###################");
				System.out.println("## My Filter init()");
				System.out.println("###################");
				
			}
			
			@Override
			public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
					throws IOException, ServletException {
				/*
				 * 실제 메소드보다 먼저 호출됨
				 */
				System.out.println("###");
				System.out.println("### My Filter doFilter() start...");
				System.out.println("###");
				chain.doFilter(request, response);
				System.out.println("###");
				System.out.println("### My Filter doFilter() end...");
				System.out.println("###");
				
			}
			
			@Override
			public void destroy() {
				System.out.println("###################");
				System.out.println("## My Filter destroy()");
				System.out.println("###################");
				
			}
		});
		//필터를 적용할 URL지정
		filter.setUrlPatterns(Arrays.asList("/dept/*", "/emp/*"));
		return filter;
	}
	
	@Bean
	FilterRegistrationBean<ConfigurableSiteMeshFilter> siteMeshFilter(){
		FilterRegistrationBean<ConfigurableSiteMeshFilter> filter = new FilterRegistrationBean<>();
		
		filter.setFilter(new ConfigurableSiteMeshFilter(){
			
			@Override
			protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
				
				//contentPath를 호출하면 decoratePath를 적용
				builder.addDecoratorPaths("/bootstrap/*", "/WEB-INF/decorators/grid.jsp");
//				builder.addDecoratorPaths("/bootstrap/*", "/WEB-INF/decorators/default.jsp");
//				builder.addDecoratorPaths("/animate/*", "/WEB-INF/decorators/default.jsp");
			}
		});
		
		filter.setUrlPatterns(Arrays.asList("/bootstrap/*", "/animate/*"));
		
		return filter;
	}
	
	
}