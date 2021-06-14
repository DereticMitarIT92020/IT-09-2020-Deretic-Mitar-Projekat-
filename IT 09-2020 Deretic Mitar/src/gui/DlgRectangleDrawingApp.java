package gui;
import gui.DlgOnlyNumbers;


import geometry.Point;
import geometry.PnlDrawing;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import gui.ColorChooser;

public class DlgRectangleDrawingApp extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected Color RectColor;
	protected Color RectColorBorder;
	protected boolean modifyMode;
	protected JTextField textField_2;
	protected JTextField textField_3;
	protected JTextField textField;
	protected JTextField textField_1;
	public boolean okPressed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangleDrawingApp dialog = new DlgRectangleDrawingApp(false);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	
	public DlgRectangleDrawingApp(boolean modifyMode) {
		setTitle("RECTANGLE (Drawing)");
		setBounds(100, 100, 526, 347);
		setModal(true);
		getContentPane().setLayout(new BorderLayout(0,0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblNewLabel = new JLabel("RECTANGLE");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				panel.add(lblNewLabel);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.SOUTH);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new GridLayout(0, 1, 0, 30));
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				panel_1.setLayout(new GridLayout(0, 2, 0, 0));
				{
					JPanel panel_2 = new JPanel();
					panel_1.add(panel_2);
			if (modifyMode == true) {
					panel_2.setLayout(new GridLayout(0, 1, 0, 0));
					{
						JLabel lblNewLabel_1 = new JLabel("Upper left X");
						lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
						panel_2.add(lblNewLabel_1);
					}
					{
						textField = new JTextField();
						panel_2.add(textField);
						textField.setColumns(10);
					}
					{
						JLabel lblNewLabel_2 = new JLabel("Upper left Y");
						lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
						panel_2.add(lblNewLabel_2);
					}
					{
						textField_1 = new JTextField();
						panel_2.add(textField_1);
						textField_1.setColumns(10);
					}
				
				
			      
			}
				}
			    }
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				panel_1.setLayout(new GridLayout(0, 1, 0, 0));
				{
					JLabel lblNewLabel_3 = new JLabel("Width");
					lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
					panel_1.add(lblNewLabel_3);
				}
				{
					textField_2 = new JTextField();
					textField_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
					panel_1.add(textField_2);
					textField_2.setColumns(10);
				}
				{
					JLabel lblNewLabel_4 = new JLabel("Height");
					lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
					panel_1.add(lblNewLabel_4);
				}
				{
					textField_3 = new JTextField();
					textField_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
					panel_1.add(textField_3);
					textField_3.setColumns(10);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						okPressed = true;
						
						//System.out.println(textField_2.getText());
						//System.out.println(textField_3.getText());
						
						try {
							
						int a = Integer.parseInt(textField_2.getText());
						int b = Integer.parseInt(textField_3.getText());
						
						if (modifyMode == true) {
							int c = Integer.parseInt(textField.getText());
							int d = Integer.parseInt(textField_1.getText());
						}
						
						dispose();
						
						} catch (Exception e1) {
							//System.out.println("Samo brojevi");
							DlgOnlyNumbers onlynumDialog = new DlgOnlyNumbers();
							onlynumDialog.setVisible(true);
						}
						
						
						
						
					}
				});
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
