import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class cus_query extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private final JTextField textField_1;
	private final JTextField textField_2;
	private final JTextField textField_3;
	private final JTextField textField_4;
	private final JTextField textField_5;
	private final JTextField textField_6;
	private final JTextField textField_7;
	private final JTextField textField_8;
	private String[] queryresult={""};
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cus_query frame = new cus_query();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    public static String[] SQLquery(int cusID) throws SQLException{ //parse the results of the user query by customer ID
    	PreparedStatement stmt = null;
    	Connection con=SQLdriver.getConnection();
		stmt=con.prepareStatement("select * from Customer where Cus_id= ?");
    	stmt.setInt(1,cusID);
		ResultSet rs = stmt.executeQuery();
		String cus_zip=null;
		String cus_state=null;
		String cus_addr=null;
		String cus_lname=null;
		String cus_fname=null;
		String accnt_creation_date=null;
		String last_update=null;
		String credit_rating = null;
        while(rs.next()){
	     cus_zip = rs.getString("Cus_zip");
		 cus_state = rs.getString("cus_state");
		 cus_addr = rs.getString("cus_addr");
		 cus_lname = rs.getString("Cus_lname");
		 cus_fname = rs.getString("cus_fname");
		 accnt_creation_date = rs.getString("accnt_creation_date");
		 last_update = rs.getString("last_update");
		 credit_rating = rs.getString("Credit_rating");
      
        }
        return new String[]{cus_zip,cus_state,cus_addr,cus_lname,cus_fname,accnt_creation_date,last_update,credit_rating};
	}
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public cus_query() throws SQLException {
		ActionListener getCustomerQuery=new ActionListener(){
			int cusID;
            public void actionPerformed(ActionEvent ae)
            {
                 String userInput=textField.getText();      
                 cusID=Integer.parseInt(userInput); 
             //    System.out.println(cusID);
					try {
						setQueryresult(SQLquery(cusID));
						setText();

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
            }
	 };
		
		setTitle("Customer Query Form");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 500, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Number");
		lblNewLabel.setBounds(12, 12, 118, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(12, 30, 460, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(12, 54, 86, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(getCustomerQuery);
		
		lblNewLabel_1 = new JLabel("Credit Rating");
		lblNewLabel_1.setBounds(12, 100, 85, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Last Update");
		lblNewLabel_2.setBounds(12, 137, 118, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Account Creation Date");
		lblNewLabel_3.setBounds(12, 177, 153, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Customer Last Name");
		lblNewLabel_4.setBounds(12, 219, 153, 14);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Customer First Name");
		lblNewLabel_5.setBounds(12, 254, 153, 14);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Address");
		lblNewLabel_6.setBounds(12, 279, 143, 14);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Zip Code");
		lblNewLabel_7.setBounds(12, 304, 99, 14);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("State");
		lblNewLabel_8.setBounds(12, 329, 99, 14);
		contentPane.add(lblNewLabel_8);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(144, 304, 170, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
				
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(144, 335, 170, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(144, 279, 170, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(144, 251, 170, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(144, 216, 170, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(144, 174, 170, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		textField_6.validate();
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setBounds(144, 134, 170, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setBounds(144, 97, 170, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
	}
	protected void setText() {
		textField_1.setText(queryresult[0]);
		textField_2.setText(queryresult[1]);
		textField_3.setText(queryresult[2]);
		textField_4.setText(queryresult[3]);
		textField_5.setText(queryresult[4]);
		textField_6.setText(queryresult[5]);
		textField_7.setText(queryresult[6]);
		textField_8.setText(queryresult[7]);
		
	}
	public String[] getQueryresult() {
		return queryresult;
	}
	public void setQueryresult(String[] queryresult) {
		this.queryresult = queryresult;
	}

}
