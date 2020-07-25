package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

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
				+ "from winratio w,banratio b where w.name=b.name order by w.no";

		try {
			conn = getDBCP();
			ps = conn.prepareStatement(sql);
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
}
