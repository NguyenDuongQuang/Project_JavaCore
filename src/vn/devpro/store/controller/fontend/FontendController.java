package vn.devpro.store.controller.fontend;

import java.util.Scanner;


public class FontendController {
	public static void menu() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\n\t\tCHUC NANG DANH CHO KHACH HANG");
			System.out.println("Chon mot chuc nang cap nhat");
			System.out.println("\t1.Xem danh sách Sản phảm");
			System.out.println("\t2. Quản Lý Giỏ Hàng");
			System.out.println("\t0. Quay lai");

			System.out.print("Lua chon cua ban?: ");
			int choose = Integer.parseInt(sc.nextLine());

			switch (choose) {
			case 1:
				HomeController.display();
				break;
			case 2:
				Product_Int_OrderController.menu();
				
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le");
			}
		} while (true);

	}
}
