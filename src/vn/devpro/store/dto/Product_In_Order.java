package vn.devpro.store.dto;

import java.util.ArrayList;

import vn.devpro.store.controller.backend.ProductController;
import vn.devpro.store.model.Product;

public class Product_In_Order {
	private int id;
	private int product_Id;
	private int order_Id;
	private int quantity;
	private ArrayList<Product_In_Order> product_In_Orders = new ArrayList<Product_In_Order>();
	

	public ArrayList<Product_In_Order> getProduct_In_Orders() {
		return product_In_Orders;
	}

	public void setProduct_In_Orders(ArrayList<Product_In_Order> product_In_Orders) {
		this.product_In_Orders = product_In_Orders;
	}

	public Product getProductById() {
		for (Product product : ProductController.getProducts()) {
			if (product.getId() == this.product_Id) {
				return product;
			}
		}
		return new Product();
	}

	public void display() {
		Product product = getProductById();
		System.out.printf("%-10s %-30s %8d %,15.2f %,15.2f%n",product.getCode(), product.getName(), this.quantity, product.getPrice(),
				this.quantity * product.getPrice());

	}
	
	public int totalProducts() {
		int total = 0;
		for (Product_In_Order productCart : this.product_In_Orders) {
			total += productCart.getQuantity();
		}
		return total;
	}
	public double totalPriceProducts() {
		double total = 0;
		for (Product_In_Order productCart : this.product_In_Orders) {
			total += productCart.getQuantity() * productCart.getProductById().getPrice();
		}
		return total;
	}
	
	public void displayDoanhThu() {
		Product product = getProductById();
		System.out.printf("%-10s %-30s %8d %,15.2f%n",product.getCode(), product.getName(),this.quantity,
				this.quantity * product.getPrice());

	}

	public Product_In_Order(int product_Id, int quantity) {
		super();
		this.product_Id = product_Id;
		this.quantity = quantity;
	}

	public Product_In_Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product_In_Order(int id, int product_Id, int order_Id, int quantity) {
		super();
		this.id = id;
		this.product_Id = product_Id;
		this.order_Id = order_Id;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProduct_Id() {
		return product_Id;
	}

	public void setProduct_Id(int product_Id) {
		this.product_Id = product_Id;
	}

	public int getOrder_Id() {
		return order_Id;
	}

	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
