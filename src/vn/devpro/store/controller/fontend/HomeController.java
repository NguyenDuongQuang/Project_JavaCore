package vn.devpro.store.controller.fontend;

import vn.devpro.store.controller.backend.ProductController;
import vn.devpro.store.model.Product;

public class HomeController {
	public static void display() {
		System.out.println("Danh Sách Sản Phẩm");
		System.out.printf("%3s %-20s %-10s %-30s %-8s %-15s%n", "Id", "Ten NCC", "Ma SP", "Tên Sản Phẩm", "Số Lượng",
				"Đơn Giá");
		for (Product product : ProductController.getProducts()) {
			product.display();
		}
	}
}
