package com.qkrtkdwns3410.fluxtest;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName    : com.qkrtkdwns3410.fluxtest
 * fileName       : EventNotify
 * author         : qkrtkdwns3410
 * date           : 2022-08-30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-30        qkrtkdwns3410       최초 생성
 */
@Component
@Setter
@Getter
public class EventNotify {
      
      private List<String> events = new ArrayList<>();
      
      private boolean change = false;
      
      public void add(String data) {
            
            events.add(data);
            change = true; // 데이터가 들어오는 순간 true로 변경된다.
      }
      
      public boolean getChanges() {
            return change;
      }
      
}
