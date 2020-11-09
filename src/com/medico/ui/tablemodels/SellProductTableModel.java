package com.medico.ui.tablemodels;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;

import com.medico.beans.SellProduct;

public class SellProductTableModel extends AbstractTableModel {

	private List<SellProduct> products;

	private String[] columns = { "NAME", "COMAPNY", "UNITS", "SELL_PRICE", "SGST", "CGST", "DISCOUNT", "AMOUNT" };

	private JLabel lbGrandTotal;

	public SellProductTableModel(List<SellProduct> products, JLabel lbGrandTotal) {
		this.products = products;
		this.lbGrandTotal = lbGrandTotal;
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

		SellProduct product = products.get(rowIndex);

		switch (columnIndex) {

		case COL_NAME:
			return product.getName();
		case COL_COMAPNY:
			return product.getCompany();
		case COL_UNITS:
			return product.getUnits();

		case COL_SELL_PRICE:
			return product.getSellingPrice();
		case COL_SGST:
			return product.getSgst();
		case COL_CGST:
			return product.getCgst();
		case COL_DISCOUNT:
			return product.getDiscount();
		case COL_AMOUNT: {
			updateAmount(product);
			return product.getAmount();
		}

		default:
			return "";

		}
	}

	private double updateAmount(SellProduct product) {

		double amt = product.getSellingPrice() * product.getUnits();
		double tax = ((product.getCgst() + product.getSgst()) * amt) / 100;
		double discount = (amt * product.getDiscount()) / 100;

		double finalAmount = amt + tax - discount;

		product.setAmount(finalAmount);

		updateGrandTotalAmount();

		return finalAmount;
	}

	private double updateGrandTotalAmount() {

		double total = 0;

		for (SellProduct product : products) {

			total += product.getAmount();
		}

		lbGrandTotal.setText("Rs " + total);

		return total;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

		SellProduct product = products.get(rowIndex);

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
		case COL_UNITS: {
			int units = Integer.parseInt((String) aValue);
			product.setUnits(units);

			updateAmount(product);
			fireTableDataChanged();
			break;
		}

		case COL_SELL_PRICE: {
			double sellPrice = Double.valueOf((String) aValue);
			product.setSellingPrice(sellPrice);

			updateAmount(product);
			fireTableDataChanged();
			break;
		}
		case COL_SGST: {
			double sgst = Double.valueOf((String) aValue);
			product.setSgst(sgst);

			updateAmount(product);
			fireTableDataChanged();
			break;
		}

		case COL_CGST: {
			double cgst = Double.valueOf((String) aValue);
			product.setCgst(cgst);

			updateAmount(product);
			fireTableDataChanged();
			break;
		}
		case COL_DISCOUNT: {
			double discount = Double.valueOf((String) aValue);
			product.setDiscount(discount);

			updateAmount(product);
			fireTableDataChanged();
			break;
		}

//		case COL_AMOUNT: {
//			double discount = Double.valueOf((String) aValue);
//			product.setDiscount(discount);
//			break;
//		}

		}
	}

	public void addProduct(SellProduct sellProduct) {

		products.add(sellProduct);
		fireTableDataChanged();
	}

	public static final int COL_NAME = 0;
	public static final int COL_COMAPNY = 1;
	public static final int COL_UNITS = 2;
	public static final int COL_SELL_PRICE = 3;
	public static final int COL_SGST = 4;
	public static final int COL_CGST = 5;
	public static final int COL_DISCOUNT = 6;
	public static final int COL_AMOUNT = 7;

}
