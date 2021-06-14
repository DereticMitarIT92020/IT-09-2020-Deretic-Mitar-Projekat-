package gui;

import java.awt.BorderLayout;
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

public class DlgLineDrawingApp extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JTextField textField;
	protected JTextField textField_1;
	protected JTextField textField_2;
	protected JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLineDrawingApp dialog = new DlgLineDrawingApp();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLineDrawingApp() {
		setTitle("LINE (Drawing)");
		setBounds(100, 100, 505, 345);
		setModal(true);
		getContentPane().setLayout(new BorderLayout(0,100));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblNewLabel = new JLabel("LINE");
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
			panel.setLayout(new GridLayout(0, 2, 0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				panel_1.setLayout(new GridLayout(0, 1, 0, 0));
				{
					JLabel lblNewLabel_1 = new JLabel("Start point X");
					lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
					panel_1.add(lblNewLabel_1);
				}
				{
					textField = new JTextField();
					textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
					panel_1.add(textField);
					textField.setColumns(10);
				}
				{
					JLabel lblNewLabel_2 = new JLabel("Start point Y");
					lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
					panel_1.add(lblNewLabel_2);
				}
				{
					textField_1 = new JTextField();
					textField_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
					panel_1.add(textField_1);
					textField_1.setColumns(10);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				panel_1.setLayout(new GridLayout(0, 1, 0, 0));
				{
					JLabel lblNewLabel_3 = new JLabel("End point X");
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
					JLabel lblNewLabel_4 = new JLabel("End point Y");
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
						try {
							int a = Integer.parseInt(textField.getText());
							int b = Integer.parseInt(textField_1.getText());
							int c = Integer.parseInt(textField_2.getText());
							int d = Integer.parseInt(textField_3.getText());
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
