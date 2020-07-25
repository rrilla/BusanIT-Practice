package lolSearch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBConn {
	private static DBConn instance = new DBConn();
	
	private DBConn() {}

	public static DBConn getInstance() {
		return instance;
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			String user = "hjh";
			String pw = "1234";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);
//			System.out.println("Database에 연결되었습니다.");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB 드라이버 로딩 실패 :" + cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB 접속실패 : " + sqle.toString());
		} catch (Exception e) {
			System.out.println("Unkonwn error");
			e.printStackTrace();
		}
		return conn;
	}

	public void insertWinRatio(WinRatio win) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into WINRATIO values(?,?,?,?,?)";
		try {
			conn = getConnection();
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
			conn = getConnection();
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
	
	public void deleteBanRatio() {
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="delete from BANRATIO";
		try {
			conn=getConnection();
			ps=conn.prepareStatement(sql);
			int n=ps.executeUpdate();
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
	
	public void deleteWinRatio() {
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="delete from WINRATIO";
		try {
			conn=getConnection();
			ps=conn.prepareStatement(sql);
			int n=ps.executeUpdate();
			if(n>0) {
				System.out.println(n+"개 챔프가 날라감");
			}else {
				System.out.println("삭제 실패(WINRATIO)");
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
	
	public ArrayList<WinRatio> selectAll(){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select w.no, w.name, w.line, w.winratio, w.pickratio,"
				+ " b.banratio from winratio w,banratio b where w.name=b.name order by w.no";
		ArrayList<WinRatio> champList=new ArrayList<WinRatio>();
		try {
			conn=getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				WinRatio win=new WinRatio();
				win.setNo(rs.getInt("no"));
				win.setName(rs.getString("name"));
				win.setLine(rs.getString("line"));
				win.setWinRatio(rs.getString("winratio"));
				win.setPickRatio(rs.getString("pickratio"));
				win.setBanRatio(rs.getString("banratio"));
				champList.add(win);
			}
		}catch(Exception ex) {
			System.out.println("select문에서 오류발생");
			ex.getStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {
				e.getStackTrace();
			}
		}
		return champList;
	}
	
	public ArrayList<WinRatio> searchName(String name){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select w.no, w.name, w.line, w.winratio, w.pickratio, b.banratio "
				+ "from winratio w,banratio b where w.name=b.name and w.name like ? order by w.no";
		ArrayList<WinRatio> champList=new ArrayList<WinRatio>();
		try {
			conn=getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
			rs=ps.executeQuery();
			while(rs.next()) {
				WinRatio win=new WinRatio();
				win.setNo(rs.getInt("no"));
				win.setName(rs.getString("name"));
				win.setLine(rs.getString("line"));
				win.setWinRatio(rs.getString("winratio"));
				win.setPickRatio(rs.getString("pickratio"));
				win.setBanRatio(rs.getString("banratio"));
				champList.add(win);
			}
		}catch(Exception ex) {
			ex.getStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {
				e.getStackTrace();
			}
		}
		return champList;
	}
	
	public ArrayList<WinRatio> searchLine(String line){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select w.no, w.name, w.line, w.winratio, w.pickratio, b.banratio "
				+ "from winratio w,banratio b where w.name=b.name and w.line like ? order by w.no";
		ArrayList<WinRatio> champList=new ArrayList<WinRatio>();
		try {
			conn=getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, "%"+line+"%");
			rs=ps.executeQuery();
			while(rs.next()) {
				WinRatio win=new WinRatio();
				win.setNo(rs.getInt("no"));
				win.setName(rs.getString("name"));
				win.setLine(rs.getString("line"));
				win.setWinRatio(rs.getString("winratio"));
				win.setPickRatio(rs.getString("pickratio"));
				win.setBanRatio(rs.getString("banratio"));
				champList.add(win);
			}
		}catch(Exception ex) {
			ex.getStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {
				e.getStackTrace();
			}
		}
		return champList;
	}
	
}
