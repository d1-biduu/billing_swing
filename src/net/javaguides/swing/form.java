package net.javaguides.swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;

public class form extends JFrame {
	public JPanel contentPane;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_4;
	public JTextField textField_5;
	public JTextField textField_6;
	public JTable table;
	Billing billing=new BillingImpl();
	public JTextField textField_7;
	public JTextArea txtbill;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					form frame = new form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1045, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 20, 761, 156);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ProductName");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(180, 20, 106, 27);
		panel.add(lblNewLabel);
		
		JLabel lblProductname = new JLabel("ProductCode");
		lblProductname.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductname.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblProductname.setBounds(37, 20, 106, 27);
		panel.add(lblProductname);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQuantity.setBounds(310, 20, 106, 27);
		panel.add(lblQuantity);
		
		JLabel lblProductprice = new JLabel("ProductPrice");
		lblProductprice.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductprice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblProductprice.setBounds(433, 20, 106, 27);
		panel.add(lblProductprice);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotal.setBounds(549, 20, 106, 27);
		panel.add(lblTotal);
		
		textField = new JTextField();
		textField.setBounds(33, 57, 121, 38);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(180, 57, 121, 38);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(433, 57, 121, 38);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(586, 57, 121, 38);
		panel.add(textField_3);
		
		JSpinner spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int price = Integer.parseInt(textField_2.getText());
				int quantity = Integer.parseInt(spinner.getValue().toString());
				int ttl = quantity*price;
				textField_3.setText(String.valueOf(ttl));
			}
		});
		spinner.setBounds(333, 57, 47, 38);
		panel.add(spinner);
		
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pcode = Integer.parseInt(textField.getText());
				String pname = textField_1.getText();
				int price = Integer.parseInt(textField_2.getText());
				int quantity = Integer.parseInt(spinner.getValue().toString());
				int ttl = quantity*price;
				textField_3.setText(String.valueOf(ttl));
					System.out.println(price);			
			Billing billing = new BillingImpl();
			BillingDAO billingformDAO = new BillingDAO();
			billingformDAO.setProductCode(pcode);
			billingformDAO.setProductName(pname);
			billingformDAO.setQuantity(quantity);
			billingformDAO.setProductPrice(price);
	        billingformDAO.setTotal(ttl);
			billing.saveProductinfo(billingformDAO);
			
			loadTableData();

			int sum = 0;
			for(int i=0; i<table.getRowCount();i++) {
				sum = sum + Integer.parseInt(table.getValueAt(i,4).toString());
			}	
			textField_4.setText(Integer.toString(sum));
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
spinner.setValue(0);
textField.requestFocus();
		
			
			
			
			
			
			}
		}			
		);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(586, 105, 121, 38);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Id");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_2.setBounds(706, 10, 45, 13);
		panel.add(lblNewLabel_2);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(781, 50, 240, 195);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTotal_1 = new JLabel("Total");
		lblTotal_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotal_1.setBounds(-17, 23, 106, 27);
		panel_1.add(lblTotal_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(79, 20, 121, 38);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(79, 116, 121, 38);
		panel_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(79, 68, 121, 38);
		panel_1.add(textField_6);
		
		JLabel lblTotal_1_1 = new JLabel("Pay");
		lblTotal_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotal_1_1.setBounds(-17, 68, 106, 27);
		panel_1.add(lblTotal_1_1);
		
		JLabel lblTotal_1_2 = new JLabel("Balance");
		lblTotal_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotal_1_2.setBounds(-17, 119, 106, 27);
		panel_1.add(lblTotal_1_2);
		
		JButton btnNewButton_4 = new JButton("Print Bill");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Balance();
				Bill();
			
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton_4.setBounds(40, 164, 164, 21);
		panel_1.add(btnNewButton_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 196, 700, 311);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		table = new JTable();
		table.setBounds(654, 212, -618, -179);
		String[] columnName = {"ProductCode","ProductName","Quantity","ProductPrice","Total"};
		DefaultTableModel tableModel = new DefaultTableModel(columnName,0);
		table.setModel(tableModel);
		loadTableData();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(25,47,665,211);
		panel_2.add(scrollPane);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(25, 280, 110, 21);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("EDIT");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel= (DefaultTableModel) table.getModel();
				int row= table.getSelectedRow();
				Object ProductCode=tableModel.getValueAt(row, 0);
				Object ProductName=tableModel.getValueAt(row, 1);
				Object ProductQuantity=tableModel.getValueAt(row, 2);
				Object ProductPrice=tableModel.getValueAt(row, 3);
				BillingForm blgForm =new  BillingForm();

			
			}
		});
		btnNewButton_2.setBounds(279, 280, 85, 21);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("DELETE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel= (DefaultTableModel) table.getModel();
				int row= table.getSelectedRow();
				Object ProductCode=tableModel.getValueAt(row, 0);
			int status=	JOptionPane.showConfirmDialog(form.this, "Click YES to Confirm","Do you really want to delete this data?", JOptionPane.YES_NO_OPTION);
			if(status==0) {
			billing.deleteProductData(Integer.parseInt(ProductCode.toString()));
			loadTableData();
			}
 			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.setBounds(575, 280, 101, 21);
		panel_2.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("SEARCH");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(557, 23, 63, 13);
		panel_2.add(lblNewLabel_1);
		
		textField_7 = new JTextField();
		textField_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			String searchName= textField_7.getText();
			if(searchName==null||searchName.isEmpty()) {
				loadTableData();
			}
			else {
				searchProductData(searchName);
			}
			
			}
		});
		textField_7.setBounds(605, 20, 85, 19);
		panel_2.add(textField_7);
		textField_7.setColumns(10);
		
	 txtbill = new JTextArea();
		txtbill.setBounds(709, 259, 312, 248);
		contentPane.add(txtbill);
		
		
		
		
	

	}
	public void loadTableData() {
		List<BillingDAO> pdctList= billing.getProducts();
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		for(BillingDAO pdct:pdctList) {
			tableModel.addRow(new Object[] {
					pdct.getProductCode(), pdct.getProductName(), pdct.getQuantity(),pdct.getProductPrice(),pdct.getTotal()
			});
		}
	}
	
	public void Balance() {
		int total = Integer.parseInt(textField_4.getText());
		int pay = Integer.parseInt(textField_6.getText().toString());
		int bal = pay-total;
		textField_5.setText(String.valueOf(bal));
	}
	
