package vn.devpro.store.controller.backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import vn.devpro.store.model.Category;


public class CategoryController {
private static ArrayList<Category> categories = new ArrayList<>();
	
	private static int autoId = 4;

	public static ArrayList<Category> getProviders() {
		return categories;
	}

	public static void setProviders(ArrayList<Category> categories) {
		CategoryController.categories = categories;
	}
	
	public static void init() {
		categories.add(new Category(1, "10001", "Unilever"));
		categories.add(new Category(2, "10002", "Sam sung"));
		categories.add(new Category(3, "10003", "Sun House"));
		categories.add(new Category(4, "10004", "Oppo"));
		categories.add(new Category(5, "10005", "Apple"));
	}
	
	static Scanner sc = new Scanner(System.in);
	
	public static void menu() {
		
		do {
			System.out.println("\n\t\tCập Nhật Thông Tin Category");
			System.out.println("Chọn Chức Năng Của Category");
			System.out.println("\t1. Hiển Thị");
			System.out.println("\t2. Thêm");
			System.out.println("\t3. Sửa");
			System.out.println("\t4. Xóa");
			System.out.println("\t5. Sắp Xếp");
			System.out.println("\t0. Thoát");
			
			System.out.print("Mời Chọn: ");
			int choose = Integer.parseInt(sc.nextLine());
			
			switch (choose) {
			case 1: display(); break;
			case 2: add(); break;
			case 3: edit(); break;
			case 4: delete(); break;
			case 5: sort(); break;
			case 0: return;
			default: System.out.println("Vui Lòng Chọn Lại");
			}
		} while (true);
		
	}

	private static void display() {
		System.out.println("\t\t\nDanh Sách Category");
		System.out.printf("%3s %-12s %-35s%n", "ID", 
				"Mã", "Tên Category");
		for (Category category : categories) {
			category.display();
		}
		
	}

	private static void add() {
		System.out.println("\t\t\nThêm Mới Category");
		System.out.print("Nhập Tên Category: ");
		String name = sc.nextLine();
		if (name == null || name.isEmpty()) {
			System.out.println("Tên Không Dduocj Null");
			return;
		}
		Category category = new Category(autoId, "1000" + autoId, name);
		autoId++;
		categories.add(category);
		System.out.println("Thêm Thành Công!");
	}

	private static void edit() {
		System.out.println("\t\t\nSửa Thông Tin Categoty");
		System.out.print("Chọn Category Cần Sửa : ");
		String code = sc.nextLine();
		int index = findProviderByCode(code);
		if (index == -1) {
			System.out.println("Category Không Tồn Tại");
			return;
		}
		categories.get(index).edit();
	}

	private static void delete() {
		System.out.println("\t\t\nXóa Category");
		System.out.print("Chọn Category Cần Xóa : ");
		String code = sc.nextLine();
		int index = findProviderByCode(code);
		if (index == -1) {
			System.out.println("Category Không Tồn Tại");
			return;
		}
		categories.remove(index);
		System.out.println("Xóa Thành Công!");
	}

	private static void sort() {
		Collections.sort(categories, new Comparator<Category>() {
			@Override
			public int compare(Category o1, Category o2) {
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
		});	
	}
	
	public static int findProviderByCode(String code) {
		for (int index = 0; index < categories.size(); index++) {
			if (categories.get(index).getCode().equals(code)) {
				return index;
			}
		}
		return -1;
	}
	public static String getById(int id) {
		for (int index = 0; index < categories.size(); index++) {
			if (categories.get(index).getId()==id) {
				return categories.get(index).getName();
			}
		}
		return null;
	}
}
