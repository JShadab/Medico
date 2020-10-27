package com.medico.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.medico.beans.Product;
import com.medico.db.DbConnection;

public class ProductDAO {

	public static boolean save(Product product) {

		String insertSQL = "INSERT INTO product (" + NAME + " , " + COMAPNY + ", " + CATEGORY + ", " + TYPE + ", "
				+ EXPIRY_DATE + ", " + DEALER + ", " + FORMULA + " , " + SYMTOMS + "," + COST_PRICE + ", " + SELL_PRICE
				+ ", " + SGST + ", " + CGST + ", " + DISCOUNT + ", " + POWER + ")"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection con = DbConnection.getConnection()) {

			PreparedStatement ps = con.prepareStatement(insertSQL);

			ps.setString(1, product.getName());
			ps.setString(2, product.getCompany());
			ps.setString(3, product.getCategory().toString());
			ps.setString(4, product.getType().toString());
			ps.setString(5, product.getExpiryDate());
			ps.setString(6, product.getDealer());
			ps.setString(7, product.getFormula());
			ps.setString(8, product.getSymptoms());
			ps.setDouble(9, product.getCostPrice());
			ps.setDouble(10, product.getSellingPrice());
			ps.setDouble(11, product.getSgst());
			ps.setDouble(12, product.getCgst());
			ps.setDouble(13, product.getDiscount());
			ps.setString(14, product.getPower());

			ps.executeUpdate();
			
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void update(Product product) {
		throw new UnsupportedOperationException("Update is not implemented yet...");
	}

	public static void delete(int productID) {
		throw new UnsupportedOperationException("Delete is not implemented yet...");
	}

	public static Product getOne(int productID) {
		throw new UnsupportedOperationException("this is not implemented yet...");
	}

	public static List<Product> getAll() {
		throw new UnsupportedOperationException("this is not implemented yet...");
	}

	private static final String NAME = "name";
	private static final String COMAPNY = "company";
	private static final String CATEGORY = "category";
	private static final String TYPE = "type";
	private static final String EXPIRY_DATE = "expiry_date";
	private static final String DEALER = "dealer";
	private static final String FORMULA = "formula";
	private static final String SYMTOMS = "symptoms";
	private static final String COST_PRICE = "cost_price";
	private static final String SELL_PRICE = "sell_price";
	private static final String SGST = "sgst";
	private static final String CGST = "cgst";
	private static final String DISCOUNT = "discount";
	private static final String POWER = "power";

}
