package product.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DB;

public class ProductDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

//	public String getSelectAll() {
//		String imsi = "";
//		try {
//			conn = DB.dbConn();
//			String sql = "select productCode, productName, productPrice, vender from product";
//
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				String code = rs.getString("productCode");
//				String name = rs.getString("productName");
//				String price = rs.getString("productPrice");
//				String vender = rs.getString("vender");
//
//
//				imsi += code + "/";
//				imsi += name + "/";
//				imsi += price + "/";
//				imsi += vender + "|";
//
//				//System.out.println(imsi);
//				
//				
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			DB.dbConnClose(rs, pstmt, conn);
//		}
//		return imsi;
//	}
	public ArrayList<ProductDTO> getSelectAll() {
		ArrayList<ProductDTO> imsi = new ArrayList<ProductDTO>();
		try {
			conn = DB.dbConn();
			String sql = "select productCode, productName, productPrice, vender from product";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int code = rs.getInt("productCode");
				String name = rs.getString("productName");
				int price = rs.getInt("productPrice");
				String vender = rs.getString("vender");
				ProductDTO dto = new ProductDTO();
				dto.setProductCode(code);
				dto.setProductName(name);
				dto.setProductPrice(price);
				dto.setVender(vender);
				
				imsi.add(dto);
				
				//System.out.println(imsi);
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}
		return imsi;
	}
	
	public ProductDTO getSelectOne(ProductDTO paramDto) {
		ProductDTO dto = new ProductDTO();
		try {
			conn = DB.dbConn();
			
			String sql = "select * from product where productCode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getProductCode());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int code = rs.getInt("productCode");
				String name = rs.getString("productName");
				int price = rs.getInt("productPrice");
				String content = rs.getString("productContent");
				String vender = rs.getString("vender");
				Date regiDate = rs.getDate("regiDate");

				dto.setProductCode(code);
				dto.setProductName(name);
				dto.setProductPrice(price);
				dto.setProductContent(content);
				dto.setVender(vender);
				dto.setRegiDate(regiDate);

				
				
			} else {
				System.out.println("조회할 데이터가 없습니다.");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}
		return dto;
	}

	public int setInsert(ProductDTO paramDto) {
		int result = 0;
		try {
			conn = DB.dbConn();
			String sql = "insert into product (productCode, productName, productPrice, productContent, vender, regiDate) values (seq_product.nextval, ?, ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getProductName());
			pstmt.setInt(2, paramDto.getProductPrice());
			pstmt.setString(3, paramDto.getProductContent());
			pstmt.setString(4, paramDto.getVender());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}
		return result;
	}

	public int setUpdate(ProductDTO paramDto) {
		int result = 0;
		try {
			conn = DB.dbConn();
			 
			String sql = "update product set productPrice = ?, productContent = ?, vender = ? where productCode = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getProductPrice());
			pstmt.setString(2, paramDto.getProductContent());
			pstmt.setString(3,paramDto.getVender());
			pstmt.setInt(4, paramDto.getProductCode());
			result = pstmt.executeUpdate();
		} catch (Exception e) {			
			// TODO: handle exception
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}
		return result;
	}

	public int setDelete(ProductDTO paramDto) {
		int result = 0;
		try {
			conn = DB.dbConn();
			
			String sql = "delete from product where productCode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getProductCode());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}
		return result;
	}

}
