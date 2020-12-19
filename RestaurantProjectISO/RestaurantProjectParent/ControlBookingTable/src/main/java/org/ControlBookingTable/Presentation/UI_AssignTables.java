package org.ControlBookingTable.Presentation;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import org.ControlBookingTable.Domain.States;
import org.ControlBookingTable.Domain.Table;
import org.ControlBookingTable.Domain.Booking;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI_AssignTables extends JPanel {
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblTable;
	private JComboBox cmbTables;
	private JLabel lblTurnLunchDinn;
	private JRadioButton rdbtnLunch;
	private JRadioButton rdbtnDinner;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblTurn;
	private JComboBox cmbTurns;
	private JButton btnAssign;
	private JLabel lblClients;
	private JSpinner spnClients;

	private UI_seeBooking bookings;

	private Color start_color;
	/**
	 * Create the panel.
	 */

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

	public UI_AssignTables(UI_seeBooking bookings) {
		this.bookings = bookings;
		setBorder(new TitledBorder(null, "Assign table", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 156, 101, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 34, 35, 33, 34, 36, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		{
			lblName = new JLabel("Client Name");
			GridBagConstraints gbc_lblName = new GridBagConstraints();
			gbc_lblName.anchor = GridBagConstraints.WEST;
			gbc_lblName.insets = new Insets(0, 0, 5, 5);
			gbc_lblName.gridx = 1;
			gbc_lblName.gridy = 1;
			add(lblName, gbc_lblName);
		}
		{
			txtName = new JTextField();
			txtName.addFocusListener(new ColorKeyListener());

			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.gridwidth = 2;
			gbc_textField.insets = new Insets(0, 0, 5, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 2;
			gbc_textField.gridy = 1;
			add(txtName, gbc_textField);
			txtName.setColumns(10);
		}
		{
			lblTable = new JLabel("Table");
			GridBagConstraints gbc_lblMesa = new GridBagConstraints();
			gbc_lblMesa.anchor = GridBagConstraints.WEST;
			gbc_lblMesa.insets = new Insets(0, 0, 5, 5);
			gbc_lblMesa.gridx = 1;
			gbc_lblMesa.gridy = 2;
			add(lblTable, gbc_lblMesa);
		}
		{
			cmbTables = new JComboBox();
			cmbTables.addFocusListener(new ColorKeyListener());
			Table table = new Table();
			table.readAll();
			ArrayList<String> listTableId = new ArrayList<String>();

			for (int i = 0; i < table.getTablesManager().get_tablesList().size(); i++) {
				String id = Integer.toString(table.getTablesManager().get_tablesList().get(i).getIdTable());
				listTableId.add(id);
			}

			cmbTables.setModel(new DefaultComboBoxModel(listTableId.toArray()));
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox.gridx = 2;
			gbc_comboBox.gridy = 2;
			add(cmbTables, gbc_comboBox);
		}
		{
			lblClients = new JLabel("Clients");
			GridBagConstraints gbc_lblComensales = new GridBagConstraints();
			gbc_lblComensales.anchor = GridBagConstraints.WEST;
			gbc_lblComensales.insets = new Insets(0, 0, 5, 5);
			gbc_lblComensales.gridx = 1;
			gbc_lblComensales.gridy = 3;
			add(lblClients, gbc_lblComensales);
		}
		{
			spnClients = new JSpinner();
			spnClients.addFocusListener(new ColorKeyListener());
			spnClients.setModel(new SpinnerNumberModel(1, 1, 6, 1));
			GridBagConstraints gbc_spinner = new GridBagConstraints();
			gbc_spinner.anchor = GridBagConstraints.WEST;
			gbc_spinner.insets = new Insets(0, 0, 5, 5);
			gbc_spinner.gridx = 2;
			gbc_spinner.gridy = 3;
			add(spnClients, gbc_spinner);
		}
		{
			lblTurnLunchDinn = new JLabel("Turn Lunch/Dinner");
			GridBagConstraints gbc_lblTurnoComCen = new GridBagConstraints();
			gbc_lblTurnoComCen.anchor = GridBagConstraints.WEST;
			gbc_lblTurnoComCen.insets = new Insets(0, 0, 5, 5);
			gbc_lblTurnoComCen.gridx = 1;
			gbc_lblTurnoComCen.gridy = 4;
			add(lblTurnLunchDinn, gbc_lblTurnoComCen);
		}
		{
			rdbtnLunch = new JRadioButton("Lunch");
			rdbtnLunch.addFocusListener(new ColorKeyListener());
			buttonGroup.add(rdbtnLunch);
			GridBagConstraints gbc_rdbtnComida = new GridBagConstraints();
			gbc_rdbtnComida.insets = new Insets(0, 0, 5, 5);
			gbc_rdbtnComida.gridx = 2;
			gbc_rdbtnComida.gridy = 4;
			add(rdbtnLunch, gbc_rdbtnComida);
		}
		{
			rdbtnDinner = new JRadioButton("Dinner");
			rdbtnDinner.addFocusListener(new ColorKeyListener());
			buttonGroup.add(rdbtnDinner);
			GridBagConstraints gbc_rdbtnCena = new GridBagConstraints();
			gbc_rdbtnCena.insets = new Insets(0, 0, 5, 5);
			gbc_rdbtnCena.gridx = 3;
			gbc_rdbtnCena.gridy = 4;
			add(rdbtnDinner, gbc_rdbtnCena);
		}
		{
			lblTurn = new JLabel("Turn ");
			GridBagConstraints gbc_lblTurno = new GridBagConstraints();
			gbc_lblTurno.anchor = GridBagConstraints.EAST;
			gbc_lblTurno.insets = new Insets(0, 0, 5, 5);
			gbc_lblTurno.gridx = 1;
			gbc_lblTurno.gridy = 5;
			add(lblTurn, gbc_lblTurno);
		}
		{
			cmbTurns = new JComboBox();
			cmbTurns.addFocusListener(new ColorKeyListener());
			cmbTurns.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3" }));
			GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
			gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox_1.gridx = 2;
			gbc_comboBox_1.gridy = 5;
			add(cmbTurns, gbc_comboBox_1);
		}
		{
			btnAssign = new JButton("Assign");
			btnAssign.addActionListener(new BtnAsignarActionListener());
			GridBagConstraints gbc_btnAsignar = new GridBagConstraints();
			gbc_btnAsignar.insets = new Insets(0, 0, 0, 5);
			gbc_btnAsignar.gridx = 2;
			gbc_btnAsignar.gridy = 7;
			add(btnAssign, gbc_btnAsignar);
		}

	}

	private class ColorKeyListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			start_color = e.getComponent().getBackground();
			e.getComponent().setBackground(new Color(250, 250, 210));
		}

		@Override
		public void focusLost(FocusEvent e) {
			e.getComponent().setBackground(start_color);
		}
	}

	private class BtnAsignarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			Booking booking = new Booking();
			booking.assignLastId();
			try {
				Table t = new Table();
				t.setIdTable(Integer.parseInt(cmbTables.getSelectedItem().toString()));
				t.read();
				booking.setTable(t);
				booking.set_name(txtName.getText());
				booking.set_guests(Integer.parseInt(spnClients.getValue().toString()));
				booking.set_turnLunchDinner(rdbtnLunch.isSelected() ? "lunch" : "dinner");
				booking.set_turn(Integer.parseInt(cmbTurns.getSelectedItem().toString()));
				t.setState(States.BOOKED);
				// Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				// t.setHour(sdf.format(timestamp));
				if (!booking.insert()) {
					throw new Exception("Error al insertar la reserva");
				}

				if (!t.update()) {
					throw new Exception("Error al modificar el estado de la mesa");
				}
				bookings.reloadBookings();

			} catch (Exception arg0) {
				JOptionPane.showMessageDialog(null, arg0.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}

		}
	}
}