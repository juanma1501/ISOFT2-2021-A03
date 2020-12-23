package org.AuxiliarMain.Presentation;

import org.Authentication.Presentation.UI_Authentication;
import org.ControlStatesOfTables.Presentation.UI_TableState;
import org.ControlBookingTable.Presentation.UI_seeTablesConf;
import org.ControlBookingTable.Presentation.UI_seeBooking;
import org.ControlBookingTable.Presentation.UI_AssignTables;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI_Main {

	private JFrame frm;
	private JTabbedPane tabbedPane;
	private JPanel tabTableBooking;
	private JPanel tabStates;
	private UI_TableState pnlStates;
	private UI_seeTablesConf pnlSeeTableConf;
	private UI_seeBooking pnlSeeBooking;
	private UI_AssignTables pnlAssignTable;
	private JPanel tabAuthentication;
	private UI_Authentication pnlAuthentication;
	private JButton btnEnter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_Main window = new UI_Main();
					window.frm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI_Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frm = new JFrame();

		frm.setBounds(200, 200, 1200, 700);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		{
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.addMouseListener(new TabbedPaneMouseListener());
			frm.getContentPane().add(tabbedPane, BorderLayout.CENTER);
			{
				tabAuthentication = new JPanel();
				tabbedPane.addTab("Autenticacion", null, tabAuthentication, null);
				GridBagLayout gbl_tabAuthentication = new GridBagLayout();
				gbl_tabAuthentication.columnWidths = new int[] { 411, 405, 0, 0 };
				gbl_tabAuthentication.rowHeights = new int[] { 83, 0, 0, 0 };
				gbl_tabAuthentication.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
				gbl_tabAuthentication.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
				tabAuthentication.setLayout(gbl_tabAuthentication);
				{
					pnlAuthentication = new UI_Authentication();
					GridBagConstraints gbc_pnl = new GridBagConstraints();
					gbc_pnl.insets = new Insets(0, 0, 5, 5);
					gbc_pnl.fill = GridBagConstraints.BOTH;
					gbc_pnl.gridx = 1;
					gbc_pnl.gridy = 1;
					tabAuthentication.add(pnlAuthentication, gbc_pnl);
				}
				{
					btnEnter = new JButton("Enter");
					btnEnter.addActionListener(new BtnEnterActionListener());
					GridBagConstraints gbc_btnEnter = new GridBagConstraints();
					gbc_btnEnter.insets = new Insets(0, 0, 0, 5);
					gbc_btnEnter.gridx = 1;
					gbc_btnEnter.gridy = 2;
					tabAuthentication.add(btnEnter, gbc_btnEnter);
				}

			}
			{
				tabTableBooking = new JPanel();
				tabbedPane.addTab("Booking", null, tabTableBooking, null);
				tabbedPane.setEnabledAt(1, false);
				GridBagLayout gbl_tabTableBooking = new GridBagLayout();
				gbl_tabTableBooking.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
				gbl_tabTableBooking.rowHeights = new int[] { 0, 0, 0, 0, 0 };
				gbl_tabTableBooking.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
				gbl_tabTableBooking.rowWeights = new double[] { 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
				tabTableBooking.setLayout(gbl_tabTableBooking);

				{
					pnlSeeTableConf = new UI_seeTablesConf();
					GridBagConstraints gbc_pnlSeeTableConf = new GridBagConstraints();
					gbc_pnlSeeTableConf.gridwidth = 2;
					gbc_pnlSeeTableConf.insets = new Insets(0, 0, 5, 0);
					gbc_pnlSeeTableConf.fill = GridBagConstraints.BOTH;
					gbc_pnlSeeTableConf.gridx = 3;
					gbc_pnlSeeTableConf.gridy = 1;
					tabTableBooking.add(pnlSeeTableConf, gbc_pnlSeeTableConf);
				}
				{
					pnlSeeBooking = new UI_seeBooking();
					GridBagConstraints gbc_pnlSeeBooking = new GridBagConstraints();
					gbc_pnlSeeBooking.gridwidth = 4;
					gbc_pnlSeeBooking.fill = GridBagConstraints.BOTH;
					gbc_pnlSeeBooking.gridx = 1;
					gbc_pnlSeeBooking.gridy = 3;
					tabTableBooking.add(pnlSeeBooking, gbc_pnlSeeBooking);
				}
				{
					pnlAssignTable = new UI_AssignTables(pnlSeeBooking);
					GridBagConstraints gbc_pnlAssignTable = new GridBagConstraints();
					gbc_pnlAssignTable.insets = new Insets(0, 0, 5, 5);
					gbc_pnlAssignTable.fill = GridBagConstraints.BOTH;
					gbc_pnlAssignTable.gridx = 1;
					gbc_pnlAssignTable.gridy = 1;
					tabTableBooking.add(pnlAssignTable, gbc_pnlAssignTable);
				}
			}
			{
				tabStates = new JPanel();
				tabbedPane.addTab("States", null, tabStates, null);
				tabbedPane.setEnabledAt(2, false);
				tabStates.setLayout(new BorderLayout(0, 0));
				{
					pnlStates = new UI_TableState();
					tabStates.add(pnlStates, BorderLayout.CENTER);
				}
			}
		}
	}

	private class TabbedPaneMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {

			if (tabbedPane.getSelectedIndex() == 1) {
				pnlSeeTableConf.loadTables();
			} else if (tabbedPane.getSelectedIndex() == 2) {
				pnlStates.reload();
			}

		}

	}

	private class BtnEnterActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (pnlAuthentication.accept()) {
				tabbedPane.setEnabledAt(2, true);
				tabbedPane.setEnabledAt(1, true);
				tabbedPane.setEnabledAt(0, false);
				Component[] components = pnlAuthentication.getComponents();
				for (int i = 0; i < components.length; i++) {
					components[i].setEnabled(false);
				}
				pnlAuthentication.setEnabled(false);
				btnEnter.setEnabled(false);

			} else {

			}

		}
	}
}