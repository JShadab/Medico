package com.medico.ui.dialogs;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumnModel;

import com.medico.beans.Product;
import com.medico.db.dao.ProductDAO;
import com.medico.enums.Category;
import com.medico.enums.ProductType;
import com.medico.ui.ProductTableModel;

public class SearchProductDialog extends JDialog {

	public SearchProductDialog(JFrame frame) {
		super(frame);

		setTitle("Search Products");

		Container con = this.getContentPane();

		con.add(getTopPanel(), BorderLayout.NORTH);
		con.add(getCenterPanel());
		con.add(getButtonPanel(), BorderLayout.SOUTH);

		setSize(500, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private Component getButtonPanel() {
		JPanel panel = new JPanel();

		JButton btnSearch = new JButton("Search");
		JButton btnClose = new JButton("Close");

		btnSearch.addActionListener(e -> {

			String searchBy = (String) cmbSearchBY.getSelectedItem();
			String searchKey = txtSearchKey.getText();

			List<Product> products = ProductDAO.getAll(searchBy, searchKey);
			if (products.isEmpty()) {

				JOptionPane.showMessageDialog(SearchProductDialog.this, "There is no product in your stock");
			}

			table.setModel(new ProductTableModel(products));

		});
		btnClose.addActionListener(e -> {
			SearchProductDialog.this.dispose();
		});

		panel.add(btnSearch);
		panel.add(btnClose);

		return panel;
	}

	private JPanel getTopPanel() {

		String[] searchBy = { "name", "company", "category", "type", "expiry_date", "dealer", "formula", "symptoms",
				"cost_price", "sell_price", "sgst", "cgst", "discount", "power" };

		cmbSearchBY = new JComboBox<String>(searchBy);

		txtSearchKey = new JTextField(15);

		JPanel panel = new JPanel();

		panel.add(cmbSearchBY);
		panel.add(txtSearchKey);

		return panel;
	}

	private Component getCenterPanel() {

		table = new JTable();

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setCellSelectionEnabled(true);

		TableColumnModel columnModel = table.getColumnModel();

		for (int i = 0; i < columnModel.getColumnCount(); i++) {

			if (i == 0) {
				columnModel.getColumn(i).setMaxWidth(25);
			} else {

				columnModel.getColumn(i).setMinWidth(100);
			}
		}

		JScrollPane jsp = new JScrollPane(table);

		return jsp;

	}

	private JTable table;
	private JTextField txtSearchKey;
	private JComboBox<String> cmbSearchBY;

}
