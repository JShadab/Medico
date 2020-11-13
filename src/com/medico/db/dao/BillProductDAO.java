package com.medico.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.medico.beans.SellProduct;
import com.medico.db.DbConnection;

public class BillProductDAO {

	public static boolean save(SellProduct product) {

		String insertSQL = "INSERT INTO bill_product (" + CUST_NAME + ", " + PHONE + ", " + NAME + ", " + COMAPNY + ", "
				+ UNITS + ", " + SELL_PRICE + ", " + SGST + ", " + CGST + ", " + DISCOUNT + ", " + AMOUNT + ")"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?)";

		try (Connection con = DbConnection.getConnection()) {

			PreparedStatement ps = con.prepareStatement(insertSQL);

			ps.setString(1, product.getCustomerName());
			ps.setString(2, product.getCustomerPhone());
			ps.setString(3, product.getName());
			ps.setString(4, product.getCompany());
			ps.setInt(5, product.getUnits());

			ps.setDouble(6, product.getSellingPrice());
			ps.setDouble(7, product.getSgst());
			ps.setDouble(8, product.getCgst());
			ps.setDouble(9, product.getDiscount());
			ps.setDouble(10, product.getAmount());

			ps.executeUpdate();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static final String ID = "id";
	public static final String CUST_NAME = "customer_name";
	public static final String PHONE = "phone";
	public static final String NAME = "name";
	public static final String COMAPNY = "company";
	public static final String SELL_PRICE = "sell_price";
	public static final String SGST = "sgst";
	public static final String CGST = "cgst";
	public static final String DISCOUNT = "discount";
	public static final String AMOUNT = "amount";
	public static final String UNITS = "units";

}
