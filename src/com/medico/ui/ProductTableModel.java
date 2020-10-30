package com.medico.ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.medico.beans.Product;
import com.medico.db.dao.ProductDAO;
import com.medico.enums.Category;
import com.medico.enums.ProductType;

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
	public boolean isCellEditable(int rowIndex, int columnIndex) {

		return true;
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

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

		Product product = products.get(rowIndex);

		switch (columnIndex) {

		case 1: {
			String name = (String) aValue;
			product.setName(name);
			break;
		}
		case 2: {
			String company = (String) aValue;
			product.setCompany(company);
			break;
		}

		case 3: {
			String category = (String) aValue;
			product.setCategory(Category.getEnum(category));
			break;
		}
		case 4: {
			String type = (String) aValue;

			product.setType(ProductType.getEnum(type));
			break;
		}

		case 5: {
			String expiryDate = (String) aValue;
			product.setExpiryDate(expiryDate);
			;
			break;
		}
		case 6: {
			String dealer = (String) aValue;
			product.setDealer(dealer);
			;
			break;
		}
		case 7: {
			String formula = (String) aValue;
			product.setFormula(formula);
			;
			break;
		}
		case 8: {
			String symptoms = (String) aValue;
			product.setSymptoms(symptoms);
			;
			break;
		}
		case 9: {
			double costPrice = Double.valueOf((String) aValue);
			product.setCostPrice(costPrice);
			break;
		}

		case 10: {
			double sellPrice = Double.valueOf((String) aValue);
			product.setSellingPrice(sellPrice);
			break;
		}
		case 11: {
			double sgst = Double.valueOf((String) aValue);
			product.setSgst(sgst);
			break;
		}

		case 12: {
			double cgst = Double.valueOf((String) aValue);
			product.setCgst(cgst);
			break;
		}
		case 13: {
			double discount = Double.valueOf((String) aValue);
			product.setDiscount(discount);
			break;
		}
		case 14: {
			String power = (String) aValue;
			product.setPower(power);
			break;
		}

		}
	}
	
	public void updateToDB() {		
		ProductDAO.updateAll(products);
	}
}
