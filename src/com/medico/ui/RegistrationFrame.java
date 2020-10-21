package com.medico.ui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegistrationFrame extends JFrame {

	public RegistrationFrame() {
		setTitle("Registeration");

		Container con = getContentPane();

		con.add(getCenterPanel());

		setSize(500, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// pack();
		setVisible(true);
	}

	private JPanel getCenterPanel() {

		JPanel panel = new JPanel(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		JLabel lbName = new JLabel("Name");
		JLabel lbEmail = new JLabel("Email");
		JLabel lbPhone = new JLabel("Phone");
		JLabel lbPassword = new JLabel("Password");
		JLabel lbCPassword = new JLabel("Confirm Password");

		JTextField txtName = new JTextField(15);
		JTextField txtEmail = new JTextField(15);
		JTextField txtPhone = new JTextField(15);
		JTextField txtPassword = new JPasswordField(15);
		JTextField txtCPassword = new JTextField(15);

		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(lbName, gbc);

		++gbc.gridy;
		panel.add(lbEmail, gbc);

		++gbc.gridy;
		panel.add(lbPhone, gbc);

		++gbc.gridy;
		panel.add(lbPassword, gbc);

		++gbc.gridy;
		panel.add(lbCPassword, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(txtName, gbc);

		++gbc.gridy;
		panel.add(txtEmail, gbc);

		++gbc.gridy;
		panel.add(txtPhone, gbc);

		++gbc.gridy;
		panel.add(txtPassword, gbc);

		++gbc.gridy;
		panel.add(txtCPassword, gbc);

		return panel;
	}

}
