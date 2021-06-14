package gui;

import java.awt.EventQueue;


import gui.DlgDeleteDrawingApp;
import gui.DlgPointDrawingApp;
import gui.DlgLineDrawingApp;
import gui.DlgRectangleDrawingApp;
import gui.DlgCircleDrawingApp;
import gui.DlgDonutDrawingApp;


import javax.swing.JFrame;

import geometry.Point;
import geometry.Line;
import geometry.Rectangle;
import geometry.Circle;
import geometry.Donut;
import geometry.PnlDrawing;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import geometry.PnlDrawing;

public class DrawingApp {

	private JFrame frmDereticMitarIt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private boolean modifyMode = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawingApp window = new DrawingApp();
					window.frmDereticMitarIt.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DrawingApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	int pointselected = 0;
	int lineselected = 0;
	int rectselected = 0;
	int circleselected = 0;
	int donutselected = 0;
	int xline1 = 0;
	int yline1 = 0;
	int timesClicked = 0;
	int selectselected = 0;
	int modifyselected = 0;
	int whichclassselected = 0;
	int showpointx1 = 0;
	int showpointy1 = 0;
	int showpointx2 = 0;
	int showpointy2 = 0;
	int showdimension1 = 0;
	int showdimension2 = 0;
	int rectselected2 = 0;
	int pointselected2 = 0;
	int lineselected2 = 0;
	int circleselected2 = 0;
	int donutselected2 = 0;
	
	DlgDeleteDrawingApp deleteObj = new DlgDeleteDrawingApp();
	
	//DIALOGS FOR MODIFICATION
	
	DlgPointDrawingApp pointDlg = new DlgPointDrawingApp();
	DlgLineDrawingApp lineDlg = new DlgLineDrawingApp();
	DlgRectangleDrawingApp rectDlg = new DlgRectangleDrawingApp(true);
	DlgCircleDrawingApp circleDlg = new DlgCircleDrawingApp(true);
	DlgDonutDrawingApp donutDlg = new DlgDonutDrawingApp(true);
	
	
	//DIALOGS FOR CREATION
	DlgRectangleDrawingApp rectangdlg = new DlgRectangleDrawingApp(false);
	DlgCircleDrawingApp circledlg = new DlgCircleDrawingApp(false);
	DlgDonutDrawingApp donutdlg = new DlgDonutDrawingApp(false);
	
