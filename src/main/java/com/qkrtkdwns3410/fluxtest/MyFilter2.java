package com.qkrtkdwns3410.fluxtest;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * packageName    : com.qkrtkdwns3410.fluxtest
 * fileName       : MyFilter
 * author         : qkrtkdwns3410
 * date           : 2022-08-30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-30        qkrtkdwns3410       최초 생성
 */
public class MyFilter2 implements Filter {
      private EventNotify eventNotify;
      
      public MyFilter2(EventNotify eventNotify) {
            this.eventNotify = eventNotify;
      }
      
      @Override
      public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            System.out.println("필터2 실행됨");
            
            //데이터를 하나 발생시켜서
            eventNotify.add("새로운 데이터");
      }
      
}
