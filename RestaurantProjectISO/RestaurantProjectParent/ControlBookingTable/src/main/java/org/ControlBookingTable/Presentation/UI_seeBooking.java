package org.ControlBookingTable.Presentation;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.ControlBookingTable.Domain.States;
import org.ControlBookingTable.Domain.Table;
import org.ControlBookingTable.Domain.Booking;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The Class UI_seeBooking.
 */
@SuppressWarnings("serial")
public class UI_seeBooking extends JPanel {
	
	/** The buttons pane. */
	private JPanel buttonsPane;
	
	/** The btn cancel. */
	private JButton btnCancel;
	
	/** The scroll pane. */
	private JScrollPane scrollPane;
	
	/** The table bookings. */
	private JTable tableBookings;
	
	/** The booking. */
	private Booking booking;
	
	/** The selected booking. */
	private boolean selectedBooking;

	/**
	 * Create the panel.
	 */

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

	/**
	 * Instantiates a new u I see booking.
	 */
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

	/**
	 * Reload bookings.
	 */
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

	/**
	 * Checks if is selected.
	 *
	 * @return true, if is selected
	 */
	public boolean isSelected() {
		return this.selectedBooking;

	}

	/**
	 * Sets the selected.
	 *
	 * @param b the new selected
	 */
	public void setSelected(boolean b) {
		this.selectedBooking = b;
	}

	/**
	 * The listener interface for receiving tableBookingsMouse events.
	 * The class that is interested in processing a tableBookingsMouse
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addTableBookingsMouseListener<code> method. When
	 * the tableBookingsMouse event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see TableBookingsMouseEvent
	 */
	private class TableBookingsMouseListener extends MouseAdapter {
		
		/* (non-Javadoc)
		 * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
		 */
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

	/**
	 * The listener interface for receiving btnCancelAction events.
	 * The class that is interested in processing a btnCancelAction
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addBtnCancelActionListener<code> method. When
	 * the btnCancelAction event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see BtnCancelActionEvent
	 */
	private class BtnCancelActionListener implements ActionListener {
		
		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
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
