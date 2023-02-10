package net.javaguides.swing;

import java.util.List;

public interface Billing {
	public void saveProductinfo(BillingDAO billingformDAO);
	public List<BillingDAO> getProducts();
	public void deleteProductData(int ID);
	public List<BillingDAO> searchProducts(String ProductName);
     public void updateProductInfo(BillingDAO billingFormDAO);
  
//	
     
}
