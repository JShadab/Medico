package com.medico.ui.dialogs;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

import com.medico.ui.ProductTableModel;

public class AllProductsDialog extends JDialog {

	public AllProductsDialog(JFrame frame) {
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
		return panel;
	}

	private Component getCenterPanel() {

		JTable table = new JTable(new ProductTableModel());

		TableColumnModel columnModel = table.getColumnModel();

		for (int i = 0; i < columnModel.getColumnCount(); i++) {

			columnModel.getColumn(i).setMinWidth(100);
		}

		JScrollPane jsp = new JScrollPane(table);

		return jsp;
	}

}
