import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class MainFrame extends JFrame
{
Container c;
JButton btnAdd,btnView,btnUpdate,btnDelete;

MainFrame()
{
	c=getContentPane();
	c.setLayout(new FlowLayout());
	
	
	btnAdd=new JButton("Add");
	btnView=new JButton("View");
	btnUpdate=new JButton("Update");
	btnDelete=new JButton("Delete");
	
	c.add(btnAdd);
	c.add(btnView);
	c.add(btnUpdate);
	c.add(btnDelete);
	btnAdd.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			AddFrame a=new AddFrame();
			dispose();
		}
	});
	
	btnView.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			ViewFrame a=new ViewFrame();
			dispose();
		}
	});
	
	btnUpdate.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			UpdateFrame u=new UpdateFrame();
			dispose();
			
		}
	});

	btnDelete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				DeleteFrame d=new DeleteFrame();
				dispose();

			}
		});

	setTitle("Employee Management System");
	setSize(500,150);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	
}	
	
	public static void main(String args[])
	{
		MainFrame m=new MainFrame();
		
	}
	

}

class DatabaseHandler
{
	static Connection con;
	
	static void getCon()
	{
		 try
		 {
			 DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
             con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");

		 }
		 catch(SQLException e)
		 {
			 JOptionPane.showMessageDialog(new JDialog(),"issue"+e);
		 }
		 
	}
	
	public void addEmployee(int id,String name)
	{
		getCon();
		try{
			  String sql="insert into employee values(?,?)";
			  
			  PreparedStatement pst=con.prepareStatement(sql);
			  pst.setInt(1,id);
			  pst.setString(2,name);
			  int r=pst.executeUpdate();
			  JOptionPane.showMessageDialog(new JDialog(),r+" records inserted");
		  }
		  catch(SQLException e)
		  {
			  JOptionPane.showMessageDialog(new JDialog(),"issue"+e);
		  }
	
	}
	
	public String viewEmployee()
	{
		getCon();
		StringBuffer sb=new StringBuffer();
		
		try{
			String sql="select * from employee";
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next())
			{
				int i=rs.getInt(1);
				String n=rs.getString(2);
				sb.append("Id:"+i+"Name:"+n+"\n");
			}
		   }
		   catch(SQLException e)
		   {
			JOptionPane.showMessageDialog(new JDialog(),"issue"+e);   
		    
		   }
		   return sb.toString();
	}

	public void updateEmployee(int i,String n)
	{  

        getCon();

	    try{ 
                   String sql="update employee set name = '"+n+"' where id = "+i;
                   Statement stm=con.createStatement();
                   int r1=stm.executeUpdate(sql);	
	    	
                  JOptionPane.showMessageDialog(new JDialog(),r1+" rows updated");	           
		
	       }
	     catch(SQLException y)
	     {
	     	JOptionPane.showMessageDialog(new JDialog(),"Error occurred :"+y);
	     }  
	}

	public void deleteEmployee(int id)
	{
          try
          {
               getCon();
               String s;

             String sql="delete from employee where id="+id;
			 Statement stm=con.createStatement();
           // ResultSet rs=stm.executeQuery(sql);
             int r1=stm.executeUpdate(sql);
             JOptionPane.showMessageDialog(new JDialog(),r1+" row has been deleted");

          }
          catch(SQLException e)
          {
          	JOptionPane.showMessageDialog(new JDialog(),"Issue :"+e);
          }

 

	}
	
}
