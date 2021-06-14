package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgPointDrawingApp extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JTextField textField;
	protected JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPointDrawingApp dialog = new DlgPointDrawingApp();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPointDrawingApp() {
		setTitle("POINT Drawing");
		setBounds(100, 100, 509, 365);
		setModal(true);
		getContentPane().setLayout(new BorderLayout(0,100));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblNewLabel = new JLabel("POINT");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				panel.add(lblNewLabel);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			
			panel.setLayout(new GridLayout(0, 1, 0, 0));
			{
				JLabel lblNewLabel_1 = new JLabel("X Coordinate");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
				panel.add(lblNewLabel_1);
			}
			{
				textField = new JTextField();
				textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
				panel.add(textField);
				textField.setColumns(10);
				
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Y Coordinate");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
				panel.add(lblNewLabel_2);
			}
			{
				textField_1 = new JTextField();
				textField_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
				panel.add(textField_1);
				textField_1.setColumns(10);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.SOUTH);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try {
						int a = Integer.parseInt(textField.getText());
						int b = Integer.parseInt(textField_1.getText());
						dispose();
						} catch (Exception e1) {
							DlgOnlyNumbers numDlg = new DlgOnlyNumbers();
							numDlg.setVisible(true);
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
