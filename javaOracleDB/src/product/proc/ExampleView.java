package product.proc;

import java.util.Scanner;

import product.model.ProductDAO;
import product.model.ProductDTO;

public class ExampleView {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("상세조회할 상품번호를 입력해주세요 : ");
		String code_ = sc.nextLine();
		
		int code = Integer.parseInt(code_);
		
		ProductDTO dto = new ProductDTO();
		dto.setProductCode(code);
		
		ProductDAO dao = new ProductDAO();
		dto = dao.getSelectOne(dto);
		
		System.out.println("Code : " + dto.getProductCode());
		System.out.println("Name : " + dto.getProductName());
		System.out.println("Price : " + dto.getProductPrice());
		System.out.println("Content : " + dto.getProductContent());
		System.out.println("Vender : " + dto.getVender());
		System.out.println("Date : " + dto.getRegiDate());
	}
}
