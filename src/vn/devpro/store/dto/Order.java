package vn.devpro.store.dto;

import java.util.ArrayList;

public class Order {
	private int id;
	private int customer_id;
	private String code;
	private double total;

	private ArrayList<Product_In_Order> product_In_Orders = new ArrayList<Product_In_Order>();
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public ArrayList<Product_In_Order> getProduct_In_Orders() {
		return product_In_Orders;
	}



	public void setProduct_In_Orders(ArrayList<Product_In_Order> product_In_Orders) {
		this.product_In_Orders = product_In_Orders;
	}



	public Order(int id, int customer_id, String code, double total) {
		super();
		this.id = id;
		this.customer_id = customer_id;
		this.code = code;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
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

	public int findById(int productId) {
		for (int index = 0; index < product_In_Orders.size(); index++) {
			if (product_In_Orders.get(index).getProduct_Id() == productId) {
				return index;
			}
		}
		return -1;
	}

}
