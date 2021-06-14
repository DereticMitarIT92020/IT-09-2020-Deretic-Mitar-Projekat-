package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgStackApp extends JDialog {

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
			DlgStackApp dialog = new DlgStackApp();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgStackApp() {
		setModal(true);
		setBounds(100, 100, 579, 386);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(9, 0, 0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			{
				JLabel lblNewLabel = new JLabel("RECTANGLE ");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
				panel.add(lblNewLabel);
			}
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Upper left X");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblNewLabel_1);
		}
		{
			textField = new JTextField();
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Upper left Y");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblNewLabel_2);
		}
		{
			textField_1 = new JTextField();
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Width");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblNewLabel_3);
		}
		{
			textField_2 = new JTextField();
			contentPanel.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Height");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblNewLabel_4);
		}
		{
			textField_3 = new JTextField();
			contentPanel.add(textField_3);
			textField_3.setColumns(10);
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
						if (c > 0 && d > 0) {
							//Ubaci u listu
							
							dispose();
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
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
