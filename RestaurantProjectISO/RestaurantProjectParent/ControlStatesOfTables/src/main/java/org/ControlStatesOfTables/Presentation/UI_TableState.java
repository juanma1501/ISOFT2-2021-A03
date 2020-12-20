package org.ControlStatesOfTables.Presentation;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import org.ControlBookingTable.Domain.Table;

import java.awt.BorderLayout;

public class UI_TableState extends JPanel {
	private JPanel pnlContainer;
	private Table table;
	private JPanel[] pnls_tables;

	/**
	 * Create the panel.
	 */
	public UI_TableState() {
		setLayout(new BorderLayout(0, 0));
		{
			pnlContainer = new JPanel();
			add(pnlContainer, BorderLayout.CENTER);
		}
		load();

	}

	public void reload() {
		// we remove all the created panels and call the load function again
		for (int i = pnlContainer.getComponents().length - 1; i >= 0; i++) {
			pnlContainer.remove(i);
		}

		load();
	}

	// we will show the state of all the tables in the created panel
	public void load() {
		table = new Table();
		table.readAll();

		pnls_tables = new JPanel[table.getTablesManager().get_tablesList().size()];
		for (int i = 0; i < pnls_tables.length; i++) {
			try {
				pnls_tables[i] = new UI_setTableState(table.getTablesManager().get_tablesList().get(i).getIdTable());
				((UI_setTableState) pnls_tables[i]).setIdTable(i + 1);
				pnls_tables[i].setBorder(new TitledBorder(null, "Table State: " + (i + 1), TitledBorder.LEADING,
						TitledBorder.TOP, null, null));

				pnlContainer.add(pnls_tables[i]);
				((UI_setTableState) pnls_tables[i]).initialState();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}