package com.medico.ui.dialogs;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JPanel;

import com.medico.beans.SellProduct;

public class PrintPreviewPanel extends JPanel {

	private List<SellProduct> allSellProducts;
	private String custName;
	private String custPhone;

	public PrintPreviewPanel(List<SellProduct> allSellProducts, String custName, String custPhone) {
		setBackground(Color.WHITE);

		this.allSellProducts = allSellProducts;
		this.custName = custName;
		this.custPhone = custPhone;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		Font oldFond = g2d.getFont();

		int X = 25;
		int Y = 25;
		int W = getWidth() - 200;

		g.drawRect(X, Y, W, getHeight() - 50);

		/*----------------------------Company Brand & Logo-----------------------------------*/

		g2d.setFont(new Font("ARIAL", Font.BOLD, 20));
		g2d.setColor(Color.BLUE);

		String header = "Indian Medical Store";

		int headerWidth = g2d.getFontMetrics().stringWidth(header);
		int centerX = (W - headerWidth) / 2;

		g2d.drawString(header, centerX, Y + 25);

		/*------------------------------Customer Info & Grand total---------------------------------------*/

		Y = Y + 30;
		g2d.drawRect(X, Y, W, 30);
		g2d.setFont(new Font("ARIAL", Font.PLAIN, 12));
		String custNameSTR = "Customer Name: " + custName + " | ";
		g2d.drawString(custNameSTR, X + 10, Y + 20);

		int custNameSTRWidth = g2d.getFontMetrics().stringWidth(custNameSTR);

		g2d.drawString("Customer Phone: " + custPhone + " | ", X + custNameSTRWidth + 15, Y + 20);

		double grandTotal = 0;
		for (SellProduct prod : allSellProducts) {

			grandTotal += prod.getAmount();
		}

		g2d.drawString("Total: " + grandTotal, W - 75, Y + 20);

		/*------------------------------ Bill Details---------------------------------------*/

		String colNames = "NAME | COMPANY | UNITS | SELL_PRICE | SGST | CGST | DISCOUNT | AMOUNT";

		g2d.setFont(new Font("ARIAL", Font.BOLD, 15));
		g2d.setColor(Color.RED);

		Y = Y + 60;
		g2d.drawString(colNames, X + 5, Y);
		
		g2d.setColor(Color.BLACK);

		for (SellProduct prod : allSellProducts) {
			String row = prod.getName() + "   |   " + prod.getCompany() + "   |   " + prod.getUnits() + "   |   "
					+ prod.getSellingPrice() + "   |   " + prod.getSgst() + "   |   " + prod.getCgst() + "   |   "
					+ prod.getDiscount() + "   |   " + prod.getAmount();
			Y = Y + 25;
			g2d.drawString(row, X + 5, Y);
		}
	}

}
