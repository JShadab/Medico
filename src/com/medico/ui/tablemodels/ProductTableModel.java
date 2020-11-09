package com.medico.ui.tablemodels;

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

	public ProductTableModel(List<Product> products) {
		this.products = products;
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
		case COL_ID:
			return product.getId();
		case COL_NAME:
			return product.getName();
		case COL_COMAPNY:
			return product.getCompany();
		case COL_CATEGORY:
			return product.getCategory();
		case COL_TYPE:
			return product.getType();
		case COL_EXPIRY_DATE:
			return product.getExpiryDate();
		case COL_DEALER:
			return product.getDealer();
		case COL_FORMULA:
			return product.getFormula();
		case COL_SYMTOMS:
			return product.getSymptoms();
		case COL_COST_PRICE:
			return product.getCostPrice();
		case COL_SELL_PRICE:
			return product.getSellingPrice();
		case COL_SGST:
			return product.getSgst();
		case COL_CGST:
			return product.getCgst();
		case COL_DISCOUNT:
			return product.getDiscount();
		case COL_POWER:
			return product.getPower();
		default:
			return "";

		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

		Product product = products.get(rowIndex);

		switch (columnIndex) {

		case COL_NAME: {
			String name = (String) aValue;
			product.setName(name);
			break;
		}
		case COL_COMAPNY: {
			String company = (String) aValue;
			product.setCompany(company);
			break;
		}
		case COL_CATEGORY: {
			String category = (String) aValue;
			product.setCategory(Category.getEnum(category));
			break;
		}
		case COL_TYPE: {
			String type = (String) aValue;

			product.setType(ProductType.getEnum(type));
			break;
		}

		case COL_EXPIRY_DATE: {
			String expiryDate = (String) aValue;
			product.setExpiryDate(expiryDate);
			;
			break;
		}
		case COL_DEALER: {
			String dealer = (String) aValue;
			product.setDealer(dealer);

			break;
		}
		case COL_FORMULA: {
			String formula = (String) aValue;
			product.setFormula(formula);

			break;
		}
		case COL_SYMTOMS: {
			String symptoms = (String) aValue;
			product.setSymptoms(symptoms);

			break;
		}
		case COL_COST_PRICE: {
			double costPrice = Double.valueOf((String) aValue);
			product.setCostPrice(costPrice);
			break;
		}

		case COL_SELL_PRICE: {
			double sellPrice = Double.valueOf((String) aValue);
			product.setSellingPrice(sellPrice);
			break;
		}
		case COL_SGST: {
			double sgst = Double.valueOf((String) aValue);
			product.setSgst(sgst);
			break;
		}

		case COL_CGST: {
			double cgst = Double.valueOf((String) aValue);
			product.setCgst(cgst);
			break;
		}
		case COL_DISCOUNT: {
			double discount = Double.valueOf((String) aValue);
			product.setDiscount(discount);
			break;
		}
		case COL_POWER: {
			String power = (String) aValue;
			product.setPower(power);
			break;
		}

		}
	}

	public void updateToDB() {
		ProductDAO.updateAll(products);
	}

	public void deleteFromDB(int selectedRowIndex) {

		Product removedProduct = products.remove(selectedRowIndex);

		ProductDAO.delete(removedProduct.getId());

		fireTableDataChanged();

	}

	public static final int COL_ID = 0;
	public static final int COL_NAME = 1;
	public static final int COL_COMAPNY = 2;
	public static final int COL_CATEGORY = 3;
	public static final int COL_TYPE = 4;
	public static final int COL_EXPIRY_DATE = 5;
	public static final int COL_DEALER = 6;
	public static final int COL_FORMULA = 7;
	public static final int COL_SYMTOMS = 8;
	public static final int COL_COST_PRICE = 9;
	public static final int COL_SELL_PRICE = 10;
	public static final int COL_SGST = 11;
	public static final int COL_CGST = 12;
	public static final int COL_DISCOUNT = 13;
	public static final int COL_POWER = 14;
	public static final int COL_SELECT = 15;

}
