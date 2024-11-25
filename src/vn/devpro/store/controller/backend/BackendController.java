package vn.devpro.store.controller.backend;

import java.util.Scanner;

import vn.devpro.store.controller.fontend.OrderController;

public class BackendController {

	public static void menu() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\n\t\tCập Nhật Thông Tin Hệ thống");
			System.out.println("Chọn 1 Hệ Thống Cần Cập Nhật");
			System.out.println("\t1. Cập Nhật Thông Tin Category");
			System.out.println("\t2. Cập Nhật thông Tin Sản Phẩm");
			System.out.println("\t3. Cập Nhật thông Tin Khách Hàng");
			System.out.println("\t4. Quản Lý Đơn Hàng");
			System.out.println("\t0. Quay lai");

			System.out.print("Lua chon cua ban?: ");
			int choose = Integer.parseInt(sc.nextLine());

			switch (choose) {
			case 1:
				CategoryController.menu();
				break;
			case 2:
				ProductController.menu();

				break;
			case 3:
				CustomerController.menu();
				break;
			case 4:
				OrderController.menu();
				break;
			case 0:
				return;
			default:
				System.out.println("Không Hợp Lệ Vui Lòng Nhập Lại");
			}
		} while (true);

	}
}
