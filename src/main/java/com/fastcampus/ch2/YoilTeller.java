package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

// 년월일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTeller {
//    public static void main(String[] args) {
        @RequestMapping("/getYoil") // http://localhost:8080/ch2/getYoil?year=2021&month=10&day=1
        public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 1. 입력
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");

        int yyyy = Integer.parseInt(year);
        int mm = Integer.parseInt(month);
        int dd = Integer.parseInt(day);

        // 2. 처리
        Calendar cal = Calendar.getInstance();
//        cal.clear();  // 모든 필드(날짜, 시간 등)을 초기화
        cal.set(yyyy, mm - 1, dd);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        char yoil = "일월화수목금토".charAt(dayOfWeek-1); //  일요일:1, 월요일:2, ...

        // 3. 출력
        response.setContentType("text/html");    // 응답의 형식을 html로 지정
        response.setCharacterEncoding("utf-8");  // 응답의 인코딩을 utf-8로 지정
        PrintWriter out = response.getWriter();  // 브라우저로의 출력 스트림(out)을 얻는다.
        out.println(year + "년 " + month + "월 " + day + "일은 ");
        out.println(yoil + "요일입니다.");
    }
}
