
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
 class Employee  {
	
	public static void myUi() 
	{	
		JFrame j1,j2;
		JTextField t1,t2,t3;
		JLabel l1,l2,l3,lb,lname,lcreatedby;
		JButton b1,b2,b3,b4,b5;
		JTable tb;
		Scanner sc = new Scanner(System.in);

		j1 = new JFrame("Employee Data Management");
		
        lb = new JLabel("");
        lb.setBounds(50,350,400,120);
		
		l1 =new JLabel("Employee Id : ");
		l1.setFont(new Font("Calibri", Font.BOLD, 18));
		l1.setBounds(60,80,150,40);
		
		t1 = new JTextField();
		t1.setBounds(250,80,250 ,40);
	
		
		l2 =new JLabel("Employee Name : ");
		l2.setFont(new Font("Calibri", Font.BOLD, 18));
		l2.setBounds(60,150,150,40);
	
		
		t2=new JTextField();
		t2.setBounds(250, 150, 250, 40);

		
		l3 =new JLabel("Employee Salary : ");
		l3.setFont(new Font("Calibri", Font.BOLD, 18));
		l3.setBounds(60,220,150,40);
		
		
		lcreatedby =new JLabel("Developer : ");
		lcreatedby.setFont(new Font("Calibri", Font.BOLD, 14));
		lcreatedby.setBounds(370,630,150,40);
	
		lname = new JLabel("Bhuwan Wankhede");
		lname.setFont(new Font("Calibri", Font.BOLD, 14));
		lname.setBounds(450,630,150,40);
		
		
		t3 = new JTextField();
		t3.setBounds(250,220,250 ,40);
	
		
		b1 = new JButton("Add data");
		b1.setBounds(30,350,160,50);
	
	
		
		b2 = new JButton("Show Data");
		b2.setBounds(205,350,160,50);
	
	
		
		b3 = new JButton("Search Data");
		b3.setBounds(380,350,160,50);
	
		
		
		b4 = new JButton("Update Data");
		b4.setBounds(120,450,160,50);
		
		
		b5=new JButton("Delete Data");
		b5.setBounds(295,450,160,50);
		
		j1.setDefaultCloseOperation(j1.EXIT_ON_CLOSE);
		
		Object[] rows = {};
		
		String[] columns = {"ID","Name","Salary"};
		j1.add(l1);
		j1.add(t1);
		j1.add(l2);
		j1.add(t2);
		j1.add(l3);
		j1.add(t3);	
		j1.add(b1);
		j1.add(b2);
		j1.add(b3);
		j1.add(b4);
		j1.add(b5);
		j1.add(lcreatedby);
		j1.add(lname);
	
	j1.setSize(600,700);
	j1.setLayout(null);
	j1.setVisible(true);
	
    b1.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try{
				int x1 = Integer.parseInt(t1.getText());
				String x2 = t2.getText();
				String x3 = t3.getText();
				int b = Employee_SQL.insertData(x1, x2, x3);
				if(b>0){
					JOptionPane.showMessageDialog(j1,"Data Inserted");
				}
			}catch(ClassNotFoundException | SQLException e1){
					e1.printStackTrace();
				}
			}
	});
	
	b2.addActionListener(new ActionListener(){ //Show
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
		try {
			Ui_table.tableUi();
			String data = Employee_SQL.show();
			lb.setText(data);			
		}
		catch(ClassNotFoundException | SQLException e1)
		{
		 e1.printStackTrace();
		}
		}
	});
	
	b3.addActionListener(new ActionListener(){ 

		@Override
		public void actionPerformed(ActionEvent del) {
			SearchMethod searchMethod = new SearchMethod();
			searchMethod.searchUI();
			}
		});
	
	b4.addActionListener(new ActionListener(){ 

		@Override
		public void actionPerformed(ActionEvent del) {
			UpdateMethod updateMethod = new UpdateMethod();
			updateMethod.updateUI();
			}
		});
	
	b5.addActionListener( new ActionListener(){ // Delete

		@Override
		public void actionPerformed(ActionEvent del)
		    {
			DeleteMethod deleteMethod = new DeleteMethod();
			deleteMethod.deleteUI();
			}
		});			
		}

	}
 
    public class Test {
	public static void main(String[] args) {
		Employee.myUi();
	}
}
