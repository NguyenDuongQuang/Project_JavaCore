package vn.devpro.store.model;

import java.util.Scanner;

public class Category {
	private int id;
	private String code;
	private String name;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int id, String code, String name) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
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

	public void display() {
		System.out.printf("%3d %-12s %-35s%n", this.id, this.code, this.name);
	}

	public void edit() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập tên Category : ");
		String name = sc.nextLine();
		if (name == null || name.isEmpty()) {
			System.out.println("Tên Category Không Được Null");
			return;
		}
		this.setName(name);
		System.out.println("Sửa Category Thành Công !");
	}
}
