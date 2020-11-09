package com.medico.ui.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumnModel;

import com.medico.beans.Product;
import com.medico.beans.SellProduct;
import com.medico.db.dao.ProductDAO;
import com.medico.ui.tablemodels.SellProductTableModel;

public class SellProductsDialog extends JDialog {

	private JLabel lbGrandTotalAmt;



	public SellProductsDialog(JFrame frame) {
		super(frame);

		setTitle("Sell Products");

		Container con = this.getContentPane();

		con.add(getTopPanel(), BorderLayout.NORTH);

		con.add(getButtonPanel(), BorderLayout.SOUTH);

		con.add(getCenterPanel());

		setSize(800, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private Component getButtonPanel() {

		JPanel panel = new JPanel(new BorderLayout());

		JPanel panelLeft = new JPanel(new FlowLayout(FlowLayout.LEFT));

		JLabel lbCustomerName = new JLabel("Customer Name");
		JTextField txtCustomerName = new JTextField(15);

		JLabel lbCustomerPhone = new JLabel("Phone");
		JTextField txtCustomerPhone = new JTextField(15);

		panelLeft.add(lbCustomerName);
		panelLeft.add(txtCustomerName);

		panelLeft.add(lbCustomerPhone);
		panelLeft.add(txtCustomerPhone);

		JButton btnGenrateBill = new JButton("Genrate Bill");
		btnGenrateBill.addActionListener(e -> {
			JOptionPane.showMessageDialog(SellProductsDialog.this, "Bill generated successfully");
		});
		panelLeft.add(btnGenrateBill);

		JPanel panelRight = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		Font font = new Font("ARIAL", Font.BOLD, 15);

		JLabel lbGrandTotal = new JLabel("Grand Total: ");
		lbGrandTotal.setFont(font);
		lbGrandTotal.setForeground(Color.BLUE);

		lbGrandTotalAmt = new JLabel("Rs 0.0");
		lbGrandTotalAmt.setFont(font);
		lbGrandTotalAmt.setForeground(Color.BLUE);

		panelRight.add(lbGrandTotal);
		panelRight.add(lbGrandTotalAmt);

		panel.add(panelLeft, BorderLayout.WEST);
		panel.add(panelRight, BorderLayout.EAST);

		return panel;
	}

	private JPanel getTopPanel() {

		List<Product> allProducts = ProductDAO.getAll();
		Product[] allProductArr = allProducts.toArray(new Product[] {});

		cmbProduct = new JComboBox<Product>(allProductArr);

		JButton btnAdd = new JButton("Add");

		btnAdd.addActionListener(e -> {

			Product selectedProduct = (Product) cmbProduct.getSelectedItem();

			SellProduct sellProduct = new SellProduct(selectedProduct);

			SellProductTableModel model = (SellProductTableModel) table.getModel();
			model.addProduct(sellProduct);

		});

		JPanel panel = new JPanel();

		panel.add(cmbProduct);
		panel.add(btnAdd);

		return panel;
	}

	private Component getCenterPanel() {

		table = new JTable(new SellProductTableModel(new ArrayList<SellProduct>(), lbGrandTotalAmt));

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setCellSelectionEnabled(true);

		TableColumnModel columnModel = table.getColumnModel();

		for (int i = 0; i < columnModel.getColumnCount(); i++) {

			columnModel.getColumn(i).setMinWidth(100);

		}

		JScrollPane jsp = new JScrollPane(table);

		return jsp;

	}

	private JTable table;
	private JComboBox<Product> cmbProduct;

}
