package lolSearch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class program {
	Scanner sc=new Scanner(System.in);
	ArrayList<WinRatio> movieList=null;
	
	public void save() {
		String url1 = "https://www.op.gg/champion/ajax/statistics/trendChampionList/type=winratio";	//승률,픽률
		String url2 = "https://www.op.gg/champion/ajax/statistics/trendChampionList/type=banratio";	//밴률
		Document doc=null;
		try{
			doc=Jsoup.connect(url1).get();
			Elements champList=doc.select("tbody.tabItem.champion-trend-winratio-ALL").select("tr");
			for(int i=0; i<champList.size();i++) {
				Element champ=champList.get(i);
				String name=champ.select(".champion-index-table__name").text();
				String line=champ.select(".champion-index-table__position").text();
				String winRatio=champ.select(".champion-index-table__cell.champion-index-table__cell--value.champion-index-table__cell--blue").text();
				String ratio=champ.select(".champion-index-table__cell.champion-index-table__cell--value").text();
				String pickRatio = ratio.substring(7);
				System.out.println("이름 : " + name+" // 라인 : "+line+" // 승률 : "+winRatio+" // 픽률 : "+pickRatio);
				
				WinRatio win1=new WinRatio(i,name,line,winRatio,pickRatio);
				System.out.println(win1);
				DBConn conn=DBConn.getInstance();
				conn.insertWinRatio(win1);
			}
			System.out.println("==========================================\n");
			doc=Jsoup.connect(url2).get();
			Elements champList2=doc.select("tbody.tabItem.champion-trend-banratio-ALL").select("tr");
			for(int i=0; i<champList2.size(); i++) {
				Element champ=champList2.get(i);
				String name=champ.select(".champion-index-table__name").text();
				String banRatio=champ.select(".champion-index-table__cell.champion-index-table__cell--value.champion-index-table__cell--blue").text();
				System.out.println("\n이름 : "+name+" // 밴률 : "+banRatio);
				
				BanRatio ban1=new BanRatio(name, banRatio);
				System.out.println(ban1);
				DBConn conn=DBConn.getInstance();
				conn.insertBanRatio(ban1);
			}
		}	catch(Exception e) {
		}
	}
	
	public void reset() {
		DBConn conn=DBConn.getInstance();
		conn.deleteBanRatio();
		conn.deleteWinRatio();
		while(true) {
			System.out.print("\n다시 데이터 저장함? Y,N\n>> ");
			String del = sc.next();
			if(del.equals("Y") || del.equals("y")) {
				save();
			}else if(del.equals("N") || del.equals("n")) {
				System.out.println("홈으로~");break;
			}else {
				System.out.print("잘못입력, 다시\n>> ");
			}
		}
	}
	
	public void show() {
		DBConn conn=DBConn.getInstance();
		ArrayList list=conn.selectAll();
		if(list.size()==0) {
			System.out.println("데이터가 없음.ㅠ\n데이터 저장을 먼저해야함");
		}else {
			for(int i=0; i<list.size();i++) {
				System.out.println(list.get(i));
			}
		}
	}
	
	public void search() {
		while(true) {
			System.out.print("\n1.챔프 이름으로 검색 할래! | 2.포지션으로 검색 할래! | 3.홈으로~\n※숫자만 쳐주세용※\n>> ");
			String num=sc.next();
			if(num.equals("1")) {
				searchName();
			}else if(num.equals("2")) {
				searchLine();
			}else if(num.equals("3")) {
				break;
			}else {
				System.out.println("잘못썼다, 다시.");
			}
		}
	}
	
	public void searchName() {
		System.out.print("\n검색할 챔프 이름 쓰셈(영어로, 맨첫자만 대문자)\n>> ");
		String name=sc.next();
		DBConn conn=DBConn.getInstance();
		ArrayList<WinRatio> list=conn.searchName(name);
		if(list.size()==0) {
			System.out.println("없다.\n오타나 데이터 저장했는지 보셈");
		}else {
			for(int i=0; i<list.size();i++) {
				System.out.println(list.get(i));
			}
		}
	}
	
	public void searchLine() {
		System.out.print("\n검색할 라인 쓰셈(영어로, 맨첫자만 대문자)\n>> ");
		String line=sc.next();
		DBConn conn=DBConn.getInstance();
		ArrayList<WinRatio> list=conn.searchLine(line);
		if(list.size()==0) {
			System.out.println("없다.\n오타나 데이터 저장했는지 보셈");
		}else {
			for(int i=0; i<list.size();i++) {
				System.out.println(list.get(i));
			}
		}
	}
	
	public void idSearch() {
		Runtime runtime = Runtime.getRuntime();
		String str = "C:/Program Files/Internet Explorer/iexplore.exe ";
		String url ="http://www.op.gg/summoner/"; 
		System.out.print("\n검색할 ID 쓰셈\n>> ");
		String id = sc.next();
		try {
			runtime.exec(str+url+id);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void run() {
		System.out.println("롤	  ,ad8888ba,   88888888ba         ,ad8888ba,    ,ad8888ba,");
		System.out.println("검	 d8\"'    `\"8b  88      \"8b       d8\"'    `\"8b  d8\"'    `\"8b");
		System.out.println("색	d8'        `8b 88      ,8P      d8'           d8'");
		System.out.println("프	88          88 88aaaaaa8P'      88            88");
		System.out.println("로	88          88 88\"\"\"\"\"\"'        88      88888 88      88888");
		System.out.println("그	Y8,        ,8P 88               Y8,        88 Y8,        88");
		System.out.println("램	 Y8a.    .a8P  88                Y8a.    .a88  Y8a.    .a88");
		System.out.println("㉿	  `\"Y8888Y\"'   88     HJH&op.gg   `\"Y88888P\"    `\"Y88888P\"\n");
		while(true) {
			System.out.print("\n1.데이터 저장 | 2.데이터 동기화 | 3.모든 챔프 보여줘! | 4.검색 할래! | 5.ID검색 할래! | 6.ㅂㅂ\n※숫자만 쳐주세용※\n>> ");
			String num = sc.next();
			if(num.equals("1")) {
				save();
			}else if(num.equals("2")) {
				reset();
			}else if(num.equals("3")) {
				show();
			}else if(num.equals("4")) {
				search();
			}else if(num.equals("5")) {
				idSearch();
			}else if(num.equals("6")) {
				break;
			}else {
				System.out.println("잘못썼다, 다시.");
			}
		}
		System.out.println("ㅂㅂ");
	}
	
	public static void main(String[] args) {
		program pro=new program();
			pro.run();
	}

}
