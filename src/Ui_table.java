import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ui_table {
	static void tableUi()
	{
		String[] columnNames = {"Id","Name","Salary"};
	    JTable table;
	    JFrame frame1;
	    
	    frame1 = new JFrame("Database Search Result");
  
        frame1.setLayout(new BorderLayout());
	    DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(columnNames);
        table = new JTable();

        table.setModel(model);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        table.setFillsViewportHeight(true);
        
        JScrollPane scroll = new JScrollPane(table);
        
        scroll.setHorizontalScrollBarPolicy(
        
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        scroll.setVerticalScrollBarPolicy(

                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        int Id ;       
        String Name = "";
        String Salary = "" ;
        
        try {
        	Connection con = Employee_SQL.getConnection();
        	PreparedStatement ps = con.prepareStatement("Select * from employee_project.table");
        	 ResultSet rs = ps.executeQuery();
        	
        	 int i = 0;
        	 while (rs.next()) 
             {
 
             	Id = rs.getInt(1);
                 
             	Name = rs.getString(2);

                 Salary = rs.getString(3);

            System.out.println(""+Id+"\t"+Name+"\t"+Salary+"");

                 model.addRow(new Object[]{Id,Name,Salary});

                 i++;
             }
                 if (i < 1) {

                     JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);

            }

                 if (i == 1) {

                     System.out.println(i + " Record Found");

                 } else {

                     System.out.println(i + " Records Found");

                 }
                 con.close();
             }
        catch(Exception e1)
        {
        	 JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
        
        frame1.add(scroll);

        frame1.setVisible(true);

        frame1.setSize(800,500);              
	}
}