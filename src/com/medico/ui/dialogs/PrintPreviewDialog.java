package com.medico.ui.dialogs;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.medico.beans.SellProduct;
import com.medico.enums.Category;
import com.medico.enums.ProductType;

public class PrintPreviewDialog extends JDialog {

	private PrintPreviewPanel printPreviewPanel;
	private JFrame frame;

	private List<SellProduct> allSellProducts;
	private String custName;
	private String custPhone;

	public PrintPreviewDialog(JFrame frame, List<SellProduct> allSellProducts, String custName, String custPhone) {
		super(frame);
		this.frame = frame;

		this.allSellProducts = allSellProducts;
		this.custName = custName;
		this.custPhone = custPhone;

		setTitle("Preview");

		Container con = this.getContentPane();

		con.add(getCenterPanel());
		con.add(getButtonPanel(), BorderLayout.SOUTH);

		setSize(800, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private Component getButtonPanel() {
		JPanel panel = new JPanel();

		JButton btnPrint = new JButton("Print");
		JButton btnClose = new JButton("Close");

		btnPrint.addActionListener(e -> {

			printComponenet(printPreviewPanel);

		});
		btnClose.addActionListener(e -> {

			PrintPreviewDialog.this.dispose();
		});

		panel.add(btnPrint);
		panel.add(btnClose);

		return panel;
	}

	private Component getCenterPanel() {

		printPreviewPanel = new PrintPreviewPanel(allSellProducts, custName,custPhone);

		return printPreviewPanel;

	}

	public void printComponenet(Component component) {
		PrinterJob pj = PrinterJob.getPrinterJob();
		pj.setJobName(" Print Component ");

		pj.setPrintable(new Printable() {
			public int print(Graphics pg, PageFormat pf, int pageNum) {
				if (pageNum > 0) {
					return Printable.NO_SUCH_PAGE;
				}

				Graphics2D g2 = (Graphics2D) pg;
				g2.translate(pf.getImageableX(), pf.getImageableY());
				component.paint(g2);
				return Printable.PAGE_EXISTS;
			}
		});
		if (pj.printDialog() == false)
			return;

		try {
			pj.print();
		} catch (PrinterException ex) {
			ex.printStackTrace();
		}
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
