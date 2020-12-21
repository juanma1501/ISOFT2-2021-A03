package org.ControlStatesOfTables.Presentation;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import org.ControlBookingTable.Domain.Table;
import org.ControlBookingTable.Domain.States;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class UI_setTableState extends JPanel {
	private JButton btnUnoccupied;
	private JButton btnBooked;
	private JButton btnOccupied;
	private JButton btnProcessing;
	private JButton btnWaitingfood;
	private JButton btnServed;
	private JButton btnWaitingbill;
	private JButton btnPaying;
	private JButton btnPreparation;

	private Table table;
	private int idTable;
	private States lastState;

	private Color selectedButtonGreen = new Color(0, 255, 0);

	private static final SimpleDateFormat date_formatter = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

	/**
	 * Create the panel.
	 */
	public UI_setTableState(int idTable) throws Exception {

		if (idTable < 1) {
			throw new Exception("The id of the table is not available");
		}

		setBorder(new TitledBorder(null, "Table States", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		{
			btnUnoccupied = new JButton("UNOCCUPIED");
			GridBagConstraints gbc_btnUnoccupied = new GridBagConstraints();
			gbc_btnUnoccupied.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnUnoccupied.insets = new Insets(0, 0, 5, 5);
			gbc_btnUnoccupied.gridx = 2;
			gbc_btnUnoccupied.gridy = 2;
			add(btnUnoccupied, gbc_btnUnoccupied);
		}
		{
			btnProcessing = new JButton("PROCESSING");
			GridBagConstraints gbc_btnProcessing = new GridBagConstraints();
			gbc_btnProcessing.insets = new Insets(0, 0, 5, 5);
			gbc_btnProcessing.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnProcessing.gridx = 4;
			gbc_btnProcessing.gridy = 2;
			add(btnProcessing, gbc_btnProcessing);
		}
		{
			btnWaitingbill = new JButton("WAITING_BILL");
			GridBagConstraints gbc_btnWaitingbill = new GridBagConstraints();
			gbc_btnWaitingbill.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnWaitingbill.insets = new Insets(0, 0, 5, 0);
			gbc_btnWaitingbill.gridx = 6;
			gbc_btnWaitingbill.gridy = 2;
			add(btnWaitingbill, gbc_btnWaitingbill);
		}
		{
			btnBooked = new JButton("BOOKED");
			GridBagConstraints gbc_btnBooked = new GridBagConstraints();
			gbc_btnBooked.insets = new Insets(0, 0, 5, 5);
			gbc_btnBooked.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnBooked.gridx = 2;
			gbc_btnBooked.gridy = 4;
			add(btnBooked, gbc_btnBooked);
		}
		{
			btnWaitingfood = new JButton("WAITING_FOOD");
			GridBagConstraints gbc_btnWaitingfood = new GridBagConstraints();
			gbc_btnWaitingfood.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnWaitingfood.insets = new Insets(0, 0, 5, 5);
			gbc_btnWaitingfood.gridx = 4;
			gbc_btnWaitingfood.gridy = 4;
			add(btnWaitingfood, gbc_btnWaitingfood);
		}
		{
			btnPaying = new JButton("PAYING");
			GridBagConstraints gbc_btnPaying = new GridBagConstraints();
			gbc_btnPaying.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnPaying.insets = new Insets(0, 0, 5, 0);
			gbc_btnPaying.gridx = 6;
			gbc_btnPaying.gridy = 4;
			add(btnPaying, gbc_btnPaying);
		}
		{
			btnOccupied = new JButton("OCCUPIED");
			GridBagConstraints gbc_btnOccupied = new GridBagConstraints();
			gbc_btnOccupied.insets = new Insets(0, 0, 5, 5);
			gbc_btnOccupied.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnOccupied.gridx = 2;
			gbc_btnOccupied.gridy = 6;
			add(btnOccupied, gbc_btnOccupied);
		}
		{
			btnServed = new JButton("SERVED");
			GridBagConstraints gbc_btnServed = new GridBagConstraints();
			gbc_btnServed.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnServed.insets = new Insets(0, 0, 5, 5);
			gbc_btnServed.gridx = 4;
			gbc_btnServed.gridy = 6;
			add(btnServed, gbc_btnServed);
		}
		{
			btnPreparation = new JButton("PREPARATION");
			GridBagConstraints gbc_btnPreparation = new GridBagConstraints();
			gbc_btnPreparation.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnPreparation.insets = new Insets(0, 0, 5, 0);
			gbc_btnPreparation.gridx = 6;
			gbc_btnPreparation.gridy = 6;
			add(btnPreparation, gbc_btnPreparation);
		}
		try {
			table = new Table();
			table.setIdTable(idTable);
			table.read();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "SORRY, AN ERROR HAS HAPPENED",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void initialState() {

		States state;
		state = table.getState();
		btnStates(state);
	}

	public void btnStates(States state) {

		switch (state) {

		case UNOCCUPIED:
			btnUnoccupied.setBackground(selectedButtonGreen);
			btnUnoccupied.setSelected(true);
			btnUnoccupied.setForeground(Color.white);
			break;
		case BOOKED:
			btnBooked.setBackground(selectedButtonGreen);
			btnBooked.setSelected(true);
			btnBooked.setForeground(Color.white);
			break;
		case OCCUPIED:
			btnOccupied.setBackground(selectedButtonGreen);
			btnOccupied.setSelected(true);
			btnOccupied.setForeground(Color.white);
			break;
		case PROCESSING:
			btnProcessing.setBackground(selectedButtonGreen);
			btnProcessing.setSelected(true);
			btnProcessing.setForeground(Color.white);
			break;
		case WAITING_FOOD:
			btnWaitingfood.setBackground(selectedButtonGreen);
			btnWaitingfood.setSelected(true);
			btnWaitingfood.setForeground(Color.white);

			break;
		case SERVED:
			btnServed.setBackground(selectedButtonGreen);
			btnServed.setSelected(true);
			btnServed.setForeground(Color.white);
			break;
		case WAITING_BILL:
			btnWaitingbill.setBackground(selectedButtonGreen);
			btnWaitingbill.setSelected(true);
			btnWaitingbill.setForeground(Color.white);
			break;
		case PAYING:
			btnPaying.setBackground(selectedButtonGreen);
			btnPaying.setSelected(true);
			btnPaying.setForeground(Color.white);
			break;
		case PREPARATION:
			btnPreparation.setBackground(selectedButtonGreen);
			btnPreparation.setSelected(true);
			btnPreparation.setForeground(Color.white);
			break;
		}
		lastState = state;
	}

	public States getLastState() {
		return this.lastState;
	}

	public void setToInitialColor() {

		switch (lastState) {
		case UNOCCUPIED:
			btnUnoccupied.setBackground(selectedButtonGreen);
			btnUnoccupied.setSelected(false);
			btnUnoccupied.setForeground(Color.black);
			break;
		case BOOKED:
			btnBooked.setBackground(selectedButtonGreen);
			btnBooked.setSelected(false);
			btnBooked.setForeground(Color.black);
			break;
		case OCCUPIED:
			btnOccupied.setBackground(selectedButtonGreen);
			btnOccupied.setSelected(false);
			btnOccupied.setForeground(Color.black);
			break;
		case PROCESSING:
			btnProcessing.setBackground(selectedButtonGreen);
			btnProcessing.setSelected(false);
			btnProcessing.setForeground(Color.black);
			break;
		case WAITING_FOOD:
			btnWaitingfood.setBackground(selectedButtonGreen);
			btnWaitingfood.setSelected(false);
			btnWaitingfood.setForeground(Color.black);
			break;
		case SERVED:
			btnServed.setBackground(selectedButtonGreen);
			btnServed.setSelected(false);
			btnServed.setForeground(Color.black);
			break;
		case WAITING_BILL:
			btnWaitingbill.setBackground(selectedButtonGreen);
			btnWaitingbill.setSelected(false);
			btnWaitingbill.setForeground(Color.black);
			break;
		case PAYING:
			btnPaying.setBackground(selectedButtonGreen);
			btnPaying.setSelected(false);
			btnPaying.setForeground(Color.black);
			break;
		case PREPARATION:
			btnPreparation.setBackground(selectedButtonGreen);
			btnPreparation.setSelected(false);
			btnPreparation.setForeground(Color.black);
			break;
		}
	}

	public void setIdTable(int idTable) {
		this.idTable = idTable;
	}

	private class BtnActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			String boton = e.getActionCommand().toString();
			States estado;
			estado = States.UNOCCUPIED;

			if (boton.equals("UNOCCUPIED")) {
				estado = States.UNOCCUPIED;
			} else if (boton.equals("BOOKED")) {
				estado = States.BOOKED;
			} else if (boton.equals("OCCUPIED")) {
				estado = States.OCCUPIED;
			} else if (boton.equals("PROCESSING")) {
				estado = States.PROCESSING;
			} else if (boton.equals("WAITING_FOOD")) {
				estado = States.WAITING_FOOD;
			} else if (boton.equals("SERVED")) {
				estado = States.SERVED;
			} else if (boton.equals("WAITING_BILL")) {
				estado = States.WAITING_BILL;
			} else if (boton.equals("PAYING")) {
				estado = States.PAYING;
			} else if (boton.equals("PREPARATION")) {
				estado = States.PREPARATION;
			}
			try {
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				table.setStateTime(date_formatter.format(timestamp));

				table.setState(estado);
				table.update();
				setToInitialColor();
				btnStates(estado);

			} catch (Exception arg0) {

			}

		}

	}

}
