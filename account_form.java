import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class account_form extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JMenuBar menuBar;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private String[] queryresult;
    static int firstAccountNum=10000;
    static int currentAccount=0;
    static int lastAccounNum=10014;
	static Connection con=SQLdriver.getConnection();

	/**
	 * Launch the application.
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
    	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					account_form frame = new account_form();
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
	public account_form() {
		ActionListener a1=new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
            	 currentAccount=10000;
                 try {
					setQueryresult(SQLquery(currentAccount));
					setText();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
      
				
            }	
	 };
	 ActionListener a2=new ActionListener(){
         public void actionPerformed(ActionEvent ae)
         {
        	 if(currentAccount==10000){
        		 currentAccount=10000;
        	 }
        	 else{
        	 currentAccount=currentAccount-1;
        	 }
             try {
				setQueryresult(SQLquery(currentAccount));
				setText();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            
				
         }	
	 };
	 ActionListener a3=new ActionListener(){
         public void actionPerformed(ActionEvent ae)
         {
        	 if(currentAccount<10014){
        		 currentAccount=currentAccount+1;
        	 }
        	 else{
        		 currentAccount=10014;
        	 }
              try {
				setQueryresult(SQLquery(currentAccount));
				setText();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
         }	
	 };
	 ActionListener a4=new ActionListener(){
         public void actionPerformed(ActionEvent ae)
         {
        	  currentAccount=10014;
              try {
				setQueryresult(SQLquery(currentAccount));
				setText();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
         }	
	 };
	 
		setTitle("Account Form");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500,500,480,450);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		btnNewButton = new JButton("First Account");
		btnNewButton.setPreferredSize(new Dimension(60, 23));
		menuBar.add(btnNewButton);
		btnNewButton.addActionListener(a1);
		
		btnNewButton_1 = new JButton("Previous Account");
		btnNewButton.setPreferredSize(new Dimension(50, 23));
        btnNewButton_1.addActionListener(a2);
		menuBar.add(btnNewButton_1);
		
		btnNewButton_3 = new JButton("Next Account");
		btnNewButton_3.addActionListener(a3);
		btnNewButton.setPreferredSize(new Dimension(50, 23));

		menuBar.add(btnNewButton_3);
		
		btnNewButton_2 = new JButton("Last Account");
		btnNewButton_2.addActionListener(a4);
		btnNewButton.setPreferredSize(new Dimension(50, 23));

		menuBar.add(btnNewButton_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Account Id");
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(Integer.toString(currentAccount));
		JLabel lblNewLabel_1 = new JLabel("Account Balance");
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Account Type");
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Account Fee");
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Account Open Date");
		contentPane.add(lblNewLabel_4);
		
		textField_4 = new JTextField("");
		textField_4.setEditable(false);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Account Last Changed");
		contentPane.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Account Branch id");
		contentPane.add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Account Cowners");
		contentPane.add(lblNewLabel_7);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		
	}
	 public static String[] SQLquery(int accountID) throws SQLException{ //parse the results of the user query by customer ID
	    	PreparedStatement stmt = null;
			stmt=con.prepareStatement("select * from Account where accnt_id= ?");
	    	stmt.setInt(1,accountID);
			ResultSet rs = stmt.executeQuery();
			String accnt_bal=null;
			String accnt_type =null;
			String accnt_fees =null;
			String accnt_open_date =null;
			String accnt_coown =null;
			String accnt_last_modified =null;
			String branch_id =null;
	        while(rs.next()){
	         accnt_bal = rs.getString("accnt_bal");
	         accnt_type = rs.getString("accnt_type");
	         accnt_fees = rs.getString("accnt_fees");
	         accnt_open_date = rs.getString("accnt_open_date");
	         accnt_coown = rs.getString("accnt_coown");
	         accnt_last_modified = rs.getString("accnt_last_modified");
	         branch_id = rs.getString("branch_id");
	        }
	        return new String[]{accnt_bal,accnt_type,accnt_fees,accnt_open_date,accnt_last_modified,branch_id,accnt_coown};
		}
	public void setQueryresult(String[] queryresult) {
		this.queryresult = queryresult;
	}
	public void setText(){ //update the application form
		textField.setText(Integer.toString(currentAccount));
		textField_1.setText(queryresult[0]);
		textField_2.setText(queryresult[1]);
		textField_3.setText(queryresult[2]);
		textField_4.setText(queryresult[3]);
		textField_5.setText(queryresult[4]);
		textField_6.setText(queryresult[5]);
		textField_7.setText(queryresult[6]);
	}
}