public void Bill() {
	 String total = textField_4.getText();
     String pay = textField_6.getText();
     String bal = textField_5.getText();
     
      DefaultTableModel model = new DefaultTableModel();
    
    model = (DefaultTableModel)table.getModel();
    
     
     txtbill.setText(txtbill.getText() + "******************************************************\n");
     txtbill.setText(txtbill.getText() + "           CASH RECEIPT                                 \n");
     txtbill.setText(txtbill.getText() + "*******************************************************\n");
     
     
     
     
     for(int i = 0; i < model.getRowCount(); i++)
     {
         
         String name = (String)model.getValueAt(i, 1);
         int price = (int)model.getValueAt(i, 3);
         int amount = (int)model.getValueAt(i, 4);
         
      txtbill.setText(txtbill.getText() + name  + "\t" + price + "\t" + amount  + "\n"  );

     }
     
     txtbill.setText(txtbill.getText() + "\n");    
     
     txtbill.setText(txtbill.getText() + "\t" + "\t" + "Subtotal :" + total + "\n");
     txtbill.setText(txtbill.getText() + "\t" + "\t" + "Pay :" + pay + "\n");
     txtbill.setText(txtbill.getText() + "\t" + "\t" + "Balance :" + bal + "\n");
     txtbill.setText(txtbill.getText() + "\n");
     txtbill.setText(txtbill.getText() + "*******************************************************\n");
     txtbill.setText(txtbill.getText() + "           THANK YOU FOR USING OUR SERVICES            \n");




     
}
	
	
	
	
		
		
		
		
		
		
		

	
	
	public void searchProductData(String ProductName) {
		List<BillingDAO> pdctList= billing.searchProducts(ProductName);
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		for(BillingDAO pdct:pdctList) {
			tableModel.addRow(new Object[] {
					pdct.getProductCode(), pdct.getProductName(), pdct.getQuantity(),pdct.getProductPrice(),pdct.getTotal()
			});
		}
	}
}


	/**
	 * Create the frame.
	 */
	