	private void initialize() {
		frmDereticMitarIt = new JFrame();
		frmDereticMitarIt.setTitle("DRAWING (Deretic Mitar IT 09-2020)");
		frmDereticMitarIt.setBounds(100, 100, 949, 507);
		frmDereticMitarIt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDereticMitarIt.getContentPane().setLayout(new BorderLayout(0, 0));
		
	
		
		JPanel panel = new JPanel();
		frmDereticMitarIt.getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("POINT");
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DlgPointDrawingApp pointdlg = new DlgPointDrawingApp();
				//pointdlg.setVisible(true);
				//System.out.println(tglbtnNewToggleButton.value());
			    pointselected = 1;
			    lineselected = 0;
				rectselected = 0;
				circleselected = 0;
				donutselected = 0;
				timesClicked = 0;
				selectselected = 0;
			    
				
			}
		});
		buttonGroup.add(tglbtnNewToggleButton);
		tglbtnNewToggleButton.setForeground(Color.WHITE);
		tglbtnNewToggleButton.setBackground(new Color(220, 20, 60));
		tglbtnNewToggleButton.setFont(new Font("Tahoma", Font.BOLD, 19));
		panel.add(tglbtnNewToggleButton);
		
		JToggleButton tglbtnNewToggleButton_2 = new JToggleButton("LINE");
		tglbtnNewToggleButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DlgLineDrawingApp linedlg = new DlgLineDrawingApp();
				//linedlg.setVisible(true);
				lineselected = 1;
				pointselected = 0;
				rectselected = 0;
				circleselected = 0;
				donutselected = 0;
				timesClicked = 0;
				selectselected = 0;
			}
		});
		buttonGroup.add(tglbtnNewToggleButton_2);
		tglbtnNewToggleButton_2.setForeground(Color.WHITE);
		tglbtnNewToggleButton_2.setBackground(new Color(220, 20, 60));
		tglbtnNewToggleButton_2.setFont(new Font("Tahoma", Font.BOLD, 19));
		panel.add(tglbtnNewToggleButton_2);
		
		JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("RECTANGLE");
		tglbtnNewToggleButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DlgRectangleDrawingApp rectangdlg = new DlgRectangleDrawingApp();
				//rectangdlg.setVisible(true);
				lineselected = 0;
				pointselected = 0;
				rectselected = 1;
				circleselected = 0;
				donutselected = 0;
				timesClicked = 0;
				selectselected = 0;
				
			}
		});
		buttonGroup.add(tglbtnNewToggleButton_1);
		tglbtnNewToggleButton_1.setForeground(Color.WHITE);
		tglbtnNewToggleButton_1.setBackground(new Color(220, 20, 60));
		tglbtnNewToggleButton_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		panel.add(tglbtnNewToggleButton_1);
		
		JToggleButton tglbtnNewToggleButton_3 = new JToggleButton("CIRCLE");
		tglbtnNewToggleButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DlgCircleDrawingApp circledlg = new DlgCircleDrawingApp();
				//circledlg.setVisible(true);
				lineselected = 0;
				pointselected = 0;
				rectselected = 0;
				circleselected = 1;
				donutselected = 0;
				timesClicked = 0;
				selectselected = 0;
			}
		});
		buttonGroup.add(tglbtnNewToggleButton_3);
		tglbtnNewToggleButton_3.setForeground(Color.WHITE);
		tglbtnNewToggleButton_3.setBackground(new Color(220, 20, 60));
		tglbtnNewToggleButton_3.setFont(new Font("Tahoma", Font.BOLD, 19));
		panel.add(tglbtnNewToggleButton_3);
		
		JToggleButton tglbtnNewToggleButton_4 = new JToggleButton("DONUT");
		tglbtnNewToggleButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DlgDonutDrawingApp donutdlg = new DlgDonutDrawingApp();
				//donutdlg.setVisible(true);
				
				lineselected = 0;
				pointselected = 0;
				rectselected = 0;
				circleselected = 0;
				donutselected = 1;
				timesClicked = 0;
				selectselected = 0;
			}
		});
		buttonGroup.add(tglbtnNewToggleButton_4);
		tglbtnNewToggleButton_4.setForeground(Color.WHITE);
		tglbtnNewToggleButton_4.setBackground(new Color(220, 20, 60));
		tglbtnNewToggleButton_4.setFont(new Font("Tahoma", Font.BOLD, 19));
		panel.add(tglbtnNewToggleButton_4);
		
		JPanel panel_1 = new JPanel();
		frmDereticMitarIt.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblNewLabel = new JLabel("DRAWING");
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel_1.add(lblNewLabel);
		
		JToggleButton tglbtnNewToggleButton_5 = new JToggleButton("SELECT");
		tglbtnNewToggleButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pointselected = 0;
			    lineselected = 0;
				rectselected = 0;
				circleselected = 0;
				donutselected = 0;
				timesClicked = 0;
				selectselected = 1;
			}
		});
		buttonGroup.add(tglbtnNewToggleButton_5);
		tglbtnNewToggleButton_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		panel_1.add(tglbtnNewToggleButton_5);
		
		JButton btnNewButton_5 = new JButton("MODIFY");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modifyMode = true;
				
				switch(whichclassselected) {
					case 0:
						showpointx1 = 0;
						showpointy1 = 0;
						showpointx2 = 0;
					    showpointy2 = 0;
						showdimension1 = 0;
						showdimension2 = 0;
						break;
					case 1:
						
						String s1 = String.valueOf(showpointx1);
						String s2 = String.valueOf(showpointy1);
						pointDlg.textField.setText(s1);
						pointDlg.textField_1.setText(s2);
						pointselected2 = 1;
						pointDlg.setVisible(true);
						break;
					case 2:
						
						String s3 = String.valueOf(showpointx1);
						String s4 = String.valueOf(showpointy1);
						String s5 = String.valueOf(showpointx2);
						String s6 = String.valueOf(showpointy2);
						lineDlg.textField.setText(s3);
						lineDlg.textField_1.setText(s4);
						lineDlg.textField_2.setText(s5);
						lineDlg.textField_3.setText(s6);
						lineselected2 = 1;
						lineDlg.setVisible(true);
						break;
					case 3:
						String s7 = String.valueOf(showpointx1);
						String s8 = String.valueOf(showpointy1);
						String s9 = String.valueOf(showdimension1);
						String s10 = String.valueOf(showdimension2);
						rectDlg.textField.setText(s7);
						rectDlg.textField_1.setText(s8);
						rectDlg.textField_2.setText(s9);
						rectDlg.textField_3.setText(s10);
						rectselected2 = 1;
						rectDlg.setVisible(true);
						
						break;
					case 4:
						
						String s11 = String.valueOf(showdimension1);
						String s12 = String.valueOf(showpointx1);
						String s13 = String.valueOf(showpointy1);
						circleDlg.textField_2.setText(s11);
					    circleDlg.textField.setText(s12);
						circleDlg.textField_1.setText(s13);
						circleselected2 = 1;
						circleDlg.setVisible(true);
						break;
					case 5:
						
						String s14 = String.valueOf(showpointx1);
						String s15 = String.valueOf(showpointy1);
						String s16 = String.valueOf(showdimension1);
						String s17 = String.valueOf(showdimension2);
						donutDlg.textField.setText(s14);
						donutDlg.textField_1.setText(s15);
						donutDlg.textField_2.setText(s16);
						donutDlg.textField_3.setText(s17);
						donutselected2 = 1;
						donutDlg.setVisible(true);
						break;
					default:
						showpointx1 = 0;
						showpointy1 = 0;
						showpointx2 = 0;
					    showpointy2 = 0;
						showdimension1 = 0;
						showdimension2 = 0;
						break;
					}
				
				
				
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("DELETE");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    deleteObj.setVisible(true);
			    
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		panel_1.add(btnNewButton_6);
		
		PnlDrawing drawing = new PnlDrawing();
		drawing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				if (pointselected == 1) {
				System.out.println(e.getX() + ","  + e.getY());
				drawing.addPoint(e.getX(), e.getY());
				}
				if (pointselected2 == 1) {
					int a = Integer.parseInt(pointDlg.textField.getText());
					int b = Integer.parseInt(pointDlg.textField.getText());
					drawing.modifySelectedShape(a, b, a, b);
					pointselected2 = 0;
					pointselected = 0;
				}
				
			
				
				if (lineselected == 1) {
					if (timesClicked == 0) {
					xline1 = e.getX();
					yline1 = e.getY();
					timesClicked = 1;
					} else {
						drawing.addLine(xline1, yline1, e.getX(), e.getY());	
						timesClicked = 0;
					}
				}
				
				if (lineselected2 == 1) {
					int a = Integer.parseInt(lineDlg.textField.getText());
					int b = Integer.parseInt(lineDlg.textField_1.getText());
					int c = Integer.parseInt(lineDlg.textField_2.getText());
					int d = Integer.parseInt(lineDlg.textField_3.getText());
					
					drawing.modifySelectedShape(a, b, c, d);
					lineselected2 = 0;
				}
				
				if (rectselected == 1 || rectselected2 == 1) {
					
					if (modifyMode == false) {
					
					Point rectP = new Point(e.getX(), e.getY());
					
					
					rectangdlg.setVisible(true);
					
					
					try {
						
						
						
						int a = Integer.parseInt(rectangdlg.textField_2.getText());
						int b = Integer.parseInt(rectangdlg.textField_3.getText());
						
						if (a >= 0 && b >= 0) {
						
						drawing.addRect(rectP, a, b);
						
						rectangdlg.dispose();
						
						} else {
							DlgOnlyNumbers onlynumDialog = new DlgOnlyNumbers();
							onlynumDialog.setVisible(true);
						}
						
						} catch (Exception e1) {
							//System.out.println("Samo brojevi");
							DlgOnlyNumbers onlynumDialog = new DlgOnlyNumbers();
							onlynumDialog.setVisible(true);
						}
					
					} else {
						
						try {
						
						int a = Integer.parseInt(rectDlg.textField.getText());
						int b = Integer.parseInt(rectDlg.textField_1.getText());
						int c = Integer.parseInt(rectDlg.textField_2.getText());
						int d = Integer.parseInt(rectDlg.textField_3.getText());
						
						if (c > 0 && d > 0) {
						drawing.modifySelectedShape(a, b, c, d);
						modifyMode = false;
						rectselected2 = 0;
						} else {
							modifyMode = false;
							rectselected2 = 0;
							DlgOnlyNumbers onlynumDialog = new DlgOnlyNumbers();
							onlynumDialog.setVisible(true);
						}
						} catch (Exception e1) {
							DlgOnlyNumbers onlynumDialog = new DlgOnlyNumbers();
							onlynumDialog.setVisible(true);
						}
 						
						
						
					}
				
				}
				
                if (circleselected == 1 || circleselected2 == 1) {
                	
                	if (modifyMode == false) {
					
					Point circleC = new Point(e.getX(), e.getY());
					
					
					circledlg.setVisible(true);
					
					
					try {
						
						int a = Integer.parseInt(circledlg.textField_2.getText());
						
						if (a > 0) {
						
						drawing.addCircle(circleC, a);
						
						circledlg.dispose();
						} else {
							DlgOnlyNumbers onlynumDialog = new DlgOnlyNumbers();
							onlynumDialog.setVisible(true);
						}
						
						} catch (Exception e1) {
							DlgOnlyNumbers onlynumDialog = new DlgOnlyNumbers();
							onlynumDialog.setVisible(true);
						}
					
                	} else {
                		
                		try {
                		
                		int a = Integer.parseInt(circleDlg.textField.getText());
						int b = Integer.parseInt(circleDlg.textField_1.getText());
						int c = Integer.parseInt(circleDlg.textField_2.getText());
					if (c > 0) {
						drawing.modifySelectedShape(a, b, c, c);
						modifyMode = false;
						circleselected2 = 0;
					} else {
						modifyMode = false;
						circleselected2 = 0;
						DlgOnlyNumbers onlynumDialog = new DlgOnlyNumbers();
						onlynumDialog.setVisible(true);
					}
                		} catch (Exception e1) {
                			DlgOnlyNumbers onlynumDialog = new DlgOnlyNumbers();
							onlynumDialog.setVisible(true);
                		}
						
						
                	}
				
				}
                
                   if (donutselected == 1 || donutselected2 == 1) {
                	   
                	if (modifyMode == false) {
					
					Point donutC = new Point(e.getX(), e.getY());
					
					
					donutdlg.setVisible(true);
					
					
					try {
						
						int a = Integer.parseInt(donutdlg.textField_2.getText());
						int b = Integer.parseInt(donutdlg.textField_3.getText());
						
						if (a > 0 && b > 0 && a>b) {
						
						drawing.addDonut(donutC, a, b);
						
						donutdlg.dispose();
						} else {
							DlgOnlyNumbers onlynumDialog = new DlgOnlyNumbers();
							onlynumDialog.setVisible(true);
						}
						
						} catch (Exception e1) {
							DlgOnlyNumbers onlynumDialog = new DlgOnlyNumbers();
							onlynumDialog.setVisible(true);
						}
					
                	} else {
                		try {
                		int a = Integer.parseInt(donutDlg.textField.getText());
						int b = Integer.parseInt(donutDlg.textField_1.getText());
						int c = Integer.parseInt(donutDlg.textField_2.getText());
						int d = Integer.parseInt(donutDlg.textField_3.getText());
						
						if (c > 0 && d > 0 && c>d) {
						drawing.modifySelectedShape(a, b, c, d);
						modifyMode = false;
						donutselected2 = 0;
						} else {
							modifyMode = false;
							donutselected2 = 0;
							DlgOnlyNumbers onlynumDialog = new DlgOnlyNumbers();
							onlynumDialog.setVisible(true);
						}
						
                		} catch (Exception e1) {
							DlgOnlyNumbers onlynumDialog = new DlgOnlyNumbers();
							onlynumDialog.setVisible(true);
						}
						
						
                	}
				
				}
                   
                   if (selectselected == 1) {
                	   
   					
   					drawing.checkContain(e.getX(), e.getY());
   					
   					frmDereticMitarIt.repaint();
   					
   					//frmDereticMitarIt.setVisible(false);
   					//frmDereticMitarIt.setVisible(true);
   					
   				   }
                   
      					
      					switch(drawing.checkSelectedObjClass()) {
      					case 0:
      						whichclassselected = 0;
      						break;
      					case 1:
      						whichclassselected = 1;
      						showpointx1 = drawing.showPoint.getX();
      						showpointy1 = drawing.showPoint.getY();
      						break;
      					case 2:
      						whichclassselected = 2;
      						showpointx1 = drawing.showPoint.getX();
      						showpointy1 = drawing.showPoint.getY();
      						showpointx2 = drawing.showPoint2.getX();
      						showpointy2 = drawing.showPoint2.getY();
      						break;
      					case 3:
      						whichclassselected = 3;
      						showpointx1 = drawing.showPoint.getX();
      						showpointy1 = drawing.showPoint.getY();
      						showdimension1 = drawing.showDimension1;
      						showdimension2 = drawing.showDimension2;
      						break;
      					case 4:
      						whichclassselected = 4;
      						showpointx1 = drawing.showPoint.getX();
      						showpointy1 = drawing.showPoint.getY();
      						showdimension1 = drawing.showDimension1;
      						break;
      					case 5:
      						whichclassselected = 5;
      						showpointx1 = drawing.showPoint.getX();
      						showpointy1 = drawing.showPoint.getY();
      						showdimension1 = drawing.showDimension1;
      						showdimension2 = drawing.showDimension2;
      						break;
      					default:
      						whichclassselected = 0;
      						break;
      					}
      					
      					if (deleteObj.wantDelete == true) {
      						drawing.deleteSelectedShape();
      						deleteObj.wantDelete = false;
      						frmDereticMitarIt.repaint();
      					}
      					
				
			}

			
		});
		frmDereticMitarIt.getContentPane().add(drawing, BorderLayout.CENTER);
	}

}
