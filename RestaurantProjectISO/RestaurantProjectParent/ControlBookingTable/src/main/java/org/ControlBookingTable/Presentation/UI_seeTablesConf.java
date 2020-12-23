package org.ControlBookingTable.Presentation;

import javax.swing.JPanel;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.ControlBookingTable.Domain.Table;

/**
 * The Class UI_seeTablesConf.
 */
@SuppressWarnings({ "unused", "serial" })
public class UI_seeTablesConf extends JPanel {
	
	/** The scroll pane. */
	private JScrollPane scrollPane;
	
	/** The table tables. */
	private JTable tableTables;
	
	/** The table. */
	private Table table;

	/**
	 * Instantiates a new u I see tables conf.
	 */
	public UI_seeTablesConf() {
		setBorder(new TitledBorder(null, "Tables configuration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setForeground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout(0, 0));
		{
			scrollPane = new JScrollPane();
			scrollPane.setName("");
			add(scrollPane, BorderLayout.CENTER);
			{
				tableTables = new JTable();
				tableTables.setName("IdTables\nClients\nState");
				tableTables.setModel(new DefaultTableModel(new Object[][] {},
						new String[] { "IdTables", "Clients", "State", "Last State Hour" }) {
					boolean[] columnEditables = new boolean[] { false, false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				tableTables.getColumnModel().getColumn(0).setPreferredWidth(100);
				tableTables.getColumnModel().getColumn(1).setPreferredWidth(96);
				scrollPane.setViewportView(tableTables);
			}
		}
		loadTables();
	}

	/**
	 * Load tables.
	 */
	public void loadTables() {
		table = new Table();
		table.readAll();

		if (tableTables.getRowCount() > 0) {

			DefaultTableModel model = (DefaultTableModel) tableTables.getModel();
			int limit = tableTables.getRowCount() - 1;

			for (int i = limit; i >= 0; i--) {
				model.removeRow(i);
			}

		}

		for (int i = 0; i < table.getTablesManager().get_tablesList().size(); i++) {
			Table aux = table.getTablesManager().get_tablesList().get(i);
			DefaultTableModel modelo = (DefaultTableModel) tableTables.getModel();
			Object filaNueva[] = { aux.getIdTable(), aux.getClients(), aux.getState().toString(), aux.getState() };
			modelo.addRow(filaNueva);
		}

	}

}