package com.medico.ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.medico.beans.Product;
import com.medico.db.dao.ProductDAO;

public class ProductTableModel extends AbstractTableModel {

	private List<Product> products;

	private String[] columns = { "ID", "NAME", "COMAPNY", "CATEGORY", "TYPE", "EXPIRY_DATE", "DEALER", "FORMULA",
			"SYMTOMS", "COST_PRICE", "SELL_PRICE", "SGST", "CGST", "DISCOUNT", "POWER" };

	public ProductTableModel() {
		products = ProductDAO.getAll();
	}

	@Override
	public int getRowCount() {
		return products.size();
	}

	@Override
	public int getColumnCount() {

		return columns.length;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		
		return columns[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Product product = products.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return product.getId();
		case 1:
			return product.getName();
		case 2:
			return product.getCompany();
		case 3:
			return product.getCategory();
		case 4:
			return product.getType();
		case 5:
			return product.getExpiryDate();
		case 6:
			return product.getDealer();
		case 7:
			return product.getFormula();
		case 8:
			return product.getSymptoms();
		case 9:
			return product.getCostPrice();
		case 10:
			return product.getSellingPrice();
		case 11:
			return product.getSgst();
		case 12:
			return product.getCgst();
		case 13:
			return product.getDiscount();
		case 14:
			return product.getPower();
		default:
			return "";

		}
	}
}
