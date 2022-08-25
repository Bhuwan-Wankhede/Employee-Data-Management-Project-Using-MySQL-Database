import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateMethod {
	int srcID;

	public void updateUI()
	{
		JFrame j2 = new JFrame("Update Employee Details");
		
		j2.setSize(500,500);
		j2.setLayout(null);
		j2.setVisible(true);
	
		JLabel ulb1 = new JLabel("Enter Emp ID:");
		JTextField utx1 = new JTextField();
		JButton ubt1 =new JButton("Search");
		ubt1.setBounds(150,90,120,40);
		utx1.setBounds(120,40,190,40);
		ulb1.setBounds(20,40,120,30);
		
		JLabel ulb2 = new JLabel("Name:");
		JLabel ulb3 = new JLabel("Salary:");
		JTextField utx2 = new JTextField();
		JTextField utx3 = new JTextField();
		
		ulb2.setBounds(20,180,120,40);
		utx2.setBounds(120,180,190,40);
		
		utx3.setBounds(120,230,190,40);
		ulb3.setBounds(20,230,120,40);
		
		JButton ubt2 =new JButton("Update");
		ubt2.setBounds(150,290,120,30);
		
		j2.add(ubt2);
		j2.add(ulb1);
		j2.add(utx1);
		j2.add(ulb2);
		j2.add(utx2);
		j2.add(ulb3);
		j2.add(utx3);
		j2.add(ubt1);
		
		
		ubt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				// TODO Auto-generated method stub
				try
				{	
				    srcID = Integer.parseInt(utx1.getText());
					Connection con = Employee_SQL.getConnection();
		        	Statement st=con.createStatement();
		        	ResultSet sout = st.executeQuery("select * from employee_project.table where Id = "+srcID);
		    
		        	
		        	if(sout.next())
		        	{
		        	 String name = sout.getString("Name");
		        	 String salary = sout.getString("Salary");
		        	 utx2.setText(name);
		        	 utx3.setText(salary);
		        	 }
		        	else {
			        	   JOptionPane.showMessageDialog(j2,"No Record Found", "alert", JOptionPane.ERROR_MESSAGE );

		        	}

		        	con.close();
				}
				catch(Exception e1)
				{
				e1.printStackTrace();
				}
				
				
				
				
				
				ubt2.addActionListener(new ActionListener()
						{

							@Override
							public void actionPerformed(ActionEvent e) {
								try {
									String uptname = utx2.getText();
									String uptsal= utx3.getText();
									
									
									Connection con = Employee_SQL.getConnection();
									Statement ps=con.createStatement();
								    int check = ps.executeUpdate("update employee_project.table set Name = '"+uptname+"', Salary = '"+uptsal+"' where Id ="+srcID);
						            con.close();
								    
						           if (check >= 0) {
						        	   JOptionPane.showMessageDialog(j2, "Record Updated Successfully..." );
						           }
						           else
						           {
						        	   JOptionPane.showMessageDialog(j2,"Record Not Updated", "alert", JOptionPane.ERROR_MESSAGE );
						           }
								}
						        	
								
								catch(Exception e1) {
									e1.printStackTrace();
									
								}
								
							}
					
						});
				
				
				
			}
			
		}
		);
	
	}
}