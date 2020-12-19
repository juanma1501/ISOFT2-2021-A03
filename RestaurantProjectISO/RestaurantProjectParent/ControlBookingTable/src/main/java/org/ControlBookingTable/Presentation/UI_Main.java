package org.ControlBookingTable.Presentation;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;

public class UI_Main {

	private JPanel tabReservaMesas;
	private JFrame frame;
	private UI_seeTablesConf paneTables;
	private JTabbedPane tabbedPane;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_Main window = new UI_Main();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 916, 618);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		panel = new JPanel();
		tabbedPane.addTab("Test", null, panel, null);
		{
			paneTables = new UI_seeTablesConf();
			GridBagConstraints gbc_panel_VerConfMesas = new GridBagConstraints();
			gbc_panel_VerConfMesas.gridwidth = 2;
			gbc_panel_VerConfMesas.insets = new Insets(0, 0, 5, 0);
			gbc_panel_VerConfMesas.fill = GridBagConstraints.BOTH;
			gbc_panel_VerConfMesas.gridx = 3;
			gbc_panel_VerConfMesas.gridy = 1;
			tabReservaMesas.add(paneTables, gbc_panel_VerConfMesas);
		}
	}
}