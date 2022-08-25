import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DeleteMethod {
	JFrame deleteframe ;
	JLabel Dlb; 
	JTextField Dtx;
	
	public  void deleteUI() {

	    deleteframe = new JFrame("Delete Employee Data");
		
		Dlb = new JLabel("Enter ID:");
		Dtx = new JTextField();
		JButton Dbt = new JButton("Remove");
		Dlb.setBounds(20,40,100,40);
		Dtx.setBounds(80,40,200,35);
		Dbt.setBounds(120,90,120,40);
		
		deleteframe.add(Dlb);
		deleteframe.add(Dtx);
		deleteframe.add(Dbt);
		
		deleteframe.setSize(500,300);
		deleteframe.setLayout(null);
		deleteframe.setVisible(true); 
	
		
		
		Dbt.addActionListener(new ActionListener(){
		

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			 try {
					
					int delID = Integer.parseInt( Dtx.getText());
		        	Connection con = Employee_SQL.getConnection();
		        	Statement st=con.createStatement();
		        	int delCheck  = st.executeUpdate( "delete from employee_project.table where Id = "+delID);
		        	con.close();
			 
			 if(delCheck > 0) {
				  JOptionPane.showMessageDialog(deleteframe, "Employee Data Deleted..." );
			 }
			 else
			 {
				  JOptionPane.showMessageDialog(deleteframe,"Employee Data Not Deleted...", "alert", JOptionPane.ERROR_MESSAGE );	 
			 }
                
			 }
			 catch(Exception e1)
			 {
				 e1.printStackTrace(); 
			 }
			
		}
		});	
	}
}
