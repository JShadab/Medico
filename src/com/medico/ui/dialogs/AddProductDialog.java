package com.medico.ui.dialogs;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.medico.beans.Product;
import com.medico.db.dao.ProductDAO;
import com.medico.enums.Category;
import com.medico.enums.ProductType;
import com.medico.ui.HomeFrame;

public class AddProductDialog extends JDialog {

	public AddProductDialog(JFrame frame) {
		super(frame);

		setTitle("All Products");

		Container con = this.getContentPane();

		con.add(getCenterPanel());
		con.add(getButtonPanel(), BorderLayout.SOUTH);

		setSize(500, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private Component getButtonPanel() {
		JPanel panel = new JPanel();

		JButton btnSave = new JButton("Save");
		JButton btnClose = new JButton("Close");

		btnSave.addActionListener(e -> {

			String name = txtName.getText();
			String company = txtCompany.getText();
			Category category = (Category) cmbCategory.getSelectedItem();
			ProductType type = (ProductType) cmbType.getSelectedItem();
			String expiryDate = txtExpiryDate.getText();
			String dealer = txtDealer.getText();
			String formula = txtFormula.getText();
			String symptoms = txtSymptoms.getText();
			double cPrice = Double.parseDouble(txtCostPrice.getText());
			double sPrice = Double.parseDouble(txtSellingPrice.getText());
			double sgst = Double.parseDouble(txtsgst.getText());
			double discount = Double.parseDouble(txtDiscount.getText());
			String power = txtPower.getText();
			double cgst = Double.parseDouble(txtCgst.getText());

			// TODO Validation code

			Product product = new Product();

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

			boolean isOK = ProductDAO.save(product);

			if (isOK) {
				JOptionPane.showMessageDialog(AddProductDialog.this, "Stock added successfully.");
			} else {
				JOptionPane.showMessageDialog(AddProductDialog.this, "Stock not added successfully.");
			}

		});
		btnClose.addActionListener(e -> {
		});

		panel.add(btnSave);
		panel.add(btnClose);

		return panel;
	}

	private Component getCenterPanel() {

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		/*--------------------------------First Row----------------------------------------*/

		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel lbName = new JLabel("Name");
		panel.add(lbName, gbc);
		gbc.gridx = 1;
		txtName = new JTextField(15);
		panel.add(txtName, gbc);

		gbc.gridx = 2;
		JLabel lbCompany = new JLabel("Company");
		panel.add(lbCompany, gbc);
		gbc.gridx = 3;
		txtCompany = new JTextField(15);
		panel.add(txtCompany, gbc);

		/*--------------------------------Second Row----------------------------------------*/
		gbc.gridx = 0;
		gbc.gridy = 1;
		JLabel lbCategory = new JLabel("Category");
		panel.add(lbCategory, gbc);

		gbc.gridx = 1;
		cmbCategory = new JComboBox<Category>(Category.values());

		panel.add(cmbCategory, gbc);

		gbc.gridx = 2;
		JLabel lbType = new JLabel("Type");
		panel.add(lbType, gbc);

		gbc.gridx = 3;
		cmbType = new JComboBox<ProductType>(ProductType.values());
		panel.add(cmbType, gbc);

		/*--------------------------------Third Row----------------------------------------*/
		gbc.gridx = 0;
		gbc.gridy = 2;
		JLabel lbExpiryDate = new JLabel("Expiry Date(dd/MM/YYYY)");
		panel.add(lbExpiryDate, gbc);

		gbc.gridx = 1;
		txtExpiryDate = new JTextField(15);
		panel.add(txtExpiryDate, gbc);

		gbc.gridx = 2;
		JLabel lbDealer = new JLabel("Dealer");
		panel.add(lbDealer, gbc);

		gbc.gridx = 3;
		txtDealer = new JTextField(15);
		panel.add(txtDealer, gbc);

		/*--------------------------------Fourth Row----------------------------------------*/
		gbc.gridx = 0;
		gbc.gridy = 3;
		JLabel lbFormula = new JLabel("Formula");
		panel.add(lbFormula, gbc);

		gbc.gridx = 1;
		txtFormula = new JTextField(15);
		panel.add(txtFormula, gbc);

		gbc.gridx = 2;
		JLabel lbSymptoms = new JLabel("Symtoms");
		panel.add(lbSymptoms, gbc);

		gbc.gridx = 3;
		txtSymptoms = new JTextField(15);
		panel.add(txtSymptoms, gbc);

		/*--------------------------------Fifth Row----------------------------------------*/
		gbc.gridx = 0;
		gbc.gridy = 4;
		JLabel lbCostPrice = new JLabel("Cost Price");
		panel.add(lbCostPrice, gbc);

		gbc.gridx = 1;
		txtCostPrice = new JTextField(15);
		panel.add(txtCostPrice, gbc);

		gbc.gridx = 2;
		JLabel lbSellingPrice = new JLabel("Selling Price");
		panel.add(lbSellingPrice, gbc);

		gbc.gridx = 3;
		txtSellingPrice = new JTextField(15);
		panel.add(txtSellingPrice, gbc);

		/*--------------------------------Sixth Row----------------------------------------*/
		gbc.gridx = 0;
		gbc.gridy = 5;

		JLabel lbsgst = new JLabel("SGST");
		panel.add(lbsgst, gbc);
		gbc.gridx = 1;

		txtsgst = new JTextField(15);
		panel.add(txtsgst, gbc);

		gbc.gridx = 2;
		JLabel lbCgst = new JLabel("CGST");
		panel.add(lbCgst, gbc);

		gbc.gridx = 3;
		txtCgst = new JTextField(15);
		panel.add(txtCgst, gbc);

		/*--------------------------------Seventh Row----------------------------------------*/
		gbc.gridx = 0;
		gbc.gridy = 6;

		JLabel lbDiscount = new JLabel("Discount");
		panel.add(lbDiscount, gbc);

		gbc.gridx = 1;
		txtDiscount = new JTextField(15);
		panel.add(txtDiscount, gbc);

		gbc.gridx = 2;
		JLabel lbPower = new JLabel("Power");
		panel.add(lbPower, gbc);

		gbc.gridx = 3;
		txtPower = new JTextField(15);
		panel.add(txtPower, gbc);

		return panel;

	}

	private JTextField txtName;
	private JTextField txtCompany;
	private JComboBox<Category> cmbCategory;
	private JComboBox<ProductType> cmbType;
	private JTextField txtExpiryDate;
	private JTextField txtDealer;
	private JTextField txtFormula;
	private JTextField txtSymptoms;
	private JTextField txtCostPrice;
	private JTextField txtSellingPrice;
	private JTextField txtsgst;
	private JTextField txtDiscount;
	private JTextField txtPower;
	private JTextField txtCgst;

}
