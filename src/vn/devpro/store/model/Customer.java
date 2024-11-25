package vn.devpro.store.model;

import java.util.Scanner;

public class Customer {
	private int id;
	private String code;
	private String name;
	private String mobile;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int id, String code, String name, String mobile) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.mobile = mobile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void display() {
		System.out.printf("%3d %-12s %-35s %-20s%n", this.id, this.code, this.name, this.mobile);
	}

	public void edit() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập Tên Khách Hàng : ");
		String name = sc.nextLine();
		if (name == null || name.isEmpty()) {
			System.out.println("Tên Khách Hàng Không Được Null");
			return;
		}
		System.out.print("Nhập Mobile Khách Hàng : ");
		String mobile = sc.nextLine();
		if (mobile == null || mobile.isEmpty()) {
			System.out.println("Tên Khách Hàng Không Được Null");
			return;
		}
		if (mobile.length() > 0 && mobile.length() < 10) {
			System.out.println("Sai Định Dạng Mobile Là 10 Số");
			return;
		}
		if (mobile.length() > 11) {
			System.out.println("Sai Định Dạng Mobile Là 10 Số");
			return;
		}
		this.setName(name);
		this.setMobile(mobile);
		System.out.println("Sửa Tên Khách Hàng Thành Công");
	}

}
