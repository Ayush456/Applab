import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.sql.*;

class DeleteFrame extends JFrame
{
	Container c;
	JLabel lblId;
	JTextField txtId;
	JButton btnSave,btnBack;
    JPanel p1,p2;
    DeleteFrame()
    {
    	c=getContentPane();
    	p1=new JPanel();
    	lblId=new JLabel("ID:");
    	txtId=new JTextField(10);
        btnSave=new JButton("Save");
        btnBack=new JButton("Back");

        p1.add(lblId);
        p1.add(txtId);
        c.add(p1);

        p2=new JPanel();
        p2.add(btnSave);
        p2.add(btnBack);
        c.add("South",p2);

   btnSave.addActionListener(new ActionListener()
   	{
   		public void actionPerformed(ActionEvent ae)
   		{
   			String i=txtId.getText();
             if(i.length()==0)
		   {
			   JOptionPane.showMessageDialog(new JDialog(),"Id is empty");
			   txtId.requestFocus();
			   return;
			  
		   }

            DatabaseHandler d=new DatabaseHandler();
            d.deleteEmployee(Integer.parseInt(i));
            txtId.setText("");
            txtId.requestFocus();

   		}
   	});



   	btnBack.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			MainFrame a=new MainFrame();
			dispose();
		}
	 });
	




    setTitle("Delete Employee Element");
	setSize(500,150);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);

    }

}