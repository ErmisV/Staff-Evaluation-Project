
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

public class CompanyElementsChange extends javax.swing.JFrame 
{
    Connection con = null;
    Statement st = null;
    String musrname;
   
    public CompanyElementsChange(String musrname) 
    {
        this.musrname=musrname;
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
            rs=con.createStatement().executeQuery("select * from company inner join manager on manager.firm=company.AFM where managerusername= '"+musrname+"'");
        
           while(rs.next())
           {
               txtAFM.setText(rs.getString("AFM").trim());
               txtDOY.setText(rs.getString("DOY").trim());
               txtname.setText(rs.getString("name").trim());
               txttelephone.setText(rs.getString("phone").trim());
               txtstreet.setText(rs.getString("street").trim());
               txtnum.setText(rs.getString("num").trim());
               txtcity.setText(rs.getString("city").trim());
               txtcountry.setText(rs.getString("country").trim());
          
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
        txtAFM = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDOY = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txttelephone = new javax.swing.JTextField();
        txtstreet = new javax.swing.JTextField();
        txtnum = new javax.swing.JTextField();
        txtcity = new javax.swing.JTextField();
        txtcountry = new javax.swing.JTextField();
        btnOK = new javax.swing.JButton();
        txtcancel = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ΑΦΜ");

        txtAFM.setEditable(false);

        jLabel2.setText("ΔΟΥ");

        txtDOY.setEditable(false);

        jLabel3.setText("Όνομα");

        txtname.setEditable(false);

        jLabel4.setText("Τηλέφωνο");

        jLabel5.setText("Οδός");

        jLabel6.setText("Αριθμός");

        jLabel7.setText("Πόλη");

        jLabel8.setText("Χώρα");

        txtstreet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstreetActionPerformed(evt);
            }
        });

        txtcountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcountryActionPerformed(evt);
            }
        });

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        txtcancel.setText("Cancel");
        txtcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcancelActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Change Managers Firm Details");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtcity)
                                    .addComponent(txtstreet)
                                    .addComponent(txtAFM)
                                    .addComponent(txtDOY)
                                    .addComponent(txtname)
                                    .addComponent(txttelephone)
                                    .addComponent(txtnum)
                                    .addComponent(txtcountry, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(btnOK)
                        .addGap(18, 18, 18)
                        .addComponent(txtcancel)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtAFM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtDOY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txttelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtstreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtcity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtcountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOK)
                    .addComponent(txtcancel)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtstreetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstreetActionPerformed
        
    }//GEN-LAST:event_txtstreetActionPerformed

    private void txtcountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcountryActionPerformed
        
    }//GEN-LAST:event_txtcountryActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        theQuery("update company set phone='"+txttelephone.getText()+"',street='"+txtstreet.getText()+"',num='"+txtnum.getText()+"',city='"+txtcity.getText()+"',country='"+txtcountry.getText()+ "' where AFM = '"+txtAFM.getText()+"'");
        setVisible(false); 
        dispose(); 
    }//GEN-LAST:event_btnOKActionPerformed

    private void txtcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcancelActionPerformed
        setVisible(false); 
        dispose(); 
    }//GEN-LAST:event_txtcancelActionPerformed

   public void theQuery(String query)
   {
       con = null;
       st = null;
      
      try
      {
          con = DriverManager.getConnection("jdbc:mysql://localhost/staffevaluation","root","");
          st = con.createStatement();
          st.executeUpdate(query);
          JOptionPane.showMessageDialog(null,"Η τροποποίηση των στοιχείων της εταιρείας έγινε επιτυχώς");
      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null,ex.getMessage());
      }
  }
    
      
    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtAFM;
    private javax.swing.JTextField txtDOY;
    private javax.swing.JButton txtcancel;
    private javax.swing.JTextField txtcity;
    private javax.swing.JTextField txtcountry;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnum;
    private javax.swing.JTextField txtstreet;
    private javax.swing.JTextField txttelephone;
    // End of variables declaration//GEN-END:variables

}
