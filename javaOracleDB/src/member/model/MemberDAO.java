package member.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DB;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public ArrayList<MemberDTO> getSelectAll() {
		ArrayList<MemberDTO> list = new ArrayList();
		try {
			conn = DB.dbConn();
			// =============================================================================================
			String sql = "select * from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // select는 executeQuery;

			

			while (rs.next()) {
				int no = rs.getInt("memberNO");
				String id = rs.getString("memberId");
				String name = rs.getString("memberName");
				String phone = rs.getString("memberPhone");
				Date regiDate = rs.getDate("regiDate");
				
				MemberDTO dto = new MemberDTO();
				dto.setMemberNO(no);
				dto.setMemberId(id);
				dto.setMemberName(name);
				dto.setMemberPhone(phone);
				dto.setRegiDate(regiDate);
				
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println("== DB 접속 실패 ==");
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}
		return list;
	}
	
	public MemberDTO getSelectOne(MemberDTO dto) {
		MemberDTO tmp = new MemberDTO();
		try {
			conn = DB.dbConn();
			String sql = "select * from member where memberNO = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getMemberNO());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int no = rs.getInt("memberNO");
				String id = rs.getString("memberId");
				String name = rs.getString("memberName");
				String phone = rs.getString("memberPhone");
				String jumin = rs.getString("memberJumin");
				String email = rs.getString("memberEmail");
				String address = rs.getString("memberAddress");
				Date regiDate = rs.getDate("regiDate");
				
				tmp.setMemberId(id);
				tmp.setMemberName(name);
				tmp.setMemberPhone(phone);
				tmp.setMemberJumin(jumin);
				tmp.setMemberEmail(email);
				tmp.setMemberAddress(address);
				tmp.setRegiDate(regiDate);

				
			} 

		} catch (Exception e) {
			System.out.println("== DB 접속 실패 ==");
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}
		return tmp;
	}

	public int setInsert(MemberDTO dto) {
		int result = 0;
		try {
			conn = DB.dbConn();
			String sql = "insert into member values(seq_member.nextval, ?, ?, ?, ?, ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMemberId());
			pstmt.setString(2, dto.getMemberPw());
			pstmt.setString(3, dto.getMemberName());
			pstmt.setString(4, dto.getMemberJumin());
			pstmt.setString(5, dto.getMemberPhone());
			pstmt.setString(6, dto.getMemberEmail());
			pstmt.setString(7, dto.getMemberAddress());

			result = pstmt.executeUpdate(); // 몇개가 추가 되었는지 insert, delete, update 는 executeUpdate;
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("-- DB 접속 실패 --");
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}
		return result;
	}

	public int setUpdate(MemberDTO dto) {
		int result = 0;
		try {
			conn = DB.dbConn();
			String sql = "update member set memberId = ?, memberName = ? where memberNO = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMemberId());
			pstmt.setString(2, dto.getMemberName());
			pstmt.setInt(3, dto.getMemberNO());
			result = pstmt.executeUpdate(); // 몇개가 추가 되었는지 insert, delete, update 는 executeUpdate;

		} catch (Exception e) {
			System.out.println("-- DB 접속 실패 --");
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}
		return result;
	}

	public int setDelete(MemberDTO dto) {
		int result = 0;
		try {
			conn = DB.dbConn();
			String sql = "delete from member where memberNO = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getMemberNO());
			result = pstmt.executeUpdate(); // 몇개가 추가 되었는지 insert, delete, update 는 executeUpdate;

		} catch (Exception e) {
			System.out.println("-- DB 접속 실패 --");
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}
		return result;
	}

	

}
