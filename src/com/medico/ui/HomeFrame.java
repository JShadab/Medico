package com.medico.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.Border;

import com.medico.ui.dialogs.AddProductDialog;
import com.medico.ui.dialogs.AllProductsDialog;
import com.medico.ui.dialogs.SearchProductDialog;
import com.medico.ui.dialogs.SellProductsDialog;

public class HomeFrame extends JFrame {

	public HomeFrame() {
		setTitle("Home");

		setJMenuBar(getOurMenuBar());

		Container con = getContentPane();

		JLabel lbHomeBanner = new JLabel(new ImageIcon(getClass().getResource("/images/home_banner.jpg")));

		con.add(lbHomeBanner, BorderLayout.CENTER);
		con.add(getFooterPanel(), BorderLayout.SOUTH);

		// setSize(700, 600);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
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

			newBill.addActionListener(e -> {
				showSellProductsDialog();
			});

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

			viewStock.addActionListener(e -> {
				showAllProductsDialog();
			});

			JMenuItem addStock = new JMenuItem("Add Stock");
			addStock.addActionListener(e -> {
				showAddProductDialog();
			});

			// JMenuItem deleteStock = new JMenuItem("Delete Stock");
			// JMenuItem printStock = new JMenuItem("Print Stock");

			mnuStock.add(viewStock);
			mnuStock.add(addStock);
			// mnuStock.add(deleteStock);
			// mnuStock.add(printStock);
		}

		JMenu mnuSearch = new JMenu("Search");
		{
			JMenuItem searchStock = new JMenuItem("Search Stock");

			searchStock.addActionListener(e -> {
				showSearchProductDialog();
			});

			mnuSearch.add(searchStock);
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
		new AddProductDialog(HomeFrame.this);
	}

	private void showAllProductsDialog() {
		new AllProductsDialog(HomeFrame.this);
	}

	private void showSearchProductDialog() {
		new SearchProductDialog(HomeFrame.this);
	}

	private void showSellProductsDialog() {
		new SellProductsDialog(HomeFrame.this);

	}

}
