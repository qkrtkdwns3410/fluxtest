package com.qkrtkdwns3410.fluxtest.config;

import com.qkrtkdwns3410.fluxtest.EventNotify;
import com.qkrtkdwns3410.fluxtest.MyFilter;
import com.qkrtkdwns3410.fluxtest.MyFilter2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;

/**
 * packageName    : com.qkrtkdwns3410.fluxtest.config
 * fileName       : MyFilterConfig
 * author         : qkrtkdwns3410
 * date           : 2022-08-30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-30        qkrtkdwns3410       최초 생성
 */
@Configuration
public class MyFilterConfig {
      
      @Autowired
      private EventNotify eventNotify;
      
      @Bean
      public FilterRegistrationBean<Filter> addFilter() {
            FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>(new MyFilter(eventNotify));
            bean.addUrlPatterns("/sse"); // 모든 접근에 대해 허용 > 올바른 빈 등록을 위하여 // -> sse로 변경 > 응답이 종료되지 않도록
            return bean;
      }
      
      @Bean
      public FilterRegistrationBean<Filter> addFilter2() {
            FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>(new MyFilter2(eventNotify));
            bean.addUrlPatterns("/add"); // 모든 접근에 대해 허용 > 올바른 빈 등록을 위하여 // -> sse로 변경 > 응답이 종료되지 않도록
            return bean;
      }
      
      
}
