package gui;

import java.awt.EventQueue;

import geometry.Point;
import geometry.Rectangle;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.GridLayout;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SortApp {

	private JFrame frmDrawingdereticMitar;
	private JList rectList;
	private DefaultListModel<String> rectModel = new DefaultListModel<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortApp window = new SortApp();
					window.frmDrawingdereticMitar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SortApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	HashMap<Integer, String> rectAreaPair = new HashMap<Integer, String>();
	
	private void initialize() {
		frmDrawingdereticMitar = new JFrame();
		frmDrawingdereticMitar.setTitle("SORT (Deretic Mitar IT 09-2020)");
		frmDrawingdereticMitar.setBounds(100, 100, 875, 475);
		frmDrawingdereticMitar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDrawingdereticMitar.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		frmDrawingdereticMitar.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("SORTED LIST");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		frmDrawingdereticMitar.getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton = new JButton("ADD RECTANGLE");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DlgStackApp addRectDlg = new DlgStackApp();
				addRectDlg.setVisible(true);
				
				try {
					int a = Integer.parseInt(addRectDlg.textField.getText());
					int b = Integer.parseInt(addRectDlg.textField_1.getText());
					int c = Integer.parseInt(addRectDlg.textField_2.getText());
					int d = Integer.parseInt(addRectDlg.textField_3.getText());
					if (c > 0 && d > 0) {
						//Ubaci u listu Bubble sort
						
						
						int area = c * d;
						Rectangle rect = new Rectangle(new Point(a,b),c,d);
						rectAreaPair.put(area, rect.toString());
						ArrayList<Integer> mapAreas = new ArrayList<>(rectAreaPair.keySet());
						Object[] areas = mapAreas.toArray();
						
						Arrays.sort(areas);
						
						rectModel.removeAllElements();
						
						for (int i = 0; i < mapAreas.size(); i++) {
						rectModel.addElement(rectAreaPair.get(areas[i]));
						} 
						
						//rectModel.addElement(new Rectangle(new Point(a,b),c,d).toString());
						
						
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
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 19));
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("REMOVE RECTANGLES");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
                
				rectModel.removeAllElements();
				rectAreaPair.clear();
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		frmDrawingdereticMitar.getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JPanel panel_3 = new JPanel();
		frmDrawingdereticMitar.getContentPane().add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		rectList = new JList();
		scrollPane.setViewportView(rectList);
		rectList.setModel(rectModel);
		panel_3.add(scrollPane);
	}

}
