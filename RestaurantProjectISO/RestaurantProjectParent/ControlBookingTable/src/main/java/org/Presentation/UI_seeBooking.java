package org.Presentation;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.Domain.States;
import org.Domain.Table;
import org.Domain.Booking;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class UI_seeBooking extends JPanel {
	private JPanel buttonsPane;
	private JButton btnCancel;
	private JScrollPane scrollPane;
	private JTable tableBookings;
	private Booking booking;
	private boolean selectedBooking;

	/**
	 * Create the panel.
	 */

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

	@SuppressWarnings("serial")
	public UI_seeBooking() {
		selectedBooking = false;
		setBorder(new TitledBorder(null, "Bookings", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		{
			buttonsPane = new JPanel();
			add(buttonsPane, BorderLayout.SOUTH);
			{
				btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new BtnCancelActionListener());
				buttonsPane.add(btnCancel);
			}
		}
		{
			scrollPane = new JScrollPane();

			add(scrollPane, BorderLayout.CENTER);
			{
				tableBookings = new JTable();
				tableBookings.addMouseListener(new TableBookingsMouseListener());

				tableBookings.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID Booking",
						"Client Name", "Nº Clients", "Turn launch/dinner", "Turn", "ID Table", }

				) {
					boolean[] editsColumn = new boolean[] { false, false, false, false, false, false };

					public boolean isCellEditable(int row, int column) {
						return editsColumn[column];
					}
				});
				scrollPane.setViewportView(tableBookings);
			}
		}
		reloadBookings();
	}

	public void reloadBookings() {
		Booking booking = new Booking();
		try {
			if (tableBookings.getRowCount() > 0) {

				DefaultTableModel model = (DefaultTableModel) tableBookings.getModel();
				int Limite = tableBookings.getRowCount() - 1;

				for (int i = Limite; i >= 0; i--) {
					model.removeRow(i);
				}

			}
			booking.readAll();
			;
			for (int i = 0; i < booking.getBookingManager().getListBooking().size(); i++) {

				Booking aux = booking.getBookingManager().getListBooking().get(i);

				DefaultTableModel model = (DefaultTableModel) tableBookings.getModel();
				Object newRow[] = { aux.getIdBooking(), aux.get_name(), aux.get_guests(), aux.get_turnLunchDinner(),
						aux.get_turn(), aux.getTable().getIdTable() };
				model.addRow(newRow);
			}
		} catch (Exception e) {

		}

	}

	public boolean isSelected() {
		return this.selectedBooking;

	}

	public void setSelected(boolean b) {
		this.selectedBooking = b;
	}

	private class TableBookingsMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			try {
				booking = new Booking();
				int row = tableBookings.getSelectedRow();
				int idBooking = Integer.parseInt(tableBookings.getValueAt(row, 0).toString());
				booking.setIdBooking(idBooking);
				booking.read();
				setSelected(true);
			} catch (Exception arg0) {

			}
		}
	}

	private class BtnCancelActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (isSelected()) {
				try {
					Table table = booking.getTable();
					table.setState(States.UNOCCUPIED);
					// Timestamp timestamp = new Timestamp(System.currentTimeMillis());
					// date modification later
					table.update();
					booking.eliminate();

					setSelected(false);
					reloadBookings();
					JOptionPane.showMessageDialog(null, "Reserva eliminada correctamente", "Reserva eliminada",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception arg0) {

				}
			} else {

				JOptionPane.showMessageDialog(null, "No ha selecionado ninguna reserva", "Error al cancelar reserva",
						JOptionPane.ERROR_MESSAGE);

			}
		}
	}
}
