package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public static Connection dbConn() {
		Connection conn = null;
		try {
			String dbDriver = "oracle.jdbc.driver.OracleDriver";
			String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
			String dbId = "javaOracleDB";
			String dbPw = "1234";
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			System.out.println("== DB 접속 성공 ==");
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("== DB 접속 실패 ==");
		}
		return conn;
	}

	public static void dbConnClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
			System.out.println("== DB 접속 끊기 성공 ==");

		} catch (Exception e) {
			System.out.println("== DB 접속 끊기 실패 ==");
		}

	}
}
