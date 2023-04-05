
package project;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;

public class Login extends JFrame
{
    JLabel JL_username,JL_password;
    JTextField JT_password,JT_username;
    JButton btn_insert;
    public String orisma;
    int choice;
    
    public Login()
    {
        super("Login ");
        
        choice=Integer.parseInt(JOptionPane.showInputDialog("Δώστε 1 για είσοδο Manager\nΔώστε 2 για είσοδο Evaluator\nΔώστε 3 για είσοδο Employee\nΔώστε 4 για είσοδο Admin\n"));
       
        JL_username = new JLabel("Username:");
        JL_password = new JLabel("Password:");

        JL_username.setBounds(20, 50, 100, 20);
        JL_password.setBounds(20, 20, 100, 20);

        JT_username = new JTextField(20);
        JT_password = new JTextField(20);

        JT_username.setBounds(130, 50, 150, 20);
        JT_password.setBounds(130,20,150,20);

        btn_insert = new JButton("Login");
        btn_insert.setBounds(300, 50, 80, 20);

        setLayout(null);

        add(JL_username);
        add(JL_password);

        add(JT_username);
        add(JT_password);

        add(btn_insert);

        btn_insert.addActionListener(new  ActionListener() 
        {
             public void actionPerformed(ActionEvent e) 
             {
                try
                {
                    if (choice==1 || choice==2 || choice==3 || choice==4)
                    {
                         System.out.println("choice"+choice);
               
                        theQuery("select * from user where password ='"+JT_password.getText()+"' and username ='"+JT_username.getText()+"'");
                    }
                  }
                catch(Exception ex){}
             }
         });

         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
         setLocationRelativeTo(null);
         setSize(500,200);
    }
 
    String getorisma()
    {
        return orisma;
    }
    
  public void theQuery(String query)
  {
      Connection con = null;
      Statement st = null;
      
      try
      {
          con = DriverManager.getConnection("jdbc:mysql://localhost/staffevaluation","root","");
          st = con.createStatement();
          
          ResultSet result=st.executeQuery(query);
         
           if (result.next())
           {
                JOptionPane.showMessageDialog(null,"Η είσοδος έγινε με επιτυχία");
                orisma=JT_username.getText();
                
                if (choice==1)
                {
                     int choice2=Integer.parseInt(JOptionPane.showInputDialog("1. Λειτουργίες Manager\n"));
                 
                     if (choice2==1)
                     {
                         new ManagerForm(orisma).setVisible(true);
                         setVisible(false); 
                         dispose();      
                     }
                }
                
                if (choice==2)
                {
                    int choice2=Integer.parseInt(JOptionPane.showInputDialog("1. Λειτουργίες Evaluator\n"));
                    
                    if (choice2==1)
                    {
                         new EvaluatorForm(orisma).setVisible(true);
                         setVisible(false); 
                         dispose();      
                     }
                }
                
                if (choice==3) 
                {
                    int choice2=Integer.parseInt(JOptionPane.showInputDialog("1. Λειτουργίες Employee\n"));
                    
                    if (choice2==1)
                    {
                         new EmployeeForm(orisma).setVisible(true);
                         setVisible(false); 
                         dispose();      
                     }
                }
                
                if (choice==4) 
                {
                    int choice2=Integer.parseInt(JOptionPane.showInputDialog("1. Λειτουργίες Admin\n"));
                    
                    if (choice2==1)
                    {
                         new AdminForm(orisma).setVisible(true);
                         setVisible(false); 
                         dispose();      
                     }
                }
               
           }
           else
               JOptionPane.showMessageDialog(null, "Wrong username/password");
      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null,ex.getMessage());
      }
  }
 
   public static void main(String[] args)
   {
        new Login();
   }
}
