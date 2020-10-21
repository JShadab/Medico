package com.medico;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.medico.ui.RegistrationFrame;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {

		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		//new LoginFrame();
		
		new RegistrationFrame();

	}

}
