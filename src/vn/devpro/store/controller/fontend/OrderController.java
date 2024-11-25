package vn.devpro.store.controller.fontend;

import java.util.ArrayList;
import java.util.Scanner;

import vn.devpro.store.controller.backend.CustomerController;
import vn.devpro.store.controller.backend.ProductController;
import vn.devpro.store.dto.Order;
import vn.devpro.store.dto.Product_In_Order;

public class OrderController {
	private static ArrayList<Order> order = new ArrayList<Order>();

	private static ArrayList<Product_In_Order> product_In_Orders = new ArrayList<Product_In_Order>();

	public static ArrayList<Order> getOrder() {
		return order;
	}

	public static void setOrder(ArrayList<Order> order) {
		OrderController.order = order;
	}

	public static void display() {
		System.out.println("\n\t\tDanh Sách Đơn Hàng");

		if (order == null || order.isEmpty()) {
			System.out.println("\n\tKhông Có Sản Phẩm Đã Mua Nào !");
		}
		for (Order orders : order) {
			Product_Int_OrderController.display(orders);
		}
	}

	public static void total() {
		double totalMoney = 0;
		for (Order order : order) {
			totalMoney += order.totalPriceProducts();
		}
		System.out.printf("\tTổng Doanh Thu Bán Được : %,15.2f%n", totalMoney);
	}

	public static void totalThuKH() {
		for (Order orders : order) {
			Product_Int_OrderController.displayKH(orders);
		}
	}

	public static void totalDoanhThu() {
		for (Order orders : order) {
			Product_Int_OrderController.displayDonHang(orders);
		}
	}

	public static void menu() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\n\t\tCHUC NANG DANH CHO KHACH HANG");
			System.out.println("Chon mot chuc nang cap nhat");
			System.out.println("\t1. Xem Danh Sách Đơn Hàng Đã Mua");
			System.out.println("\t2. Tổng Doanh Thu");
			System.out.println("\t3. Tổng Tiền Thu Được Của Từng Khách Hàng");
			System.out.println("\t4. Tổng Doanh Thu Theo Từng Sản Phẩm");
			System.out.println("\t0. Quay lai");

			System.out.print("Lua chon cua ban?: ");
			int choose = Integer.parseInt(sc.nextLine());

			switch (choose) {
			case 1:
				display();
				break;
			case 2:
				total();
				break;
			case 3:
				totalThuKH();
				break;
			case 4:
				totalDoanhThu();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le");
			}
		} while (true);

	}
}
