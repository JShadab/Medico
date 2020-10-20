package com.medico.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {

	public LoginFrame() {
		setTitle("Login");

		JLabel lbEmail = new JLabel("Email");
		JLabel lbPass = new JLabel("Password");

		JTextField txtEmail = new JTextField(15);
		JTextField txtPass = new JPasswordField(15);

		JButton btnOK = new JButton("OK");
		JButton btnExit = new JButton("Exit");

		setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets = new Insets(5, 5, 5, 5);

		gbc.gridx = 0;
		gbc.gridy = 0;
		add(lbEmail, gbc);

		// gbc.gridx = 0;
		gbc.gridy = 1;
		add(lbPass, gbc);

		// gbc.gridx = 0;
		gbc.gridy = 2;
		add(btnOK, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		add(txtEmail, gbc);

		// gbc.gridx = 1;
		gbc.gridy = 1;
		add(txtPass, gbc);

		// gbc.gridx = 1;
		gbc.gridy = 2;
		add(btnExit, gbc);

		//setSize(500, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}

}
