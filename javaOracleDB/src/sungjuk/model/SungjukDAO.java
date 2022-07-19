package sungjuk.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DB;

public class SungjukDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public ArrayList<SungjukDTO> getSelectAll() {
		ArrayList<SungjukDTO> list = new ArrayList();
		try {
			conn = DB.dbConn();

			String sql = "select no,name,avg,grade,regDate from sungjuk";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
		
				double avg = rs.getDouble("avg");
				String grade = rs.getString("grade");
				Date regDate = rs.getDate("regDate");
				
				SungjukDTO dto = new SungjukDTO();
				dto.setSungjukNo(no);
				dto.setSungjukName(name);
				dto.setAvg(avg);
				dto.setGrade(grade);
				dto.setRegiDate(regDate);
				
				list.add(dto);

			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}
		return list;
	}

	public SungjukDTO getSelectOne(SungjukDTO dto) {
		SungjukDTO imsi = new SungjukDTO();
		try {
			conn = DB.dbConn();

			String sql = "select * from sungjuk where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getSungjukNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				imsi.setSungjukName(rs.getString("name"));
				imsi.setKor(rs.getInt("kor"));
				imsi.setEng(rs.getInt("eng"));
				imsi.setMat(rs.getInt("mat"));
				imsi.setTot(rs.getInt("tot"));
				imsi.setAvg(rs.getDouble("avg"));
				imsi.setGrade(rs.getString("grade"));
				imsi.setRegiDate(rs.getDate("regDate"));
				
				

			} else {
				System.out.println("조회할 정보가 존재하지 않습니다.");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}
		return imsi;
	}

	public int setInsert(SungjukDTO dto) {
		int result = 0;
		try {
			conn = DB.dbConn();
			String sql = "insert into sungjuk(no,name,kor,eng,mat,tot,avg,grade,regDate) values(seq_sungjuk.nextval, ?, ?, ?, ?, ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSungjukName());
			pstmt.setInt(2, dto.getKor());
			pstmt.setInt(3, dto.getEng());
			pstmt.setInt(4, dto.getMat());
			pstmt.setInt(5, dto.getTot());
			pstmt.setDouble(6, dto.getAvg());
			pstmt.setString(7, dto.getGrade());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}
		return result;
	}

	public int setUpdate(SungjukDTO dto) {
		int result = 0;
		try {
			conn = DB.dbConn();
			
			String sql = "update sungjuk set kor = ?,eng = ?, mat = ?, tot = ?, avg = ?, grade = ? where no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getKor());
			pstmt.setInt(2, dto.getEng());
			pstmt.setInt(3, dto.getMat());
			pstmt.setInt(4, dto.getTot());
			pstmt.setDouble(5, dto.getAvg());
			pstmt.setString(6, dto.getGrade());
			pstmt.setInt(7, dto.getSungjukNo());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}
		return result;
	}

	public int setDelete(SungjukDTO dto) {
		int result = 0;
		try {
			conn = DB.dbConn();
			
			String sql = "delete from sungjuk where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getSungjukNo());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}
		return result;
	}

}
