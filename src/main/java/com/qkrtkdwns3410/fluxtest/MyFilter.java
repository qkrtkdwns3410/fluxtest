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
public class MyFilter implements Filter {
      private EventNotify eventNotify;
      
      public MyFilter(EventNotify eventNotify) {
            this.eventNotify = eventNotify;
      }
      
      @Override
      public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            System.out.println("필터 실행됨.");
            
            HttpServletResponse servletResponse = (HttpServletResponse) response;
            servletResponse.setContentType("text/event-stream; charset = utf8"); // text/plain의 경우 버퍼 플러쉬를 1초마다 해줘도 전부 다 출력될때 까지 waiting
            // 하지만 text/event-stream의 경우 플러시 할때 마다 읽어서 화면에 뿌리게 된다
            PrintWriter out = servletResponse.getWriter();
            
            for (int i = 0; i < 5; i++) {
                  out.println("응답" + i); // 버퍼에 데이터 쌓고
                  out.flush(); // 버퍼를 비우는 역할
                  
                  try {
                        Thread.sleep(1000);
                  } catch (InterruptedException e) {
                        e.printStackTrace();
                  }
                  
            }
            //원래는 종료됨.
            // 스택이 종료 되지 않도록.. ->  flux 의 개념
            while (true) {
                  try {
                        Thread.sleep(1);
                  } catch (InterruptedException e) {
                        e.printStackTrace();
                  }
            }
            //여기서 sse 적용해보겠습니다.
            
      }
}
