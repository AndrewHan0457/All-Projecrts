package lab9;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerGui frame = new CustomerGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CustomerGui() {
		setResizable(true);
		setTitle("Customer Info");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setForeground(Color.ORANGE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		contentPane.add(lblName);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(32, 78, 53, 12);
		
		textField = new JTextField();
		contentPane.add(textField);
		textField.setBounds(117, 74, 116, 22);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		
		 System.out.println("Customer with Id "+ textField_2.getText()+" name "+ textField.getText()+" address "+textField_1.getText()+ " gender "+textField_3.getText() +"  is created");
		}
		});
		contentPane.add(btnNewButton);
		btnNewButton.setBounds(117, 207, 97, 25);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Customer is not created");
				
			}
			
		});
		btnCancel.setBounds(268, 207, 85, 25);
		contentPane.add(btnCancel);
		
		JLabel lblAddress = new JLabel("Address");
		contentPane.add(lblAddress);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddress.setBounds(29, 123, 56, 16);
		
		textField_1 = new JTextField();
		contentPane.add(textField_1);
		textField_1.setBounds(119, 113, 240, 22);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Id");
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(32, 32, 56, 16);
		
		textField_2 = new JTextField();
		textField_2.setBounds(117, 30, 53, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Gender");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(29, 166, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(117, 164, 90, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton1 = new JButton("OK");

		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			 System.out.println("Customer with Id "+ textField_2.getText()+" name "+ textField.getText()+" address "+textField_1.getText()+ " gender "+textField_3.getText() +"  is created");
			}
			});
		
	}
}

