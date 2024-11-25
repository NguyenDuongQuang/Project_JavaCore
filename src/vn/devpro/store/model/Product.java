package vn.devpro.store.model;

import java.util.Scanner;

import vn.devpro.store.controller.backend.CategoryController;

public class Product {
	private int id;
	private int category_Id;
	private String code;
	private String name;
	private double price;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int id, int category_Id, String code, String name, double price) {
		super();
		this.id = id;
		this.category_Id = category_Id;
		this.code = code;
		this.name = name;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategory_Id() {
		return category_Id;
	}
	public void setCategory_Id(int category_Id) {
		this.category_Id = category_Id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void edit() {
		Scanner scanner = new Scanner(System.in);

		int chon;
		do {
			System.out.println("Sửa thông Tin Sản Phẩm");
			System.out.println("1.Sửa Tên NCC ");
			System.out.println("2.Sửa Tên Sản Phẩm");
			System.out.println("3.Sửa Số Lượng");
			System.out.println("4.Sửa Đơn Giá");
			System.out.println("0.Thoát chương trình");
			System.out.print("Lựa chọn của bạn: ");
			chon = scanner.nextInt();

			switch (chon) {
			case 1:
				System.out.println("Chọn Nhà Cung Cấp :");
				String providerCode = scanner.nextLine();
				// Kiểm Tra Mã Provider có hợp lệ không
				int index = CategoryController.findProviderByCode(providerCode);
				if (index == -1) {
					System.out.println("Nhà Cung Cấp Không Tồn Tại");
					return;
				}
				int category_Id = CategoryController.getProviders().get(index).getId();
				this.setCategory_Id(category_Id);
				System.out.println("Sửa Thành Công");
				break;
			case 2:
				System.out.print("Nhap ten Sản phẩm: ");
				String name = scanner.nextLine();
				if (name == null || name.isEmpty()) {
					System.out.println("Ten NCC khong duoc de trong");
					return;
				}
				this.setName(name);
				System.out.println("Sửa Tên Thành Công");
				break;
			case 3:
				System.out.println("Nhập Giá :");
				int price = Integer.parseInt(scanner.nextLine());
				if (price < 0) {
					System.out.println("Giá Không Âm");
					return;
				}
				this.setPrice(price);
				System.out.println("Sửa Giá Thành Công");
				break;
			case 0:
				System.out.println("Thoát chương trình.");
				return;
			default:
				System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
				break;
			}
		} while (true);
	}
	public void display() {
		String categoryName = CategoryController.getById(this.category_Id);
		System.out.printf("%3d %-20s %-10s %-30s %,15.2f%n", id, categoryName, code, name, price);
	}

}
