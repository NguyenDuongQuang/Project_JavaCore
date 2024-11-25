package vn.devpro.store;

import java.util.Scanner;

import vn.devpro.store.controller.backend.BackendController;
import vn.devpro.store.controller.backend.CategoryController;
import vn.devpro.store.controller.backend.CustomerController;
import vn.devpro.store.controller.backend.ProductController;
import vn.devpro.store.controller.fontend.FontendController;


public class StartingProject {
	public static void main(String[] args) {
//
		CategoryController.init();
		CustomerController.init();
		ProductController.init();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\n\t\tCHUONG TRINH QUAN LY BAN HANG");
			System.out.println("Mời Bạn Chọn Chức Năng");
			System.out.println("\t1. Quản Trị Viên - BE");
			System.out.println("\t2. Khách Hàng - FE");
			System.out.println("\t0. Thoát Chương Trình");

			System.out.print("Lua chon cua ban?: ");
			int choose = Integer.parseInt(sc.nextLine());

			switch (choose) {
			case 1:
				BackendController.menu();
				break;
			case 2:
				FontendController.menu();
				;
				break;
			case 0:
				return;
			default:
				System.out.println("Chọn Không Hợp Lệ.Vui Lòng Chọn Lại");
			}
		} while (true);
	}
}
