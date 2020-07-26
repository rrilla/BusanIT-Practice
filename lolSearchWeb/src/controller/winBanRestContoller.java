package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.WinBanDao;
import vo.WinRatio;


@WebServlet("/api/winBan")
public class winBanRestContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 호출됨");
		
		String strJson = "";
		WinBanDao winBanDao = WinBanDao.getInstance();
		
		winBanDao = winBanDao.getInstance();
		List<WinRatio> list = winBanDao.selectAll(); //추가
			
		// 데이터 응답 포맷 2가지 - JSON, XML
		// 자바 객체의 데이터를 JSON 포맷 문자열로 변환하기
		Gson gson = new Gson();
		strJson = gson.toJson(list);
		System.out.println(list);
				
		// 클라이언트로 출력하기
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(strJson); // 정상응답은 200번 코드 사용
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doDelete() 호출됨");
		
		WinBanDao winBanDao = WinBanDao.getInstance();
		winBanDao.delete();
		winBanDao.crawling();
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("글갱신 성공!");
		out.close(); 
	}

}
