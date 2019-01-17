import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class UpdateFrame extends  JFrame  
{
   Container c;
   JPanel p1,p2;
   JTextField txtId,txtName;
   JButton btnSave,btnBack;
   JLabel lblId,lblName;
   
   UpdateFrame()
   {
      c=getContentPane();
	  p1=new JPanel();
	  lblId=new JLabel("ID:");
	  lblName=new JLabel("Name");
	  
	  txtId=new JTextField(10);
	  txtName=new JTextField(10);
	  btnSave=new JButton("Save");
	  btnBack=new JButton("Back");
       p1.add(lblId);
	   p1.add(txtId);
	   p1.add(lblName);
	   p1.add(txtName);
	   
	   c.add(p1);
	  
	  
	  
	  
	  p2=new JPanel();
      btnSave=new JButton("Save");
	 // btnBack=new JButton("Back");
	  p2.add(btnSave);
	  p2.add(btnBack);
	  c.add("South",p2);
	 
      btnSave.addActionListener(new ActionListener()
      	{
      		public void actionPerformed(ActionEvent ae)
      		{
      			String i=txtId.getText();
      			String n=txtName.getText();
                
                  if(i.length()==0)
		         {
			   JOptionPane.showMessageDialog(new JDialog(),"Id is empty");
			   txtId.requestFocus();
			   return;
			  
		         }	
                  if(n.length()==0)
		       	{
			   JOptionPane.showMessageDialog(new JDialog(),"Name is empty");
			   txtName.requestFocus();
			   return;
		    	}
                
                DatabaseHandler d=new DatabaseHandler();
                d.updateEmployee(Integer.parseInt(i),n);
                txtId.setText("");
			    txtName.setText("");
			    txtId.requestFocus();


      		}
      	});




	  btnBack.addActionListener(new ActionListener()
	  { public void actionPerformed(ActionEvent ae)
	    {  MainFrame m=new MainFrame();
		   dispose();
		
		}
	  });
   
    setTitle("UPDATE Employee");
	setSize(500,150);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
   
   }
  
}