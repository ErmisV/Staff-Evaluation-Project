
package project;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JobSalaryChange extends javax.swing.JFrame 
{
    Connection con = null;
    Statement st = null;
    String evusrname;
    int jobid;
   
    
    public JobSalaryChange(String evusrname)
    {
        jobid=Integer.parseInt(JOptionPane.showInputDialog(null,"Δώσε Job ID"));
        
        this.evusrname=evusrname;
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
            rs=con.createStatement().executeQuery("select * from job inner join evaluator on job.evaluator=evaluator.username inner join user on evaluator.username=user.username where evaluator.username= '"+evusrname+"'"+" and job.id ='"+jobid+"'");
         
           while(rs.next())
           { 
               txtid.setText(rs.getString("id").trim());
               txtstartdate.setText(rs.getString("start_date").trim());
               txtannouncedate.setText(rs.getString("announce_date").trim());
               txtsubmissiondate.setText(rs.getString("submission_date").trim());
               txtpos.setText(rs.getString("position").trim());
               txtedra.setText(rs.getString("edra").trim());
               txtevaluator.setText(rs.getString("evaluator").trim());
               txtsalary.setText(rs.getString("salary").trim());
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtOK = new javax.swing.JButton();
        txtCancel = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();
        txtstartdate = new javax.swing.JTextField();
        txtannouncedate = new javax.swing.JTextField();
        txtsubmissiondate = new javax.swing.JTextField();
        txtpos = new javax.swing.JTextField();
        txtedra = new javax.swing.JTextField();
        txtevaluator = new javax.swing.JTextField();
        txtsalary = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Job ID");

        jLabel2.setText("Start Date");

        jLabel3.setText("Announce Date");

        jLabel4.setText("Submission Date");

        jLabel5.setText("Position");

        jLabel6.setText("Position's City");

        jLabel7.setText("Evaluator");

        jLabel8.setText("Salary");

        txtOK.setText("OK");
        txtOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOKActionPerformed(evt);
            }
        });

        txtCancel.setText("Cancel");
        txtCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCancelActionPerformed(evt);
            }
        });

        txtid.setEditable(false);

        txtstartdate.setEditable(false);

        txtannouncedate.setEditable(false);

        txtsubmissiondate.setEditable(false);

        txtpos.setEditable(false);

        txtedra.setEditable(false);

        txtevaluator.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtstartdate)
                            .addComponent(txtid)
                            .addComponent(txtsubmissiondate)
                            .addComponent(txtannouncedate)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(16, 16, 16))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtOK)
                                .addGap(35, 35, 35)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCancel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtsalary, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                .addComponent(txtedra)
                                .addComponent(txtpos)
                                .addComponent(txtevaluator)))))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtstartdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtannouncedate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtsubmissiondate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtpos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtedra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtevaluator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtsalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOK)
                    .addComponent(txtCancel))
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOKActionPerformed
        theQuery("update job set salary='"+txtsalary.getText()+"' where id = '"+txtid.getText()+"'");
        setVisible(false);
        dispose(); 
    }//GEN-LAST:event_txtOKActionPerformed

    private void txtCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCancelActionPerformed
        setVisible(false); 
        dispose(); 
    }//GEN-LAST:event_txtCancelActionPerformed

    public void theQuery(String query)
   {
       con = null;
       st = null;
      
      try
      {
          con = DriverManager.getConnection("jdbc:mysql://localhost/staffevaluation","root","");
          st = con.createStatement();
          st.executeUpdate(query);
          JOptionPane.showMessageDialog(null,"Η τροποποίηση του μισθού έγινε επιτυχώς");
      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null,ex.getMessage());
      }
  }
    
    public static void main(String args[]) 
    {
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton txtCancel;
    private javax.swing.JButton txtOK;
    private javax.swing.JTextField txtannouncedate;
    private javax.swing.JTextField txtedra;
    private javax.swing.JTextField txtevaluator;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtpos;
    private javax.swing.JTextField txtsalary;
    private javax.swing.JTextField txtstartdate;
    private javax.swing.JTextField txtsubmissiondate;
    // End of variables declaration//GEN-END:variables
}
