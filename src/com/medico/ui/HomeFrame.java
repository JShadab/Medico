package com.medico.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.medico.beans.Product;
import com.medico.enums.Category;
import com.medico.enums.ProductType;

public class HomeFrame extends JFrame {

	public HomeFrame() {
		setTitle("Home");

		setJMenuBar(getOurMenuBar());

		Container con = getContentPane();

		con.add(getFooterPanel(), BorderLayout.SOUTH);

		setSize(700, 600);
		// setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setVisible(true);
	}

	private JMenuBar getOurMenuBar() {

		ImageIcon iconNewBill = new ImageIcon(getClass().getResource("/images/new-bill.png"));

		JMenuBar menuBar = new JMenuBar();

		JMenu mnuBilling = new JMenu("Billing");
		{
			JMenuItem newBill = new JMenuItem("New Bill", iconNewBill);
			JMenuItem editBill = new JMenuItem("Edit Bill");
			JMenuItem deleteBill = new JMenuItem("Delete Bill");
			JMenuItem printBill = new JMenuItem("Print Bill");

			mnuBilling.add(newBill);
			mnuBilling.addSeparator();
			mnuBilling.add(editBill);
			mnuBilling.add(deleteBill);
			mnuBilling.add(printBill);
		}

		JMenu mnuStock = new JMenu("Stock");
		{
			JMenuItem viewStock = new JMenuItem("View Stock", iconNewBill);
			JMenuItem addStock = new JMenuItem("Add Stock");

			addStock.addActionListener(e -> {
				showAddProductDialog();
			});

			JMenuItem deleteStock = new JMenuItem("Delete Stock");
			JMenuItem printStock = new JMenuItem("Print Stock");

			mnuStock.add(viewStock);
			mnuStock.add(addStock);
			mnuStock.add(deleteStock);
			mnuStock.add(printStock);
		}

		JMenu mnuSearch = new JMenu("Search");
		{
		}
		JMenu mnuSettings = new JMenu("Settings");
		{
		}

		menuBar.add(mnuBilling);
		menuBar.add(mnuStock);
		menuBar.add(mnuSearch);
		menuBar.add(mnuSettings);

		return menuBar;
	}

	private Component getFooterPanel() {

		JLabel lbFooter = new JLabel("CopyRight @2020", JLabel.CENTER);

		Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
		lbFooter.setBorder(border);

		return lbFooter;
	}

	private void showAddProductDialog() {

		JDialog dialog = new JDialog(HomeFrame.this);
		dialog.setTitle("Add Product");

		Container con = dialog.getContentPane();

		con.add(getCenterPanelForAddProductDialog());
		con.add(getButtonPanelForAddProductDialog(), BorderLayout.SOUTH);

		dialog.setSize(500, 500);
		setLocationRelativeTo(null);
		dialog.setVisible(true);

	}

	private Component getButtonPanelForAddProductDialog() {
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

		});
		btnClose.addActionListener(e -> {
		});

		panel.add(btnSave);
		panel.add(btnClose);

		return panel;
	}

	private JPanel getCenterPanelForAddProductDialog() {

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
