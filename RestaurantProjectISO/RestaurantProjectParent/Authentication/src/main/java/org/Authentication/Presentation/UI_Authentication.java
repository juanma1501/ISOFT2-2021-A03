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
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * The Class UI_Authentication.
 */
public class UI_Authentication extends JPanel {
	
	/** The lbl user name. */
	private JLabel lblUserName;
	
	/** The lbl user pass. */
	private JLabel lblUserPass;
	
	/** The txt name. */
	private JTextField txtName;
	
	/** The password F. */
	private JPasswordField passwordF;
	
	/** The btn enter. */
	private JButton btnEnter;

	/** The authenticated. */
	private boolean authenticated = false;

	/** The original color. */
	private Color originalColor;
	
	/** The selected color. */
	private Color selectedColor = new Color(250, 250, 200);

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

	/**
	 * Gets the autheticated.
	 *
	 * @return the autheticated
	 */
	public boolean getAutheticated() {
		return authenticated;
	}

	/**
	 * The listener interface for receiving txtFocus events.
	 * The class that is interested in processing a txtFocus
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addTxtFocusListener<code> method. When
	 * the txtFocus event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see TxtFocusEvent
	 */
	private class TxtFocusListener extends FocusAdapter {
		
		/* (non-Javadoc)
		 * @see java.awt.event.FocusAdapter#focusGained(java.awt.event.FocusEvent)
		 */
		@Override
		public void focusGained(FocusEvent e) {
			e.getComponent().setBackground(selectedColor);
		}

		/* (non-Javadoc)
		 * @see java.awt.event.FocusAdapter#focusLost(java.awt.event.FocusEvent)
		 */
		@Override
		public void focusLost(FocusEvent e) {
			e.getComponent().setBackground(originalColor);
		}
	}

	/**
	 * Sets the txt name.
	 *
	 * @param name the new txt name
	 */
	public void setTxtName(String name) {
		txtName.setText(name);
	}

	/**
	 * Sets the password.
	 *
	 * @param pass the new password
	 */
	public void setPassword(String pass) {
		passwordF.setText(pass);
	}

	/**
	 * Accept.
	 *
	 * @return true, if successful
	 */
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

	/**
	 * The listener interface for receiving btnEnterAction events.
	 * The class that is interested in processing a btnEnterAction
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addBtnEnterActionListener<code> method. When
	 * the btnEnterAction event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see BtnEnterActionEvent
	 */
	private class BtnEnterActionListener implements ActionListener {
		
		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {
			accept();
		}
	}
}