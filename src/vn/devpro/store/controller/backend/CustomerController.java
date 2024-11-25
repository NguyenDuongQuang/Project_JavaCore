package vn.devpro.store.controller.backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import vn.devpro.store.model.Customer;

public class CustomerController {

	private static ArrayList<Customer> customers = new ArrayList<>();

	private static int autoId = 4;

	public static int getAutoId() {
		return autoId;
	}

	public static void setAutoId(int autoId) {
		CustomerController.autoId = autoId;
	}

	public static ArrayList<Customer> getCustomers() {
		return customers;
	}

	public static void setCustomers(ArrayList<Customer> customers) {
		CustomerController.customers = customers;
	}

	public static void init() {
		customers.add(new Customer(0, "10000", "Dương Lê", "0965953837"));
		customers.add(new Customer(1, "10001", "Dương Quang", "0965953837"));
		customers.add(new Customer(2, "10002", "Văn Sơn", "0965953837"));
		customers.add(new Customer(3, "10003", "Tú Anh", "0965953837"));
		customers.add(new Customer(4, "10004", "Thị Giang", "0965953837"));
	}

	static Scanner sc = new Scanner(System.in);

	public static void menu() {

		do {
			System.out.println("\n\t\tCAP NHAT THONG TIN KHACH HANG");
			System.out.println("Chon mot chuc nang quan ly");
			System.out.println("\t1. Hien thi danh sach khach hang");
			System.out.println("\t2. Them khach hang moi");
			System.out.println("\t3. Sua thong tin khach hang");
			System.out.println("\t4. Xoa thong tin khach hang");
			System.out.println("\t5. Sap xep danh sach khach hang");
			System.out.println("\t0. Dong chuong trinh");

			System.out.print("Lua chon cua ban?: ");
			int choose = Integer.parseInt(sc.nextLine());

			switch (choose) {
			case 1:
				display();
				break;
			case 2:
				add();
				break;
			case 3:
				edit();
				break;
			case 4:
				delete();
				break;
			case 5:
				sort();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le");
			}
		} while (true);

	}

	private static void display() {
		System.out.println("\t\t\nDANH SACH khach hang");
		System.out.printf("%3s %-12s %-35s %-35s%n", "ID", "Mã KH", "Tên Khách Hàng", "Mobile");
		for (Customer customer : customers) {
			customer.display();
		}

	}

	private static void add() {
		System.out.println("\t\t\nThêm Mới Khách Hàng");
		System.out.print("Nhập Tên Khách Hàng: ");
		String name = sc.nextLine();
		if (name == null || name.isEmpty()) {
			System.out.println("Tên Khách Hàng Không Được Null");
			return;
		}
		System.out.print("Nhập Mobile Khách Hàng: ");
		String mobile = sc.nextLine();
		if (mobile == null || mobile.isEmpty()) {
			System.out.println("Mobile Không Được Null");
			return;
		}
		if (mobile.length() > 0 && mobile.length() < 10) {
			System.out.println("Sai Định Dạng Mobile Chỉ Có 10 Số");
			return;
		}
		if (mobile.length() > 11) {
			System.out.println("Sai Định Dạng Mobile Chỉ Có 10 Số");
			return;
		}

		Customer customer = new Customer(autoId, "1000" + autoId, name, mobile);
		autoId++;
		customers.add(customer);
		System.out.println("THêm Mới Khách Hàng Thành Công !");
	}

	private static void edit() {
		System.out.println("\t\t\nSửa Thông Tin Khách Hàng");
		System.out.print("Nhập Khách Hàng Cần Sửa (Mã KH) : ");
		String code = sc.nextLine();
		int index = findProviderByCode(code);
		if (index == -1) {
			System.out.println("Khách Hàng Này Không Tồn Tại");
			return;
		}
		customers.get(index).edit();
	}

	private static void delete() {
		System.out.println("\t\t\nXóa Thông Tin Khách Hàng");
		System.out.print("Chọn Khách Hàng Cần Xóa (Mã KH): ");
		String code = sc.nextLine();
		int index = findProviderByCode(code);
		if (index == -1) {
			System.out.println("Khách Hàng Này Không Tồn Tại");
			return;
		}
		customers.remove(index);
		System.out.println("Xóa Thành Công!");
	}

	private static void sort() {
		Collections.sort(customers, new Comparator<Customer>() {
			@Override
			public int compare(Customer o1, Customer o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
		});
	}

	public static int findProviderByCode(String code) {
		for (int index = 0; index < customers.size(); index++) {
			if (customers.get(index).getCode().equals(code)) {
				return index;
			}
		}
		return -1;
	}

	public static String getNameById(int customerID) {
		for (Customer customer : customers) {
			if (customer.getId() == customerID) {
				return customer.getName();
			}

		}
		return null;
	}
}
