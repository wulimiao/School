package db;

import java.sql.*;

/**
 * 
 * Title: ���ݿ����� 
 * Description: ���ݿ�����ģ��
 * 
 * @author  Mr.li
 */

public class dbConn {
	public dbConn() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Statement conn() {
		try {
			// ��������
			Class.forName("com.mysql.jdbc.Driver");

			// ���ݿ����ƣ�����Ա�˺š�����
			String url = "jdbc:mysql://localhost:8080/TellHubaDB";
			String user = "root";
			String pwd = "123";

			// ����
			Connection con = null;
			con = DriverManager.getConnection(url, user, pwd);
			Statement stat = con.createStatement();
			return stat;
		} catch (ClassNotFoundException ex) {
			return null;
		} catch (SQLException ex1) {
			return null;
		}
	}

	// ��ѯ���ݿ�
	public ResultSet getRs(String sql) {
		try {
			Statement stat = conn();
			ResultSet rs = stat.executeQuery(sql);
			System.out.println(rs);
			return rs;
		} catch (SQLException ex) {
			System.err.println("------------" + ex.getMessage());
			return null;
		}
	}

	// �������ݿ�
	public int getUpdate(String sql) {
		try {
			Statement stat = conn();
			int i = stat.executeUpdate(sql);
			return i;
		} catch (Exception ex) {
			System.out.println(">>>>>>>>" + ex.getMessage());
			return -1;
		}
	}

	private void jbInit() throws Exception {
		conn();
	}

}
