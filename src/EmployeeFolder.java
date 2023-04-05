
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


public class EmployeeFolder extends javax.swing.JFrame 
{
    Connection con = null;
    Statement st = null;
    String eusrname;
    String empusrname;
    boolean already=false;
    
    public EmployeeFolder(String empusrname) 
    {
        this.eusrname=eusrname;
        this.empusrname=empusrname;
        ResultSet rs = null;
        
        initComponents();
        
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost/staffevaluation","root","");
            st = con.createStatement();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        
         try
         {     
            rs=con.createStatement().executeQuery(" select * from employee inner join user on "
                    + " employee.username = user.username where employee.username='"+empusrname+"'");
         
           while(rs.next())
           {
               txtusername.setText(rs.getString("user.username").trim());
               txtpassword.setText(rs.getString("password").trim());
               txtname.setText(rs.getString("name").trim());
               txtsurname.setText(rs.getString("surname").trim());
               txtemail.setText(rs.getString("email").trim());
               txtbio.setText(rs.getString("bio").trim());
               txtregdate.setText(rs.getString("reg_date").trim());
                 
               txtsistatikes.setText(rs.getString("sistatikes").trim());
               txtcertificates.setText(rs.getString("certificates").trim());
               txtawards.setText(rs.getString("awards").trim());
            }
           
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtawards = new javax.swing.JTextField();
        txtchange = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtsistatikes = new javax.swing.JTextField();
        txtcertificates = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtbio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtsurname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtregdate = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Awards");

        txtawards.setEditable(false);

        txtchange.setText("OK");
        txtchange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtchangeActionPerformed(evt);
            }
        });

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Εμφάνιση/Τροποποίηση Στοιχείων");

        jLabel4.setText("Employee");

        txtusername.setEditable(false);

        jLabel5.setText("Συστατικές");

        jLabel6.setText("Πιστοποιητικά");

        txtsistatikes.setEditable(false);

        txtcertificates.setEditable(false);

        jLabel2.setText("Βιογραφικό");

        jLabel7.setText("Password");

        jLabel8.setText("Όνομα");

        txtname.setEditable(false);

        jLabel9.setText("Πατρώνυμο");

        txtsurname.setEditable(false);

        jLabel10.setText("Ημερομηνία Εγγραφής");

        txtregdate.setEditable(false);

        jLabel11.setText("Email");

        txtemail.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtchange)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtsistatikes)
                    .addComponent(txtawards)
                    .addComponent(txtcertificates)
                    .addComponent(txtbio)
                    .addComponent(txtsurname)
                    .addComponent(txtregdate)
                    .addComponent(txtemail)
                    .addComponent(txtpassword)
                    .addComponent(txtname)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(50, 50, 50))
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtsurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtregdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtbio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtsistatikes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtcertificates, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtawards, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtchange)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtchangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtchangeActionPerformed
        theQuery("update employee set sistatikes='"+txtsistatikes.getText()+"',certificates='"+txtcertificates.getText()+"',awards='"+txtawards.getText()+"',bio='"+txtbio.getText()+"' where username = '"+txtusername.getText()+"'");
        theQuery("update user set name='"+txtname.getText()+"',surname='"+txtsurname.getText()+"',email='"+txtemail.getText()+"',password='"+txtpassword.getText()+"',reg_date='"+txtregdate.getText()+"' where username = '"+txtusername.getText()+"'");

        setVisible(false); 
        dispose();      
    }//GEN-LAST:event_txtchangeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        dispose(); 
    }//GEN-LAST:event_jButton1ActionPerformed

    public void theQuery(String query)
    {
       con = null;
       st = null;
      
      try
      {
          con = DriverManager.getConnection("jdbc:mysql://localhost/staffevaluation","root","");
          st = con.createStatement();
          st.executeUpdate(query);
          if (already==false)
          {
             JOptionPane.showMessageDialog(null,"Η τροποποίηση του φακέλου του Employee έγινε επιτυχώς");
             already=true;
          }
      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null,ex.getMessage());
      }
    }
    
    
   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ManagerElementsChange().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtawards;
    private javax.swing.JTextField txtbio;
    private javax.swing.JTextField txtcertificates;
    private javax.swing.JButton txtchange;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtpassword;
    private javax.swing.JTextField txtregdate;
    private javax.swing.JTextField txtsistatikes;
    private javax.swing.JTextField txtsurname;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
