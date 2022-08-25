import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SearchMethod {
	
	JLabel sName,sSalary,nametag,salarytag;
	 String name;
	 String salary;
	public void searchUI() {
	
		JFrame js = new JFrame("Search Frame");
		JLabel slb = new JLabel("Enter Id: ");
		JTextField stx = new JTextField();
		JButton sbt = new JButton("search");
		
		
		slb.setBounds(70,40,100,40);
		stx.setBounds(130,40,200,40);
		sbt.setBounds(170,100,100,40);
	
		js.add(sbt);
		js.add(slb);
		js.add(stx);

		
		js.setSize(500,400);
		js.setLayout(null);
		js.setVisible(true);
	
		
		sbt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try
				{	
					int srcID = Integer.parseInt( stx.getText());
					Connection con = Employee_SQL.getConnection();
		        	Statement st=con.createStatement();
		        	ResultSet sout = st.executeQuery("select * from employee_project.table where Id = "+srcID);
		        	
		        	if(sout.next()) {
		        	 name = sout.getString("Name");
		        	 salary = sout.getString("Salary");
		        	 
		        	    sName = new JLabel(name);
			    		sSalary = new JLabel(salary);
			    		sName.setBounds(100,190,200,50);
			    		sSalary.setBounds(100,220,200,50);
			    		nametag = new JLabel("Emp Name: ");
			    		salarytag = new JLabel("Emp Salary: ");
			    		nametag.setBounds(20,190,200,50);
			    		salarytag.setBounds(20,220,200,50);
			    		
			    		js.add(nametag);
			    		js.add(salarytag);
			    		js.add(sName);
			    		js.add(sSalary);
			    		

		        	}
		        	else
		        	{
		        		JOptionPane.showMessageDialog(js,"No Record Found", "alert", JOptionPane.ERROR_MESSAGE );
		        	}
		        	con.close();
		        	
		        	
				}
				catch(Exception e1)
				{
				e1.printStackTrace();
				}
			
			}
			
		});
		
	}
}
