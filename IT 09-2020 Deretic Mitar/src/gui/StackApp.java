package gui;


import java.awt.EventQueue;

import geometry.Point;
import geometry.Rectangle;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

import gui.DlgStackApp;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

public class StackApp {

	private JFrame frmStackdereticMitar;
	private JList rectList;
	private DefaultListModel<String> rectModel = new DefaultListModel<String>();
	
	ArrayList valList = new ArrayList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StackApp window = new StackApp();
					window.frmStackdereticMitar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StackApp() {
		initialize();
	}
	
	
	private void initialize() {
		frmStackdereticMitar = new JFrame();
		frmStackdereticMitar.setTitle("STACK (Deretic Mitar IT 09-2020)");
		frmStackdereticMitar.setBounds(100, 100, 831, 448);
		frmStackdereticMitar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStackdereticMitar.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(139, 0, 139));
		frmStackdereticMitar.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("RECTANGLE STACK");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 27));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(139, 0, 139));
		frmStackdereticMitar.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("ADD RECTANGLE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				DlgStackApp addRectDlg = new DlgStackApp();
				addRectDlg.setVisible(true);
				
				try {
					int a = Integer.parseInt(addRectDlg.textField.getText());
					int b = Integer.parseInt(addRectDlg.textField_1.getText());
					int c = Integer.parseInt(addRectDlg.textField_2.getText());
					int d = Integer.parseInt(addRectDlg.textField_3.getText());
					if (c > 0 && d > 0) {
						//Ubaci u listu
						rectModel.add(0,new Rectangle(new Point(a,b),c,d).toString());
						valList.add(a);
						valList.add(b);
						valList.add(c);
						valList.add(d);
						
						
					} else {
						DlgErrorStackSortApps errorDlg = new  DlgErrorStackSortApps();
						errorDlg.setVisible(true);
					}
					
					} catch (Exception e1) {
						 DlgErrorStackSortApps errorDlg = new  DlgErrorStackSortApps();
						 errorDlg.setVisible(true);
					}
				
				
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setMargin(new Insets(15, 15, 15, 15));
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DELETE RECTANGLE");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DlgStackApp remRectDlg = new DlgStackApp();
				
				
				String height = String.valueOf(valList.get(valList.size() - 1));
				valList.remove(valList.size() - 1);
				String width = String.valueOf(valList.get(valList.size() - 1));
				valList.remove(valList.size() - 1);
				String y = String.valueOf(valList.get(valList.size() - 1));
				valList.remove(valList.size() - 1);
				String x = String.valueOf(valList.get(valList.size() - 1));
				valList.remove(valList.size() - 1);
				
				
				remRectDlg.textField.setText(x);
				remRectDlg.textField_1.setText(y);
				remRectDlg.textField_2.setText(width);
				remRectDlg.textField_3.setText(height);
				remRectDlg.setVisible(true);
				 
				rectModel.remove(0);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1 .setMargin(new Insets(15, 15, 15, 15));
		panel_1.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		rectList = new JList();
		scrollPane.setViewportView(rectList);
		rectList.setModel(rectModel);
		frmStackdereticMitar.getContentPane().add(scrollPane, BorderLayout.CENTER);
	}

}
