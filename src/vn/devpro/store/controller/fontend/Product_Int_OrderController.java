package vn.devpro.store.controller.fontend;

import java.util.Scanner;

import vn.devpro.store.controller.backend.CustomerController;
import vn.devpro.store.controller.backend.ProductController;
import vn.devpro.store.dto.Order;
import vn.devpro.store.dto.Product_In_Order;
import vn.devpro.store.model.Customer;
import vn.devpro.store.model.Product;

public class Product_Int_OrderController {
	static Order order = new Order();
	static Scanner sc = new Scanner(System.in);

	public static void menu() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\n\t\tCHUC NANG DANH CHO KHACH HANG");
			System.out.println("Chon mot chuc nang cap nhat");
			System.out.println("\t1.Xem danh sách Sản phảm");
			System.out.println("\t2. Thêm Vào Giỏ Hàng");
			System.out.println("\t3. Xóa Vào Giỏ Hàng");
			System.out.println("\t4. Sửa Số Lượng Vào Giỏ Hàng");
			System.out.println("\t5. Đặt Hàng Và Lưu Hóa Đơn");
			System.out.println("\t0. Quay lai");

			System.out.print("Lua chon cua ban?: ");
			int choose = Integer.parseInt(sc.nextLine());

			switch (choose) {
			case 1:
				display(order);
				break;
			case 2:
				addToCart(order);
				break;
			case 3:
				remove(order);
				break;
			case 4:
				edit(order);
				break;
			case 5:
				order(order);
				order = new Order();
				System.out.println("Đặt Hàng Và Lưu Hóa Đơn Thành Công !");
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le");
			}
		} while (true);

	}

	private static void order(Order order) {
		System.out.println("\n\t\tDat Hang");
		System.out.println("Nhập Mã Khách Hàng :");
		String code = sc.nextLine();
		int customerindex = CustomerController.findProviderByCode(code);
		if (customerindex != -1) {
			order.setCustomer_id(customerindex);
		} else {
			String name;
			String mobile;
			do {
				System.out.println("Nhập Tên Khách Hàng :");
				name = sc.nextLine();
				if (name == null || name.isEmpty()) {
					System.out.println("Tên Khách Hàng Không Được Bỏ Trống");
					return;
				}
				System.out.println("Nhập Mobile Khách Hàng :");
				mobile = sc.nextLine();
				if (mobile == null || mobile.isEmpty()) {
					System.out.println("Mobile Khách Hàng Không Được Bỏ Trống");
					return;
				}
			} while (name == null || name.isEmpty());
			int cusId = CustomerController.getAutoId();
			Customer customer = new Customer(CustomerController.getAutoId(), "1000" + CustomerController.getAutoId(),
					name, mobile);
			CustomerController.setAutoId(cusId + 1);
			CustomerController.getCustomers().add(customer);
			order.setCustomer_id(cusId);
			System.out.println("Thêm Khách Hàng Thành Công!");
		}
		display(order);
		OrderController.getOrder().add(order);
	}

	private static void edit(Order order) {
		System.out.println("\n\t\tSửa Giỏ Hàng");
		System.out.print("Chọn Mã SP:");
		String code = sc.nextLine();

		int index = ProductController.findProductByCode(code);
		if (index == -1) {
			System.out.println("Mã Sản Phẩm Không Tồn Tại");
			return;
		}
		int product_id = ProductController.getProducts().get(index).getId();

		int orderIndex = order.findById(product_id);
		if (orderIndex == -1) {
			System.out.println("Sản phẩm Không Có Trong Giỏ Hàng");
			return;
		}
		System.out.print("Nhập Số Lượng Cần Mua : ");
		int quantity = Integer.parseInt(sc.nextLine());
		if (quantity <= 0) {
			System.out.println("Số Lượng Không Hợp Lệ");
			return;
		}
		order.getProduct_In_Orders().get(orderIndex).setQuantity(quantity);
		System.out.println("Sửa Thành Công");
	}

	private static void remove(Order order) {
		System.out.println("\n\t\tXóa Giỏ Hàng Cần Xóa");
		System.out.print("Chọn Mã SP:");
		String code = sc.nextLine();

		int index = ProductController.findProductByCode(code);
		if (index == -1) {
			System.out.println("Mã Sản Phẩm Không Tồn Tại");
			return;
		}
		int product_id = ProductController.getProducts().get(index).getId();
		int orderIndex = order.findById(product_id);
		if (orderIndex == -1) {
			System.out.println("Sản phẩm Khỗng Có Trong Giỏ Hàng");
			return;
		}
		order.getProduct_In_Orders().remove(orderIndex);
		System.out.println("Xóa Sản Phẩm Thành Công");
	}

	private static void addToCart(Order order) {
		System.out.println("\n\t\tThêm Vào Giỏ Hàng");
		System.out.print("Chọn mã SP:");
		String code = sc.nextLine();

		int index = ProductController.findProductByCode(code);
		if (index == -1) {
			System.out.println("Mã Sản Phẩm Không Tồn Tại");
			return;
		}
		System.out.print("Nhập Số Lượng Cần Mua : ");
		int quantity = Integer.parseInt(sc.nextLine());
		if (quantity <= 0) {
			System.out.println("Số Lượng Không Hợp Lệ");
			return;
		}

		int productId = ProductController.getProducts().get(index).getId();
		int orderIndex = order.findById(productId);
		if (orderIndex == -1) {
			order.getProduct_In_Orders().add(new Product_In_Order(productId, quantity));
		} else {
			order.getProduct_In_Orders().get(orderIndex)
					.setQuantity(quantity + order.getProduct_In_Orders().get(orderIndex).getQuantity());
		}
		System.out.println("Thêm Sản Phẩm Vào Giở Hàng Thành Công");
	}

	public static void display(Order order) {
		System.out.println("\n\t\tGiỏ Hàng Của Bạn");

		String customerName = CustomerController.getNameById(order.getCustomer_id());
		System.out.println("\tKhách Hàng: " + customerName);
		if (order.totalProducts() <= 0) {
			System.out.println("Giở Hàng Chưa Có Sản Phẩm Nào");
			return;
		}
		String mobile = CustomerController.getCustomers().get(0).getMobile();
		System.out.println("\tMobile Khách Hàng : " + mobile);
		System.out.println("\tTổng Số Sản Phẩm :" + order.totalProducts());

		System.out.println("Danh Sách Sản Phẩm");
		System.out.printf("%-10s %-30s %-8s %-15s %-15.2s%n", "Mã SP", "Tên Sản Phẩm", "Số Lượng", "Đơn giá",
				"Thành Tiền");
		for (Product_In_Order product_In_Order : order.getProduct_In_Orders()) {
			product_In_Order.display();
		}
		System.out.printf("\tTong Thành Tiền : %,15.2f%n", order.totalPriceProducts());

	}

	public static void displayKH(Order order) {
		System.out.println("\n\t\tDoanh Thu Theo Từng Khách Hàng");

		String customerName = CustomerController.getNameById(order.getCustomer_id());
		System.out.println("\tKhách Hàng: " + customerName);
		if (order.totalProducts() <= 0) {
			System.out.println("Giở Hàng Chưa Có Sản Phẩm Nào");
			return;
		}
		String mobile = CustomerController.getCustomers().get(0).getMobile();
		System.out.println("\tMobile Khách Hàng : " + mobile);
		System.out.println("\tTổng Số Sản Phẩm :" + order.totalProducts());
		System.out.printf("\tTổng Tiền Thu Được Của Khách :  %,15.2f%n", order.totalPriceProducts());

	}

	public static void displayDonHang(Order order) {
		System.out.println("\n\t\tDanh Sách Đơn Hàng Đã Bán");
		System.out.println("Danh Sách Sản Phẩm");
		System.out.printf("%-5s %-30s %-20s %-15s%n", "STT", "Tên sản phẩm", "Đã Bán", "Doanh thu");

		int index = 1;
		for (Product_In_Order product_In_Order : order.getProduct_In_Orders()) {
			System.out.printf("%-5d %-30s %-20d %,15.2f%n", index, product_In_Order.getProductById().getName(),
					order.totalProducts(), order.totalPriceProducts());
			index++;
		}
	}
}
