package net.javaguides.swing;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillingImpl implements Billing{
	PreparedStatement ps=null;
	@Override
	public void saveProductinfo(BillingDAO billingformDAO) {
			String sql="INSERT INTO product(ID,ProductName,Quantity,ProductPrice,Total) VALUES (?,?,?,?,?)";
			try {
				ps=DatabaseConnectivity.getConnection().prepareStatement(sql);
				ps.setInt(1, billingformDAO.getProductCode());
				ps.setString(2,billingformDAO.getProductName());
				ps.setInt(3,billingformDAO.getQuantity());
				ps.setInt(4,billingformDAO.getProductPrice());
				ps.setInt(5, billingformDAO.getTotal());
				
				System.out.println(billingformDAO.getProductCode());
				
		
////				
//		
//				ps.setInt(1, 1);
//				ps.setString(2,"waiwai");
//				ps.setInt(3,1);
//				ps.setInt(4,20);
//			ps.setInt(5, 100);
////				
				ps.executeUpdate();
			}	catch(ClassNotFoundException| SQLException e) {
				e.printStackTrace();
			}
		
	}
	@Override
	public List<BillingDAO> getProducts() {
		List<BillingDAO> productList= new ArrayList<>();
		String sql="SELECT * FROM product";
		
		try {
			
			ps= DatabaseConnectivity.getConnection().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				BillingDAO billing= new BillingDAO();
				billing.setProductCode(rs.getInt("ID"));
				billing.setProductName(rs.getString("ProductName"));
				billing.setQuantity(rs.getInt("Quantity"));
				billing.setProductPrice(rs.getInt("ProductPrice"));
				billing.setTotal(rs.getInt("Total"));
				productList.add(billing);
				
			}
			
			
			
		}
		catch(ClassNotFoundException| SQLException e) {
			e.printStackTrace();
		}
	
		return productList;
	}
	@Override
	public void deleteProductData(int ProductCode) {
		String sql= "DELETE from product WHERE ID=?";
		try {
			ps= DatabaseConnectivity.getConnection().prepareStatement(sql);
			ps.setInt(1, ProductCode);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	@Override
	public List<BillingDAO> searchProducts(String ProductName) {
		List<BillingDAO> productList= new ArrayList<>();
String sql= "SELECT * FROM product WHERE ProductName LIKE ?";
try {
	ps= DatabaseConnectivity.getConnection().prepareStatement(sql);
	ps.setString(1, "%"+ ProductName +"%");
	ResultSet rs=ps.executeQuery();
	while(rs.next()) {
		BillingDAO billing= new BillingDAO();
		billing.setProductCode(rs.getInt("ID"));
		billing.setProductName(rs.getString("ProductName"));
		billing.setQuantity(rs.getInt("Quantity"));
		billing.setProductPrice(rs.getInt("ProductPrice"));
		billing.setTotal(rs.getInt("Total"));
		productList.add(billing);
		
	}
	
 

} catch (ClassNotFoundException e) {
	
	e.printStackTrace();
} catch (SQLException e) {
	
	e.printStackTrace();
}

		return productList;
	}
	@Override
	public void updateProductInfo(BillingDAO billingFormDAO) {
		String sql="UPDATE product SET ProductCode=?,ProductName=?,Quantity=?,ProductPrice=?,Total=? WHERE ProductCode=?)";
		try {
			ps=DatabaseConnectivity.getConnection().prepareStatement(sql);
			ps.setInt(1, billingFormDAO.getProductCode());
			ps.setString(2,billingFormDAO.getProductName());
			ps.setInt(3,billingFormDAO.getQuantity());
			ps.setInt(4,billingFormDAO.getProductPrice());
			ps.setInt(5, billingFormDAO.getTotal());
			
	
	

		
			ps.executeUpdate();
		}	catch(ClassNotFoundException| SQLException e) {
			e.printStackTrace();
		}
	
}

		
	}
		
	



