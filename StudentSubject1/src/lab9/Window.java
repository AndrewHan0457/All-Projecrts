package lab9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Window  extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Window(){		
		 setTitle( "My First SubClass" );
		 setSize( 1500, 800 );
		 setLocation(150, 250 );
		 setVisible(true);
		 setDefaultCloseOperation( EXIT_ON_CLOSE );
		
		}

	public static void main(String [] args){
		
		Window win = new Window();
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5,2));
		win.setContentPane(panel);
		win.setVisible(true);
		 
		JTextField field = new JTextField(10);
		panel.add(field);
	    field.setFont(new Font(null, Font.PLAIN, 20));
		field.setText("A new string");
		field.setForeground(Color.red);
		field.setBackground(Color.yellow);
		 
		JButton btn = new JButton("Submit");
	    	btn.setFont(new Font(null, Font.PLAIN, 20));
	        panel.add(btn);
	        btn.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                System.out.println("Submit:" + field.getText());
	            }
	        });
	        
	        JTextArea textAera = new JTextArea(20, 50);
	        panel.add(textAera, BorderLayout.CENTER);
	        textAera.setLineWrap(true);
	        textAera.setText("hello0\n");
	        textAera.append("hello1\n");
	        textAera.append("hello2\n");
	        textAera.append("hello3\n");
	        textAera.setVisible(true);
	        
	        JScrollPane sText = new JScrollPane(textAera);
	        panel.add(sText);
		}
}
