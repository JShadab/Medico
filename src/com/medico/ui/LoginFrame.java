package com.medico.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class LoginFrame extends JFrame {

	public LoginFrame() {
		setTitle("Login");

		Container con = getContentPane();

		con.add(getTopComponent(), BorderLayout.NORTH);
		con.add(getCenterPanel(), BorderLayout.CENTER);
		con.add(getBottomPanel(), BorderLayout.SOUTH);

		// setSize(500, 400);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setVisible(true);
	}

	private JPanel getCenterPanel() {

		JPanel panel = new JPanel(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		JLabel lbEmail = new JLabel("Email");
		JLabel lbPass = new JLabel("Password");

		JTextField txtEmail = new JTextField(15);
		JTextField txtPass = new JPasswordField(15);

		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(lbEmail, gbc);

		// gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(lbPass, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(txtEmail, gbc);

		// gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(txtPass, gbc);

		Border border = BorderFactory.createLineBorder(Color.BLUE, 1);

		panel.setBorder(border);

		return panel;
	}

	private JLabel getTopComponent() {

		URL url = getClass().getResource("/images/banner1.png");
		ImageIcon icon = new ImageIcon(url);

		JLabel lbHeader = new JLabel(icon);

		return lbHeader;
	}

	private JPanel getBottomPanel() {

		JPanel panel = new JPanel();

		JButton btnOK = new JButton("OK");
		JButton btnExit = new JButton("Exit");
		JButton btnSignUp = new JButton("Sign Up");

		btnOK.addActionListener(e -> {

			// TODO Validating User

			new HomeFrame();
		});

		btnExit.addActionListener(e -> {
			System.exit(0);
		});

		btnSignUp.addActionListener(e -> {
			new RegistrationFrame();

			LoginFrame.this.dispose();
		});

		panel.add(btnOK);
		panel.add(btnSignUp);
		panel.add(btnExit);

		return panel;
	}

}
