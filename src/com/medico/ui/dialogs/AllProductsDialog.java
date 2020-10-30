package com.medico.ui.dialogs;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import com.medico.ui.ProductTableModel;

public class AllProductsDialog extends JDialog {

	public AllProductsDialog(JFrame frame) {
		super(frame);

		setTitle("All Products");

		Container con = this.getContentPane();

		con.add(getCenterPanel(), BorderLayout.CENTER);
		con.add(getButtonPanel(), BorderLayout.SOUTH);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private Component getButtonPanel() {
		JPanel panel = new JPanel();

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(e -> {

			ProductTableModel model = (ProductTableModel) table.getModel();

			model.updateToDB();
			
			JOptionPane.showMessageDialog(AllProductsDialog.this, "Stock updated successfully");

		});

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(e -> {
			AllProductsDialog.this.dispose();
		});

		panel.add(btnUpdate);
		panel.add(btnClose);
		return panel;
	}

	private Component getCenterPanel() {

		table = new JTable(new ProductTableModel());
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
}
