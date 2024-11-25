package vn.devpro.store.controller.backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import vn.devpro.store.model.Category;
import vn.devpro.store.model.Product;

public class ProductController {
	private static int autoId = 1;

	private static ArrayList<Product> products = new ArrayList<>();

	public static ArrayList<Product> getProducts() {
		return products;
	}

	public static void init() {
		products.add(new Product(autoId++, 1, "10001", "Kem Đánh Răng", 120000));
		products.add(new Product(autoId++, 2, "10002", "Bàn Chải Điện", 12000000));
		products.add(new Product(autoId++, 3, "10003", "Nồi Cơm", 450000));
		products.add(new Product(autoId++, 4, "10004", "Chảo Chiên Không Dầu", 5200000));
		products.add(new Product(autoId++, 5, "10005", "Tủ Lạnh 150ml", 180000));

	}

	public static void setProducts(ArrayList<Product> products) {
		ProductController.products = products;
	}

	static Scanner sc = new Scanner(System.in);

	public static void menu() {

		do {
			System.out.println("\n\t\tCập Nhật Thông Tin Sản Phẩm");
			System.out.println("Chọn Chức Năng Quản Lý Sản Phẩm");
			System.out.println("\t1. Hiển Thị");
			System.out.println("\t2. Thêm");
			System.out.println("\t3. Sửa");
			System.out.println("\t4. Xóa");
			System.out.println("\t5. Sắp Xếp");
			System.out.println("\t0. Thoát");

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
				System.out.println("Sắp Xếp Thành Công !");
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le");
			}
		} while (true);

	}

	private static void display() {
		System.out.println("Danh Sách Sản Phẩm");
		System.out.printf("%3s %-20s %-10s %-30s %-15s%n", "Id", "Tên Category", "Mã SP", "Tên Sản Phẩm", "Đơn Giá");
		for (Product product : products) {
			product.display();
		}
	}

	private static void add() {
		System.out.println("\t\t\nThêm Sản Phẩm");
		System.out.println("Chọn Category :");
		String categoryCode = sc.nextLine();
		int index = CategoryController.findProviderByCode(categoryCode);
		if (index == -1) {
			System.out.println("Category Không Tồn Tại");
			return;
		}
		System.out.print("Nhập Tên Sản Phẩm: ");
		String name = sc.nextLine();
		if (name == null || name.isEmpty()) {
			System.out.println("Tên Sản Phẩm Không Được Null");
			return;
		}
		System.out.println("Nhập Đon Giá :");
		double price = Double.parseDouble(sc.nextLine());
		if (price < 0) {
			System.out.println("Giá Bán Không Âm");
			return;
		}
		Category category = new Category();
		int category_id = CategoryController.findProviderByCode(categoryCode);
		Product product = new Product(autoId, category_id, "1000" + autoId++, name, price);
		autoId++;
		products.add(product);
		System.out.println("Thêm Thành Công !");
	}

	private static void edit() {
		System.out.println("\t\t\nSửa Thông Tin Sản Phẩm");
		System.out.print("Chọn Sản Phẩm (Mã): ");
		String code = sc.nextLine();
		int index = findProductByCode(code);
		if (index == -1) {
			System.out.println("Mã Sản Phẩm Không Tồn Tại");
			return;
		}
		products.get(index).edit();
		System.out.println("Sửa Sản Phẩm thành Công");
	}

	private static void delete() {
		System.out.println("\t\t\nXóa Thông Tin Sản Phẩm");
		System.out.print("Chọn Sản Phẩm Cần Xóa (Mã): ");
		String code = sc.nextLine();
		int index = findProductByCode(code);
		if (index == -1) {
			System.out.println("Mã Sản Phẩm Không Tồn Tại");
			return;
		}
		products.remove(index);
		System.out.println("Xóa Thành Công");
	}

	private static void sort() {
		Collections.sort(products, new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
		});
	}

	public static int findProductByCode(String code) {
		for (int index = 0; index < products.size(); index++) {
			if (products.get(index).getCode().equals(code)) {
				return index;
			}
		}
		return -1;
	}

	public static Product getProductById(int id) {
		for (Product product : products) {
			if (product.getId() == id) {
				return product;
			}
		}
		return new Product();
	}
}
