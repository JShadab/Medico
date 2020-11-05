package com.medico.ui.dialogs;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.print.PrinterException;

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

		setSize(800, 600);
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

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(e -> {

			int selectedRowIndex = table.getSelectedRow();

			if (selectedRowIndex == -1) {
				JOptionPane.showMessageDialog(AllProductsDialog.this, "Please select a row for deletion");
				return;
			}

			ProductTableModel model = (ProductTableModel) table.getModel();

			model.deleteFromDB(selectedRowIndex);

			JOptionPane.showMessageDialog(AllProductsDialog.this, "Stock deleted successfully");

		});

		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(e -> {
			try {
				table.print();
			} catch (PrinterException e1) {
				e1.printStackTrace();
			}
		});

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(e -> {
			AllProductsDialog.this.dispose();
		});

		panel.add(btnUpdate);
		panel.add(btnDelete);
		panel.add(btnPrint);
		panel.add(btnClose);

		return panel;
	}

	private Component getCenterPanel() {

		table = new JTable(new ProductTableModel());

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
}
