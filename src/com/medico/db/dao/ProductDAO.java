package com.medico.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.medico.beans.Product;
import com.medico.db.DbConnection;
import com.medico.enums.Category;
import com.medico.enums.ProductType;

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

		String updateSQL = "UPDATE product SET name=?, company=?, category=?, type=?, expiry_date=?, dealer=?, formula=?, symptoms=?, cost_price=?, sell_price=?, sgst=?, cgst=?, discount=?, power=?  WHERE id=?";

		try (Connection con = DbConnection.getConnection()) {

			PreparedStatement ps = con.prepareStatement(updateSQL);

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
			ps.setInt(15, product.getId());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void delete(int productID) {
		throw new UnsupportedOperationException("Delete is not implemented yet...");
	}

	public static Product getOne(int productID) {
		throw new UnsupportedOperationException("this is not implemented yet...");
	}

	public static List<Product> getAll() {

		List<Product> products = new ArrayList<Product>();

		try (Connection conn = DbConnection.getConnection()) {

			String selectSQL = "SELECT * FROM product";

			PreparedStatement ps = conn.prepareStatement(selectSQL);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int id = rs.getInt(ID);
				String name = rs.getString(NAME);
				String company = rs.getString(COMAPNY);
				Category category = Category.getEnum(rs.getString(CATEGORY));
				ProductType type = ProductType.getEnum(rs.getString(TYPE));
				String expiryDate = rs.getString(EXPIRY_DATE);
				String dealer = rs.getString(DEALER);
				String formula = rs.getString(FORMULA);
				String symptoms = rs.getString(SYMTOMS);
				double cPrice = rs.getDouble(COST_PRICE);
				double sPrice = rs.getDouble(SELL_PRICE);
				double sgst = rs.getDouble(SGST);
				double discount = rs.getDouble(DISCOUNT);
				String power = rs.getString(POWER);
				double cgst = rs.getDouble(CGST);

				Product product = new Product();

				product.setId(id);
				product.setCategory(category);
				product.setCgst(cgst);
				product.setCompany(company);
				product.setCostPrice(cPrice);
				product.setDealer(dealer);
				product.setDiscount(discount);
				product.setExpiryDate(expiryDate);
				product.setFormula(formula);
				product.setName(name);
				product.setPower(power);
				product.setSellingPrice(sPrice);
				product.setSgst(sgst);
				product.setSymptoms(symptoms);
				product.setType(type);

				products.add(product);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return products;
	}

	public static void updateAll(List<Product> products) {

		for (Product prod : products) {
			update(prod);
		}

	}

	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String COMAPNY = "company";
	public static final String CATEGORY = "category";
	public static final String TYPE = "type";
	public static final String EXPIRY_DATE = "expiry_date";
	public static final String DEALER = "dealer";
	public static final String FORMULA = "formula";
	public static final String SYMTOMS = "symptoms";
	public static final String COST_PRICE = "cost_price";
	public static final String SELL_PRICE = "sell_price";
	public static final String SGST = "sgst";
	public static final String CGST = "cgst";
	public static final String DISCOUNT = "discount";
	public static final String POWER = "power";

}
