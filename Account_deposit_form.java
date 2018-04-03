import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Account_deposit_form extends JFrame {

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
    private int currentDeposit;
	private String[] queryresult;
	private JTextField textField_5;
    private int firstDeposit=12901;
    private int lastDeposit=12911;
	static Connection con=SQLdriver.getConnection();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Account_deposit_form frame = new Account_deposit_form();
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
	public Account_deposit_form() {
		ActionListener FirstDeposit=new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
            	 currentDeposit=firstDeposit;
                	try {
						setQueryresult(SQLquery(currentDeposit));
						setText();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	
				
            }	
	 };
	 ActionListener PreviousDeposit=new ActionListener(){
         public void actionPerformed(ActionEvent ae)
         {
        	 if(currentDeposit==firstDeposit){
        		 currentDeposit=firstDeposit;
        	 }
        	 else{
        	 currentDeposit=currentDeposit-1;
        	 }
             try {
				setQueryresult(SQLquery(currentDeposit));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				setText();

                
				
         }	
	 };
	 ActionListener NextDeposit=new ActionListener(){
         public void actionPerformed(ActionEvent ae)
         {
        	 if(currentDeposit<lastDeposit){
        		 currentDeposit=currentDeposit+1;
        	 }
        	 else{
        		 currentDeposit=lastDeposit;
        	 }
              try {
				setQueryresult(SQLquery(currentDeposit));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				setText();

				
         }

		
	 };
	 ActionListener LastDeposit=new ActionListener(){

		public void actionPerformed(ActionEvent ae)
         {
			currentDeposit=lastDeposit;
        	try {
				setQueryresult(SQLquery(currentDeposit));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setText();

         }
	 };
		setTitle("Account Deposit Form");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 555, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Account ID");
		lblNewLabel.setBounds(10, 11, 71, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Deposit ID");
		lblNewLabel_1.setBounds(10, 56, 71, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Deposit Amount");
		lblNewLabel_2.setBounds(10, 99, 90, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Deposit Last Update");
		lblNewLabel_3.setBounds(10, 144, 129, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblDepositDate = new JLabel("Deposit Date");
		lblDepositDate.setBounds(10, 184, 114, 14);
		contentPane.add(lblDepositDate);
		
		JLabel lblBranchID=new JLabel("Branch ID");
		lblBranchID.setBounds(10, 223, 114, 14);
		contentPane.add(lblBranchID);
    
		//create the textfields which output the results
		
		textField = new JTextField();
		textField.setBounds(162, 8, 114, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		textField_1 = new JTextField();
		textField_1.setBounds(162, 50, 114, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
		
		textField_2 = new JTextField();
		textField_2.setBounds(162, 96, 114, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setEditable(false);
		
		textField_3 = new JTextField();
		textField_3.setBounds(162, 141, 114, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setEditable(false);
		
		textField_4 = new JTextField();
		textField_4.setBounds(162, 181, 114, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		textField_4.setEditable(false);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(162, 220, 111, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton firstDeposit = new JButton("First Deposit");//create the button objects here
		firstDeposit.setBounds(10, 351, 114, 23);
		contentPane.add(firstDeposit);
		firstDeposit.addActionListener(FirstDeposit);//this allows the user to actually access the database
		
		JButton nextDeposit = new JButton("Next Deposit");
		nextDeposit.setBounds(134, 351, 110, 23);
		contentPane.add(nextDeposit);
		nextDeposit.addActionListener(NextDeposit);

		
		JButton previousDeposit = new JButton("Previous Deposit");
		previousDeposit.setBounds(254, 351, 141, 23);
		contentPane.add(previousDeposit);
		previousDeposit.addActionListener(PreviousDeposit);
		
		JButton lastDeposit = new JButton("Last Deposit");
		lastDeposit.setBounds(405, 351, 129, 23);
		contentPane.add(lastDeposit);
		lastDeposit.addActionListener(LastDeposit);

        
	}
	protected String[] SQLquery(int currentDeposit) throws SQLException {
		PreparedStatement stmt = null; //create statement
		stmt=con.prepareStatement("select * from Account natural join deposit where deposit_id= ?");
    	stmt.setInt(1,currentDeposit); //add variable
		ResultSet rs = stmt.executeQuery(); //create the result set
		String accnt_id=null;
		String depositAmt =null;
		String depositLastUpdate =null;
		String depositDate =null;
		String branch_id =null;
        while(rs.next()){
         accnt_id = rs.getString("accnt_id"); //this is what is actually fed into the application
         depositAmt = rs.getString("accnt_type");
         depositLastUpdate = rs.getString("deposit_last_update");
         depositDate = rs.getString("accnt_open_date");
         branch_id = rs.getString("branch_id");
        }
        
        return new String[]{accnt_id,depositAmt,depositLastUpdate,depositDate,branch_id};
	}

	
   
	public void setQueryresult(String[] queryresult) {
		this.queryresult = queryresult;
	}
	 public void setText(){ //this function updates all of the text fields in the update form.
	    	textField.setText(Integer.toString(currentDeposit));
			textField_1.setText(queryresult[0]);
			textField_2.setText(queryresult[1]);
			textField_3.setText(queryresult[2]);
			textField_4.setText(queryresult[3]);
			textField_5.setText(queryresult[4]);
	    }
}
