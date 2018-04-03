import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		 ActionListener a1=new ActionListener(){
	            public void actionPerformed(ActionEvent ae)
	            {
	               new account_form().setVisible(true); //create the account form and make it visible
	            };
		 };
		 ActionListener a2=new ActionListener(){
	            public void actionPerformed(ActionEvent ae)
	            {
		            try {
						new cus_query().setVisible(true); //create the customer query and make it visisble
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            };
		 };
		 ActionListener a3=new ActionListener(){
	            public void actionPerformed(ActionEvent ae)
	            {
		          new Account_deposit_form().setVisible(true); //create the account form and make it visible
	            };
		 };
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		setTitle("Master Menu");
		JButton button = new JButton("Account Form");
		button.addActionListener(a1);
		menuBar.add(button);
		
		JButton btnNewButton = new JButton("Customer Query Form");
		menuBar.add(btnNewButton);
		btnNewButton.addActionListener(a2);
		JButton btnNewButton_1 = new JButton("Account Deposit Form");
		btnNewButton_1.addActionListener(a3);
		menuBar.add(btnNewButton_1);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		 }	
}