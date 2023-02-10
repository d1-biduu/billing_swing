package net.javaguides.swing;

public class BillingDAO {
private String productName;
private int productCode, quantity, productPrice, total;

public int getProductCode() {
	return productCode;
}
public void setProductCode(int productCode) {
	this.productCode = productCode;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getProductPrice() {
	return productPrice;
}
public void setProductPrice(int productPrice) {
	this.productPrice = productPrice;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
}
