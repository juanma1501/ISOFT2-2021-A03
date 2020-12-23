package org.Authentication.Presentation;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import org.Authentication.Domain.User;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.Authentication.Domain.User;
import org.Authentication.Domain.UsersManager;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFrame;

public class UI_Authentication extends JPanel {
	private JLabel lblUserName;
	private JLabel lblUserPass;
	private JTextField txtName;
	private JPasswordField passwordF;
	private JButton btnEnter;

	private boolean authenticated = false;

	private Color originalColor;
	private Color selectedColor = new Color(250, 250, 200);

	private JFrame frm;

	/**
	 * Create the panel.
	 */
	public UI_Authentication() {
		setBorder(new TitledBorder(null, "Authentication", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 198, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		{
			lblUserName = new JLabel("User Name:");
			GridBagConstraints gbc_lblUserName = new GridBagConstraints();
			gbc_lblUserName.insets = new Insets(0, 0, 5, 5);
			gbc_lblUserName.gridx = 1;
			gbc_lblUserName.gridy = 2;
			add(lblUserName, gbc_lblUserName);
		}
		{
			txtName = new JTextField();
			txtName.addFocusListener(new TxtFocusListener());
			GridBagConstraints gbc_txtName = new GridBagConstraints();
			gbc_txtName.insets = new Insets(0, 0, 5, 5);
			gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtName.gridx = 3;
			gbc_txtName.gridy = 2;
			add(txtName, gbc_txtName);
			txtName.setColumns(10);
		}
		originalColor = txtName.getBackground();
		{
			lblUserPass = new JLabel("Password: ");
			GridBagConstraints gbc_lblUserPass = new GridBagConstraints();
			gbc_lblUserPass.insets = new Insets(0, 0, 5, 5);
			gbc_lblUserPass.gridx = 1;
			gbc_lblUserPass.gridy = 3;
			add(lblUserPass, gbc_lblUserPass);
		}
		{
			passwordF = new JPasswordField();
			passwordF.addFocusListener(new TxtFocusListener());
			GridBagConstraints gbc_passwordField = new GridBagConstraints();
			gbc_passwordField.insets = new Insets(0, 0, 5, 5);
			gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
			gbc_passwordField.gridx = 3;
			gbc_passwordField.gridy = 3;
			add(passwordF, gbc_passwordField);
		}
		{
			btnEnter = new JButton("Enter");
			btnEnter.setVisible(false);
			btnEnter.addActionListener(new BtnEnterActionListener());
			GridBagConstraints gbc_btnEnter = new GridBagConstraints();
			gbc_btnEnter.insets = new Insets(0, 0, 5, 5);
			gbc_btnEnter.gridx = 3;
			gbc_btnEnter.gridy = 5;
			add(btnEnter, gbc_btnEnter);
		}

	}

	public void setFrm(JFrame frm) {
		this.frm = frm;
	}

	public boolean getAutheticated() {
		return authenticated;
	}

	private class TxtFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			e.getComponent().setBackground(selectedColor);
		}

		@Override
		public void focusLost(FocusEvent e) {
			e.getComponent().setBackground(originalColor);
		}
	}

	public void setTxtName(String name) {
		txtName.setText(name);
	}

	public void setPassword(String pass) {
		passwordF.setText(pass);
	}

	@SuppressWarnings("deprecation")
	public boolean accept() {
		boolean autheticated = false;
		try {
			if (txtName.getText().equals("") && passwordF.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "No ha introducido usuario y contraseña", "Autenticación",
						JOptionPane.WARNING_MESSAGE);
			} else {
				String name = txtName.getText();
				String password = passwordF.getText();
				User user = new User();
				user.setName(name);
				user.setPassword(password);

				if (!user.authenticate()) {
					JOptionPane.showMessageDialog(null, "The introduced user or password are not valid",
							"Authentication", JOptionPane.WARNING_MESSAGE);
				} else {
					autheticated = true;

					JOptionPane.showMessageDialog(null, "Authetication Valid", "Authentication",
							JOptionPane.DEFAULT_OPTION);

				}
			}
		} catch (Exception arg0) {
			autheticated = false;
		}
		return autheticated;
	}

	private class BtnEnterActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			accept();
		}
	}
}