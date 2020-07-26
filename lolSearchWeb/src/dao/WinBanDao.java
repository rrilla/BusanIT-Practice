package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import vo.BanRatio;
import vo.WinRatio;

public class WinBanDao {
	private WinBanDao() {}
	
	private static WinBanDao instance = new WinBanDao();
	
	public static WinBanDao getInstance() {
		return instance;
	}
	
	private Connection getDBCP() {
		Connection conn=null;
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/oracleDB");
			conn = ds.getConnection();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return conn;
	}
	
	public List<WinRatio> selectAll() {
		List<WinRatio> list = new ArrayList<WinRatio>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select w.no, w.name, w.line, w.winratio, w.pickratio,b.banratio "
				+ "from winratio w,banratio b where w.name=b.name order by no";

		try {
			conn = getDBCP();
			ps = conn.prepareStatement(sql);
//			ps.setString(1, column);
			rs = ps.executeQuery();
			while (rs.next()) {
				WinRatio win=new WinRatio();
				win.setNo(rs.getInt("no"));
				win.setName(rs.getString("name"));
				win.setLine(rs.getString("line"));
				win.setWinRatio(rs.getString("winratio"));
				win.setPickRatio(rs.getString("pickratio"));
				win.setBanRatio(rs.getString("banratio"));
				list.add(win);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public void delete() {
		Connection conn=null;
		PreparedStatement ps=null;
		PreparedStatement ps2=null;
		String sql="delete from BANRATIO";
		String sql2="delete from WINRATIO";
		try {
			conn=getDBCP();
			ps=conn.prepareStatement(sql);
			int n=ps.executeUpdate();
			if(n>0) {
				System.out.println("삭제중....");
			}else {
				System.out.println("삭제 실패(BANRATIO)");
			}
			sql="delete from WINRATIO";
			ps2=conn.prepareStatement(sql2);
			n=ps.executeUpdate();
			if(n>0) {
				System.out.println("삭제중....");
			}else {
				System.out.println("삭제 실패(BANRATIO)");
			}
		}catch(Exception ex) {
			ex.getStackTrace();
		}finally {
			try {
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {
				e.getStackTrace();
			}
		}
	}
	
	public void crawling() {
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
				
				WinRatio win1=new WinRatio(i,name,line,winRatio,pickRatio);
				WinBanDao conn=WinBanDao.getInstance();
				conn.insertWinRatio(win1);
			}
			doc=Jsoup.connect(url2).get();
			Elements champList2=doc.select("tbody.tabItem.champion-trend-banratio-ALL").select("tr");
			for(int i=0; i<champList2.size(); i++) {
				Element champ=champList2.get(i);
				String name=champ.select(".champion-index-table__name").text();
				String banRatio=champ.select(".champion-index-table__cell.champion-index-table__cell--value.champion-index-table__cell--blue").text();
				
				BanRatio ban1=new BanRatio(name, banRatio);
				WinBanDao conn=WinBanDao.getInstance();
				conn.insertBanRatio(ban1);
			}
		}catch(Exception e) {
		}
	}
	
	public void insertWinRatio(WinRatio win) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into WINRATIO values(?,?,?,?,?)";
		try {
			conn = getDBCP();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, win.getNo());
			ps.setString(2, win.getName());
			ps.setString(3, win.getLine());
			ps.setString(4, win.getWinRatio());
			ps.setString(5, win.getPickRatio());
			int n = ps.executeUpdate();
			if (n == 1)
				System.out.println("데이터 입력 성공");
		} catch (Exception ex) {
			ex.getStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	}
	
	public void insertBanRatio(BanRatio ban) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into BANRATIO values(?,?)";
		try {
			conn = getDBCP();
			ps = conn.prepareStatement(sql);
			ps.setString(1, ban.getName());
			ps.setString(2, ban.getBanRatio());
			int n = ps.executeUpdate();
			if (n == 1)
				System.out.println("데이터 입력 성공");
		} catch (Exception ex) {
			ex.getStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	}
}
