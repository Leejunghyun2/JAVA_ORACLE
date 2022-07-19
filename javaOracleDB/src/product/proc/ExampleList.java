package product.proc;

import java.util.ArrayList;

import product.model.ProductDAO;
import product.model.ProductDTO;

public class ExampleList {
	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
		
		ArrayList<ProductDTO> product = dao.getSelectAll();
		
		for(int i=0; i < product.size(); i++) {
			System.out.println(product.get(i));
		}
		
		
	}
}
